package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Финальный стейдж формы заказа
public class OrderUserDataFinalStage {
    private WebDriver driver;

    public OrderUserDataFinalStage (WebDriver driver) {
        this.driver = driver;
    }
    //Локатор для оформленного заказа
    private By orderGoodTake = By.xpath("//div[text()='Заказ оформлен']");

    //Метод для проверки отображения текста оформленного заказа
    public boolean orderIsGoodTake() {
        return driver.findElement(orderGoodTake).isDisplayed();
    }
}
