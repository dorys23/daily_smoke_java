package pageobjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.*;
import java.sql.Time;

public class BasePage {

    public WebElement getUniqueElement(WebDriver driver, By locator) {
        return ExpectedConditions.visibilityOfElementLocated(locator).apply(driver);
    }

    public void selectFromDropdownMenu(WebElement element, String option){
        Select countryDropdown = new Select(element);
        countryDropdown.selectByVisibleText(option);
    }

    public void takeScreenshot(WebDriver driver, String filename) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(URLS.screenshotsLocation + filename + ".png"));
    }
}
