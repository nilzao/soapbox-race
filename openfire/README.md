Using openfire 4.0.2

    http://www.igniterealtime.org/downloads/index.jsp#openfire
    http://www.igniterealtime.org/downloads/download-landing.jsp?file=openfire/openfire_4_0_2.tar.gz
    http://www.igniterealtime.org/builds/openfire/openfire_4_0_2.tar.gz

- install openfire
- edit /opt/openfire/bin/openfire file, put:

    INSTALL4J_ADD_VM_PARAMS=" -Djsse.enableCBCProtection=false"

---

remove mechanisms tag:

need to remove tag <mechanisms xmlns="urn:ietf:params:xml:ns:xmpp-sasl"> to work with soapbox.exe

    http://localhost:9090/server-properties.jsp

set sasl.mechs to empty string

but stop working with new xmpp libs (smack, xmpp rocks)

go inside openfire.jar, replace org/jivesoftware/openfire/net/SASLAuthentication.class file

with the SASLAuthentication.classx

---

change soapbox Xmpp Srv port:

inside class br.com.soapboxrace.xmpp.XmppSrv 

find line with:

    ServerSocket listener = new ServerSocket(5222);

and change port number to avoid conflict with openfire

---

create user:

    http://localhost:9090/user-create.jsp
    
user name: nfsw.PERSONA_ID  (example nfsw.100, nfsw.200, nfsw.300)

user pass: 1234567890123456 (just like  br.com.soapboxrace.engine.User first 16 token text)

---

showing online users:

you can see personas online in this link:

    http://localhost:9090/user-summary.jsp

---

debug:

to debug openfire responses, create user nfsw.102 and use python file:

    debug-openfire.py

---

test send:

    http://localhost:9090/user-message.jsp

