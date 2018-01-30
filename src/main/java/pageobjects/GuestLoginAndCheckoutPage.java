package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.CSS;

public class GuestLoginAndCheckoutPage {
    @FindBy(how = CSS, using = "input[name=\"email\"]")
    private WebElement emailAddressInput;
    @FindBy(how = CSS, using = ".confirmGuestEmail.form-control")
    private WebElement confirmEmailAddressInput;
    @FindBy(how = CSS, using = ".btn.btn-default.btn-block.guestCheckoutBtn")
    private WebElement checkoutGuestButton;

    public WebElement getEmailAddressInput() { return emailAddressInput; }

    public WebElement getConfirmEmailAddressInput() { return confirmEmailAddressInput; }

    public WebElement getCheckoutGuestButton() { return checkoutGuestButton; }

    public void checkoutAsGuest(String email, String confirmationEmail){
        getEmailAddressInput().sendKeys(email);
        getConfirmEmailAddressInput().click();
        getConfirmEmailAddressInput().sendKeys(confirmationEmail);
        getCheckoutGuestButton().click();
    }
}
