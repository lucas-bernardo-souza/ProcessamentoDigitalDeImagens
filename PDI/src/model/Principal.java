package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// variaveis iniciais
		String path = "lena256.pgm";
		String pathDois = "ctskull-256.pgm";
		String pathTres = "aerial.pgm";
		String pathQuatro = "spine.pgm";
		
	    int[][] imagem = new int[256][256];
	    int[][] imagemDois;
	    int[][] imagemTres;
	    int[][] imagemQuatro;
	    int[][] imagemLena;
	    int linha = 0, coluna = 0;
	    
	    ArrayList<String> cabecalho = new ArrayList<>();
	    ArrayList<String> cabecalhoLena = new ArrayList<>();
	    ArrayList<String> cabecalhoDois = new ArrayList<>();
	    ArrayList<String> cabecalhoTres = new ArrayList<>();
	    ArrayList<String> cabecalhoQuatro = new ArrayList<>();
	    
	 // lendo dados iniciais
	    cabecalho = ManipuladorArquivo.leCabecalho(path);
	    cabecalhoLena = ManipuladorArquivo.leCabecalho(path);
	    cabecalhoDois = ManipuladorArquivo.leCabecalho(pathDois);
	    cabecalhoTres = ManipuladorArquivo.leCabecalho(pathTres);
	    cabecalhoQuatro = ManipuladorArquivo.leCabecalho(pathQuatro);
	    // imprimindo cabecalho
	//    for(String s : cabecalhoDois) {
	//    	System.out.println(s);
	//    }
	    
	    linha = TamanhoImagem.altura(cabecalhoLena);
	    coluna = TamanhoImagem.largura(cabecalhoLena);
	    imagemLena = new int[linha][coluna];
	    
	    linha = TamanhoImagem.altura(cabecalhoDois);
	    coluna = TamanhoImagem.largura(cabecalhoDois);
	    imagemDois = new int[linha][coluna];
	    
	    linha = TamanhoImagem.altura(cabecalhoTres);
	    coluna = TamanhoImagem.largura(cabecalhoTres);
	    imagemTres = new int[linha][coluna];
	    
	    linha = TamanhoImagem.altura(cabecalhoQuatro);
	    coluna = TamanhoImagem.largura(cabecalhoQuatro);
	    imagemQuatro = new int[linha][coluna];
	   
	    imagem = ManipuladorArquivo.leitor(path, 256, 256);
	    imagemDois = ManipuladorArquivo.leitor(pathDois);
	    imagemTres = ManipuladorArquivo.leitor(pathTres);
	    imagemQuatro = ManipuladorArquivo.leitor(pathQuatro);
	    imagemLena = ManipuladorArquivo.leitor(path);
	    
	    
	    // Visualizando conteudo da matriz
	//    for(int i = 0; i < 256; i++){
	//        for(int j = 0; j < 256; j++){
	//            System.out.println(imagem[i][j]);
	//        }
	//    }
	    
	    int[][] imagemEscurecida = new int[256][256];
	    int[][] imagemNegativa = new int[256][256];
	    int[][] imagemClarearUm = new int[256][256];
	    int[][] imagemClarearDois = new int[256][256];
	    int[][] imagemRotacionada = new int[256][256];
	    linha = TamanhoImagem.altura(cabecalhoDois);
	    coluna = TamanhoImagem.largura(cabecalhoDois);
	    int[][] imagemEspelhada = new int[linha][coluna];
	    int[][] imagemEspelhadaLinha = new int[linha][coluna];
	    int[][] imagemDestacada = new int[linha][coluna];
	    int[][] imagemDestacadaDois = new int[linha][coluna];
	    int[][] diferenca = new int[linha][coluna];
	    
	    int[][] resultadoTres = new int[TamanhoImagem.altura(cabecalhoTres)][TamanhoImagem.largura(cabecalhoTres)];
	    int[][] resultadoQuatro = new int[TamanhoImagem.altura(cabecalhoQuatro)][TamanhoImagem.largura(cabecalhoQuatro)];
	    
	    // subtraindo dez de cada pixel
	    imagemEscurecida = OperacaoEscurecer.escurecer(imagem, 10);
	    
	    imagemNegativa = OperacaoNegativo.negativo(imagem, 255);
	    
	    // Adicionando o valor 10 a cada pixel
	    imagemClarearUm = OperacaoClarear.clarear(imagem, 10);
	    
	    // Multiplicando cada pixel da imagem por 1.9
	    imagemClarearDois = OperacaoClarear.clarear(imagem, 1.9F);
	    
	    //Não foi implementando a quantidade de rotações
	    imagemRotacionada = OperacaoRotacionar.rotacionar(imagem);
	   
	    imagemEspelhada = OperacaoEspelhamento.espelhamentoColuna(imagemDois);
	   
	    imagemEspelhadaLinha = OperacaoEspelhamento.espelhamentoLinha(imagemDois);
	   
	   // implementar uma interface para passar os valores de A e B de forma dinamica e ir vendo o resultado na hora
	   	imagemDestacada = OperacaoDestacar.destacarIntervalo(imagemDois, 150, 202, 255);
	   	
	   	imagemDestacadaDois = OperacaoDestacar.destacarIntervaloDois(imagemDois, 150, 202, 255);
	    
	   	diferenca = OperacaoSubtracao.subtrairImagem(imagemDois, imagemDestacada);
	   	
	    ManipuladorArquivo.escritor(imagemEscurecida, "imagemEscurecida", 256, 256, cabecalho);
	    ManipuladorArquivo.escritor(imagemNegativa, "imagemNegativa", 256, 256, cabecalho);
	    ManipuladorArquivo.escritor(imagemClarearUm, "imagemClareadaUm", 256, 256, cabecalho);
	    ManipuladorArquivo.escritor(imagemClarearDois, "imagemClarearDois", 256, 256, cabecalho);
	    ManipuladorArquivo.escritor(imagemRotacionada, "imagemRotacionada", 256, 256, cabecalho);
	    ManipuladorArquivo.escritor(imagemEspelhada, "imagemEspelhada", linha, coluna, cabecalhoDois);
	    ManipuladorArquivo.escritor(imagemEspelhadaLinha, "imagemEspelhadaLinha", linha, coluna, cabecalhoDois);
	    ManipuladorArquivo.escritor(imagemDestacada, "imagemDestacada", linha, coluna, cabecalhoDois);
	    ManipuladorArquivo.escritor(imagemDestacadaDois, "imagemDestacadaDois", linha, coluna, cabecalhoDois);
	    ManipuladorArquivo.escritor(diferenca, "diferenca", linha, coluna, cabecalhoDois);
	    
	    // Operação gama
	    resultadoTres = OperacaoMelhoramentoContraste.gama(imagemTres, 1, 3.0);
	    ManipuladorArquivo.escritor(resultadoTres, "aerialUm", cabecalhoTres);
	    resultadoTres = OperacaoMelhoramentoContraste.gama(imagemTres, 1, 4.0);
	    ManipuladorArquivo.escritor(resultadoTres, "aerialDois", cabecalhoTres);
	    resultadoTres = OperacaoMelhoramentoContraste.gama(imagemTres, 1, 5.0);
	    ManipuladorArquivo.escritor(resultadoTres, "aerialTres", cabecalhoTres);
	    
	    resultadoQuatro = OperacaoMelhoramentoContraste.gama(imagemQuatro, 1, 0.3);
	    ManipuladorArquivo.escritor(resultadoQuatro, "spineUm", cabecalhoQuatro);
	    resultadoQuatro = OperacaoMelhoramentoContraste.gama(imagemQuatro, 1, 0.4);
	    ManipuladorArquivo.escritor(resultadoQuatro, "spineDois", cabecalhoQuatro);
	    resultadoQuatro = OperacaoMelhoramentoContraste.gama(imagemQuatro, 1, 0.6);
	    ManipuladorArquivo.escritor(resultadoQuatro, "spineTres", cabecalhoQuatro);
	    
	    int imagemZoom[][] = OperacaoZoom.replicacao(imagemLena);
	    cabecalhoLena = TamanhoImagem.alteraCabecalho(cabecalhoLena, imagemZoom.length, imagemZoom[0].length);
	    ManipuladorArquivo.escritor(imagemZoom, "lenaZoom", cabecalhoLena);
	    int imagemReducao[][] = OperacaoZoom.reducao(imagemZoom);
	    ManipuladorArquivo.escritor(imagemReducao, "lenaReducao", cabecalho);
	    
	}
}
