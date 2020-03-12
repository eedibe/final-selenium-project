package stepdefinition;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HomePage;
import framework.webPages.LoginPage;
import org.testng.Assert;


public class DarkSky_RegisterSD {


        private HomePage homePage = new HomePage();


        @Given("^I am on Darksky home page$")
        public void onHomepage() throws InterruptedException {
            Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");
            homePage.clickonSkyAPIDarkSKy();
            Thread.sleep(2000);
            homePage.clickOnSignupDarkSky();
            Thread.sleep(2000);
        }


        @When("^I click on Register button$")
        public void clickonResgiterbutton(){
            homePage.clickOnRegisterDarkSky();

        }
        @Then("^I verify I am on Register page by asserting Register header$")
        public void getRegisterError(){
                Assert.assertEquals("Register",homePage.getRegisterErrorTextFromDarksky());


        }

    }

