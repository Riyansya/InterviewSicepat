@Login
Feature: SICEPAT Skenario Add Cart

  @OpenWeb
  Scenario Outline: Open URL Web
    When Open Web Sicepat test url <url>
    Examples:
      |url                             |
      |https://www.saucedemo.com       |

    @Login
      Scenario: Login
      When Login Sicepat test

    @AddCart
    Scenario Outline: Add Cart
      When Transaksi Sicepat2 test cart <cart>
      Examples:
        |cart                      |
        |Sauce Labs Backpack       |


