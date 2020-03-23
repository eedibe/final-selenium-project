package framework.webPages;

import org.glassfish.grizzly.nio.SelectorHandlerTask;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stepdefinition.SharedSD;
import sun.security.provider.SHA;

import java.util.List;

public class HomePageHotels extends BasePage {

    private By inputField = By.xpath("//input[@id='qf-0q-destination']");
    private By searchButton = By.xpath("//button[@class='cta cta-strong']");
    private By closeRedSign = By.xpath("//button[contains(@class,'cta cta-link')]");
    private By hotDayPrice = By.xpath("//section[@class='hotel-wrap']//aside[@class='pricing resp-module']//div[@class='price']//ins[contains(text(), '$')]");
    private By todaysBestDeal = By.xpath("//li[@class='hotel deal-of-the-day']//section[@class='hotel-wrap']//aside[@class='pricing resp-module']//div[@class='price']//ins[contains(text(), '$')]");

    private By landmark = By.xpath("//h3[contains(text(),'Landmarks')]");
    private By setLandmark = By.id("f-label-lid-1662393");


    private By fiveStars = By.xpath("//fieldset[@id='filter-star-rating']//li[*][1]");
    private By fourStars = By.xpath("//fieldset[@id='filter-star-rating']//li[*][2]");
    private By threeStars = By.xpath("//fieldset[@id='filter-star-rating']//li[*][3]");
    private By twoStars = By.xpath("//fieldset[@id='filter-star-rating']//li[*][4]");
    private By oneStar = By.xpath("//fieldset[@id='filter-star-rating']//li[*][5]");
    private By miles = By.xpath("//option[contains(text(),'1 mile')]");

    private By selectNumbersOfRooms = By.xpath("//select[@id='qf-0q-rooms']");
    private By displayedRooms = By.xpath("//span[contains(text(),'Room')]");


    public boolean isRoomsDisplayed() {
        return isElementDisplayed(displayedRooms);
    }

    public void selectNumberofRooms(String value) {
        selectByTextFromDropDown(selectNumbersOfRooms, value);

    }

    public void miles() {
        clickOn(miles);
    }

    public void clearInputField() {
        SharedSD.getDriver().findElement(inputField).clear();

    }

    public void clickOnSearch() {
        clickOn(searchButton);

    }

    public void setInputField(String value) {
        SharedSD.getDriver().findElement(inputField).sendKeys(value);

    }

    public void closeSign() {
        clickOn(closeRedSign);
    }

    public String getDealofDayPrice() {
        return SharedSD.getDriver().findElement(hotDayPrice).getText();


    }

    public void selectByTextFromDropDown(By locator, String text) {
        WebElement dropDownElement = SharedSD.getDriver().findElement(locator);
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByVisibleText(text);
    }

    public void clickOnLandmark() {
        clickOn(landmark);
    }

    public void checkLandmarkRadioButton() {
        clickOn(setLandmark);
    }

    public void selectMilesRadius() {
        Select miles = new Select(SharedSD.getDriver().findElement(By.xpath("//div[@id ='filter-landmarks-contents']//select[@id='f-distance']")));
        miles.selectByVisibleText("10 miles");
    }

    public String setStarsRate(String numberStars) {
        return numberStars;
    }

    public void clickOnFiveStar() {
        clickOn(fiveStars);
    }

    public void clickOnFourStar() {
        clickOn(fourStars);
    }

    public void clickOnThreeStar() {
        clickOn(threeStars);
    }

    public void clickOnTwoStar() {
        clickOn(twoStars);
    }

    public void clickOnOneStar() {
        clickOn(oneStar);

    }

    public String compareFiveStarRate() {
        return getTextFromElement(fiveStars);
    }

    public String compareFourStarRate() {
        return getTextFromElement(fourStars);
    }

    public String compareThreeStarRate() {
        return getTextFromElement(threeStars);
    }

    public String compareTwoStarRate() {
        return getTextFromElement(twoStars);
    }

    public String compareOneStarRate() {
        return getTextFromElement(oneStar);
    }


}
