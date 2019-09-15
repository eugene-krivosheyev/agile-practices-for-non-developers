@FR
Feature: Get all users
  As a Operations I want get user details for report.

  Background:
    Given: Application is running on port 8080

  Scenario: Get all users
    When REST-client make GET request to '/api/client/1'
      And REST-client supply HTTP header 'X-API-VERSION' as '1'
