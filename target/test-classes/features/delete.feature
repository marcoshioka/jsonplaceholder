@jsonplaceholder
Feature: Delete

  @delete
  Scenario Outline: Delete a resource
    Given the user deletes '<resource>' with <id>
    When it returns response status <code>
    Then the response should be empty '<message>'

    Examples:
      | resource | id | code | message |
      | posts    | 1  | 200  |         |
      | posts    | 2  | 200  |         |
      | posts    | 3  | 200  |         |
      | posts    | 4  | 200  |         |
      | posts    | 5  | 200  |         |