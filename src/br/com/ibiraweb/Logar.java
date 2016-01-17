package br.com.ibiraweb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

public class Logar extends javax.servlet.http.HttpServlet{

     protected void doPost(HttpServletRequest request, HttpServletResponse
         response) throws ServletException, IOException {

         Connection conexao = null;

         PreparedStatement stmt = null;

         ResultSet res = null;

         try{

              String login = request.getParameter("login");

              String senha = request.getParameter("senha");

              Class.forName("com.mysql.jdbc.Driver");

              conexao = DriverManager.getConnection("jdbc:mysql://localhost/javamagazine1", "root", "senha");

              stmt = conexao.prepareStatement("SELECT * FROM usuarios WHERE login=?");

              stmt.setString(1, login);

              res = stmt.executeQuery();

              Login usuario = null;

              if(res.first()){

                   usuario = new Login();

                  usuario.setId(res.getInt("id"));

                   usuario.setUsername(res.getString("nome"));

               //    usuario.set(res.getString("login"));

                   usuario.setPassword(res.getString("senha"));

              }

              if(usuario==null||!usuario.getPassword().equals(senha)){

                   request.getSession().setAttribute("msg", "Login ou senha incorretos!");

                   response.sendRedirect("index.jsp");

              }else{

                   request.getSession().setAttribute("usuario", usuario);

                   response.sendRedirect("admin/index.jsp");

              }

         }catch(Exception e){

              throw new ServletException(e);

         }finally{

              try{

                   res.close();

                   stmt.close();

                   conexao.close();

              }catch(Exception e){

                   e.printStackTrace();

              }

         }

     }            

}

 

