package ru.hh.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class AllTests extends TestBase {
    @Test
    @DisplayName("Тест на поиск вакансии удаленно и проверка любой выпавшей из посика на включение слова")
    void searchForRemoteJob() {
        open("/");
        $("[data-qa=advanced-search]").shouldBe(visible, Duration.ofSeconds(40)).click();
        $("[data-qa=vacancysearch__keywords-input]").setValue("AQA");
        $(".bloko-tag-list").scrollTo();
        $("[data-qa=bloko-tag__cross]").click();
        $("[data-qa=advanced-search__schedule-item-label_remote]").scrollTo().click();
        $("[data-qa=advanced-search-submit-button]").click();
        $x("//div[@id='a11y-main-content']//div[@class='serp-item'][7]//a[@class='serp-item__title']").click();
        switchTo().window(1);
        $("[data-qa=vacancy-view-employment-mode]").shouldHave(Condition.text("удаленная работа"));
    }

    @Test
    @DisplayName("Ищем конкретную вакансию и проверяем нужный стек")
    void searchSpecificJobByName(){
        open("/");
        $("[data-qa=advanced-search]").shouldBe(visible, Duration.ofSeconds(40)).click();
        $("[data-qa=vacancysearch__keywords-input]").setValue("AQA Тинькофф Java");
        $(".bloko-tag-list").scrollTo();
        $("[data-qa=bloko-tag__cross]").click();
        $("[data-qa=advanced-search-submit-button]").click();
        $(".serp-item__title").click();
        switchTo().window(1);
        $(".bloko-columns-row").shouldHave(Condition.text("Тинькофф"));
        $("[data-qa=vacancy-description]").shouldHave(Condition.text("Java"));
        $("[data-qa=vacancy-description]").shouldHave(Condition.text("автотест"));
    }


    @Test
    @DisplayName("Проверка ввода некорректного email после нажатия \"Я хочу тут работать\"")
    void iWantToWorkHereClickAndSetNegativeEmail() {
        open("/");
        $("[data-qa=search-button]").click();
        $("[data-hh-tab-id=employersList]").click();
        $(".bloko-input-text").setValue("Тинькофф").pressEnter();
        $("[data-qa=employers-list-company-list]").shouldHave(Condition.text("Тинькофф"));
        $("[data-qa=employers-list-company-list]").$(byText("Тинькофф")).click();
        $(".tmpl_hh_wrapper").shouldHave(Condition.text("Тинькофф — финансовая экосистема для 25 млн клиентов"));
        $("[data-qa=resumeservice-button__targetemployer]").click();
        $(".account-login-page").shouldHave(Condition.text("Войдите на сайт"));
        $("[data-qa=account-signup-email]").setValue("123").pressEnter();
        $(".account-login-tile").shouldHave(Condition.text("Пожалуйста, укажите email или телефон"));
    }


    @ValueSource(
            strings = {"Х5 Group",
                    "Тинькофф",
                    "IBS"
            }
    )
    @ParameterizedTest(name = "В карточке компании {0} присутствует кнопка \"Я хочу тут работать\"")//x5 group, Positive Technologies, ibs
    void iWantToWorkHerePresentOnCompanyPage(String companyName) {
        open("/");
        $("[data-qa=search-button]").click();
        $("[data-hh-tab-id=employersList]").click();
        $(".bloko-input-text").setValue(companyName).pressEnter();
        $("[data-qa=employers-list-company-list]").shouldHave(Condition.text(companyName));
        $("[data-qa=employers-list-company-list]").$(byText(companyName)).click();
        $("[data-qa=resumeservice-button__targetemployer]").shouldBe(visible).
                shouldHave(Condition.text("Я хочу тут работать"));
    }
    @Test
    @DisplayName("Ищем компанию Тинькофф и проверяем инфу о ней")
    void findCompany() {
        open("/");
        $("[data-qa=search-button]").shouldBe(visible, Duration.ofSeconds(40)).click();
        $("[data-hh-tab-id=employersList]").click();
        $(".bloko-input-text").setValue("Тинькофф").pressEnter();
        $("[data-qa=employers-list-company-list]").shouldHave(Condition.text("Тинькофф"));
        $("[data-qa=employers-list-company-list]").$(byText("Тинькофф")).click();
        $(".tmpl_hh_wrapper").shouldHave(Condition.text("Тинькофф — финансовая экосистема для 25 млн клиентов"));
    }
}
