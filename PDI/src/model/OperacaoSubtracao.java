package model;

public class OperacaoSubtracao {
	
	public static int[][] subtrairImagem(int[][] imgUm, int[][] imgDois){
		int alt = imgUm.length;
		int lar = imgUm[0].length;
		int imgSaida[][] = new int[alt][lar];
		
		for(int a = 0; a<alt; a++) {
			for(int l = 0; l<lar; l++) {
				imgSaida[a][l] = imgUm[a][l] - imgDois[a][l];
			}
		}
		
		return imgSaida;
	}
}
