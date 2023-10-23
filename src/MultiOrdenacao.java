import java.util.Arrays;

public class MultiOrdenacao {

	//MÉTODO DE ORDENAÇÃO BOLHA
	public static int [] ordenacaoPorBubbleSort(int vetor[]) {
	
		int comparacoes =0;// guarda a quantidade de comparações feitas
		int trocas=0; // guarda a quantidade de trocas realizadas
		int temp=0;
		boolean trocou = false;
		 
	for (int i=0; i<vetor.length-1 ; i++){
		for (int j=0; j<vetor.length-i-1; j++){
			comparacoes++;
			if (vetor[j] > vetor[j+1]){
				trocas++;
				temp = vetor[j];
				vetor[j]=vetor[j+1];
				vetor[j+1]=temp;
				trocou = true;
				 } 
			}
		if (!trocou) break;// Se nenhuma troca foi feita na passagem completa, a lista já está ordenada e é retornada
		}
		return new int []{comparacoes, trocas} ;
	}

	
	//MÉTODO DE ORDENAÇÃO POR SELEÇÃO
	public static int[] ordenacaoPorSelecao(int vetor[]){
	int comparacoes =0;
	int trocas=0;
	int auxiliar;
	int posicaoMenor; 
		for (int i=0; i<vetor.length-1; i++) {
		posicaoMenor = i;
		for (int j=i+1; j<=vetor.length-1; j++) {
			comparacoes ++;
			if (vetor[j] < vetor[posicaoMenor]) {
				posicaoMenor = j;
				trocas ++;
			// troca o menor elemento (que esta na posicao menor) com o elemento da posicao i
				auxiliar = vetor[i];
				vetor[i] = vetor[posicaoMenor];
				vetor[posicaoMenor] = auxiliar;
				}
			} 
		} 
		return new int []{comparacoes, trocas} ;
	}
	
	
	//MÉTODO DE ORDENAÇÃO POR INSERÇÃO
	public static int[] ordenacaoPorInsercao(int vetor[]) {
	
	int comparacoes=0;
	int trocas=0;
	int temp=0;
		for (int i=1; i <  vetor.length; i++){
			
			temp = vetor[i];
			int j;
			for (j=i-1; j >=0 && temp < vetor[j]; j--) {
			comparacoes ++;
			vetor[j+1] = vetor[j];
			}
			vetor[j+1]=temp; // a atualização da variável tem que ser feita neste escopo(fora do loop interno)
			trocas++;

		}
		return new int []{comparacoes, trocas};
	}	
	

	public static void impressao(int VetorOriginal[]) {
		int temp[];
		// clonar o vetor durante as tres impressoes garqante que ele entre desordenado em cada método

		temp= VetorOriginal.clone();
		int [] retornoBolha = ordenacaoPorBubbleSort(temp);
		System.out.println("O vetor ordenado pelo método bolha é: "+ Arrays.toString(temp) );
		System.out.println("O número de comparações do método bolha é: " + retornoBolha[0]);		
		System.out.println("O número de trocas do método bolha é: " + retornoBolha[1]);		


		
		temp= VetorOriginal.clone();
		int []retornoSelecao=ordenacaoPorSelecao(temp); 
		System.out.println("\nO vetor ordenado pelo método Seleção é: "+ Arrays.toString(temp) );
		System.out.println("O número de comparações do método de Seleção é: " + retornoSelecao[0]);		
		System.out.println("O número de trocas do método de Seleção é: " + retornoSelecao[1]);		

		temp= VetorOriginal.clone();
		int[] retornoInsercao=ordenacaoPorInsercao(temp);
		System.out.println("\nO vetor ordenado pelo método de incerção é: " +Arrays.toString(temp) );
		System.out.println("O número de comparações do método de inserção é: " + retornoInsercao[0]);		
		System.out.println("O número de trocas do método de inserção é: " + retornoInsercao[1] +"\n");		
}
	
	public static void main(String[] args) {
		
		int [] vetorInicial1= {3,2,1,4,5,6,7,8,9,10}; String quaseOrdenado ="vetor quase ordenado";
		int [] vetorInicial2= {3,9,1,6,5,4,7,2,9,10}; String parcialmenteOrdenado= "vetor parcialmenteOrdenado";
		int [] vetorInicial3= {10,9,8,7,6,5,4,3,2,1,0}; String desordenado = "vetor totalmente desodernado(inverso)";
		
		System.out.println("=======================================================================\n"
		+ quaseOrdenado +Arrays.toString(vetorInicial1) +"\n");
		impressao(vetorInicial1);
		
		System.out.println("=======================================================================\n"
		+parcialmenteOrdenado +Arrays.toString(vetorInicial2) +"\n");
		impressao(vetorInicial2);

		System.out.println("=======================================================================\n"
		+desordenado +Arrays.toString(vetorInicial3) +"\n");
		impressao(vetorInicial3);
		

	}
}
