package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;

public class B2CLoginPage extends BasePage {
    @FindBy(how = CSS, using = "input[name='username']")
    private WebElement usernameInputField;
    @FindBy(how = CSS, using = "input[name='password']")
    private WebElement passwordInputField;
    @FindBy(how = CSS, using = "input[id='okta-signin-submit']")
    private WebElement loginButton;

    public B2CLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void b2CLogin(String username, String password) throws InterruptedException {
        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        loginButton.click();
    }

}
