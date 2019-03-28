package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class BasePage {

    public static WebDriver driver = BaseSteps.getDriver();

    public BasePage(){
        PageFactory.initElements(driver,this);
    }

    public void fillForm(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        }

    public static void checkBoxCheck(WebElement checkbox, String choise){
        if (choise=="согласен") {
            Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 30, 1000);
            wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        }
    }

    public static void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) BaseSteps.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void waitFieldisDisplayed(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);
            wait.until((WebDriver d) -> element.isDisplayed());
            return;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        Assert.fail("Поле не отображено");
    }

    public static void click(WebElement element) {
        waitFieldisDisplayed(element);
        element.click();
    }


}
