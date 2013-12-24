<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@page import="java.util.*" %>
<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <html:base/>
    </head>
    <body style="background-color: white">
        
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
    <center>
        
        <br></br>
        <html:errors/>
        <html:form action="/student" >
            <table>
                <tr><td>Student ID : </td><td><html:text property="id" /></td>
                    <td><html:submit value="Send" /></td></tr>
            </table>
        </html:form>
        <br></br>
        
            <% ArrayList al=(ArrayList)session.getAttribute("res");
            if(al!=null)
            { %>
        <table border="1">
            <tr><th>ID </th><th>Name </th><th>Course </th><th>Qualification</th></tr>
            <% for(int i=0;i<al.size();i++) 
            {
               bean.Student st=(bean.Student)al.get(i); %>
              <tr>
              <td><%=st.getId ()%></td> 
              <td><%=st.getName()%></td>
              <td><%=st.getCourse ()%></td> 
              <td><%=st.getQualification ()%></td>
              </tr> 
          <%  } %>
        </table>                
          <%  }  %>

    </center>
    </body>
</html:html>
