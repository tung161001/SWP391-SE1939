JSTL Library Setup for Jakarta EE 10

To use JSTL in this project, please download the following JAR files and place them in this directory (web/WEB-INF/lib):

1. jakarta.servlet.jsp.jstl-api-3.0.0.jar
2. jakarta.servlet.jsp.jstl-3.0.0.jar

You can download these files from:
- Jakarta JSTL API: https://mvnrepository.com/artifact/jakarta.servlet.jsp.jstl/jakarta.servlet.jsp.jstl-api/3.0.0
- Jakarta JSTL Implementation: https://mvnrepository.com/artifact/org.glassfish.web/jakarta.servlet.jsp.jstl/3.0.0

These libraries are necessary for the JSP pages to use the JSTL tags (such as <c:forEach> and <c:if>).

After adding these libraries, restart your application server for the changes to take effect. 