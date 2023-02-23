# RELEX_test_assignment
# Биржа

Требуется разработать RESTfull API service — биржу для проведения торгов криптовалютами. 

### Обязательные требования:
* Spring Boot;
* возвращаемые данные в формате Json;

**Роли:** пользователь и администратор.
> В упрощенном варианте достаточно при получении запроса проверять полученный secret_key — если данный метод доступен только администратору и  secret_key тоже принадлежит  администратору, то выполнять операцию, а иначе возвращать http статус — 403 Forbidden
/* подключение Spring Security

