import app.pages.LoginPage;
import app.pages.ProductsPage;
import core.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginPageTest extends TestBase {

    private LoginPage loginPage;

    @BeforeEach
    public void setUp(){
        open(properties.getProperty("mainUrl"));
        loginPage = new LoginPage();
    }

    @DisplayName("Success login to saucedemo.com")
    @Test
    public void successLogin() {
        loginPage.login(properties.getProperty("userLogin"), properties.getProperty("userPassword"));
        ProductsPage productsPage = new ProductsPage();
        productsPage.verifyProductsTitle();
    }

    @DisplayName("Authorize with incorrect password to saucedemo.com")
    @Test
    public void errorLogin() {
        loginPage.login("standard_user", "standard_user");
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service",
                loginPage.getErrorMessage());
    }

}
