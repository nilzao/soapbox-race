#!/bin/bash
NUMBER=$1
wine explorer /desktop=SOAPBOX$NUMBER,800x600 soapbox.exe \
US http://localhost:1337/soapbox/ \
a $NUMBER &> /dev/null
