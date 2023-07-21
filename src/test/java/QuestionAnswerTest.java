import ru.yandex.praktikum.core.BaseTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.page_object.MainPage;

import static ru.yandex.praktikum.constants.ExpectedText.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionAnswerTest extends BaseTest {
    private static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final int index;
    private final String expectedText;

    public QuestionAnswerTest(int index, String expectedText) {
        this.index = index;
        this.expectedText = expectedText;
    }


    @Parameterized.Parameters(name="Вопрос {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {0, FIRST_EXPECTED_ANSWER_TEXT},
                {1, SECOND_EXPECTED_ANSWER_TEXT},
                {2, THIRD_EXPECTED_ANSWER_TEXT},
                {3, FOURTH_EXPECTED_ANSWER_TEXT},
                {4, FIFTH_EXPECTED_ANSWER_TEXT},
                {5, SIXTH_EXPECTED_ANSWER_TEXT},
                {6, SEVENTH_EXPECTED_ANSWER_TEXT},
                {7, EIGHTH_EXPECTED_ANSWER_TEXT},

        };
    }

    @org.junit.Test
    public void test() {
        driver.get(BASE_URL);
        String actual = new MainPage()
                .acceptCookie()
                .scrollPageToQuestions()
                .getAnswerText(index);
        assertEquals(expectedText, actual);
    }
}
