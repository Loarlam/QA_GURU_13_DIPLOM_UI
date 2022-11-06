package ru.tele2.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class Tele2VacancySteps {
    private SelenideElement vacancy = $("#fieldOfVacancyName"),
            linkToAboutPage = $(byAttribute("href", "/about")),
            linkToVacancies = $(byAttribute("href", "/about/career/vacancies")),
            page = $(".page"),
            blockWithVacancy = $(".vacancy-card__item-name"),
            filter = $("#selectOfVacancyDivisions_listbox_active_option"),
            loginButton = $(".actions-container"),
            number = $("input[id=\"keycloakAuth.phone\"]"),
            password = $("input[id=\"keycloakAuth.password\"]"),
            submitButton = $("button[type=submit]"),
            errorTextLogin = $("span[class=error-text]"),
            errorTextPassword = $(".static-error-text"),
            subdivisionDropDown = $(".rw-multiselect-wrap"),
            errorTextVacancy = $(".vacancy-list__empty-filter-text");

    @Step("Открываем страницу \"https://msk.tele2.ru{linkValue}\"")
    public Tele2VacancySteps openingPage(String linkValue) {
        open(linkValue);
        return this;
    }

    @Step("Проверяем наличие \"{validateFieldValue}\" на странице")
    public Tele2VacancySteps checkingResultsOnPage(String validateFieldValue) {
        page.shouldHave(text(validateFieldValue));
        return this;
    }

    @Step("Url открытой страницы должен быть \"{validateUrl}\"")
    public Tele2VacancySteps checkingUrlOnPage(String validateUrl) {
        webdriver().shouldHave(url(validateUrl));
        return this;
    }

    @Step("Клик по кнопке входа в личный кабинет")
    public Tele2VacancySteps clickingOnLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Клик в поле ввода номера")
    public Tele2VacancySteps clickingInNumberFiled() {
        number.click();
        return this;
    }

    @Step("Клик в поле ввода пароля")
    public Tele2VacancySteps clickingInPasswordFiled() {
        password.click();
        return this;
    }

    @Step("Клик по кнопке \"{buttonText}\"")
    public Tele2VacancySteps clickingInPasswordButton(String buttonText) {
        $(byText(buttonText)).click();
        return this;
    }

    @Step("Ввод добавочной части номера \"{phoneNumber}\"")
    public Tele2VacancySteps enteringPhoneNumber (String phoneNumber) {
        number.setValue(phoneNumber);
        return this;
    }

    @Step("Ввод пароля \"{passwordSymbols}\"")
    public Tele2VacancySteps enteringPassword (String passwordSymbols) {
        password.setValue(passwordSymbols);
        return this;
    }

    @Step("Клик на кнопку подтверждения входа в форме входа")
    public Tele2VacancySteps clickingOnSubmit() {
        submitButton.click();
        return this;
    }

    @Step("Проверка текста ошибки в форме ввода логина")
    public Tele2VacancySteps checkingErrorTextLogin() {
        errorTextLogin.should(exist);
        return this;
    }

    @Step("Проверка текста ошибки в форме ввода пароля")
    public Tele2VacancySteps checkingErrorTextPassword(String errorText) {
        errorTextPassword.shouldHave(text(errorText)).shouldBe(visible);;
        return this;
    }

    @Step("Установить значение \"{searchedVacancy}\" в поле поиска")
    public Tele2VacancySteps settingValueInVacancySelection(String searchedVacancy) {
        vacancy.setValue(searchedVacancy);
        return this;
    }

    @Step("Проверяем наличие вакансий \"{vacancyOnPage}\" на странице")
    public Tele2VacancySteps findingVacancy(String vacancyOnPage) {
        blockWithVacancy.shouldHave(text(vacancyOnPage)).shouldBe(visible);
        return this;
    }

    @Step("Проверка наличия оибки с включением значения \"{errortext}\"")
    public Tele2VacancySteps findingErrorTextForVacancy(String errortext) {
        errorTextVacancy
                .shouldHave(text(String.format("Вакансий по запросу «%s» пока нет. Попробуйте искать по-другому или заходите попозже.", errortext)))
                .should(exist);
        return this;
    }

    @Step("Клик по выпадающему списку \"Все подразделения\"")
    public Tele2VacancySteps clickingOnSubdivision() {
        subdivisionDropDown.click();
        return this;
    }

    @Step("Выбрали первое значение из выпавшего списка \"Все подразделения\"")
    public Tele2VacancySteps choosingFilterOfSubdivision() {
        filter.click();
        return this;
    }

    @Step("Проверяем наличие вакансии на странице")
    public Tele2VacancySteps findingVacancy() {
        blockWithVacancy.shouldBe(visible);
        return this;
    }
}