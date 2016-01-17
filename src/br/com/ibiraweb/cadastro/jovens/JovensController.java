package br.com.ibiraweb.cadastro.jovens;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
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

import br.com.ibiraweb.bean.DadosJovem;
import br.com.ibiraweb.bean.DadosMae;
import br.com.ibiraweb.bean.DadosPai;
import br.com.ibiraweb.bean.Secoes;
import br.com.ibiraweb.bean.Sexo;
import br.com.ibiraweb.iqualitywebws.Dml;
import br.com.ibiraweb.iqualitywebws.InvalidInputException;



@ManagedBean(name = "jovenscontroller")
@SessionScoped
public class JovensController {
	
	private int 					currentJovenOnTable;
	
	private Collection<Object> 		selecao;

	private DadosJovem 				dadosJovem ;
	
	private List<Secoes> 			secoesList ;
	
	private List<Object> 			sexoList ;
	
	private List<DadosJovem> 		dadosJvenList;
	
	private DadosJovem 				jovemselecionadoNaTabela;
	
	private	DadosPai				dadosPai	=  new DadosPai();
	
	private DadosMae				dadosMae	=	new DadosMae();
	
	private	String					motDesligamento;
	
	
	
	public int getInit(){
		//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("acompanhademandasbean");
		// funcionalidadeselect = new Funcionalidade();
		
		dadosJovem = new DadosJovem();
		
		return 0;
	}
	
	
	public JovensController() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		 Dml select  =  Dml.getInstance();
		 secoesList  =  select.busca(" secoes ", " id, secao, ativo ", " "," where ativo = 0",false,new Secoes());
		
		 
	}
	
	
	public List<Object> getSexoData() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
		Sexo result = new Sexo();
		//if (secoesList == null) {
			 Dml select =  Dml.getInstance();
			 sexoList    =  select.busca(" sexo " , " id, descricao "  , " " ,"",false,new Sexo());
		//}
			
		return sexoList;
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
	
	
	
	public void incluiDadosJoven(ActionEvent event) throws WebServiceException, Exception {
		
		try{
			
			String mensagem = "";
			FacesMessage.Severity severity ;
			
		//	if(dadosJovem.getIddadosjovem() != null && (dadosJovem.getIddadosjovem().equals("") || dadosJovem.getIddadosjovem().equals("0"))){
				
				mensagem = "***** Parabéns! Jovem Aceite Com SUCESSO...";
				severity = FacesMessage.SEVERITY_INFO;
			
					LocalDate date = LocalDate.now();
					DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
					String dataInicio = date.toString(fmt);
		
					Dml select =  Dml.getInstance();
					 select.inclui("  iquali_ibirabase.dadosjovem ",
							 " (iddadosjovem,idsecao,ativo,nroFamilia,nomeJoven,nroRegistro,rgJovem,cpfJovem,dtNascJovem,cidadeNascJovem,ufNascJovem,religiaoJovem,idsexo,precelJovem,telCelularJovem,preresJovem,telResidencialJovem,emailJovem,nomedaMae,telComercialMae,profissaoMae,eMailMae,cidadeNascimentoMae,rgMae,cpfMAE,telCelMae,nomePai,telComercialPai,profissaoPai,emailPai,cidadeNasPai,rgPai,cpfPAI,telCelPai,enderecoJovem,bairro,cidade,estado,cep,dataInicio,dataDesligamento,motDesligamento)", 
							 "(0,'"+dadosJovem.getIdsecao()+"','0','"+dadosJovem.getNroFamilia()+"','"+dadosJovem.getNomeJoven()+"','"+dadosJovem.getNroRegistro()+"','"+dadosJovem.getRgJovem()+"','"+dadosJovem.getCpfJovem()+"','"+dadosJovem.getDtNascJovem()+"','"+dadosJovem.getCidadeNascJovem()+"','"+dadosJovem.getUfNascJovem()+"','"+dadosJovem.getReligiaoJovem()+"','"+dadosJovem.getIdsexo()+"','"+dadosJovem.getPrecelJovem()+"','"+dadosJovem.getTelCelularJovem()+"','"+dadosJovem.getPreresJovem()+"','"+dadosJovem.getTelResidencialJovem()+"','"+dadosJovem.getEmailJovem()+"','"+dadosJovem.getNomedaMae()+"','"+dadosJovem.getTelComercialMae()+"','"+dadosJovem.getProfissaoMae()+"','"+dadosJovem.getEmailMae()+"','"+dadosJovem.getCidadeNascimentoMae()+"','"+dadosJovem.getRgMae()+"','"+dadosJovem.getCpfMAE()+"','"+dadosJovem.getTelCelMae()+"','"+dadosJovem.getNomePai()+"','"+dadosJovem.getTelComercialPai()+"','"+dadosJovem.getProfissaoPai()+"','"+dadosJovem.getEmailPai()+"','"+dadosJovem.getCidadeNasPai()+"','"+dadosJovem.getRgPai()+"','"+dadosJovem.getCpfPAI()+"','"+dadosJovem.getTelCelPai()+"','"+dadosJovem.getEnderecoJovem()+"','"+dadosJovem.getBairro()+"','"+dadosJovem.getCidade()+"','"+dadosJovem.getEstado()+"','"+dadosJovem.getCep()+"','"+dataInicio+"','"+dadosJovem.getDataDesligamento()+"','"+dadosJovem.getMotDesligamento()+"')",
							 "", false);
					
					if(selecao != null){
						selecao.clear();
					}
					
					dadosJovem = new DadosJovem();
					
			
		//	}else{
		//		mensagem = "***** Jovem Já Cadastrado ... Selecione Botao 'Limpar' para Incluir novo Jovem ou 'Alterar' Para Gravar Dados do Jovem Selecionado.. ";
		//		severity = FacesMessage.SEVERITY_ERROR;
		//	}
			
			
			FacesContext fctx=FacesContext.getCurrentInstance();
			UIComponent impt = event.getComponent();
			UICommandButton uiInput = ((UICommandButton) impt.findComponent("incluiDadosescoteiro:btnInclui"));
			
			FacesMessage msg = new FacesMessage(mensagem," ");
			msg.setSeverity(severity);
			fctx.addMessage(uiInput.getClientId(fctx), msg);
			
			
			
			
			
			
		}catch(Exception c){
			FacesContext fctx=FacesContext.getCurrentInstance();
			UIComponent impt = event.getComponent();
			UICommandButton uiInput = ((UICommandButton) impt.findComponent("incluiDadosescoteiro:btnInclui"));
			
			FacesMessage msg = new FacesMessage("ERRO GRAVE! ","Falha ao Incluir Dados Joven !"+c.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fctx.addMessage(uiInput.getClientId(fctx), msg);
			return;
		}
		
		
		
		
	}

	
	
	
	
	
public void findByCep(/*ActionEvent event*/) throws WebServiceException, Exception {
		
		try{
			
			BuscaCEP b = new BuscaCEP();
			dadosJovem.setEnderecoJovem(b.getEndereco(dadosJovem.getCep()));
			dadosJovem.setBairro(b.getBairro(dadosJovem.getCep()));
			dadosJovem.setCidade(b.getCidade(dadosJovem.getCep()));
			dadosJovem.setEstado(b.getUF(dadosJovem.getCep()));
			
		}catch(Exception c){
//			FacesContext fctx=FacesContext.getCurrentInstance();
//			UIComponent impt = event.getComponent();
//			UICommandButton uiInput = ((UICommandButton) impt.findComponent("incluiDadosescoteiro:btnInclui"));
//			
//			FacesMessage msg = new FacesMessage("ERRO GRAVE! ","Falha ao Incluir Dados Joven !"+c.getMessage());
//			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//			fctx.addMessage(uiInput.getClientId(fctx), msg);
			return;
		}
		
		
		
		
	}
	
public List<DadosJovem> getListDadosJoven() throws WebServiceException, Exception {
//	if(dadosJvenList == null){
		
		 Dml select  =  Dml.getInstance();
		 dadosJvenList   =  select.busca(" iquali_ibirabase.dadosjovem ","iddadosjovem,"
		 		    + "              idsecao, " 
			 		+ "				 (select secao from iquali_ibirabase.secoes where id = idsecao) secao, "
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
			 		+ "				 (SELECT descricao FROM iquali_ibirabase.sexo where id = idsexo) sexo,"
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
			 		  , " " ,"where ativo = 0",false,new DadosJovem());	
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

public void removeJovemOnTable(ActionEvent event) throws WebServiceException, Exception {
	try{
//		UIComponent t = event.getComponent();
	//	UIInput uiInput = ((UIInput) t.findComponent("primeiroform:panelprojConfirm:motDeslig"));
		//((UIInput) t.findComponent(":primeiroform:motDeslig"))
		//((UIInput) t.findComponent(":primeiroform:motDeslig")).getValue();
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		String dataDesligamento = date.toString(fmt);
		
		Dml select =  Dml.getInstance();
		 select.altera(" iquali_ibirabase.dadosjovem ", "ativo = '1' "
		 									   + " ,dataDesligamento =   '"+dataDesligamento+"' "
		 									   + " ,motDesligamento = '"+(motDesligamento == null? "" : motDesligamento) , "' where iddadosjovem = "+jovemselecionadoNaTabela.getIddadosjovem(), false);		
		
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
public List<Object> getSexoList() {
	return sexoList;
}
public void setSexoList(List<Object> sexoList) {
	this.sexoList = sexoList;
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
public DadosPai getDadosPai() {
	return dadosPai;
}
public void setDadosPai(DadosPai dadosPai) {
	this.dadosPai = dadosPai;
}
public DadosMae getDadosMae() {
	return dadosMae;
}
public void setDadosMae(DadosMae dadosMae) {
	this.dadosMae = dadosMae;
}


public String getMotDesligamento() {
	return motDesligamento;
}


public void setMotDesligamento(String motDesligamento) {
	this.motDesligamento = motDesligamento;
}


	
	
	
}
