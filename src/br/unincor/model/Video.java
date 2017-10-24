package br.unincor.model;

public class Video extends Midia{
	private String autor;
	private Boolean midiaDigital;
	
	public Video(String nomeArquivo, Double precoBase, String autor, Boolean midiaDigital) {
		super(nomeArquivo, precoBase);
		this.autor = autor;
		this.midiaDigital = midiaDigital;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Boolean getMidiaDigital() {
		return midiaDigital;
	}

	public void setMidiaDigital(Boolean midiaDigital) {
		this.midiaDigital = midiaDigital;
	}
	
	@Override
	public String verDados() {
		return super.verDados() +
				"\nAutor: " + this.autor +
				"\nMídia digital: " + this.midiaDigital;
	}
	
}
