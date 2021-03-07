Feature: dev.to basic features
  Scenario: open first seen blog
    Given go to devto main page
    When click on first blog displayed
    Then should be redirected to blog page
  Scenario: go to podcasts, open first podcast
    Given go to devto main page
    When I click on podcasts
    And I click on first podcast displayed
    Then should be redirected to podcast
  Scenario: search for a phrase
    Given go to devto main page
    When I search for "programming" phrase
    Then top 3 blogs found should have the keyword in title
