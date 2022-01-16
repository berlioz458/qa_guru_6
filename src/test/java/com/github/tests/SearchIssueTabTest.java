package com.github.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.pages.MainPage;
import com.github.pages.RepoPage;
import com.github.pages.SearchResultsPage;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchIssueTabTest {

    public static String REPOSITORY = "berlioz458/qa_guru_6";

    MainPage mainPage = new MainPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    RepoPage repoPage = new RepoPage();

    @Test
    @Owner("berlioz458")
    @Feature("IssueTab")
    @Story("Проверка вкладки Issue в репозитории (Лямбда шаги через step)")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldHaveIssueTabOnRepoPageLambdaStep() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий", () -> {
            $("[name=\"q\"]").setValue(REPOSITORY).pressEnter();
        });

        step("Переходим в репозиторий", () -> {
            $(By.linkText(REPOSITORY)).click();
        });

        step("Проверка наличия таба Issue", () -> {
            $("#issues-tab").shouldBe(Condition.visible);
        });

    }

    @Test
    @Owner("berlioz458")
    @Feature("IssueTab")
    @Story("Проверка вкладки Issue в репозитории(Шаги с аннотацией)")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldHaveIssueTabOnRepoPageAnnotatedStep() {
        mainPage.openPage().setQueryInput(REPOSITORY);
        searchResultsPage.goToRepo();
        repoPage.shouldSeeIssueTab();
    }

    @Test
    @Owner("berlioz458")
    @Feature("IssueTab")
    @Story("Проверка вкладки Issue в репозитории(Чистый Selenide)")
    @DisplayName("Проверка вкладки Issue в репозитории")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldHaveIssueTabOnRepoPageListenerStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $("[name=\"q\"]").setValue(REPOSITORY).pressEnter();
        $(By.linkText(REPOSITORY)).click();
        $("#issues-tab").shouldBe(Condition.visible);
    }
}
