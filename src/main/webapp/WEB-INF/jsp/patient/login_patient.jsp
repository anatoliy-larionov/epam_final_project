
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../shared/header.jsp"%>
<%@include file="../shared/navigation_patient.jsp"%>

    <form class="from-auth" action="<c:url value="/login_patient"/>" method="post">
        <fieldset>
            <legend>Авторизация</legend>
            <spring:bind path="user.login">
                <div class="auth-login" ${status.error ? 'has-error' : ''}>
                    <label>Логин</label>
                    <input type="text" name="login" placeholder="Введите логин" required="required">
                </div>
                <form:errors path="user.login" cssClass="error"/>
            </spring:bind>

            <spring:bind path="user.password">
                <div class="auth-password" ${status.error ? 'has-error' : ''}>
                    <label>Пароль</label>
                    <input type="password" name="password" placeholder="Введите пароль" required="required">
                </div>
                <form:errors path="user.password" cssClass="error"/>
            </spring:bind>

            <div  class="auth-btn">
                <button type="submit">Войти</button>
            </div>
        </fieldset>
    </form>
<%@include file="../shared/footer.jsp"%>
