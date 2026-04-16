<!DOCTYPE html>
<html>
<head>
    <title>Histarttestservice</title>
</head>
<body>
<h1>TestService</h1>
<h4>Все товары</h4>
<form action="/" method="get">
    Поиск по названию товара: <input type="text" name="title"><br>
    <input type="submit" value="Поиск">

</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b>${product.price} руб.| <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
    <#else>
        <h3>Товаров нет</h3>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post">
    Название товара: <input type="text" name="title"/><br><br>
    Описание товара: <input type="text" name="description"/><br><br>
    Цена: <input type="number" step="0.01" name="price"/><br><br>
    Город: <input type="text" name="city"/><br><br>
    Автор: <input type="text" name="author"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>