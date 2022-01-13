@TestSheepCalculator @regression
Feature: Validating Calculate functionality in TestSheep

  Background: Repeated Steps
    Given user navigates to TestSheep application

#Background will not work with Examples table


  Scenario Outline: Validating calculate functionality with valid inputs

    When user enters "<number1>" as first Number
    And user enters "<number2>" as second number
    And user selects "<Operation>" operator
    And clicks on Calculate button
    Then user validates that output is <answer>
    Examples:
      | number1 | number2 | Operation   | answer |
      | 6       | 2       | Add         | 8      |
      | 10      | 5       | Subtract    | 5      |
      | 2       | 3       | Multiply    | 6      |
      | 4       | 1       | Divide      | 4      |
      | 1       | 2       | Concatenate | 12     |

  Scenario Outline: Validating calculate functionality with invalid inputs

    When user enters "<number1>" as first Number
    And user enters "<number2>" as second number
    And user selects "<Operation>" operator
    And clicks on Calculate button
    Then user validates "<ErrorMessage>" error message
    Examples:
      | number1 | number2 | Operation | ErrorMessage             |
      | abc     | abc     | Add       | Number 1 is not a number |
      | 5       | abc     | Subtract  | Number 2 is not a number |
      | 5       | 0       | Divide    | Divide by zero error!    |

