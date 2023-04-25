package model;

import java.util.ArrayList;

public class TamanhoImagem {
	
	public static int largura(ArrayList<String> cabecalho) {
		// Pegando o numero de linhas e colunas do cabecalho da imagem
		String linhaColuna = cabecalho.get(1);
		// Pegando o indice do espaço que separa a linha da coluna
		int espaco = linhaColuna.indexOf(" ");
		int coluna = Integer.parseInt(linhaColuna.substring(0, espaco));
		return coluna;
	}
	
	public static int altura(ArrayList<String> cabecalho) {
		String linhaColuna = cabecalho.get(1);
		int espaco = linhaColuna.indexOf(" ");
		int linha = Integer.parseInt(linhaColuna.substring(espaco+1, linhaColuna.length()));
		return linha;
	}
	
	public static ArrayList<String> alteraCabecalho(ArrayList<String> cabecalho, int linha, int coluna){
		String tam = Integer.toString(linha) + " " + Integer.toString(coluna);
		cabecalho.remove(1);
		cabecalho.add(1, tam);
		return cabecalho;
	}
}
