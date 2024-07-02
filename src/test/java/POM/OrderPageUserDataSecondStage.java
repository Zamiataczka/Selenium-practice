package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//Второй стейдж формы заказа
public class OrderPageUserDataSecondStage {
    private WebDriver driver;

    public OrderPageUserDataSecondStage (WebDriver driver) {
        this.driver = driver;
    }

    //Поле даты доставки
    private By whenDeliverField = By.xpath(".//input[@placeholder ='* Когда привезти самокат']");

    //Поле срока аренды
    private By rentalPeriodField = By.className("Dropdown-placeholder");

    //Подполе с выбор срока аренды по дням
    private By rentalPeriod_1 = By.xpath(".//*[@class='Dropdown-option'][1]");

    private By rentalPeriod_2 = By.xpath(".//*[@class='Dropdown-option'][2]");

    private By rentalPeriod_3 = By.xpath(".//*[@class='Dropdown-option'][3]");

    private By rentalPeriod_4 = By.xpath(".//*[@class='Dropdown-option'][4]");

    private By rentalPeriod_5 = By.xpath(".//*[@class='Dropdown-option'][5]");

    private By rentalPeriod_6 = By.xpath(".//*[@class='Dropdown-option'][6]");

    private By rentalPeriod_7 = By.xpath(".//*[@class='Dropdown-option'][7]");

    //Чекбокс с черным цветом самоката
    private By colourBlackScooter = By.xpath(".//label[@for ='black']");
    //Чекбокс с серым цветом самоката
    private By colourGreyScooter = By.xpath(".//label[@for ='grey']");

    //Поле комментария
    private By commentField = By.xpath(".//input[@placeholder ='Комментарий для курьера']");

    //Кнопка "Заказать"
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //Метод с вводом даты и нажанием ввода для фиксации даты доставки
    public void SendWhenDeliver(String userDataDeliver) {
        driver.findElement(whenDeliverField).sendKeys(userDataDeliver);
        driver.findElement(whenDeliverField).sendKeys(Keys.ENTER);
    }

    //Метод выбора срока аренды
    public void chooseRentalPeriod (String typeButton) {
        driver.findElement(rentalPeriodField).click();
        switch (typeButton) {
            case ("1"):
                driver.findElement(rentalPeriod_1).click();
                break;
            case ("2"):
                driver.findElement(rentalPeriod_2).click();
                break;
            case ("3"):
                driver.findElement(rentalPeriod_3).click();
                break;
            case ("4"):
                driver.findElement(rentalPeriod_4).click();
                break;
            case ("5"):
                driver.findElement(rentalPeriod_5).click();
                break;
            case ("6"):
                driver.findElement(rentalPeriod_6).click();
                break;
            case ("7"):
                driver.findElement(rentalPeriod_7).click();
                break;
        }
    }

    //Методы для выбора в чекбоксе цвета самоката
    public void clickBlackColourScooter() {
        driver.findElement(colourBlackScooter).click();
    }
    public void clickGreyColourScooter() {
        driver.findElement(colourGreyScooter).click();
    }
    public void chooseColourScooter (String colourButton) {
        switch (colourButton) {
            case ("Black"):
                clickBlackColourScooter();
                break;
            case ("Grey"):
                clickGreyColourScooter();
                break;
        }
    }

    //Метод для заполнения поля Комментария
    public OrderPageUserDataSecondStage sendComment(String userComment) {
        driver.findElement(commentField).sendKeys(userComment);
        return this;
    }

    //Метод для нажатия кнопки "Заказать"
    public OrderPageUserDataSecondStage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    ////Метод для заполнения второго стейджа данных для заказа и перехода на третий стейдж
    public OrderPageUserDataSecondStage secondStageOrderUserData(String userDataDeliver, String typeButton, String colourButton, String userComment) {
        SendWhenDeliver(userDataDeliver);
        chooseRentalPeriod(typeButton);
        chooseColourScooter(colourButton);
        sendComment(userComment);
        new WebDriverWait(driver, Duration.ofSeconds(5));
        clickOrderButton();
        return this;
    }
}
