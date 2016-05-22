#!/bin/bash
EMAIL=$1
PASSWD=$2
URL=http://localhost:1337/soapbox-race/
USER_TOKEN=$(curl -s $URL"nothing/user/authenticateUser?email="$EMAIL"&password="$PASSWD)
IN=$USER_TOKEN
ARRIN=(${IN//./ })
USERID=${ARRIN[0]}
TOKEN=${ARRIN[1]}

echo USER: $USERID

wine explorer /desktop=SOAPBOX$EMAIL,800x600 soapbox.exe \
US $URL $TOKEN $USERID &> /dev/null

