package base;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class FrameworkBase {

    protected static WebDriver driver = null;
    protected JavascriptExecutor js;
    protected WebDriverWait waiter;
    public FrameworkBase(){
        if(driver!=null){
            waiter = (WebDriverWait) new WebDriverWait(driver, timeouts)
                    .pollingEvery(Duration.ofMillis(50))
                    .ignoring(StaleElementReferenceException.class);
            js = (JavascriptExecutor)driver;
           
        }
        getDriver();
    }

	//default timeout
    protected int timeouts = 5;

    /**
     *  Get the driver with devices
     */
    public  WebDriver getDriver(){
        if(driver != null){
            return  driver;
        }
        System.out.println("Starting test on chrome");
        final String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        return driver;
    }

    /**
     * Get Site Url from pom.xml properties or command line -DsiteUrl
     */
    public String getSiteBaseUrl() {
        return (String)System.getProperty("siteUrl");
    }

    /**
     * Close Driver: delete all cookies for new session, tearDownClass() will handle closing the driver
     */
    protected static void clearCookies() {
        if (null != driver) {
            driver.manage().deleteAllCookies();
        }
    }
    /**
     * Quit Driver: tearDownClass() will handle closing the driver
     */
    public static void quitDriver() {
        if (null != driver) {
            driver.quit();
        }
    }

    /**
     * Select element describe by locator
     * @param locator
     * @return WebElement
     */
    protected WebElement select(By locator){
        try{
            WebElement elt = waiter
                    .withMessage(String.format("Could not found element with locator %s",locator))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return elt;
        }catch(Exception ex){
            throw ex;
        }
    }

    /**
     * click on element describe by locator
     * @param locator
     */
    protected void click(By locator){
        select(locator).click();
    }

    /**
     * get text displayed on element describe by locator
     * @param locator
     * @return
     */
    protected String getText(By locator){
        return select(locator).getText();
    }

    /**
     * set text on field describe by locator
     * @param locator
     * @param input
     */
    protected void setText(By locator, String input){
        select(locator).sendKeys(input);
    }

}
