package ex1;

public class Algoritmo {
	
	// Parametros do AG
	private static final double uniformRate = 0.5;
	private static final double mutationRate = 0.015;
	private static final int tournamentSize = 5;
	private static final boolean elitism = true;
	
	// Métodos Publicos
	
	//Evoluir a população
	public static Populacao evoluirPopulacao(Populacao pop){
		Populacao newPopulacao = new Populacao(pop.tamanho(), false);
		
		//Manter o melhor individuo --> Elitismo
		if (elitism){
			newPopulacao.salvarIndividuo(0, pop.getMaisSaudavel());
		}
		
		//Crossover
		int elitismOffset;
		if (elitism){
			elitismOffset = 1;
		} else {
			elitismOffset = 0;
		}
		
		//Busca em cima da população e criar novos individuos com o Crossover
		for(int x = elitismOffset; x< pop.tamanho(); x++){
			Individuo indiv1 = tournamentSelection(pop);
			Individuo indiv2 = tournamentSelection(pop);
			Individuo newIndiv = crossover(indiv1, indiv2);
			newPopulacao.salvarIndividuo(x, newIndiv);
		}
		
		//Mutar população
		for(int x= elitismOffset; x<newPopulacao.tamanho(); x++){
			mutate(newPopulacao.getIndividuo(x));
		}
		
		return newPopulacao;
	}
	
	//Crossover dos individuos
	public static Individuo crossover(Individuo indiv1, Individuo indiv2){
		Individuo filho = new Individuo();
		//Buscar entre os genes
		for(int x=0; x < indiv1.tamanho(); x++){
			//Crossover
			if(Math.random() <= uniformRate){
				filho.setGene(x, indiv1.getGene(x));
			} else {
				filho.setGene(x, indiv2.getGene(x));
			}
		}
		return filho;
	}
	
	//Mutar um individuo
	public static void mutate(Individuo indiv){
		//Busca entre os genes
		for(int x=0; x<indiv.tamanho(); x++){
			if(Math.random() <= mutationRate){
				//Criar gene aleatório
				byte gene = (byte) Math.round(Math.random());
				indiv.setGene(x, gene);
			}
		}
	}
	
	//Selecionar individuos para o Crossover
	public static Individuo tournamentSelection (Populacao pop){
		// Criar população para o torneio
		Populacao torneio = new Populacao(tournamentSize, false);
		//Pegar individuo aleatorio para cada espaço no torneio
		for(int x = 0; x < tournamentSize; x++){
			int random = (int) (Math.random() * pop.tamanho());
			torneio.salvarIndividuo(x, pop.getIndividuo(random));
		}
		//Selecionar o mais saudavel
		Individuo maisSaudavel = torneio.getMaisSaudavel();
		return maisSaudavel;
	}
	
	
}
