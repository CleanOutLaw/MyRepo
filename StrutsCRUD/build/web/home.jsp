<%-- 
    Document   : home.jsp
    Created on : 21 janv. 2022, 18:07:33
    Author     : oussa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Home Page</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    
    <style>
    .center_div{
    margin: 5% auto;
    width:90% /* value of your choice which suits your alignment */
    }   
    </style>
    
    <body>
        
        <div class="container center_div">
        <div class="row">
            <div class="col-4 align-self-center">
        <h3>Gesion des films</h3>
         <s:form action="saveProduct" class="form-group">
                <s:textfield name="code" label="Code" placeholder="Enter a code" />
                <s:textfield name="designation" label="Designation" placeholder="Enter a designation"/>
                <s:textfield name="price" label="Prix" placeholder="Enter a price"/>
                <s:submit value="Ajouter"/>
        </s:form>
        <br>
        </div>
        
        
       <s:if test="%{allProducts.size()>0}">
           <div class="col-8 align-self-center">
           <table class="table table-dark">
            <tr>
                <th scope="col">Code</th>
                <th scope="col">Designation</th>
                <th scope="col">Prix</th>
                <th scope="col">Actions</th>
            </tr>
            
            <s:iterator value="allProducts">
                <tr>
                    <td><s:property value="code"/></td>
                    <td><s:property value="designation"/></td>
                    <td><s:property value="price"/></td>
                    <td>
                        <s:url id="deleteUrl" action="deleteProduct">
                            <s:param name="code" value="%{code}"></s:param>
                        </s:url>
                        <s:a href="%{deleteUrl}"><button type="button" class="btn btn-light">Delete</button></s:a>
                        
                        <s:url id="editUrl" action="editProduct">
                            <s:param name="code" value="%{code}"></s:param>
                        </s:url>
                        <s:a href="%{editUrl}"><button type="button" class="btn btn-info">Update</button></s:a>
                    </td>
                </tr>
            </s:iterator>
            </table>
              </div>
           </div>
           </div>
        </s:if>
    </body>
</html>