package model;

public class OperacaoReduzirNivelCinza {
	
	public static int[][] reduzNivelCinza(int[][] img, int nivelCinza, int novoNivel){
		int alt = img.length;
		int lar = img[0].length;
		int imgSaida[][] = new int[alt][lar];
		
		int intervalo = nivelCinza / novoNivel;
		
		for(int a = 0; a<alt; a++) {
			for(int l = 0; l<lar; l++) {
				int pixel = img[a][l];
				int novoPixel = Math.round(pixel / intervalo);
				imgSaida[a][l] = novoPixel;
			}
		}
		
		return imgSaida;
	}
}
