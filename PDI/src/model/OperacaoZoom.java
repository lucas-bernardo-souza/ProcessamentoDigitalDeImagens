package model;

public class OperacaoZoom {
	
	public static int[][] replicacao(int[][] img){
		int alt = img.length;
		int lar = img[0].length;
		// a imagem de saida é duas vezes maior
		int imgSaida[][] = new int[alt*2][lar*2];
		
		int novaAlt = 0;
		int novaLar;
		
		for(int a = 0; a<alt; a++) {
			novaLar = 0;
			for(int l = 0; l<lar; l++) {
				imgSaida[novaAlt][novaLar] = img[a][l];
				imgSaida[novaAlt][novaLar+1] = img[a][l];
				imgSaida[novaAlt+1][novaLar] = img[a][l];
				imgSaida[novaAlt+1][novaLar+1] = img[a][l];
				novaLar += 2;
			}
			novaAlt += 2;
		}
		
		return imgSaida;
	}
	
	public static int[][] reducao(int[][] img){
		int alt = img.length/2;
		int lar = img[0].length/2;
		int imgSaida[][] = new int[alt][lar];
		int media = 0;
		
		int novaAlt = 0;
		int novaLar = 0;
		
		for(int a=0; a<alt; a++) {
			novaLar = 0;
			for(int l=0; l<lar; l++) {
				media = (img[novaAlt][novaLar] + img[novaAlt][novaLar+1] + img[novaAlt+1][novaLar] + img[novaAlt+1][novaLar+1])/4; 
				imgSaida[a][l] = media;
				novaLar += 2;
			}
			novaAlt += 2;
		}
		
		return imgSaida;
	}

}
