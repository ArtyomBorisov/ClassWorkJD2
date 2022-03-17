<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="ru">
    <head>
        <meta charset="utf-8">
        <title>Поиск рейсов</title>
    </head>
    <body>
        <h1>Поиск рейсов</h1>
        <form action="/ClassWork/flights">
            <p>
                Аэропорт отправления
                <select size="1" name="airDep">
                    <option value="">Выберите аэропорт</option>
                    <c:forEach items="${requestScope.airports}" var="airport">
                        <option>${airport}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                Аэропорт прибытия
                <select size="1" name="airArr">
                    <option value="">Выберите аэропорт</option>
                    <c:forEach items="${requestScope.airports}" var="airport">
                        <option>${airport}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                Дата вылета по расписанию
                <input type="date" name="dayArr"></p>
            </p>
            <p>
                Количество записей на странице:
                <select size="1" name="size">
                    <option>20</option>
                    <option>15</option>
                    <option>10</option>
                    <option>5</option>
                </select>
            </p>
            <p>
                <input type="submit"  value="Подобрать">
            </p>
        </form>
    </body>
</html>