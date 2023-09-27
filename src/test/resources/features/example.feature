Feature: Form
  The user submits the form with his information

  Scenario Outline: Information submited successfully
    Given User gets into webpage and goes to form page
    When User submit the information
      | userName   | passWord   | textAreaComment   | fileName   | checkboxItems   | radioItems   | multipleSelectValues   | dropDown   |
      | <userName> | <passWord> | <textAreaComment> | <fileName> | <checkboxItems> | <radioItems> | <multipleSelectValues> | <dropDown> |
    Then The information is displayed

    Examples:
      | userName | passWord | textAreaComment | fileName | checkboxItems | radioItems | multipleSelectValues | dropDown |
      | Carlitos | 123456   | Hola mundo      | null     | 1             | 3          | 2                    | 1        |
