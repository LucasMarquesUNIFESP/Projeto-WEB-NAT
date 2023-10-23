<%@ page import="java.util.Date" %>
<%@ page import="ProjetoWEB.GeoIP"%>
<%@ page import="ProjetoWEB.VisitCounter"%>
<% 
	GeoIP geoIp = new GeoIP(request.getRemoteAddr().toString());
	VisitCounter visitCounter = new VisitCounter(request);
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Projeto WEB</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <header>
        <h1>Projeto WEB NAT - Redes de Computadores</h1>
    </header>
    <main>
        <p>
            Nome do Servidor
        </p>
        <button><%= request.getLocalName() %></button>
    </main>
    <main>
        <p>
            Data
        </p>
        <button>
        	<% Date date = new Date(); %>
			<%= date %>
		</button>
    </main>
    <main>
        <p>
            Endereço de IP do Cliente
        </p>
        <button><%= request.getRemoteAddr().toString() %></button>
    </main>
    <main>
        <p>
            Quantidade de Requests na sessão pelo Cliente
        </p>
        <button><%= visitCounter.Value() %></button>
    </main>
    <main>
        <p>
            Localização 
        </p>
        <button><%= geoIp.getCidadeIsp() + " - " + geoIp.getEstado() + " - " + geoIp.getPais() %></button>
    </main>
    <main>
        <p>
            Serviço IPS
        </p>
        <button><%= geoIp.getIspCliente() %></button>
    </main>
    
    <footer>
        lucas.william@unifesp.br
    </footer>
</body>
</html>