package Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {

    final static Logger logger = LogManager.getLogger(BasePage.class);
    WebDriver driver = null;
    WebDriverWait wait = null;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void sendKeys(By by, String text){
        findElement(by).sendKeys(text);
        logger.info(by.toString()+" Elementine "+ text+" degeri yazildi.");
    }

    public void click(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
        logger.info(by.toString()+" Elementine tiklandi.");
    }

    public void clear(By by){
        findElement(by).clear();
        logger.info(by.toString()+" Elementinin input alani temizlendi.");
    }

    //public List<WebElement> findElements(By by){
    //    return driver.findElements(by);
    //}

    public List<WebElement> findElementsWithWait(By by){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public String getText(By by){
        String text =  findElement(by).getText();
        logger.info(by.toString()+" Elementinin text değeri: "+text);
        return text;
    }

    public boolean isElementVisible(By by){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info(by.toString()+ " true");
            return true;
        }catch (Exception e){
            logger.error(by.toString()+" false "+e.getMessage());
            return false;
        }
    }

    public boolean isElementInvisible(By by){
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            logger.info(by.toString()+ " true");
            return true;
        }catch (Exception e){
            logger.error(by.toString()+" false "+e.getMessage());
            return false;
        }
    }
    //Javascript metodları kullanmak icin
    public void scrollElementCenter(By by){
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
                findElement(by));
    }

    public void waitByMilliSeconds(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info(millis +" MilliSaniye Beklendi");
    }

    public void waitBySeconds(long seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info(seconds +" Saniye Beklendi");
    }
}
