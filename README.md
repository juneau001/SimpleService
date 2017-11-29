This is a simple Java EE Microservice that connects to an Apache Derby database.

To begin, connect to a local Apache Derby database and create the necessary table structure.  Next, update the web.xml of the project with the database connection properties for your environment.

Deploy to Payara Micro using the following after building and compiling:

java -jar payara-micro-4.1.2.174.jar --deploy SimpleService-1.0.war
