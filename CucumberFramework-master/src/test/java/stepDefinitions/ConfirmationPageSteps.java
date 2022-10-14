package stepDefinitions;

import org.junit.Assert;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import pageObjects.ConfirmationPage;

public class ConfirmationPageSteps {
	TestContext testContext;
	ConfirmationPage confirmationPage;
	
	public ConfirmationPageSteps(TestContext context) {
		testContext = context;
		confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
	}
	
	@Then("^verify the order details$")
	public void verify_the_order_details(){
		
	}

}
