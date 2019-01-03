# jmx-demo

java -server -Dcom.sun.management.jmxremote.port=12345 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Djava.rmi.server.hostname=192.168.56.103 -cp "./jmx-demo-0.0.1-SNAPSHOT.jar" com.demo.jmx.Main
