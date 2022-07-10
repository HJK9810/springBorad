<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="./style.css" />
</head>
<body>
<div>
    <table>
        <tr>
            <td width="40px">id</td>
            <td>title</td>
            <td width="100px">editor</td>
            <td width="100px" align="center">date</td>
        </tr>
        <c:forEach var="item" items="${list}" varStatus="status">
            <tr>
                <td>${item}</td>
                <td>제목${item}</td>
                <td>작성자${item}</td>
                <td align="center">2022-07-10</td>
            </tr>
        </c:forEach>
        <tfoot>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td style="text-align: right"><button>글쓰기</button></td>
        </tr>
        </tfoot>
    </table>
</div>
</body>
</html>
