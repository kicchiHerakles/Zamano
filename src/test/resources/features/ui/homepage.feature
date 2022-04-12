Feature: Home Page Element Validations

  Background:
    Given Home page is loaded

  @KEY-2 @Web-Desktop
  Scenario:
    Then user should see the following menus in the navigation bar
      |Courses|
      |       Services|
      |       About Us|
      |       Contact|