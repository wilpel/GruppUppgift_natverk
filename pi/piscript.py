from urllib.request import urlopen
import time
import random

while True:

	sensorData = random.uniform(0, 100)

	content = urlopen("http://172.20.200.170/Website/db.php?data="+str(sensorData)).read()
	print("sending: "+str(sensorData))
	time.sleep(1)