package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.CSS;

public class B2BFamilyPage {

    @FindBy(how = CSS, using = ".productSpecifications__group-buttons button.addToCart")
    private WebElement addToCartButton;
    @FindBy(how = CSS, using = "#addToCartLayer > div.flex-container > a.btn.btn-link.js-mini-cart-close-button")
    private WebElement continueShoppingButton;
    @FindBy(how = CSS, using = "#addToCartLayer > div.flex-container > a.btn.btn-primary.add-to-cart-button")
    private WebElement viewCartButton;


    private WebElement getAddToCartButton() { return addToCartButton; }

    private WebElement getContinueShoppingButton() { return continueShoppingButton; }

    private WebElement getViewCartButton() { return viewCartButton; }

    public void addB2BProduct1ToCart(WebDriver driver) throws InterruptedException {
        driver.get(URLS.b2bProduct1Url);
        Thread.sleep(5000);
        getAddToCartButton().click();
        Thread.sleep(5000);
        getContinueShoppingButton().click();
    }

    public void addB2BProduct2ToCart(WebDriver driver) throws InterruptedException {
        driver.get(URLS.b2bProduct2Url);
        Thread.sleep(5000);
        getAddToCartButton().click();
        Thread.sleep(5000);
        getContinueShoppingButton().click();
    }

    public void addB2BProduct3ToCart(WebDriver driver) throws InterruptedException {
        driver.get(URLS.b2bProduct3Url);
        Thread.sleep(5000);
        getAddToCartButton().click();
        Thread.sleep(5000);
        getViewCartButton().click();
    }
}
