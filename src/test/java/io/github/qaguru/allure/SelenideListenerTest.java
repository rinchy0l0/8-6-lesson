package io.github.qaguru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;
import static com.codeborne.selenide.Condition.*;

public class SelenideListenerTest {

    @Test
    public void testGithub() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $("[name=q]").as("Поисковая строка").setValue("eroshenkoam/allure-example").pressEnter();
        $(linkText("eroshenkoam/allure-example")).as("Ссылка на репозиторий").click();
        $(partialLinkText("Issues")).as("Таб на Issues").click();
        $(byText("68")).as("Issue с номером 68").shouldBe(visible);
    }

}
