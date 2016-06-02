# soapbox-race

webserver to handle cars and pilots profiles.

to build need apache maven and jdk8

https://maven.apache.org/

http://www.oracle.com/technetwork/java/javase/downloads/

build:

    mvn clean compile assembly:single

#####to run the server use:

    java -Djsse.enableCBCProtection=false -jar soapbox-race-version-jarname.jar

---

#####to run the client use:

for player 1:

    soapbox.exe US http://localhost:1337/soapbox/ a 1

for player 2:

    soapbox.exe US http://localhost:1337/soapbox/ a 2 