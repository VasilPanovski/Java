<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="home.jsp"/>
<div class="container">
    <form method="POST" action="">
        <label>Title</label>
        <div class="form-group">
            <input type="text" name="title" class="form-control" placeholder="Enter subject..." required>
        </div>
        <div class="form-group">
            <label>Content</label>
            <textarea name="content" class="form-control" placeholder="Enter your message..." required></textarea>
        </div>
        <div class="form-group">
            <label>Category</label>
            <select name="category" class="form-control" required>
                <option value="">Category 1</option>
                <option value="">Category 2</option>
                <option value="">Category 3</option>
            </select>
        </div>
        <input type="submit" class="btn btn-primary" value="Publish"/>
    </form>
</div>
