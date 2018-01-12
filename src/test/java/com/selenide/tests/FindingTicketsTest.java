package com.selenide.tests;

import com.selenide.pageobjects.components.SearchTicketsForm;
import com.selenide.pageobjects.pages.SearchResultsPage;
import org.testng.annotations.Test;

public class FindingTicketsTest extends TestConfig {

    @Test
    public void testCanSelectStationsFromDropdown() {
        new SearchTicketsForm().userCanSelectStartStationFromDropdown();
        new SearchTicketsForm().userCanSelectFinishStationFromDropdown();
    }

    @Test(priority = 1)
    public void testCanSwapStations() {
        new SearchTicketsForm().userCanSwapStations();
    }

    @Test(priority = 2)
    public void testCanSelectReturnTrip() {
        new SearchTicketsForm().userCanSelectReturnTrip();
    }

    @Test(priority = 3)
    public void testCanSetTripDateAndTime() {
        new SearchTicketsForm().userCanSetTripDateAndTime();
    }


    @Test(priority = 4)
    public void testCanOpenSearchResults() {
        new SearchTicketsForm().userCanClickFindButton();
        new SearchResultsPage().userCanSeeSearchResults();
    }

    @Test(priority = 5)
    public void testCanSelectStartTicketAndTicketClass() {
        new SearchResultsPage().userCanSelectStartTicketAndTicketClass();
    }

    @Test(priority = 6)
    public void testCanSelectReturnTicketAndTicketClass() {
        new SearchResultsPage().userCanSelectReturnTicketAndTicketClass();
    }

    @Test(priority = 7)
    public void testCanLoadTicketDetails() {
        new SearchResultsPage().userCanLoadTicketDetails();
    }
}