<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Document</title>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
<div>
        <table>
            <tr>
                <td width="50px"></td>
                <td>${item.title}</td>
            </tr>
            <tr>
                <td></td>
                <td><span>${item.editer}</span> | &nbsp;<span>${item.date}</span></td>
            </tr>
            <tr height="400px">
                <td>내용</td>
                <td>${item.text}</td>
            </tr>
            <tfoot>
            <tr>
                <td style="text-align: left"><button onclick="location.href='/back'">목록</button></td>
                <td style="text-align: right"><button onclick="location.href='/editor/${item.id}'">수정</button></td>
            </tr>
            </tfoot>
        </table>
</div>
</body>
</html>
