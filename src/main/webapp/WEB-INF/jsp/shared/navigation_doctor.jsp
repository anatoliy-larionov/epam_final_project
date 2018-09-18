<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="menu-top">
    <header>
        <div>
            <nav>
                <a href="<c:url value="/list_users"/>">Список пользователей</a>
                <a href="<c:url value="/add_diagnosis"/>">Добавить диагноз</a>
                <a href="<c:url value="/add_treatment"/>">Добавить лечение</a>
                <a href="<c:url value="/discharge"/>">Выписать пациента</a>
                <a class="reg-url" href="<c:url value="/index"/> ">Выход</a>
            </nav>
        </div>
    </header>
</div>