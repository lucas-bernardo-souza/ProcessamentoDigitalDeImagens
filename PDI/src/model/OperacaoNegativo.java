package model;

public class OperacaoNegativo {
	
	public static int[][] negativo(int[][] imagem, int nivelCinza){
        int altura = imagem.length;
        int largura = imagem[0].length;
        int[][] novaImagem= new int[largura][altura];
        for(int l = 0; l < largura; l++){
            for(int a = 0; a < altura; a++){
                if((nivelCinza - imagem[l][a]) < 255){
                    novaImagem[l][a] = nivelCinza - imagem[l][a];
                } else{
                    novaImagem[l][a] = 255;
                }
            }
        }
        return novaImagem;
    }
}
