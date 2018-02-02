import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AuthenticatedB2BUserTest extends BasePage{
    private WebDriver driver;
    private StoreAndRegion storeAndRegion;
    private B2BLoginPage b2BLoginPage;
    private B2BFamilyPage b2BFamilyPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;


    @BeforeClass
    public void beforeClass(){
        Browser browser = new Browser();
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        storeAndRegion = new StoreAndRegion(driver);
        b2BLoginPage = new B2BLoginPage(driver);
        b2BFamilyPage = new B2BFamilyPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void b2bAuthenticated() throws InterruptedException, IOException {
        driver.get(URLS.b2bLoginUrl);
        Thread.sleep(5000);
        takeScreenshot(driver, "27_on_login_page");

        storeAndRegion.setSelectBusinessStore(driver);
        takeScreenshot(driver, "28_selecting_business_store");
        storeAndRegion.setUnitedStatesLinkB2B(driver);
        takeScreenshot(driver, "29_selecting_usa_region");

        b2BLoginPage.b2bLogin(URLS.b2bUsername, URLS.b2bPassword);
        Thread.sleep(5000);
        System.out.println("\n The B2B user successfully authenticated");
        takeScreenshot(driver, "30_b2b_authenticated");

        b2BFamilyPage.addB2BProduct1ToCart(driver);
        takeScreenshot(driver, "31_first_product_added");
        System.out.println("\n Product was successfully added to cart");
        b2BFamilyPage.addB2BProduct2ToCart(driver);
        takeScreenshot(driver, "32_second_product_added");
        System.out.println("\n Product was successfully added to cart");
        b2BFamilyPage.addB2BProduct3ToCart(driver);
        takeScreenshot(driver, "33_third_product_added");
        System.out.println("\n Product was successfully added to cart");

        productPage.clickOnCheckoutInCartButton();
        productPage.clickOnCheckoutInCartButton();
        takeScreenshot(driver, "34_proceeding_to_cart");
        System.out.println("\n B2B user successfully reached the Checkout section");

        checkoutPage.b2bCheckoutFlow("123");
        takeScreenshot(driver, "35_checking_out");
        System.out.println("\n B2B user successfully got through the checkout flow");
        System.out.println("\n B2C user placed the order and successfully transitioned to the order confirmation page");
        takeScreenshot(driver, "36_on_order_confirmation_page");
    }

}
