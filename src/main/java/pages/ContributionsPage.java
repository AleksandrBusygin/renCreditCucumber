package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import steps.BaseSteps;

import static junit.framework.Assert.assertEquals;

public class ContributionsPage extends BasePage {

    @FindBy(xpath = "//h2[@class='calculator-block__title block-title']")
    public WebElement headerOfContributionsPage;

    @FindBy(xpath = "//span[text()='Рубли']")
    public WebElement rublesButton;

    @FindBy(xpath = "//input[@name='amount']")
    public WebElement formForMoney;

    @FindBy(xpath = "//div[@class='jq-selectbox__select']")
    public WebElement chooseTerm;

    @FindBy(xpath = "//input[@name='replenish']")
    public WebElement replenishment;

    @FindBy(xpath = "//span[@class='calculator__check-text'][contains(text(),'Ежемесячная')]")
    public WebElement checkBox1;

    @FindBy(xpath = "//span[@class='calculator__check-text'][contains(text(),'Частичное')]")
    public WebElement checkBox2;

    @FindBy(xpath = "//div[@class=\"calculator__dep-percent\"]//child::span[@class=\"js-calc-rate\"]")
    public WebElement rate;

    @FindBy(xpath = "//tr//td//child::b//child::span[@class=\"js-calc-earned\"]")
    public WebElement earned;

    @FindBy(xpath = "//tr//td//child::span[@class=\"js-calc-replenish\"]")
    public WebElement replenish;

    @FindBy(xpath = "//div//div//child::span[@class=\"js-calc-result\"]")
    public WebElement result;

    public void compareHeader (String expected) {
        scrollToElement(headerOfContributionsPage);
        String actual = headerOfContributionsPage.getText() ;
        assertEquals("Вместо ожидаемого текста: " + expected + " найден: " + actual, expected, actual);
        if (actual.contains(expected)) {
            System.out.println("Искомый текст есть: " + expected);
        }
    }
    public void compareResults(String expected, WebElement element) {
        scrollToElement(element);
        waitFieldisDisplayed(element);
        String actual = element.getText().replaceAll("%","");
        assertEquals("Вместо ожидаемого текста: " + expected + " найден: " + actual, expected, actual);
        if (actual.contains(expected)) {
            System.out.println("Искомый текст есть: " + expected);
        }
    }

    public void chooseTermMethod(WebElement element,String term) {
        click(element);
        Select select = new Select(BaseSteps.getDriver().findElement(By.xpath("//select[@class=\"calculator__slide-input js-slide-value\"]")));
        select.selectByVisibleText(term);
    }

}
