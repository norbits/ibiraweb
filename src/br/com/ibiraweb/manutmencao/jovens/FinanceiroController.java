package br.com.ibiraweb.manutmencao.jovens;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.xml.ws.WebServiceException;

import org.joda.time.DateTime;
import org.richfaces.component.UICommandButton;
import org.richfaces.component.UIExtendedDataTable;

import br.com.ibiraweb.bean.DadosDevedorFinanceiro;
import br.com.ibiraweb.bean.DadosFinanceiro;
import br.com.ibiraweb.bean.DadosJovem;
import br.com.ibiraweb.bean.DadosNroFamilia;
import br.com.ibiraweb.bean.Familiares;
import br.com.ibiraweb.bean.RazaoPagamento;
import br.com.ibiraweb.bean.TipoPagamento;
import br.com.ibiraweb.bean.Variaveis;
import br.com.ibiraweb.iqualitywebws.Dml;
import br.com.ibiraweb.iqualitywebws.InvalidInputException;

@ManagedBean(name = "financeiroController")
@SessionScoped
public class FinanceiroController {

	private DadosNroFamilia dadosNroFamilia = new DadosNroFamilia();
	private List<SelectItem> nroFamiliaListselectItem = new ArrayList<SelectItem>();
	private List<DadosNroFamilia> nroFamiliaList = new ArrayList<DadosNroFamilia>();
	private String nroFamiliaCorrentSelected;

	private int idSindicoGeral;
	private String nomeJovemSelectAutoComplete;

	private String nomeJovemFinanceiro;

	private String nomeJovemAutoComplete;

	private List<TipoPagamento> tipoPagamentoList;

	private List<RazaoPagamento> razaoPagamentoList;

	private DadosFinanceiro dadosFinanceiro = new DadosFinanceiro();

	private List<DadosFinanceiro> dadosFinanceiroList;

	private Map<String,DadosDevedorFinanceiro> dadosDevedorFinanceiroMap;
	private List<DadosDevedorFinanceiro> dadosDevedorFinanceiroList;

	private String idJovemSelecionado;

	private Collection<Object> selecao;

	private DadosFinanceiro financeitrSelecionadoNaTabela;
	
	private DadosDevedorFinanceiro devedorSelected;
	

	private int currentFinanceiroOnTable;

	private String valorTotalDevido;
	private double vvvTtoDev;
	private List<Variaveis> 		variaveisList;
	private String ano;
	private List<Familiares> familiaresList ;
	
	private String textoIsento;
	
	
	public int getInit() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		nroFamiliaCorrentSelected						= 			"";
		
		nomeJovemFinanceiro 							= 			"";
		
		dadosFinanceiro 								= new DadosFinanceiro();
		// LISTA DE PAGAMENTO EFETUADOS
		dadosFinanceiroList 							= new ArrayList<DadosFinanceiro>();
		// LISTA DE PAGAMENTOS A DEVER
		dadosDevedorFinanceiroMap 						= new HashMap();
		
		dadosDevedorFinanceiroList 						= new ArrayList();
		
		razaoPagamentoList								= new ArrayList();
		
		familiaresList									= new ArrayList();
		
		nroFamiliaListselectItem = new ArrayList<SelectItem>();
		
		
		valorTotalDevido = "Total Devido...: ";
		
		getNroFamiliaNomeJovemList();
		
		 Dml select =  Dml.getInstance();
			
		 variaveisList = select.busca(" iquali_ibirabase.variaveis ", " anobase ", " "," where ativo = 0",false,new Variaveis());
		 
		 for (Variaveis var : variaveisList) {
			 
			 ano = var.getAnobase();
			
		}
		 
		 if(ano == null ){
			 ano = ""+new DateTime().getYear();
		 }
		 
		 

		return 0;
	}
	
	
	public void selecaoDevedorListener(AjaxBehaviorEvent event) throws IOException, Exception {
	    UIExtendedDataTable dataTable = (UIExtendedDataTable) event.getComponent();
	    //Object originalKey = dataTable.getRowKey();
	    
	    for (Object chave : selecao) {
	    	dataTable.setRowKey(chave);        	
	    	if (dataTable.isRowAvailable()) {
	    		
	    		devedorSelected = (DadosDevedorFinanceiro) dataTable.getRowData();
	    		
	    		
	    		dadosFinanceiro.setDataPagamento("01/"+devedorSelected.getDatadevendo());
	    		dadosFinanceiro.setCompetencia(devedorSelected.getDatadevendo());;
	    		dadosFinanceiro.setTipoPagamentoSelected("Dinheiro");
	    		dadosFinanceiro.setRazaoPagamentoSelected(devedorSelected.getRazaoDevendo());
	    		dadosFinanceiro.setValorPagamento(devedorSelected.getValorDevendo());
	    		
	    		
	    		break;
	    		
	    	}
	    }
		selecao.clear();
	 }

	public List<DadosNroFamilia> getNroFamiliaNomeJovemList()
			throws InvalidInputException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Dml select = Dml.getInstance();
		nroFamiliaList = select.busca(" iquali_ibirabase.dadosjovem b ,secoes a ",
				" b.iddadosjovem, b.nroFamilia, b.nomeJoven, a.secao ",
				" order by b.nroFamilia ", "  where b.ativo = 0 and idsecao = a.id ", false,
				new DadosNroFamilia());

		SelectItem item = new SelectItem("", "");
		for (int i = 0; i < nroFamiliaList.size(); i++) {
			item = new SelectItem(
					((DadosNroFamilia) nroFamiliaList.get(i)).getIddadosjovem(),
					((DadosNroFamilia) nroFamiliaList.get(i)).getNroFamilia()
							+ " - "
							+ ((DadosNroFamilia) nroFamiliaList.get(i))
									.getNomeJoven()+ "   -    "
									+  ((DadosNroFamilia) nroFamiliaList.get(i))
									.getSecao());
			
			nroFamiliaListselectItem.add(item);
		}

		return nroFamiliaList;
	}

	public List<TipoPagamento> getTipoPagamentoDataList()
			throws InvalidInputException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Dml select = Dml.getInstance();

		tipoPagamentoList = select.busca(" iquali_ibirabase.tipopagamento ",
				" idTipoPgto, descricao ", " ", "", false, new TipoPagamento());

		return tipoPagamentoList;
	}

	public List<RazaoPagamento> getRazaoPagamentoDataList()
			throws InvalidInputException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Dml select = Dml.getInstance();

		razaoPagamentoList = select.busca(" iquali_ibirabase.razaopagamento ",
				" idrzpgto, descricao ", " ", "", false, new RazaoPagamento());

		return razaoPagamentoList;
	}

	public List<DadosFinanceiro> getDadosFinanceiroDataList()
			throws InvalidInputException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Dml select = Dml.getInstance();

		idJovemSelecionado = idJovemSelecionado == null ? "''"
				: idJovemSelecionado;

		dadosFinanceiroList = select
				.busca(" iquali_ibirabase.dadosfinanceiro ",
						" idFin, dataPagamento, valorPagamento, competencia, idRazaoPgto, idTipoFormaPgto  ",
						" ", " where idJovem = " + idJovemSelecionado, false,
						new DadosFinanceiro());

		return dadosFinanceiroList;
	}

	public void atualizaValorsecao() {
		boolean achou = false;
	}

	public void popularIdSindicoGeral() {

		idJovemSelecionado = nomeJovemSelectAutoComplete;

		for (int j = 0; j < nroFamiliaList.size(); j++) {
			DadosNroFamilia dado = nroFamiliaList.get(j);
			if (dado.getIddadosjovem().equals(idJovemSelecionado)) {
				nomeJovemSelectAutoComplete = dado.getNroFamilia() + "-" + dado.getNomeJoven()+ "  -  " +dado.getSecao();
				nomeJovemFinanceiro  = nomeJovemSelectAutoComplete;
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

	public void incluiDadosFinanceiro(ActionEvent event)
			throws WebServiceException, Exception {

		try {

			Dml select = Dml.getInstance();
			idJovemSelecionado = idJovemSelecionado == null ? "''"	: idJovemSelecionado;
			
			
			String idTipoPgto = "";
			for (TipoPagamento tipoPagamento : tipoPagamentoList) {
				if(tipoPagamento.getDescricao().equals(dadosFinanceiro.getTipoPagamentoSelected())){
					idTipoPgto =  tipoPagamento.getIdTipoPgto();
					break;
				}
			}
			
			String idRazaoPgto = "";
			for (RazaoPagamento razaoPagamento : razaoPagamentoList) {
				if(razaoPagamento.getDescricao().equals(dadosFinanceiro.getRazaoPagamentoSelected())){
					idRazaoPgto =  razaoPagamento.getIdrzpgto();
					break;
				}
			}
			
			
			String ano = "";
			String mes = "";
			String dia = "";
			String data = "";

			
			try{
				
				int m = new Integer(dadosFinanceiro.getDataPagamento().substring(0,2));
				int d = new Integer(dadosFinanceiro.getDataPagamento().substring(3,5));
				int a = new Integer(dadosFinanceiro.getDataPagamento().substring(6,10));
				
				DateTime dt = new DateTime(a,m,d,0,0);
				data = dt.getYear()+"-"+(dt.getMonthOfYear()<10?"0"+dt.getMonthOfYear():dt.getMonthOfYear())+"-"+(dt.getDayOfMonth()<10?"0"+dt.getDayOfMonth():dt.getDayOfMonth());
				
			}catch(Exception sd){
				DateTime dt = new DateTime();
				data = dt.getYear()+"-"+(dt.getMonthOfYear()<10?"0"+dt.getMonthOfYear():dt.getMonthOfYear())+"-"+(dt.getDayOfMonth()<10?"0"+dt.getDayOfMonth():dt.getDayOfMonth());
			}
			
			
			
			
			// registro da ueb é individual
			if(!dadosFinanceiro.getRazaoPagamentoSelected().equals("Registro UEB") ){
					select.iniciaTransacao();
					for( Familiares f :  familiaresList){
							select.inclui(
									" iquali_ibirabase.dadosfinanceiro ",
									"( idFin,idJovem,dataPagamento,valorPagamento,competencia,idRazaoPgto,idTipoFormaPgto )",
									"( 0,'" + f.getIddadosjovem() + "','"
											+ data + "',"
											+ dadosFinanceiro.getValorPagamento() + ",'"
											+ dadosFinanceiro.getCompetencia() + "','"
											+ idRazaoPgto + "','"
											+ idTipoPgto+"' )", "", false);
					}
					select.finalizaTransacao();
			}else {
				
				select.inclui(
						" iquali_ibirabase.dadosfinanceiro ",
						"( idFin,idJovem,dataPagamento,valorPagamento,competencia,idRazaoPgto,idTipoFormaPgto )",
						"( 0,'" + idJovemSelecionado + "','"
								+ data +"',"
								+ dadosFinanceiro.getValorPagamento() + ",'"
								+ dadosFinanceiro.getCompetencia() + "','"
								+ idRazaoPgto + "','"
								+ idTipoPgto+"' )", "", false);
				
			}
			
			
			
			
			
			
			atualizaTabelaPagamento();
			
			dadosFinanceiro.setIdRazaoPgto(dadosFinanceiro.getRazaoPagamentoSelected());
			dadosFinanceiro.setIdTipoFormaPgto(dadosFinanceiro.getTipoPagamentoSelected());
			selecao.clear();

		} catch (Exception c) {
			FacesContext fctx = FacesContext.getCurrentInstance();
			UIComponent impt = event.getComponent();
			UICommandButton uiInput = ((UICommandButton) impt
					.findComponent("incluiDadosescoteiro:btnInclui"));

			FacesMessage msg = new FacesMessage("ERRO GRAVE! ",
					"Falha ao Incluir Dados Joven !" + c.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fctx.addMessage(uiInput.getClientId(fctx), msg);
			return;
		}

	}

	public void removeFinanceiroOnTable() throws WebServiceException, Exception {
		try {
			
			Dml select = Dml.getInstance();
			
			
			// registro da ueb é individual
			if(!financeitrSelecionadoNaTabela.getIdRazaoPgto().equals("Registro UEB") ){
				select.iniciaTransacao();
				for( Familiares f :  familiaresList){
					select.deleta(" iquali_ibirabase.dadosfinanceiro ", "competencia = '"+financeitrSelecionadoNaTabela.getCompetencia()+"' "
																+ "and  idJovem = "+f.getIddadosjovem()+"  "
																+ " and idRazaoPgto = ( SELECT idrzpgto  FROM iquali_ibirabase.razaopagamento where descricao = 'Contribuição Mensal' )" , false);
				}
				select.finalizaTransacao();	
			}else {
				select.deleta(" iquali_ibirabase.dadosfinanceiro ", " idFin = "+financeitrSelecionadoNaTabela.getIdFin(), false);
			}
						
			atualizaTabelaPagamento();

		} catch (Exception c) {
			return;
		}
	}

	public void selecaoListener(AjaxBehaviorEvent event) throws IOException,
			Exception {
		UIExtendedDataTable dataTable = (UIExtendedDataTable) event
				.getComponent();
		// Object originalKey = dataTable.getRowKey();

		for (Object chave : selecao) {
			dataTable.setRowKey(chave);
			if (dataTable.isRowAvailable()) {

				financeitrSelecionadoNaTabela = (DadosFinanceiro) dataTable
						.getRowData();

			}
		}
		selecao.clear();
	}

	public void alteraDadoPagamentoJaPago(ActionEvent event)
			throws WebServiceException, Exception {

		try {

			System.out.println();

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

	public void buscaDadoPagamentoJaPago(ActionEvent event)
			throws WebServiceException, Exception {
		
		try {
			
			atualizaTabelaPagamento();

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
	
	
	
	private void atualizaTabelaPagamento() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		dadosDevedorFinanceiroList = new ArrayList();
		dadosDevedorFinanceiroMap = new HashMap();
		
		vvvTtoDev = 0;
		
		
		String v[] = {"","",""};
		if (!((nomeJovemSelectAutoComplete == null || nomeJovemSelectAutoComplete.equals("")))){
			v = nomeJovemSelectAutoComplete.split("-");
		}else if (!(nroFamiliaCorrentSelected ==null || nroFamiliaCorrentSelected.equals(""))) {
			
			v[0] = dadosNroFamilia.getNroFamilia();
			v[1] = dadosNroFamilia.getNomeJoven();
			
		}else {
			return;
		}
		

		Dml select = Dml.getInstance();
		
		dadosFinanceiroList = select.busca(" iquali_ibirabase.dadosjovem " , "isento",""," where nroFamilia = '"+ 
							v[0].trim()+ "' and nomeJoven = '"+ v[1].trim()
							+ "' ",false, new DadosFinanceiro());
		
		String eIsento = "";
		for(DadosFinanceiro d : dadosFinanceiroList){
			eIsento = d.getIsento();
			break;
		}
		
		if(eIsento.equals("1")){
			textoIsento = "Jovem Isento";
		}else{
			textoIsento = "";
		}
		

		// LISTA DE PAGAMENTO EFETUADOS
		dadosFinanceiroList = select
				.busca(" iquali_ibirabase.dadosjovem a , iquali_ibirabase.dadosfinanceiro b  ",
						" b.idFin, Date(b.dataPagamento) dataPagamento, b.valorPagamento, b.competencia,"
						+ " (SELECT descricao FROM iquali_ibirabase.razaopagamento where idrzpgto = b.idRazaoPgto) idRazaoPgto, "
						+ " (SELECT descricao FROM iquali_ibirabase.tipopagamento where idTipoPgto = b.idTipoFormaPgto) idTipoFormaPgto ,"
						+ "a.iddadosjovem ",
						"  order by b.competencia desc",
						" where a.iddadosjovem = b.idJovem and a.nroFamilia = '"
								+ v[0].trim()
								+ "' and a.nomeJoven = '"
								+ v[1].trim()
								+ "' "
								+ " and ( b.idRazaoPgto = (SELECT idrzpgto FROM iquali_ibirabase.razaopagamento where descricao = 'Registro UEB') "
								+ " or b.idRazaoPgto = (SELECT idrzpgto FROM iquali_ibirabase.razaopagamento where descricao = 'Contribuição Mensal') )",
						false, new DadosFinanceiro());

		// LISTA DE PAGAMENTOS A DEVER
		// dadosDevedorFinanceiroList =
		// select.busca(" dadosDevedorFinanceiro ",
		// " idDevFin, datadevendo, valorDevendo, razaoDevendo",
		// " ","",true,new DadosDevedorFinanceiro());

		List<Variaveis> variaveis = select
				.busca(" iquali_ibirabase.variaveis ",
						" id,contribMensal,contrbMensalAtrasadaMes,contribMensalAtrasadaForaMes,registroUEB,registroUEBChefe,ativo,anobase,diaVencimentoMensalidade,anoAnterior ",
						" ", "  where ativo = 0 ", false, new Variaveis());

		// lista de variaveis para depois comparar e smamr valores .
		// nao esquecer de calcular o ano anterior
		
		
		familiaresList = select
				.busca("iquali_ibirabase.dadosjovem ",
						" iddadosjovem, "
						+ "		(select secao from secoes where id = idsecao) secao,"
						+ "        nomeJoven ",
						" ", "  where ativo = 0 and "
						   + " nroFamilia = (SELECT nroFamilia FROM iquali_ibirabase.dadosjovem where iddadosjovem =  "+idJovemSelecionado+" )", false, new Familiares());
		
		
		
		analisaDevedorAno(variaveis);
	
		valorTotalDevido = "Total Devido...:    R$ " + vvvTtoDev;
		
		
	}
	
	
	
	
	private void analisaDevedorAno(List<Variaveis> variaveis){
		
		
		DateTime d = new DateTime();
		
		int totalMeses = (new Integer(ano).intValue() != d.getYear() ? 12: d.getMonthOfYear() );
		
		int anoBase = new Integer(ano).intValue();

		int mes = 1;
		
		boolean pagouUEB = false;
		
		int index = 0 ;
		
		for (; mes <= totalMeses; mes++) {
			index++;
			if (dadosFinanceiroList.size() == 0) {
				incluiMesDevedor(variaveis, new DateTime(), mes, totalMeses,anoBase,""+index+anoBase);
			}
			
			boolean isContribuicaoPago = false;

			for (int i = 0; i < dadosFinanceiroList.size(); i++) {
				if (dadosFinanceiroList.get(i).getIdRazaoPgto()
						.equals("Registro UEB")&& new Integer(dadosFinanceiroList.get(i).getCompetencia().substring(0,2)).intValue() == mes && new Integer(dadosFinanceiroList.get(i).getCompetencia().substring(3,7)).intValue() == anoBase) {
					pagouUEB = true;
				}
				if (dadosFinanceiroList.get(i).getIdRazaoPgto()
						.equals("Contribuição Mensal") && new Integer(dadosFinanceiroList.get(i).getCompetencia().substring(0,2)).intValue() == mes && new Integer(dadosFinanceiroList.get(i).getCompetencia().substring(3,7)).intValue() == anoBase) {
					isContribuicaoPago = true;
				}
			}
			if(!isContribuicaoPago){
				incluiMesDevedor(variaveis, new DateTime(), mes, totalMeses,anoBase,""+index+anoBase);
			}
			
		}
		
		
		if (pagouUEB == false) {
			DadosDevedorFinanceiro dadosDevedorFinanceiro = new DadosDevedorFinanceiro();

			dadosDevedorFinanceiro.setDatadevendo("01" + "/"
					+ anoBase);
			dadosDevedorFinanceiro.setRazaoDevendo("Registro UEB");
			dadosDevedorFinanceiro.setValorDevendo(variaveis.get(0)
					.getRegistroUEB());

			vvvTtoDev = vvvTtoDev
					+ new Double(variaveis.get(0).getRegistroUEB());

			dadosDevedorFinanceiroMap.put("Registro UEB"+anoBase,dadosDevedorFinanceiro);
		}
		
		 for (int i = 0; i <= totalMeses ; i++) {
			 DadosDevedorFinanceiro x = dadosDevedorFinanceiroMap.get(""+i+anoBase);
			 if(x != null){
			  this.dadosDevedorFinanceiroList.add(x);
			 }
		   }
		 DadosDevedorFinanceiro x = dadosDevedorFinanceiroMap.get("Registro UEB"+anoBase);
		 if(x != null){
			  this.dadosDevedorFinanceiroList.add(x);
		 }
	}
	 
	
	
	
	
	private void incluiMesDevedor(List<Variaveis> variaveis, DateTime datetime,
			int mes, int mesAtual, int anoBase, String index) {

		int diadeHoje = datetime.getDayOfMonth();

		DadosDevedorFinanceiro dadosDevedorFinanceiro = new DadosDevedorFinanceiro();
		dadosDevedorFinanceiro.setDatadevendo("" + (mes < 10 ? "0" + mes : mes)
				+ "/" + anoBase);
		dadosDevedorFinanceiro.setRazaoDevendo("Contribuição Mensal");

		String contriDevedora = "";

		if (diadeHoje > new Integer(variaveis.get(0)
				.getDiaVencimentoMensalidade()).intValue()) {
			contriDevedora = variaveis.get(0).getContrbMensalAtrasadaMes();
		} else {
			contriDevedora = variaveis.get(0).getContribMensal();
		}

		if (mes != mesAtual) {
			contriDevedora = variaveis.get(0).getContribMensalAtrasadaForaMes();
		}
		dadosDevedorFinanceiro.setValorDevendo(contriDevedora);

		vvvTtoDev = vvvTtoDev + new Double(contriDevedora);

		dadosDevedorFinanceiroMap.put(index,dadosDevedorFinanceiro);

	}

	public void limpaBuscarDadsJovem(ActionEvent event)
			throws WebServiceException, Exception {

		setNroFamiliaCorrentSelected("");
		dadosNroFamilia.setNroFamiliaSelected("");
		setNomeJovemSelectAutoComplete("");

	}

	public void valueChanged(ValueChangeEvent event) {
		if (null != event.getNewValue()) {
			String[] currentItems;

			for (DadosNroFamilia dadosNroFamiliaLocal : nroFamiliaList) {

				if (dadosNroFamiliaLocal.getIddadosjovem().equals(
						event.getNewValue())) {
					dadosNroFamilia = dadosNroFamiliaLocal;
					nomeJovemFinanceiro = dadosNroFamilia.getNroFamilia()
							+ "-" + dadosNroFamilia.getNomeJoven() + "-" + dadosNroFamilia.getSecao();
					idJovemSelecionado = dadosNroFamilia.getIddadosjovem();
					break;
				}

			}

		}

		nomeJovemSelectAutoComplete = "";
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////
	// GETTERS AND SETTERS
	// ////////////////////////////////////////////////////////////////////////////////////////////

	public DadosNroFamilia getDadosNroFamilia() {
		return dadosNroFamilia;
	}

	public String getNomeJovemAutoComplete() {
		return nomeJovemAutoComplete;
	}

	public void setNomeJovemAutoComplete(String nomeJovemAutoComplete) {
		this.nomeJovemAutoComplete = nomeJovemAutoComplete;
	}

	public int getIdSindicoGeral() {
		return idSindicoGeral;
	}

	public void setIdSindicoGeral(int idSindicoGeral) {
		this.idSindicoGeral = idSindicoGeral;
	}

	public void setDadosNroFamilia(DadosNroFamilia dadosNroFamilia) {
		this.dadosNroFamilia = dadosNroFamilia;
	}

	public String getNomeJovemFinanceiro() {
		return nomeJovemFinanceiro;
	}

	public void setNomeJovemFinanceiro(String nomeJovemFinanceiro) {
		this.nomeJovemFinanceiro = nomeJovemFinanceiro;
	}

	public String getNomeJovemSelectAutoComplete() {
		return nomeJovemSelectAutoComplete;
	}

	public void setNomeJovemSelectAutoComplete(
			String nomeJovemSelectAutoComplete) {
		this.nomeJovemSelectAutoComplete = nomeJovemSelectAutoComplete;
	}

	public List<TipoPagamento> getTipoPagamentoList() {
		return tipoPagamentoList;
	}

	public void setTipoPagamentoList(List<TipoPagamento> tipoPagamentoList) {
		this.tipoPagamentoList = tipoPagamentoList;
	}

	public List<RazaoPagamento> getRazaoPagamentoList() {
		return razaoPagamentoList;
	}

	public void setRazaoPagamentoList(List<RazaoPagamento> razaoPagamentoList) {
		this.razaoPagamentoList = razaoPagamentoList;
	}

	public DadosFinanceiro getDadosFinanceiro() {
		return dadosFinanceiro;
	}

	public void setDadosFinanceiro(DadosFinanceiro dadosFinanceiro) {
		this.dadosFinanceiro = dadosFinanceiro;
	}

	public List<DadosFinanceiro> getDadosFinanceiroList() {
		return dadosFinanceiroList;
	}

	public void setDadosFinanceiroList(List<DadosFinanceiro> dadosFinanceiroList) {
		this.dadosFinanceiroList = dadosFinanceiroList;
	}

	public Collection<Object> getSelecao() {
		return selecao;
	}

	public void setSelecao(Collection<Object> selecao) {
		this.selecao = selecao;
	}

	public DadosFinanceiro getFinanceitrSelecionadoNaTabela() {
		return financeitrSelecionadoNaTabela;
	}

	public void setFinanceitrSelecionadoNaTabela(
			DadosFinanceiro financeitrSelecionadoNaTabela) {
		this.financeitrSelecionadoNaTabela = financeitrSelecionadoNaTabela;
	}

	public int getCurrentFinanceiroOnTable() {
		return currentFinanceiroOnTable;
	}

	public void setCurrentFinanceiroOnTable(int currentFinanceiroOnTable) {
		this.currentFinanceiroOnTable = currentFinanceiroOnTable;
	}

	public String getValorTotalDevido() {
		return valorTotalDevido;
	}

	public void setValorTotalDevido(String valorTotalDevido) {
		this.valorTotalDevido = valorTotalDevido;
	}

	public String getNroFamiliaCorrentSelected() {
		return nroFamiliaCorrentSelected;
	}

	public void setNroFamiliaCorrentSelected(String nroFamiliaCorrentSelected) {
		this.nroFamiliaCorrentSelected = nroFamiliaCorrentSelected;
	}

	public List<SelectItem> getNroFamiliaListselectItem() {
		return nroFamiliaListselectItem;
	}

	public void setNroFamiliaListselectItem(
			List<SelectItem> nroFamiliaListselectItem) {
		this.nroFamiliaListselectItem = nroFamiliaListselectItem;
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
	
	public Map<String,DadosDevedorFinanceiro> getDadosDevedorFinanceiroMap(){
		return dadosDevedorFinanceiroMap;
	}
	
	  public List<DadosDevedorFinanceiro> getDadosDevedorFinanceiroList(){
		  
		  return this.dadosDevedorFinanceiroList;
	  }

	public List<Variaveis> getVariaveisList() {
		return variaveisList;
	}

	public void setVariaveisList(List<Variaveis> variaveisList) {
		this.variaveisList = variaveisList;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public double getVvvTtoDev() {
		return vvvTtoDev;
	}

	public void setVvvTtoDev(double vvvTtoDev) {
		this.vvvTtoDev = vvvTtoDev;
	}

	public List<Familiares> getFamiliaresList() {
		return familiaresList;
	}

	public void setFamiliaresList(List<Familiares> familiaresList) {
		this.familiaresList = familiaresList;
	}

	public void setDadosDevedorFinanceiroMap(
			Map<String, DadosDevedorFinanceiro> dadosDevedorFinanceiroMap) {
		this.dadosDevedorFinanceiroMap = dadosDevedorFinanceiroMap;
	}

	public void setDadosDevedorFinanceiroList(
			List<DadosDevedorFinanceiro> dadosDevedorFinanceiroList) {
		this.dadosDevedorFinanceiroList = dadosDevedorFinanceiroList;
	}


	public DadosDevedorFinanceiro getDevedorSelected() {
		return devedorSelected;
	}


	public void setDevedorSelected(DadosDevedorFinanceiro devedorSelected) {
		this.devedorSelected = devedorSelected;
	}


	public String getTextoIsento() {
		return textoIsento;
	}


	public void setTextoIsento(String textoIsento) {
		this.textoIsento = textoIsento;
	}




	  
	  

}
