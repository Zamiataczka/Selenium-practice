package POM;

import org.openqa.selenium.*;


//Первый стейдж формы заказа
public class OrderPageUserDataFirstStage {
    private WebDriver driver;
    private By firstnameField = By.xpath(".//input[@placeholder ='* Имя']");
    //Поле фамилии
    private By secondnameField = By.xpath(".//input[@placeholder ='* Фамилия']");
    //Поле адреса
    private By addressField = By.xpath(".//input[@placeholder ='* Адрес: куда привезти заказ']");
    //Поле метро
    private By metroField = By.xpath(".//input[@placeholder ='* Станция метро']");
    //Поле селектора Станции метро
    private By metroFieldСhoose = By.className("select-search__select");
    //Поле номера телефона
    private By phoneField = By.xpath(".//input[@placeholder ='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private By nextStageButton = By.xpath(".//button[text()='Далее']");

    public OrderPageUserDataFirstStage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод ввода Имя
    public void SendFirstName(String firstName) {
        driver.findElement(firstnameField).sendKeys(firstName);
    }

    //Метод ввода Фамилии
    public void SendSecondName(String secondName) {
        driver.findElement(secondnameField).sendKeys(secondName);
    }

    //Метод ввода Адреса
    public void SendAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    //Метод выбора станции метро в поле
    public void clickMetroField() {
        driver.findElement(metroField).click();
        driver.findElement(metroFieldСhoose).isDisplayed();
        driver.findElement(metroField).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    //Метод ввода номера телефона
    public void SendPhoneNumber(String phoneNumber) {
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    //Метод клика по кнопук "Далее"
    public void nextStageButtonClick() {
        driver.findElement(nextStageButton).click();
    }

    //Метод для заполнения первого стейджа данных для заказа и перехода на второй стейдж
    public OrderPageUserDataFirstStage firstStageOrderUserData (String firstName, String secondName, String address, String phoneNumber) {
        SendFirstName(firstName);
        SendSecondName(secondName);
        SendAddress(address);
        clickMetroField();
        SendPhoneNumber(phoneNumber);
        nextStageButtonClick();
        return this;
    }
}
