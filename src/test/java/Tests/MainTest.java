package Tests;

import Base.BaseTest;
import Page.BasketPage;
import Page.HomePage;
import Page.ProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest extends BaseTest {

    final static Logger logger = LogManager.getLogger(MainTest.class);
    public List<String> readCsv(String path){
        List<String> novels = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileInputStream(path));
            while (scanner.hasNext()){
                novels.add(scanner.next());
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found or deleted");
        }
        return novels;
    }

    HomePage homePage;
    ProductPage productPage;
    BasketPage basketPage;

    @Before
    public void setUp(){
        super.setUp();
        logger.info("Test is starting..");
        logger.trace("Logger message TRACE");
        logger.debug("Logger message DEBUG");
        logger.info("Logger message INFO");
        logger.warn("Logger message WARM");
        logger.error("Logger message ERROR");
        logger.fatal("Logger message FATAL");

        homePage = new HomePage(getWebDriver());
        productPage = new ProductPage(getWebDriver());
        basketPage = new BasketPage(getWebDriver());
    }

    @Test
    public void test() {
        /* Search the "roman" words */
        List<String> novels = readCsv("csvfile/roman.csv");
        homePage
                .controlHomePage()
                .clickSearchBar()
                .sendWord(novels.get(0))
                .clickSearchButton();

        logger.info("Aranacak urun:" +novels);

        /* Find the random book */
        homePage.clickRandomProduct();

        logger.info("Product Page is starting");
        productPage
                .clickBasket()
                .checkProductCountOnBasket(1)
                .clickCart()
                .clickGoCart();

        basketPage
                .checkBasketPage()
                .findProduct()
                .clearProduct()
                .sendProduct()
                .refreshButton()
                .controlRefreshButton() //Sepetteki Urun Miktari Guncellendi Mesaji Kontrolu
                .checkBasketPage()
                .removeProduct()
                .controlRemoveProduct();

    }
    @After
    public void tearDown() {
        super.tearDown();
        logger.info("Test finished");
    }
}
