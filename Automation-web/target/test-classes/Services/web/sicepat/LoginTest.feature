@Login
Feature: SICEPAT Skenario Add All Cart

  @OpenWeb
  Scenario Outline: Open URL Web
    When Open Web Sicepat test url <url>
    Examples:
      |url                             |
      |https://www.saucedemo.com       |

    @Login
      Scenario: Login
      When Login Sicepat test

    @AddCarts
    Scenario: Add Carts
      When Transaksi Sicepat test



