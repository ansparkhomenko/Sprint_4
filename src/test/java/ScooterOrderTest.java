import ru.yandex.praktikum.core.BaseTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.page_object.MainPage;

import ru.yandex.praktikum.page_object.RentPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ScooterOrderTest extends BaseTest {
    private static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    private final String name;
    private final String surName;
    private final String phoneNumber;
    private final String comment;

    public ScooterOrderTest(String name, String surName, String phoneNumber, String comment) {
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Клиент {index}: Имя: {0} {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Майкл", "Джексон", "89255286796", "Позвонить за 5 минут"},
                {"Джон", "Коннор", "89035214577", "Оставить у входа"},
                {"Бритни", "Спирс", "89261234568", "Стою на автобусной остоновке"}
        };
    }

    @Test
    public void scooterOrder() {
        driver.get(BASE_URL);
        new MainPage()
                .acceptCookie()
                .orderButtonClick()
                .fillOrderDataField(name, surName, phoneNumber);

        boolean actual = new RentPage()
                .fillRentDataFields(comment)
                .statusButtonIsDisplayed();

        assertTrue("Заказ не оформлен", actual);
    }
}
