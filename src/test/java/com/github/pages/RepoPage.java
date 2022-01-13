package com.github.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class RepoPage {
    public SelenideElement issueTab = $("#issues-tab");

    @Step("Проверка наличия таба Issue")
    public void shouldSeeIssueTab() {
        issueTab.shouldBe(Condition.visible);
    }

}
