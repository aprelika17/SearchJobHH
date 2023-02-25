# Проект по тестированию сайта hh.ru
> <a target="_blank" href="https://hh.ru/">Ссылка на сайт</a>

![This is an image](/forReadMe/images/hhrumain.jpg)

#### Список проверок, реализованных в автотестах
- [x] Поиск компании в каталоге и проверка верности открытой карточки
- [x] Поиск конкретной вакансии и проверка нужного стека
- [x] Поиск вакансии "удаленная работа" и проверка любой выпавшей в поиске на наличие этого условия
- [x] В карточке заданной компании присутствует кнопка "Я хочу тут работать"
- [x] Проверка ввода некорректного email после нажатия "Я хочу тут работать"
#### Список проверок ручного тестирования
- [x] Поиск вакансии в заданном городе
- [x] Адаптивность вёрстки главной страницы

## Проект реализован с использованием
Java Gradle IntelliJ IDEA Selenide Selenoid JUnit5 Jenkins Allure Report Allure TestOps Telegram Jira

![This is an image](/forReadMe/icons/Java.png)![This is an image](/forReadMe/icons/Gradle.png)![This is an image](/forReadMe/icons/Intelij_IDEA.png)![This is an image](/forReadMe/icons/Selenide.png)![This is an image](/forReadMe/icons/Selenoid.png)![This is an image](/forReadMe/icons/JUnit5.png)![This is an image](/forReadMe/icons/Jenkins.png)![This is an image](/forReadMe/icons/Allure_Report.png)![This is an image](/forReadMe/icons/AllureTestOps.png)![This is an image](/forReadMe/icons/Telegram.png)![This is an image](/forReadMe/icons/Jira.png)


# Запуск автотестов выполняется на сервере Jenkins
> <a target="_blank" href="https://jenkins.autotests.cloud/job/menkovaJenkinsHHru/">Ссылка на проект в Jenkins</a>

### Параметры сборки

* login (default user1)
* password (default 1234)
* test_group (default remote_test). Параметр определяет группу тестов для запуска.

##  Запуск тестов из терминала
### Локальный запуск тестов

```
gradle clean remote_test

```

### Удаленный запуск тестов

```
export BROWSER=$(echo "${BROWSER}" | awk '{print $1}')
export VERSION=$(echo "${BROWSER}" | awk '{print $2}')

./gradlew clean remote_test\
 "-Dbrowser=${BROWSER}"\
"-Dversion=${VERSION}"\
"-Dresolution=${RESOLUTION}"\
"-Dselenoid=${SELENOID}"

```

> `${BROWSER}` - наименование браузера (_по умолчанию - <code>chrome</code>_).
> 
> `${VERSION}` - номер версии браузера (_по умолчанию - <code>100.0</code>_).
> 
> `${RESOLUTION}` - размер окна браузера (_по умолчанию - <code>1920x1080</code>_).
>
> `${SELENOID}` - адрес удаленного сервера, на котором будут запускаться тесты.

<a id="jenkins"></a>
## Запуск тестов в Jenkins

> Сборка с параметрами позволяет перед запуском изменить параметры для сборки (путем выбора из списка или прямым указанием значения).

<p align="center">
<img src="images/screenshots/JenkinsJob.png"/></a>
</p>

### Для запуска автотестов в Jenkins
#### 1. Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/menkovaJenkinsHHru/">проект</a>

![This is an image](/design/images/jenkins1.png)

#### 2. Выбрать пункт **Собрать с параметрами**
#### 3. В случае необходимости изменить параметры, выбрав значения из выпадающих списков
#### 4. Нажать **Собрать**
#### 5. Результат запуска сборки можно посмотреть в отчёте Allure

![This is an image](/design/images/jenkins2a.png)

## Локальный запуск автотестов
Пример командной строки:
```bash
gradle clean remote_test -Dlogin=user1 -Dpassword=1234 -DtestUrl=selenoid.autotests.cloud/wd/hub/
```

Получение отчёта:
```bash
allure serve build/allure-results
```

# Полная статистика по прохождению тестпланов, отчёты и приложения к ним хранятся в Allure TestOps
> <a target="_blank" href="https://allure.autotests.cloud/project/1918">Сссылка на проект в AllureTestOps</a> (запрос доступа admin@qa.guru)

### Тест-планы проекта
![This is an image](/design/images/testplans.png)
### Кейсы тест-плана выполнения ручного тестирования
![This is an image](/design/images/manual.png)
### Кейсы тест-плана выполнения автотестирования
![This is an image](/design/images/auto.png)
### Общий список всех кейсов, имеющихся в системе (без разделения по тест-планам и виду выполнения тестирования)
![This is an image](/design/images/testcases.png)
### Пример dashboard с общими результатами тестирования
![This is an image](/design/images/dashboard_all.png)
### В том числе сводная статистика запусков
![This is an image](/design/images/dashboard_all2.png)

### Пример отчёта выполнения одного из автотестов
![This is an image](/design/images/onecasereport.png)
#### *После окончания выполнения автотестов по каждому из них в отчёте доступны скриншоты и исходный код страницы, лог консоли браузера и видеозапись выполнения теста.*

### Пример видеозаписи прохождения теста
![This is an image](/design/images/Video.gif)


## По результатам ручного тестирования выявлены дефекты, зафиксированные в соответствующих задачах AllureTestOps
### Тест план выполнения ручного тестирования
![This is an image](/design/images/testplan2.png)
### Сводные результаты ручного тестирования
![This is an image](/design/images/failedresult.png)
### Пример описания дефекта в Allure TestOps
![This is an image](/design/images/testops2.png)
### Список выявленных дефектов, открытых как задачи в Allure TestOps
![This is an image](design/images/defects.png)

# Результаты выполнения тестов и информация о выявленных дефектах интегрированы с Atlassian Jira
> <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-286">Ссылка на задачу в Jira</a> (запрос доступа admin@qa.guru)

Задачи на выявленные дефекты оформлены как подзадачи к данной. Связаны с соответствующими дефектами в Allure TestOps

![This is an image](/design/images/jira_n.png)

# Настроено автоматическое оповещение о результатах сборки Jenkins в Telegram-бот
![This is an image](/design/images/bot.png)


:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>
