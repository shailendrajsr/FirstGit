<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html>
<html>
 <head>
 <title>Image File Upload</title>
 </head>
 <body>
<h1>File Upload Example - JavaTpoint</h1>

<h3 style="color:red">${filesuccess}</h3>
<form:form method="post" action="savefile" enctype="multipart/form-data">
<p><label for="image">Choose Image</label></p>
<p><input name="file" id="fileToUpload" type="file" /></p>
<p><input type="submit" value="Upload"></p>
</form:form>
<form:form method="post" action="savefile" enctype="multipart/form-data">
<p><label for="image">Choose Image</label></p>
<p><input name="file" id="fileToUpload" type="file" /></p>
<p><input type="submit" value="Upload"></p>
</form:form>
<form:form method="post" action="savefile" enctype="multipart/form-data">
<p><label for="image">Choose Image</label></p>
<p><input name="file" id="fileToUpload" type="file" /></p>
<p><input type="submit" value="Upload"></p>
</form:form>
<form:form method="post" action="savefile" enctype="multipart/form-data">
<p><label for="image">Choose Image</label></p>
<p><input name="file" id="fileToUpload" type="file" /></p>
<p><input type="submit" value="Upload"></p>
</form:form>

<form:form method="post" action="submitfor" enctype="multipart/form-data">

<p><input type="submit" value="SubmitForUpload"></p>
</form:form>
</body>
</html>

