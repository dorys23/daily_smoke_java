package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CLASS_NAME;
import static org.openqa.selenium.support.How.CSS;

public class ResourceLibraryPage {
    @FindBy(how = CSS, using = "span.app")
    private WebElement resourceLibraryBreadcrumb;
    @FindBy(how = CSS, using = "input[name='catalogNumber']")
    private WebElement productNumberInput;
    @FindBy(how = CSS, using = "input[name='lotId']")
    private WebElement lotNumberInput;
    @FindBy(how = CLASS_NAME, using = "certificate-lookup-form-error")
    private WebElement lookupFormErrorMessage;
    @FindBy(how = CSS, using = "button[value='Download Certificate']")
    private WebElement downloadCertificateButton;

    public ResourceLibraryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void downloadCertificate(String productNumber, String lotNumber) throws InterruptedException {
        productNumberInput.sendKeys(productNumber);
        lotNumberInput.sendKeys(lotNumber);
        Thread.sleep(5000);
        downloadCertificateButton.click();
    }

    public void lookupFormErrorMessagePresent(){
        assert lookupFormErrorMessage.isDisplayed();
    }

    public void resourceLibraryPageBreadcrumPresent(){
        assert resourceLibraryBreadcrumb.isDisplayed();
    }

    public void downloadCertificateButtonPresent(){
        assert downloadCertificateButton.isDisplayed();
    }
}
