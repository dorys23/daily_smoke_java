package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public QuickOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void placeAnOrderInTheQuickOrderPage(String product1, String product2, String product3) throws InterruptedException {
        product1Field.sendKeys(product1);
        Thread.sleep(5000);
        product2Field.sendKeys(product2);
        Thread.sleep(5000);
        product3Field.sendKeys(product3);
        product3Field.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        addToCartButton.click();
        checkoutButton.click();
    }
}
