package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;

public class HeaderSection {
    @FindBy(how = CSS, using = "body > main > header > div.header > div > div.header__utilityNavWrap > div > div.header__utilityNav-iconWrap.header__utilityNav-iconWrap--commerce > a:nth-child(2) > span")
    private WebElement productCount;

    public HeaderSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getProductCount() {
        return productCount.getText();
    }
}
