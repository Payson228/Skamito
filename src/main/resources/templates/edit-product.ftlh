<!DOCTYPE html>
<html>
<head>
    <title>Skamito</title>
</head>
<body>
<h1>Изменить товар</h1>
<form action="/product/edit/${product.id}" method="post">
    <label for="title">Название товара:</label>
    <input type="text" id="title" name="title" value="${product.title}" required><br><br>

    <label for="description">Описание товара:</label><br>
    <textarea id="description" name="description" rows="4" cols="50" required>${product.description}</textarea><br><br>

    <label for="price">Цена:</label>
    <input type="number" id="price" name="price" value="${product.price}" required><br><br>

    <label for="city">Город:</label>
    <input type="text" id="city" name="city" value="${product.city}" required><br><br>

    <label for="author">Автор:</label>
    <input type="text" id="author" name="author" value="${product.author}" required><br><br>

    <input type="submit" value="Сохранить изменения">
</form>
</body>
</html>