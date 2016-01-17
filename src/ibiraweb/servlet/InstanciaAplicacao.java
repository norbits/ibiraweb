package ibiraweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;



public class InstanciaAplicacao extends HttpServlet
 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public InstanciaAplicacao()
	{
	}


	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		String parAcao = req.getParameter("parAcao");
		String parRotina = req.getParameter("parRotina");
		RequestDispatcher requestDispatcher = null;
		req.getSession().setAttribute("parRotina", parRotina);
		System.out.println("parRotina = "+parRotina);
		System.out.println("***********************************************************");
		System.out.println("request.getRemoteUser(); = "+req.getRemoteUser());
		System.out.println("***********************************************************");

		 SecurityUtils.getSubject();
		if(parAcao == null)   { 

			requestDispatcher = getServletContext().getRequestDispatcher("/jsp/menuFrames.jsp");
		}
		else
			if(parAcao.equals("listarMenu")){
		            
		            
				requestDispatcher = getServletContext().getRequestDispatcher("/portal/cabec/menuOpcoes.jsp");
			}
		
		
		

		System.out.println("sai");
		requestDispatcher.forward(req, resp);
			}


}
