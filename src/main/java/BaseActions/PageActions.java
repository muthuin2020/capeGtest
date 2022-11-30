package BaseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActions extends BaseAction {

	int waitTime = 60;

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getTextOfElement(By ele) {
		String s = waitForElementToBeVisible(ele).getText();
		return s;

	}

	public void enterText(By ele, String text) {
		waitForElementToBeClickable(ele).sendKeys(text);
	}

	public void clickOnElement(By ele) {
		waitForElementToBeClickable(ele).click();
	}

	public void selectFromDropdown(By ele, String optionToBeSelected) {
		Select s = new Select(waitForElementToBeVisible(ele));
		s.selectByVisibleText(optionToBeSelected);

	}

	public WebElement getSelectedFromDropdown(By ele) {
		Select s = new Select(waitForElementToBeVisible(ele));
		return s.getFirstSelectedOption();

	}

	public WebElement waitForElementToBeVisible(By ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ele));

	}

	public WebElement waitForElementToBeClickable(By ele) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		return wait.until(ExpectedConditions.elementToBeClickable(ele));

	}

}
