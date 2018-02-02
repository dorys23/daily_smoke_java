package pageobjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.*;

public class BasePage {

    WebElement getUniqueElement(WebDriver driver, By locator) {
        return ExpectedConditions.visibilityOfElementLocated(locator).apply(driver);
    }

    void selectFromDropdownMenu(WebElement element, String option){
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(option);
    }

    protected void takeScreenshot(WebDriver driver, String filename) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(URLS.screenshotsLocation + filename + ".png"));
    }
}
