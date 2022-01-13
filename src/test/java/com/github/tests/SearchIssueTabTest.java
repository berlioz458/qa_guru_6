package com.github.tests;

import com.codeborne.selenide.Condition;
import com.github.pages.MainPage;
import com.github.pages.RepoPage;
import com.github.pages.SearchResultsPage;
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
    public void shouldHaveIssueTabOnRepoPageWebStep() {
        mainPage.openPage().setQueryInput(REPOSITORY);
        searchResultsPage.goToRepo();
        repoPage.shouldSeeIssueTab();
    }
}
