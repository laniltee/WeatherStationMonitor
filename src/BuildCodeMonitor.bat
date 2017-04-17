javac *.java
rmic MonitorProxy
copy MonitorProxy_Stub.class ..\..\WeatherStationServer\src /Y
java MonitorUI