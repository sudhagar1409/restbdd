Feature: Get incidents 
  Scenario: Get incidents specific to the query parameters
    Given I am creating a request with end points
    And I am using basic aunthetication
    When I am constructing a request with query paramter as "sysparm_fields" and "category"
    And I am sending the get request
    Then I validate the response of get request
    