<?php 
if(isset($_POST))
{
 include("connection.php");
 $first_name=$_POST['first_name'];
 $last_name=$_POST['last_name'];
 $city=$_POST['city'];
 $age=$_POST['age'];
 
 $query= "INSERT into `details`(`first_name`,`last_name`,`city`,`age`) values('$first_name','$last_name','$city','$age')";
 $result= mysqli_query($conn,$query) or die(mysqli_error($conn));
 
 echo "<script> 
 alert('Data Inserted Successfuly');
        window.location='insert_form.html';
     </script>";
}

?>
