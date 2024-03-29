@fillFormPositive, @positive, @fillForm

Feature: Заполнение анкеты

  Scenario Outline: Добавление анкеты с заполнением полей валидными значениями
    Given Пользователь авторизован
    And находимся на странице с анкетой

    When вводим "<E-Mail>" в поле Email
    And вводим "<Имя>" в поле Имя

    When выбираем "<Пол>"
    Then в поле Пол отображается выбранный "<Пол>"

    When устанавливаем "<Вариант 1>" в разделе с чекбоксами
    Then в поле с чекбоксами выбран "<Вариант 1>"

    When выбираем "<Вариант 2>" из списка радиокнопок
    Then в поле с радиокнопками выбран "<Вариант 2>"

    When нажимаем на кнопку Добавить
    Then появляется уведомление об успешном добавлении данных
    And в таблице с данными отображаются все данные заполненной анкеты - "<E-Mail>", "<Имя>", "<Пол>", "<Вариант 1>", "<Вариант 2>"

    Examples:
      | E-Mail        | Имя       | Пол     | Вариант 1 | Вариант 2 |
      | Ivan@mail.ru  | Ivan      | Мужской | 1.1       | 2.3       |
      | Ivan@mail.ru  | Ivan      | Мужской | 1.2       | 2.2       |
      | Ivan@mail.ru  | Ivan      | Мужской | 1.2       | 2.1       |
      | Eva@mail.ru   | Eva       | Женский | 1.1       | 2.1       |
      | Eva@mail.ru   | Eva       | Женский | 1.1       | 2.2       |
      | Eva@mail.ru   | Eva       | Женский | 1.1       | 2.1       |
      | Eva@gmail.com | Eva       | Женский | 1.1       | 2.1       |
      | Eva@mail.ru   | Eva-Maria | Женский | 1.1       | 2.1       |


  Scenario Outline: Добавление анкеты с заполнением полей валидными значениями и c двумя выбранными чекбоксами
    Given Пользователь авторизован
    And находимся на странице с анкетой

    When вводим "<E-Mail>" в поле Email
    And вводим "<Имя>" в поле Имя

    When выбираем "<Пол>"

    When устанавливаем "<Вариант 1.1>" в разделе с чекбоксами
    And устанавливаем "<Вариант 1.2>" в разделе с чекбоксами
    Then в поле с чекбоксами выбраны оба варианта

    When выбираем "<Вариант 2>" из списка радиокнопок

    When нажимаем на кнопку Добавить
    Then появляется уведомление об успешном добавлении данных
    And в таблице с данными отображаются все данные заполненной анкеты - "<E-Mail>", "<Имя>", "<Пол>", "<Вариант 1.1>", "<Вариант 1.2>", "<Вариант 2>"

    Examples:
      | E-Mail       | Имя  | Пол     | Вариант 1.1 | Вариант 1.2 | Вариант 2 |
      | Ivan@mail.ru | Ivan | Мужской | 1.1         | 1.2         | 2.3       |