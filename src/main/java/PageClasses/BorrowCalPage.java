package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BaseActions.PageActions;

public class BorrowCalPage extends PageActions{

 By appTypeSingle=By.xpath("//label[@for=\"application_type_single\"]");
 By appTypeJoint=By.xpath("//label[@for=\"application_type_joint\"]");	
 
 By selectedType=By.xpath("//label[contains(text(),\"Application\")]//parent::div//li[@class=\"selected\"]//label");
 By selectedProperty=By.xpath("//label[contains(text(),\"Property you\")]//parent::div//li[@class=\"selected\"]//label");
 
 By noOfDependants=By.xpath("//Select[@title=\"Number of dependants\"]");
 
 By anualIncome=By.xpath("//label[contains(text(),\"Your annual income\")]//parent::div//input");
 By otherIncome=By.xpath("//label[contains(text(),\"Your annual other income\")]//parent::div//input");
 By monthlyExpense=By.xpath("//label[contains(text(),\"Monthly living expenses \")]//parent::div//input");
 By homeLoanRepayment=By.xpath("//label[contains(text(),\"Current home loan\")]//parent::div//input");
 By otherLoanRepayment=By.xpath("//label[contains(text(),\"Other loan monthly\")]//parent::div//input");
 By otherMonthlyCommit=By.xpath("//label[contains(text(),\"Other monthly commit\")]//parent::div//input");
 By creditCardLimit=By.xpath("//label[contains(text(),\"credit card limit\")]//parent::div//input");
 By borrowCalButton=By.xpath("//button[@id=\"btnBorrowCalculater\"]");
 By borrowEstimatedAmount=By.xpath("//span[@id=\"borrowResultTextAmount\"]");
 By startOver=By.xpath("//button[contains(text(),\"Start over\")]");
 By borrowInEligibleError=By.xpath("//div[@class=\"borrow__error__text\"]");
 
 WebDriver driver;
 
 public BorrowCalPage(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	 }
 
 //  ----------------get methods-----------------
 public String getAppType()
 {
	return getTextOfElement(selectedType);
 }
 
 public String getSelectedProperty()
 {
	return getTextOfElement(selectedProperty);
 }
 
 public WebElement getNoOfDependants()
 {
	return getSelectedFromDropdown(noOfDependants);
 }
 
 public String getAnualIncome()
 {
	return getTextOfElement(anualIncome);
 }
 
 public String getOtherIncome()
 {
	return getTextOfElement(otherIncome);
 }
 
 public String getMonthlyExpense()
 {
	return getTextOfElement(monthlyExpense);
 }
 
 public String getHomeLoanRepayment()
 {
	return getTextOfElement(homeLoanRepayment);
 }
 
 public String getOtherLoanRepayment()
 {
	return getTextOfElement(otherLoanRepayment);
 }
 
 public String getOtherMonthlyCommit()
 {
	return getTextOfElement(otherMonthlyCommit);
 }
 
 public String getCreditCardLimit()
 {
	return getTextOfElement(creditCardLimit);
 }
 
 public String getBorrowInEligibleError()
 {
	return getTextOfElement(borrowInEligibleError);
 }
 
 public String getBorrowEstimatedAmount()
 {
	return getTextOfElement(borrowEstimatedAmount);
 }
 

 //  ----------------Set methods-----------------
 
 
 public void setNoOfDependants(String text)
 {
	 selectFromDropdown(noOfDependants, text);
 }
 
 public void setAnualIncome(String text)
 {
	enterText(anualIncome, text);
 }
 
 public void setOtherIncome(String text)
 {
	 enterText(otherIncome, text);
	
 }
 
 public void setMonthlyExpense(String text)
 {

	 enterText(monthlyExpense, text);
	
 }
 
 public void setHomeLoanRepayment(String text)
 {
	 enterText(homeLoanRepayment, text);
	
 }
 
 public void setOtherLoanRepayment(String text)
 {
	 enterText(otherLoanRepayment, text);
 }
 
 public void setOtherMonthlyCommit(String text)
 {
	 enterText(otherMonthlyCommit, text);
	
 }
 
 public void setCreditCardLimit(String text)
 {
	 enterText(creditCardLimit, text);

 }
 
 public void setBorrowInEligibleError(String text)
 {
	 enterText(borrowInEligibleError, text);

 }
 
 public void setBorrowEstimatedAmount(String text)
 {
	 enterText(borrowEstimatedAmount, text);
	
 }
 
 public void clickEstimateButton()
 {
	 clickOnElement(borrowCalButton);
 }
 
 
 public void clickOnStartOverButton()
 {
	 clickOnElement(startOver);
 }
 
 
 
}