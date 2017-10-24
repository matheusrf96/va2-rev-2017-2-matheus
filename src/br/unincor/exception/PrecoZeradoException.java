package br.unincor.exception;

import br.unincor.model.Midia;

public class PrecoZeradoException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private Midia m;
	
	public PrecoZeradoException(Midia m) {
		super();
		this.m = m;
	}
	
	@Override
	public String getMessage() {
		return "O preço final da mídia '" + this.m.getNomeArquivo() + "' está zerado!";
	}
}
