<?php 
$conn=mysqli_connect("localhost","root","","test_db") or die(mysql_error());
/*The above code is having a function mysqli which takes four parameters.
First parameter tells the host name
Second parameter tells the username of database (default is root)
Third Parameter is password of database(which is by default nothing hence
only pair of double quotes are passed.
fourth parameter is the database name.
After that the "or die()" function is used to stop the page from being scanned 
after that line of code if in case the database connection fails 
and it will display the mysql_error() instead.
*/
?>
