package meujogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy3 {
	
	private Image imagem;
	private int x,y;
	private int largura, altura;
	private boolean isVisivel;
	//private static final int LARGURA = 938;
	private static int VELOCIDADE = 2;
	
	
	
	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
		vELOCIDADE = VELOCIDADE;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}
	
	
	public Image getImagem() {
		return imagem;
	}

	public Enemy3(int x,int y) {
		this.x = x;
		this.y = y;
		isVisivel = true;
	}
		
	public void load() {
		ImageIcon referencia  = new ImageIcon("res\\Enemy3.png");
		imagem = referencia.getImage();
		
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}
	public void update() {  /*metodo para fazer o inimigo andar, de tras pra frente*/
		this.x = x - VELOCIDADE;
		//if(this.x > LARGURA) {
			//isVisivel = false;
					//}		
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,largura,altura);
	}

}
