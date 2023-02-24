package ru.hh.tests;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("remote")
public class SearchCompanyTest extends TestBase {

    @Test
    @Owner("amenkova")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "hh.ru", url = "https://hh.ru")
    @DisplayName("Поиск компании, переход в карточку, проверка верности карточки")
    void findCompany() {

        step("Открыть hh.ru", () -> {
            pageObject.openPage();
        });

        step("Нажать на кнопку поиска", () -> {
            pageObject.chooseSimpleSearch();
        });

        step("Поиск компании по наименованию", () -> {
            pageObject.searchCompanyByName(testData.company);
        });

        step("Проверка нужной компании в выдаче поиска", () -> {
            pageObject.verifySearchCompanyByName(testData.company);
        });

        step("Выбор нужной компании в выдаче поиска", () -> {
            pageObject.chooseCompanyFromTheSearchResult(testData.company);
        });

        step("Проверка на включение заданного текста на карточке компании", () -> {
            pageObject.verifyCompanyPageByCertainTextInclude(testData.company);
        });
    }
}
