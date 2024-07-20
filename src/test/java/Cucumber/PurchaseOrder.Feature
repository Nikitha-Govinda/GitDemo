Feature:Purchase Order from Ecommerce
  I am going to use this template for my feature file

  Background: I landed in Ecommerce website


    Given Logged in to the website using <username> and <password>
    When  I add <productName> to the cart
    And checkout <productName> and submit the order
    Then THANK FOR THE ORDER  Confirmation message is displayed on the confirmation page

    Examples:
    | name| password| productName|
    |trulynikki.22@gmail.com|Test@123|ZARA COAT 3|