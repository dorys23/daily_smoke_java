import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.ResourceLibraryPage;
import pageobjects.URLS;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DownloadCertificateTest extends BasePage{
    private WebDriver driver;
    private ResourceLibraryPage resourceLibraryPage;

    @BeforeClass
    public void beforeClass(){
        Browser browser = new Browser();
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        resourceLibraryPage = new ResourceLibraryPage(driver);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test(priority = 1)
    public void downloadCertificateWithValidData() throws InterruptedException, IOException {
        driver.get(URLS.resourceLibraryUrl);
        Thread.sleep(5000);
        resourceLibraryPage.resourceLibraryPageBreadcrumPresent();
        System.out.println("\n Resource Library Page fully loaded");
        takeScreenshot(driver, "40_resource_library_page_loaded");

        resourceLibraryPage.downloadCertificate(URLS.certificateProductNumber, URLS.certificateLotNumber);
        System.out.println("\n Downloading Certificate");
        takeScreenshot(driver, "41_downloading_certificate");

        resourceLibraryPage.downloadCertificateButtonPresent();
    }

    @Test(priority = 2)
    public void downloadCertificateWithInvalidData() throws InterruptedException, IOException {
        driver.get(URLS.resourceLibraryUrl);
        Thread.sleep(5000);
        resourceLibraryPage.resourceLibraryPageBreadcrumPresent();
        System.out.println("\n Resource Library Page fully loaded");
        takeScreenshot(driver, "42_resource_library_page_loaded");

        resourceLibraryPage.downloadCertificate("645687", "785785");
        takeScreenshot(driver, "43_provided_incorrect_certificate_numbers");

        resourceLibraryPage.lookupFormErrorMessagePresent();
    }
}
