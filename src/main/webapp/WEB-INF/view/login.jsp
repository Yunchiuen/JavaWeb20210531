<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding: 20px">
        <form method="post" class="pure-form" >
            <fieldset>
                <legend>Login form</legend>
            <input name="username" type="text" placeholder="請輸入帳號" ><p /> 
            <input name="password" type="password" placeholder="請輸入密碼" ><p />
            <font color="red">${error}</fieldset>
            <button type="submit" class="pure-button pure-button-primary">登入</button>
            <button type="reset" class="pure-button pure-button-primary">重置</button>
            </fieldset>
        </form>
    </body>
</html>

