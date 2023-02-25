package ru.hh.pages;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PageObject {
    public PageObject openPage() {
        open("/");
        $("[data-qa=bloko-header-3]").shouldHave(Condition.text("Работа найдется для каждого"));
        return this;
    }
    
    public PageObject chooseSimpleSearch() {
        $("[data-qa=search-button]").shouldBe(visible, Duration.ofSeconds(40)).click();
        return this;
    }
    public PageObject searchCompanyByName(String value) {
        $("[data-hh-tab-id=employersList]").click();
        $(".bloko-input-text").setValue(value).pressEnter();
        return this;
    }

    public PageObject verifySearchCompanyByName(String value) {
        $("[data-qa=employers-list-company-list]").shouldHave(Condition.text(value));
        return this;
    }
    public PageObject verifyCompanyPageByCertainTextInclude(String value) {
        $(".tmpl_hh_wrapper").shouldHave(Condition.text(value));
        return this;
    }

    public PageObject chooseCompanyFromTheSearchResult(String value) {
        $("[data-qa=employers-list-company-list]").$(byText(value)).click();
        return this;
    }

    public PageObject chooseAdvancedSearch() {
        $("[data-qa=advanced-search]").shouldBe(visible, Duration.ofSeconds(40)).click();
        return this;
    }

    public PageObject fillAdvancedSearchByJavaAutoValue() {
        $("[data-qa=vacancysearch__keywords-input]").setValue("AQA Тинькофф Java");
        $(".bloko-tag-list").scrollTo();
        $("[data-qa=bloko-tag__cross]").click();
        $("[data-qa=advanced-search-submit-button]").click();

        return this;
    }

    public PageObject clickToFirstVacancy() {
        $(".serp-item__title").click();
        return this;
    }

    public PageObject verifyChosenStackInVacancyCard() {
        switchTo().window(1);
        $(".bloko-columns-row").shouldHave(Condition.text("Тинькофф"));
        $("[data-qa=vacancy-description]").shouldHave(Condition.text("Java"));
        $("[data-qa=vacancy-description]").shouldHave(Condition.text("автотест"));
        return this;
    }

    public PageObject fillAdvancedSearchByRemoteJobValue() {
        $("[data-qa=vacancysearch__keywords-input]").setValue("AQA");
        $(".bloko-tag-list").scrollTo();
        $("[data-qa=bloko-tag__cross]").click();
        $("[data-qa=advanced-search__schedule-item-label_remote]").scrollTo().click();
        $("[data-qa=advanced-search-submit-button]").click();
        return this;
    }

    public PageObject getRandomVacancyFromTheList(int value) {
        $x("//div[@id='a11y-main-content']//div[@class='serp-item'][" + value + "]" +
                "//a[@class='serp-item__title']").click();
        return this;
    }

    public PageObject verifyJobConditionsIsRemote() {
        switchTo().window(1);
        $("[data-qa=vacancy-view-employment-mode]").shouldHave(Condition.text("удаленная работа"));
        return this;
    }

    public PageObject iWantToWorkHereButtonClickAndVerifyOpenedPage() {
        $("[data-qa=resumeservice-button__targetemployer]").click();
        $(".account-login-page").shouldHave(Condition.text("Войдите на сайт"));
        return this;
    }
    public PageObject setNegativeEmailOnAccountEnterPage() {
        $("[data-qa=account-signup-email]").setValue("123").pressEnter();
        return this;
    }

    public PageObject verifyErrorOnEnterTheAccountPage() {
        $(".account-login-tile").shouldHave(Condition.text("Пожалуйста, укажите email или телефон"));
        return this;
    }

    public PageObject verifyCompanyCardButtonIWantToWorkHereExist() {
        $("[data-qa=resumeservice-button__targetemployer]").shouldBe(Condition.visible).
                shouldHave(Condition.text("Я хочу тут работать"));
        return this;
    }

}
