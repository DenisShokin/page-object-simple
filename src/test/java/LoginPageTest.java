import app.pages.LoginPage;
import app.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginPageTest {

    @BeforeEach
    public void setUp(){
        open("https://www.saucedemo.com/");
    }

    @Test
    public void successLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage();
        productsPage.verifyShoppingCard();
    }

    @Test
    public void errorLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "standard_user");
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service",
                loginPage.getErrorMessage());
    }

}
