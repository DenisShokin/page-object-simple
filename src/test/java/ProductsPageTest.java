import app.pages.LoginPage;
import app.pages.ProductsPage;
import com.codeborne.selenide.Selenide;
import core.TestBase;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class ProductsPageTest extends TestBase {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeEach
    public void setUp() {
        open(properties.getProperty("mainUrl"));
        loginPage = new LoginPage();
        loginPage.login(properties.getProperty("standardLogin"), properties.getProperty("standardPassword"));
        productsPage = new ProductsPage();
    }

    @DisplayName("Check shopping card is empty")
    @Test
    public void checkCardIsEmpty() {
        productsPage.verifyShoppingCardIsEmpty();
    }

    @DisplayName("Check count inventory list")
    @Test
    public void checkCountInventoryList() {
        Assertions.assertEquals(6, productsPage.getInventoryItemsCount(), "Inventory count is not correct");
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

    @DisplayName("Open inventory card")
    @Test
    public void openInventoryCard() {
        productsPage.openInventoryCard("Sauce Labs Bolt T-Shirt");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
