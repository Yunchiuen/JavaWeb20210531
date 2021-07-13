<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>招聘</title>
        <meta charset="UTF-8">
        <!--線上icon製作-->
        <link rel="icon" href="../icons/favicon.ico" type="image/x-icon" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css" >
    </head>
    <body style="padding: 20px"><!--上下左右20px空白-->
        <form class="pure-form" method="post" action="/JavaWeb20210531/controller/recruit">
            <fieldset>
                <legend>招聘</legend>
                <img src="../images/person.png" width="40" valign="middle"/>
                <input type="number" placeholder="請輸入人數" name="amount"/>
                <button type="submit" class="pure-button pure-button-primary">submit</button>
            </fieldset>
        </form>
    </body>
</html>

