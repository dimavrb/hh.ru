package ru.hh.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.hh.pages.MainPage;
import ru.hh.pages.SearchResults;


public class SearchVacancyTest extends TestBase {
    static MainPage mainPage = new MainPage();
    SearchResults searchResults = new SearchResults();

    @CsvSource({"Водитель", "Менеджер",})

    @ParameterizedTest(name = "Проверка поиска вакансии {0}")
    @Tag("web")
    void searchVacancy(String vacancy) {
        mainPage.openPage("");
        mainPage.setInputVacancy(vacancy);
        mainPage.clickToSearchButton();
        searchResults.assertResultSearch(vacancy);


    }

    @Test

    @DisplayName("Проверка поиска пустой строки")
    void searchEmptyVacancy() {

        mainPage.openPage("");
        mainPage.setInputVacancy("");
        mainPage.clickToSearchButton();
        searchResults.assertResultSearch("Найдено");


    }

    @Test
    @Tag("full-regress")
    @DisplayName("Проверка поиска несуществующей вакансии")
    void searchFail() {

        mainPage.openPage("");
        mainPage.setInputVacancy("Несуществующая вакансия");
        mainPage.clickToSearchButton();
        searchResults.assertResultSearch("ничего не найдено");


    }

    @ValueSource(strings = {"Подработка", "Исключить слова", "Уровень дохода", "Регион"})
    @ParameterizedTest(name = "Проверка наличия фильтра {0}")

    @Tag("full-regress")
    void shouldFilter(String value) {

        mainPage.openPage("");
        mainPage.setInputVacancy("Водитель");
        mainPage.clickToSearchButton();
        searchResults.assertFilter(value);

    }


    @CsvFileSource(resources = "/test.csv")
    @ParameterizedTest(name = "Проверка наличия значения {0} в фильтре")
    @Tag("full-regress")
    void shouldFilterSubCategory(String vacancy) {

        mainPage.openPage("");
        mainPage.setInputVacancy(vacancy);
        mainPage.clickToSearchButton();
        searchResults.assertResultSearch(vacancy);


    }
}