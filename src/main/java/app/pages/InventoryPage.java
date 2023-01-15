package app.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class InventoryPage {

    private SelenideElement backToProductsButton = $x("//button[@data-test='back-to-products']");
    private SelenideElement inventoryDetailContainer = $("div.inventory_details_container");

    public void verifyBackToProductsButtonVisible() {
        backToProductsButton.shouldBe(Condition.visible);
    }
}
