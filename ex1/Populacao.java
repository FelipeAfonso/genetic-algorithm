package ex1;

public class Populacao {
	
	Individuo[] individuos;
	
	// Construtores
	//Criar Popula��o
	public Populacao(int tamPop, boolean iniciar){
		individuos = new Individuo[tamPop];
		//Iniciar Popula��o
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
	
	// M�todos P�blicos
	//Tamanho da Popula��o
	public int tamanho(){
		return individuos.length;
	}
	
	//Salvar Individuo
	public void salvarIndividuo(int index, Individuo i){
		individuos[index] = i;
	}
}
