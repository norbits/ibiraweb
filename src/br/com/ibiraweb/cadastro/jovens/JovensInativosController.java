package br.com.ibiraweb.cadastro.jovens;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.xml.ws.WebServiceException;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.richfaces.component.UICommandButton;
import org.richfaces.component.UIExtendedDataTable;

import br.com.ibiraweb.bean.Ativo;
import br.com.ibiraweb.bean.DadosJovem;
import br.com.ibiraweb.bean.DadosMae;
import br.com.ibiraweb.bean.DadosPai;
import br.com.ibiraweb.bean.Secoes;
import br.com.ibiraweb.bean.Sexo;
import br.com.ibiraweb.iqualitywebws.Dml;
import br.com.ibiraweb.iqualitywebws.InvalidInputException;



@ManagedBean(name = "jovensinativoscontroller")
@SessionScoped
public class JovensInativosController {
	
	private int 					currentJovenOnTable;
	
	private Collection<Object> 		selecao;

	private DadosJovem 				dadosJovem ;
	
	private List<Secoes> 			secoesList ;
	
	private List<DadosJovem> 		dadosJvenList;
	
	private DadosJovem 				jovemselecionadoNaTabela;
	
	
	public int getInit(){
		//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("acompanhademandasbean");
		// funcionalidadeselect = new Funcionalidade();
		
		dadosJovem = new DadosJovem();
		
		return 0;
	}
	
	
	public JovensInativosController() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		 Dml select  =  Dml.getInstance();
		 secoesList  =  select.busca(" secoes ", " id, secao, ativo ", " "," where ativo = 0",false,new Secoes());
		
		 
	}
	

	 
	public List<Secoes> getSecoes() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
		Secoes result = new Secoes();
		//if (secoesList == null) {
			 Dml select =  Dml.getInstance();
			 secoesList =  select.busca(" secoes ", " id, secao, ativo ", " "," where ativo = 0",false,new Secoes());
		//}
			
		return secoesList;
	}

    public List<SelectItem> getSecoesOptions() {
        List<SelectItem> result = new ArrayList<SelectItem>();
        result.add(new SelectItem("", ""));
        for (Secoes vendorList : secoesList) {
            result.add(new SelectItem(vendorList.getSecao()));
        }
        return result;
    }
	
	
	
	public void atualizaValorsecao() {
		boolean achou = false;
	}
	
	
	
	
	
public List<DadosJovem> getListDadosJoven() throws WebServiceException, Exception {
//	if(dadosJvenList == null){
		
		 Dml select  =  Dml.getInstance();
		 dadosJvenList   =  select.busca(" iquali_ibirabase.dadosjovem ","iddadosjovem,"
			 		+ "				 (select secao from iquali_ibirabase.secoes where id = idsecao) idsecao, "
			 		+ "				 ativo,"
			 		+ "				 trim(nroFamilia) nroFamilia," 
			 		+ "				 nomeJoven,"
			 		+ "				 nroRegistro,"
			 		+ "				 rgJovem,"
			 		+ "				 cpfJovem,"
			 		+ "				 dtNascJovem,"
			 		+ "				 cidadeNascJovem,"
			 		+ "				 ufNascJovem,"
			 		+ "				 religiaoJovem,"
			 		+ "				 idsexo,"
			 		+ "				 precelJovem,"
			 		+ "				 telCelularJovem,"
			 		+ "				 preresJovem,"
			 		+ "				 telResidencialJovem,"
			 		+ "				 emailJovem,"
			 		+ "				 nomedaMae,"
			 		+ "				 telComercialMae,"
			 		+ "				 profissaoMae,"
			 		+ "				 eMailMae,"
			 		+ "				 cidadeNascimentoMae,"
			 		+ "				 rgMae,"
			 		+ "				 cpfMAE,"
			 		+ "				 telCelMae,"
			 		+ "				 nomePai,"
			 		+ "				 telComercialPai,"
			 		+ "				 profissaoPai,"
			 		+ "				 emailPai,"
			 		+ "				 cidadeNasPai,"
			 		+ "				 rgPai, "
			 		+ "				 cpfPAI,"
			 		+ "				 telCelPai,"
			 		+ "				 enderecoJovem,"
			 		+ "				 bairro,"
			 		+ "				 cidade,"
			 		+ "				 estado,"
			 		+ "				 cep,"
			 		+ "				 dataInicio,"
			 		+ "				 dataDesligamento,"
			 		+ "				 motDesligamento"
			 		  , " " ,"where ativo = 1",false,new DadosJovem());	
//		}

		 if(selecao != null ){
			 selecao.clear();
		 }
		 
		return dadosJvenList;
	}
	
	
public void selecaoListener(AjaxBehaviorEvent event) throws IOException, Exception {
    UIExtendedDataTable dataTable = (UIExtendedDataTable) event.getComponent();
    //Object originalKey = dataTable.getRowKey();
    
    for (Object chave : selecao) {
    	dataTable.setRowKey(chave);        	
    	if (dataTable.isRowAvailable()) {
    		
    		jovemselecionadoNaTabela = (DadosJovem) dataTable.getRowData();
    		break;
    		
    	}
    }
 }

public void reativaJovemOnTable(ActionEvent event) throws WebServiceException, Exception {
	try{
//		UIComponent t = event.getComponent();
	//	UIInput uiInput = ((UIInput) t.findComponent("primeiroform:panelprojConfirm:motDeslig"));
		//((UIInput) t.findComponent(":primeiroform:motDeslig"))
		//((UIInput) t.findComponent(":primeiroform:motDeslig")).getValue();
		
		
		
		Dml select =  Dml.getInstance();
		 select.altera(" iquali_ibirabase.dadosjovem ", "ativo = '0' "
		 									   + " ,dataDesligamento =   '' "
		 									   + " ,motDesligamento = '' " , 
		 									   " where iddadosjovem = "+jovemselecionadoNaTabela.getIddadosjovem(), false);		
		
		dadosJvenList.remove(jovemselecionadoNaTabela);

		
		if(selecao != null ){
			 selecao.clear();
		 }
		
	}catch(Exception c){
		FacesContext fctx=FacesContext.getCurrentInstance();
		UIComponent impt = event.getComponent();
		UICommandButton uiInput = ((UICommandButton) impt.findComponent("incluiDadosescoteiro:btnInclui"));
		
		FacesMessage msg = new FacesMessage("ERRO GRAVE! ","Falha ao desativar o Joven !"+c.getMessage());
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		fctx.addMessage(uiInput.getClientId(fctx), msg);
		return;
	}
}





///////////////////////////////////////////////////////////////////////////////////////////////
// GETTERS AND SETTERS
//////////////////////////////////////////////////////////////////////////////////////////////






public int getCurrentJovenOnTable() {
	return currentJovenOnTable;
}
public void setCurrentJovenOnTable(int currentJovenOnTable) {
	this.currentJovenOnTable = currentJovenOnTable;
}
public Collection<Object> getSelecao() {
	return selecao;
}
public void setSelecao(Collection<Object> selecao) {
	this.selecao = selecao;
}
public DadosJovem getDadosJovem() {
	return dadosJovem;
}
public void setDadosJovem(DadosJovem dadosJovem) {
	this.dadosJovem = dadosJovem;
}
public List<Secoes> getSecoesList() {
	return secoesList;
}
public void setSecoesList(List<Secoes> secoesList) {
	this.secoesList = secoesList;
}

public List<DadosJovem> getDadosJvenList() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	return dadosJvenList;
}
public void setDadosJvenList(List<DadosJovem> dadosJvenList) {
	this.dadosJvenList = dadosJvenList;
}
public DadosJovem getJovemselecionadoNaTabela() {
	return jovemselecionadoNaTabela;
}
public void setJovemselecionadoNaTabela(DadosJovem jovemselecionadoNaTabela) {
	this.jovemselecionadoNaTabela = jovemselecionadoNaTabela;
}
	
	
}
