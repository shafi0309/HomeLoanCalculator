package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	@When("user gets the title of the page")
	public void user_is_on_accounts_page(String strTitle) {
		Assert.assertTrue(accountsPage.getAccountsPageTitle().contains(strTitle));
	}
	@Given("user is on home loan calculator page")
	public void userHomeLoanCalculatorPage()
	{
		Assert.assertTrue(accountsPage.getPageHeader().equals("How much could I borrow?"));
	}
	
	@And("User selects {string} as {string}")
	public void userSelectOption(String strLabel,String strOption)
	{
		accountsPage.getOpt(strLabel,strOption).click();
	}
	@And("User enters {string} as {string}")
	public void userEntersVal(String strLabel,String strOption)
	{
		accountsPage.getLabel(strLabel).sendKeys(strOption);
	}
	@And("User clicks {string} button")
	public void userClicksButton(String strLabelName)
	{
		accountsPage.getClickButton(strLabelName).click();
	}
	@Then("User verifies borrowing estimates")
	public void userVerifiesBorrowingEst()
	{
		Assert.assertTrue(!accountsPage.getEstimate().isDisplayed());
	}
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {

		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(userName, password);

	}

	
}
