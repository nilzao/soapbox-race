# soapbox-race

webserver to handle cars and pilots profiles.

to build need apache maven and jdk8

https://maven.apache.org/

http://www.oracle.com/technetwork/java/javase/downloads/

build:
mvn clean compile assembly:single

#####to run the server use:

    java -Djsse.enableCBCProtection=false -jar soapbox-race-version-jarname.jar your-ip-to-host-xmpp (optional)

example:

    java -Djsse.enableCBCProtection=false -jar soapbox-race-version-jarname.jar 127.0.0.1

---

users / password hashes:

debug@player1	a94a8fe5ccb19ba61c4c0873d391e987982fbbd3
debug@player2	a94a8fe5ccb19ba61c4c0873d391e987982fbbd3
debug@player3	a94a8fe5ccb19ba61c4c0873d391e987982fbbd3

to use the client, access browser at url:

    http://localhost:1337/soapbox/nothing/user/authenticateUser?email=SOME_EMAIL&password=SOME_HASH_PASSWORD

examples:

    user1
    http://localhost:1337/soapbox/nothing/user/authenticateUser?email=debug@player1&password=a94a8fe5ccb19ba61c4c0873d391e987982fbbd3
    
    user2
    http://localhost:1337/soapbox/nothing/user/authenticateUser?email=debug@player2&password=a94a8fe5ccb19ba61c4c0873d391e987982fbbd3
    
    user3
    http://localhost:1337/soapbox/nothing/user/authenticateUser?email=debug@player3&password=a94a8fe5ccb19ba61c4c0873d391e987982fbbd3

your browser show a response like this:

    <LoginData><UserId>n</UserId><LoginToken>zzzzzzzzzzzzzzzz</LoginToken></LoginData>

next, you call soapbox.exe with the parameters: 

    soapbox.exe US http://localhost:1337/soapbox/Engine.svc zzzzzzzzzzzzzzzz n
    
---

A launcher is on the way

https://github.com/berkay2578/soapbox-race-launcher

for more users, insert userid, email and passowrd in table user
