<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2048 game!</title>
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
<script type="text/javascript" src="resources/make2DArr.js"></script>
<script type="text/javascript" src="resources/2048_logic.js"></script>
<div>
<h2>2048 game!</h2>
<table id="2048_table"></table>
<br>
<div id="scoreBoard">Score : <span id="curScore"></span></div>
<button id="start-btn" onclick="startGame();">시작하기</button>
<button id="reset-btn" onclick="init_game();">다시하기</button>
<button id="rankingBoard" onclick="location.href='/game/rankingBoard?gameKind=2048'">점수보기</button>
</div>
</body>
</html>