package ex1;

public class Individuo {
	
	static int tamanhoGeneticoPadrao = 64;
	private byte[] genes = new byte[tamanhoGeneticoPadrao];
	
	//Cache
	private int saude = 0;
	
	//Criar individuo aleatorio
	public void criarIndividuo(){
		for(int x=0; x<tamanho(); x++) {
			byte gene = (byte) Math.round(Math.random());
			genes[x] = gene;
		}
	}
	
	// Getters e Setters
	
	//Metodo para criar individuos com tamanhos geneticos diferentes
	public static void setTamanhoGeneticoPadrao(int tam) {
		tamanhoGeneticoPadrao = tam;
	}
	
	public byte getGene (int index){
		return genes[index];
	}
	
	public void setGene(int index, byte valor){
		genes[index] = valor;
		saude = 0;
	}
	
	// Métodos públicos
	
	public int tamanho(){
		return genes.length;
	}
	
	public int getSaude(){
		if (saude == 0){
			saude = CalcSaude.getSaude(this);
		} return saude;
	}
	
	@Override
	public String toString(){
		String geneString = "";
		for(int x=0; x<tamanho(); x++){
			geneString += getGene(x);
		}
		return geneString;
	}
	
}
