#!/usr/bin/env python

import socket, ssl
from ssl import PROTOCOL_TLSv1

BUFSIZE = 4096

#before ssl
cliPktA = '''<?xml version='1.0' ?><stream:stream to='nils-pc' xmlns='jabber:client' xmlns:stream='http://etherx.jabber.org/streams' version='1.0' xml:lang='en'>'''
cliPktB = '''<starttls xmlns='urn:ietf:params:xml:ns:xmpp-tls'/>'''

#after ssl
cliPktC = '''<?xml version='1.0' ?><stream:stream to='nils-pc' xmlns='jabber:client' xmlns:stream='http://etherx.jabber.org/streams' version='1.0' xml:lang='en'>'''
cliPktD = '''<iq id='EA-Chat-1' type='get'><query xmlns='jabber:iq:auth'><username>nfsw.102</username></query></iq>'''
cliPktE = '''<iq xml:lang='en' id='EA-Chat-2' type='set'><query xmlns='jabber:iq:auth'><username>nfsw.102</username><password>1234567890123456</password><resource>EA-Chat</resource><clientlock xmlns='http://www.jabber.com/schemas/clientlocking.xsd' id='900'>57b8914527daff651df93557aef0387e5aa60fae</clientlock></query></iq>'''
cliPktF = '''<presence><show>chat</show><status>Online</status><priority>0</priority></presence>'''
cliPktG = ''' '''
cliPktH = '''<presence to='channel.EN__1@conference.nils-pc/nfsw.102'/>'''

name = '''127.0.0.1'''

def sendToSrvClear(targetsock, packet):
    print "before ssl: C->S [" + packet + "]"
    targetsock.send(packet)

def getFromSrvClear(targetsock):
    packet = targetsock.recv(BUFSIZE)
    print "before ssl: S->C [" + packet + "]"

def sendToSrv(socket, packet):
    print "C->S [" + packet + "]"
    socket.send(packet)

def getFromSrv(socket):
    packet = socket.recv(BUFSIZE)
    print "S->C [" + packet + "]"

if __name__ == '__main__': 
    targetsock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        print 'SERVER CONNECT to:', '127.0.0.1'
        targetsock.connect(('127.0.0.1', 5222))
        
        sendToSrvClear(targetsock, cliPktA)
        
        packet = targetsock.recv(BUFSIZE)
        print "before ssl: S->C [" + packet + "]"
        isSubstring = '''</stream:features>''' in packet
        if not isSubstring:
            packet = targetsock.recv(BUFSIZE)
            print "before ssl: S->C [" + packet + "]"
        
        sendToSrvClear(targetsock, cliPktB)
        
        getFromSrvClear(targetsock)
        
    except Exception as e:
        print "closing socket:", e
        targetsock.close()
    try:
        print '\n=============\n server connection is switching to TLS \n=============\n'
        sslsock = ssl.wrap_socket(targetsock, suppress_ragged_eofs=False, ssl_version=PROTOCOL_TLSv1)
        sendToSrv(sslsock, cliPktC)
        getFromSrv(sslsock)
        
        sendToSrv(sslsock, cliPktD)
        getFromSrv(sslsock)
        
        sendToSrv(sslsock, cliPktE)
        getFromSrv(sslsock)

        sendToSrv(sslsock, cliPktF)
        sendToSrv(sslsock, cliPktG)
        sendToSrv(sslsock, cliPktH)
        
        while (True):
            getFromSrv(sslsock)
            sendToSrv(sslsock, cliPktG)
        
    except Exception as e:
        print "closing SSL socket:", e
        sslsock.close()
