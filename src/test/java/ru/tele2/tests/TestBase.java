package ru.tele2.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import ru.tele2.attachments.AttachmentsForReport;
import ru.tele2.config.CredentialsConfig;
import ru.tele2.pages.Tele2VacancySteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.qameta.allure.Allure.step;

public class TestBase {
    Tele2VacancySteps tele2VacancySteps = new Tele2VacancySteps();
    static DataForTheTest dataForTheTest = new DataForTheTest();
    static CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void beforeAllTests() {
        SelenideLogger.addListener("Allure", new AllureSelenide());

        Configuration.remote = String.format("https://%s:%s@%s", credentialsConfig.login(), credentialsConfig.password(), credentialsConfig.remoteLink());
        Configuration.baseUrl = dataForTheTest.baseUrl;
        Configuration.browserPosition = credentialsConfig.position();
        Configuration.browser = credentialsConfig.browser();
        Configuration.browserVersion = credentialsConfig.version();
        Configuration.browserSize = credentialsConfig.resolution();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void afterAllTests() {
        AttachmentsForReport.attachScreenshot();
        AttachmentsForReport.pageSource();
        AttachmentsForReport.browserConsoleLogs();
        AttachmentsForReport.addVideo();
        step("Close driver", Selenide::closeWebDriver);
    }
}