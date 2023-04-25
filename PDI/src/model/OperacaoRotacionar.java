package model;

public class OperacaoRotacionar {
	
	public static int[][] rotacionar(int[][] imagem){
        int altura = imagem.length;
        int largura = imagem[0].length;
        int[][] novaImagem= new int[largura][altura];
        int novaL, novaC;
        for(int linhas = 0; linhas < altura; linhas++){
            novaC = (largura -1) - linhas;
            for(int colunas = 0; colunas < largura; colunas++){
                novaL = colunas;
                novaImagem[novaL][novaC] = imagem[linhas][colunas];
            }
        }
        
       return novaImagem;
    }
}
