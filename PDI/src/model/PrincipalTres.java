package model;

public class PrincipalTres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] img = new int[3][3];
		img[0][0] = 1;
		img[0][1] = 2;
		img[0][2] = 3;
		img[1][0] = 1;
		img[1][1] = 2;
		img[1][2] = 3;
		img[2][0] = 1;
		img[2][1] = 2;
		img[2][2] = 3;
		
		OperacaoEqualizacao.equalizacaoLocal(img, 0, 2);

	}

}
