package app.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {

    private final SelenideElement productsTitle = $x("//span[@class='title']");
    private final SelenideElement menuButton = $x("//div[@class='bm-burger-button']");
    private final SelenideElement shoppingCardContainer = $x("//div[@id='shopping_cart_container']");
    //private final ElementsCollection inventoryContainer = (ElementsCollection) $x("//div[@class='inventory_list']");

    public void verifyProductsTitle() {
        productsTitle.shouldBe(Condition.visible);
    }

    public void verifyShoppingCard() {
        shoppingCardContainer.shouldBe(Condition.visible);
    }

    public void addInventoryToCard() {
        //inventoryContainer.findBy(Condition.text("Sauce Labs Bike Light"));
    }

}
