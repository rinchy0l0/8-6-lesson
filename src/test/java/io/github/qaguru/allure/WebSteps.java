package io.github.qaguru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchRepository(String repo) {
        $("[name=q]").setValue(repo).pressEnter();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Открываем разедел Issues")
    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем наличие Issue с номером {number}")
    public void shouldHaveIssueWithNumber(int number) {
        $(byText("#"+ number)).shouldBe(visible);
    }
}
