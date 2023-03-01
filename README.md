# RELEX_test_assignment
# Биржа
# Видеопрезентация: [link](https://drive.google.com/drive/folders/18PvWD-rAovmzwYA_kUDcd_sJDYA8fbCu?usp=sharing)
***
## Краткое описание исходного задания:
Требуется разработать RESTfull API service — биржу для проведения торгов криптовалютами.
### Обязательные требования:
* Spring Boot;
* возвращаемые данные в формате Json;
* хранилище данных.
* роли: админ/пользователь
### Дополнительно:
- [ ] Swagger ***(сделан Postman)***
- [x] PostgreSql
- [ ] Spring Security
- [ ] accept:application/json или accept:application/xml к HTTP-запросу
- [ ] верификация письмом
- [ ] сервис по запросу может возвращать данные в json ИЛИ xml.
- [ ] формат может быть изменен добавлением header
> В упрощенном варианте достаточно при получении запроса проверять полученный secret_key — если данный метод доступен только администратору и  secret_key тоже принадлежит  администратору, то выполнять операцию, а иначе возвращать http статус — 403 Forbidden
***
# Реализация
## Подробно про технологии:
- SpringBoot
- Gradle
- Postgres + Liquibase для менеджмента скриптов
- Hibernate
- JPA (JpaRepository) для гибких запросов в бд
- WebMVC
- Mapstruct
- JavaX Validators
- Lombok (@RequiresArgsConstructor, @Getter/@Setter)
- SpringSecurity.TextEncryptor (для генерации строки по некоторому уникальному полю приходящего дто)

## Допы:
- тесты для API через Postman 
> Приглашение для workspace: https://app.getpostman.com/join-team?invite_code=b8f2c5577b1cae7a8ae397be1432ebfe&target_code=363abd10cf151dbf8448435771af1129
>
> После принятия может выскочить ошибка 500, это нормально, так как приглашение уже будет недействительным. Ниже название и айдишник, чтобы найти его в своем профиле Postman.
>
> Workspace Id: 666c2991-2828-445d-aa44-1e1a945e3391
>
> Workspace Name: CryptoTrade_Relex2023
> 
> Воркспейс выглядит следующим образом:
> 
> <img src="_screenshots/img_28.png" width="300">

- кастомные валидаторы для почты и логина (@EmailUnique, @LoginUnique)
- логгер SLF4J для вывода сообщений о запрошенных операциях в консоль
- безопасность простейшим способом (через проверку secretKey)

***

## Структура БД
![img.png](_screenshots/img.png))

***
## Подробно про API:
Предполагается, что все манипуляции приложением будут идти через личный
кабинет (например, так сделано во многих банковских приложениях с 
инвестициями и прочим), поэтому вся работа с валютой и транзакциями будет
включать в пути _users/{userID}_. 

### Пользователь:
- создать нового пользователя

<img src="_screenshots/img_4.png" width="600">

- удалить пользователя

<img src="_screenshots/img_1.png" width="300">

- список всех

<img src="_screenshots/img_2.png" width="300">

### Администратор:
- Создание нового администратора

<img src="_screenshots/img_3.png" width="600">

- Удаление администратора

<img src="_screenshots/img_5.png" width="300">

- Список всех

<img src="_screenshots/img_6.png" width="300">

### Валюта:
- Список всех валют

<img src="_screenshots/img_7.png" width="300">

- Создание валюты

<img src="_screenshots/img_8.png" width="300">

- Удаление валюты

<img src="_screenshots/img_9.png" width="300">

- Сумма по валюте
  
<img src="_screenshots/img_10.png" width="600">
<img src="_screenshots/img_11.png" width="600">

### Обменные коээфициенты:
- для двух конкретных валют
 
<img src="_screenshots/img_13.png" width="300">

- все обменные к-ты

<img src="_screenshots/img_12.png" width="300">

- изменить обменный к-т

<img src="_screenshots/img_14.png" width="300">

- создать обменный к-т

<img src="_screenshots/img_15.png" width="300">

- удалить обменный к-т

<img src="_screenshots/img_16.png" width="300">

### Транзакции
- вывести валюту

<img src="_screenshots/img_17.png" width="300">

- внести валюту

<img src="_screenshots/img_18.png" width="300">

- перевести валюту с кошелька на кошелек (и обменять при этом, если нужно)

<img src="_screenshots/img_19.png" width="300">

- история транзакций пользователя

<img src="_screenshots/img_20.png" width="300">

- вся история транзакций

<img src="_screenshots/img_21.png" width="300">

- число транзакций в заданном промежутке времени

<img src="_screenshots/img_22.png" width="300">

### Счета (кошельки)
- все кошельки списком

<img src="_screenshots/img_23.png" width="300">

- все кошельки одного пользователя

<img src="_screenshots/img_24.png" width="300">

- конкретный кошелек

<img src="_screenshots/img_25.png" width="300">

- создать кошелек

<img src="_screenshots/img_26.png" width="300">

- удалить кошелек

<img src="_screenshots/img_27.png" width="300">