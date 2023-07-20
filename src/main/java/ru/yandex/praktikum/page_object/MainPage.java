package ru.yandex.praktikum.page_object;

import ru.yandex.praktikum.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends BasePage {
    //Кнопка для принятия Cookie
    private By acceptCookie = By.xpath(".//button[@id='rcc-confirm-button']");

    //Кнопка "Заказать" в верху страницы
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Общий локатор для вопросов
    private By questionButton = By.xpath(".//div[@class='accordion__button']");


    /**
     * Метод для принятия Cookie
     */
    public MainPage acceptCookie() {
        if (driver.findElement(acceptCookie).isDisplayed()) {
            driver.findElement(acceptCookie).click();
        }
        return this;
    }

    /**
     * Метод для нажатия на кнопку заказа вверху страницы
     */
    public OrderPage orderButtonClick() {
        driver.findElement(orderButton).click();
        return new OrderPage();
    }


    /**
     * Метод прокручивает страницу к вопросам
     */
    public MainPage scrollPageToQuestions() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionButton));
        return this;
    }

    /**
     * Метод кликает на один из вопросов
     */
    public MainPage clickOnQuestion(int index) {
        By someQuestion = By.xpath(".//div[id='accordion__heading-" + index + "']");
        driver.findElements(questionButton).get(index).click();
        return this;
    }

    /**
     * Метод для получения текста ответа в зависимости от вопроса
     */
    public String getAnswerText(int index) {
        By answer = By.xpath(".//div[@id='accordion__panel-" + index + "']/p");
        clickOnQuestion(index);
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(answer)).getText();

    }


}

