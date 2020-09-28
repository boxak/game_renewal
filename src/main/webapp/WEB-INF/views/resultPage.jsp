<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Result Page</title>
        <script>
            alert("result of ${action}"+ " : " +"${result}");
            document.location.href = "${header.referer}";
        </script>
    </head>
    <body>
    </body>
</html>