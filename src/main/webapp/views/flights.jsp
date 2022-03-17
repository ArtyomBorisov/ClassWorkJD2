<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="ru">
    <head>
        <meta charset="utf-8">
        <title>Рейсы</title>
    </head>
    <body>
         <table border="1">
            <tbody>
                <tr>
                    <td rowspan="2">Номер рейса</td>
                    <td rowspan="2">Код самолета</td>
                    <td colspan="2">Аэропорт</td>
                    <td colspan="2">Расписание</td>
                    <td colspan="2">Фактическое</td>
                </tr>
                <tr>
                    <td>Отправления</td>
                    <td>Прибытия</td>
                    <td>Время вылета</td>
                    <td>Время прилета</td>
                    <td>Время вылета</td>
                    <td>Время прилета</td>
                </tr>
                <c:forEach items="${requestScope.flights}" var="flight">
                    <tr>
                        <td>${flight.flightNum}</td>
                        <td>${flight.aircraftCode}</td>
                        <td>${flight.codeAirDepart}</td>
                        <td>${flight.codeAirArrival}</td>
                        <td>${flight.timeScheduleDepart}</td>
                        <td>${flight.timeScheduleArrival}</td>
                        <td><c:choose>
                                <c:when test="${flight.timeActualDepart} != null">
                                    ${flight.timeActualDepart}
                                </c:when>
                                <c:otherwise>
                                    -
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td><c:choose>
                                <c:when test="${flight.timeActualArrival} != null">
                                    ${flight.timeActualArrival}
                                </c:when>
                                <c:otherwise>
                                    -
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
         </table>
         <p>Страница: ${requestScope.page}. Количество записей: ${requestScope.size}.</p>
    </body>
</html>