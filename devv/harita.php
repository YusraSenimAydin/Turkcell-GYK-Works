<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8"/>
<?php
$enlem='36.584014';
$boylam='36.163995'; 



if(isset($_POST['konum']))
{
	$enlem_boylam=explode(",",$_POST['konum']);
	$enlem=$enlem_boylam[0];
	$boylam=$enlem_boylam[1];

}
if(isset($_POST['enlem'])&&isset($_POST['boylam']))
{
	
$dosya=fopen('konum.txt','a');
fwrite($dosya,$_POST['enlem'].",".$_POST['boylam']."-");
fclose($dosya);
}
else
{
	try{
	
$dosya=fopen('konum.txt','r');
$boyut=filesize('konum.txt');
$veri=fread($dosya,$boyut);
fclose($dosya);
$konum=explode("-",$veri);

	}
	catch(Exception $ex)
	{
		echo $ex->getMessage();
	}
?>
    <title>Yusra Dede</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	 <script src="http://api-maps.yandex.ru/2.0/?load=package.full&lang=tr-TR" type="text/javascript"></script>
<script type="text/javascript">
ymaps.ready(init);
function init () {
   var myMap = new ymaps.Map('map', {
           center: [<?php echo $enlem;?>, <?php echo $boylam;?>],
           zoom: 12
       }),
       myPlacemark = new ymaps.Placemark([<?php echo $enlem;?>, <?php echo $boylam;?>], {
           content: 'İskenderun!',
           balloonContent: 'Buradasınız!!!!'
       });
   myMap.controls
       .add('searchControl', { left:5, top: 5 })
       .add('smallZoomControl', { left: 5, top: 165 })
       .add('typeSelector')
       .add('mapTools', { left: 5, top: 460 })
       .add('trafficControl', { left: 270, top: 5 });
               myMap.geoObjects.add(myPlacemark);
}
</script>
</head>
<body>
<table >
<tr><td align="center">
<form method="post">
<select name="konum" id="konum" onchange='this.form.submit()' >
<option value="Seçiniz...">Konum Bilgileri</option> 
<?php
for($i=0;$i<count($konum)-1;$i++){
?>
<option value="<?php echo $konum[$i];?>"><?php echo $konum[$i];?></option> 
<?php }?>
</select>
</form>
</td></tr><tr><td align="center" valign="middle">
<?php 
	
}
?>
    <div id="map" style="width:1000px; height:800px;"></div>
</td>
</tr>
</table>
</body>
</html>