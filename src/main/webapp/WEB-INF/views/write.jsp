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
    <form>
        <table>
            <tr>
                <td width="50px"></td>
                <td><input type="text" name="title" id="title" value="title" size="70" maxlength="255"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <span><input type="text" name="editor" id="editor" value="editor" size="9" maxlength="20"/></span>
                    | &nbsp;<span>2022-07-10</span>
                </td>
            </tr>
            <tr height="400px">
                <td>내용</td>
                <td><textarea name="text" id="text" rows="25"></textarea></td>
            </tr>
            <tfoot>
            <tr>
                <td style="text-align: left"><input type="reset" value="취소" formaction="/back"/></td>
                <td style="text-align: right"><input type="submit" value="글쓰기" formaction="" formmethod="post"/></td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>
