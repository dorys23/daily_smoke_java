package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.XPATH;

public class QuickOrderPage extends BasePage{
    @FindBy(how = XPATH, using = "/html/body/main/header/div[3]/div[2]/nav/div[4]/a[1]")
    private WebElement quickOrderButton;
    @FindBy(how = CSS, using = "li:nth-child(2) > div.item-sku-input.js-sku-container > input.js-sku-input-field.form-control")
    private WebElement product1Field;
    @FindBy(how = CSS, using = "li:nth-child(3) > div.item-sku-input.js-sku-container > input.js-sku-input-field.form-control")
    private WebElement product2Field;
    @FindBy(how = CSS, using = "li:nth-child(4) > div.item-sku-input.js-sku-container > input.js-sku-input-field.form-control")
    private WebElement product3Field;
    @FindBy(how = CSS, using = "#js-add-to-cart-quick-order-btn-bottom")
    private WebElement addToCartButton;
    @FindBy(how = CSS, using = ".btn.btn-primary.add-to-cart-button")
    private WebElement checkoutButton;


    private WebElement getQuickOrderButton() { return quickOrderButton; }

    private WebElement getProduct1Field() { return product1Field; }

    private WebElement getProduct2Field() { return product2Field; }

    private WebElement getProduct3Field() { return product3Field; }

    private WebElement getAddToCartButton() { return addToCartButton; }

    private WebElement getCheckoutButton() { return checkoutButton; }

    public void placeAnOrderInTheQuickOrderPage(String product1, String product2, String product3) throws InterruptedException {
        getProduct1Field().sendKeys(product1);
        Thread.sleep(5000);
        getProduct2Field().sendKeys(product2);
        Thread.sleep(5000);
        getProduct3Field().sendKeys(product3);
        getProduct3Field().sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        getAddToCartButton().click();
        getCheckoutButton().click();
    }
}
