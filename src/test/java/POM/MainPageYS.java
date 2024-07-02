package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static Sourses.ConstatnsText.getExpectedURLYandexComeBack;
import static Sourses.ConstatnsText.mainPageYsURL;
import static org.junit.Assert.assertEquals;

public class MainPageYS {
    private WebDriver driver;

    public MainPageYS (WebDriver driver) {
        this.driver = driver;
    }

    //Открыть главную страницу сервиса "Яндекс.Самокат"

    //Кнопка "Заказать" в хедере
    private By OrderButtonHeader = By.className("Button_Button__ra12g");

    //Клик по кнопке "Заказать" в хедере
    public void orderButtonHeaderClick() {
        driver.findElement(OrderButtonHeader).click();
    }

    //Кнопка "Заказать" в центральной части страницы
    private By OrderButtonMiddle = By.className("Button_Middle__1CSJM");

    //Скролл до кнопки "Заказать" и клик по ней
    public MainPageYS orderButtonMiddleClick() {
        WebElement element = driver.findElement(OrderButtonMiddle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(OrderButtonMiddle).click();
        return this;
    }
    //Метод выбора кнопки для заказа
    public void chooseOrderButton (String typeOrderButton) {
        switch (typeOrderButton) {
            case ("Header"):
                orderButtonHeaderClick();
                break;
            case ("Middle"):
                orderButtonMiddleClick();
                break;
        }
    }

        //Локаторы кнопкок вопросов раздела "Вопросы о важном"
        private By buttonQuestions_0 = By.id("accordion__heading-0");
        private By buttonQuestions_1 = By.id("accordion__heading-1");
        private By buttonQuestions_2 = By.id("accordion__heading-2");
        private By buttonQuestions_3 = By.id("accordion__heading-3");
        private By buttonQuestions_4 = By.id("accordion__heading-4");
        private By buttonQuestions_5 = By.id("accordion__heading-5");
        private By buttonQuestions_6 = By.id("accordion__heading-6");
        private By buttonQuestions_7 = By.id("accordion__heading-7");

        //Массив кнопкок вопросов раздела "Вопросы о важном"
        private By[] buttonQuestionsArray = {
                buttonQuestions_0,
                buttonQuestions_1,
                buttonQuestions_2,
                buttonQuestions_3,
                buttonQuestions_4,
                buttonQuestions_5,
                buttonQuestions_6,
                buttonQuestions_7
        };
        //Метод клика по идексу вопроса массива из раздела "Вопросы о важном" с ожиданием анимации раскрытия поля ответа
        public void questionButtonClick(int Index) {
            By indexChosen = buttonQuestionsArray[Index];
            WebElement element = driver.findElement(indexChosen);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(indexChosen));
            driver.findElement(indexChosen).click();
    }

        //Локаторы поля ответа их раздела "Вопросы о важном"
        private By answerField_0 = By.xpath(".//div[@id='accordion__panel-0']/p");
        private By answerField_1 = By.xpath(".//div[@id='accordion__panel-1']/p");
        private By answerField_2 = By.xpath(".//div[@id='accordion__panel-2']/p");
        private By answerField_3 = By.xpath(".//div[@id='accordion__panel-3']/p");
        private By answerField_4 = By.xpath(".//div[@id='accordion__panel-4']/p");
        private By answerField_5 = By.xpath(".//div[@id='accordion__panel-5']/p");
        private By answerField_6 = By.xpath(".//div[@id='accordion__panel-6']/p");
        private By answerField_7 = By.xpath(".//div[@id='accordion__panel-7']/p");

        //Массив полей ответов их раздела "Вопросы о важном"
        private By[] answerFieldArray = {answerField_0,
                answerField_1,
                answerField_2,
                answerField_3,
                answerField_4,
                answerField_5,
                answerField_6,
                answerField_7
        };


        public String getAnswers(int Index) {
            By indexChosen = answerFieldArray[Index];
            return driver.findElement(indexChosen).getText();
        }

    private By headerScooterLink = By.className("Header_LogoScooter__3lsAR");
    private By headerYandexLink = By.className("Header_LogoYandex__3TSOI");
    private By headerOrderStatus = By.className("Header_Link__1TAG7");
    private By headerOrderStatusField = By.xpath(".//input[@placeholder = 'Введите номер заказа']");
    private By headerOrderApproveButton = By.xpath(".//button[@class = 'Button_Button__ra12g Header_Button__28dPO']");


    public void headerScooterCheckUrl() {
        driver.findElement(headerScooterLink).click();
        String currentPage=driver.getCurrentUrl();
        assertEquals(currentPage, mainPageYsURL);
    }

    public void headerYandexCheckUrl() {
        String mainTab = driver.getWindowHandle();
        driver.findElement(headerYandexLink).click();
        for (String tab: driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        String newPage = driver.getCurrentUrl();
        driver.switchTo().window(mainTab);
        assertEquals(newPage, getExpectedURLYandexComeBack);
    }

    public MainPageYS headerStatusOrderFinder(String numberOrder) {
        driver.findElement(headerOrderStatus).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(headerOrderStatusField));
        driver.findElement(headerOrderStatusField).sendKeys(numberOrder);
        driver.findElement(headerOrderApproveButton).click();
        return this;
    }









}
