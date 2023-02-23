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
    
    >{
	
	>"username": "vasya_vezunchik",
	
	>"email": "vasyu_kolbasit@mail.ru"
    
    >}
    
    >**Responce:** unique hash
    
    >{
    
    >   "secret_key": "AAFeyWzOnlD-9G4i662PdKn2B-b4BwrCNA",
    
    >}
  - [ ] \*log in
  - [ ] \*log out
  - [ ] cash/check  **GET**
    >{
    
    >   "secret_key": "AAFeyWzOnlD-9G4i662PdKn2B-b4BwrCNA"
    
    >}
  - [ ] cash/in **POST**
    >{
    
    >   "secret_key": "AAFeyWzOnlD-9G4i662PdKn2B-b4BwrCNA",
    
    >   "RUB_wallet": "1000"
    
    >}
  - [ ] cash/out **POST**
  > Проверка, есть ли достаточно валюты на счету.
  >{
	
	>   "secret_key": "AAFeyWzOnlD-9G4i662PdKn2B-b4BwrCNA",
	
	>   "currency": "RUB",
	
	>   "count": "1500",
	
	>   "credit_card": "1234 5678 9012 3456"
  
  >}

*ИЛИ*

>{
	
	>   "secret_key": "AAFeyWzOnlD-9G4i662PdKn2B-b4BwrCNA",
	
	>   "currency": "TON",
	
	>   "count": "15",
	
	>   "wallet": "AsS5A2SASd2as3q5sd2asd53a1s5"
  
  >}
  
  >**Response:**
  
  >{
	
	>   "RUB_wallet": "3000"
  
  >}
  - [ ] cash/exchange **POST**
    
    > Проверка, есть ли достаточно денег на счету
    
    >{
	  
	  >   "secret_key": "AAFeyWzOnlD-9G4i662PdKn2B-b4BwrCNA",
	  
	  >   "currency_from": "RUB",
	  
	  >   "currency_to": "TON",
	  
	  >   "amoun": "2000"
    
    >}
    
    >**Response:**
    
    >{
	  
	  >"currency_from": "RUB",
	  
	  >"currency_to": "TON",
	  
	  >"amount_from": "2000",
	  
	  >"amount_to": "11.11"

    >}
  - [ ] cash/rate **GET**
    >{
	
	>     "secret_key": "AAFeyWzOnlD-9G4i662PdKn2B-b4BwrCNA",
	
	>     "currency": "TON"
    
    >}
    
    >**Response:**
    
    >{
     
     >	"BTC": "0.00009564",
	
     >  "RUB": "180"
    
    >}
- [ ] Admin
  - [ ] cash/rate **GET**
    >{
    
    > 	"secret_key": "AAFeyWzOnlD-9G4i662PdKn2B-b4BwrCNA",
	
    >	"currency": "TON"
    
    >}
    
    >**Responce:**
    
    >{
	 
	 >"BTC": "0.00009564",
	 
	 >"RUB": "180"
    
    >}
  - [ ] cash/rate/modify  **POST**
    >{
	 
	 >"secret_key": "1071daaabf1cda35d207030c898d07ff16c934b7"
	 
	 >"base_currency": "TON",
	 
	 >"BTC": "0.000096",
	 
	 >"RUB": "184"
    
    >}
    
    >**Responce:**
    
    >{
      	
	>"BTC": "0.000096",
	
	>"RUB": "184"
    
    >}
  - [ ] cash/total  **GET**
    >{
      
      >	"secret_key": "1071daaabf1cda35d207030c898d07ff16c934b7",
  
      > "currency": "RUB"
    
    >}
    
    >**Responce:**
    
    >{
	
	>"RUB": "15006813",
    
    >}
  - [ ] transaction/total **GET**
    >{
      
      >	"secret_key": "1071daaabf1cda35d207030c898d07ff16c934b7"
	
      > "date_from": "18.02.2023",
  
      > "date_to": "19.02.2023"
    
    >}
    
    >**Responce:**
    
    >{
      
      >	"transaction_count": "154"
    
    >}
    
**Дополнительно:**
- [ ] Swagger
- [ ] Spring Security
- [ ] accept:application/json или accept:application/xml к HTTP-запросу
- [ ] верификация письмом
- [ ] сервис по запросу может возвращать данные в json ИЛИ xml.
- [ ] формат может быть изменен добавлением header

**Видеопрезентация:** [Mock link](https://www.youtube.com/watch?v=oHg5SJYRHA0)


