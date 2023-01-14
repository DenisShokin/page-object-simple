import app.pages.LoginPage;
import app.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginPageTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setUp(){
        open("https://www.saucedemo.com/");
        loginPage = new LoginPage();
    }

    @DisplayName("Success login to saucedemo.com")
    @Test
    public void successLogin() {
        loginPage.login("standard_user", "secret_sauce");
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
