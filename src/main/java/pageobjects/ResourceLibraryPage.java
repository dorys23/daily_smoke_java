package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    private WebElement getResourceLibraryBreadcrumb() { return resourceLibraryBreadcrumb; }

    private WebElement getProductNumberInput() { return productNumberInput; }

    private WebElement getLotNumberInput() { return lotNumberInput; }

    private WebElement getLookupFormErrorMessage() { return lookupFormErrorMessage; }

    private WebElement getDownloadCertificateButton() { return downloadCertificateButton; }

    public void downloadCertificate(String productNumber, String lotNumber) throws InterruptedException {
        getProductNumberInput().sendKeys(productNumber);
        getLotNumberInput().sendKeys(lotNumber);
        Thread.sleep(5000);
        getDownloadCertificateButton().click();
    }

    public void lookupFormErrorMessagePresent(){
        assert getLookupFormErrorMessage().isDisplayed();
    }

    public void resourceLibraryPageBreadcrumPresent(){
        assert getResourceLibraryBreadcrumb().isDisplayed();
    }

    public void downloadCertificateButtonPresent(){
        assert getDownloadCertificateButton().isDisplayed();
    }
}
