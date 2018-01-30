package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public String getProductID() { return productID.getText(); }

    private WebElement getAddToCartButton() { return addToCartButton; }

    private WebElement getContinueShoppingButton() { return continueShoppingButton; }

    private WebElement getCheckOutButton() { return checkOutButton; }

    private WebElement getCheckoutInCartButton() { return checkoutInCartButton; }

    public void clickOnAddToCartButton(){
        getAddToCartButton().click(); }

    public void clickOnContinueShoppingButton(){
        getContinueShoppingButton().click(); }

    public void clickOnCheckoutButton(){
        getCheckOutButton().click(); }

    public void clickOnCheckoutInCartButton(){
        getCheckoutInCartButton().click(); }


}
