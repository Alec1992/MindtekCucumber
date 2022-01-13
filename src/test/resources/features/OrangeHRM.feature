@OrangeHRMApp
Feature: Validating timesheet functionalities
  Background:
    Given user navigates to OrangeHRM app and provides "Admin" for username and "admin123" for password and click login button
    When user clicks on TIME button and clicks on view for Paul Collings

  Scenario: Validate add timesheet functionality

    And user clicks on Add timesheet button and selects date Jan 3rd on calendar and clicks on OK button
    Then user verifies "Timesheet Already Exists" message is displayed

  Scenario: Validate edit timesheet functionality
    And user saves total hours and clicks on Edit button
    Then user selects the first row and saves total hours for that row and clicks remove row button and clicks on save button
    And user validates that total hours on timesheet are updated accordingly
    Then user clicks on edit button and clicks on add Row button and provides all inputs
    Then user clicks on save button and validates that total hours are updated accordingly


