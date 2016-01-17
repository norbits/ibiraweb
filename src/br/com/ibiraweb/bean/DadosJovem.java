package br.com.ibiraweb.bean;


public class DadosJovem implements Comparable<DadosJovem>{
	


private String iddadosjovem			= "";
private String idsecao		= "";
private String secao		= "";
private String ativo		= "";
private String nroFamilia		= "";
private String nomeJoven		= "";
private String nroRegistro		= "";
private String rgJovem		= "";
private String cpfJovem		= "";
private String dtNascJovem		= "";
private String cidadeNascJovem		= "";
private String ufNascJovem		= "";
private String religiaoJovem		= "";
private String idsexo		= "";
private String sexo		= "";
private String precelJovem		= "";
private String telCelularJovem		= "";
private String preresJovem		= "";
private String telResidencialJovem		= "";
private String emailJovem		= "";

private String secaoSelected		= "";
private String sexoSelected		= "";

private String nomedaMae		= "";
private String telComercialMae		= "";
private String profissaoMae		= "";
private String emailMae		= "";
private String cidadeNascimentoMae		= "";
private String rgMae		= "";
private String cpfMAE		= "";
private String telCelMae		= "";


private String nomePai		= "";
private String telComercialPai		= "";
private String profissaoPai		= "";
private String emailPai		= "";
private String cidadeNasPai		= "";
private String rgPai		= "";
private String cpfPAI		= "";
private String telCelPai		= "";
private String enderecoJovem		= "";
private String bairro		= "";
private String cidade		= "";
private String estado		= "";
private String cep		= "";
private String dataInicio		= "";
private String dataDesligamento		= "";
private String motDesligamento		= "";
private String numeroResidencia		= "";
private String complementoEndereco		= "";
private String	isento;
private boolean	isentoDisplay;

private boolean	inativar;


public String getIddadosjovem() {
	return iddadosjovem;
}
public void setIddadosjovem(String iddadosjovem) {
	this.iddadosjovem = iddadosjovem;
}
public String getIdsecao() {
	return idsecao;
}
public void setIdsecao(String idsecao) {
	this.idsecao = idsecao;
}
public String getAtivo() {
	return ativo;
}
public void setAtivo(String ativo) {
	this.ativo = ativo;
}
public String getNroFamilia() {
	return nroFamilia;
}
public void setNroFamilia(String nroFamilia) {
	this.nroFamilia = nroFamilia;
}
public String getNomeJoven() {
	return nomeJoven;
}
public void setNomeJoven(String nomeJoven) {
	this.nomeJoven = nomeJoven;
}
public String getNroRegistro() {
	return nroRegistro;
}
public void setNroRegistro(String nroRegistro) {
	this.nroRegistro = nroRegistro;
}
public String getRgJovem() {
	return rgJovem;
}
public void setRgJovem(String rgJovem) {
	this.rgJovem = rgJovem;
}
public String getCpfJovem() {
	return cpfJovem;
}
public void setCpfJovem(String cpfJovem) {
	this.cpfJovem = cpfJovem;
}
public String getDtNascJovem() {
	return dtNascJovem;
}
public void setDtNascJovem(String dtNascJovem) {
	this.dtNascJovem = dtNascJovem;
}
public String getCidadeNascJovem() {
	return cidadeNascJovem;
}
public void setCidadeNascJovem(String cidadeNascJovem) {
	this.cidadeNascJovem = cidadeNascJovem;
}
public String getUfNascJovem() {
	return ufNascJovem;
}
public void setUfNascJovem(String ufNascJovem) {
	this.ufNascJovem = ufNascJovem;
}
public String getReligiaoJovem() {
	return religiaoJovem;
}
public void setReligiaoJovem(String religiaoJovem) {
	this.religiaoJovem = religiaoJovem;
}
public String getIdsexo() {
	return idsexo;
}
public void setIdsexo(String idsexo) {
	this.idsexo = idsexo;
}
public String getPrecelJovem() {
	return precelJovem;
}
public void setPrecelJovem(String precelJovem) {
	this.precelJovem = precelJovem;
}
public String getTelCelularJovem() {
	return telCelularJovem;
}
public void setTelCelularJovem(String telCelularJovem) {
	this.telCelularJovem = telCelularJovem;
}
public String getPreresJovem() {
	return preresJovem;
}
public void setPreresJovem(String preresJovem) {
	this.preresJovem = preresJovem;
}
public String getTelResidencialJovem() {
	return telResidencialJovem;
}
public void setTelResidencialJovem(String telResidencialJovem) {
	this.telResidencialJovem = telResidencialJovem;
}
public String getEmailJovem() {
	return emailJovem;
}
public void setEmailJovem(String emailJovem) {
	this.emailJovem = emailJovem;
}
public String getNomedaMae() {
	return nomedaMae;
}
public void setNomedaMae(String nomedaMae) {
	this.nomedaMae = nomedaMae;
}
public String getTelComercialMae() {
	return telComercialMae;
}
public void setTelComercialMae(String telComercialMae) {
	this.telComercialMae = telComercialMae;
}
public String getProfissaoMae() {
	return profissaoMae;
}
public void setProfissaoMae(String profissaoMae) {
	this.profissaoMae = profissaoMae;
}
public String getCidadeNascimentoMae() {
	return cidadeNascimentoMae;
}
public void setCidadeNascimentoMae(String cidadeNascimentoMae) {
	this.cidadeNascimentoMae = cidadeNascimentoMae;
}
public String getRgMae() {
	return rgMae;
}
public void setRgMae(String rgMae) {
	this.rgMae = rgMae;
}
public String getCpfMAE() {
	return cpfMAE;
}
public void setCpfMAE(String cpfMAE) {
	this.cpfMAE = cpfMAE;
}
public String getTelCelMae() {
	return telCelMae;
}
public void setTelCelMae(String telCelMae) {
	this.telCelMae = telCelMae;
}
public String getNomePai() {
	return nomePai;
}
public void setNomePai(String nomePai) {
	this.nomePai = nomePai;
}
public String getTelComercialPai() {
	return telComercialPai;
}
public void setTelComercialPai(String telComercialPai) {
	this.telComercialPai = telComercialPai;
}
public String getProfissaoPai() {
	return profissaoPai;
}
public void setProfissaoPai(String profissaoPai) {
	this.profissaoPai = profissaoPai;
}
public String getEmailPai() {
	return emailPai;
}
public void setEmailPai(String emailPai) {
	this.emailPai = emailPai;
}
public String getCidadeNasPai() {
	return cidadeNasPai;
}
public void setCidadeNasPai(String cidadeNasPai) {
	this.cidadeNasPai = cidadeNasPai;
}
public String getRgPai() {
	return rgPai;
}
public void setRgPai(String rgPai) {
	this.rgPai = rgPai;
}
public String getCpfPAI() {
	return cpfPAI;
}
public void setCpfPAI(String cpfPAI) {
	this.cpfPAI = cpfPAI;
}
public String getTelCelPai() {
	return telCelPai;
}
public void setTelCelPai(String telCelPai) {
	this.telCelPai = telCelPai;
}
public String getEnderecoJovem() {
	return enderecoJovem;
}
public void setEnderecoJovem(String enderecoJovem) {
	this.enderecoJovem = enderecoJovem;
}
public String getBairro() {
	return bairro;
}
public void setBairro(String bairro) {
	this.bairro = bairro;
}
public String getCidade() {
	return cidade;
}
public void setCidade(String cidade) {
	this.cidade = cidade;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public String getCep() {
	return cep;
}
public void setCep(String cep) {
	this.cep = cep;
}
public String getDataInicio() {
	return dataInicio;
}
public void setDataInicio(String dataInicio) {
	this.dataInicio = dataInicio;
}
public String getDataDesligamento() {
	return dataDesligamento;
}
public void setDataDesligamento(String dataDesligamento) {
	this.dataDesligamento = dataDesligamento;
}
public String getMotDesligamento() {
	return motDesligamento;
}
public void setMotDesligamento(String motDesligamento) {
	this.motDesligamento = motDesligamento;
}
public String getSecaoSelected() {
	return secaoSelected;
}
public void setSecaoSelected(String secaoSelected) {
	this.secaoSelected = secaoSelected;
}
public String getSexoSelected() {
	return sexoSelected;
}
public void setSexoSelected(String sexoSelected) {
	this.sexoSelected = sexoSelected;
}
public String getEmailMae() {
	return emailMae;
}
public void setEmailMae(String emailMae) {
	this.emailMae = emailMae;
}

public String getNumeroResidencia() {
	return numeroResidencia;
}
public void setNumeroResidencia(String numeroResidencia) {
	this.numeroResidencia = numeroResidencia;
}
public String getComplementoEndereco() {
	return complementoEndereco;
}
public void setComplementoEndereco(String complementoEndereco) {
	this.complementoEndereco = complementoEndereco;
}

public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
public String getSecao() {
	return secao;
}
public void setSecao(String secao) {
	this.secao = secao;
}

public boolean isIsentoDisplay() {
	
	if(isento != null && isento.equals("1")){
		return true;
	}else{
		return false;
	}
}


public boolean isInativar() {
	return inativar;
}
public void setInativar(boolean inativar) {
	this.inativar = inativar;
}
public void setIsentoDisplay(boolean isentoDisplay) {
	
	if(isentoDisplay){
		isento = "1";
	}else {
		isento = "0";
	}
	
	this.isentoDisplay = isentoDisplay;
}
public String getIsento() {
	
	if(isentoDisplay){
		isento = "1";
	}else {
		isento = "0";
	}
	
	return isento;
}
public void setIsento(String isento) {
	this.isento = isento;
}
@Override
public int compareTo(DadosJovem outraConta) {
	
	int x = new Integer(outraConta.nroFamilia).intValue();
	int y = new Integer(this.nroFamilia).intValue();
	
    if (x< y) {
        return -1;
    }
    if (x > y) {
        return 1;
    }
    return 0;
}





	

	}