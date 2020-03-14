package framework.webPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.Collections;

public class HomePageForDarkSky extends BasePage{
    private By expandPlusButtonDarkSky = By.xpath("//a[@data-day='0']//span[@class='open']");
    private By skyApiLink = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
    private By lowTempDay=By.xpath("//a[@data-day='0']//span[@class='minTemp']");
    private By highTempDay=By.xpath("//*[@id=\"week\"]/a[1]/span[2]/span[3]");
    private By lowTempDayExtras=By.xpath("//*[@id=\"week\"]/div[2]/div[1]/div[2]/div[1]/span[1]/span[1]");
    private By highTempDayExtras=By.xpath("//*[@id=\"week\"]/div[2]/div[1]/div[2]/div[1]/span[3]/span[1]");

    public void clickOnexpandPlusButtonDarkSky()

    {
        clickOn(expandPlusButtonDarkSky);
    }

    public void clickonSkyAPIDarkSKy()
    { clickOn(skyApiLink);
    }
    public String getLowTempDay(){
        return SharedSD.getDriver().findElement(lowTempDay).getText();
    }
    public String getHighTempDay(){
        return SharedSD.getDriver().findElement(highTempDay).getText();
    }
    public String getLowTempDayExtras(){
        return SharedSD.getDriver().findElement(lowTempDayExtras).getText();

    }
    public String getHighDayExtras(){
        return SharedSD.getDriver().findElement(highTempDayExtras).getText();
    }

}
