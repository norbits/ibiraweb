
	
	package br.com.ibiraweb.relatorio.jovens;

	import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.joda.time.DateTime;
import org.richfaces.component.UICommandButton;
import org.richfaces.component.UIExtendedDataTable;

import br.com.ibiraweb.bean.DadosJovem;
import br.com.ibiraweb.bean.DetalhePago;
import br.com.ibiraweb.bean.SecaoDevedor;
import br.com.ibiraweb.bean.Secoes;
import br.com.ibiraweb.bean.Variaveis;
import br.com.ibiraweb.iqualitywebws.Dml;
import br.com.ibiraweb.iqualitywebws.InvalidInputException;



	@ManagedBean(name = "relatoriocontroller")
	@SessionScoped
	public class RelatorioController {
		
		private List<Secoes> 			secoesList ;
		private DadosJovem 				dadosJovem ;
		private Collection<Object> 		selecao;
		private List<SecaoDevedor>		secaoDevedorList;
		private List<DetalhePago>		detalhePagoList;
		private List<Variaveis> 		variaveisList;
		private String ano;
		
		private String totalDeJovens		   = "Total de Jovens Da Seção......................:";
		private String totalInscricoesUEBPagas = "Total Inscrições UEB Pagas...............:";
		private String totalContribuicoesPagas = "Total Contribuições Pagas.............:";
		private String totalInscricoesUEBNaoPagas = "Total Inscrições UEB NÃO Pagas...:";
		private String totalContribuicoesNaoPagas = "Total Contribuições NÃO Pagas.....:";
		 
		private String totalDeJovensValor		   = "";
		private String totalInscricoesUEBPagasValor = "";
		private String totalContribuicoesPagasValor = "";
		private String totalInscricoesUEBNaoPagasValor = "";
		private String totalContribuicoesNaoPagasValor = "";


		
		public int getInit() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException{
			
			 Dml select =  Dml.getInstance();
			 variaveisList = select.busca(" iquali_ibirabase.variaveis ", " anobase ", " "," where ativo = 0",false,new Variaveis());
			 for (Variaveis var : variaveisList) {
				 ano = var.getAnobase();
			}
			 
			 if(ano == null){
				 ano = ""+new DateTime().getYear();
			 }
			
			secaoDevedorList = new ArrayList();
			dadosJovem = new DadosJovem();
			
			totalDeJovensValor		   = "";
			totalInscricoesUEBPagasValor = "";
			totalContribuicoesPagasValor = "";
			totalInscricoesUEBNaoPagasValor = "";
			totalContribuicoesNaoPagasValor = "";

			
			return 0;
		}
		
		
		public RelatorioController() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException{
			
			secaoDevedorList = new ArrayList();
			
			secoesList  = new ArrayList();
			
			dadosJovem = new DadosJovem();
			
			 
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
		

		public List<SecaoDevedor> getDadosSecaoList() throws InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
			Secoes result = new Secoes();
			totalDeJovens		   = "Total de Jovens Da Seção...............:";
			totalInscricoesUEBPagas = "Total Inscrições UEB Pagas...........:";
			totalContribuicoesPagas = "Total Contribuições Pagas.............:";
			totalInscricoesUEBNaoPagas = "Total Inscrições UEB NÃO Pagas...:";
			totalContribuicoesNaoPagas = "Total Contribuições NÃO Pagas.....:";

			//if (secoesList == null) {
			
			if(dadosJovem.getIdsecao() != "" && new Integer(dadosJovem.getIdsecao()).intValue() >= 0){
				 Dml select =  Dml.getInstance();
				 secaoDevedorList =  select.busca("  iquali_ibirabase.dadosjovem dj  ", 
						 " dj.iddadosjovem, dj.nroFamilia,dj.nomeJoven ,dj.nroRegistro ", " ",
						 " where dj.idsecao = "+dadosJovem.getIdsecao()+"  and dj.ativo = 0 ",false,new SecaoDevedor());
				 
				 
				 detalhePagoList = select.busca(" iquali_ibirabase.dadosfinanceiro df ", 
						 " df.idJovem,Date(df.dataPagamento) dataPagamento,"
					   + "	    df.valorPagamento,"
					   + "         (SELECT descricao FROM iquali_ibirabase.tipopagamento tip"
					   + " where tip.idTipoPgto = df.idTipoFormaPgto ) idTipoFormaPgto,"
					   + " df.competencia, "
					   + "  (select isento from iquali_ibirabase.dadosjovem y where y.iddadosjovem = df.idJovem) isento ", 
					   "", " where df.idRazaoPgto = (SELECT ra.idrzpgto FROM iquali_ibirabase.razaopagamento ra"
					   		+ " where ra.descricao = 'Registro UEB') "
					   		+ "and RIGHT(competencia,4) = '"+ano+"'", false, new DetalhePago());
				 
				 int totalRegistrosUEBAnuaisPagas = 0;
				 
				 for ( SecaoDevedor secd : secaoDevedorList ){
					 for (DetalhePago det : detalhePagoList ){
						 if(secd.getIddadosjovem().trim().equals(det.getIdJovem().trim())){
							 secd.setUebDataPgto(det.getDataPagamento());
							 secd.setUebValorPago(det.getValorPagamento());
							 secd.setUebFormaPaga(det.getIdTipoFormaPgto());
							 secd.setIsento(det.getIsento());
							 
							 totalRegistrosUEBAnuaisPagas++;
							 break;
						 }
					 }
				 }
				 
				 
			detalhePagoList = select.busca(" iquali_ibirabase.dadosfinanceiro df ", 
						 " df.idJovem,Date(df.dataPagamento) dataPagamento,"
						 + " 	    df.valorPagamento,"
						 + "        (SELECT descricao FROM iquali_ibirabase.tipopagamento tip"
						 + " where tip.idTipoPgto = df.idTipoFormaPgto ) idTipoFormaPgto,"
						 + " df.competencia, "
						 + " (select isento from iquali_ibirabase.dadosjovem y where y.iddadosjovem = df.idJovem) isento  ",
						 " order by df.idJovem,df.competencia ", 
						 " where df.idRazaoPgto = (SELECT ra.idrzpgto FROM iquali_ibirabase.razaopagamento ra"
						 + "						where ra.descricao = 'Contribuição Mensal')"
						 + "and RIGHT(competencia,4) = '"+ano+"'", false, new DetalhePago());
				 
			
			
			
			
				 int totalContribuicoesMensaisPagas = 0;
				 
				 for ( SecaoDevedor secd : secaoDevedorList ){
					 for (DetalhePago det : detalhePagoList ){
						 if(secd.getIddadosjovem().trim().equals(det.getIdJovem().trim())){
							 
							 
							 if( det.getIsento().equals("1")){
								 secd.setJaneiroDataPgto("Isento");
								 secd.setJaneiroValorPago("Isento");
								 secd.setJaneiroFormaPaga("Isento");
								 
								 secd.setFevereiroDataPgto("Isento");
								 secd.setFevereiroValorPago("Isento");
								 secd.setFevereiroFormaPaga("Isento");
								 
								 secd.setMarcoDataPgto("Isento");
								 secd.setMarcoValorPago("Isento");
								 secd.setMarcoFormaPaga("Isento");
								 
								 secd.setAbrilDataPgto("Isento");
								 secd.setAbrilValorPago("Isento");
								 secd.setAbrilFormaPaga("Isento");
								 
								 secd.setMaioDataPgto("Isento");
								 secd.setMaioValorPago("Isento");
								 secd.setMaioFormaPaga("Isento");
								 
								 secd.setJunhoDataPgto("Isento");
								 secd.setJunhoValorPago("Isento");
								 secd.setJunhoFormaPaga("Isento");
								 
								 secd.setJulhoDataPgto("Isento");
								 secd.setJulhoValorPago("Isento");
								 secd.setJulhoFormaPaga("Isento");
								 
								 secd.setAgostoDataPgto("Isento");
								 secd.setAgostoValorPago("Isento");
								 secd.setAgostoFormaPaga("Isento");
								 
								 secd.setSetembroDataPgto("Isento");
								 secd.setSetembroValorPago("Isento");
								 secd.setSetembroFormaPaga("Isento");
								 
								 secd.setOutubroDataPgto("Isento");
								 secd.setOutubroValorPago("Isento");
								 secd.setOutubroFormaPaga("Isento");
								 
								 secd.setNovembroDataPgto("Isento");
								 secd.setNovembroValorPago("Isento");
								 secd.setNovembroFormaPaga("Isento");
								 
								 secd.setDezembroDataPgto("Isento");
								 secd.setDezembroValorPago("Isento");
								 secd.setDezembroFormaPaga("Isento");
							 }else {
							 
							 
									 
									 if(det.getCompetencia().equals("01/"+ano)){
										 secd.setJaneiroDataPgto(det.getDataPagamento());
										 secd.setJaneiroValorPago(det.getValorPagamento());
										 secd.setJaneiroFormaPaga(det.getIdTipoFormaPgto());
										 totalContribuicoesMensaisPagas++;
									 }
									 if(det.getCompetencia().equals("02/"+ano)){
										 secd.setFevereiroDataPgto(det.getDataPagamento());
										 secd.setFevereiroValorPago(det.getValorPagamento());
										 secd.setFevereiroFormaPaga(det.getIdTipoFormaPgto());
										 totalContribuicoesMensaisPagas++;
									 }
									 if(det.getCompetencia().equals("03/"+ano)){
										 secd.setMarcoDataPgto(det.getDataPagamento());
										 secd.setMarcoValorPago(det.getValorPagamento());
										 secd.setMarcoFormaPaga(det.getIdTipoFormaPgto());
										 totalContribuicoesMensaisPagas++;
									 }
									 if(det.getCompetencia().equals("04/"+ano)){
										 secd.setAbrilDataPgto(det.getDataPagamento());
										 secd.setAbrilValorPago(det.getValorPagamento());
										 secd.setAbrilFormaPaga(det.getIdTipoFormaPgto());
										 totalContribuicoesMensaisPagas++;
									 }
									 if(det.getCompetencia().equals("05/"+ano)){
										 secd.setMaioDataPgto(det.getDataPagamento());
										 secd.setMaioValorPago(det.getValorPagamento());
										 secd.setMaioFormaPaga(det.getIdTipoFormaPgto());
										 totalContribuicoesMensaisPagas++;
									 }
									 if(det.getCompetencia().equals("06/"+ano)){
										 secd.setJunhoDataPgto(det.getDataPagamento());
										 secd.setJunhoValorPago(det.getValorPagamento());
										 secd.setJunhoFormaPaga(det.getIdTipoFormaPgto());
										 totalContribuicoesMensaisPagas++;
									 }
									 if(det.getCompetencia().equals("07/"+ano)){
										 secd.setJulhoDataPgto(det.getDataPagamento());
										 secd.setJulhoValorPago(det.getValorPagamento());
										 secd.setJulhoFormaPaga(det.getIdTipoFormaPgto());
										 totalContribuicoesMensaisPagas++;
									 }
									 if(det.getCompetencia().equals("08/"+ano)){
										 secd.setAgostoDataPgto(det.getDataPagamento());
										 secd.setAgostoValorPago(det.getValorPagamento());
										 secd.setAgostoFormaPaga(det.getIdTipoFormaPgto());
										 totalContribuicoesMensaisPagas++;
									 }
									 if(det.getCompetencia().equals("09/"+ano)){
										 secd.setSetembroDataPgto(det.getDataPagamento());
										 secd.setSetembroValorPago(det.getValorPagamento());
										 secd.setSetembroFormaPaga(det.getIdTipoFormaPgto());
										 totalContribuicoesMensaisPagas++;
									 }
									 if(det.getCompetencia().equals("10/"+ano)){
										 secd.setOutubroDataPgto(det.getDataPagamento());
										 secd.setOutubroValorPago(det.getValorPagamento());
										 secd.setOutubroFormaPaga(det.getIdTipoFormaPgto());
										 totalContribuicoesMensaisPagas++;
									 }
									 if(det.getCompetencia().equals("11/"+ano)){
										 secd.setNovembroDataPgto(det.getDataPagamento());
										 secd.setNovembroValorPago(det.getValorPagamento());
										 secd.setNovembroFormaPaga(det.getIdTipoFormaPgto());
										 totalContribuicoesMensaisPagas++;
									 }
									 if(det.getCompetencia().equals("12/"+ano)){
										 secd.setDezembroDataPgto(det.getDataPagamento());
										 secd.setDezembroValorPago(det.getValorPagamento());
										 secd.setDezembroFormaPaga(det.getIdTipoFormaPgto());
										 totalContribuicoesMensaisPagas++;
									 }
									 
							 }
						 }
					 }
				 }
				 
				 
				 
				 DateTime d = new DateTime();
				 
				 int totaldeMeses = new Integer(ano).intValue() == d.getYear() ? d.getMonthOfYear() : 12;  
				 
				 
				 
				 totalDeJovensValor = ""+secaoDevedorList.size();
				 
				 totalContribuicoesPagasValor =  " " + totalContribuicoesMensaisPagas; 
				 totalInscricoesUEBPagasValor= "" + totalRegistrosUEBAnuaisPagas;				 
				 
				 totalInscricoesUEBNaoPagasValor =  "" + (secaoDevedorList.size() - totalRegistrosUEBAnuaisPagas);
				 
				 totalContribuicoesNaoPagasValor =  "" + ((secaoDevedorList.size() * totaldeMeses ) - totalContribuicoesMensaisPagas);
				 
				 
				 
			}else
			{
				secaoDevedorList = new ArrayList();
			}
			
			
			
			
			
			
				 
				
			return secaoDevedorList;
		}

		
		
		
		public void geraDadosExcell(ActionEvent event) throws WebServiceException, Exception {

			try {

				
				if(secaoDevedorList == null || secaoDevedorList.size() == 0){
					
					FacesContext fctx = FacesContext.getCurrentInstance();
    				UIComponent impt = event.getComponent();
    				UICommandButton uiInput = ((UICommandButton) impt
    						.findComponent("secaorelatorioForm:btnGera"));

    				FacesMessage msg = new FacesMessage("ERRO GRAVE! ",
    						"Não ha Dados Para Gerar Arquivo !" );
    				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
    				fctx.addMessage(uiInput.getClientId(fctx), msg);
    				return;
					
					
				}
				
				
				String secaoSelecionada = "";
				for (Secoes  s : secoesList){
					if(new Integer(s.getId()).intValue() == new Integer(dadosJovem.getIdsecao()).intValue() ){
						secaoSelecionada = s.getSecao();
						break;
					}
				}

				DateTime d = new DateTime();
				
				int dia = d.getDayOfMonth();
				int mes = d.getMonthOfYear();
				int ano = d.getYear();
				
				
				 File diretorio = new File("c:\\Relatorios");
				 if (!diretorio.exists()) {
					 diretorio.mkdirs();
				 }
				 
			        //Blank workbook
				 HSSFWorkbook workbook = new HSSFWorkbook();
			         
			        //Create a blank sheet
				 HSSFSheet sheet = workbook.createSheet("Seção-"+secaoSelecionada);
				 
				  ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
				     
				    String serverRealPath = servletContext.getRealPath("/");
				    //String serverContextPath = servletContext.getContextPath();
				 
				 String path = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
				 InputStream my_banner_image = new FileInputStream(serverRealPath+"/resources/images/escout3.png");
				 
				 byte[] bytes = IOUtils.toByteArray(my_banner_image);
				 int my_picture_id = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
	                my_banner_image.close();
	                HSSFPatriarch drawing = sheet.createDrawingPatriarch();
	                ClientAnchor my_anchor = new HSSFClientAnchor();
	                /* Define top left corner, and we can resize picture suitable from there */
	                my_anchor.setCol1(0);
	                my_anchor.setRow1(0);
	                
	                HSSFPicture  my_picture = drawing.createPicture(my_anchor, my_picture_id);
	                my_picture.resize();
			          
			        //This data needs to be written (Object[])
			        Map<String, Object[]> data = new TreeMap<String, Object[]>();
			        
			        Row row = sheet.createRow(2);
			        Cell cell = row.createCell(0);
			        HSSFCellStyle my_style = workbook.createCellStyle();
	                   
	                   HSSFFont  font = workbook.createFont();
	                   font.setBoldweight( HSSFFont.BOLDWEIGHT_BOLD);
	                   font.setFontHeightInPoints((short)14);
	                   my_style.setFont(font);
	                   cell.setCellStyle(my_style);
	                   cell.setCellValue("Relatório ");
	                   
	                   row = sheet.createRow(3);
	                   cell = row.createCell(0);
	                   cell.setCellStyle(my_style);
	                   cell.setCellValue("Devedor/Pagador");
	                   
	                   row = sheet.createRow(4);
	                   cell = row.createCell(0);
	                   cell.setCellStyle(my_style);
                   cell.setCellValue(secaoSelecionada.toUpperCase()+" - "+ano);
	                   
					         data.put("11000", new Object[] {//"  ", "            ", "             ", 
					        		 "             " 
					        		 ,"Ueb" 
					        		 ,"Jan"
					        		 ,"Fev"
					        		 ,"Mar"
					        		 ,"Abr"
					        		 ,"Mai"
					        		 ,"Jun"
					        		 ,"Jul"
					        		 ,"Ago"
					        		 ,"Set"
					        		 ,"Out"
					        		 ,"Nov"
					        		 ,"Dez"});
					         
//					         data.put("11001", new Object[] {"ID", "Nro.Famil.", "Nome do Joven", "Nro.Reg.UEB" 
//					        		 ," Valor ",
//					        		  " Valor ",  
//					        		  " Valor ",
//					        		  " Valor ",
//					        		  " Valor ",
//					        		  " Valor ",
//					        		  " Valor ",
//					        		  " Valor ",
//					        		  " Valor ",
//					        		  " Valor ",
//					        		  " Valor ",
//					        		  " Valor "
//					         			} );
					         
			        int idx = 11002;
			        for(SecaoDevedor s : secaoDevedorList){
			        	idx++;
			        	data.put(""+idx, new Object[] {
			        			//s.getIddadosjovem(), 
			        			//s.getNroFamilia(), 
			        			s.getNomeJoven().length()>25?s.getNomeJoven().substring(0, 25):s.getNomeJoven(), 
			        			//s.getNroRegistro() , 
			        	s.getIsento()!=null&&s.getIsento().equals("1")?"Ise":s.getUebValorPago()==null?"":"X"
			        	,s.getIsento()!=null&&s.getIsento().equals("1")?"Ise":s.getJaneiroValorPago()==null?"":"X"
			        	,s.getIsento()!=null&&s.getIsento().equals("1")?"Ise":s.getFevereiroValorPago()==null?"":"X"
			        	,s.getIsento()!=null&&s.getIsento().equals("1")?"Ise":s.getMarcoValorPago()==null?"":"X"
		 	        	,s.getIsento()!=null&&s.getIsento().equals("1")?"Ise":s.getAbrilValorPago()==null?"":"X"
			        	,s.getIsento()!=null&&s.getIsento().equals("1")?"Ise":s.getMaioValorPago()==null?"":"X"
			        	,s.getIsento()!=null&&s.getIsento().equals("1")?"Ise":s.getJunhoValorPago()==null?"":"X"
			        	,s.getIsento()!=null&&s.getIsento().equals("1")?"Ise":s.getJulhoValorPago()==null?"":"X"
			        	,s.getIsento()!=null&&s.getIsento().equals("1")?"Ise":s.getAgostoValorPago()==null?"":"X"
			        	,s.getIsento()!=null&&s.getIsento().equals("1")?"Ise":s.getSetembroValorPago()==null?"":"X"
			        	,s.getIsento()!=null&&s.getIsento().equals("1")?"Ise":s.getOutubroValorPago()==null?"":"X"
			        	,s.getIsento()!=null&&s.getIsento().equals("1")?"Ise":s.getNovembroValorPago()==null?"":"X"
			        	,s.getIsento()!=null&&s.getIsento().equals("1")?"Ise":s.getDezembroValorPago()==null?"":"X"
			        	});			        	
			        	
			        };
			        
			        
			        //Iterate over data and write to sheet
			        Set<String> keyset = data.keySet();
			        int rownum = 7;
			        for (String key : keyset)
			        {
			             row = sheet.createRow(rownum++);
			            Object [] objArr = data.get(key);
			            int cellnum = 0;
			            
			            for (Object obj : objArr)
			            {
			                cell = row.createCell(cellnum++);
			               
			               if(obj instanceof String)
			                    cell.setCellValue((String)obj);
			                else if(obj instanceof Integer)
			                    cell.setCellValue((Integer)obj);
			               
			               my_style = workbook.createCellStyle();
			               
//			               if(    (cellnum == 0  || cellnum == 1  ||
//			            		   cellnum == 2  || cellnum == 3  || cellnum == 4 ||
//			            		   cellnum == 5  || cellnum == 5  || cellnum == 6 ||
//			            		   cellnum == 7  || cellnum == 8  ||cellnum == 9  ||
//			            		   cellnum == 10 || cellnum == 11 ||cellnum == 12 ||
//			            		   cellnum == 13 || cellnum == 14 ||cellnum == 15 || 
//			            		   cellnum == 16 || cellnum == 17 ||cellnum == 18) && (rownum == 8 || rownum == 9) ){
//			                   my_style.setFillPattern(HSSFCellStyle.FINE_DOTS );
//			                   my_style.setFillForegroundColor(new HSSFColor.GREY_25_PERCENT().getIndex());
//			                   my_style.setFillBackgroundColor(new HSSFColor.GREEN().getIndex());
//			                   cell.setCellStyle(my_style);
//			               }
			               
			               if(    (cellnum == 0  || cellnum == 1  ||
			            		   cellnum == 2  || cellnum == 3  || cellnum == 4 ||
			            		   cellnum == 5  || cellnum == 5  || cellnum == 6 ||
			            		   cellnum == 7  || cellnum == 8  ||cellnum == 9  ||
			            		   cellnum == 10 || cellnum == 11 ||cellnum == 12 ||
			            		   cellnum == 13 || cellnum == 14 ||cellnum == 15 || 
			            		   cellnum == 16 || cellnum == 17 ||cellnum == 18) && (rownum == 8 || rownum == 9) ){
				                font = workbook.createFont();
			                   font.setBoldweight( HSSFFont.BOLDWEIGHT_BOLD);
			                   my_style.setFont(font);
			                   cell.setCellStyle(my_style);
			               }
			            }
			        }
			        
			        
			        
//			        font = workbook.createFont();
//                    font.setBoldweight( HSSFFont.BOLDWEIGHT_BOLD);
//                    font.setItalic(true);
//                    font.setColor(new HSSFColor.BLUE().getIndex());
//                    font.setFontHeightInPoints((short)12);
//                    my_style.setFont(font);
//			        
//			        int cellnum = 0;
//			        row = sheet.createRow(rownum++);
//                    cell = row.createCell(cellnum);
//                    cell.setCellStyle(my_style);
//                    cell.setCellValue(totalDeJovens);
//                    
//                    cell = row.createCell(cellnum+1);
//                    cell.setCellStyle(my_style);
//                    cell.setCellValue(totalDeJovensValor);
//
//                    
//                    
//			        
//                    row = sheet.createRow(rownum++);
//                    cell = row.createCell(cellnum);
//                    cell.setCellStyle(my_style);
//                    cell.setCellValue(totalContribuicoesPagas);
//                    
//                    cell = row.createCell(cellnum+1);
//                    cell.setCellStyle(my_style);
//                    cell.setCellValue(totalContribuicoesPagasValor);
//                    
//                    
//                    
//                    
//                    row = sheet.createRow(rownum++);
//                    cell = row.createCell(cellnum);
//                    cell.setCellStyle(my_style);
//                    cell.setCellValue(totalInscricoesUEBPagas);
//                    
//                    cell = row.createCell(cellnum+1);
//                    cell.setCellStyle(my_style);
//                    cell.setCellValue(totalInscricoesUEBPagasValor);
//
//                    
//                    
//                    
//                    
//                    row = sheet.createRow(rownum++);
//                    cell = row.createCell(cellnum);
//                    cell.setCellStyle(my_style);
//                    cell.setCellValue(totalInscricoesUEBNaoPagas);
//                    
//                    cell = row.createCell(cellnum+1);
//                    cell.setCellStyle(my_style);
//                    cell.setCellValue(totalInscricoesUEBNaoPagasValor);
//                    
//                    
//                    
//			        
//                    row = sheet.createRow(rownum++);
//                    cell = row.createCell(cellnum);
//                    cell.setCellStyle(my_style);
//                    cell.setCellValue(totalContribuicoesNaoPagas);
//                    
//                    cell = row.createCell(cellnum+1);
//                    cell.setCellStyle(my_style);
//                    cell.setCellValue(totalContribuicoesNaoPagasValor);
//                    
//                    
                    
                    
                    
                    
			        
                    FacesContext context = FacesContext.getCurrentInstance();             
                    HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();   
                      
                    try   
                    {    
                          
                        OutputStream out = response.getOutputStream();
                        
                        response.setContentType("application/octet-stream");   
                        response.setHeader("Content-disposition","attachment; filename=" + secaoSelecionada+"_"+dia+"_"+mes+"_"+ano+".xls");  
                        workbook.write(out);
                        
                        out.flush();  
                        out.close();  
                        
                        context.responseComplete();    
                    }   
                    catch (Exception e)   
                    {    
                    	FacesContext fctx = FacesContext.getCurrentInstance();
        				UIComponent impt = event.getComponent();
        				UICommandButton uiInput = ((UICommandButton) impt
        						.findComponent("secaorelatorioForm:btnGera"));

        				FacesMessage msg = new FacesMessage("ERRO GRAVE! ",
        						"Falha ao Incluir Dados Joven !" + e.getMessage());
        				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        				fctx.addMessage(uiInput.getClientId(fctx), msg);
        				return;
                        
                    } 

                    // SALVA LOCAL
//			        try
//			        {
//			            FileOutputStream out = new FileOutputStream(new File(diretorio+"\\"+secaoSelecionada+"_"+dia+"_"+mes+"_"+ano+".xls"));
//			            workbook.write(out);
//			            out.close();
//			            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
//			        }
//			        catch (Exception e)
//			        {
//			            e.printStackTrace();
//			        }
				
							

			} catch (Exception c) {
				FacesContext fctx = FacesContext.getCurrentInstance();
				UIComponent impt = event.getComponent();
				UICommandButton uiInput = ((UICommandButton) impt
						.findComponent("secaorelatorioForm:btnGera"));

				FacesMessage msg = new FacesMessage("ERRO GRAVE! ",
						"Falha ao Incluir Dados Joven !" + c.getMessage());
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				fctx.addMessage(uiInput.getClientId(fctx), msg);
				return;
			}

		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public void selecaoListener(AjaxBehaviorEvent event) throws IOException, Exception {
		    UIExtendedDataTable dataTable = (UIExtendedDataTable) event.getComponent();
		    //Object originalKey = dataTable.getRowKey();
		    
//		    for (Object chave : selecao) {
//		    	dataTable.setRowKey(chave);        	
//		    	if (dataTable.isRowAvailable()) {
//		    		
//		    		// jovemselecionadoNaTabela = (DadosJovem) dataTable.getRowData();
//		    		break;
//		    		
//		    	}
//		    }
		 }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		public List<Secoes> getSecoesList() {
			return secoesList;
		}


		public void setSecoesList(List<Secoes> secoesList) {
			this.secoesList = secoesList;
		}


		public DadosJovem getDadosJovem() {
			return dadosJovem;
		}


		public void setDadosJovem(DadosJovem dadosJovem) {
			this.dadosJovem = dadosJovem;
		}


		public Collection<Object> getSelecao() {
			return selecao;
		}


		public void setSelecao(Collection<Object> selecao) {
			this.selecao = selecao;
		}


		public List<SecaoDevedor> getSecaoDevedorList() {
			return secaoDevedorList;
		}


		public void setSecaoDevedorList(List<SecaoDevedor> secaoDevedorList) {
			this.secaoDevedorList = secaoDevedorList;
		}


		public List<DetalhePago> getDetalhePagoList() {
			return detalhePagoList;
		}


		public void setDetalhePagoList(List<DetalhePago> detalhePagoList) {
			this.detalhePagoList = detalhePagoList;
		}


		public String getAno() {
			return ano;
		}


		public void setAno(String ano) {
			this.ano = ano;
		}


		public String getTotalInscricoesUEBPagas() {
			return totalInscricoesUEBPagas;
		}


		public void setTotalInscricoesUEBPagas(String totalInscricoesUEBPagas) {
			this.totalInscricoesUEBPagas = totalInscricoesUEBPagas;
		}


		public String getTotalContribuicoesPagas() {
			return totalContribuicoesPagas;
		}


		public void setTotalContribuicoesPagas(String totalContribuicoesPagas) {
			this.totalContribuicoesPagas = totalContribuicoesPagas;
		}


		public List<Variaveis> getVariaveisList() {
			return variaveisList;
		}


		public void setVariaveisList(List<Variaveis> variaveisList) {
			this.variaveisList = variaveisList;
		}


		public String getTotalDeJovens() {
			return totalDeJovens;
		}


		public void setTotalDeJovens(String totalDeJovens) {
			this.totalDeJovens = totalDeJovens;
		}


		public String getTotalInscricoesUEBNaoPagas() {
			return totalInscricoesUEBNaoPagas;
		}


		public void setTotalInscricoesUEBNaoPagas(String totalInscricoesUEBNaoPagas) {
			this.totalInscricoesUEBNaoPagas = totalInscricoesUEBNaoPagas;
		}


		public String getTotalContribuicoesNaoPagas() {
			return totalContribuicoesNaoPagas;
		}


		public void setTotalContribuicoesNaoPagas(String totalContribuicoesNaoPagas) {
			this.totalContribuicoesNaoPagas = totalContribuicoesNaoPagas;
		}


		public String getTotalDeJovensValor() {
			return totalDeJovensValor;
		}


		public void setTotalDeJovensValor(String totalDeJovensValor) {
			this.totalDeJovensValor = totalDeJovensValor;
		}


		public String getTotalInscricoesUEBPagasValor() {
			return totalInscricoesUEBPagasValor;
		}


		public void setTotalInscricoesUEBPagasValor(String totalInscricoesUEBPagasValor) {
			this.totalInscricoesUEBPagasValor = totalInscricoesUEBPagasValor;
		}


		public String getTotalContribuicoesPagasValor() {
			return totalContribuicoesPagasValor;
		}


		public void setTotalContribuicoesPagasValor(String totalContribuicoesPagasValor) {
			this.totalContribuicoesPagasValor = totalContribuicoesPagasValor;
		}


		public String getTotalInscricoesUEBNaoPagasValor() {
			return totalInscricoesUEBNaoPagasValor;
		}


		public void setTotalInscricoesUEBNaoPagasValor(
				String totalInscricoesUEBNaoPagasValor) {
			this.totalInscricoesUEBNaoPagasValor = totalInscricoesUEBNaoPagasValor;
		}


		public String getTotalContribuicoesNaoPagasValor() {
			return totalContribuicoesNaoPagasValor;
		}


		public void setTotalContribuicoesNaoPagasValor(
				String totalContribuicoesNaoPagasValor) {
			this.totalContribuicoesNaoPagasValor = totalContribuicoesNaoPagasValor;
		}
		

		

		
	}
