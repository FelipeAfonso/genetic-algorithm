package ex1;

public class Main {

	public static void main(String[] args) {
		// Candidato a resolução
		CalcSaude.setSolution("0100101001001010010010100100101001001010010010100100101001001010");
							 
		// Criar população inicial
		Populacao popInicial = new Populacao(50, true);
		
		// Evouluir a população até achar um resultado agradável
		int contagem = 0;
		while (popInicial.getMaisSaudavel().getSaude() < CalcSaude.getSaudeIdeal()) {
			contagem++;
			System.out.println("Geração: " + contagem + " Mais Saudável: " + popInicial.getMaisSaudavel().getSaude());
			popInicial = Algoritmo.evoluirPopulacao(popInicial);
		}
		System.out.println("Geração ideal encontrada");
		System.out.println("Geração: " + contagem);
		System.out.println("Genes:");
		System.out.println(popInicial.getMaisSaudavel());

	}

}
