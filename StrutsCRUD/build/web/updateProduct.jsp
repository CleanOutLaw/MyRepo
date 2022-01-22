<%-- 
    Document   : updateProduct
    Created on : 21 janv. 2022, 19:36:33
    Author     : oussa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update product</title>
    </head>
    <body>
        <h1>Mise à jour du produit <s:property value="code"/></h1>
         <s:form action="saveEditProduct">
             <s:hidden name="code" value="%{myProduct.getCode()}"/>
             <s:textfield name="designation" label="Desgination"/>
             <s:textfield name="price" label="Prix "/>
             <s:submit value="Update"/>
        </s:form>
    </body>
</html>