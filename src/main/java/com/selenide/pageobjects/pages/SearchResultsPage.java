package com.selenide.pageobjects.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;

public class SearchResultsPage {

    private String tabInfo = "London to Paris";
    private By searchResultsPageInfoTab = By.xpath("//*[@id=\"tabs\"]");
    private By searchResults = By.xpath("/html/body/div[1]/div/div[2]/section/div/form/div[3]/div/div/div[3]/a[2]");

    public void userCanSeeSearchResults(){
        $(searchResultsPageInfoTab).shouldHave(text(tabInfo));
        $(searchResults).waitUntil(visible, 20000);
    }

}
