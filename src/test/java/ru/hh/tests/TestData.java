package ru.hh.tests;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;

public class TestData {

    String company = "Тинькофф";
    String companyPageText = "Тинькофф — финансовая экосистема для 25 млн клиентов";

    int getJobNumber() {
        String jobCountString = Selenide.$x("//*[text()='Удаленная работа']" +
                "//following::span//span[@class='bloko-text bloko-text_tertiary']").getOwnText();
        int jobCount = Integer.parseInt(jobCountString);
        Faker faker = new Faker();
        int jobNumber = faker.number().numberBetween(1, jobCount);
        return jobNumber;
    }

}
