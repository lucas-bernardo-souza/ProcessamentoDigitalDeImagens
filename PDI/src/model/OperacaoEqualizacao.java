package model;

import java.util.ArrayList;
import java.util.Arrays;

public class OperacaoEqualizacao {
	
	public static int[][] equalizacao(int[][] img, ArrayList<Integer> histograma, int nivelCinza){
		int alt = img.length;
		int lar = img[0].length;
		int imgSaida[][] = new int[alt][lar];
		double aux = 0;
		double soma = 0;
		
		ArrayList<Double> probabilidade = new ArrayList<>();
		ArrayList<Integer> equalizado = new ArrayList<>();
		
		for(int i : histograma) {
			probabilidade.add((double) i / (alt*lar));
			//System.out.println((double) i / (alt*lar));
		}
		
		soma = probabilidade.get(0); // inicializando soma com o primeiro valor do probabilidade
		
		for(double d : probabilidade) {
			aux = (nivelCinza - 1) * soma;
			soma += d;
			equalizado.add((int) aux);
		}
		
		int pixel;
		
		for(int a = 0; a<alt; a++) {
			for(int l = 0; l<lar; l++) {
				pixel = equalizado.get(img[a][l]);
				imgSaida[a][l] = pixel;
			}
		}
		
//		for(double d : equalizado) {
//			System.out.println(d);
//		}
		
		return imgSaida;
	}
	
	public static int[][] equalizacaoLocal(int[][] img, int nivelCinza, int dim){
		int alt = img.length;
		int lar = img[0].length;
		int imgSaida[][] = new int[alt][lar];
		int imgAux[][] = new int[dim][dim];
		double aux = 0;
		double soma = 0;
		
		ArrayList<Double> probabilidade = new ArrayList<>();
		ArrayList<Integer> equalizado = new ArrayList<>();
		ArrayList<Integer> histograma = new ArrayList<>();
		
		for(int a = 0; a<alt; a++) {
			int col = 0;
			for(int l = 0; l<lar; l++) {
				if(dim > lar) {
					break;
				}
				int linha[] = Arrays.copyOfRange(img[a], l, l+dim);
				imgAux[col] = linha;
				col++;
				l = l +dim;
				break;
			}
			col ++;
			for(int k = 0; k < dim; k++) {
				for(int l = 0; l < dim; l++) {
					System.out.print(imgAux[k][l] + " ");
				}
				System.out.println();
			}
		}
		
		
		return imgSaida;
	}

}
