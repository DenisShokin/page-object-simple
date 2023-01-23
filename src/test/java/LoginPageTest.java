import app.pages.LoginPage;
import app.pages.ProductsPage;
import com.codeborne.selenide.Selenide;
import core.TestBase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    @DisplayName("Authorize with incorrect data to saucedemo.com")
    @ParameterizedTest()
    @MethodSource("provideParameters")
    public void incorrectUserLogin(String login, String password, String errorMessage) {
        loginPage.login(login, password);
        Assertions.assertEquals(errorMessage,
                loginPage.getErrorMessage());
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."),
                Arguments.of("standard_user", "test", "Epic sadface: Username and password do not match any user in this service"),
                Arguments.of("test", "test", "Epic sadface: Username and password do not match any user in this service")
        );
    }

}
