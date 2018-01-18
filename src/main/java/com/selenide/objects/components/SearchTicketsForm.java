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
    //Return trip switcher
    private By returnTripSwitcher = By.xpath("//*[@id=\"search_journey_type_input\"]");
    private By returnTripInputField = By.xpath("//*[@id=\"search_return_date_input\"]");
    //Departure date and time
    private By departureInputField = By.xpath("//*[@id=\"search_departure_date_input\"]/input[2]");
    private By departureTomorrowButton = By.xpath("//*[@id=\"search_departure_date_datepicker\"]/div[1]/div[1]/a[2]");
    private By departureTimeHour = By.xpath("//*[@id=\"search_departure_time_hour\"]");
    private By departureDatepicker = By.xpath("//*[@id=\"search_departure_time_min\"]");
    private By departureTimeMinute = By.xpath("//*[@id=\"search_departure_time_min\"]");
    //Return date and time
    private By returnInputField = By.xpath("//*[@id=\"search_return_date_input\"]/input[2]");
    private By returnNextDayButton = By.xpath("//*[@id=\"search_departure_date_input\"]");
    private By returnTimeHour = By.xpath("//*[@id=\"search_departure_time_hour\"]");
    private By returnTimeMinute = By.xpath("//*[@id=\"search_departure_time_min\"]");
    private By returnDatepicker = By.xpath("//*[@id=\"search_departure_time_min\"]");
    //Adult passengers controls
    private By adultPassengerMinus = By.xpath("//*[@class=\"who\"]/ol/li[1]/div[1]/div[1]/div[1]/button");
    private By adultPassengerPlus = By.xpath("//*[@class=\"who\"]/ol/li[1]/div[1]/div[1]/div[2]/button");
    private By adultPassengersNumber = By.xpath("//*[@id=\"search_passengers_attributes_0_number\"]");
    //Senior passengers controls
    private By seniorPassengerMinus = By.xpath("//*[@class=\"who\"]/ol/li[2]/div[1]/div[1]/div[1]/button");
    private By seniorPassengerPlus = By.xpath("//*[@class=\"who\"]/ol/li[2]/div[1]/div[1]/div[2]/button");
    private By seniorPassengersNumber = By.xpath("//*[@id=\"search_passengers_attributes_1_number\"]");
    //Youth passengers controls
    private By youthPassengerMinus = By.xpath("//*[@class=\"who\"]/ol/li[3]/div[1]/div[1]/div[1]/button");
    private By youthPassengerPlus = By.xpath("//*[@class=\"who\"]/ol/li[3]/div[1]/div[1]/div[2]/button");
    private By youthPassengersNumber = By.xpath("//*[@id=\"search_passengers_attributes_2_number\"]");
    private By youthPassengerInputField = By.xpath("//*[@id=\"passenger_2_age_0\"]");
    //Railcards
    private By addRailcardButton = By.xpath("//*[@id=\"add_railcard\"]");
    private By railcardWindow = By.xpath("//*[@id=\"railcards\"]");
    private By closeRailcardWindow = By.xpath("//*[@id=\"new_search\"]/div[1]/div/a");
    private By quantityOfRailcardsSelector = By.xpath("//*[@id=\"railcards\"]/section/div[1]/fieldset/ol/li/select[1]");
    private By firstRailcardTypeSelector = By.xpath("//*[@id=\"railcards\"]/section/div[1]/fieldset/ol/li/select[2]");
    private By removeFirstRailcardButton = By.xpath("//*[@id=\"railcards\"]/section/div[1]/fieldset[1]/ol/li/a/i");
    private By addAnotherRailcardButton = By.xpath("//*[@id=\"railcards\"]/section/a");
    private By removeSecondRailcardButton = By.xpath("//*[@id=\"railcards\"]/section/div[1]/fieldset[2]/ol/li/a");
    private By confirmAddingRailcardButton = By.xpath("//*[@id=\"railcards\"]/section/div[2]/a");
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
        $(adultPassengerMinus).shouldBe(disabled);
        $(adultPassengerPlus).click();
        $(adultPassengersNumber).shouldHave(value("1"));
        $(seniorPassengersNumber).shouldHave(value("0"));
        $(seniorPassengerMinus).shouldBe(disabled);
        $(seniorPassengersNumber).shouldHave(value("0"));
        $(youthPassengerInputField).shouldNotBe(visible);
        $(youthPassengersNumber).shouldHave(value("0"));
        $(youthPassengerInputField).shouldBe(disabled);
        $(youthPassengerPlus).click();
        $(youthPassengersNumber).shouldHave(value("1"));
        $(youthPassengerInputField).shouldBe(visible).setValue("10");
        $(youthPassengerMinus).click();
        $(youthPassengerMinus).shouldBe(disabled);
    }

    public void userCanManageRailcards(){
        $(addRailcardButton).click();
        $(railcardWindow).shouldBe(visible);
        $(quantityOfRailcardsSelector).selectOptionByValue("2");
        $(quantityOfRailcardsSelector).shouldHave(value("2"));
        $(firstRailcardTypeSelector).selectOptionByValue("BC25-1");
        $(firstRailcardTypeSelector).shouldHave(text("BahnCard 25, 1st class"));
        $(confirmAddingRailcardButton).click();
        $(addRailcardButton).shouldHave(text("2 railcards")).click();
        $(addAnotherRailcardButton).click();
        $(removeSecondRailcardButton).click();
        $(removeFirstRailcardButton).click();
        $(closeRailcardWindow).click();
    }



    public SearchResultsPage userCanClickFindButton() {
        $(findTrainsButton).click();
        return new SearchResultsPage();
    }
}


