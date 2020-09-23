package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.eci.cvds.servlet.*;
import edu.eci.cvds.servlet.model.Todo;
import java.util.*;
import java.io.*;
import java.net.*;

@WebServlet(
    urlPatterns = "/webApp"
)
public class WebAppServlet extends HttpServlet{
    static final long serialVersionUID = 35L;
	ArrayList<Todo> lista = new ArrayList<Todo>();
	public String var = "";
	

    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
       Writer responseWriter = resp.getWriter();
	   try{
		   
		   Optional<String> valorId = Optional.ofNullable(req.getParameter("id"));
		   Integer id = (Integer.parseInt(valorId.get()));
		   Todo valor = Service.getTodo(id);
		   lista.add(valor);
		   resp.setStatus(HttpServletResponse.SC_OK);
		   responseWriter.write(Service.todosToHTMLTable(lista));
		   responseWriter.flush();
		   
	   }
	   catch(FileNotFoundException i){
		   resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		   responseWriter.write(Service.noEncontradoHTML()+"\n");		    
	   }
	   catch(NoSuchElementException i){
		   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		   responseWriter.write("requerimiento inválido");	   
	   }
	   catch(NumberFormatException i){
		   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		   responseWriter.write("requerimiento inválido");	   
	   }
	   
	   catch(MalformedURLException i){
		   resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		   responseWriter.write("error interno en el servidor");	  
		   
	   }
	   
	   catch (Exception e){
	       responseWriter.write("Requerimiento Invalido");
	   }  
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
       Writer responseWriter = resp.getWriter();
	   try{
		   
		   Optional<String> valorId = Optional.ofNullable(req.getParameter("id"));
		   Integer id = (Integer.parseInt(valorId.get()));
		   Todo valor = Service.getTodo(id);
		   lista.add(valor);
		   resp.setStatus(HttpServletResponse.SC_OK);
		   responseWriter.write(Service.todosToHTMLTable(lista));
		   responseWriter.flush();
		   
	   }
	   catch(FileNotFoundException i){
		   resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		   responseWriter.write(Service.noEncontradoHTML()+"\n");		    
	   }
	   catch(NoSuchElementException i){
		   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		   responseWriter.write("requerimiento inválido");	   
	   }
	   catch(NumberFormatException i){
		   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		   responseWriter.write("requerimiento inválido");	   
	   }
	   
	   catch(MalformedURLException i){
		   resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		   responseWriter.write("error interno en el servidor");	  
		   
	   }
	   
	   catch (Exception e){
	       responseWriter.write("Requerimiento Invalido");
	   }  
   }
   public void setVar(String var){
	   this.var = var;
	   
   }
}