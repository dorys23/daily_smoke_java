package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;

public class B2BLoginPage {
    @FindBy(how = CSS, using = "input[name='username']")
    private WebElement usernameInputField;
    @FindBy(how = CSS, using = "input[name='password']")
    private WebElement passwordInputField;
    @FindBy(how = CSS, using = "input[id='okta-signin-submit']")
    private WebElement loginButton;


    public B2BLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void b2bLogin(String username, String password) {
        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        loginButton.click();
    }
}
