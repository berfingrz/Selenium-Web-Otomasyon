package Constants;

import org.openqa.selenium.By;

public class AllConstants {
    public static class Constants{
        public static final By LOGIN = By.cssSelector(".menu-top-button.login");
        public static final By SIGN_UP = By.cssSelector(".menu-top-button.register");
        public static final By PRODUCT = By.className("product-cr");
        public static final By SEARCH_BAR = By.id("search-input");
        public static final By SEARCH_BUTTON = By.className("button-search");
        public static final By PRODUCT_LIST = By.cssSelector("#product-table .name");
        public static final By BASKET = By.xpath("//*[@id=\"button-cart\"]/span");
        public static final By QUANTITY = By.id("cart-items-text");
        public static final By CART = By.id("cart");
        public static final By GO_CART = By.id("js-cart");
        public static final By ADD_PRODUCT = By.cssSelector("form.js-cart-update-product > input[name = \"quantity\"]");
        public static final By REFRESH_BUTTON = By.className("green-icon");
        public static final By REMOVE = By.cssSelector("td.remove > a");
        public static final By BUY = By.xpath("//div[@class=\"buttons\"]//a[@class=\"button red\" and normalize-space(text())=\"Satın Al\"]");
        public static final By CONTROL_BASKET = By.xpath("//h2[@id=\"swal2-title\" and normalize-space(text())=\"Sepetiniz güncelleniyor!\"]");

        public static final By CONTROL_REMOVE = By.xpath("//h2[@id=\"swal2-title\" and normalize-space(text())=\"Sepetinizden çıkarılıyor!\"]");
    }
}
