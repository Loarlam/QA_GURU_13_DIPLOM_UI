package ru.tele2.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Tele2VacanciesTest extends TestBase {
    @Test
    @Tag("tele2")
    @Owner("Loarlam")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка некорректного ввода номера телефона для входа в аккаунт")
    void checkingInvalidNumber() {
        tele2VacancySteps.openingPage(dataForTheTest.additionalPath)
                .checkingResultsOnPage(dataForTheTest.h1Text)
                .checkingUrlOnPage(dataForTheTest.baseUrl + dataForTheTest.additionalPath)
                .clickingOnLoginButton()
                .clickingInNumberFiled()
                .clickingOnSubmit()
                .checkingErrorTextLogin();
    }

    @Test
    @Tag("tele2")
    @Owner("Loarlam")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка некорректного ввода пароля для входа в аккаунт")
    void checkingInvalidPassword() {
        tele2VacancySteps.openingPage(dataForTheTest.additionalPath)
                .checkingResultsOnPage(dataForTheTest.h1Text)
                .checkingUrlOnPage(dataForTheTest.baseUrl + dataForTheTest.additionalPath)
                .clickingOnLoginButton()
                .clickingInPasswordButton(dataForTheTest.passwordButtonText)
                .clickingInNumberFiled()
                .enteringPhoneNumber(dataForTheTest.phoneNumber)
                .clickingInPasswordFiled()
                .enteringPassword(dataForTheTest.password)
                .clickingOnSubmit()
                .checkingErrorTextPassword(dataForTheTest.errorTextPassword);
    }

    @Test
    @Tag("tele2")
    @Owner("Loarlam")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск вакансии через ввод на странице \"Вакансии Tele2\"")
    void checkingTheEnteredVacancy() {
        tele2VacancySteps.openingPage(dataForTheTest.additionalPath)
                .checkingResultsOnPage(dataForTheTest.h1Text)
                .settingValueInVacancySelection(dataForTheTest.jobTitle)
                .findingVacancy(dataForTheTest.jobTitle);
    }

    @Test
    @Tag("tele2")
    @Owner("Loarlam")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка ввода некорректного значения для поика вакансии")
    void successfulTest() {
        tele2VacancySteps.openingPage(dataForTheTest.additionalPath)
                .checkingResultsOnPage(dataForTheTest.h1Text)
                .settingValueInVacancySelection(dataForTheTest.errorJobTitle)
                .findingErrorTextForVacancy(dataForTheTest.errorJobTitle);
    }

    @Test
    @Tag("tele2")
    @Owner("Loarlam")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск вакансии по подразделениям на странице \"Вакансии Tele2\"")
    void checkingVacanciesWithSubdivisionSearch() {
        tele2VacancySteps.openingPage(dataForTheTest.additionalPath)
                .checkingResultsOnPage(dataForTheTest.h1Text)
                .clickingOnSubdivision()
                .choosingFilterOfSubdivision()
                .findingVacancy();
    }
}