package model;

public class OperacaoMelhoramentoContraste {
	
	public static int[][] gama(int[][] img, int c, double gama){ // s=c*r^y
		int alt = img.length;
		int lar = img[0].length;
		int imgSaida[][] = new int[alt][lar];
		
		for(int a = 0; a<alt; a++) {
			for(int l = 0; l<lar; l++) {
				double aux = img[a][l] / 255.0;
				aux = c * Math.pow(aux, gama);
				imgSaida[a][l] = (int) (aux * 255);
			}
		}
		
		return imgSaida;
	}
}
