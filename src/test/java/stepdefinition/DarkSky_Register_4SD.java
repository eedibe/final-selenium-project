package stepdefinition;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyAPI;
import framework.webPages.HomePage;
import framework.webPages.HomePageForDarkSky;
import framework.webPages.LoginPage;
import org.testng.Assert;


public class DarkSky_Register_4SD {


        private DarkSkyAPI darkSkyAPI = new DarkSkyAPI();
        private HomePageForDarkSky homepage = new HomePageForDarkSky();

        @Given("^I am on Darksky home page$")
        public void onHomepage() throws InterruptedException {
            Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");
            homepage.clickonSkyAPIDarkSKy();
            Thread.sleep(2000);
            darkSkyAPI.clickOnSignupDarkSky();
            Thread.sleep(2000);
        }


        @When("^I click on Register button$")
        public void clickonResgiterbutton(){
            darkSkyAPI.clickOnRegisterDarkSky();

        }
        @Then("^I verify I am on Register page by asserting Register header$")
        public void getRegisterError(){
                Assert.assertEquals("Register",darkSkyAPI.getRegisterErrorTextFromDarksky());


        }

    }

