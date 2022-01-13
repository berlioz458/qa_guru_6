package com.github.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {
    SelenideElement searchResultsItem = $(By.linkText("berlioz458/qa_guru_6"));

    @Step("Переходим в репозиторий")
    public void goToRepo() {
        searchResultsItem.click();
    }
}
