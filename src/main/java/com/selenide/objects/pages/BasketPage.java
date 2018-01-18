package com.selenide.objects.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    private String pageTitle = "Basket | Loco2";
    private By orderDetails = By.xpath("//*[@id=\"order_items\"]");

    public void userIsOnBasketPage() {
        $("title").shouldHave(attribute("text", pageTitle));

    }


}
