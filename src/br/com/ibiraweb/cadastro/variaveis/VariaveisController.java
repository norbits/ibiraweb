package br.com.ibiraweb.cadastro.variaveis;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.xml.ws.WebServiceException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.richfaces.component.UICommandButton;

import br.com.ibiraweb.bean.Variaveis;
import br.com.ibiraweb.iqualitywebws.Dml;
import br.com.ibiraweb.iqualitywebws.InvalidInputException;



@ManagedBean(name = "variaveiscontroller")
@SessionScoped
public class VariaveisController {

	
	private Variaveis variaveis;
	
	private List<Variaveis> variaveisList;

	public int getInit() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		
		variaveis = new Variaveis();
		
		 Dml select  =  Dml.getInstance();
		 variaveisList  =  select.busca(" iquali_ibirabase.variaveis ", "  id,"
		 		+ "	  contribMensal,"
		 		+ "	  contrbMensalAtrasadaMes,"
		 		+ "	  contribMensalAtrasadaForaMes,"
		 		+ "	  registroUEB,"
		 		+ "	  registroUEBChefe,"
		 		+ "	  ativo,"
		 		+ "	  anobase,"
		 		+ "	  diaVencimentoMensalidade,"
		 		+ "	  anoAnterior, "
		 		+ "   Date(dataUltimaAlteracao) dataUltimaAlteracao,"
		 		+ "user ", " "," where ativo = 0",false,new Variaveis());
		 
		 
		 for (Variaveis var : variaveisList) {
			
			 variaveis.setId(var.getId());
			 variaveis.setContribMensal(var.getContribMensal());
			 variaveis.setContrbMensalAtrasadaMes(var.getContrbMensalAtrasadaMes());
			 variaveis.setContribMensalAtrasadaForaMes(var.getContribMensalAtrasadaForaMes());
			 variaveis.setRegistroUEB(var.getRegistroUEB());
			 variaveis.setAnobase(var.getAnobase());
			 variaveis.setDiaVencimentoMensalidade(var.getDiaVencimentoMensalidade());
			 variaveis.setDataUltimaAlteracao(var.getDataUltimaAlteracao());
			 variaveis.setUser(var.getUser());
			 variaveis.setAnoAnterior(var.getAnoAnterior());
			 
		}
		 
		 
		 
		 
		 
		 
		return 0;
	}
	
	
	
	
	public void alteraParametros(ActionEvent event)
			throws WebServiceException, Exception {

		try {
			
			Subject currentUser = SecurityUtils.getSubject();
			String user = currentUser.getPrincipal().toString();
			
			

			 Dml select  =  Dml.getInstance();
			 
			 select.iniciaTransacao();
			 
			 select.altera(" iquali_ibirabase.variaveis ", 
					 		" ativo = 1" , 
					 		" where id = "+  variaveis.getId() , false) ;
			 
			 DateTime dt = new DateTime();
			 	
			 int mes = dt.getMonthOfYear();
				int dia = dt.getDayOfMonth();
				int ano = dt.getYear();
				
				String data = ano+"-"+(mes<10?"0"+mes:mes)+"-"+(dia<10?"0"+dia:dia);
			 
			 
			 select.inclui(" iquali_ibirabase.variaveis ", "( id,"
			 		+ " 	  contribMensal,"
			 		+ "	  contrbMensalAtrasadaMes,"
			 		+ "	  contribMensalAtrasadaForaMes,"
			 		+ "	  registroUEB,"
			 		+ " 	  ativo,"
			 		+ " 	  anobase,"
			 		+ " 	  diaVencimentoMensalidade,"
			 		+ "      dataUltimaAlteracao, "
			 		+ "      user,"
			 		+ "     anoAnterior  )", 
			 		" ( '0',"+
			 				"'"+variaveis.getContribMensal()+"',"+
			 				"'"+variaveis.getContrbMensalAtrasadaMes()+"',"+
			 				"'"+variaveis.getContribMensalAtrasadaForaMes()+"',"+
			 				"'"+variaveis.getRegistroUEB()+"',"+
			 				"'0',"+
			 				"'"+variaveis.getAnobase()+"',"+
			 				"'"+variaveis.getDiaVencimentoMensalidade()+"','" +
			 				data + "', '"
			 				+ user + "','"+ 
			 				variaveis.getAnoAnterior()+"' )", "", false);
			 
			 
			 select.finalizaTransacao();
			 
			 
			 
			 
			 variaveisList  =  select.busca(" iquali_ibirabase.variaveis ", "  id,"
				 		+ "	  contribMensal,"
				 		+ "	  contrbMensalAtrasadaMes,"
				 		+ "	  contribMensalAtrasadaForaMes,"
				 		+ "	  registroUEB,"
				 		+ "	  registroUEBChefe,"
				 		+ "	  ativo,"
				 		+ "	  anobase,"
				 		+ "	  diaVencimentoMensalidade,"
				 		+ "	  anoAnterior,"
				 		+ "   Date(dataUltimaAlteracao) dataUltimaAlteracao, "
				 		+ "   user  ", " "," where ativo = 0",false,new Variaveis());
				 
				 
				 for (Variaveis var : variaveisList) {
					
					 variaveis.setId(var.getId());
					 variaveis.setContribMensal(var.getContribMensal());
					 variaveis.setContrbMensalAtrasadaMes(var.getContrbMensalAtrasadaMes());
					 variaveis.setContribMensalAtrasadaForaMes(var.getContribMensalAtrasadaForaMes());
					 variaveis.setRegistroUEB(var.getRegistroUEB());
					 variaveis.setAnobase(var.getAnobase());
					 variaveis.setDiaVencimentoMensalidade(var.getDiaVencimentoMensalidade());
					 variaveis.setDataUltimaAlteracao(var.getDataUltimaAlteracao());
					 variaveis.setUser(var.getUser());
					 variaveis.setAnoAnterior(var.getAnoAnterior());
					 
				}
				 

		} catch (Exception c) {
			FacesContext fctx = FacesContext.getCurrentInstance();
			UIComponent impt = event.getComponent();
			UICommandButton uiInput = ((UICommandButton) impt
					.findComponent("variaveisform:btnAterar"));

			FacesMessage msg = new FacesMessage("ERRO GRAVE! ",
					"Falha ao Incluir Dados de Parametros !" + c.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fctx.addMessage(uiInput.getClientId(fctx), msg);
			return;
		}

	}
	
	
	
	
	public Variaveis getVariaveis() {
		return variaveis;
	}

	public void setVariaveis(Variaveis variaveis) {
		this.variaveis = variaveis;
	}

	public List<Variaveis> getVariaveisList() {
		return variaveisList;
	}

	public void setVariaveisList(List<Variaveis> variaveisList) {
		this.variaveisList = variaveisList;
	}
	
	
	
	
}
