package StepDefinition;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import BaseActions.BaseAction;
import BaseActions.PageActions;
import PageClasses.BorrowCalPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepdefs extends BaseAction {

	public static BorrowCalPage borrowCalPage;
	public static Properties envData;
	public static Properties executionEnv;
	public static String featurName;
	public static String scenarioName;

	@Before
	public void setUpBrowser(Scenario scenario) {
		featurName = scenario.getId().split(";")[0].replace("-", " ");
		scenarioName = scenario.getName();
		executionEnv = loadScenarioInput(System.getProperty("user.dir") + "//Env//selectEnvHere.txt");
		System.out.println("Tests are running in : " + executionEnv.getProperty("executionEnv"));
		envData = loadScenarioInput(
				System.getProperty("user.dir") + "//Env//" + executionEnv.getProperty("executionEnv") + ".txt");
		loadScenarioInput(
				System.getProperty("user.dir") + "//Input//" + featurName + "//" + scenarioName + ".properties");

		if (!driverLaunched) {
			if (envData.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//Driver//chromedriver.exe");
				driver = new ChromeDriver();
			}
			if (envData.getProperty("browser").equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "//Driver//geckodriver.exe");
				driver = new FirefoxDriver();
			}
			if (envData.getProperty("browser").equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "//Driver//EdgeDriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			borrowCalPage = new BorrowCalPage(driver);
			driverLaunched = true;
		}

		System.out.println("Scenario name : " + scenario.getName());
		BaseAction.driver.get(envData.getProperty("url"));
	}

	@After("@last")
	public void quitBrowser() {
		BaseAction.driver.quit();
	}

	@Given("^Enter input values in Borrow Estimate form")
	public void Enter_input_values_in_Borrow_Estimate_form() throws Throwable {

		enterValuesInForm();
	}

	@When("^submit values in Borrow Estimate form")
	public void submit_values_in_Borrow_Estimate_form() throws Throwable {
		borrowCalPage.clickEstimateButton();
	}

	@Then("^verify Borrow Limit")
	public void verify_Borrow_Limit() throws Throwable {
		Thread.sleep(2000);
		Assert.assertEquals(scenarioInput.getProperty("borrowEstimatedAmount"),
				Integer.parseInt(borrowCalPage.getBorrowEstimatedAmount().replace("$", "").replace(",", "")));

	}

	@When("^Click on Start over button$")
	public void click_on_Start_over_button() throws Throwable {
		borrowCalPage.clickOnStartOverButton();
	}

	@Then("^verify fields are reset in the form$")
	public void verify_fields_are_reset_in_the_form() throws Throwable {
		Thread.sleep(2000);
		Assert.assertEquals(scenarioInput.getProperty("expectedOut"), borrowCalPage.getAnualIncome());
	}

	@Then("^Verify Error message$")
	public void Verify_Error_message() throws Throwable {
		Assert.assertEquals(scenarioInput.getProperty("expectedOut"), borrowCalPage.getBorrowInEligibleError());

	}

	public void enterValuesInForm() {
		if (scenarioInput.getProperty("anualIncome") != null) {
			borrowCalPage.setAnualIncome(scenarioInput.getProperty("anualIncome"));
		}
		if (scenarioInput.getProperty("otherIncome") != null) {
			borrowCalPage.setOtherIncome(scenarioInput.getProperty("otherIncome"));
		}
		if (scenarioInput.getProperty("monthlyExpense") != null) {
			borrowCalPage.setMonthlyExpense(scenarioInput.getProperty("monthlyExpense"));
		}
		if (scenarioInput.getProperty("homeLoanRepayment") != null) {
			borrowCalPage.setHomeLoanRepayment(scenarioInput.getProperty("homeLoanRepayment"));
		}
		if (scenarioInput.getProperty("otherLoanRepayment") != null) {
			borrowCalPage.setOtherLoanRepayment(scenarioInput.getProperty("otherLoanRepayment"));
		}
		if (scenarioInput.getProperty("otherMonthlyCommit") != null) {
			borrowCalPage.setOtherMonthlyCommit(scenarioInput.getProperty("otherMonthlyCommit"));
		}
		if (scenarioInput.getProperty("creditCardLimit") != null) {
			borrowCalPage.setCreditCardLimit(scenarioInput.getProperty("creditCardLimit"));
		}

	}

}