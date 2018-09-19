<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../shared/header.jsp"%>
<%@include file="../shared/navigation_doctor.jsp"%>


    <div class="content">
        <div class="from-info-treatment">
            <div class="info-treatment">
            <table class="info-treatment-table" border="1">
                <caption><h2>Выписка пациента</h2></caption>
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
                    <th>Выписать</th>
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

                        <c:if test="${treat.dateDischarge != null}">
                            <td>${treat.dateDischarge}</td>
                        </c:if>

                        <c:if test="${treat.finalDiagnosis != null}">
                            <td>${treat.finalDiagnosis}</td>
                        </c:if>
                        <form:form action="/discharge?idTreatment=${treat.idTreatment}" method="post">

                        <c:if test="${treat.dateDischarge == null}">
                        <td><label><input type="date" name="dateDischarge"></label></td>

                        <c:if test="${treat.finalDiagnosis == null}">
                        <td><label><input type="text" name="finalDiagnosis"></label></td>

                        <td><button type="submit">Выписать</button></td>
                            </c:if>
                            </c:if>
                            </form:form>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </div>
        </div>
    </div>
<%@include file="../shared/footer.jsp"%>
