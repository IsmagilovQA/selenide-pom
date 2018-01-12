package com.selenide.pageobjects.components;


import com.selenide.pageobjects.pages.SearchResultsPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SearchTicketsForm {
    public String startStation = "Berlin";
    public String finishStation = "Hamburg";
    private By startStationInputField = By.xpath("//*[@id=\"search_start_station\"]");
    private By startStationFirstDropdownItem = By.xpath("/html/body/div[6]/ul/li[1]");
    private By finishStationInputField = By.xpath("//*[@id=\"search_finish_station\"]");
    private By finishStationFirstDropdownItem = By.xpath("/html/body/div[7]/ul/li[1]");
    private By swapStationsButton = By.xpath("//*[@id=\"new_search\"]/fieldset[1]/ol/li[2]/a");
    private By returnTripSwitcher = By.xpath("//*[@id=\"search_journey_type_input\"]");
    private By departureTimeHour = By.xpath("//*[@id=\"search_departure_time_hour\"]");
    private By departureTimeMinute = By.xpath("//*[@id=\"search_departure_time_min\"]");
    private By returnTimeHour = By.xpath("//*[@id=\"search_departure_time_hour\"]");
    private By returnTimeMinute = By.xpath("//*[@id=\"search_departure_time_min\"]");
    private By findTrainsButton = By.xpath("//*[@id=\"new_search\"]/fieldset[4]/ol/li[2]");
    private By openDepartureCalendar = By.xpath("//*[@id=\"search_departure_date_input\"]");
    private By departureTomorrow = By.xpath("//*[@id=\"search_departure_date_datepicker\"]/div[1]/div[1]/a[2]");

    public void userCanSelectStartStationFromDropdown() {
        $(startStationInputField).setValue(startStation);
        $(startStationFirstDropdownItem).shouldBe(visible);
        $(startStationFirstDropdownItem).click();
        $(startStationInputField).shouldHave(value(startStation));
    }

    public void userCanSelectFinishStationFromDropdown(){
        $(finishStationInputField).setValue(finishStation);
        $(finishStationFirstDropdownItem).shouldBe(visible);
        //First item is selected
        $(finishStationFirstDropdownItem).click();
        $(finishStationInputField).shouldHave(value(finishStation));
    }

    public void userCanSwapStations(){
        $(swapStationsButton).click();
        $(startStationInputField).shouldHave(value(finishStation));
        $(finishStationInputField).shouldHave(value(startStation));
        $(swapStationsButton).click();
    }

    public void userCanSelectReturnTrip(){
        $(returnTripSwitcher).click();
    }

    public void userCanSetTripDateAndTime(){
        $(openDepartureCalendar).click();
        $(departureTomorrow).click();
        $(departureTimeHour).selectOptionByValue("16");
        $(departureTimeHour).shouldHave(text("16"));
        $(departureTimeMinute).selectOptionByValue("30");
        $(departureTimeMinute).shouldHave(text("30"));
        $(returnTimeHour).selectOptionByValue("8");
        $(returnTimeHour).shouldHave(text("08"));
        $(returnTimeMinute).selectOptionByValue("30");
        $(returnTimeMinute).shouldHave(text("30"));
    }

    public SearchResultsPage userCanClickFindButton() {
        $(findTrainsButton).click();
        return new SearchResultsPage();
    }
}


