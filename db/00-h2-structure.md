To use h2db, create the database and schema SOAPBOX.

inside file persistence.xml, uncomment the tag:
 
    <property name="hibernate.hbm2ddl.auto" value="create" />

start and stop the server.

run the NN-insert-*.sql scripts
