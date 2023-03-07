Feature: sample karate test script
  for help, see: https://github.com/intuit/karate/wiki/IDE-Support

  Background:
    * url 'https://petstore.swagger.io/v2/pet/'

    Scenario: Find a pet and then get it by id
    Given path 'findByStatus'
    And param status = 'available'
    When method get
    Then status 200


  Scenario: Find a pet and then get it by id
    Given path 'findByStatus'
    And param status = ''
    When method get
    Then status 400

  Feature: Create a pet
  Scenario: create a pet
    * def pet =
  {
  "id": 123456,
  "name": "Fluffy",
  "status": "available"
  }

    And request pet
    When method post
    Then status 200


    * def id = response.id
    * print 'created id is: ', id

