#!/bin/bash
EMAIL=$1
PASSWD=$2
URL=http://localhost:1337/soapbox-race/
SRV_RESPONSE=$(curl -s $URL"nothing/user/authenticateUser?email="$EMAIL"&password="$PASSWD)
IN=$SRV_RESPONSE
ARRIN=(${IN//>/ })
USERID=${ARRIN[2]}
USERID=${USERID//[^0-9]/}
TOKEN=${ARRIN[4]}
TOKEN=${TOKEN//[^0-9]/}

echo SRV: $SRV_RESPONSE
echo USER: $USERID
echo TOKEN: $TOKEN
echo

wine explorer /desktop="SOAPBOX["$USERID"]"$EMAIL,800x600 soapbox.exe \
US $URL $TOKEN $USERID &> /dev/null
