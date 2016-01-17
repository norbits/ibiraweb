package br.com.ibiraweb.manutmencao.jovens;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.xml.ws.WebServiceException;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.richfaces.component.UICommandButton;

import br.com.ibiraweb.bean.DadosJovem;
import br.com.ibiraweb.bean.DadosNroFamilia;
import br.com.ibiraweb.bean.Secoes;
import br.com.ibiraweb.bean.Sexo;
import br.com.ibiraweb.cadastro.jovens.BuscaCEP;
import br.com.ibiraweb.iqualitywebws.Dml;
import br.com.ibiraweb.iqualitywebws.InvalidInputException;


@ManagedBean(name = "alterardadosjovens")
@SessionScoped
public class AlterarDadosJovens {

	private String nomeJovem;
	private List<DadosNroFamilia> nroFamiliaList = new ArrayList<DadosNroFamilia>();
	private String idJovemSelecionado;
	private String nomeJovemSelectAutoComplete;
	private String nroFamiliaCorrentSelected;
	private DadosNroFamilia dadosNroFamilia = new DadosNroFamilia();
	private List<SelectItem> nroFamiliaListselectItem = new ArrayList<SelectItem>();
	private DadosJovem 				dadosJovem ;
	private List<Secoes> 			secoesList ;
	private List<Object> 			sexoList ;
	private List<DadosJovem> 		dadosJvenList;
	private String 					motDesligamento;
	
	
	
	
	
	
	
	public int getInit() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException  {

		dadosJovem = new DadosJovem();
		 nroFamiliaList = new ArrayList<DadosNroFamilia>();
		 
		 nroFamiliaListselectItem = new ArrayList<SelectItem>();
		
		getNroFamiliaNomeJovemList();
		return 0;
	}


	public void inativarFalse(ActionEvent event) throws WebServiceException, Exception {

		dadosJovem.setInativar(false);
	}
	
	

	public void popularIdSindicoGeral() {

		idJovemSelecionado = nomeJovemSelectAutoComplete;

		for (int j = 0; j < nroFamiliaList.size(); j++) {
			DadosNroFamilia dado = nroFamiliaList.get(j);
			if (dado.getIddadosjovem().equals(idJovemSelecionado)) {
				nomeJovemSelectAutoComplete = dado.getNroFamilia() + "-" + dado.getNomeJoven();
				nomeJovem  = nomeJovemSelectAutoComplete;
				break;
			}
		}

		nroFamiliaCorrentSelected = "";
	}

	
	
	public List<DadosNroFamilia> buscarListaJovem(String prefix)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, InvalidInputException {

		ArrayList<DadosNroFamilia> result = new ArrayList<DadosNroFamilia>();
		if ((prefix == null) || (prefix.length() == 0)) {
			for (int i = 0; i < 10; i++) {
				result.add(nroFamiliaList.get(i));
			}
		} else {
			Iterator<DadosNroFamilia> iterator = nroFamiliaList.iterator();
			while (iterator.hasNext()) {
				DadosNroFamilia elem = ((DadosNroFamilia) iterator.next());
				if ((elem != null && elem.getNomeJoven().toLowerCase()
						.indexOf(prefix.toLowerCase()) == 0)
						|| "".equals(prefix)) {
					result.add(elem);
				}
			}
		}

		return result;
	}
	
	
	public void valueChanged(ValueChangeEvent event) {
		if (null != event.getNewValue()) {
			String[] currentItems;

			for (DadosNroFamilia dadosNroFamiliaLocal : nroFamiliaList) {

				if (dadosNroFamiliaLocal.getIddadosjovem().equals(
						event.getNewValue())) {
					dadosNroFamilia = dadosNroFamiliaLocal;
					nomeJovem = dadosNroFamilia.getNroFamilia()
							+ "-" + dadosNroFamilia.getNomeJoven();
					idJovemSelecionado = dadosNroFamilia.getIddadosjovem();
					break;
				}

			}

		}

		nomeJovemSelectAutoComplete = "";
	}
	
	
	
	public List<DadosNroFamilia> getNroFamiliaNomeJovemList()
			throws InvalidInputException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Dml select = Dml.getInstance();
		nroFamiliaList = select.busca(" iquali_ibirabase.dadosjovem ",
				" iddadosjovem, nroFamilia, nomeJoven ",
				" order by nroFamilia ", "  where ativo = 0 ", false,
				new DadosNroFamilia());

		SelectItem item = new SelectItem("", "");
		for (int i = 0; i < nroFamiliaList.size(); i++) {
			item = new SelectItem(
					((DadosNroFamilia) nroFamiliaList.get(i)).getIddadosjovem(),
					((DadosNroFamilia) nroFamiliaList.get(i)).getNroFamilia()
							+ " - "
							+ ((DadosNroFamilia) nroFamiliaList.get(i))
									.getNomeJoven());
			nroFamiliaListselectItem.add(item);
		}

		return nroFamiliaList;
	}
	
	
	public void buscaDados(ActionEvent event)
			throws WebServiceException, Exception {
		
		try {
			
			
			
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
				 		+ "				 motDesligamento, "
				 		+ "				 numeroResidencia,  "
				 		+ "				 complementoEndereco,"
				 		+ "  			 isento"
				 		  , " " ,"where iddadosjovem = "+idJovemSelecionado ,false,new DadosJovem());	
			 
			 
			 for (DadosJovem d : dadosJvenList) {
				
				 dadosJovem = d;
				 
			}
			
			
			
			
			

		} catch (Exception c) {

			FacesContext fctx = FacesContext.getCurrentInstance();
			UIComponent impt = event.getComponent();
			UICommandButton uiInput = ((UICommandButton) impt
					.findComponent("financeiroController:btnOK"));

			FacesMessage msg = new FacesMessage("ERRO GRAVE! ",
					"Falha ao Tentar Altar Dados De Pagamento Ja Pago..!!"
							+ c.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fctx.addMessage(uiInput.getClientId(fctx), msg);
			return;

		}

	}
	
	

public void alteraDadosJoven(ActionEvent event) throws WebServiceException, Exception {
		
		try{
		
			
			if(dadosJovem.isInativar()){
				
				LocalDate date = LocalDate.now();
				DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
				String dataDesligamento = date.toString(fmt);
				
				Dml select =  Dml.getInstance();
				 select.altera(" iquali_ibirabase.dadosjovem ", "ativo = '1' "
				 									   + " ,dataDesligamento =   '"+dataDesligamento+"' "
				 									   + " ,motDesligamento = '"+(motDesligamento == null? "" : motDesligamento) , "' where iddadosjovem = "+dadosNroFamilia.getIddadosjovem(), false);		
				
			//	 nroFamiliaList.remove(dadosNroFamilia);
				 
				 int z = 0;
				 for (SelectItem dadosJovem : nroFamiliaListselectItem) {
					 if(dadosJovem.getValue().equals(dadosNroFamilia.getIddadosjovem())){
						 break;
					 }
					 z++;
				}
				 nroFamiliaList.remove(z);
				 nroFamiliaListselectItem.remove(z);
				 

				FacesContext fctx=FacesContext.getCurrentInstance();
				UIComponent impt = event.getComponent();
				UICommandButton uiInput = ((UICommandButton) impt.findComponent("btnInclui"));
				
				FacesMessage msg = new FacesMessage("***** Jovem Desativador Com SUCESSO..."," ");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				fctx.addMessage(uiInput.getClientId(fctx), msg);
				
				
			}else {
			
			
					Dml select  =  Dml.getInstance();
					select.altera(" iquali_ibirabase.dadosjovem ",
									"	idsecao=	"+"'"+	dadosJovem.getIdsecao()	+"',"+
									"	nroFamilia=	"+"'"+	dadosJovem.getNroFamilia()	+"',"+
									"	nomeJoven=	"+"'"+	dadosJovem.getNomeJoven()	+"',"+
									"	nroRegistro=	"+"'"+	dadosJovem.getNroRegistro()	+"',"+
									"	rgJovem=	"+"'"+	dadosJovem.getRgJovem()	+"',"+
									"	cpfJovem=	"+"'"+	dadosJovem.getCpfJovem()	+"',"+
									"	dtNascJovem=	"+"'"+	dadosJovem.getDtNascJovem()	+"',"+
									"	cidadeNascJovem=	"+"'"+	dadosJovem.getCidadeNascJovem()	+"',"+
									"	ufNascJovem=	"+"'"+	dadosJovem.getUfNascJovem()	+"',"+
									"	religiaoJovem=	"+"'"+	dadosJovem.getReligiaoJovem()	+"',"+
									"	idsexo=	"+"'"+	dadosJovem.getIdsexo()	+"',"+
									"	precelJovem=	"+"'"+	dadosJovem.getPrecelJovem()	+"',"+
									"	telCelularJovem=	"+"'"+	dadosJovem.getTelCelularJovem()	+"',"+
									"	preresJovem=	"+"'"+	dadosJovem.getPreresJovem()	+"',"+
									"	telResidencialJovem=	"+"'"+	dadosJovem.getTelResidencialJovem()	+"',"+
									"	emailJovem=	"+"'"+	dadosJovem.getEmailJovem()	+"',"+
									"	nomedaMae=	"+"'"+	dadosJovem.getNomedaMae()	+"',"+
									"	telComercialMae=	"+"'"+	dadosJovem.getTelComercialMae()	+"',"+
									"	profissaoMae=	"+"'"+	dadosJovem.getProfissaoMae()	+"',"+
									"	eMailMae=	"+"'"+	dadosJovem.getEmailMae()	+"',"+
									"	cidadeNascimentoMae=	"+"'"+	dadosJovem.getCidadeNascimentoMae()	+"',"+
									"	rgMae=	"+"'"+	dadosJovem.getRgMae()	+"',"+
									"	cpfMAE=	"+"'"+	dadosJovem.getCpfMAE()	+"',"+
									"	telCelMae=	"+"'"+	dadosJovem.getTelCelMae()	+"',"+
									"	nomePai=	"+"'"+	dadosJovem.getNomePai()	+"',"+
									"	telComercialPai=	"+"'"+	dadosJovem.getTelComercialPai()	+"',"+
									"	profissaoPai=	"+"'"+	dadosJovem.getProfissaoPai()	+"',"+
									"	emailPai=	"+"'"+	dadosJovem.getEmailPai()	+"',"+
									"	cidadeNasPai=	"+"'"+	dadosJovem.getCidadeNasPai()	+"',"+
									"	rgPai=	"+"'"+	dadosJovem.getRgPai()	+"',"+
									"	cpfPAI=	"+"'"+	dadosJovem.getCpfPAI()	+"',"+
									"	telCelPai=	"+"'"+	dadosJovem.getTelCelPai()	+"',"+
									"	enderecoJovem=	"+"'"+	dadosJovem.getEnderecoJovem()	+"',"+
									"	bairro=	"+"'"+	dadosJovem.getBairro()	+"',"+
									"	cidade=	"+"'"+	dadosJovem.getCidade()	+"',"+
									"	estado=	"+"'"+	dadosJovem.getEstado()	+"',"+
									"	cep=	"+"'"+	dadosJovem.getCep()	    +"' ," +
									"  numeroResidencia = '" + dadosJovem.getNumeroResidencia()+"' ," +
									"  complementoEndereco= '" + dadosJovem.getComplementoEndereco() + "', " + 
									"  isento    = '"+dadosJovem.getIsento() +"'"
							   , " where iddadosjovem = "+dadosJovem.getIddadosjovem(), false);
					
					
					FacesContext fctx=FacesContext.getCurrentInstance();
					UIComponent impt = event.getComponent();
					UICommandButton uiInput = ((UICommandButton) impt.findComponent("btnInclui"));
					
					FacesMessage msg = new FacesMessage("***** Jovem Alterado Com SUCESSO..."," ");
					msg.setSeverity(FacesMessage.SEVERITY_INFO);
					fctx.addMessage(uiInput.getClientId(fctx), msg);
					
			}
			
			dadosJovem = new DadosJovem();
			

			nomeJovem = "";
			
		}catch(Exception c){
			FacesContext fctx=FacesContext.getCurrentInstance();
			UIComponent impt = event.getComponent();
			UICommandButton uiInput = ((UICommandButton) impt.findComponent("incluiDadosescoteiro:btnAlterar"));
			
			FacesMessage msg = new FacesMessage("ERRO GRAVE! ","Falha ao Alterar Dados Joven !"+c.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fctx.addMessage(uiInput.getClientId(fctx), msg);
			return;
		}
		
		
		
		
	}
	
	
	public void limpaBuscarDadsJovem(ActionEvent event)
			throws WebServiceException, Exception {

		setNroFamiliaCorrentSelected("");
		dadosNroFamilia.setNroFamiliaSelected("");
		setNomeJovemSelectAutoComplete("");

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


public List<Object> getSexoData() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
	Sexo result = new Sexo();
	//if (secoesList == null) {
		 Dml select =  Dml.getInstance();
		 sexoList    =  select.busca(" sexo " , " id, descricao "  , " " ,"",false,new Sexo());
	//}
		
	return sexoList;
}




public void atualizaValorsecao() {
	boolean achou = false;
}

public List<Secoes> getSecoes() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
	Secoes result = new Secoes();
	//if (secoesList == null) {
		 Dml select =  Dml.getInstance();
		 secoesList =  select.busca(" secoes ", " id, secao, ativo ", " "," where ativo = 0",false,new Secoes());
	//}
		
	return secoesList;
}
	
	
	

	public List<Object> getSexoList() {
	return sexoList;
}



public void setSexoList(List<Object> sexoList) {
	this.sexoList = sexoList;
}



	public String getNomeJovem() {
		return nomeJovem;
	}



	public void setNomeJovem(String nomeJovem) {
		this.nomeJovem = nomeJovem;
	}



	public List<DadosNroFamilia> getNroFamiliaList() {
		return nroFamiliaList;
	}



	public void setNroFamiliaList(List<DadosNroFamilia> nroFamiliaList) {
		this.nroFamiliaList = nroFamiliaList;
	}



	public String getIdJovemSelecionado() {
		return idJovemSelecionado;
	}



	public void setIdJovemSelecionado(String idJovemSelecionado) {
		this.idJovemSelecionado = idJovemSelecionado;
	}



	public String getNomeJovemSelectAutoComplete() {
		return nomeJovemSelectAutoComplete;
	}



	public void setNomeJovemSelectAutoComplete(String nomeJovemSelectAutoComplete) {
		this.nomeJovemSelectAutoComplete = nomeJovemSelectAutoComplete;
	}



	public String getNroFamiliaCorrentSelected() {
		return nroFamiliaCorrentSelected;
	}



	public void setNroFamiliaCorrentSelected(String nroFamiliaCorrentSelected) {
		this.nroFamiliaCorrentSelected = nroFamiliaCorrentSelected;
	}



	public DadosNroFamilia getDadosNroFamilia() {
		return dadosNroFamilia;
	}



	public void setDadosNroFamilia(DadosNroFamilia dadosNroFamilia) {
		this.dadosNroFamilia = dadosNroFamilia;
	}



	public List<SelectItem> getNroFamiliaListselectItem() {
		return nroFamiliaListselectItem;
	}



	public void setNroFamiliaListselectItem(
			List<SelectItem> nroFamiliaListselectItem) {
		this.nroFamiliaListselectItem = nroFamiliaListselectItem;
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



	public List<DadosJovem> getDadosJvenList() {
		return dadosJvenList;
	}



	public void setDadosJvenList(List<DadosJovem> dadosJvenList) {
		this.dadosJvenList = dadosJvenList;
	}



	public String getMotDesligamento() {
		return motDesligamento;
	}



	public void setMotDesligamento(String motDesligamento) {
		this.motDesligamento = motDesligamento;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
