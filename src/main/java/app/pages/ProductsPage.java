package app.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProductsPage {

    private final SelenideElement productsTitle = $x("//span[@class='title']");

    private final SelenideElement shoppingCardContainer = $x("//div[@id='shopping_cart_container']");
    private final SelenideElement shoppingCardCounter = $x("//div[@id='shopping_cart_container']//span");
    private final ElementsCollection inventoryItemList = $$x("//div[@class='inventory_item']");

    public void verifyProductsTitle() {
        productsTitle.shouldBe(Condition.visible);
    }

    public void verifyShoppingCardIsEmpty() {
        shoppingCardContainer.shouldBe(Condition.visible);
        // for empty card counter is not visible
        shoppingCardCounter.shouldNot(Condition.visible);
    }

    public int getInventoryItemsCount() {
        return inventoryItemList.size();
    }

    public void addInventoryByLabelToCard(String label) {
        SelenideElement inventoryItem = inventoryItemList.findBy(Condition.text(label));
        inventoryItem.find("button").click();
    }

    public int getCountItemsInCard() {
        return Integer.parseInt(shoppingCardCounter.getText());
    }

    public void addAllInventoryToCard() {
        for (SelenideElement inventoryItem : inventoryItemList) {
            inventoryItem.find("button").click();
        }
    }

    public InventoryPage openInventoryCard(String label) {
        inventoryItemList.findBy(Condition.text(label)).find("div.inventory_item_img").click();
        return page(InventoryPage.class);
    }

}
