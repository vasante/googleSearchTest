Feature: Searching Keyword in Google
  As a site user
  If I search for keyword
  The page title should contains the keyword

  Scenario: open google and search with valid criteria
    Given I reach google home page
    When I enter valid search criteria 'ingenico'
    Then The result page displayed at least one result

  @smoke
  Scenario: open google
    Then I reach google home page

  Scenario Outline: open google and search with valid criteria
    Given I reach google home page
    When I enter valid search criteria '<text>'
    Then The result page displayed at least one result
    
    Examples:
    |text|
    |ingenico|
    |Publicis|

  Scenario: open google and search with valid criteria1
    Given I reach google home page
