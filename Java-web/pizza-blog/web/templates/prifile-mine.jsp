<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h1>{username}</h1>
    <table class = "table table-striped">
        <caption>Topics</caption>
        <thead>
        <tr>
            <th>Title</th>
            <th>Category</th>
            <th>Date</th>
            <th>Replies Count</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><a href="#">{Title}</a></td>
            <td><a href="#">{Category}</a></td>
            <td>02/03/2017 10:40:00</td>
            <td>120</td>
            <td><a href="#" class="btn btn-danger">Delete</a></td>
        </tr>
        </tbody>
    </table>
</div>
