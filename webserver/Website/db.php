<?php
$servername = "db.cu7kdxmko67m.eu-central-1.rds.amazonaws.com:3306";
$username = "IoT";
$password = "gummianka";
$dbname = "IoT";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$variable = $_GET["data"];

$sql = "INSERT INTO sys.Table (data) VALUES ('$variable')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>