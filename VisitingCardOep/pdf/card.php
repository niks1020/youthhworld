<?php 
//SETTING UP THE MEMORY LIMIT FOR THE SAFE SIDE USE OF MPDF MODULE.
ini_set("memory_limit","9999999M");

include('mpdf/mpdf.php');
$mpdf=new mPDF('','', 0, '', 0, 0, 0, 0, 0, 0, 'P');

//$html CONTAINS THE HTML STRRING WHICH WILL PE PRINTED ON PDF.
$html=
'<html>
    </head> 
    <body>
       <center>';

//$path VARIBALE STORES THE PATH OF IMAGE TEMPLATE.
  $path = '..\cards\1.jpg';
//SPECIFYING X-Y COORDINATES FOR TEXT STRING
  $x1_h = 30;   $y1_h = 80;
  $x2_h = 30;   $y2_h = 100;
  $x3_h = 30;   $y3_h = 120;
  $x4_h = 30;   $y4_h = 160;
  $x5_h = 90;   $y5_h = 160;
  $x6_h = 90;   $y6_h = 180;
  $x7_h = 90;   $y7_h = 200;
  
  $font = 'trebuchet-ms.ttf';
  if(isset($_POST['submit'])){
        $event_name=$_POST['name'];
        $image = imagecreatefromjpeg($path);
        $string1=$_POST['name'];
        $string2= "Email: ".$_POST['email'];
        $string3= "Contact: ".$_POST['contact1'];
		$string4= "Address: ";
		$string5= $_POST['building'].", ".$_POST['street'];
		$string6= $_POST['city'].", ".$_POST['state'];
		$string7= $_POST['country']." - PIN: ".$_POST['pincode'];
        if(isset($_POST['contact2'])){
			$string3.=", ".$_POST['contact2'];
		}
        imagettftext($image, 40, 0, $x1_h, $y1_h, $black, $font, $string1);
        imagettftext($image, 12, 0, $x2_h, $y2_h, $black, $font, $string2);
        imagettftext($image, 12, 0, $x3_h, $y3_h, $black, $font, $string3);
        imagettftext($image, 12, 0, $x4_h, $y4_h, $black, $font, $string4);
        imagettftext($image, 12, 0, $x5_h, $y5_h, $black, $font, $string5);
        imagettftext($image, 12, 0, $x6_h, $y6_h, $black, $font, $string6);
        imagettftext($image, 12, 0, $x7_h, $y7_h, $black, $font, $string7);
        $imagename="abc";
        $image1.= '<img class="side" style="width:100%" src="../cardsGenerated/'.$imagename.'.jpg"><br/><br/><br/><br/><br/><br/>';
        imagejpeg($image,  $fileName = "..\cardsGenerated\\$imagename.jpg", $quality = 100);
}
$html.=$image1;
$html.='</center>
</body>
</html>';
$mpdf->WriteHTML($html);
$mpdf->Output();
exit;
?>