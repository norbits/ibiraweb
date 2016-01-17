<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sample Error Page for JEE Security</title>
<style type="text/css">H1 {color: navy}</style>
</head>
<body>
   <div style="height:400px; overflow:auto"> 
<table width="500" border="0">
   <tbody>

      <tr>
         <td colspan="3" width="80%" align="center"><b><font face="Verdana" size="+2" 
             color="#15406a">Error Page</font></b><hr>
         </td>
      </tr>
      <tr>
         <td colspan="3" width="560" align="center" height="58" 
             valign="top"><br>
              <p style="font-size: 150%;"> <%=request.getAttribute("errorMsg") %> </p>
 
             
           </td>
      </tr>
   
   </tbody>
</table>

    </div>

</body>

 <INPUT TYPE="button" VALUE="Voltar" onClick="history.go(-1);">
 
 
</html>