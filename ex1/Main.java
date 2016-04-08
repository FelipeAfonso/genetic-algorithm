package ex1;

public class Main {

	public static void main(String[] args) {
		// Candidato a resolu��o
		CalcSaude.setSolution("0100101001001010010010100100101001001010010010100100101001001010");
							 
		// Criar popula��o inicial
		Populacao popInicial = new Populacao(50, true);
		
		// Evouluir a popula��o at� achar um resultado agrad�vel
		int contagem = 0;
		while (popInicial.getMaisSaudavel().getSaude() < CalcSaude.getSaudeIdeal()) {
			contagem++;
			System.out.println("Gera��o: " + contagem + " Mais Saud�vel: " + popInicial.getMaisSaudavel().getSaude());
			popInicial = Algoritmo.evoluirPopulacao(popInicial);
		}
		System.out.println("Gera��o ideal encontrada");
		System.out.println("Gera��o: " + contagem);
		System.out.println("Genes:");
		System.out.println(popInicial.getMaisSaudavel());

	}

}
