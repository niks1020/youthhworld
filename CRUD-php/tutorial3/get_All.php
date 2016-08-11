<html>
<head>
<title> Fetch All Details</title>
</head>
<body>
<h3> Data Dump</h3>
<table>

<tr>
<th>id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Age</th>
<th>City</th>
</tr>
<?php 
include("connection.php");

$query="Select * from details";
$result=mysqli_query($conn,$query);

while($row=mysqli_fetch_array($result))
{
echo "<tr>";
echo "<td>".$row[0]."</td>";
echo "<td>".$row[1]."</td>";
echo "<td>".$row[2]."</td>";
echo "<td>".$row[3]."</td>";
echo "<td>".$row[4]."</td>";
echo "</tr>";
 
}


?>
</table>
</body>
</html>
