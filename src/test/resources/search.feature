Feature: Testing Search Functionality
  Background:
    Given user visits the portal
  Scenario Outline: Searching for a repo
    When user inputs searchTerm: "<searchTerm>" in the search field
    And user presses enter
    Then user sees a count of matching results
    And expected searchResult: "<expectedResult>" as the first result
    Examples:
      | searchTerm       | expectedResult            |
      | create-react-app | facebook/create-react-app |


