Feature: Login Test

  @SmokeTest @first
  Scenario: Verify Borrow Estimation
    Given Enter input values in Borrow Estimate form
    When submit values in Borrow Estimate form
    Then verify Borrow Limit

  @SmokeTest
  Scenario: Verify Start over button resets the form
    Given Enter input values in Borrow Estimate form
    Given submit values in Borrow Estimate form
    When Click on Start over button
    Then verify fields are reset in the form

  @NegativeTest @last
  Scenario: Submit form with Living expense alone and Verify Error message
    Given Enter input values in Borrow Estimate form
    When submit values in Borrow Estimate form
    Then Verify Error message
