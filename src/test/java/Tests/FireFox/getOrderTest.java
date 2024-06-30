package Tests.FireFox;

import BrowserSetUp.FireFox.BrowserSetUpFireFox;
import POM.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class getOrderTest extends BrowserSetUpFireFox {
    private final String typeOrderButton;
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String phoneNumber;
    private final String userDataDeliver;
    private final String typeButton;
    private final String colourButton;
    private final String userComment;

    public getOrderTest(String typeOrderButton, String firstName, String secondName, String address, String phoneNumber, String userDataDeliver, String typeButton, String colourButton, String userComment) {
        this.typeOrderButton = typeOrderButton;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userDataDeliver = userDataDeliver;
        this.typeButton = typeButton;
        this.colourButton = colourButton;
        this.userComment = userComment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
            {"Header", "Александр", "Олегович", "Бульвар Рокоссовского", "89218885544", "02.12.2024", "1", "Black", "Ну к новому году доставьте"},
            {"Middle", "Райан", "Гослинг", "Севастопольская", "89218885533", "21.07.2024", "3", "Grey", "Мне серый сюда"},
        };
    }

    @Test
    public void getOrderByUserTest() {
        MainPageYS objMainPageYS = new MainPageYS(driver);
        objMainPageYS.chooseOrderButton(typeOrderButton);
        //Цепочкой вызовов произвоидтся заполнение двух трех стрейдже оформления заказа
        new OrderPageUserDataFirstStage(driver)
                .firstStageOrderUserData(firstName,secondName,address,phoneNumber);
        new OrderPageUserDataSecondStage(driver)
                .secondStageOrderUserData(userDataDeliver,typeButton,colourButton,userComment);
        new OrderPageUserDataThirdStage(driver)
                .clickAccessButton();
        //Проверка отображения в финальном стейдже оформления заказа
        OrderUserDataFinalStage objOrderFinalStage = new OrderUserDataFinalStage(driver);
        assertTrue(objOrderFinalStage.orderIsGoodTake());
    }
}

