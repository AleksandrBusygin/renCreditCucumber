package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@class='service__links-item'][@href='/contributions/']")
    public WebElement calculatorForConributionsButton;

    public void calculatorClick(){
        click(calculatorForConributionsButton);
    }
}
