<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Snake Game!</title>
<style>
	table{
		width : 450px;
		height : 400px;
		border : 1px solid black;
		border-collapse: collapse;
	}

</style>
</head>
<body>
<script type="text/javascript" src="resources/Queue.js"></script>
<script type="text/javascript" src="resources/Pair.js"></script>
<script type="text/javascript" src="resources/make2DArr.js"></script>
<script type="text/javascript" src="resources/snake_logic.js"></script>
<div style="position:absolute;top:10%;left:30%;text-align:center">
<h2>Snake Game!</h2>
<table id="snake_table">
</table>
<br>
<button id="start-btn" onclick="gameStart();">시작하기</button>
<button id="reset-btn" onclick="init_game()">다시 시작</button>
<button id="ranking-btn" onclick="location.href='/game/rankingBoard?gameKind=snake'">점수 보기</button>
</div>
</body>
</html>