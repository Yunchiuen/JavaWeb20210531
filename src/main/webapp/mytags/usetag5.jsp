<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="/tlds/mytld"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <my:exchange symbol="USDTWD=x" />
        </h1>
        <h1>
            <my:exchange symbol="TWDUSD=x" />
        </h1>
        <h1>
            <my:exchange symbol="12345678" />
        </h1>
        
    </body>
</html>
