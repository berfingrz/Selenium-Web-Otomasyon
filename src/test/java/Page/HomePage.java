package Page;

import Base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static Constants.AllConstants.Constants.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage controlHomePage(){
        Assertions.assertTrue(isElementVisible(LOGIN),"Anasayfada Login Butonu Bulunamadi");
        Assertions.assertTrue(isElementVisible(SIGN_UP),"Anasayfada Üye Ol Butonu Bulunamadi");
        Assertions.assertTrue(isElementVisible(SEARCH_BAR),"Anasayfada Arama Cubugu Bulunamadi");
        Assertions.assertTrue(isElementVisible(SEARCH_BUTTON),"Anasayfada Arama Butonu Bulunamadi");
        Assertions.assertTrue(isElementVisible(CART),"Anasayfada Sepet Alani Bulunamadi");
        Assertions.assertTrue(isElementVisible(PRODUCT),"Anasayfada Urun Bulunamadi");
        return this;
    }
    public HomePage clickSearchBar(){
        click(SEARCH_BAR);
        return this;
    }

    public HomePage sendWord(String text){
        sendKeys(SEARCH_BAR,text);
        return this;
    }

    public HomePage clickSearchButton(){
        click(SEARCH_BUTTON);
        return this;
    }
    public HomePage clickRandomProduct(){
        Assertions.assertTrue(isElementVisible(PRODUCT_LIST),"Anasayfada Urun Listesi Bulunamadi");
        Random random = new Random();
        List<WebElement> productList = findElementsWithWait(By.cssSelector(".product-list .name"));
        int randomProductNumber = random.nextInt(productList.size());
        By productBy = By.cssSelector("#product-table > .product-cr:nth-child("+randomProductNumber+") .name > a");
        Assertions.assertTrue(isElementVisible(productBy),"Anasayfada Secilen Urun Bulunamadi");
        waitByMilliSeconds(500);
        scrollElementCenter(productBy);
        waitByMilliSeconds(500);
        Assertions.assertTrue(isElementVisible(productBy),"Anasayfada Secilen Urun Bulunamadi"); //Scrool Ettikten sonra tekrar element kontrol ettim
        click(productBy);
        return this;
    }
}
