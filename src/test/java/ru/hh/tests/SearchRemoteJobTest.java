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
public class SearchRemoteJobTest extends TestBase {

    @Test
    @Owner("amenkova")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "hh.ru", url = "https://hh.ru")
    @DisplayName("Поиск вакансии \"удаленная работа\" и проверка любой выпавшей в поиске на наличие этого условия")
    void searchForRemoteJob() {

        step("Открыть hh.ru", () -> {
            pageObject.openPage();
        });

        step("Выбрать расширенный поиск", () -> {
            pageObject.chooseAdvancedSearch();
        });

        step("Заполнить поля расширенного поиска и выполнить поиск вакансий удаленно", () -> {
            pageObject.fillAdvancedSearchByRemoteJobValue();
        });

        step("Выбрать случайную вакансию из списка", () -> {
            pageObject.getRandomVacancyFromTheList(testData.getJobNumber());
        });

        step("Проверить, что в карточке вакансии указано условие: удаленная работа", () -> {
            pageObject.verifyJobConditionsIsRemote();
        });
    }
}

