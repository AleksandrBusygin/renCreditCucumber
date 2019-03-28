package steps;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;
import pages.ContributionsPage;

import java.util.Map;

public class ContributionsPageSteps {

    ContributionsPage contributionsPage = new ContributionsPage();

    @Тогда("проверяем заголовок страницы - \"(.*)\"")
    public void checkHeaderStep(String expectedHeader) {
        contributionsPage.compareHeader(expectedHeader);
    }

    @Когда("заполняются поля ввода данных")
    public void fillAll(DataTable parameters) throws Exception {

        Map<String, String> fillMap = parameters.asMap(String.class, String.class);
//      сумма вклада
        contributionsPage.fillForm(contributionsPage.formForMoney, fillMap.get("Сумма вклада"));
//      на срок
        contributionsPage.chooseTermMethod(contributionsPage.chooseTerm, fillMap.get("Срок"));
//      ежемесячное пополнение
        contributionsPage.fillForm(contributionsPage.replenishment, fillMap.get("Ежемесячное пополнение"));
//      ежемесячная капитализация
        contributionsPage.checkBoxCheck(contributionsPage.checkBox1, fillMap.get("Ежемесячная капитализация"));
//      частичное снятие
        contributionsPage.checkBoxCheck(contributionsPage.checkBox2, fillMap.get("Частичное снятие"));
    }

    @Тогда("сравниваются итоговые данные")
    public void assertResult(DataTable parameters) {
        Map<String, String> resultMap = parameters.asMap(String.class, String.class);

        contributionsPage.compareResults(resultMap.get("Ставка"), contributionsPage.rate);
        contributionsPage.compareResults(resultMap.get("Начислено"), contributionsPage.earned);
        contributionsPage.compareResults(resultMap.get("Пополнение за период"), contributionsPage.replenish);
        contributionsPage.compareResults(resultMap.get("К снятию"), contributionsPage.result);


    }

}
