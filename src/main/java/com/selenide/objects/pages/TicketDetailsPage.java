package com.selenide.objects.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TicketDetailsPage {

    private String pageTitle = "Ticket details | Loco2";
    private By orderDetails = By.xpath("//*[@id=\"order_items\"]");
    private By seatingPreferences = By.xpath("//*[@id=\"order_items\"]/div/section[2]/div");
    private By paidSeatReservationCheckbox = By.xpath("//*[@id=\"selection_items_attributes_0_optional_reservations_required_input\"]/label");
    private By printAtHomeCheckbox = By.xpath("//*[@id=\"selection_items_attributes_0_delivery_method_print_at_home\"]");
    private By mobileTicketCheckbox = By.xpath("//*[@id=\"selection_items_attributes_0_delivery_method_mobile\"]");
    private By firstPassengerType = By.xpath("//*[@id=\"passengers_details\"]/div/div[1]/h3/strong");
    private By firstPassengerTitle = By.xpath("//*[@id=\"selection_passengers_attributes_0_title\"]");
    private By firstPassengerFirstName = By.xpath("//*[@id=\"selection_passengers_attributes_0_first_name\"]");
    private By firstPassengerLastName = By.xpath("//*[@id=\"selection_passengers_attributes_0_last_name\"]");
    private By addToBasketButton = By.xpath("//*[@class=\"tally\"]/p/button");


    public void userIsOnTicketsDetailsPage(){
        $("title").shouldHave(attribute("text", pageTitle));
    }

    public void userCanUncheckPaidSeatReservation(){
        $(orderDetails).waitUntil(visible, 10000);
        $(paidSeatReservationCheckbox).shouldBe(visible).click();
        $(paidSeatReservationCheckbox).shouldNotBe(checked);
        $(seatingPreferences).shouldNotBe(visible);
    }

    public void userCanSelectTicketDeliveryMethod(){
        $(printAtHomeCheckbox).shouldBe(checked);
        $(mobileTicketCheckbox).shouldNotBe(checked);
    }
    public void userCanSelectPassengerTitle(){
        $(firstPassengerType).shouldHave(exactText("Adult"));
        $(firstPassengerTitle).selectOptionByValue("Mr");
        $(firstPassengerTitle).shouldHave(text("Mr"));
        $(firstPassengerFirstName).setValue("Test");
        $(firstPassengerLastName).setValue("Testing");
    }

    public void userCanClickAddToBasketButton(){
        $(addToBasketButton).click();
    }


}
