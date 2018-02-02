import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AuthenticatedB2CUserTest extends BasePage{
    private WebDriver driver;
    private B2CLoginPage b2CLoginPage;
    private StoreAndRegion storeAndRegion;
    private QuickOrderPage quickOrderPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;

    @BeforeClass
    public void beforeClass(){
        Browser browser = new Browser();
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        b2CLoginPage = new B2CLoginPage(driver);
        storeAndRegion = new StoreAndRegion(driver);
        quickOrderPage = new QuickOrderPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void b2cAuthenticated() throws InterruptedException, IOException {
        driver.get(URLS.b2cLoginUrl);
        takeScreenshot(driver, "17_navigate_to_login_page");
        Thread.sleep(5000);

        storeAndRegion.setSelectConsumerStore(driver);
        takeScreenshot(driver, "18_selecting_consumer_store");
        storeAndRegion.setUnitedStatesLinkB2C(driver);
        takeScreenshot(driver, "19_selecting_usa_region.png");
        Thread.sleep(5000);
        b2CLoginPage.b2CLogin(URLS.b2cUsername, URLS.b2cPassword);
        Thread.sleep(5000);
        System.out.println("\n The B2C user successfully authenticated");
        takeScreenshot(driver, "20_authenticating_b2c_user");

        driver.get(URLS.quickOrderUrl);
        takeScreenshot(driver, "21_navigating_to_quick_order");

        quickOrderPage.placeAnOrderInTheQuickOrderPage("6875-SB", "AP-8-200", "1000-100");
        takeScreenshot(driver, "22_place_an_order_in_the_quick_order_page");
        System.out.println("\n B2C user successfully added the products in the cart and reached the Cart section");

        productPage.clickOnCheckoutInCartButton();
        takeScreenshot(driver, "23_proceeding_to_checkout");
        System.out.println("\n B2C user successfully reached the Checkout section");

        checkoutPage.b2cCheckoutFlow();
        takeScreenshot(driver, "24_on_checkout");
        checkoutPage.addCardDetails("Visa", "4111111111111111", "12", "2019", "116");
        takeScreenshot(driver, "25_provided_card_details");
        System.out.println("\n B2C user successfully got through the checkout flow");
        System.out.println("\n B2C user placed the order and successfully transitioned to the order confirmation page");
        takeScreenshot(driver, "26_on_order_confirmation_page");
    }
}
