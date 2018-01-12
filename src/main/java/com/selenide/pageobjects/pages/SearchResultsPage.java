package com.selenide.pageobjects.pages;

import com.selenide.pageobjects.components.SearchTicketsForm;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage extends SearchTicketsForm{

    private String tabInfo = startStation + " to " + finishStation;
    private By searchResultsPageInfoTab = By.xpath("//*[@id=\"tabs\"]");
    private By inboundResultsFirstItem = By.xpath("//*[@id=\"legs\"]/div[1]/div/div[2]/ul/li[1]");
    private By inboundTicketClassDropdown = By.xpath("//*[@id=\"legs\"]/div[1]/div/div[2]/ul/li[1]/div[2]/ol/li/div/div/table/tbody/tr/td[3]");
    private By inboundTicketClassItem = By.xpath("//*[@id=\"legs\"]/div[1]/div/div[2]/ul/li[1]/div[2]/ol/li/div/div/div/table/tbody/tr[2]");
    private By returnTicketsButton = By.xpath("//*[@class=\"outbound\"]/button");
    private By outboundResultsFirstItem = By.xpath("//*[@id=\"legs\"]/div[2]/div/div[2]/ul/li[1]");
    private By outboundTicketClassDropdown = By.xpath("//*[@id=\"legs\"]/div[2]/div/div[2]/ul/li[1]/div[2]/ol/li/div/div/table/tbody/tr/td[3]");
    private By outboundTicketClassItem = By.xpath("//*[@id=\"legs\"]/div[2]/div/div[2]/ul/li[1]/div[2]/ol/li/div/div/div/table/tbody/tr[2]");
    private By ticketDetailsButton = By.xpath("//*[@class=\"inbound\"]/button");

    public void userCanSeeSearchResults(){
        $(searchResultsPageInfoTab).shouldHave(text(tabInfo));
        $(inboundResultsFirstItem).waitUntil(visible, 20000);
    }

    public void userCanSelectStartTicketAndTicketClass(){
        //Click ticket
        $(inboundResultsFirstItem).click();
        //Click ticket class dropdown
        $(inboundTicketClassDropdown).click();
        //Select ticket class (second in the list)
        $(inboundTicketClassItem).click();
    }

    public void userCanSelectReturnTicketAndTicketClass(){
        $(returnTicketsButton).click();
        //Click ticket
        $(outboundResultsFirstItem).click();
        //Click ticket class dropdown
        $(outboundTicketClassDropdown).click();
        //Select ticket class (second in the list)
        $(outboundTicketClassItem).click();
    }

    public TicketDetailsPage userCanLoadTicketDetails() {
        $(ticketDetailsButton).click();
        return new TicketDetailsPage();
    }

}
