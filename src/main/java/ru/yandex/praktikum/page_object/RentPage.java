package ru.yandex.praktikum.page_object;

import org.openqa.selenium.By;
import ru.yandex.praktikum.core.BasePage;

public class RentPage extends BasePage {
    //Поле выбора даты "Когда привезти самокат"
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Выбор значения в календаре
    private By calendarDateValue = By.xpath(".//div[@role='button' and text()='15']");

    //Поле "Срок аренды"
    private By rentalTimeField = By.cssSelector(".Dropdown-placeholder");

    //Период аренды "Сутки"
    private By rentalPeriod = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");

    //Поле для комментария
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Кнопка "Заказать" после заполнения полей
    private By makeAnOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка "Да" для оформления заказа
    private By confirmOrderButton = By.xpath(".//button[text()='Да']");

    //Кнопка "Посмотреть статус" после оформления заказа
    private By checkStatusButton = By.xpath(".//button[text()='Посмотреть статус']");

    /**
     * Метод заполнения полей на форме "Про аренду"
     */
    public RentPage fillRentDataFields(String comment) {
        driver.findElement(dateField).click();
        driver.findElement(calendarDateValue).click();
        driver.findElement(rentalTimeField).click();
        driver.findElement(rentalPeriod).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(makeAnOrderButton).click();
        driver.findElement(confirmOrderButton).click();
        return this;
    }

    /**
     * Метод для проверки доступности кнопки "Посмотреть статус" на форме подтверждения заказа
     */
    public boolean statusButtonIsDisplayed() {
        return driver.findElement(checkStatusButton).isDisplayed();
    }
}
