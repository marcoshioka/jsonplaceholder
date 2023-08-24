@jsonplaceholder
Feature: Post

  @post
  Scenario Outline: Create new resource
    Given the user creates '<resource>', with name '<title>', message '<body>' and id <userId>
    When it gets status <code>
    Then it should contains the same name '<title>', message '<body>' and id <userId>

    Examples:
      | resource | userId | title   | body                    | code |
      | posts    | 1      | Title 1 | This is the first body  | 201  |
      | posts    | 2      | Title 2 | This is the second body | 201  |
      | posts    | 3      | Title 3 | This is the third body  | 201  |
      | posts    | 4      | Title 4 | This is the fourth body | 201  |
      | posts    | 5      | Title 5 | This is the fifth body  | 201  |





