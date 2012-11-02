JTechLog JPA lazy loading
=========================

Ez a program a JTechLog (<http://jtechlog.blogspot.com>) blog "JPA lazy loading" cikkéhez készült példaprogram. 
Prezentálja a JPA lazy loading-ot EclipseLink és Hibernate perzistence provider esetén. Kétrétegű alkalmazás, 
JPA perzisztens réteggel és Spring MVC  web réteggel. Maven-nel build-elhető, és a letöltést követően a 
'mvn jetty:run' paranccsal futtatható. 

Alapban EclipseLink-re van állítva, a Hibernate használatához a megjegyzésbe tett részeket kell cserélni.

Felhasznált technológiák: Spring 3.1.1, JSP 2.2, JSTL 1.1.2, JPA 2.0, EclipseLink 2.3.2, Hibernate 4.1.2,
HSQLDB 2.2.4, SLF4J 1.6.4, Maven 3.0.3, Jetty 8.0.4

viczian.istvan a gmail-en