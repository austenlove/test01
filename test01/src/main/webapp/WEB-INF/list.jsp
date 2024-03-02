<%--
  Created by IntelliJ IDEA.
  User: 804-03
  Date: 2024-02-05
  Time: 오후 5:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Member List</title>
    <%--bootstrap css--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class="container">

    <h2 class="mt-5 mb-3">Member List</h2>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">no</th>
            <th scope="col">name</th>
            <th scope="col">id</th>
            <th scope="col">password</th>
            <th scope="col">age</th>
            <th scope="col">gender</th>
            <th scope="col">hobby</th>
            <th scope="col">travel</th>
            <th scope="col">content</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${memberDTOList}" var="dto">
            <tr>
                <th scope="row">${dto.tno}</th>
                <td>${dto.name}</td>
                <td>${dto.id}</td>
                <td>${dto.pw}</td>
                <td>${dto.age}</td>
                <td>${dto.gender}</td>
                <td>${dto.hobby}</td>
                <td>${dto.travel}</td>
                <td>${dto.content}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="d-flex justify-content-end mb-3">
        <button type="button" class="btn btn-primary" onclick="location.href='register'">회원등록</button>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>