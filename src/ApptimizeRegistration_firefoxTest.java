/**
 * Created by HaroldKendall on 5/17/2017.
 *
 * Chrome automated test to register for Apptimize trial
 * uses a 5 digit random alphanumeric to ensure unique emails per run
 */

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApptimizeRegistration_firefoxTest {
    private WebDriver driver;
    private String email = "hco_apptimizetest+%s@gmail.com";


    @Before
    public void setUp() throws Exception {
        BrowserHandler br = new BrowserHandler();
        driver = br.setupFirefox();
        String uid = RandomStringUtils.randomAlphanumeric(5);
        email = String.format(email,uid);
    }


    @Test
    public void testRegistration() throws Exception {
        WebElement element;
        Apptimize_trial.navigateToSignUp(driver);
        Thread.sleep(1000);
        element = Apptimize_trial.fetchFirstNameField(driver);
        element.sendKeys("Harold");
        element = Apptimize_trial.fetchLastNameField(driver);
        element.sendKeys("Co");
        element = Apptimize_trial.fetchCompanyNameField(driver);
        element.sendKeys("Apptimize Candidate");
        element = Apptimize_trial.fetchEmailNameField(driver);
        element.sendKeys(email);
        element = Apptimize_trial.fetchPasswordField(driver);
        element.sendKeys("shabadoobie");
        element = Apptimize_trial.fetchCheckboxEula(driver);
        element.click();
        element = Apptimize_trial.fetchRadioNo(driver);
        element.click();
        element = Apptimize_trial.fetchSignUpBtn(driver);
        element.click();
        Thread.sleep(3000);
        element = Apptimize_trial.fetchVerificationHeader(driver);
        Assert.assertEquals("What is the name of your application",element.getText());
        Thread.sleep(3000);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
