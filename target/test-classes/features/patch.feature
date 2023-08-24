@jsonplaceholder
Feature: Patch

  @patch
  Scenario Outline: Modify a resource partially
    Given the user retrieves '<resource>'
    And it uses the identification '<id>'
    And it should returns '<title>'
    And status <code>
    When the user updates that '<resource>' id <id> with just the name to '<newTitle>'
    Then the status received should be <code>
    And the <id> should be the same
    But the title must be the updated '<newTitle>'

    Examples:
      | resource | id | title                                                                      | code | newTitle                        |
      | posts    | 1  | sunt aut facere repellat provident occaecati excepturi optio reprehenderit | 200  | Just title Updated with Patch 1 |
      | posts    | 11 | et ea vero quia laudantium autem                                           | 200  | Just title Updated with Patch 2 |
      | posts    | 22 | dolor sint quo a velit explicabo quia nam                                  | 200  | Just title Updated with Patch 3 |
      | posts    | 33 | qui explicabo molestiae dolorem                                            | 200  | Just title Updated with Patch 4 |
      | posts    | 44 | optio dolor molestias sit                                                  | 200  | Just title Updated with Patch 5 |




