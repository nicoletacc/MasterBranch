@regression
Feature: Testing the login positive an negative functionality

  Scenario: Validating the successful login for OpenMrs
    Given User navigates to the OpenMrs web application and provide credentials and location 'Inpatient Ward'
    Then User validates the title 'Home' and 'http://codefish.ninja/openmrs/referenceapplication/home.page'

  Scenario Outline: Validating the negative login for OpenMrs
    Given User navigates to the OpenMrs web applications and provides credentials '<username>', '<password>' and location '<location>'
    Then User validates the errors message 'Invalid username/password. Please try again.'
    Examples:
      | username | password | location          |
      | Ahmet    | Admin123 | Inpatient Ward   |
      | admin    | admin123 | Isolation Ward    |
      |          | Admin123 | Outpatient Clinic |
      | admin    |          | Registration Desk |