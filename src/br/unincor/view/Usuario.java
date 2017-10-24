package br.unincor.view;

import javax.swing.JOptionPane;

public class Usuario {
	
	public void exibeMsg(String texto) {
		JOptionPane.showMessageDialog(null, texto, "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
	}

	public void exibeMsgErro(String texto) {
		JOptionPane.showMessageDialog(null, texto, "ERRO", JOptionPane.ERROR_MESSAGE);
	}

	public int menuPrincipal(){
		Object[] opcoes = { "Música", "Vídeo", "Finalizar Pedido" };
		
		int escolha = JOptionPane.showOptionDialog(null, 
		    "Selecione uma opção",
		    "Menu", 
		    JOptionPane.YES_NO_OPTION, 
		    JOptionPane.QUESTION_MESSAGE, 
		    null, 
		    opcoes, 
		    opcoes[0]);

		return escolha;
	}
	
	public int menuPagamento(){
		Object[] opcoes = { "Boleto", "Cartão" };
		
		int escolha = JOptionPane.showOptionDialog(null, 
		    "Selecione uma opção de pagamento",
		    "Pagamento", 
		    JOptionPane.YES_NO_OPTION, 
		    JOptionPane.QUESTION_MESSAGE, 
		    null, 
		    opcoes, 
		    opcoes[0]);

		return escolha;
	}
	
	public Long recebeLong(String texto) {
		int f = 0;
		
		while(f == 0){
			try {
				String resposta = JOptionPane.showInputDialog(texto);
				Long respostaConvertida = Long.parseLong(resposta);
				f = 1;
				
				return respostaConvertida;
			} catch (Exception e) {
				exibeMsg("Entrada inválida!");
				f = 0;
			}
		}
		return null;
	}

	public Double recebeDouble(String texto) {
		int f = 0;
		
		while(f == 0){
			try {
				String resposta = JOptionPane.showInputDialog(texto);
				Double respostaConvertida = Double.parseDouble(resposta);
				f = 1;
				
				return respostaConvertida;
			} catch (Exception e) {
				exibeMsg("Entrada inválida!");
				f = 0;
			}
		}
		return null;
	}

	public String recebeTexto(String texto) {
		return JOptionPane.showInputDialog(texto);
	}
}
