
<?php
$return = json_decode('{"id":0,"imagen":[-119,80,78,71,13,10,26,10,0,0,0,13,73,72,68,82,0,0,0,6,0,0,0,5,8,2,0,0,0,-23,58,10,-79,0,0,0,1,115,82,71,66,0,-82,-50,28,-23,0,0,0,4,103,65,77,65,0,0,-79,-113,11,-4,97,5,0,0,0,9,112,72,89,115,0,0,14,-61,0,0,14,-61,1,-57,111,-88,100,0,0,0,35,73,68,65,84,24,87,99,-8,-113,1,64,66,111,101,84,32,36,-124,1,85,5,-25,3,1,84,21,-124,-113,-94,10,1,-2,-1,7,0,-8,-9,75,39,-67,-49,-62,104,0,0,0,0,73,69,78,68,-82,66,96,-126]}")
$imgData = base64_encode(implode($return->imagen));
$img = "<img src= 'data:image/png;base64, $imgData' />";
print($img);

