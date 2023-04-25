package model;

import java.io.IOException;
import java.util.ArrayList;

public class PrincipalDois {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path = "lena256.pgm";
		String pathUm = "phistf1.pgm";
		String pathDois = "phistf2.pgm";
		String pathTres = "phistf3.pgm";
		String pathQuatro = "phistf4.pgm";
		int[][] imagem = new int[256][256];
		int[][] imagemUm = new int[500][500];
		int[][] imagemDois = new int[500][500];
		int[][] imagemTres = new int[500][500];
		int[][] imagemQuatro = new int[500][500];
		ArrayList<String> cabecalhoUm = new ArrayList<>();
		ArrayList<String> cabecalhoDois = new ArrayList<>();
		ArrayList<String> cabecalhoTres = new ArrayList<>();
		ArrayList<String> cabecalhoQuatro = new ArrayList<>();
		cabecalhoUm = ManipuladorArquivo.leCabecalho(pathUm);
		cabecalhoDois = ManipuladorArquivo.leCabecalho(pathDois);
		cabecalhoTres = ManipuladorArquivo.leCabecalho(pathTres);
		cabecalhoQuatro = ManipuladorArquivo.leCabecalho(pathQuatro);
		imagem = ManipuladorArquivo.leitor(path);
		imagemUm = ManipuladorArquivo.leitor(pathUm);
		imagemDois = ManipuladorArquivo.leitor(pathDois);
		imagemTres = ManipuladorArquivo.leitor(pathTres);
		imagemQuatro = ManipuladorArquivo.leitor(pathQuatro);
		
		ArrayList<Integer> histograma = OperacaoHistograma.histograma(imagem);
		ArrayList<Integer> histogramaUm = OperacaoHistograma.histograma(imagemUm);
		ArrayList<Integer> histogramaDois = OperacaoHistograma.histograma(imagemDois);
//		for(int i : histogramaUm) {
//			System.out.println(i);
//		}
		
//		for(int i: histograma) {
//			System.out.println(i);
//		}
		
		imagemUm = OperacaoEqualizacao.equalizacao(imagemUm, histogramaUm, 256);
		int[][] imagemEqualizada = OperacaoEqualizacao.equalizacao(imagemDois, histogramaDois, 256);
		
		ManipuladorArquivo.gravaHistograma(histograma);
		ManipuladorArquivo.escritor(imagemUm, "EqualizadoUm", cabecalhoUm);
		ManipuladorArquivo.escritor(imagemEqualizada, "EqualizadoDois", cabecalhoDois);
		
//		for(int i = 0; i<255; i++) {
//			for(int j = 0; j < 255; j++) {
//				System.out.println(imagem[i][j]);
//			}
//		}
		
		//System.out.println(histograma.size());
	}

}
