package steps;

import cucumber.api.java.ru.Когда;
import pages.MainPage;

public class MainPageSteps {
    MainPage mainPage = new MainPage();

    @Когда("выбор калькулятора для вкладов")
    public void calculatorStep(){
        mainPage.calculatorClick();
    }
}
