<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../shared/header.jsp"%>
<%@include file="../shared/navigation_doctor.jsp"%>

    <div class="content">
        <div class="from-info-treatment">
            <div class="info-treatment">
            <table class="info-treatment-table" border="1">
                <caption><h2>Список диагнозов</h2></caption>
                <thead>
                <tr>
                    <th>Н/Лечения</th>
                    <th>Н/Пациента</th>
                    <th>Н/Персонала</th>
                    <th>Дата поступления</th>
                    <th>Предварительный диагноз</th>
                    <th>Название лекарства</th>
                    <th>Тип лечения</th>
                    <th>Дата выписки</th>
                    <th>Финальный диагноз</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${treatments}" var="treat">
                <tr>
                    <td>${treat.idTreatment}</td>
                    <td>${treat.patientId}</td>
                    <td>${treat.roleId}</td>
                    <td>${treat.dateReception}</td>
                    <td>${treat.preliminaryDiagnosis}</td>
                    <td>${treat.nameMedicines}</td>
                    <td>${treat.typeTreatment}</td>
                    <td>${treat.dateDischarge}</td>
                    <td>${treat.finalDiagnosis}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            </div>
        </div>
    </div>

    <div class="content">
        <form class="from-info-treatment" action="<c:url value="/add_diagnosis/add"/>" method="post">
            <div class="info-treatment">
            <table class="info-treatment-table" border="1">
                <caption><h2>Добавить диагноз</h2></caption>
                <thead>
                <tr>
                   <th>Н/Пациента</th>
                   <th>Н/Персонала</th>
                   <th>Дата поступления</th>
                   <th>Предварительный диагноз</th>
                   <th>Добавить</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><label><input type="number" name="patientId"></label></td>
                    <td><label><input type="number" name="roleId"></label></td>
                    <td><label><input type="date" name="dateReception"></label></td>
                    <td><label><input type="text" name="preliminaryDiagnosis"></label></td>

                    <td><button type="submit">Добавить</button></td>
                </tr>
                </tbody>
            </table>
            </div>
        </form>
    </div>
<%@include file="../shared/footer.jsp"%>
