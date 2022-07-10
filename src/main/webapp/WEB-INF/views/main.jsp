<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>게시판</title>
    <link rel="stylesheet" href="./style.css"/>
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
                <td>${item.id}</td>
                <td><a href="/${item.id}">${item.title}</a></td>
                <td>${item.editer}</td>
                <td align="center"><fmt:formatDate pattern = "yyyy-MM-dd" value = "${item.date}" /></td>
            </tr>
        </c:forEach>
        <tfoot>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td style="text-align: right">
                <button onclick="location.href='/writes'">글쓰기</button>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
</body>
</html>
