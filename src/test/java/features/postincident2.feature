Feature: Post Incident

  Scenario Outline: Post incident scenario
    Given I am create the resources with endpoint
    And I am allowing the authetication
    And I am adding the headers and body of the request as "<description>" and "<category>"
    When I am sending the request
    Then I validate the response
    Then I print the sys_id
    
    Examples:
    |description|category|
    #1st Data
    |test for software|software|
    #2nd Data
    |test for hardware|hardware|