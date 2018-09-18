<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="shared/header.jsp"%>
<%@include file="shared/navigation.jsp"%>

    <form class="from-auth" action="<c:url value="/login"/>" method="post">
        <fieldset>
            <legend>Авторизация</legend>
            <spring:bind path="user.login">
                <div class="auth-login" ${status.error ? 'has-error' : ''}>
                    <label>Логин</label>
                    <input type="text" name="login" placeholder="Введите логин" required="required">
                </div>
                <form:errors path="user.login" />
            </spring:bind>

            <spring:bind path="user.password">
                <div class="auth-password" ${status.error ? 'has-error' : ''}>
                    <label>Пароль</label>
                    <input type="password" name="password" placeholder="Введите пароль" required="required">
                </div>
                ${error}
                <form:errors path="user.password" />
            </spring:bind>


            <spring:bind path="role">
                <div ${status.error ? 'has-error' : ''}>
                    <label>Роль</label>
                    <label>
                        <select size="1" name="role" style="overflow: hidden;">
                            <option value="doctor">DOCTOR</option>
                            <option value="nurse">NURSE</option>
                        </select>
                    </label>
                </div>
                <form:errors path="role"/>
            </spring:bind>

            <div  class="auth-btn">
                <button type="submit">Войти</button>
            </div>
        </fieldset>
    </form>
<%@include file="shared/footer.jsp"%>
