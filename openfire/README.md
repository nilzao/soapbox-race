Using openfire 4.0.2

    http://www.igniterealtime.org/downloads/index.jsp#openfire

- install openfire


windows:

- place openfired.vmoptions file inside openfire bin folder.

linux:

- edit /opt/openfire/bin/openfire file, put:

    INSTALL4J_ADD_VM_PARAMS=" -Djsse.enableCBCProtection=false"

---

remove mechanisms tag:

need to remove tag <mechanisms xmlns="urn:ietf:params:xml:ns:xmpp-sasl"> to work with soapbox.exe

- go inside openfire.jar
- rename the file  SASLAuthentication.classx to  SASLAuthentication.class and replace the org/jivesoftware/openfire/net/SASLAuthentication.class file

---

change xmpp.domain

go to url:

    http://localhost:9090/server-properties.jsp

- find xmpp.domain
- set xmpp.domain to your ip
- Save

---

install restApi plugin

go to url:

    http://localhost:9090/available-plugins.jsp

find and add REST API plugin

go to url:

    http://localhost:9090/plugins/restapi/rest-api.jsp

- set Enabled
- set Secret key auth - REST API authentication over specified secret key
- copy the Secret key (need it later to start server)
- Save Settings

---

disable compression

go to url:

    http://localhost:9090/compression-settings.jsp

- Disable
- Save

---

disable register

go to url:

    http://localhost:9090/reg-settings.jsp
    
- Disable
- Save
