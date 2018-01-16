package com.selenide.objects.pages;


import com.selenide.objects.components.SearchTicketsForm;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

public class TicketDetailsPage extends SearchTicketsForm{

    private String pageTitle = "Ticket details | Loco2";

    public void userIsOnTicketsDetailsPage(){
        $("title").shouldHave(attribute("text", pageTitle));
    }
}
