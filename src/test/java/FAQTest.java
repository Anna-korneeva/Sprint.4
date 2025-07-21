import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.FAQPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class FAQTest extends BaseTest1 {
    private WebDriver driver;
    private final int questionIndex;
    private final By answerLocator;
    private final String expectedAnswer;

    public FAQTest(int questionIndex, By answerLocator, String expectedAnswer) {
        this.questionIndex = questionIndex;
        this.answerLocator = answerLocator;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionAnswerPairs() {
        return new Object[][] {
                {0, FAQPage.answer_1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, FAQPage.answer_2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, FAQPage.answer_3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, FAQPage.answer_4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, FAQPage.answer_5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, FAQPage.answer_6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, FAQPage.answer_7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, FAQPage.answer_8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }


    @Test
    public void FAQCorrectAnswer() throws InterruptedException {

        // Открыть домашнюю страницу Яндекс самокат
        faqPage.openPage();

        // Найти куку и кликнуть по ее кнопке для закрытия
        faqPage.clickCloseButtonCookie();

        // Проскролить страницу до появления таблицы
        faqPage.scrollTable();

        // Нажать на вопрос

        faqPage.clickQuestion(questionIndex);

        // Получить ответ на вопрос
        assertTrue(faqPage.isAnswerDisplayed(answerLocator));
        assertTrue(faqPage.getAnswerText(answerLocator).contains(expectedAnswer));


    }

}

