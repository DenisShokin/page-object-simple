import app.pages.LoginPage;
import app.pages.ProductsPage;
import core.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class ProductsPageTest extends TestBase {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeEach
    public void setUp(){
        open(properties.getProperty("mainUrl"));
        loginPage = new LoginPage();
        loginPage.login(properties.getProperty("userLogin"), properties.getProperty("userPassword"));
        productsPage = new ProductsPage();
    }

    @DisplayName("Check that shopping card is empty")
    @Test
    public void checkCardIsEmpty() {
        productsPage.verifyShoppingCardIsEmpty();
    }

    @DisplayName("Check count inventory list")
    @Test
    public void checkCountInventoryList() {
        Assertions.assertEquals(6, productsPage.getInventoryItemsCount(), "Inventory count is not correct") ;
    }

    @DisplayName("Add item to card from inventory list")
    @Test
    public void addItemToCard() {
        productsPage.verifyShoppingCardIsEmpty();
        productsPage.addInventoryByLabelToCard("Sauce Labs Bolt T-Shirt");
        Assertions.assertEquals(1, productsPage.getCountItemsInCard(), "In card incorrect count items");
    }

    @DisplayName("Add all items to card from inventory list")
    @Test
    public void addAllItemsToCard() {
        productsPage.verifyShoppingCardIsEmpty();
        productsPage.addAllInventoryToCard();
        Assertions.assertEquals(6, productsPage.getCountItemsInCard(), "In card incorrect count items");
    }
}
