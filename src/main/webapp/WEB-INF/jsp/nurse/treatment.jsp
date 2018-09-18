<%@include file="../shared/header.jsp"%>
<%@include file="../shared/navigation_nurse.jsp"%>

    <h2>Список лечений</h2>

    <div class="content">
        <div class="from-info-treatment">
            <div class="info-treatment">
                <table class="info-treatment-table" border="1">
                    <thead>
                    <tr>
                        <th>Н/Лечения</th>
                        <th>Н/Пациента</th>
                        <th>Н/Персонала</th>
                        <th>Дата поступления</th>
                        <th>Предварительный диагноз</th>
                        <th>Название лекарства</th>
                        <th>Тип лечения</th>
                        <th>Назначить лечение</th>
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

                            <c:if test="${treat.nameMedicines != null}">
                                <td>${treat.nameMedicines}</td>
                            </c:if>

                            <c:if test="${treat.typeTreatment != null}">
                                <td>${treat.typeTreatment}</td>
                            </c:if>
                            <form:form action="/treatment?idTreatment=${treat.idTreatment}" method="post">

                            <c:if test="${treat.nameMedicines == null}">
                            <td><label><input type="text" name="nameMedicines"></label></td>

                            <c:if test="${treat.typeTreatment == null}">
                            <td>
                                <label>
                                    <select size="1" name="typeTreatment">
                                        <option value="procedure">ПРОЦЕДУРЫ</option>
                                        <option value="medicament">МЕДИКАМЕНТЫ</option>
                                    </select>
                                </label>
                            </td>

                            <td><button type="submit">Назначить лечение</button>
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