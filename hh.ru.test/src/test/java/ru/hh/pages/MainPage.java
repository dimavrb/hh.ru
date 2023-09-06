package ru.hh.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    SelenideElement inputVacancy = $("#a11y-search-input"),
            searchButton = $("button[type='submit']");


    public MainPage openPage(String url) {
        open(url);
        return this;
    }

    public MainPage setInputVacancy(String value) {

        inputVacancy.setValue(value);

        return this;
    }


    public MainPage clickToSearchButton() {

        searchButton.click();

        return this;
    }


}
