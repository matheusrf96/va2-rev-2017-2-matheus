package br.unincor.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Midia {
	private String nomeArquivo;
	private Double precoBase;
	private Double precoFinal;
	
	public Midia(String nomeArquivo, Double precoBase) {
		super();
		this.nomeArquivo = nomeArquivo;
		
		if(precoBase >= 0)
			this.precoBase = precoBase;
		
		this.precoFinal = 0d;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public Double getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(Double precoBase) {
		if(precoBase >= 0)
			this.precoBase = precoBase;
	}

	public Double getPrecoFinal() {
		return precoFinal;
	}

	public void setPrecoFinal(Double precoFinal) {
		if(precoFinal >= 0)
			this.precoFinal = precoFinal;
	}
	
	public String verDados() {
		NumberFormat f = new DecimalFormat("0.00");
		
		return "Nome do arquivo: " + this.nomeArquivo +
				"\nPreço Base: R$" + f.format(this.precoBase) +
				"\nPreço Final: R$" + f.format(this.precoFinal);
	}	
}
