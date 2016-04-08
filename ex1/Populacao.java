package ex1;

public class Populacao {
	
	Individuo[] individuos;
	
	// Construtores
	//Criar População
	public Populacao(int tamPop, boolean iniciar){
		individuos = new Individuo[tamPop];
		//Iniciar População
		if(iniciar){
			for(int x=0; x<tamanho();x++){
				Individuo newIndividuo = new Individuo();
				newIndividuo.criarIndividuo();
				salvarIndividuo(x, newIndividuo);
			}
		}
	}
	
	// Getters
	public Individuo getIndividuo(int index){
		return individuos[index];
	}
	
	public Individuo getMaisSaudavel(){
		Individuo maisSaudavel = individuos[0];
		//Busca Simples
		for (int x=0; x<tamanho(); x++){
			if (maisSaudavel.getSaude() <= getIndividuo(x).getSaude()){
				maisSaudavel = getIndividuo(x);
			}
		}
		return maisSaudavel;
	}
	
	// Métodos Públicos
	//Tamanho da População
	public int tamanho(){
		return individuos.length;
	}
	
	//Salvar Individuo
	public void salvarIndividuo(int index, Individuo i){
		individuos[index] = i;
	}
}
