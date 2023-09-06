package ru.hh.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import static com.codeborne.selenide.ElementsCollection.texts;
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

    public SearchResults assertFilterValue(String locator , List<String> value) {
        $$(locator).filter(text(locator)).should(texts(value));
        return this;
    }


}

