package framework.webPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import stepdefinition.SharedSD;


public class HomePageForDarkSky extends BasePage{
    private By expandPlusButtonDarkSky = By.xpath("//a[@data-day='0']//span[@class='open']");
    private By skyApiLink = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
    private By lowTempDay=By.xpath("//a[@data-day='0']//span[@class='minTemp']");
    private By highTempDay=By.xpath("//a[@data-day='0']//span[@class='maxTemp']");
    private By lowTempDayExtras=By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']");
    private By highTempDayExtras=By.xpath("//div[contains(@class,'revealed')]//span[@class='lowTemp swap']//span[@class='temp']");



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
