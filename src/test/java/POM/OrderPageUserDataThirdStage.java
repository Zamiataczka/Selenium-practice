package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(accessButton));
        driver.findElement(accessButton).click();
        return this;
    }
}
