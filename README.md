# README

## Requirements

- скачаны желаемые seleniumDrivers
- или развернут seleniumHub c доступом к нодам с желаемыми seleniumDrivers

## Configuring
Для использования seleniumHub:
- В файле `test_mail/pom.xml` в секции `properties` заменить значение свойства `selenium.hub.url` на актуальное. Default: http://127.0.0.1:4444/wd/hub.
- В файле `test_mail/pom.xml` в секции `build` раскомментить `-Dremote=${selenium.hub.url}` у плагина maven-surefire-plugin.

Для выбора целевого браузера:
- В файле `test_mail/testng.xml` изменить значение параметра `selenium.browser` на желаемый браузер. Default: gecko.

## Running tests

В директории test_mail выполнить:
```
	$ mvn
```

## View report

В директории test_mail выполнить:
```	
	$ mvn allure:serve
```
