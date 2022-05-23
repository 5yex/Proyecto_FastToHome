
<?php
$imgData = "iVBORw0KGgoAAAANSUhEUgAAAAYAAAAFCAIAAADpOgqxAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAjSURBVBhXY/iPAUBCb2VUICSEAVUF5wMBVBWEj6IKAf7/BwD490snvc/CaAAAAABJRU5ErkJggg==";
$img = "<img src= 'data:image;base64, $imgData' />";
print($img);


file_put_contents( "imagenes/prueba.png", base64_decode($imgData));

