package br.com.ibiraweb.util.report;

import java.io.Serializable;
import java.util.Date;

public class ItensPerfilAlunoExcel {



	private String m_cpd;
	
	private String m_nomeAluno;
	
	private String m_formaPgto;
	
	
	
	private Integer m_parcelas;
	
	private Integer m_qtdParcelasReceb;
	
	
	private Double m_valor;
	
	private Double m_valorrecebido;
	
	private Date m_dataRecebimento;
	

	
	
	
	   public ItensPerfilAlunoExcel() {}
	   
	 
	
	public String getCpd() {
		return m_cpd;
	}

	public void setCpd(String cpd) {
		this.m_cpd = cpd;
	}

	public String getNomeAluno() {
		return m_nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.m_nomeAluno = nomeAluno;
	}

	public String getFormaPgto() {
		return m_formaPgto;
	}

	public void setFormaPgto(String formaPgto) {
		this.m_formaPgto = formaPgto;
	}

	public Double getValor() {
		return m_valor;
	}

	public void setValor(Double valor) {
		this.m_valor = valor;
	}

	public Integer getParcelas() {
		return m_parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.m_parcelas = parcelas;
	}

	public Integer getQtdParcelasReceb() {
		return m_qtdParcelasReceb;
	}

	public void setQtdParcelasReceb(Integer qtdParcelasReceb) {
		this.m_qtdParcelasReceb = qtdParcelasReceb;
	}

	public Double getValorrecebido() {
		return m_valorrecebido;
	}

	public void setValorrecebido(Double valorrecebido) {
		this.m_valorrecebido = valorrecebido;
	}



	public Date getDataRecebimento() {
		return m_dataRecebimento;
	}



	public void setDataRecebimento(Date dataRecebimento) {
		this.m_dataRecebimento = dataRecebimento;
	}



	

	
	
	
	
}
