package ru.hh.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static io.qameta.allure.Allure.step;

@Tag("remote")
public class IWantToWorkHereTests extends TestBase{
    @Test
    @Owner("amenkova")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "hh.ru", url = "https://hh.ru")
    @DisplayName("Проверка ввода некорректного email после нажатия \"Я хочу тут работать\"")
    void iWantToWorkHereClickAndSetNegativeEmail() {

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

        step("Нажатие на кнопку Я хочу тут работать и проверка открытой страницы", () -> {
            pageObject.iWantToWorkHereButtonClickAndVerifyOpenedPage();
        });

        step("Ввод некорректного email", () -> {
            pageObject.setNegativeEmailOnAccountEnterPage();
        });

        step("Проверка текста ошибки", () -> {
            pageObject.verifyErrorOnEnterTheAccountPage();
        });
    }


    @ValueSource(
            strings = {"Х5 Group",
                    "Тинькофф",
                    "IBS"
            }
    )
    @ParameterizedTest(name = "В карточке компании {0} присутствует кнопка \"Я хочу тут работать\"")
    @Owner("amenkova")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "hh.ru", url = "https://hh.ru")
    void iWantToWorkHerePresentOnCompanyPage(String companyName) {
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

        step("Выбор нужной компании в выдаче поиска", () -> {
            pageObject.verifyCompanyCardButtonIWantToWorkHereExist();
        });
    }
}
