package ru.hh.tests;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

@Tag("remote")
public class SearchJobByStackTest extends TestBase {
    @Test
    @Owner("amenkova")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "hh.ru", url = "https://hh.ru")
    @DisplayName("Ищем конкретную вакансию и проверяем нужный стек")
    void searchSpecificJobByName(){

        step("Открыть hh.ru", () -> {
            pageObject.openPage();
        });

        step("Выбрать расширенный поиск", () -> {
            pageObject.chooseAdvancedSearch();
        });

        step("Заполнить поля расширенного поиска и выполнить поиск вакансий AQA JAVA", () -> {
            pageObject.fillAdvancedSearchByJavaAutoValue();
        });

        step("Выбрать первую вакансию", () -> {
            pageObject.clickToFirstVacancy();
        });

        step("Проверить верный ли стэк в карточке", () -> {
            pageObject.verifyChosenStackInVacancyCard();
        });
    }
}
