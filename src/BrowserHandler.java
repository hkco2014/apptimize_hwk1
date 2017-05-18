/**
 * Created by HaroldKendall on 5/17/2017.
 *
 * Selenium wrapper to create a driver object.
 * Figures out which OS the program is running in and reads
 * the appropriate configs.txt values to find the browser driver
 * and the binary installation paths.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.*;
import java.util.Properties;


public class BrowserHandler {

    private WebDriver driver;
    private static Properties prop = new Properties();
    private String GECKO_PATH, CHROME_DRIVER_PATH, FF_BINARY_PATH, CRM_BINARY_PATH;

    public BrowserHandler() throws FileNotFoundException, IOException{
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.contains("windows")) {
            GECKO_PATH = "GECKO_DRIVER_WIN"; FF_BINARY_PATH = "FIREFOX_BINARY_PATH_WIN";
            CHROME_DRIVER_PATH = "CHROME_DRIVER_WIN"; CRM_BINARY_PATH = "CHROME_BINARY_PATH_WIN";
        }
        else if (OS.startsWith("linux")) {
            GECKO_PATH = "GECKO_DRIVER_LNX"; FF_BINARY_PATH = "FIREFOX_BINARY_PATH_LNX";
            CHROME_DRIVER_PATH = "CHROME_DRIVER_LNX"; CRM_BINARY_PATH = "CHROME_BINARY_PATH_LNX";
        }
        else {
            GECKO_PATH = "GECKO_DRIVER_OSX"; FF_BINARY_PATH = "FIREFOX_BINARY_PATH_OSX";
            CHROME_DRIVER_PATH = "CHROME_DRIVER_OSX"; CRM_BINARY_PATH = "CHROME_BINARY_PATH_OSX";
        }

        InputStream input = new FileInputStream("configs.txt");
        prop.load(input);

    }


    public WebDriver setupFirefox() {
        System.setProperty("webdriver.gecko.driver", prop.getProperty(GECKO_PATH));
        FirefoxOptions configs = new FirefoxOptions();
        File pathBinary = new File(prop.getProperty(FF_BINARY_PATH));
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        configs.setBinary(firefoxBinary);
        driver = new FirefoxDriver(configs);
        return driver;
    }

    public WebDriver setupChrome() {
        System.setProperty("webdriver.chrome.driver", prop.getProperty(CHROME_DRIVER_PATH));
        ChromeOptions options = new ChromeOptions();
        options.setBinary(prop.getProperty(CRM_BINARY_PATH));
        driver = new ChromeDriver(options);
        return driver;
    }
}
