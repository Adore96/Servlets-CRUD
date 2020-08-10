<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kasun_k
  Date: 8/10/2020
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <title>Student Details Update</title>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <form action="FinalUpdate" method="post">
                        <h2>Edit User</h2><br>
                        <fieldset class="form-group">
                            <label>First Name</label> <input type="text"
                                                          value="<c:out value='${user.fname}'/>" class="form-control"
                                                          name="fname" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Last Name</label> <input type="text"
                                                           value="<c:out value='${user.lname}' />" class="form-control"
                                                           name="lname" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Username</label> <input type="text"
                                                           value="<c:out value='${user.username}' />" class="form-control"
                                                           name="username" readonly>
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Password</label> <input type="password"
                                                           value="<c:out value='${user.password}' />" class="form-control"
                                                           name="password" readonly>
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Mobile Number</label> <input type="number"
                                                           value="<c:out value='${user.telephone}' />" class="form-control"
                                                           name="telephone" required="required">
                        </fieldset>

                        <input type="submit" class="btn btn-success" value="Update">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
