Feature: Testing About Page Heading
  Background:
    Given user visits the site
  Scenario: Validating about page title
    When user scrolls down to the page
    And click on About button
    Then about page is opened