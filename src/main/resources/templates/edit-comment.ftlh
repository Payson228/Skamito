<!DOCTYPE html>
<html>
<head>
    <title>Skamito</title>
</head>
<body>
<h1>Изменить товар</h1>
<form action="/edit/product/comment/${comment.id}" method="post">
    <label for="comment">Автор:</label>
    <input type="text" id="author" name="author" value="${comment.author}" required><br><br>

    <label for="text">Комментарий:</label><br>
    <textarea id="text" name="text" rows="4" cols="50" required>${comment.text}</textarea><br><br>

    <input type="submit" value="Сохранить изменения">
</form>
</body>
</html>