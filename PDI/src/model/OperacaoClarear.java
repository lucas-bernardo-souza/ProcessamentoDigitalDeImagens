package model;

public class OperacaoClarear {
	
	public static int[][] clarear(int[][] imagem, int p){
        int altura = imagem.length;
        int largura = imagem[0].length;
        int[][] novaImagem= new int[largura][altura];
        for(int l = 0; l < largura; l++){
            for(int a = 0; a < altura; a++){
                if(imagem[l][a] + p < 255){
                    novaImagem[l][a] = imagem[l][a] + p;
                } else{
                    novaImagem[l][a] = 255;
                }
            }
        }
        return novaImagem;
    }
    
    public static int[][] clarear(int[][] imagem, float p){
        int altura = imagem.length;
        int largura = imagem[0].length;
        int[][] novaImagem= new int[largura][altura];
        for(int l = 0; l < largura; l++){
            for(int a = 0; a < altura; a++){
                if(imagem[l][a] * p < 255){
                    novaImagem[l][a] = (int)(imagem[l][a] * p);
                } else{
                    novaImagem[l][a] = 255;
                }
            }
        }
        return novaImagem;
    }
}
