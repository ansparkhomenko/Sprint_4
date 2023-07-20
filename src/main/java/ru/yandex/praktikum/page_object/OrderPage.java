package ru.yandex.praktikum.page_object;

import ru.yandex.praktikum.core.BasePage;
import org.openqa.selenium.By;

public class OrderPage extends BasePage {
    //Поле "Имя"
    private By nameField = By.xpath(".//*[@placeholder='* Имя']");

    //Поле "Фамилия"
    private By sureNameField = By.xpath(".//*[@placeholder='* Фамилия']");

    //Поле "Станция метро"
    private By stationField = By.cssSelector(".select-search__value");

    //Выбор станции метро
    private By stationButton = By.xpath("//button[@value='10']");

    //Поле для ввода номера телефона
    private By telephoneNumberField = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка "Далее"
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    /**
     * Метод заполнения полей на форме "Для кого самокат"
     */
    public OrderPage fillOrderDataField(String nameValue, String surnameValue, String telephoneNumberValue) {
        driver.findElement(nameField).sendKeys(nameValue);
        driver.findElement(sureNameField).sendKeys(surnameValue);
        driver.findElement(stationField).click();
        driver.findElement(stationButton).click();
        driver.findElement(telephoneNumberField).sendKeys(telephoneNumberValue);
        driver.findElement(nextButton).click();
        return new OrderPage();

    }
}
