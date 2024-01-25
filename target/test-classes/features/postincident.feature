Feature: Post Incident

  Scenario: Post incident scenario
    Given I am create the resources with endpoint
    And I am allowing the authetication
    And I am adding the headers and body of the request
    When I am sending the request
    Then I validate the response
    Then I print the sys_id
