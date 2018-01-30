import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.ProductFamilyPage;
import pageobjects.StoreAndRegion;
import pageobjects.URLS;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FilteringOnFamilyPageTest extends BasePage{
    private WebDriver driver;
    private Browser browser = new Browser();
    private StoreAndRegion storeAndRegion = new StoreAndRegion();
    private ProductFamilyPage productFamilyPage = new ProductFamilyPage();

    @BeforeClass
    public void beforeClass(){
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        storeAndRegion = PageFactory.initElements(driver, StoreAndRegion.class);
        productFamilyPage = PageFactory.initElements(driver, ProductFamilyPage.class);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void selectingPFPVariants() throws IOException, InterruptedException {
        driver.get(URLS.productFamilyPageLink);
        System.out.println("\n The user reached the family product page");
        takeScreenshot(driver, "37_on_family_product_page");

        storeAndRegion.setSelectBusinessStore(driver);
        storeAndRegion.setUnitedsStatesLinkB2B(driver);

        productFamilyPage.selectSpecifications();
        takeScreenshot(driver, "38_specifications_selected");
        System.out.println("\n The user reached the family product page");
        System.out.println("\n The user successfully selected the product specifications");

        productFamilyPage.returnListOfElements(driver);
        takeScreenshot(driver, "39_only_one_product_is_present_in_the_list");
    }
}
