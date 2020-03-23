package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.HomePageHotels;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Hotels_RoomCountSD {
    HomePageHotels homePage = new HomePageHotels();


    @Given("^I am on hotels.com home page$")
    public void onHomepage() throws InterruptedException {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations", "Invalid Home Page");

    }

    @Then("^I select (.*) from room dropdown$")
    public void selectRooms(String selectRooms) throws InterruptedException {
        switch (selectRooms) {
            case "1":
                homePage.selectNumberofRooms("1");
                Thread.sleep(3000);
                break;
            case "2":
                homePage.selectNumberofRooms("2");
                Thread.sleep(3000);
                break;
            case "3":
                homePage.selectNumberofRooms("3");
                Thread.sleep(3000);
                break;
            case "4":
                homePage.selectNumberofRooms("4");
                Thread.sleep(3000);
                break;
            case "5":
                homePage.selectNumberofRooms("5");
                Thread.sleep(3000);
                break;
            case "6":
                homePage.selectNumberofRooms("6");
                Thread.sleep(3000);
                break;
            case "7":
                homePage.selectNumberofRooms("7");
                Thread.sleep(3000);
                break;
            case "8":
                homePage.selectNumberofRooms("8");
                Thread.sleep(3000);
                break;
            case "(9+":
                homePage.selectNumberofRooms("9+");
                Thread.sleep(3000);
                break;

        }
    }

    @And("^I verify (.*) is displayed$")
    public void verifyRoomCountDropdown(String numberOfRomms) {


        List<WebElement> roomsDisplayed = SharedSD.getDriver().findElements(By.xpath("//div[contains(@class,'widget-query-group widget-query-rooms widget-query-rooms-multiple')]//div[contains(@class,'widget-query-group widget-query-room-options')]//span[contains(@class,'widget-query-room-options-label')]"));

        for (int i = 1; i < roomsDisplayed.size(); i++) {
            String roomsDispayedSplit = roomsDisplayed.get(i).getText();
            //String [] splitRooms = roomsDispayedSplit.split(" ");
            String subsRooms = roomsDispayedSplit.substring(5,6);
            System.out.println("rooms: "+subsRooms);
            
            //I am stuck here and I don't know how to compare....
            Assert.assertTrue(homePage.isRoomsDisplayed(),"Rooms not displayed correctly");




        }
    }
}


