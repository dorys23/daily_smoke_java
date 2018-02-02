package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;

public class GuestLoginAndCheckoutPage {
    @FindBy(how = CSS, using = "input[name=\"email\"]")
    private WebElement emailAddressInput;
    @FindBy(how = CSS, using = ".confirmGuestEmail.form-control")
    private WebElement confirmEmailAddressInput;
    @FindBy(how = CSS, using = ".btn.btn-default.btn-block.guestCheckoutBtn")
    private WebElement checkoutGuestButton;

    public GuestLoginAndCheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkoutAsGuest(String email, String confirmationEmail){
        emailAddressInput.sendKeys(email);
        confirmEmailAddressInput.click();
        confirmEmailAddressInput.sendKeys(confirmationEmail);
        checkoutGuestButton.click();
    }
}
