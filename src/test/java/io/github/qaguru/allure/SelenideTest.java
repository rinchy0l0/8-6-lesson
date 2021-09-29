package io.github.qaguru.allure;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;
import static com.codeborne.selenide.Condition.*;


public class SelenideTest {

    @Test
    public void testGithub() {
        open("https://github.com");
        $("[name=q]").setValue("eroshenkoam/allure-example").pressEnter();
        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("Issues")).click();
        $(byText("68")).shouldBe(visible);
    }

}
