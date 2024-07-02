package Tests;
import POM.MainPageYS;
import Settings.BrowserSetUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static Sourses.ConstatnsText.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FAQMainPageTest extends BrowserSetUp {

        private final int Index;
        private final String expected;

        //конструктор тест-класса Вопросы о важном с 2 параметрами
        public FAQMainPageTest(int Index, String expected) {
            this.Index = Index;
            this.expected = expected;
        }

        // метод для получения тестовых данных
        @Parameterized.Parameters
        public static Object[][] getTestData() {
            return new Object[][] {
                    {0, expectedAnswer0},
                    {1, expectedAnswer1},
                    {2, expectedAnswer2},
                    {3, expectedAnswer3},
                    {4, expectedAnswer4},
                    {5, expectedAnswer5},
                    {6, expectedAnswer6},
                    {7, expectedAnswer7}
            };
        }

    @Test
    public void checkEqualsTextInAnswer() {
        MainPageYS objMainPageYS = new MainPageYS(driver);
        objMainPageYS.questionButtonClick(Index);
        String actual = objMainPageYS.getAnswers(Index);
        assertEquals(expected, actual);
    }
}
