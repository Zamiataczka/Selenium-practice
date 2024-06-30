package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Третий стейдж формы заказа
public class OrderPageUserDataThirdStage {
    private WebDriver driver;
    public OrderPageUserDataThirdStage (WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Да"
    private By accessButton = By.xpath(".//*[text()='Да']");

    //Метож клика по кнопке "Да"
    public OrderPageUserDataThirdStage clickAccessButton() {
        driver.findElement(accessButton).click();
        return this;
    }
}
