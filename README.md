# README
Тестирование почты mail.ru

## Requirements

- скачаны желаемые seleniumDrivers
- или развернут seleniumHub c доступом к нодам с желаемыми seleniumDrivers

## Configuring
Для использования seleniumHub:
- В файле `test_mail/pom.xml` в секции `properties` заменить значение свойства `selenium.hub.url` на актуальное. Default: http://127.0.0.1:4444/wd/hub.
- В файле `test_mail/pom.xml` в секции `build` раскомментить `-Dremote=${selenium.hub.url}` у плагина maven-surefire-plugin.

Для использования локальных драйверов:
- В PATH должны быть прописаны пути до желаемых seleniumDrivers
- Или в файле `test_mail/pom.xml` в секции `build` у плагина maven-surefire-plugin раскомментить/добавить соответствующие системные свойства и указать актуальные пути до seleniumDrivers

Для выбора целевого браузера:
- В файле `test_mail/testng.xml` изменить значение параметра `selenium.browser` на желаемый браузер. Default: gecko.

## Running tests
Отредактировать файл с тестовыми данными `test_mail/src/test/resources/mailTestData.xlsx` в соответствии с подготовленной учеткой и письмами.
В директории test_mail выполнить:
```
	$ mvn
```

## View report

В директории test_mail выполнить:
```	
	$ mvn allure:serve
```
