package br.unincor.control;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Midia;
import br.unincor.model.Musica;
import br.unincor.model.Video;
import br.unincor.view.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario gui = new Usuario();
		CalculaPrecos cp = new CalculaPrecos();
		List<Midia> listaMidias = new ArrayList<Midia>();
		
		int j = 0;
		
		while(true) {
			int opcao = gui.menuPrincipal();
			
			if(opcao == -1 || opcao == 2) {
				break;
			}
			else if(opcao == 0) {
				Musica m = new Musica(
						"Arquivo " + j,
						1.99,
						"Artista " + j,
						true
					);
				
				listaMidias.add(m);
			}
			else if(opcao == 1) {
				Video v = new Video(
						"Arquivo " + j,
						3.99,
						"Autor " + j,
						true
					);
				
				listaMidias.add(v);
			}
			
			j++;
			
		}
		
		double totalPedido = 0d;
		String resumoPedido = "RESUMO DO PEDIDO:\n____________________\n";
		
		int pagto = gui.menuPagamento();
		
		for(int i = 0; i < listaMidias.size(); i++) {
			try {
				cp.calculaPrecoFinal(listaMidias.get(i));
			}
			catch (PrecoZeradoException pze) {
				gui.exibeMsgErro(pze.getMessage());
			}
			
			if(pagto == -1 || pagto == 0)
				listaMidias.get(i).setPrecoFinal(cp.pagtoBoleto(listaMidias.get(i).getPrecoFinal()));
			else if(pagto == 1)
				listaMidias.get(i).setPrecoFinal(cp.pagtoCartao(listaMidias.get(i).getPrecoFinal()));
			
			totalPedido += listaMidias.get(i).getPrecoFinal();
			resumoPedido += listaMidias.get(i).verDados() + "\n\n";
		}
		
		DecimalFormat f = new DecimalFormat("R$ 0.00");
		
		resumoPedido += "____________________\n" + "Valor total do pedido: " + f.format(totalPedido);
		gui.exibeMsg(resumoPedido);
		
	}

}
