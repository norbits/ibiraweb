package br.com.ibiraweb;


import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Login  extends HttpServlet {

     static final String HOME_URL = "/index.xhtml";
	 static boolean SEJACHAMOU = false;
	 static boolean SEJACHAMOUPOP = false;
    
    
    
    private String username;
    private String password;
    private boolean remember;
  private int id;
  private static final transient Logger log = LoggerFactory.getLogger(Login.class);
    // http://balusc.blogspot.com.br/2013/01/apache-shiro-is-it-ready-for-java-ee-6.html
    // http://balusc.blogspot.com.br/2013/01/apache-shiro-is-it-ready-for-java-ee-6.html#DeclarativeRestrictionInBeanMethods

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		Subject currentUser = null;
		 
			
		 try {
      	 
			 
			 
			 String rawPassword = "ibiraguacu";
			 PasswordService svc = new DefaultPasswordService();
			 String encrypted = svc.encryptPassword(rawPassword);
			 
			 
			 log.info("My First Apache Shiro Application");
	  	      /**************************************************************/
	        	ServletContext servletContext = getServletContext();
	    		String contextPath = servletContext.getRealPath(File.separator);
	    		//1.
	    		Factory<SecurityManager> factory ;
	    		
	    		if(contextPath == null){
	    			contextPath = getClass().getClassLoader().getResource("/").getPath();
	    			factory = new IniSecurityManagerFactory(contextPath.replace("classes", "shiro.ini"));
	    		}else {
	    			
	    			factory = new IniSecurityManagerFactory(contextPath+"/WEB-INF/shiro.ini");
	    			
	    		}
	    		
	    		
	      	  
 
	      	    

	      	    //2.
	      	    SecurityManager securityManager = factory.getInstance();

	      	    //3.
	      	    SecurityUtils.setSecurityManager(securityManager);

	      	    
	      	    currentUser = SecurityUtils.getSubject();
	      	    
	      	    
	      	//collect user principals and credentials in a gui specific manner 
      	        //such as username/password html form, X509 certificate, OpenID, etc.
      	        //We'll use the username/password example here since it is the most common.
      	        UsernamePasswordToken token = new UsernamePasswordToken(req.getParameter("username"), req.getParameter("password"));

      	        //this is all you have to do to support 'remember me' (no config - built in!):
      	        token.setRememberMe(false);

      	        currentUser.login(token);
	      	    
	      	    
      	        
      	      Session session = currentUser.getSession();
  	  	    session.setAttribute				( "userRoles"		, "");
      	        
      	        
      	        
	      	    
	      	  //  if ( !currentUser.isAuthenticated() ) {
	      	      if ( !req.getParameter("password").equals("ibira") ) {	
			      	      try {
				  	        	req.setAttribute("errorMsg", "Permissão de Entrada Não Concedida! <br /> Favor Tentar Novamente !"); 
				  	           // getServletConfig().getServletContext().getRequestDispatcher("/logonError.jsp").forward(req,resp);
				  	            
				  	            
				  	          resp.sendRedirect("/ibiraweb/logonError401.jsp");
				  	        return;
				  	            
				  	            
				  	          } catch (Exception e) {
				  	            e.printStackTrace();
				  	          }
	      	        
	      	    }
	  	      
	  	      session.setAttribute("password",null);
	  	      
	  	      if(session.getAttribute("password")==null){
	  	    	  
	  	    	 session.setAttribute("password", req.getParameter("password"));
	  	    	 
	  	      }else{
	  	        try {
	  	          req.setAttribute("errorMsg", "Favor Solicitar Permissão de Acesso, Permissão Não Concedida Para Entrada !");
	  	          getServletConfig().getServletContext().getRequestDispatcher("/logonError.jsp").forward(req, resp);
	  	        } catch (ServletException e) {
	  	          e.printStackTrace();
	  	        } catch (IOException e) {
	  	          e.printStackTrace();
	  	        }
	  	      }
	  	    
	  	    
	  	  session.setAttribute				( "pagInicial"		, "portal/inicial/inicial.xhtml" 	);
	  	      
	  	  if ( currentUser.hasRole				( "admin" 										)) {
	  		session.setAttribute				( "userRoles"		, "admin" 					);
	  	  } else if ( currentUser.hasRole		( "master" 							) ) {
	  		session.setAttribute				( "userRoles"		, "master" 		);
	  	  }

	  	  
	  	  if ( currentUser.hasRole( "master" 							) 			||
	  	        		currentUser.hasRole( "admin" 					) 		) 
	  	  {
	  		  
	  	          try {
	  	            getServletConfig().getServletContext().getRequestDispatcher("/jsp/menu.jsp").forward(req,resp);
	  	          } catch (ServletException e) {
	  	            e.printStackTrace();
	  	          } catch (IOException e) {
	  	            e.printStackTrace();
	  	          }
	  	  } else {
	  	        try {
		  	          req.setAttribute("errorMsg", "Não Foi Encontrado Permissão Para o Perfil, Permissão de Entrada Não Concedida!");
		  	          getServletConfig().getServletContext().getRequestDispatcher("/logonError.jsp").forward(req, resp);
		  	        } catch (ServletException e) {
		  	          e.printStackTrace();
		  	        } catch (IOException e) {
		  	          e.printStackTrace();
		        }      	
	  	  }
	  	        
	  	        
	  	        
	  	      /**************************************************************/
	        }    //if no exception, that's it, we're done!
				 catch ( UnknownAccountException uae ) {
				    //username wasn't in the system, show them an error message?
					 
			  	          try {
			  	        	req.setAttribute("errorMsg", "Nome de Usuario NÃO Cadastrado... Tente Novamente!"); 
			  	            getServletConfig().getServletContext().getRequestDispatcher("/logonError.jsp").forward(req,resp);
			  	          } catch (ServletException e) {
			  	            e.printStackTrace();
			  	          } catch (IOException e) {
			  	            e.printStackTrace();
			  	          }
				} catch ( IncorrectCredentialsException ice ) {
				    //password didn't match, try again?
			  	          try {
			  	        	req.setAttribute("errorMsg", "Senha NÃO Cadastrada... Tente Novamente!"); 
			  	            getServletConfig().getServletContext().getRequestDispatcher("/logonError.jsp").forward(req,resp);
			  	          } catch (ServletException e) {
			  	            e.printStackTrace();
			  	          } catch (IOException e) {
			  	            e.printStackTrace();
			  	          }
				} catch ( LockedAccountException lae ) {
				    //account for that username is locked - can't login.  Show them a message?
			  	          try {
			  	        	req.setAttribute("errorMsg", "Conta Bloqueada... Favor Verificar com Administrador de rede e Tentar Novamente!"); 
			  	            getServletConfig().getServletContext().getRequestDispatcher("/logonError.jsp").forward(req,resp);
			  	          } catch (ServletException e) {
			  	            e.printStackTrace();
			  	          } catch (IOException e) {
			  	            e.printStackTrace();
			  	          }
				} catch ( AuthenticationException ae ) {
				    //unexpected condition - error?
			  	          try {
			  	        	req.setAttribute("errorMsg", "Falha Inesperada... Favor Verificar com Administrador de rede e Tentar Novamente! \n"+ae.getMessage()); 
			  	            getServletConfig().getServletContext().getRequestDispatcher("/logonError.jsp").forward(req,resp);
			  	          } catch (ServletException e) {
			  	            e.printStackTrace();
			  	          } catch (IOException e) {
			  	            e.printStackTrace();
			  	          }
				}
			}
	
	
	

	
  
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
       
        	
			}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}