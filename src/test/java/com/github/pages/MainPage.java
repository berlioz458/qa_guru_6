package com.github.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    SelenideElement queryInput = $("[name=\"q\"]");

    @Step("Открытие главной странцы")
    public MainPage openPage(){
        open("https://github.com");
        return this;
    }

    @Step("Ищем репозиторий")
    public MainPage setQueryInput(String value) {
        queryInput.setValue(value).pressEnter();

        return this;
    }
}
