package com.taotas.selenideintro;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class GoogleTest {
    @Test
    void shouldSearch(){
        open("https://google.com/ncr");
        element(byName("q")).setValue("selenide").pressEnter();
        elements("#search .g").shouldHave(sizeGreaterThanOrEqual(10))
                .first().shouldHave(text("Selenide: concise UI tests in Java"))
                .find(".yuRUbf").click();
        Wait().until(titleIs("Selenide: concise UI tests in Java"));

    }
}
