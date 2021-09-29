package io.github.qaguru.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;
import static org.openqa.selenium.By.partialLinkText;
import static com.codeborne.selenide.Condition.*;

public class LambdaStepTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static Integer ISSUE_NUMBER = 68;

    @Test
    public void testGithub() {
        step("Открыть главную страницу GitHub", () -> {
            open("https://github.com");
        });
        step("Поиск репозитория " + REPOSITORY, () -> {
            $("[name=q]").setValue(REPOSITORY).pressEnter();
        });
        step("Перейти в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открыть раздел Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверить наличие репозитория с номером" + ISSUE_NUMBER, () -> {
            $(byText("#"+ ISSUE_NUMBER)).shouldBe(visible);
        });
    }

}
