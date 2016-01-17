<LINK rel="stylesheet" type="text/css" href="/pira/portal/menu/TB.css">

<HTML>


	<HEAD>
		<META http-equiv="Expires" content="0">
		<META content="text/html; charset=windows-1252" http-equiv=Content-Type>
		<SCRIPT language="JavaScript">
			window.status = 'Aguarde';
			<!--
				function MM_openBrWindow(theURL,winName,features) { 
					window.open(theURL,winName,features);
				}
			//-->
			function animaPto(){
    
    				var sPto = " "
				for (var i = 1; i <= nCtPto; i++)
					sPto = sPto + ". ";
				texto= "Carregando perfil "+sPto;

				document.all.div3Pto.innerHTML = texto;
				 nCtPto == 3 ? nCtPto = 1 : nCtPto = nCtPto + 1;
    				 setTimeout("animaPto()", 500);
			}
			var nCtPto = 1;
			setTimeout("animaPto()", 500);
		</SCRIPT>
		
		<TITLE>O PEQUENO APRENDIZ</TITLE>
		
	</HEAD>

	<BODY class="fnd2" ONLOAD="javascript:document.location='/<%=request.getContextPath().toLowerCase().substring(1)%>/servlet/instanciaAplicacao?parRotina=<%=request.getContextPath().toLowerCase().substring(1)%>';" >


	</BODY>
	<FONT FACE="Verdana"><B><DIV id=div3Pto>Carregando perfil . . .</DIV></B></FONT>
</HTML>
