GWT 2.8 Spring Kotlin Archetype
===============================

Summary
-------
This archetype will create a simple GWT + Spring project. The generated application will implement a simple login.

Generated project characteristics
---------------------------------

No-xml Spring 4 web application
GWT 2.8 with GWTBootstrap3 And Kotlin
JUnit with Selenium Test and GWTTest

Prerequisites
-------------
    JDK 7+
    Maven 3

Create a project
----------------
    mvn archetype:generate \
        -DarchetypeGroupId=net.cardosi \
        -DarchetypeArtifactId=gwt8-spring-kotlin-archetype \
        -DarchetypeVersion=1.0.0 \
        -DgroupId=my.groupid \
        -DartifactId=MyArtifact \
        -Dversion=version \
        -DarchetypeRepository=http://gitgabrio.github.io/gwt8-spring-kotlin-archetype

Note: The above command will bootstrap a project using the archetype published here: http://gitgabrio.github.io/gwt8-spring-kotlin-archetype

Run the project
---------------

Navigate to newly created project directory (my-artifactId) and then run:

    mvn -DskpiTests compile gwt:compile tomcat7:run-war -P default
    
Test in the browser
-------------------

http://localhost:8080/MyArtifact

Implementation details
----------------------
For the client side the eventbus architecture has been used to allow component decoupling.
 
For the server side the components are managed by the Spring framework.

About the container
-------------------
The application makes use of the new Servlet 3.0 specification, i.e. it does not use web.xml but it is completely managed by annotation. 
The drawback of this approach is that (currently) it does not run inside the Jetty server (embedded with the GWT environment) so Tomcat should be used for development. 
The generated Readme.md contains detailed instructions on how to cope with that.



