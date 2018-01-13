package com.selenide.objects.components;


import com.selenide.objects.pages.SearchResultsPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchTicketsForm {
    public String startStation = "Berlin";
    public String finishStation = "Hamburg";

    private By startStationInputField = By.xpath("//*[@id=\"search_start_station\"]");
    private By startStationFirstDropdownItem = By.xpath("/html/body/div[5]/ul/li[1]");
    private By finishStationInputField = By.xpath("//*[@id=\"search_finish_station\"]");
    private By finishStationFirstDropdownItem = By.xpath("/html/body/div[6]/ul/li[1]");
    private By swapStationsButton = By.xpath("//*[@id=\"new_search\"]/fieldset[1]/ol/li[2]/a");
    private By returnTripSwitcher = By.xpath("//*[@id=\"search_journey_type_input\"]");
    private By returnTripInputField = By.xpath("//*[@id=\"search_return_date_input\"]");
    private By departureInputField = By.xpath("//*[@id=\"search_departure_date_input\"]/input[2]");
    private By departureTomorrowButton = By.xpath("//*[@id=\"search_departure_date_datepicker\"]/div[1]/div[1]/a[2]");
    private By departureTimeHour = By.xpath("//*[@id=\"search_departure_time_hour\"]");
    private By departureDatepicker = By.xpath("//*[@id=\"search_departure_time_min\"]");
    private By departureTimeMinute = By.xpath("//*[@id=\"search_departure_time_min\"]");
    private By returnInputField = By.xpath("//*[@id=\"search_return_date_input\"]/input[2]");
    private By returnNextDayButton = By.xpath("//*[@id=\"search_departure_date_input\"]");
    private By returnTimeHour = By.xpath("//*[@id=\"search_departure_time_hour\"]");
    private By returnTimeMinute = By.xpath("//*[@id=\"search_departure_time_min\"]");
    private By returnDatepicker = By.xpath("//*[@id=\"search_departure_time_min\"]");
    private By adultPassengerMinus = By.xpath("//*[@class=\"who\"]/ol/li[1]/div[1]/div[1]/div[1]/button");
    private By adultPassengerPlus = By.xpath("//*[@class=\"who\"]/ol/li[1]/div[1]/div[1]/div[2]/button");
    private By adultPassengersNumber = By.xpath("//*[@id=\"search_passengers_attributes_0_number\"]");
    private By findTrainsButton = By.xpath("//*[@id=\"new_search\"]/fieldset[4]/ol/li[2]");

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
        $(returnTripInputField).waitUntil(visible, 2000);
    }

    public void userCanSetTripDateAndTime(){
        $(departureInputField).click();
        $(departureDatepicker).shouldBe(visible);
        $(departureTomorrowButton).click();
        $(departureTimeHour).selectOptionByValue("16");
        $(departureTimeHour).shouldHave(text("16"));
        $(departureTimeMinute).selectOptionByValue("30");
        $(departureTimeMinute).shouldHave(text("30"));
        $(returnInputField).click();
        $(returnDatepicker).shouldBe(visible);
        $(returnNextDayButton).click();
        $(returnTimeHour).selectOptionByValue("8");
        $(returnTimeHour).shouldHave(text("08"));
        $(returnTimeMinute).selectOptionByValue("30");
        $(returnTimeMinute).shouldHave(text("30"));
    }

    public void userCanSelectPassengers(){
        $(adultPassengersNumber).shouldHave(value("1"));
        $(adultPassengerMinus).click();
        $(adultPassengersNumber).shouldHave(value("0"));
        $(adultPassengerPlus).click();
        $(adultPassengersNumber).shouldHave(value("1"));

    }

    public SearchResultsPage userCanClickFindButton() {
        $(findTrainsButton).click();
        return new SearchResultsPage();
    }
}


