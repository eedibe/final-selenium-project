package framework.webPages;

import org.openqa.selenium.By;
import stepdefinition.SharedSD;

public class HomePage extends BasePage{

	private By emailTextField = By.id("email");
	private By passwordTextField = By.id("pass");
	private By loginButton = By.id("loginbutton");
	private By firstNameTextField = By.id("firstName");
	private By lastNameTextField = By.id("lastName");
	private By mobileNumberTextField = By.id("mobileNumber");
	private By newPasswordTextField = By.id("newPwd");
	private By errorMessage = By.id("errorMessage");
	private By femaleGender = By.id("u_0_9");
	private By maleGender = By.id("u_0_a");
	private By messengerLink = By.id("");

	/*****************************************************************************/
						/********DARKSKY********/

	private By skyApiLink = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
	private By darkskySignupButton = By.xpath("//a[@class='button filled']");
	private By darkskyRegisterButton = By.xpath("//button[contains(text(),'Register')]");
	private By register = By.xpath("//h1[@class='stand-alone title']");


//
	String darkSkyCurrentTemp = SharedSD.getDriver().findElement(By.xpath("//span[@class='summary swap']")).getText();
	String darkSkyLowTemp = SharedSD.getDriver().findElement(By.xpath("//span[@class='low-temp-text']")).getText();
	String darkSkyHighTemp = SharedSD.getDriver().findElement(By.xpath("//span[@class='high-temp-text']")).getText();




	public void verifyCurrentTemp() {
		//convert temprature string to temperature integer, to get temperture string only take part before special character '˚'
		String darkSkyDisplayCurrentTemp = darkSkyCurrentTemp.substring(0,darkSkyCurrentTemp.indexOf('˚'));
		int darkSkyIntCurrentTemp = Integer.parseInt(darkSkyCurrentTemp.substring(0, darkSkyCurrentTemp.indexOf('˚')));
		int darkSkyIntLowTemp = Integer.parseInt(darkSkyLowTemp.substring(0, darkSkyLowTemp.indexOf('˚')));
		int darkSkyIntHighTemp = Integer.parseInt(darkSkyHighTemp.substring(0, darkSkyHighTemp.indexOf('˚')));

		//Compare to see if the Current temperature is between low and high temperature
		if (darkSkyIntCurrentTemp  > darkSkyIntLowTemp || darkSkyIntCurrentTemp < darkSkyIntHighTemp) {
			System.out.println("Current temperature is " + darkSkyDisplayCurrentTemp +"˚F" +" and it is between low and high daily timeline temperature." );
		}
		else{
			System.out.println("Current temperature is " + darkSkyDisplayCurrentTemp +"˚F"+" and it is great or lower than the daily timeline temperature.");

		}

	}

	public void clickonSkyAPIDarkSKy()
	{ clickOn(skyApiLink);
	}
	public void clickOnSignupDarkSky(){
		clickOn(darkskySignupButton);
	}
	public String getRegisterErrorTextFromDarksky(){
		return SharedSD.getDriver().findElement(register).getText();

	}
	public void clickOnRegisterDarkSky() {

		clickOn(darkskyRegisterButton);
	}

	/**********************************************************************************/
	public void clickOnLoginButton() {
		clickOn(loginButton);
	}

	public void enterEmail(String enterEmail) {
		setValue(emailTextField, enterEmail);
	}
	
	public void enterPassword(String enterPassword) {
		setValue(passwordTextField, enterPassword);
	}

	public void enterFirstName(String firstName) {
		setValue(firstNameTextField, firstName);
	}

	public void enterLastName(String lastName) {
		setValue(lastNameTextField, lastName);
	}

	public void enterMobileNumber(String mobileNum) {
		setValue(mobileNumberTextField, mobileNum);
	}

	public void enterNewPassword(String password) {
		setValue(newPasswordTextField, password);
	}

	public String getErrorMessage() {
		return getTextFromElement(errorMessage);
	}

	public boolean isGenderFemaleSelected() {
		return isElementSelected(femaleGender);
	}

	public void clickOnFemaleGender() {
		clickOn(femaleGender);
	}

	public boolean isGenderMaleSelected() {
		return isElementSelected(maleGender);
	}

	public void clickOnMaleGender() {
		clickOn(maleGender);
	}

	public void clickOnMessengerLink() {
		clickOn(messengerLink);
	}







}
