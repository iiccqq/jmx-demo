
java -Dcom.sun.management.jmxremote.port=12345 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=true -Dcom.sun.management.jmxremote.authenticate=true -Dcom.sun.management.jmxremote.access.file=./jmxremote.acce -Dcom.sun.management.jmxremote.password.file=./jmxremote.password -Djava.rmi.server.hostname=192.168.123.128  -cp "./*" Main


192.168.123.128:12345

jconsole
jvisualvm

