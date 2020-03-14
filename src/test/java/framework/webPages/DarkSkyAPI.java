package framework.webPages;

import org.openqa.selenium.By;
import stepdefinition.SharedSD;

public class DarkSkyAPI extends BasePage{

    private By darkskySignupButton = By.xpath("//a[@class='button filled']");
    private By darkskyRegisterButton = By.xpath("//button[contains(text(),'Register')]");
    private By register = By.xpath("//h1[@class='stand-alone title']");


    public void clickOnSignupDarkSky()
    {
        clickOn(darkskySignupButton);
    }
    public String getRegisterErrorTextFromDarksky(){
        return SharedSD.getDriver().findElement(register).getText();

    }
    public void clickOnRegisterDarkSky() {
        clickOn(darkskyRegisterButton);
    }
}
