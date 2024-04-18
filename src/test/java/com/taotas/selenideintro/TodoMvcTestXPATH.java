package com.taotas.selenideintro;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.bidi.script.LocalValue.setValue;

public class TodoMvcTestXPATH {
    @Test
    void completesTask(){
    open("https://todomvc.com/examples/emberjs/todomvc/dist/");
        SelenideElement NewTodo = element(By.xpath("[@class='new-todo']"));
        SelenideElement Toggle = element(By.xpath("[@class = 'toggle']"));
        SelenideElement Completed = element(By.xpath("[@class = 'completed']"));
        ElementsCollection TodoList = elements(By.xpath("[@class='todo-list>li']"));

        NewTodo.setValue("a").pressEnter();
        NewTodo.setValue("b").pressEnter();
        NewTodo.setValue("c").pressEnter();
        TodoList.shouldHave(exactTexts("a", "b", "c"));
        NewTodo.find(String.valueOf(exactText("b")))
            .find(String.valueOf(Toggle)).click();
        TodoList.filterBy((WebElementCondition) Completed)
            .shouldHave(exactTexts("b"));
        TodoList.filterBy(not((WebElementCondition) Completed))
            .shouldHave(exactTexts("a","c"));
    }
}
