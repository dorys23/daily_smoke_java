package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addNewAddress(String country, String title, String firstName, String lastName, String organization, String address, String town, String state, String postalCode) throws InterruptedException {
//        Payment Type section
        paymentTypeSubmitButton.click();
//        Shipping address section
        addNewAddressButton.click();
//        Add New Address section
        Thread.sleep(60);
        selectFromDropdownMenu(countryDropdownMenu, country);
        selectFromDropdownMenu(titleDropdownMenu, title);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        organizationInput.sendKeys(organization);
        addressLine1Input.sendKeys(address);
        townOrCityInput.sendKeys(town);
        selectFromDropdownMenu(stateDropdownMenu, state);
        zipPostalCodeInput.sendKeys(postalCode);
        addAddressButton.click();
        shippingDeliveryButton.click();
        deliveryMethodButton.click();
        Thread.sleep(5000);
        nextPaymentButton.click();
    }

    public void addCardDetails(String cardType, String cardNumber, String expirationMonth, String expirationYear, String securityCode) {
        selectFromDropdownMenu(cardTypeDropdown, cardType);
        cardNumberInput.sendKeys(cardNumber);
        selectFromDropdownMenu(cardExpirationMonthDropdown, expirationMonth);
        selectFromDropdownMenu(cardExpirationYearDropdown, expirationYear);
        securityCodeInput.sendKeys(securityCode);
        termsCheckBox.click();
        placeOrderButton.click();
    }

    public void b2cCheckoutFlow() throws InterruptedException {
        paymentTypeSubmitButton.click();
        shippingDeliveryButton.click();
        deliveryMethodButton.click();
        Thread.sleep(5000);
        nextPaymentButton.click();
    }

    public void b2bCheckoutFlow(String paymentNumber) throws InterruptedException{
        purchaseOrderInput.sendKeys(paymentNumber);
        paymentTypeSubmitButton.click();
        deliveryMethodButton.click();
        Thread.sleep(5000);
        termsCheckBox.click();
        placeOrderButton.click();
    }
}
