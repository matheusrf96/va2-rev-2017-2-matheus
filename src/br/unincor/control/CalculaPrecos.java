package br.unincor.control;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Midia;
import br.unincor.model.Musica;
import br.unincor.model.Video;

public class CalculaPrecos {

	public void calculaPrecoFinal(Midia m) throws PrecoZeradoException {
		if(m.getPrecoFinal() != null && m.getPrecoFinal() == 0d) {
			if(m instanceof Musica){
				Musica mus = (Musica)m;
				
				if(mus.getDominioPublico() == true) {
					mus.setPrecoFinal(mus.getPrecoBase() - (mus.getPrecoBase() * 0.3));
				}
				else {
					mus.setPrecoFinal(mus.getPrecoBase() * 1.1);
				}
			}
			else if(m instanceof Video){	
				Video vid = (Video)m;
				
				if(vid.getMidiaDigital() == true) {
					vid.setPrecoFinal(vid.getPrecoBase() - (vid.getPrecoBase() * 0.1));
				}
				else {
					vid.setPrecoFinal(vid.getPrecoBase() * 1.2);
				}
			}
		}
		else {
			throw new PrecoZeradoException(m);
		}
	}
	
	public Double pagtoBoleto(Double totalPedido) {
		return totalPedido * 0.9;
	}
	
	public Double pagtoCartao(Double totalPedido) {
		return totalPedido * 1.15;
	}
}
