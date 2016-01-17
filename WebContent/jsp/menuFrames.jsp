
<%@ page import="org.apache.shiro.SecurityUtils, org.apache.shiro.subject.Subject" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE> </TITLE>
		<META content="text/html; charset=ISO-8859-1" http-equiv=Content-Type>
		<META http-equiv="Content-Style-Type" content="text/css">
		<LINK href="/ibiraweb/portal/componentes/estilosApp.css" type="text/css" rel="stylesheet">
		
		<SCRIPT language="javascript" >
			var scriptPath="/ibiraweb/portal/menu/";
		</SCRIPT>
		
		<SCRIPT language="javascript" src="/ibiraweb/portal/menu/fst5-path.js"> 
		</SCRIPT>
		
		<SCRIPT language="javascript" src="/ibiraweb/portal/menu/menuG5LoaderFSX.js" >
		</SCRIPT>
		
		<SCRIPT language="javascript" src="/ibiraweb/portal/menu/menuG5LoaderFSX.js" >
		</SCRIPT>
		
		<SCRIPT language="javascript" >
		  // <![CDATA[ 
				

				if(yx_menuSafe){
   					 	var yx_es=scriptPath+(yx_isGecko?"menuG5GeckoFSX.js":yx_isOpera7?"menuG5OperaFSX.js":yx_isSafari?"menuG5SafariFSX.js":"menuG5IEFSX.js");
    					document.write("<script language='javascript' src='"+yx_es+"' gg='text/javascript'><\/script>");
    	
    					if(typeof(contentScript)!="undefined"){
    						
        					document.write("<script language='javascript' src='"+preparaMenu()+"' gg='text/javascript'><\/script>")
            			};
            
    					if(typeof(styleScript)!="undefined"){
        					document.write("<script language='javascript' src='"+styleScript+"' gg='text/javascript'><\/script>")
            			};
            
    					if(typeof(instanceScript)!="undefined"){
        					document.write("<script language='javascript' src='"+instanceScript+"' gg='text/javascript'><\/script>")
            			};
				}else if(typeof(nonMenuPage)!="undefined"){
    						setTimeout("window.location.replace('"+nonMenuPage+"')",0)
        		};
        			
        		function preparaMenu(){
        							
        							var varroles = '<%=(String)SecurityUtils.getSubject().getSession().getAttribute("userRoles")%>';
        							
        							var obj =   varroles.split(";");
        							var i = 100;
        							
        							    
        							
        							addMenu("Vtro", "vtro-top");
/*     ****************************************************************************************************************/
        							addSubMenu("vtro-top", "CADASTROS", "", "", "Perform-sub", "s1");
        							if(varroles=="master" 
										|| varroles=="admin"){
		        								addLink("Perform-sub", "Jovens Novos", "", "/ibiraweb/faces/telas/cadastros/jovens/manutencaoEscoteiros.xhtml", "");
		        								addLink("Perform-sub", "Jovens Inativos", "", "/ibiraweb/faces/telas/cadastros/jovens/manutencaoEscoteirosInativos.xhtml", "");
		        								addLink("Perform-sub", "Alerar Dados Jovens", "", "/ibiraweb/faces/telas/manutencao/Jovens/alterarDadosJovens.xhtml", "");
		        								addLink("Perform-sub", "Parametros Sistema", "", "/ibiraweb/faces/telas/cadastros/variaveis/variaveis.xhtml", "");
        							}
    								
/*     ****************************************************************************************************************/
    								addSubMenu("vtro-top", "FINANCEIRO", "", "", "horasAtivd-sub", "s1");
    								
									if(varroles=="master" 
											|| varroles=="admin"){
												addLink("horasAtivd-sub", "Registro Pagamento"      , "", "/ibiraweb/faces/telas/manutencao/Jovens/fianceiraJovens.xhtml", "");
    								}

    								
/*     ****************************************************************************************************************/    								
	        							addSubMenu("vtro-top", " RELATÓRIO ", "", "", "tool-sub_relat", "s1");
	        							
	        							if(varroles=="master"  
        									|| varroles=="admin" ){''
	        								
	        								addLink("tool-sub_relat", "Por Seção"      , "", "/ibiraweb/faces/telas/relatorio/jovens/relatorioJovens.xhtml", "");
	        								
        								}
	        							
	        						
	        							
/*     ****************************************************************************************************************/
        							    addSubMenu("vtro-top", "  ", "", "", "transi-sub", "s1");
        								//addSubMenu("transi-sub", " - ", "", "", "", "");
        								
        								addSubMenu("vtro-top", "  ", "", "", "transi-sub2", "s1");
          								//addSubMenu("transi-sub2", " - ", "", "", "", "");
          								
	          							addSubMenu("vtro-top", "  ", "", "", "transi-sub3", "s1");
	      								//addSubMenu("transi-sub3", " - ", "", "", "", "");
	
	      							  	addSubMenu("vtro-top", "  ", "", "", "transi-sub4", "s1");
	  									//addSubMenu("transi-sub4", " - ", "", "", "", "");
	      								
	  							  		addSubMenu("vtro-top", "  ", "", "", "transi-sub5", "s1");
										//addSubMenu("transi-sub5", " - ", "", "", "", "");
									
									  	addSubMenu("vtro-top", "  ", "", "", "transi-sub6", "s1");
	  									//addSubMenu("transi-sub6", " - ", "", "", "", "");
	      								
	  									addSubMenu("vtro-top", "  ", "", "", "transi-sub7", "s1");
	  									//addSubMenu("transi-sub7", " - ", "", "", "", "");
	  									
        								endMenu();
        				}

        		

 // ]]> 
 
		</SCRIPT>		

		
	</HEAD>
	
	
	
	
	

		<FRAMESET ROWS="73,20,*,42" BORDER="0">
			<FRAME  src="../portal/cabec/cabec.jsp"	marginwidth="0" marginheight="0" framespacing="0" frameborder="no" scrolling="no" noresize="true" name="cabecalhoFrame"/>
			<FRAME class="obj"  src="/<%=request.getContextPath().toLowerCase().substring(1)%>/servlet/instanciaAplicacao?parAcao=listarMenu&parRotina=<%=request.getContextPath().toLowerCase().substring(1)%>&role=${param.role}""	marginwidth="0" marginheight="0" framespacing="0" frameborder="no" scrolling="no"   noresize="true" name="menuFrame">
			</FRAME>
			<FRAME src="/<%=request.getContextPath().toLowerCase().substring(1)%>/faces/portal/inicial/inicial.xhtml" marginwidth="0" marginheight="0" framespacing="0" frameborder="no" scrolling="no" noresize="true" name="main">
			
			
			
			</FRAME>
			<FRAME src="/<%=request.getContextPath().toLowerCase().substring(1)%>/faces/portal/rodape/rodape.xhtml"	marginwidth="0" marginheight="0" framespacing="0" frameborder="no" scrolling="no"   noresize="true" name="rodapeFrame"/>
		</FRAMESET>
	

	
	 
</HTML>
