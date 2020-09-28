<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <form action="/mongo/insert" method="post">
            이름 : <input type="text" name="name" required>
            <br>
            나이 : <input type="number" name="age" required>
            <br>
            키 : <input type="number" name="height" required>
            <br>
            <input type="submit" value="submit">
        </form>
        <button onclick="location.href='/mongo/readMulti?key=&value='">전체 목록</button>
        <form action="/mongo/readMulti" method="get">
            키워드 :
            <label>
                <select name="key">
                    <option value="name">이름</option>
                    <option value="age">나이</option>
                    <option value="height">키</option>
                </select>
                <input type="search" name="value">
            </label>
            <input type="submit" value="검색하기">
        </form>
    </body>
</html>