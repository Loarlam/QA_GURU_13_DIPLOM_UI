package ru.tele2.tests;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class DataForTheTest {

    Faker fakerData = new Faker(Locale.FRANCE);
    Random random = new Random();

    String errorJobTitle = fakerData.job().position(),
            password = fakerData.internet().password(),
            phoneNumber = String.valueOf(random.nextInt(1000000000) + 9000000000L),
            baseUrl = "https://msk.tele2.ru",
            additionalPath = "/about/career/vacancies",
            h1Text = "Вакансии Tele2",
            jobTitle = "Руководитель",
            passwordButtonText = "По паролю",
            errorTextPassword = "Этот номер не принадлежит Tele2.";
}