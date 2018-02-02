package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StoreAndRegion extends BasePage {
    private By selectChannelOverlay = By.id("#cboxLoadedContent");
    private By selectConsumerStoreButton = By.cssSelector("button[id='chooseB2CButton']");
    private By selectBusinessStoreButton = By.cssSelector("button[id='chooseB2BButton']");
    private By unitedStatesLinkB2C = By.cssSelector(".region:nth-child(1) a[href *='/b2c/US/en']");
    private By unitedStatesLinkB2B = By.cssSelector(".region:nth-child(1) a[href *='/b2b/US/en']");

    public StoreAndRegion(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setSelectConsumerStore(WebDriver driver) {
        getUniqueElement(driver, selectConsumerStoreButton).click();
    }

    public void setSelectBusinessStore(WebDriver driver) {
        getUniqueElement(driver, selectBusinessStoreButton).click();
    }

    public void setUnitedStatesLinkB2C(WebDriver driver) {
        getUniqueElement(driver, unitedStatesLinkB2C).click();
    }

    public void setUnitedStatesLinkB2B(WebDriver driver) {
        getUniqueElement(driver, unitedStatesLinkB2B).click();
    }

}
