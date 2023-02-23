# RELEX_test_assignment
# Биржа

Требуется разработать RESTfull API service — биржу для проведения торгов криптовалютами. 

### Обязательные требования:
* Spring Boot;
* возвращаемые данные в формате Json;
* хранилище данных.

**Роли:**
- [ ] пользователь
  - [ ] зарегистрироваться
  - [ ] пополнить кошелёк
  - [ ] вывести деньги
  - [ ] купить
  - [ ] продать
- [ ] администратор
  - [ ] изменить курс крипты
  - [ ] посмотреть статистику по всем кошелькам пользователей
  - [ ] статистику по торгам за определенный промежуток времени

> В упрощенном варианте достаточно при получении запроса проверять полученный secret_key — если данный метод доступен только администратору и  secret_key тоже принадлежит  администратору, то выполнять операцию, а иначе возвращать http статус — 403 Forbidden

`Доп.: подключение Spring Security`

**Хранилище:**
- [ ] .txt
  *или*
- [ ] PostgresSQL

**API:**
- [ ] User
  - [ ] registrate **POST**
    >username и email уникальны
    
    >**Responce:** unique hash
    
  - [ ] \*log in
  - [ ] \*log out
  - [ ] cash/check  **GET**
  - [ ] cash/in **POST**
  - [ ] cash/out **POST**
    > Проверка, есть ли достаточно валюты на счету.
  - [ ] cash/exchange **POST**
    > Проверка, есть ли достаточно денег на счету
  - [ ] cash/rate **GET**
- [ ] Admin
  - [ ] cash/rate **GET**
  - [ ] cash/rate/modify  **POST**
  - [ ] cash/total  **GET**
  - [ ] transaction/total **GET**
    
**Дополнительно:**
- [ ] Swagger
- [ ] Spring Security
- [ ] accept:application/json или accept:application/xml к HTTP-запросу
- [ ] верификация письмом
- [ ] сервис по запросу может возвращать данные в json ИЛИ xml.
- [ ] формат может быть изменен добавлением header

## Видеопрезентация: [Mock link](https://www.youtube.com/watch?v=oHg5SJYRHA0)
***
## Структура БД
![TAR2023BD drawio](https://user-images.githubusercontent.com/45429218/221036227-52434727-ae75-4bed-a3da-4053c7eec40d.png)

