<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="shared/header.jsp"%>
<%@include file="shared/navigation.jsp"%>

    <form class="form-registration" action="<c:url value="/registration"/>" method="post">
        <fieldset>
            <legend>Регистрация</legend>
            <div>
                <label>Фамилия
                    <input type="text" name="lastName" placeholder="Введите фамилию" id="last-name" required>
                    <div id="valid-last-name"></div>
                </label>
            </div>
            <div>
                <label>Имя
                    <input type="text" name="firstName" placeholder="Введите имя" id="first-name" required>
                    <div id="valid-first-name"></div>
                </label>
            </div>
            <div>
                <label>Отчество
                    <input type="text" name="patronymic" placeholder="Введите отчество" id="patronymic" required>
                    <div id="valid-patronymic"></div>
                </label>
            </div>
            <div>
                <label>Дата рождения
                    <input type="date" name="dateOfBirth" placeholder="" id="date-of-birth" required>
                </label>
            </div>
            <div>
                <label>Логин
                    <input type="text" name="login" placeholder="Введине логин" class="login" required>
                    <div id="valid-login"></div>
                </label>
            </div>
            <div>
                <label>Пароль
                    <input type="password" name="password" placeholder="Введите пароль" class="password" required>
                    <div id="valid-password"></div>
                </label>
            </div>
            <div class="reg-btn">
                <label>
                    <input type="submit" value="Зарегистрироваться" name="sing-up" id="sing-up">
                </label>
            </div>
        </fieldset>
    </form>
<%@include file="shared/footer.jsp"%>
