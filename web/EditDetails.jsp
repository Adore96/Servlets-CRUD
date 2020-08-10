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
                    <form action="update" method="post">
                        <h2>Edit User</h2><br>
                        <fieldset class="form-group">
                            <label>User ID</label> <input type="text"
                                                          value="<c:out value='${user.id}'/>" class="form-control"
                                                          name="id" readonly>
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Username</label> <input type="text"
                                                           value="<c:out value='${user.username}' />" class="form-control"
                                                           name="username" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Password</label> <input type="password"
                                                           value="<c:out value='${user.password}' />" class="form-control"
                                                           name="password" readonly>
                        </fieldset>

                        <fieldset class="form-group">
                            <label>User Department</label> <input type="text"
                                                                  value="<c:out value='${user.department}' />" class="form-control"
                                                                  name="department" list="department">
                            <datalist id="department">
                                <option value="Technical">
                                <option value="Finance">
                                <option value="Marketing">
                                <option value="Transportation">
                                <option value="HR">
                            </datalist>
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
