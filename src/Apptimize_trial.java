

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by HaroldKendall on 5/17/2017
 * Page Object Model of Apptimize.com
 *  - contains methods to fetch various elements in the page
 * .
 */
public class Apptimize_trial {

    private static WebElement element;
    private static String url = "http://apptimize.com";

    public static void navigateToSignUp(WebDriver driver) throws InterruptedException{
        driver.get(url);
        Thread.sleep(2000);
        element = driver.findElement(By.cssSelector("li>a[class='btn navbar__btn-register']"));
        element.click();
        Thread.sleep(2000);
    }

    public static WebElement fetchText(WebDriver driver) {
        element = driver.findElement(By.cssSelector(".home-hero__content__title"));
        return element;
    }

    public static WebElement fetchFirstNameField(WebDriver driver) {
        element = driver.findElement(By.cssSelector("div>input#fname"));
        return element;
    }

    public static WebElement fetchLastNameField(WebDriver driver) {
        element = driver.findElement(By.cssSelector("div>input#lname"));
        return element;
    }

    public static WebElement fetchEmailNameField(WebDriver driver) {
        element = driver.findElement(By.cssSelector("div>input#email"));
        return element;
    }

    public static WebElement fetchCompanyNameField(WebDriver driver) {
        element = driver.findElement(By.cssSelector("div>input#company"));
        return element;
    }

    public static WebElement fetchPasswordField(WebDriver driver) {
        element = driver.findElement(By.cssSelector("div>input#password"));
        return element;
    }
    public static WebElement fetchRadioYes(WebDriver driver) {
        element = driver.findElement(By.cssSelector("div>input[name='purchased'][value='Yes']"));
        return element;
    }
    public static WebElement fetchRadioNo(WebDriver driver) {
        element = driver.findElement(By.cssSelector("div>input[name='purchased'][value='No']"));
        return element;
    }
    public static WebElement fetchCheckboxEula(WebDriver driver) {
        element = driver.findElement(By.cssSelector("div>input#eula"));
        return element;
    }

    public static WebElement fetchSignUpBtn(WebDriver driver) {
        element = driver.findElement(By.cssSelector("div>button#submit"));
        return element;
    }

    public static WebElement fetchVerificationHeader(WebDriver driver) {
        element = driver.findElement(By.cssSelector("div>form>h1"));
        return element;
    }


}
