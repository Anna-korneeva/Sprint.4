package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FAQPage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;
    public static final By answer_8 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");

    private By closeButtonCookie = By.cssSelector("button.App_CookieButton__3cvqF");
    public static final By answer_7 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");

    public static final By answer_6 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");

    public static final By answer_5 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");

    public static final By answer_4 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");

    public static final By answer_3 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");

    public static final By answer_2 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");

    public static final By answer_1 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");

    private By table = By.xpath(".//div[@class='accordion']");



    public FAQPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAnswerDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public String getAnswerText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void clickQuestion(int numberQuestion) {
        driver.findElement(By.id("accordion__heading-" + numberQuestion)).click();
    }

    public void scrollTable() {
        WebElement tableFAQ = driver.findElement(table);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);

    }
    public void clickCloseButtonCookie() {
        driver.findElement(closeButtonCookie).click();
    }

    public void openPage() {
        driver.get(URL);
    }

}

