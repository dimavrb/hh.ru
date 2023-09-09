package ru.hh.pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResults {

    SelenideElement
            result = $(By.cssSelector("div[data-qa='vacancies-search-header'")),
            filter = $(By.cssSelector("aside[data-qa='serp__criterias'"));

    public SearchResults assertResultSearch(String value) {
        result.shouldHave(text(value));

        return this;
    }

    public SearchResults assertFilter(String value) {
        filter.shouldHave(text(value));

        return this;
    }


}

