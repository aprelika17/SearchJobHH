<h1 >Проект по тестированию сайта <a href="https://hh.ru/ ">hh.ru</a></h1>

## Содержание

* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Реализованные проверки</a>
* <a href="#console">Запуск тестов из терминала</a>
* <a href="#jenkins">Запуск тестов в Jenkins</a>
* <a href="#allure">Отчеты в Allure</a>
* <a href="#testops">Интеграция с Allure TestOps</a>
* <a href="#testops">Интеграция с Jira</a>
* <a href="#telegram">Уведомления в Telegram с использованием бота</a>
* <a href="#video">Пример прогона теста в Selenoid</a>

<a id="tools"></a>
## Технологии и инструменты

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="forReadMe/icons/IntelliJ_IDEA.png">
<img width="6%" title="Java" src="forReadMe/icons/Java_logo.png">
<img width="6%" title="Selenide" src="forReadMe/icons/Selenide.png">
<img width="6%" title="Selenoid" src="forReadMe/icons/Selenoid.png">
<img width="6%" title="Allure Report" src="forReadMe/icons/AllureReports.png">
<img width="6%" title="Gradle" src="forReadMe/icons/Gradle.png">
<img width="6%" title="JUnit5" src="forReadMe/icons/JUnit5.png">
<img width="6%" title="GitHub" src="forReadMe/icons/GitHub.png">
<img width="6%" title="Jenkins" src="forReadMe/icons/Jenkins.png">
<img width="6%" title="Allure TestOps" src="forReadMe/icons/AllureTestOps.svg">
</p>

Автотесты написаны на <code>Java</code> с использованием <code>JUnit 5</code> и <code>Gradle</code>.
Для UI-тестов использован фреймворк [Selenide](https://selenide.org/).
Запуск тестов можно осуществлять локально или с помощью [Selenoid](https://aerokube.com/selenoid/).
Также реализована сборка в <code>Jenkins</code> с формированием Allure-отчета и отправкой уведомления с результатами в <code>Telegram</code> после завершения прогона.

Allure-отчет включает в себя:
* шаги выполнения тестов;
* скриншот страницы в браузере в момент окончания автотеста;
* Page Source;
* логи браузерной консоли;
* видео выполнения автотеста.

<a id="cases"></a>
## Реализованные проверки

### Автоматизированные проверки
- [ ] Поиск компании в каталоге и проверка верности открытой карточки
- [ ] Поиск конкретной вакансии и проверка нужного стека
- [ ] Поиск вакансии "удаленная работа" и проверка любой выпавшей в поиске на наличие этого условия
- [ ] В карточке заданной компании присутствует кнопка "Я хочу тут работать"
- [ ] Проверка ввода некорректного email после нажатия "Я хочу тут работать"

### Мануальные проверки
- [ ] Поиск вакансии в заданном городе
- [ ] Адаптивность вёрстки главной страницы

<a id="console"></a>
##  Запуск тестов из терминала
### Локальный запуск тестов

```
gradle clean run_tests 
```

### Удаленный запуск тестов

```
export BROWSER_PLATFORM=$(echo "${BROWSER}" | awk '{print $1}')
export BROWSER_VERSION=$(echo "${BROWSER}" | awk '{print $2}')

./gradlew clean run_tests \
  -Dbrowser=${BROWSER} \
  -Dversion=${VERSION} \
  -DwindowSize=${RESOLUTION} \
  -DremoteUrl=${SELENOID}
```

> `${BROWSER}` - наименование браузера (_по умолчанию - <code>chrome</code>_).
> 
> `${VERSION}` - номер версии браузера (_по умолчанию - <code>100.0</code>_).
> 
> `${RESOLUTION}` - размер окна браузера (_по умолчанию - <code>1366x768</code>_).
>
> `${SELENOID}` - адрес удаленного сервера, на котором будут запускаться тесты.

<a id="jenkins"></a>
## Запуск тестов в Jenkins

> Сборка с параметрами позволяет перед запуском изменить параметры для сборки (путем выбора из списка или прямым указанием значения).

<p align="center">
<img src="/forReadMe/images/jenkinsStartRun.jpg"/></a>
</p>

<a id="allure"></a>
## Отчеты в Allure

### Основное окно

<p align="center">
<img src="/forReadMe/images/allureReport.jpg">
</p>

### Тесты

<p align="center">
<img src="/forReadMe/images/allureReportTests.jpg">
</p>

<a id="testops"></a>
## Интеграция с Allure TestOps 

### Тест-кейсы
<p align="center">
<img src="/forReadMe/images/allureTestOps.jpg">
</p>

### Пример мануального тест-кейса
<p align="center">
<img src="/forReadMe/images/allureTestOpsManual.jpg">
</p>

### Пример запуска тест-кейсов
<p align="center">
<img src="/forReadMe/images/allureReportTestsStartRun.jpg">
</p>

<a id="jira"></a>
## Интеграция с Jira 
<p align="center">
<img src="/forReadMe/icon/Jira.png">
</p>

<a id="telegram"></a>
## Уведомления в Telegram с использованием бота

<p>
<img src="/forReadMe/images/telegram.jpg">
</p>

<a id="video"></a>
## Пример прогона теста в Selenoid

> К каждому тесту в отчете прилагается видео
<p align="center">
  <img src="/forReadMe/images/hhru_video.gif">
</p>
