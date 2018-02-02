package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.How.CSS;

public class ProductFamilyPage {
    @FindBy(how = CSS, using = ".productSpecifications__group:nth-child(2) ul li:nth-child(3)")
    private WebElement ml5Option;
    @FindBy(how = CSS, using = ".productSpecifications__group:nth-child(3) ul li:nth-child(2)")
    private WebElement individuallyWrappedClearPLastic;
    @FindBy(how = CSS, using = "span[class='tablesaw-cell-content'] > a")
    private WebElement productNumber;

    public ProductFamilyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectSpecifications() throws InterruptedException {
        ml5Option.click();
        Thread.sleep(5000);
        individuallyWrappedClearPLastic.click();
        Thread.sleep(5000);
    }

    public void returnListOfElements(WebDriver driver){
       List<WebElement> elements = driver.findElements(By.cssSelector("button[class='addToCart js-enable-btn']"));
       if (elements.size() ==1)
           System.out.println("\n Only the " + productNumber + " is present in the Products table");
       else
           System.out.println("\n The list has: " + elements.size() + " number of products");
    }
}
