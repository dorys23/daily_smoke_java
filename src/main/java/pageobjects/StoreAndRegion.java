package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.XPATH;

public class StoreAndRegion extends BasePage {
    private By selectChannelOverlay = By.id("#cboxLoadedContent");
    private By selectConsumerStoreButton = By.cssSelector("button[id='chooseB2CButton']");
    private By selectBusinessStoreButton = By.cssSelector("button[id='chooseB2BButton']");
    private By unitedsStatesLinkB2C = By.cssSelector(".region:nth-child(1) a[href *='/b2c/US/en']");
    private By unitedsStatesLinkB2B = By.cssSelector(".region:nth-child(1) a[href *='/b2b/US/en']");

    public void setSelectConsumerStore(WebDriver driver){
        getUniqueElement(driver,selectConsumerStoreButton).click();
    }

    public void setSelectBusinessStore(WebDriver driver){
        getUniqueElement(driver,selectBusinessStoreButton).click();
    }

    public void setUnitedsStatesLinkB2C(WebDriver driver){
        getUniqueElement(driver,unitedsStatesLinkB2C).click();
    }

    public void setUnitedsStatesLinkB2B(WebDriver driver){
        getUniqueElement(driver,unitedsStatesLinkB2B).click();
    }

}
