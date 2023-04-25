package model;

public class OperacaoEspelhamento {
	
	public static int[][] espelhamentoColuna(int img[][]){

		int alt = img.length;
		int lar = img[0].length;
		int imgSaida[][] = new int[alt][lar];
		
		for(int a = 0; a<alt; a++) {
			for(int l = 0; l<lar; l++) {
				imgSaida[a][lar - l - 1] = img[a][l];
			}
		}
		
		return imgSaida;
	}
	
	public static int[][] espelhamentoLinha(int img[][]){
		int alt = img.length;
		int lar = img[0].length;
		int imgSaida[][] = new int[alt][lar];
		
		for(int a = 0; a<alt/2; a++) {
			for(int l = 0; l<lar; l++) {
				imgSaida[alt - (a + 1)][l] = img[a][l];
				imgSaida[a][l] = img[alt -(a+1)][l];
			}
		}
		
		return imgSaida;
	}
}
