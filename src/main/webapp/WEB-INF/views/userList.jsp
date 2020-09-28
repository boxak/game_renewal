<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.example.mongo.entity.UserEntity" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>List Page</title>
    </head>
    <body>
        <div>
            <table>
                <tr>
                    <th>이름</th>
                    <th>나이</th>
                    <th>키</th>
                </tr>
                <c:if test="${userEntity != null}" var="user">
                    <tr>
                        <td>${user.name}</td>
                        <td>${user.age}</td>
                        <td>${user.height}</td>
                        <td><a href="/mongo/delete?_id=${entity._id}">삭제</a></td>
                    </tr>
                </c:if>
                <c:if test="${list != null}">
                    <c:forEach var="entity" items="${list}">
                        <tr>
                            <td>${entity.name}</td>
                            <td>${entity.age}</td>
                            <td>${entity.height}</td>
                            <td><a href="/mongo/delete?_id=${entity._id}">삭제</a></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
            <button onclick="location.href='${header.referer}'">입력 화면으로 가기</button>
        </div>
    </body>
</html>