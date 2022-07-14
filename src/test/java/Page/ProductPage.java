package Page;

import Base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Constants.AllConstants.Constants.*;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public ProductPage clickBasket(){
        Assertions.assertTrue(isElementVisible(BASKET),"Urun Sayfasinda Sepete Ekle Butonu Bulunamadi");
        click(BASKET);
        return this;
    }
    public ProductPage checkProductCountOnBasket(int expectedProductCountOnBasket){
        Assertions.assertTrue(isElementVisible(QUANTITY),"Sepetteki Urun Sayisi Alani Bulunamadi");
        waitByMilliSeconds(250);
        String quantity = getText(QUANTITY);
        Assertions.assertEquals(expectedProductCountOnBasket,Integer.valueOf(quantity.trim()));
        return this;
    }
    public ProductPage clickCart(){
        Assertions.assertTrue(isElementVisible(CART),"Urun Sayfasinda Sepet Alani Bulunamadi");
        click(CART);
        return this;
    }

    public ProductPage clickGoCart(){
        Assertions.assertTrue(isElementVisible(GO_CART),"Urun Sayfasinda Sepet Git Butonu Bulunamadi");
        click(GO_CART);
        return this;
    }

}
