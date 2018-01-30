package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.CSS;

public class HeaderSection {
    @FindBy(how = CSS, using = "body > main > header > div.header > div > div.header__utilityNavWrap > div > div.header__utilityNav-iconWrap.header__utilityNav-iconWrap--commerce > a:nth-child(2) > span")
    private WebElement productCount;

    public String getProductCount() {
        return productCount.getText();
    }
}
