package ex1;

public class CalcSaude {
	
	static byte[] solution = new byte[64];
	
	// Métodos Publicos
	public static void setSolution(byte[] newSolution){
		solution = newSolution;
	}
	
	//Facilitando minha vida
	static void setSolution(String newSolution){
		char[] tempSolution = new char[newSolution.length()];
		for(int x=0; x<newSolution.length();x++){
			tempSolution[x] = newSolution.charAt(x);
			if (tempSolution[x] == '0'){
				solution[x] = 0;
			} else if (tempSolution[x] == '1'){
				solution[x] = 1;
			}else{
				solution[x] = 0;
			}
		}
		
	}
	
	//Calcular a saude dos individuos comparando com a resolução do candidato
	static int getSaude(Individuo individuo){
		int saude = 0;
		// Busca Simples
		for(int x=0; x<individuo.tamanho() && x<solution.length; x++){
			if(individuo.getGene(x) == solution[x]){
				saude++;
			}
		} return saude;
	}
	
	static int getSaudeIdeal(){
		return solution.length;
	}
}
