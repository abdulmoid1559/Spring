<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1 style="color:blue;text-align:center">All ${opt} </h1>


<c:choose>
   <c:when test="${listInfo ne null && !empty listInfo   }">
         <table align="center" bgcolor="pink">
          <c:forEach var="country"  items="${listInfo}">
            <tr>
               <td style="color:blue">${country} </td>
             </tr>
            </c:forEach>
         </table>
         <b> ${opt} count:: ${count}</b>
   </c:when>
   <c:otherwise>
          <h1 style="color: red;text-align: center;"> No ${opt} found </h1>
   </c:otherwise>
</c:choose>
 <br>
 <br>
   <a href="welcome">home</a>