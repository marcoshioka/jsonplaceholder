@jsonplaceholder
Feature: Get

  @get
  Scenario Outline: Retrieve resource
    Given the user retrieves '<resource>'
    When it uses the identification '<id>'
    Then it should returns '<title>'
    And status <code>

    Examples:
      | resource | id | title                                                                      | code |
      | posts    | 1  | sunt aut facere repellat provident occaecati excepturi optio reprehenderit | 200  |
      | posts    | 11 | et ea vero quia laudantium autem                                           | 200  |
      | posts    | 22 | dolor sint quo a velit explicabo quia nam                                  | 200  |
      | posts    | 33 | qui explicabo molestiae dolorem                                            | 200  |
      | posts    | 44 | optio dolor molestias sit                                                  | 200  |




