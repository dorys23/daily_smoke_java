package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.CSS;

public class B2CLoginPage extends BasePage{
    @FindBy(how = CSS, using = "input[name='username']")
    private WebElement usernameInputField;
    @FindBy(how = CSS, using = "input[name='password']")
    private WebElement passwordInputField;
    @FindBy(how = CSS, using = "input[id='okta-signin-submit']")
    private WebElement loginButton;

    private WebElement getUsernameInputField() { return usernameInputField; }

    private WebElement getPasswordInputField() { return passwordInputField; }

    private WebElement getLoginButton() { return loginButton; }


    public void b2CLogin(String username, String password) throws InterruptedException {
        getUsernameInputField().sendKeys(username);
        getPasswordInputField().sendKeys(password);
        getLoginButton().click();
    }

}
