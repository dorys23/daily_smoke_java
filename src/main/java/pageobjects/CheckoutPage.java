package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.ID;

public class CheckoutPage extends BasePage {
    @FindBy(how = ID, using = "paymentTypeSubmit")
    private WebElement paymentTypeSubmitButton;
    @FindBy(how = CSS, using = "button[data-toggle='#addressForm']")
    private WebElement addNewAddressButton;
    @FindBy(how = CSS, using = "select[name='countryIso']")
    private WebElement countryDropdownMenu;
    @FindBy(how = CSS, using = "select[name='titleCode']")
    private WebElement titleDropdownMenu;
    @FindBy(how = CSS, using = "input[name='firstName']")
    private WebElement firstNameInput;
    @FindBy(how = CSS, using = "input[name='lastName']")
    private WebElement lastNameInput;
    @FindBy(how = CSS, using = "input[name='company']")
    private WebElement organizationInput;
    @FindBy(how = CSS, using = "input[name='line1']")
    private WebElement addressLine1Input;
    @FindBy(how = CSS, using = "input[name='townCity']")
    private WebElement townOrCityInput;
    @FindBy(how = CSS, using = "select[name='regionIso']")
    private WebElement stateDropdownMenu;
    @FindBy(how = CSS, using = "input[name='postcode']")
    private WebElement zipPostalCodeInput;
    @FindBy(how = CSS, using = "button[id='addressSubmit']")
    private WebElement addAddressButton;
    @FindBy(how = ID, using = "shippingDeliverySubmit")
    private WebElement shippingDeliveryButton;

    @FindBy(how = CSS, using = "input[name='purchaseOrderNumber']]")
    private WebElement purchaseOrderInput;

    @FindBy(how = ID, using = "deliveryMethodSubmit")
    private WebElement deliveryMethodButton;

    @FindBy(how = CSS, using = ".checkout-next")
    private WebElement nextPaymentButton;

    @FindBy(how = CSS, using = "select[name='card_cardType']")
    private WebElement cardTypeDropdown;
    @FindBy(how = CSS, using = "input[name='card_accountNumber-formatted']")
    private WebElement cardNumberInput;
    @FindBy(how = CSS, using = "select[name='card_expirationMonth']")
    private WebElement cardExpirationMonthDropdown;
    @FindBy(how = CSS, using = "select[name='card_expirationYear']")
    private WebElement cardExpirationYearDropdown;
    @FindBy(how = CSS, using = "input[name='card_cvNumber']")
    private WebElement securityCodeInput;
    @FindBy(how = CSS, using = "input[name='termsCheck']")
    private WebElement termsCheckBox;
    @FindBy(how = CSS, using = "button[id='placeOrder']")
    private WebElement placeOrderButton;

    private WebElement getPaymentTypeSubmitButton() { return paymentTypeSubmitButton; }

    private WebElement getAddNewAddressButton() { return addNewAddressButton; }

    private WebElement getFirstNameInput() { return firstNameInput; }

    private WebElement getLastNameInput() { return lastNameInput; }

    private WebElement getOrganizationInput() { return organizationInput; }

    private WebElement getAddressLine1Input() { return addressLine1Input; }

    private WebElement getTownOrCityInput() { return townOrCityInput; }

    private WebElement getZipPostalCodeInput() { return zipPostalCodeInput; }

    private WebElement getAddAddressButton() { return addAddressButton; }

    private WebElement getShippingDeliveryButton() { return shippingDeliveryButton; }

    private WebElement getPurchaseOrderInput() { return purchaseOrderInput; }

    private WebElement getDeliveryMethodButton() { return deliveryMethodButton; }

    private WebElement getNextPaymentButton() { return nextPaymentButton; }

    private WebElement getCardNumberInput() { return cardNumberInput; }

    private WebElement getSecurityCodeInput() { return securityCodeInput; }

    private WebElement getTermsCheckBox() { return termsCheckBox; }

    private WebElement getPlaceOrderButton() { return placeOrderButton; }

    public void addNewAddress(String country, String title, String firstName, String lastName, String organization, String address, String town, String state, String postalCode) throws InterruptedException {
//        Payment Type section
        getPaymentTypeSubmitButton().click();
//        Shipping address section
        getAddNewAddressButton().click();
//        Add New Address section
        Thread.sleep(60);
        selectFromDropdownMenu(countryDropdownMenu, country);
        selectFromDropdownMenu(titleDropdownMenu, title);
        getFirstNameInput().sendKeys(firstName);
        getLastNameInput().sendKeys(lastName);
        getOrganizationInput().sendKeys(organization);
        getAddressLine1Input().sendKeys(address);
        getTownOrCityInput().sendKeys(town);
        selectFromDropdownMenu(stateDropdownMenu, state);
        getZipPostalCodeInput().sendKeys(postalCode);
        getAddAddressButton().click();
        getShippingDeliveryButton().click();
        getDeliveryMethodButton().click();
        Thread.sleep(5000);
        getNextPaymentButton().click();
    }

    public void addCardDetails(String cardType, String cardNumber, String expirationMonth, String expirationYear, String securityCode) {
        selectFromDropdownMenu(cardTypeDropdown, cardType);
        getCardNumberInput().sendKeys(cardNumber);
        selectFromDropdownMenu(cardExpirationMonthDropdown, expirationMonth);
        selectFromDropdownMenu(cardExpirationYearDropdown, expirationYear);
        getSecurityCodeInput().sendKeys(securityCode);
        getTermsCheckBox().click();
        getPlaceOrderButton().click();
    }

    public void b2cCheckoutFlow() throws InterruptedException {
        getPaymentTypeSubmitButton().click();
        getShippingDeliveryButton().click();
        getDeliveryMethodButton().click();
        Thread.sleep(5000);
        getNextPaymentButton().click();
    }

    public void b2bCheckoutFlow(String paymentNumber) throws InterruptedException{
        getPurchaseOrderInput().sendKeys(paymentNumber);
        getPaymentTypeSubmitButton().click();
        getDeliveryMethodButton().click();
        Thread.sleep(5000);
        getTermsCheckBox().click();
        getPlaceOrderButton().click();
    }
}
