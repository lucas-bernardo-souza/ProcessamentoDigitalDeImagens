package model;

public class OperacaoEscurecer {
	
	public static int[][] escurecer(int[][] imagem, int p){
        int altura = imagem.length;
        int largura = imagem[0].length;
        int[][] novaImagem= new int[largura][altura];
        
        for(int l = 0; l < largura; l++){
            for(int a = 0; a < altura; a++){
                if(imagem[l][a] - p > 0){
                    novaImagem[l][a] = imagem[l][a] - p;
                } else{
                    novaImagem[l][a] = 0;
                }
            }
        }
        return novaImagem;
    }
}
