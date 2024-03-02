<%--
  Created by IntelliJ IDEA.
  User: Park
  Date: 2024-02-10
  Time: 오후 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Member Read</title>
    <%--bootstrap css--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row mt-5">
        <div class="col">

            <h2 class="mb-4">${memberDTO.name}님의 회원 정보</h2>

                <%--이름--%>
                <div class="input-group mb-3">
                    <span class="input-group-text">이름</span>
                    <input type="text" name="name" class="form-control" value="${memberDTO.name}" readonly>
                </div>
                <%--아이디--%>
                <div class="input-group mb-3">
                    <span class="input-group-text">아이디</span>
                    <input type="text" name="id" class="form-control" value="${memberDTO.id}" readonly>
                </div>
                <%--패스워드--%>
                <div class="input-group mb-3">
                    <span class="input-group-text">패스워드</span>
                    <input type="password" name="pw" class="form-control" value="${memberDTO.pw}" readonly>
                </div>
                <%--나이--%>
                <div class="input-group mb-3">
                    <span class="input-group-text">나이</span>
                    <input type="text" name="age" class="form-control" value="${memberDTO.age}" readonly>
                </div>

                <%--성별--%>
                <div class="row mb-3">
                    <div class="col-md-2">
                        <h6 class="d-inline">성별</h6>
                    </div>
                    <div class="col-md-10">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="남자" ${memberDTO.gender=='남자' ? 'checked':''} disabled>
                            <label class="form-check-label">남자</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="여자" ${memberDTO.gender=='여자' ? 'checked':''} disabled>
                            <label class="form-check-label">여자</label>
                        </div>
                    </div>
                </div>

                <div class="row mb-4">
                    <div class="col-md-2">
                        <h6 class="d-inline">취미</h6>
                    </div>
                    <div class="col-md-10">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" name="hobby" value="술먹기" ${memberDTO.hobby.contains("술먹기") ? 'checked':''} disabled>
                            <label class="form-check-label">술먹기</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" name="hobby" value="잠자기" ${memberDTO.hobby.contains("잠자기") ? 'checked':''} disabled>
                            <label class="form-check-label">잠자기</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" name="hobby" value="공부하기" ${memberDTO.hobby.contains("공부하기") ? 'checked':''} disabled>
                            <label class="form-check-label">공부하기</label>
                        </div>
                    </div>
                </div>

                <h6>가고 싶은 여행지는?</h6>
                <select class="form-select mb-3" name="travel" disabled>
                    <option ${memberDTO.travel == '괌' ? 'selected':''} disabled>괌</option>
                    <option ${memberDTO.travel == '다낭' ? 'selected':''} disabled>다낭</option>
                    <option ${memberDTO.travel == '나트랑' ? 'selected':''} disabled>나트랑</option>
                    <option ${memberDTO.travel == '코나키나발루' ? 'selected':''} disabled>코나키나발루</option>
                    <option ${memberDTO.travel == '대만' ? 'selected':''} disabled>대만</option>
                </select>

                <div class="form-floating mb-5">
                    <textarea class="form-control" name="content" readonly>${memberDTO.content}</textarea>
                    <label>Comments</label>
                </div>

                <div class="d-flex justify-content-end">
                    <button type="reset" class="btn btn-secondary me-1" onclick="location.href='modify?tno=${memberDTO.tno}'">수정/삭제</button>
                    <button type="button" class="btn btn-outline-dark me-1" onclick="location.href='list'">목록</button>
                </div>

            </form>

        </div>   <%--col end--%>
    </div>   <%--row end--%>
</div>   <%--container end--%>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
