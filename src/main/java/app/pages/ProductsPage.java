package app.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {

    private final SelenideElement shoppingCardContainer = $x("//div[@id='shopping_cart_container']");

    public void verifyShoppingCard() {
        shoppingCardContainer.shouldBe(Condition.visible);
    }
}
