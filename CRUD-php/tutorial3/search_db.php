<html>
<body>
<center>
<?php 

require ("connection.php");

if(isset($_POST['submit']))
{
 $filter=$_POST['filter'];
 $data=$_POST['data'];
 if($filter=='age' || $filter=='id' )
  $query="SELECT * from details where `$filter`='$data'"; 
 else
  $query="SELECT * from details where $filter like '$data%'";
 $result=mysqli_query($conn,$query);
 
 if($result)
 {
  echo "<h2> Details Fetched Are </h3><table border='2'><tr>
 <th>id</th>
 <th>First Name</th>
 <th>Last Name</th>
 <th>Age</th>
 <th>City</th>
 </tr>";
 
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
 }
 else
  echo "<h3> Not Found !</h3>";
}
else
 echo " <h1> Go To HelL : -p ......"
?>

</center>
</body>
</html>
