
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../shared/header.jsp"%>
<%@include file="../shared/navigation_doctor.jsp"%>



    <div class="content">
        <div class="from-info-treatment">
            <div class="info-treatment">
            <table class="info-treatment-table" border="1">
                <caption><h2>Список пользователей</h2></caption>
                <thead>
                <tr>
                    <th>Н/П</th>
                    <th>Фамилия</th>
                    <th>Имя</th>
                    <th>Отчество</th>
                    <th>Дата рождения</th>
                    <th>Логин</th>
                    <th>Пароль</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="u">
                    <tr>
                        <td>${u.idUser}</td>
                        <td>${u.lastName}</td>
                        <td>${u.firstName}</td>
                        <td>${u.patronymic}</td>
                        <td>${u.dateOfBirth}</td>
                        <td>${u.login}</td>
                        <td>${u.password}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            </div>
        </div>

        <div class="content">
            <form class="from-info-treatment" action="<c:url value="/list_users/addUser"/>" method="post">
                <div class="info-treatment">
                    <table class="info-treatment-table" border="1">
                        <caption><h2>Добавить лечение</h2></caption>
                        <thead>
                        <tr>
                            <th>Фамилия</th>
                            <th>Имя</th>
                            <th>Отчество</th>
                            <th>Дата рождения</th>
                            <th>Логин</th>
                            <th>Пароль</th>
                            <th>Добавить</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><label><input type="text" name="lastName"></label></td>
                            <td><label><input type="text" name="firstName"></label></td>
                            <td><label><input type="text" name="patronymic"></label></td>
                            <td><label><input type="date" name="dateOfBirth"></label></td>
                            <td><label><input type="text" name="login"></label></td>
                            <td><label><input type="text" name="password"></label></td>

                            <td><button type="submit">Добавить</button></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>

        <form action="<c:url value="/list_users/addIdPatient"/>" method="post">
            <div class="from-info-treatment">
                <div class="info-treatment">
                    <table class="info-treatment-table" border="1">
                        <caption><h2>Добавить регистрационный номер пациента</h2></caption>
                    <thead>
                    <tr>
                        <th>Номер пользователя</th>
                        <th>Добавить</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><label>
                            <input type="number" name="patientIdUser">
                        </label></td>
                        <td><button type="submit">Добавить</button></td>
                    </tr>
                    </tbody>
                    </table>
                </div>
            </div>
        </form>
    </div>
<%@include file="../shared/footer.jsp"%>