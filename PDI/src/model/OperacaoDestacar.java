package model;

public class OperacaoDestacar {
	
	public static int[][] destacarIntervalo(int [][] img, int limiteInferior, int limiteSuperior, int nivelCinza){
		int alt = img.length;
		int lar = img[0].length;
		int imgSaida[][] = new int[alt][lar];
		
		for(int a = 0; a<alt; a++) {
			for(int l = 0; l<lar; l++) {
				if(img[a][l] < limiteInferior || img[a][l] > limiteSuperior) {
					imgSaida[a][l] = 0;
				} else {
					imgSaida[a][l] = nivelCinza;
				}
			}
		}
		
		return imgSaida;
	}
	
	public static int[][] destacarIntervaloDois(int [][] img, int limiteInferior, int limiteSuperior, int nivelCinza){
		int alt = img.length;
		int lar = img[0].length;
		int imgSaida[][] = new int[alt][lar];
		
		for(int a = 0; a<alt; a++) {
			for(int l = 0; l<lar; l++) {
				if(img[a][l] >= limiteInferior && img[a][l] <= limiteSuperior) {
					imgSaida[a][l] = nivelCinza;
				} else {
					imgSaida[a][l] = img[a][l];
				}
			}
		}
		
		return imgSaida;
	}
}
