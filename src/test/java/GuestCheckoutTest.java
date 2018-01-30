import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class GuestCheckoutTest extends BasePage {
    private WebDriver driver;
    private Browser browser = new Browser();
    private ProductPage productPage = new ProductPage();
    private HeaderSection header = new HeaderSection();
    private StoreAndRegion store = new StoreAndRegion();
    private GuestLoginAndCheckoutPage guestLoginAndCheckoutPage = new GuestLoginAndCheckoutPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();


    @BeforeClass
    public void beforeClass() {
        //initialize the Chrome browser here
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //initialize page object class
        productPage = PageFactory.initElements(driver, ProductPage.class);
        header = PageFactory.initElements(driver, HeaderSection.class);
        store = PageFactory.initElements(driver, StoreAndRegion.class);
        guestLoginAndCheckoutPage = PageFactory.initElements(driver, GuestLoginAndCheckoutPage.class);
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        orderConfirmationPage = PageFactory.initElements(driver, OrderConfirmationPage.class);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void guestCheckOut() throws InterruptedException, IOException {
        driver.get(URLS.product1Url);
        Thread.sleep(5000);
        takeScreenshot(driver, "01_product_page_1");
        store.setSelectConsumerStore(driver);
        takeScreenshot(driver, "02_choose_consumer_store");
        store.setUnitedsStatesLinkB2C(driver);
        takeScreenshot(driver, "03_choose_united_states_region");
        assertEquals("Product Number 3470", productPage.getProductID());
        productPage.clickOnAddToCartButton();
        takeScreenshot(driver, "04_adding_first_product_to_cart");
        productPage.clickOnContinueShoppingButton();
        takeScreenshot(driver, "05_clicking_on_continue_overlay");
        System.out.println("\n " + productPage.getProductID() + " was successfully added to cart");

        driver.get(URLS.product2Url);
        Thread.sleep(5000);
        takeScreenshot(driver, "06_product_page_2.png");
        assertEquals("Product Number 356243", productPage.getProductID());
        assertEquals("(1)", header.getProductCount());
        productPage.clickOnAddToCartButton();
        takeScreenshot(driver, "07_adding_second_product_to_cart");
        productPage.clickOnContinueShoppingButton();
        takeScreenshot(driver, "08_clicking_on_continue_overlay");
        System.out.println("\n " + productPage.getProductID() + " was successfully added to cart");

        driver.get(URLS.product3Url);
        Thread.sleep(5000);
        takeScreenshot(driver, "09_product_page_3");
        assertEquals("Product Number 430518", productPage.getProductID());
        assertEquals("(2)", header.getProductCount());
        productPage.clickOnAddToCartButton();
        takeScreenshot(driver, "10_adding_third_product_to_cart");
        System.out.println("\n Product " + productPage.getProductID() + " was successfully added to cart");
        productPage.clickOnCheckoutButton();
        takeScreenshot(driver, "11_proceeding_to_cart");
        assertEquals("(3)", header.getProductCount());
        System.out.println("\n Guest successfully transitioned to the cart page");
        productPage.clickOnCheckoutInCartButton();
        takeScreenshot(driver, "12_proceeding_to_checkout");

        guestLoginAndCheckoutPage.checkoutAsGuest(URLS.guestEmail, URLS.guestConfirmationEmail);
        System.out.println("\n Guest successfully authenticated");
        takeScreenshot(driver, "13_guest_authenticated");
        System.out.println("\n Guest successfully transitioned to the checkout page");

        checkoutPage.addNewAddress("United States", "Mr.", "Tester", "Test", "Siteworx", "Plopilor 63", "Portland", "Oregon", "54321");
        takeScreenshot(driver, "14_provided_new_address");
        checkoutPage.addCardDetails("Visa", "4111111111111111", "12", "2019", "234");
        takeScreenshot(driver, "15_provided_credit_card_details");
        System.out.println("\n Guest successfully got through the checkout flow");
        System.out.println("\n" + orderConfirmationPage.getOrderID());
        System.out.println("\n Guest placed the order and successfully transitioned to the order confirmation page");
        takeScreenshot(driver, "16_on_order_confirmation_page.png");

    }
}
