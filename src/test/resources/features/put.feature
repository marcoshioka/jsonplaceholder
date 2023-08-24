@jsonplaceholder
Feature: Put

  @put
  Scenario Outline: Update an existing resource
    Given the user updates an existing '<resource>', with name '<title>', message '<body>', user id <userId> and id <id>
    When it returns status <code>
    Then it should contains name '<title>', message '<body>', user id <userId> and id <id>

    Examples:
      | resource | id | userId | title           | body                            | code |
      | posts    | 1  | 1      | Title 1 updated | This is the first body updated  | 200  |
      | posts    | 2  | 2      | Title 1 updated | This is the second body updated | 200  |
      | posts    | 3  | 3      | Title 1 updated | This is the third body updated  | 200  |
      | posts    | 4  | 4      | Title 1 updated | This is the fourth body updated | 200  |
      | posts    | 5  | 5      | Title 1 updated | This is the fifth body updated  | 200  |





