package br.com.ibiraweb.mock;

public class Mock {

	
	
	public String [][] getSecoes(){
		String[][] retorno =   {{"id", "secao", "ativo"}, 
								{"1"," Seoni", "0"}, 
								{"2", "Wainganga", "0"}, 
								{"3", "Aratupis", "0"}, 
								{"4", "Caramuru", "0"}, 
								{"5", "Xingu", "0"},
								{"6", "Xavante", "0"}, 
								{"7", "Rairu", "0"}};
		return retorno;
	}
	
	
	public String [][] getAtivo(){
		String[][] retorno =   {{"id", "descricao"}, {"1","Ativo"}, {"2", "Afastado"}};
		return retorno;
	}
	
	
	public String [][] getSexo(){
		String[][] retorno =   {{"id", "descricao"}, {"1","Masculino"}, {"2", "Feminino"}, {"3", "Outros"}};
		return retorno;
	}
	
	public String [][] getDadosJovem(){
		String[][] retorno =   {{		"iddadosjovem",
										"idsecao",
										"ativo",
										"nroFamilia",
										"nomeJoven",
										"nroRegistro",
										"rgJovem",
										"cpfJovem",
										"dtNascJovem",
										"cidadeNascJovem",
										"ufNascJovem",
										"religiaoJovem",
										"idsexo",
										"precelJovem",
										"telCelularJovem",
										"preresJovem",
										"telResidencialJovem",
										"emailJovem",
										"nomedaMae",
										"telComercialMae",
										"profissaoMae",
										"eMailMae",
										"cidadeNascimentoMae",
										"rgMae",
										"cpfMAE",
										"telCelMae",
										"nomePai",
										"telComercialPai",
										"profissaoPai",
										"emailPai",
										"cidadeNasPai",
										"rgPai",
										"cpfPAI",
										"telCelPai",
										"enderecoJovem",
										"bairro",
										"cidade",
										"estado",
										"cep",
										"dataInicio",
										"dataDesligamento",
										"motDesligamento",
}, 

		
{"1","1","1","11","Wagner José Oliveira","466774-3","","","","","","Não informado","1","","","11","55662284","","Almerinda A   Oliveira","","","","","","","","","","","","","","","","Rua Gemea Dantas, 101","Jordanópolis","São Paulo","SP","04830-300","2005-02-26","2010-02-20","Desinteresse"},
{"2","1","1","25","Jader Caio Ricarte Alvilo","infor 21","50.907.990-8","","2004-02-15","São Paulo","SP","Não informado","1","","","11","28552488","","Patrícia Auxiliadora Ricarte de Almeida","","Professor (a)","patricia.aux.iliadora@hotmail.com","São Paulo","28.537.739-5","252.388.798-30","","","","","","","","","","Rua Hermógenes Lima, 154","Jardim Mte Azul","São Paulo","SP","5836230","2008-03-01","2012-06-23","Desinteresse"},
{"3","1","1","32","Nicolas Paz Correia de Medeiros","526581-9","","","","","","Não informado","1","","","","","","","","","","","","","","Celso Luiz Correia de Medeiros","","","","","","","","R.Vicente Pereira de Assunção, 55 ap Bl 1","Vila Constância","São Paulo","SP","04658-000","2007-02-24","2009-03-28","Desinteresse"},
{"4","1","1","34","Lorena Regina Canelhas","599215-0","","","2003-10-27","São Paulo","SP","Católica","2","11","82563112","11","43236001","lorenacanelhas@ig.com.br","Adriana Regina","5667-6001","Dentista","aregi@ig.com.br","São Paulo","11.557.362-8","086.603.948-10","8256-3112","Ricardo Ruela","5669-3128","Advogado","ricardoruela@ig.com.br","São Paulo","","","8379-0511","R.Santo Alberto, 56","Vila São Pedro","São Paulo","SP","04676-040","2008-05-30","2011-02-12","Desinteresse"},
{"5","1","0","44","Laura Caixeta Reimberg","594193-8","","","2003-12-06","São Paulo","SP","Católica","2","","","11","55243525","","Andrea Elisa Caixeta Reimberg","","Professor (a)","andreaecr@terra.com.br","São Paulo","","184.739.568-69","7669-3436","Rodolfo Reimberg","3478-8889","Engenheiro","rodolfo.reimberg@br.atlascopco.com","São Paulo","26.123.388-9","250.224.618-03","8690-3810","Rua Honorato Correia, 05","Jardim Edith","São Paulo","SP","4813260","2008-08-30","2012-06-23","Desinteresse"},
{"6","1","0","44","Clara Caixeta Reimberg","630694-2","","","2004-12-20","São Paulo","SP","Não informado","2","","","11","55243525","","Andrea Elisa Caixeta Reimberg","","Professor (a)","andreaecr@terra.com.br","","25.641.222-4","","7669-3436","Rodolfo Reimberg","3478-8889","Gerente Comercial","rodolfo.reimberg@gmail.com","","26.123.388-9","","8690-3810","Rua Interlúdio, 18","Vila Isa","São Paulo","SP","4689115","2009-05-29","2010-03-13","Mudança de Bairro"},
{"7","1","1","52","Gabriel Sevílio","466765-4","21.321.730","112.206.398.93","2001-05-13","","","Católica","1","11","73132637","11","58518440","sevilio.eliete@globo.com","Eliete Antonio Pires Sevílio","5180-4200","Analista de RH","sevilio.eliete@globo.com","","21.321.730","","7313-2637","Osmar Sevilio","","Autônomo","","","15.318.847","","9718-3471","","","","SP","","2009-03-21","2010-03-13","Mudança de Bairro"},
{"8","1","1","56","Nathália  Scola Leitao","492999-3","39.751.892-4","","2000-06-18","","","Não informado","2","11","34949578","11","56314267","","Fabiana Scola","3494-9578","atendente","","","26.129.295-X","","7221-7939","Robson Leitão","3494-9578","Autônomo","","","","","9741-6734","Rua Canal do Panamá, 160","Vila S Catarina","São Paulo","SP","4375070","2009-08-29","2010-02-20","Desinteresse"},
{"9","1","1","71","João Pedro Coutinho Souza de Oliva","609715-4","","","2002-05-07","São Paulo","SP","Católica","1","11","89171235","11","55622504","","Regiane Coutinho Souza de Oliva","5686-1461","Funcionário (a) Público","","","25756749-5","273287578-33","9463-6968","Marco Antonio Ferreira de Oliva","0800-7099999","Coordenador","","","24.254.269-4","144.005.548-30","8917-1235","Rua Glycério Almeida Maciel, 945","Jardim Itapura","São Paulo","SP","4433020","2010-04-17","2012-12-01","Desinteresse"},
{"10","1","1","75","Lucas Fregoneze Sebastiani","infor 09","","","2002-07-12","São Paulo","SP","Não informado","1","","","11","55238144","","Andrea Fregoneze Sebastiani","","Do lar","andrea_fregoneze@yahoo.com.br","","23.551.589-9","","9654-1650","Emir Carlos Sebastiani","3563-4312","Engenheiro","emir.deba@yahoo.com.br","","36.522.464-9","","9160-1865","Rua Colastine, 53","Jd Ubirajara (z Sul)","São Paulo","SP","4458025","2010-09-18","2012-06-23","Desinteresse"},
{"11","1","1","80","Ana Carolina Genga Freitas","infor 08","","","2003-09-18","São Paulo","SP","Católica","2","","","11","29658190","","Katia R. Genga","","Dentista","","","","","","Luiz Carlos Bernardo Freitas","","Administrador(a)","","","","","9619-2709","Rua Raul Marques Marinho, 84","Vila Inglesa","São Paulo","SP","4653150","2010-09-18","2015-03-28","Desinteresse"},
{"12","1","1","84","Kauan Molina Souza Silva","infor 07","","","2002-01-29","São Paulo","SP","Não informado","1","","","11","56313675","","Cleide Vicente Doria Molina (avó)","","Aposentado","confeccaocleide@terra.com.br","","","","7827-9017","Kleber Souza Silva","","","","","","","7408-0986","Rua Arlindo Veiga Dos Santos, 25 - bl.A - ap. 183","Parque Res Julia","São Paulo","SP","4671300","2010-09-25","2013-08-31","Outros Motivos"},
{"13","1","1","94","Paulo José Bonifácio Fonseca Novaes","358810-6","","","1998-11-07","","","Católica","1","","","11","59281049","","Margareth Lopes da Fonseca ","2134-5985","assist. Administrativo","","","20.309.541-8","","9566-6899","","","","","","","","","Rua Antônio de Pádua Prado, 29","Jardim Luanda","São Paulo","SP","4678070","2011-03-23","2012-06-23","Desinteresse"},
{"14","1","0","120","Patrick da Silva Araújo","574017-7","","","2000-07-06","","","Católica","1","","","11","55662912","","Priscila Aparecida da Silva","","","","","","","9854-5629","Severino Alves Araújo (avô)","","","","","","","","Rua José Zeferino Peixoto, 55","Jardim Luanda","São Paulo","SP","4678025","2011-03-12","2013-08-31","Outros Motivos"},
{"15","1","1","123","Carlos Eduardo Vasconcelos","630709-4","","","2004-07-27","São Paulo","SP","Católica","1","11","57908868","11","32940194","","Sandra Abadia Ferreira de Lima","","Do lar","","Minas Gerais","","","","Paulo Eduardo Patricio Vasconcellos","3315-4092","Analista de Sistemas","pepuasco@hotmail.com","São Paulo","9.040.579-1","034.880.328-7","","Rua Sargento Olício Alves, 361","Vila Cpo Grande","São Paulo","SP","4455180","2011-03-26","2013-09-01","Excesso de Atividades"},
{"16","1","0","127","Letícia Tiemi Okasaki","630698-5","","","2005-01-19","São Paulo","SP","Não informado","2","","","11","50312614","","Cristina M. O. Okasaki","5105-5005","Gerente Comercial","cristina_okasaki@yahoo.com.br","São Paulo","47.689.532-2","","9686-8126","Ricardo  Teruyuki Okasaki","5851-9696","Engenheiro","ricardo.okasaki@terra.com.br","São Paulo","9.267.225-5","","9982-5328","Av.Pascoal da Rocha Falcão, 352","Jd S Helena","São Paulo","SP","4785000","2011-04-02","2013-05-01","Excesso de Faltas"},
{"17","1","1","131","Gustavo Ferreira  Oliveira","497582-0","39.634.318-1","04813-260","2001-03-14","","","Católica","1","11","92019032","11","56622752","","Rosana Maria Ferreira Oliveira","3796-0065","Recepcionista","sana-1964@hotmail.com","","16.710.880-3","","9201-9032","Anastácio Lomba Oliveira","4055-1810","Ferramenteiro","","","3.312.350","","9119-7740","Rua Lourenço Antônio Bragança, 106","Vila Joaniza","São Paulo","SP","4403160","2011-04-09","2013-10-30","Excesso de Atividades"},
{"18","1","0","179","Leticia Lira Bomfim","743072-8","56.056.925-7","","2005-10-22","São Paulo","SP","Católica","2","","","11","55647301","","Alessandra Borba Lira Bonfim","5521-2674","Pedagoga","alelirabonfim@hotmail.com","São Paulo","20.190.118-3","101.584.898-29","7298-6128","Jackstone Machado Bonfim","5631-6722","Comerciante","reconprint@terra.com.br","","16.625.729-1","","8381-1956","Rua José Zeferino Peixoto,55","Jardim Luanda","São Paulo","SP","4678025","2011-09-03","2015-03-28","Desinteresse"},
{"19","1","1","185","Henrique Rennê Claro","524979-1","39929798-4","","2001-07-27","","","Não informado","1","11","84153384","","","","Catherine Coelho da Rocha","","Psicólogo(a)","catherine_rocha@hotmail.com","","22.665.608-1","","8415-3384","Carlos Eduardo de Andrade","5180-4200","Administrador de Empresas","","","","","9532-7433","Av. Mascote, 1381-ap.31","Vila Mascote","São Paulo","SP","4363001","2011-08-06","",""},
{"20","1","1","186","Luiz Henrique Alves S. Porfirio","533087-4","","","2002-04-01","","","Não informado","1","","","11","56786763","","Flávia Alves Silva Porfirio","3054-7240","securitaria","fla.porfirio@hotmail.com","","","","9402-9788","Gilberto Sturari Porfirio","5032-2875","Marcineiro","","","","","8923-7687","Av.Sargento Geraldo Santana 240 ap 22A","Jd Taquaral","São Paulo","SP","4674225","2011-08-13","2013-08-31","Desinteresse"},
{"21","1","1","205","Danilo de Aguiar Germano","574016-9","","","2000-11-20","","","Evangélica","1","","","11","56136870","","Elenice de Aguiar Germano","","Auxiliar Administrativo","","","21.239.007","","7885-7423","José Estanilau Germano","","Mecânico","","","","","8948-2609","Rua Juari, 589","Jd Sabará","São Paulo","SP","4446160","2011-11-26","",""},
{"22","1","1","208","Sara Vieira Gronda","575218-3","","","2003-09-14","","","Católica","2","","","11","56860713","","Ana Lúcia Toledo Vieira","5686-6651","","analtvieria@yahoo.com.br","","","","9910-3570","João Gronda Neto","5671-3008","Comerciante","gronda@tease.com.br","","9.372.022-1","","9376-3138","Rua Santo André, 45","Vila S Pedro","São Paulo","SP","4676070","2012-02-25","",""},
{"23","1","1","210","Alyni Marani Oliveira","554814-4","52.176.789-1","","2001-11-03","São Paulo","SP","Católica","2","11","86906258","11","56140014","kmarani@ig.com.br","Kátia M.M. de Oliveira Pereira","","Gerente Comercial","kmarani@ig.com.br","","28.686.001-6","184.690.598-23","8589-5363","Aurélio de Oliveira Pereira","","Vendedor (a)","pereiraaurelio@superig.com.br","","27.613.874-0","","8690-6258","Rua Duque Costa, 25-ap.204A","Vila Sofia","São Paulo","SP","4671160","2012-03-17","2015-04-01","Desinteresse"},
{"24","1","0","213","Raphael Itiro Fratin","653163-6","","","2005-05-29","São Paulo","SP","Não informado","1","","","11","56319268","","Telma Sayuri Oi","4305-1545","Reflexologista Neural","telma.sayuri@gmail.com","","23.189.531-8","","9833-2841","Ricardo Fratin","","Motorista","ricardofratin@hotmail.com","","28.037.384-3","","6679-4333","Rua Profa. Zoraide de Campos Helu, 2","Vila D Pedro I","São Paulo","SP","4267005","2012-03-10","2014-05-24","Excesso de Faltas"},
{"25","1","1","216","Bruna Ferreira Leite","598255-3","551816715","","2002-05-04","São Paulo","SP","Não informado","2","","","11","27298029","","Ariene Gomes Ferreira","","estoquista","prariri@gmail.com","São Paulo","29.733.159-0","258.216.938-29","8373-0532","Davi Gomes Leite","","","","","","","","Rua Zike Tuma, 116-ap.82A","Jd Ubirajara (z Sul)","São Paulo","SP","4458000","2012-03-10","",""},
{"26","1","1","229","Marãna Iasmim Novais Ventura","594187-3","","","2002-10-10","São Paulo","SP","Católica","2","11","93944782","11","25063144","marana.i.novais@gmail.com","Diva Mariana","","Analista de Atendimento","divanovais@gmail.com","","406.345.818","30.416.254.829","9394-4782","Renato Aurelio Ventura da Silva","","","","","","","","Rua Dr. Epaminondas Barra, 5","Vila Castelo","São Paulo","SP","4438100","2012-03-24","",""},
{"27","1","0","230","Guilherme Durán Vasconcelos","653160-1","","","2004-04-02","São Paulo","SP","Espírita","1","","","11","56119795","guilhermeduranvasconcelos@hotmail.com","Simone B. Durán Vasconcelos","","Professor (a)","sisma@terra.com.br","","16.540.324-X","","7833-3862","Julio Cesar Lopes Vasconcelos","","Comerciante","jclva@terra.com.br","","14.371.559-8","","7884-2902","Rua Alessandro Manzoni, 371","Vila Arriete","São Paulo","SP","4445050","2012-03-10","",""},
{"28","1","1","234","Gabriel Samir Jauhar","660551-6","","","2005-08-03","São Paulo","SP","Católica","1","","","11","20617312","","Andrea Scherhaufer Jauhar","","Artesã","","São Paulo","25.439.884-4","193.203.458/25","9918-3535","Juarez Michel Perez Jauhar","5185-1127","Veterinário","michelpj@terra.com.br","São Paulo","18.300.815","101.428.538/01","8256-8252","Avenida Nossa Senhora do Sabará, 3590","Vila Emir","São Paulo","SP","4447010","2012-04-14","",""},
{"29","1","0","235","Júlia Lira Brito Monteiro","660545-1","","","2003-04-15","Recife","PE","Católica","2","","","11","55242338","","Juliana Vanessa Lira da Costa","","Produtora","jjvanessa@hotmail.com","Recife","4.589.566 (PE)","864.953.214","8109-6212","Edecio Brito Monteiro","","Cinegrafista","deko@hotmail.com","Recife","","","8814-7071","Rua Dr. Lauro Parente, 576","Vila Castelo","São Paulo","SP","4438250","2012-08-04","",""},
{"30","1","0","241","Gustavo dos Santos Barbosa","660637-7","","","2004-09-08","São Paulo","SP","Evangélica","1","","","11","56141267","","Juçara dos Santos de Oliveira","","Do lar","jucaras@hotmail.com","São Paulo","26.251.971-9","226.014.768-26","9819-6143","Edson Barbosa dos Santos","","Professor (a)","edsonbsantos@ibest.com.br","São Paulo","","060.844.878-82","9945-2777","Rua Dr. Epaminondas Barra, 18 ap 21","Vila Castelo","São Paulo","SP","4438100","2012-08-25","",""},
{"31","1","0","242","Henrique Araújo de Sá","660563-0","52.619.521-6","","2004-08-08","São Paulo","SP","Católica","1","","","11","56148472","","Elaine Viana de Sá","5612-4075","Professor (a)","eliaraujosa@hotmail.com","Bagé","28.225.585-0","135.193.068-08","9267-5503","Fernando Viana de Sá","5682-2738","Economista","fusa@sabesp.com.br","São Paulo","14.195.755","065.571.418-99","9252-1537","Rua Agnaldo Saturnino Rocha","Jd República","São Paulo","SP","4812100","2012-09-15","2015-03-28","Desinteresse"},
{"32","1","0","248","Caio Barbosa Campi","674238-6","","","2004-11-28","","","Espírita","1","","","11","35829796","","Sueli Barbosa","3582-9796","Cabelereira","sueloreta@hotmail.com","Marília","18.448.580","072125788-78","7294-2484","Carlos Campi Oliveira","","Técnico Eletrônico","","","","","","Rua Alessandro Manzoni,369","Vila Arriete","São Paulo","SP","4445050","2012-09-22","",""},
{"33","1","0","250","Rebecca dos Santos Matos","690731-8","56.594.348-0","","2005-03-26","São Paulo","SP","Cristã","2","","","11","56123244","","Gilmara dos Santos Matos","","Representante Comercial","gilconfeccoes@yahoo.com.br","","21.519.329-5","129.368.018-42","99102-4603","","","","","","","","","Rua José da Fonseca Nadaes, 365","Jd Sabará","São Paulo","SP","4446125","2012-09-29","",""},
{"34","1","0","253","Sofia Martins Camacho","694043-9","","","2004-11-26","São Paulo","SP","Não informado","2","","","11","55663238","","Mariangela Martins da Paixão Camacho","3038-2130","Analista Financeiro","mariangelapaixao@gmail.com","São Paulo","21.760.039-6","165.441.638-05","8274-5909","Mauricio Freitas Camacho","","Consultor","mfreitascamacho@gmail.com","São Paulo","13.073.822-0","125.589.548-9","9479-4966","Rua Eng. Adelmar de Mello Franco, 54","B Paulista","São Paulo","SP","4623100","2013-03-23","2014-06-28","Excesso de Atividades"},
{"35","1","0","257","Kevin Freire Landim","696855-4","545821861","21413987893","2003-10-26","São Paulo","SP","Não informado","1","11","976303623","","","","Michelly Freire dos Santos","2126-2636","Ass.Adm","mikevin2610@hotmail.com","São Paulo","291889827","21413987893","97630-3623","Christian Thomas Landim","","Acessor Parlamentar","ctlandim@sl.sp.gov.br","São Paulo","348084420","34197267835","97809-4435","Rua Pierre de Beranger, 260 ap 54","Vila S Pedro","São Paulo","SP","4676051","2013-02-16","",""},
{"36","1","0","260","Camila Barbosa Nicolau Rolim","697535-6","50405563X","","2005-08-25","São Paulo","SP","Não informado","2","11","995466286","11","56128246","","Mauricélia Nicolau Rolim","","Teleoperadora","celia.36.camila@ig.com.br","Antenor Navarro","25463668X","15262746802","","Herculano Franscisco Filho","","Motorista","celia36_camila@ig.com.br","Barreiras","19545801","11702792870","","Rua Job Vaz do Amaral, 95 ap 34 Bl 2","Jardim Lallo","São Paulo","SP","4812240","2013-03-23","",""},
{"37","1","0","260","Henrique Francisco Barbosa Nicolau Rolim","867562-7","52.928.820-5","","2007-04-26","São Paulo","SP","Católica","1","","","11","56128246","","Mauricélia Nicolau Rolim","","Atendente de Telemarketing","celia36_camila@ig.com.br","Antenor Navarro","25.963.668-X","152.627.468-02","98528-4728","Herculano Francisco Filho","","Motorista","","Barreiras","19.545.801-1","117.027.928-70","98038-6240","Rua Selma Kurtz, 449","Jardim M Luiza","São Paulo","SP","4434010","2013-03-09","2015-04-07","Desinteresse"},
{"38","1","0","262","Lucas Gustavo Rodrigues Florêncio","699868-2","39.698.160-4","","2005-06-21","São Paulo","SP","Católica","1","","","11","56125938","","Ana Eliza Rodrigues Zan","","Consultora Fiscal II","anaelizarodrigues@yahoo.com.br","São Paulo","33.158.345-8","323.820.958-22","98572-5581","Wesley Florêncio (separados)","","","","","","","","Rua Pedro Nogueira de Pazes, 404","Jardim Itapura","São Paulo","SP","4433010","2013-04-13","2015-03-28","Desinteresse"},
{"39","1","0","265","Nicolas Reimberg Hengler Hessel","734967-0","50.920.496-X","","2003-06-09","São Paulo","SP","Católica","1","","","11","26199623","","Simone da Silva Reimberg Hessel","","Professor (a)","simonehessel@ig.com.br","São Paulo","22.519.228-7","166.195.378-63","97279-3893","Carlos Hengler Hessel","","Desenhista","hengler10@hotmail.com","São Paulo","12.319.546-9","011.337.508-50","97333-2082","Av. João Peixoto Viegas, 697","Jardim Consórcio","São Paulo","SP","4437000","2013-03-02","",""},
{"40","1","1","268","Sophia Helena de Azevedo Andreoli","734959-9","","","2004-08-12","São Paulo","SP","Católica","2","","","11","55436384","","Katharina F. Barbosa de Azevedo Andreoli","4529-2155","Psicólogo(a)","k.andreoli@hotmail.com","São Paulo","10.163.206-x","115.069.998-16","99741-7401","Sergio Ricardo Barnez Andreoli","2478-9080","Administrador(a)","sergioandreoli@hotmail.com","São Paulo","37.058.481-8","059.528.828-62","99990-0952","Estrada do Alvarenga, 882","Jd Pedreira","São Paulo","SP","4462000","2013-06-15","",""},
{"41","1","0","272","Pedro Henrique Oliveira Crivelli","734969-6","50.760.862-8","","2005-07-26","São Paulo","SP","Kardecista","1","","","11","26384065","","Catia Oliveira Crivelli","5506-6781","Professor (a)","catita23@ig.com.br","São Paulo","25.229.002-1","260.878.468-24","98191-2147","Cesar Crivelli","","","","","","","","Rua Domingos Luiz Bueno, 68","Jardim Ernestina","São Paulo","SP","4677070","2013-06-15","",""},
{"42","1","0","274","Pedro Melo Petraglia","734971-8","","","2005-09-27","São Paulo","SP","Não informado","1","11","951517829","11","56126627","","Angelita Maria de Melo","","Do lar","","São Paulo","44.162.335-9","345.394.978-12","95709-9964","Denis Abreu Petraglia Jr","5613-2950","","juninho@lbcap.com.br","São Paulo","28.557.301-9","359.182.128-41","94932-0981","Rua Prof. Djalma Bento, 219","Jardim Luanda","São Paulo","SP","4678020","","2015-03-28","Desinteresse"},
{"43","1","0","277","Isaque Marconi Gomes de Souza","741990-2","52.333.839-9","","2006-04-26","São Paulo","SP","Evangélica","1","","","11","56144100","","Patricia Gomes Souza","5615-6596","Auxiliar Administrativo","patricia.gomess@gmail.com","São Paulo","26.572.712-1","225.153.708-29","96676-6615","Marconi de Souza","97049-0286","Segurança","marconi.turismo@gmail.com","Recife","24.802.482-6","165.715.048-80","97049-0286","Rua Láurea, 68","Jardim Jua","São Paulo","SP","4688080","2013-08-10","2015-03-28","Desinteresse"},
{"44","1","1","280","Lana Tirelli Yoshima","infor 66","","","2003-11-07","São Paulo","SP","Batista","2","","","11","55235381","","Patricia Tirelli Yoshima","","Empresário(a)","patriciatirelli@gmail.com","São Paulo","22.174.917-2","176.196.958-77","97181-1804","Rodrigo Yoshima","","Empresário(a)","rodrigoy@gmail.com","Mauá","28.999.207-2","268.619.208-94","99747-0250","Avenida Interlagos, 1880 ap 133 C","Jardim Marajoara","São Paulo","SP","4660002","2013-09-14","2015-04-07","Desinteresse"},
{"45","1","1","280","Paola Tirelli Yoshima","infor 67","","","2005-09-03","São Paulo","SP","Batista","2","","","11","55235381","","Patricia Tirelli Yoshima","","Empresário(a)","patriciatirelli@gmail.com","São Paulo","22.174.917-2","176.196.958-77","97181-1804","Rodrigo Yoshima","","Empresário(a)","rodrigoy@gmail.com","Mauá","28.999.207-2","268.619.208-94","99747-0250","Avenida Nossa Senhora do Sabará, 960 - ap 211 B","Vila Isa","São Paulo","SP","4686001","2013-08-03","2015-03-28","Desinteresse"},
{"46","1","0","286","Murilo Oliveira Silva","774091-3","","","2003-06-18","","","Não informado","1","","","11","56321625","","","","","","","","","","Antonio Carlos Silva","","Inspetora de qualidade","","","","257.844.978-39","98753-7143","Rua Eng. Domício de L. Pacheco e Silva, 288 - ap 15 A","Vila Cpo Grande","São Paulo","SP","4455310","2013-08-03","2015-04-07","Desinteresse"},
{"47","1","0","287","Laura Sofia Alves Moreira","774089-1","","324525658-22","2005-04-21","","","Não informado","2","","","11","56142990","","Cléia Alves Moreira","2532-9716","","","","","325.525.658-22","7941-5625","","","","","","","","","Rua Alessandro Manzoni, 369","Vila Arriete","São Paulo","SP","4445050","2014-08-09","",""},
{"48","1","0","293","Rafaela Chamie Zoline","774103-0","","","2004-12-23","São Paulo","SP","Não informado","2","","","11","56321002","","Roseli Arruda Chamie Zoline","","Bancário","zoline@zoline.com.be","","23.632.069-5","166.988.378-73","9 9433-0398","Glauco Zoline","","Advogado","","","","064.466.878-42","","Rua Barão de Hermida, 14","Jd Sta Fé (z Sul)","São Paulo","SP","4890575","2014-09-06","",""},
{"49","1","0","299","Breno Ferreira e Silva","793064-0","","","2006-01-15","São Paulo","SP","Não informado","1","","","11","36289282","","Alessandra Paula Dias Ferreira","5687-6122","Design Gráfico","alessandra.ferreira@tencom.com.br","São Paulo","22.336.858-1","128.359.118-98","98399-4568","Almir Bento de Lima Silva","3878-5726","Gerente Comercial","almirls@hotmail.com","São Paulo","","","98399-0555","Rua Esparta, 42","Jardim Guarapiranga","São Paulo","SP","4785135","2014-09-13","",""},
{"50","1","0","300","Arthur Gomes Menozzi","793066-6","","","2003-12-04","São Paulo","SP","Não informado","1","","","11","56798218","","Ana Luiza Machado Gomes","3085-1223","Gerente de Projeto","analu_gomes@hotmail.com","São Paulo","43.992.942-1","314.956.048-96","96029-1100","","","","","","","","","Avenida Mascote, 830 apto. 23","Vila Mascote","São Paulo","SP","4363001","2013-11-09","2015-03-28","Desinteresse"},
{"51","1","0","301","Matheus Pinheiro","790877-6","56.124.964-7","451.000.828-79","2006-02-09","Catanduva","SP","Evangélica","1","","","11","25894840","","Gislaine Pereira P Pinheiro","2589-4840","Técnico em Enfermagem","gislaine.pinheiro@hotmail.com","Catanduva","26.894.592-5","254.639.248-48","99580-4490","Cieber Buzzo Pinheiro","5669-7000","Gerente Comercial","","Santo André","26.376.406-0","172.527.048-07","99599-9038","Rua Eugênio Portal, 65","Vila Cpo Grande","São Paulo","SP","4455280","2011-08-13","2012-06-23","Desinteresse"},
{"52","1","0","303","Augusto Quirino Oliveira Jacob","790874-1","","","2004-04-30","São Paulo","SP","Católica","1","","","11","36378527","","Eloisa M Oliveira Jacob","","Enfermeiro(a)","eloisamos@yahoo.com","São Paulo","","288.629.818-21","96684-9099","Quirino Clemente Jacob Filho","5634-0251","Músico","quirinojacob65@gmail.com","C Procopio","12.766.736-2","063.094.918-22","99430-8527","Rua Jaboticabal nº 255","Vila Bertioga","São Paulo","SP","3188000","2011-08-12","2012-12-01","Desinteresse"},
{"53","1","0","307","Murilo Lopes Frade","infor 05","","","2005-10-24","São Paulo","SP","Não informado","1","11","986100853","11","41191992","","Nilciane Lopes Frade","","Analista de Sistemas","n.frade@terra.com.br","São Paulo","234684711","14763561812","9914-62943","Marcelo Santos Frade","","Analista de Sistemas","marcelo.santos.frade@gmail.com","são Paulo","21470048","11671387830","9861-00853","Rua Arlindo Veiga Dos Santos nº50 ap. 151 H","Parque Res Julia","São Paulo","SP","4671300","2011-09-03","2012-06-23","Desinteresse"},
{"54","1","0","309","Julia Sousa Azevedo","infor 99","","","2006-03-13","São Paulo","SP","Católica","2","","","11","56317550","","Camila Sousa Nascimento","5634-0455","Auxiliar Administrativo","ramiska_mi@hotmail.com","São Paulo","34.669.590-2","361.131.398-08","","Paulo Henrique Azevedo","","Segurança","","São Paulo","","","7730-3208","Rua Dr. Lauro Parente, 425 - casa 04","Jardim Martini","São Paulo","SP","4438250","2011-03-19","2013-05-01","Outros Motivos"},
{"55","1","0","310","Agatha Sabino Xavier","660575-3","","","2005-02-15","São Paulo","SP","Católica","2","","","","","","Alenaid Maria Sabino Xavier","","Secretária","alenaid.sabino@hotmail.com","São Paulo","35.866.898-0","","9474-8054","Fernando Melo dos Santos","5070-7000","Contador","fernando.melo@allbrazil100.com.br","São Paulo","7.974.351","858.657.538-00","9176-3604","Avenida Sargento Geraldo Santana, 401 - casa 2","Jd Taquaral","São Paulo","SP","4674225","2013-04-06","2013-10-30","Excesso de Atividades"},
{"56","1","0","312","Laura Benevides Silva","infor 96","57.648.722-3","","2006-12-23","São Paulo","SP","Umbanda","2","","","11","56313214","","Natali Benevides da Silva","","Representante Comercial","natali.benevides@yahoo.com.br","São Paulo","42.173.551-X","333.571.198-03","98538-9312","Everton Benevides Silva","96354-0024","adestrador de cães","ton_fsilva@hotmail.com","São Paulo","33.537.066-4","336.556.798-40","96354-0024","Avenida Sargento Geraldo Santana, 401 - casa 2","Jd Taquaral","São Paulo","SP","4674225","2013-04-06","2013-10-30","Excesso de Atividades"},
{"57","1","0","322","Gustavo Ferreira Klein","infor 87","","","2008-04-20","São Paulo","SP","Espírita","1","","","11","27298029","","Veronica Augusto Klein","","","","","28.289.839-0","","","José Norberto Ferreira Junior","","","","","24.253.706","205.354.138-58","","Estrada do Mboi Mirim, 2298 - bl.15 - ap. 73","Jardim Flores","São Paulo","SP","4905022","2005-04-29","",""},
{"58","1","0","328","Matheus Teixeira Damasceno","870134-2","50.738.420-9","","2004-06-04","São Paulo","SP","Católica","1","","","11","59202930","","Francisca Maria Teixeira Damasceno","","Doméstica","franciscateixeira.damasceno@hotmail.com","Pimenteiro","28.537.511-9","250.506.318-40","95706-2987","Antonio da Silva Pereira Damasceno","","Técnico de Manutenção","","São Paulo","36.265.521-2","147.765.908-05","97013-2761","Rua Dublin, 174","Vila Lisboa","São Paulo","SP","4776130","2015-03-14","",""},
{"59","1","0","329","Camila Bailon Silva","870137-7","58.613.282-X","","2006-04-05","São Paulo","SP","Espírita","2","","","11","64670373","","Yara Vieira Bailon","","Professor (a)","yara@claudioroberto.fot.br","São Paulo","26.284.350-X","153.250.388-18","99153-2191","Claudio Roberto da Silva","2822-7967","Fotógrafo","claudio@claudioroberto.fot.br","São Paulo","22.967.713-7","151.912.038-95","99436-1034","Avenida Eng. José Salles, 200","Socorro","São Paulo","SP","4776100","2015-03-14","",""},
{"60","1","0","330","Nicolly Keyth Guilger Ichiba","infor 86","52.586.790-9","","2008-04-11","São Paulo","SP","Não informado","2","","","11","55272415","","Lydia Ichiba da Silva","","","","São Paulo","25.814.421","292.373.348-77","97418-5570","","","","","","","","","Rua Itabapoama, 201","Vila Isa","São Paulo","SP","4689050","2015-03-04","",""},
{"61","1","0","331","Murilo Ichiba da Silva","infor 85","54.692.776-2","","2005-12-15","São Paulo","SP","Católica","1","","","11","59797469","","Michelle da Silva","","Professor (a)","mipey_mu@hotmail.com","São Paulo","24.991.654-X","284.486.218-75","99534-4323","Pedro Renato Claudino da Silva","","Montador(a)","pedro.tequila@hotmail.com","São Paulo","29.842.271","254.842.368-94","99708-3053","Rua João Terrero, 35","Jardim Guarapiranga","São Paulo","SP","4770000","2015-02-07","",""},
{"62","1","0","335","Pietro da Costa e Silva","infor 81","55.454.238-9","440.904.658-69","2008-02-28","São Paulo","SP","Católica","1","","","11","56125379","","Elaine Cristina da Costa e Silva","","Pedagoga","haraell@ig.com.br","São Paulo","27.249.571-2","266.624.628-02","93000-1422","Marcos Roberto da Costa e Silva","","Técnico de Enfermagem","marcos.robertocsilva@gmail.com","São Paulo","20.123.463-4","183.567.148-93","98242-0072","Avenida Nossa Senhora do Sabará, 4350 bl.4 ap.81","Vila Emir","São Paulo","SP","4447011","2014-10-11","",""},
{"63","1","0","339","Vinícius Hokamura Graunke","infor 77","54.963.801-5","","2008-03-14","São Paulo","SP","Católica","1","","","11","964453550","","Simone Hokamura","","Comerciante","shokamura@msn.com","São Paulo","19.736.918-2","128.084.298-94","98356-2088","Jones Graunke","","Acunputurista","jograunke@hotmail.com","São Paulo","3.597.547-0","502.652.029-49","","Rua Miguel Yunes, 485 - ap.41 - T2","U Piratininga","São Paulo","SP","4444000","2014-09-27","",""},
{"64","1","0","341","Matheus Scheffer","infor 75","50.884.488-5","","2006-08-04","São Paulo","SP","Evangélica","1","","","","","","Lucimeire Alves dos Santos","","Berçarista","camilalcm@hotmail.com","São Paulo","34.094.550-3","223.111.408-92","98502-6511","","","","","","","","","Rua Miguel Yunes, 485 - ap.41 - T2","U Piratininga","São Paulo","SP","4444000","2014-09-27","2015-03-28","Desinteresse"},
{"65","1","0","342","Isaac de Carvalho Dias","infor 72","58.780.612-6","456.382.388-08","2006-05-26","São Paulo","SP","Protestante","1","","","11","56676852","","Ana Cláudia de Carvalho","3327-2054","Advogado","anaclaudia.decarvalho@gmail.com","São Paulo","21.411.314-0","253.065.418-28","94778-4820","Marcelo Carlos Dias","","","","São Paulo","19.840.530-3","173.166.568-75","99582-0040","Rua Sargento Olício Alves, 361","Vila Cpo Grande","São Paulo","SP","4455180","2014-09-27","",""},
{"66","1","0","343","Clarissa Santos Silva","infor 71","55.492.218-6","","2005-02-09","São Paulo","SP","Católica","2","","","11","26910647","","Creusa Candida dos Santos Silva","","","","","","","","João Alves da Silva Neto","3095-3618","Bancário","joaoasn1@hotmail.com","São Paulo","18.988.660-2","094.624.348-40","","Rua Comend. Antunes Dos Santos, 494","C Redondo","São Paulo","SP","5861260","2014-03-08","",""},
{"67","1","0","345","Ana Júlia Macário Chagas","infor 68","22.664.357-8","","2005-04-29","São Paulo","SP","Católica","2","","","11","58332218","","","","","","","","","","Francisco Varneiro das Chagas","","Autônomo","","Carius","33.429.624-9","074.562.768-46","","Rua Pedro Osvaldo Venturini, 102","Vila Santana","São Paulo","SP","4679020","2014-03-08","",""}

		
		
		
		
		};
		return retorno;
	}
	
	public String [][] getDadosPai(){
		String[][] retorno =   {{			"idPai",
											"nomePai",
											"telComercialPai",
											"profissaoPai",
											"escolaridadePai",
											"rgPai",
											"emailPai",
											"cpfPai",
											"telCelularPai",
											"cidadeNascimentPai"}, 
		 		{"1","1","1","1","999" ,"999" ,"999" ,"99" ,"99","Sao Paulo" },
				{"2","0","0","0","9999","9999","9999","999","999","Sao Paulo"},
				{"3","1","1","1","999" ,"999" ,"999" ,"99" ,"99","Sao Paulo" }};
		return retorno;
	}
	
	
	public String [][] getDadosMae(){
		String[][] retorno =   {{			"idMae",
											"nomeMae",
											"telComercialMae",
											"profissaoMae",
											"escolaridadeMae",
											"rgMae",
											"emailMae",
											"cpfMae",
											"telCelularMae",
											"cidadeNascimentMae"}, 
		 		{"1","1","1","1","999" ,"999" ,"999" ,"99" ,"99","Sao Paulo" },
				{"2","0","0","0","9999","9999","9999","999","999","Sao Paulo"},
				{"3","1","1","1","999" ,"999" ,"999" ,"99" ,"99","Sao Paulo" }};
		return retorno;
	}
	
	public String [][] getDadosNroFamilia(){
		String[][] retorno =   {{"idNroFamilia", "numeroFamilia", "nomeJovem"}, 
								{"10"," 0001", "Jorge da Silva e Solvano"}, 
								{"20", "0001", "Adamastor de Barros"}, 
								{"30", "0003", "Lobinho da Silva"}, 
								{"40", "0023", "Escoteiro Fernmandes dos Santos de Alburquerque"}, 
								{"50", "0043", "Senior dos Santos "},
								{"60", "0234", "Guia Aparecida"}, 
								{"70", "1234", "Lobinho Novo dos Santos"}};
		return retorno;
	}
	
	public String [][] getTipoPagamento(){
		String[][] retorno =   {{"idTipoPgto", "descricao"}, 
								{"1"," Cheque"}, 
								{"2", "Dinheiro"}, 
								{"3", "Debito"}, 
								{"4", "Credito"}, 
								};
		return retorno;
	}
	
	public String [][] getRazaoPagamento(){
		String[][] retorno =   {{"idRzPgto", "descricao"}, 
								{"1"," Contribuição Mensal"}, 
								{"2", "Registro UEB"}, 
								{"3", "Isento"}};
		return retorno;
	}
	
	public String [][] getDadosFinanceiro(){
		String[][] retorno =   {{"idFin", "dataPagamento", "valorPagamento", "competencia", "razaoPagamentoSelected", "tipoPagamentoSelected"}, 
								{"1"," 01/01/2015", "20,00", "07/15", "Contribuicao Mensal", "Cheque"}, 
								{"2"," 01/01/2015", "20,00", "07/15", "Contribuicao Mensal", "Cheque"}, 
								{"3"," 01/01/2015", "20,00", "07/15", "Contribuicao Mensal", "Cheque"}, 
								{"4"," 01/01/2015", "20,00", "07/15", "Contribuicao Mensal", "Cheque"}, 
								};
		return retorno;
	}
	
	public String [][] getDadosDevedorFinanceiro(){
		String[][] retorno =   {{"idDevFin", "datadevendo", "valorDevendo", "razaoDevendo"}, 
								{"1"," 01/2015", "20,00", "Contribuicao Mensal"}, 
								{"2"," 02/2015", "20,00", "Contribuicao Mensal"}, 
								{"3"," 03/2015", "20,00", "Contribuicao Mensal"}, 
								{"4"," 04/2015", "20,00", "Contribuicao Mensal"}, 
								};
		return retorno;
	}
	
	
}
