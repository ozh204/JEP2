# JEP2

## Connection Pool and JNDI JDBC resource on GlassFish 4.1

1. stop GlassFish if it's running
`asadmin stop-domain`
* copy jdbc driver hsqldb-2.2.4.jar to glassfish domain lib folder e.g.:
`cp ./scripts/hsqldb-2.2.4.jar /opt/devel/as/glassfish4/glassfish/domains/domain1/lib/ext/.`
* define resource connection pool and jndi resource. Edit default domain configuration file e.g.:
`vi /opt/devel/as/glassfish4/glassfish/domains/domain1/config/domain.xml`
Find `<resource>` element. Copy&Paste following xml fragment next to any other `<jdbc-connection-pool>` element:
`    <jdbc-connection-pool driver-classname="" datasource-classname="org.hsqldb.jdbc.JDBCDataSource"`
`    res-type="javax.sql.DataSource" description="" name="HSQLPool" ping="true">`
`      <property name="DatabaseName" value="jdbc:hsqldb:hsql://localhost/workdb"></property>`
`      <property name="User" value="SA"></property>`
`      <property name="Password" value=""></property>`
`      <property name="connectionAttributes" value=";ifexists=true"></property>`
`    </jdbc-connection-pool>`
`    <jdbc-resource pool-name="HSQLPool" description="DataSource for demo apps with HSQLDB" `
`    jndi-name="jdbc/demoapps"></jdbc-resource>`
