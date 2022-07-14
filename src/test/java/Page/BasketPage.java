package Page;

import Base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static Constants.AllConstants.Constants.*;

public class BasketPage extends BasePage {

    final static Logger logger = LogManager.getLogger(BasketPage.class);
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public BasketPage checkBasketPage(){
        Assertions.assertTrue(isElementVisible(BUY),"Sepet Sayfasinda Satin Al Butonu Bulunamadi");
        Assertions.assertTrue(isElementVisible(ADD_PRODUCT),"Sepet Sayfasinda Urun Miktari Alani Bulunamadi");
        Assertions.assertTrue(isElementVisible(REFRESH_BUTTON),"Sepet Sayfasinda Urun Miktari Yenileme Butonu Bulunamadi");
        Assertions.assertTrue(isElementVisible(REMOVE),"Sepet Sayfasinda Urunu Kaldirma Butonu Bulunamadi");
        return this;
    }

    public BasketPage findProduct(){

        click(ADD_PRODUCT);
        return this;
    }

    public BasketPage clearProduct(){
        clear(ADD_PRODUCT);
        return this;
    }

    public BasketPage sendProduct(){
        sendKeys(ADD_PRODUCT,"2");
        return this;
    }

    public BasketPage refreshButton(){
        click(REFRESH_BUTTON);
        return this;
    }

    public BasketPage controlRefreshButton(){
        Assertions.assertTrue(isElementVisible(CONTROL_BASKET),"Sepet Sayfasinda Urun Sayisi Guncellendi Mesaji Goruntulenemedi.");
        logger.info("Sepetteki Urun Sayisi Guncellendi");
        return this;
    }

    public BasketPage removeProduct(){
        click(REMOVE);
        return this;
    }

    public BasketPage controlRemoveProduct(){
        Assertions.assertTrue(isElementVisible(CONTROL_REMOVE),"Sepet Sayfasindaki Urun Cikartiliyor Mesaji Goruntulenemedi.");
        logger.info("Sepetteki Urun Kaldirildi");
        Assertions.assertTrue(isElementInvisible(REMOVE),"Sepet Sayfasindaki Urun Kaldirma Butonu Halen Mevcut");
        return this;
    }
}
