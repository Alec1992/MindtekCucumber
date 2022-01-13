@regression @smoke @ui @MB2P-122
Feature: Validating pizza application functionalities

  Scenario Outline: Validating place order functionality
    Given user navigates to pizza application
    When user creates pizza order with data
      | Pizza        | <Pizza>        |
      | Toppings 1   | <Toppings 1>   |
      | Toppings 2   | <Toppings 2>   |
      | Quantity     | <Quantity>     |
      | Name         | <Name>         |
      | email        | <email>        |
      | phone        | <phone>        |
      | Payment type | <Payment type> |
    Then user validates that order is created with success message "Thank you for your order! TOTAL: " "<Pizza>"
    Examples:
      | Pizza                        | Toppings 1 | Toppings 2   | Quantity | Name        | email             | phone     | Payment type   |
      | Small 6 Slices - no toppings | Mushrooms  | Extra cheese | 1        | John Doe    | johndoe@gmail.com | 123456789 | cash on pickup |
      | Large 10 Slices - 2 toppings | Mushrooms  | Extra cheese | 3        | Patel Harsh | patel@gmail.com   | 987654321 | Credit Card    |
      | Medium 8 Slices - 2 toppings | Olives     | Salami       | 2        | Kim Moore   | kim@gmail.com     | 987654321 | Credit Card    |