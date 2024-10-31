1. Open the folder using IntelliJ IDEA
2. This work not use MAVEN or GRADLE, so we need to run some command to build the project
3. Download gson-2.11.0.jar and  javax.servlet-api.jar
4. File -> Project Structure -> Modulea -> PASTE two JARs here
5. Terminal -> "javac -classpath "C:\Users\quboc\.m2\repository\javax\servlet\javax.servlet-api\4.0.1\javax.servlet-api-4.0.1.jar;C:\Users\quboc\.m2\repository\com\google\code\gson\gson\2.11.0\gson-2.11.0.jar" -d WEB-INF/classes src/ChatServlet.java"
6. Terminal -> "jar -cvf chatapp.war *"
7. Then locate the war file into xampp/tomcat/webapps/chatapp.war
8. Run XAMPP, start the Apache and Tomcat services (Make sure the ports are working properly)
9. Back to IDE, run client.html (you can configurate the URL to make sure the web is correct)
10. If the ChatServer not found, check the fetch path in client.html 
