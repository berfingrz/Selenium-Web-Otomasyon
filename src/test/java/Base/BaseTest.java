package Base;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BaseTest {
    static WebDriver webDriver=null;

    public void setUp(){
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        setWebDriver(new EdgeDriver(options));
        webDriver.manage().window().maximize();
        webDriver.get("https://www.kitapyurdu.com/");
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }
    public static void setWebDriver(WebDriver webDriver) {
        BaseTest.webDriver = webDriver;
    }


    public void tearDown(){
        getWebDriver().quit();
    }
}
