package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.ID;

public class ProductPage {
    @FindBy(how = CSS, using = "div.name.product-details--name > span")
    private WebElement productID;
    @FindBy(how = ID, using = "addToCartButton")
    private WebElement addToCartButton;
    @FindBy(how = CSS, using = "#addToCartLayer > div.flex-container > a.btn.btn-link.js-mini-cart-close-button")
    private WebElement continueShoppingButton;
    @FindBy(how = CSS, using = "a.btn.btn-primary.add-to-cart-button")
    private WebElement checkOutButton;
    @FindBy(how = CSS, using = "div.col-sm-12.col-md-6.cart-actions--print.cart__actions > button.btn.btn-primary.btn-block.btn--continue-checkout.js-continue-checkout-button")
    private WebElement checkoutInCartButton;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddToCartButton(){
        addToCartButton.click(); }

    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click(); }

    public void clickOnCheckoutButton(){
        checkOutButton.click(); }

    public void clickOnCheckoutInCartButton(){
        checkoutInCartButton.click(); }

    public String getProductId(){
        return productID.getText();
    }
}
