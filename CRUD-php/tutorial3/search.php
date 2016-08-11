<html>
<head><title>Search Details</title></head>
<body>

<center>
<h2>Search Data </h2>
<table border="2px"> 
<form name="form1" action="search_db.php" method="POST">
<tr>
<td >Search For:</td>
<td>
<select name="filter" required="required">
<option value="">Select Filter</option>
<option value="id">id</option>
<option value="first_name">First Name</option>
<option value="last_name">Last Name</option>
<option value="age">Age</option>
<option value="city">City</option>
</select>
</td>
</tr>

<tr>
<td>Data To be Searched :</td>
<td><input type="text" name="data" required="required" placeholder="Enter Search Data !" /></td>

</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" name="submit" value="Submit !"/>
</td>
</tr>

</form>
</table>
</body>
</html>
