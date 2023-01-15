import app.pages.LoginPage;
import app.pages.ProductsPage;
import com.codeborne.selenide.Selenide;
import core.TestBase;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class LoginPageTest extends TestBase {

    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        open(properties.getProperty("mainUrl"));
        loginPage = new LoginPage();
    }

    @DisplayName("Success login to saucedemo.com")
    @Test
    public void standardUserLogin() {
        loginPage.login(properties.getProperty("standardLogin"), properties.getProperty("standardPassword"));
        ProductsPage productsPage = new ProductsPage();
        productsPage.verifyProductsTitle();
    }

    @DisplayName("Authorize with locked login to saucedemo.com")
    @Test
    public void lockedUserLogin() {
        loginPage.login(properties.getProperty("lockedLogin"), properties.getProperty("standardPassword"));
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.",
                loginPage.getErrorMessage());
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
