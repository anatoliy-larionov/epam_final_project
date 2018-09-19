<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../shared/header.jsp"%>
<%@include file="../shared/navigation_patient.jsp"%>

        <div class="content">
            <div class="from-info-treatment">
                <div class="info-treatment">
                    <table class="info-treatment-table" border="1">
                        <caption><h2>Информация о диагнозах и лечений</h2></caption>
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
                        <c:forEach items="${treatment}" var="treatment">
                            <tr>
                                <td>${treatment.idTreatment}</td>
                                <td>${treatment.patientId}</td>
                                <td>${treatment.roleId}</td>
                                <td>${treatment.dateReception}</td>
                                <td>${treatment.preliminaryDiagnosis}</td>
                                <td>${treatment.nameMedicines}</td>
                                <td>${treatment.typeTreatment}</td>
                                <td>${treatment.dateDischarge}</td>
                                <td>${treatment.finalDiagnosis}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
<%@include file="../shared/footer.jsp"%>
