<!DOCTYPE html>
<html>
<head>
    <title>Skamito</title>
</head>
<body>
<h1>Skamito</h1><hr>
<h4>Подробная информация о товаре</h4>
<#list images as img>
    <img src="/images/${img.id}" height = "100px"/><br><br>
</#list>
<b>Название товара: </b>${product.title}<br>
<b>Описание товара: </b>${product.description}<br>
<b>Цена: </b>${product.price}<br>
<b>Город: </b>${product.city}<br>
<b>Автор: </b>${product.author}<br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар"/>
</form>
<form action="/product/edit/${product.id}" method="get">
    <input type="submit" value="Изменить товар"/>
</form>
<h4>Комментарии к объявлению:</h4>
<#list product.comments as com>
    <div>
    <p><b>${com.author}:</b> ${com.text}</p>
</div>
</#list>
<hr>
<h4>Добавить комментарий:</h4>
<form action="/product/${product.id}/comment" method="post">
    Комментарий: <input type="text" name="text"/><br><br>
    Имя пользователя: <input type="text" name="author"/><br><br>
    <input type="submit" value="Добавить комментарий"/>
</form>
<hr>

</body>
</html>