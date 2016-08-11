<?php
include("Connection.php");
if($conn==true) //This line checks weather the connection variable's 
                //is connected to database or not.
 echo "Connected!";
else 
 echo "Not Connected!";
?>
