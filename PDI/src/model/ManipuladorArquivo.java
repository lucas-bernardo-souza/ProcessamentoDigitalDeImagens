package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ManipuladorArquivo {
	public static FileReader leitorArquivo(String path)throws FileNotFoundException, IOException{
        return new FileReader(path);
    }
	
	public static ArrayList<String> leCabecalho(String path) throws IOException{
        ArrayList<String> cabecalho = new ArrayList<>();
        String linha = "";
        BufferedReader bufferedRead = new BufferedReader(new FileReader(path));
        cabecalho.add(bufferedRead.readLine()); // primeira linha
        linha = bufferedRead.readLine();
        while(!"#".equals(linha.substring(0, 1))){ // percorrendo os comentarios do comeco do arquivo
                                            // Percorro até encontrar um caracter diferente de #
            cabecalho.add(linha);
            linha = bufferedRead.readLine();
        }
        linha = bufferedRead.readLine();
        cabecalho.add(linha); // pegando linhas e colunas
        linha = bufferedRead.readLine();
        cabecalho.add(linha); // O maior valor presente num pixel
        return cabecalho;
    }
	
	public static int[][] leitor(String path, int linhas, int colunas) throws FileNotFoundException, IOException {
        int[][] matriz;
        try (BufferedReader bufferedRead = new BufferedReader(new FileReader(path))) {
            String linha = "";
            matriz = new int[linhas][colunas];
            linha = bufferedRead.readLine(); 
            linha = bufferedRead.readLine();
            linha = bufferedRead.readLine();
            linha = bufferedRead.readLine();
            for (int i=0; i<linhas; i++) {
                for (int j=0; j<colunas; j++){
                    linha = bufferedRead.readLine();
                    if (linha != null) { 
                        matriz[i][j] = Integer.parseInt(linha);
                    }
                    
                }
            }
        }
        return matriz;
    }
	
	public static int[][] leitor(String path) throws IOException{
		int[][] matriz;
		ArrayList<Integer> array = new ArrayList<>();
		
		ArrayList<String> cabecalho = leCabecalho(path);
		// Pegando o numero de linhas e colunas do cabecalho da imagem
		String linhaColuna = cabecalho.get(1);
		// Pegando o indice do espaço que separa a linha da coluna
	    int espaco = linhaColuna.indexOf(" ");
	    int coluna = Integer.parseInt(linhaColuna.substring(0, espaco));
	    int linha = Integer.parseInt(linhaColuna.substring(espaco+1, linhaColuna.length()));
	    
	    try (BufferedReader bufferedRead = new BufferedReader(new FileReader(path))) {
            String linhaLida = "";
            matriz = new int[linha][coluna];
            linhaLida = bufferedRead.readLine(); 
            linhaLida = bufferedRead.readLine();
            linhaLida = bufferedRead.readLine();
            linhaLida = bufferedRead.readLine();
            
            for(int i = 0; i < linha*coluna; i++) {
            	linhaLida = bufferedRead.readLine();
            	if(linhaLida != null) {
            		String[] aux = linhaLida.split(" ");
            		for(String str : aux) {
            			array.add(Integer.parseInt(str));
            		}
            	}
            }
            
            int k = 0;
            
            for (int i=0; i<linha; i++) {
                for (int j=0; j<coluna; j++){
                    matriz[i][j] = array.get(k);
                    k++;
                }
            }
        }
        return matriz;
	}
	
	public static void escritor(int[][] m, String op, int linhas, int colunas, ArrayList<String> cabecalho) throws FileNotFoundException, IOException {
        
        File file = new File(op.concat(".pgm"));
       
        try (FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                BufferedWriter writer = new BufferedWriter(osw)){
            for(String linha : cabecalho){
                writer.append(linha);
                writer.newLine();
            }
            for(int i = 0; i < linhas; i++){
                for(int j = 0; j < colunas; j++){
                    writer.append(Integer.toString(m[i][j]));
                    writer.newLine();
                }
            }
        }
    }
	
	public static void escritor(int[][] m, String op, ArrayList<String> cabecalho) throws FileNotFoundException, IOException {
		int linhas = TamanhoImagem.altura(cabecalho);
	    int colunas = TamanhoImagem.largura(cabecalho);
        File file = new File(op.concat(".pgm"));
       
        try (FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                BufferedWriter writer = new BufferedWriter(osw)){
            for(String linha : cabecalho){
                writer.append(linha);
                writer.newLine();
            }
            
            for(int i = 0; i < linhas; i++){
                for(int j = 0; j < colunas; j++){
                    writer.append(Integer.toString(m[i][j]));
                    writer.newLine();
                }
            }
        }
    }
	
	public static void gravaHistograma(ArrayList<Integer> histograma) throws FileNotFoundException, IOException {
		File file = new File("histograma.txt");
		try (FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                BufferedWriter writer = new BufferedWriter(osw)){
			for(int i:histograma) {
				writer.append(Integer.toString(i));
				writer.newLine();
			}
		}
	}
}
