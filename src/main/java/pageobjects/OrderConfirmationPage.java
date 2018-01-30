package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;

import static org.openqa.selenium.support.How.CSS;

public class OrderConfirmationPage extends BasePage{
    @FindBy(how = CSS, using = ".checkout-success__body > p:first-of-type b")
    private WebElement orderID;

    public String getOrderID() {
        return orderID.getText();
    }

    public void guestSaveOrderInformation() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(URLS.localArtifactGuest, "UTF-8");
        writer.println("Order Number is " + orderID.getText() + ", and was placed at " + DateFormat.getInstance().format(new Date(0)));
        writer.println("\n");
        writer.close();
    }

    public void b2CSaveOrderInformation() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(URLS.localArtifactB2C, "UTF-8");
        writer.println("Order Number is " + orderID.getText() + ", and was placed at " + DateFormat.getInstance().format(new Date(0)));
        writer.println("\n");
        writer.close();
    }

    public void b2BSaveOrderInformation() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(URLS.localArtifactB2B, "UTF-8");
        writer.println("Order Number is " + orderID.getText() + ", and was placed at " + DateFormat.getInstance().format(new Date(0)));
        writer.println("\n");
        writer.close();
    }
}
