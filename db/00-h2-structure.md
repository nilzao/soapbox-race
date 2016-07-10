To use h2db, create the database and schema SOAPBOX.

inside file persistence.xml, uncomment the tag:
 
    <property name="hibernate.hbm2ddl.auto" value="create" />

inside file pom.xml, uncomment the h2 driver dependency tag. 

inside file soapbox.properties set 

    dbDriver=H2 

start and stop the server.

run the NN-insert-*.sql scripts
