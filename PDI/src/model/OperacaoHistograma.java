package model;

import java.util.ArrayList;

public class OperacaoHistograma {
	
	public static ArrayList<Integer> histograma(int[][] img){
		int alt = img.length;
		int lar = img[0].length;
		ArrayList<Integer> histograma = new ArrayList<>();
		// tamanho do nível de cinza
		int cont = 0;
		for(int k = 0; k<255; k++) {
			cont = 0;
			for(int a=0; a<alt; a++) {
				for(int l=0; l<lar; l++) {
					if(k == img[a][l]) {
						cont++;
					}
				}
			}
			histograma.add(cont);
		}
		
		return histograma;
	}

}
