package meujogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player implements ActionListener {
	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int altura, largura;
	private List<Tiro> tiros;
	private boolean isVisivel;
	private boolean isTurbo;
	private Timer timer;

	public boolean isTurbo() {
		return isTurbo;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public List<Tiro> getTiros() {
		return tiros;
	}

	public Player() {
		this.x = 100; /* coordenada da tela onde o player vai iniciar */
		this.y = 100;
		isVisivel = true;
		isTurbo = false;
		tiros = new ArrayList<Tiro>();

		timer = new Timer(5000, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(isTurbo == true) {
			turbo();
			isTurbo = false;
		}
		if(isTurbo == false) {
			load();
		}

	}

	public void load() {
		ImageIcon referencia = new ImageIcon("res\\spaceship2.png");
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);

	}

	public void update() {
		x += dx;
		y += dy;

	}

	public void tiroSimples() { // para o tiro sair bem no meio da nave
		this.tiros.add(new Tiro(x + largura, y + (altura / 2)));
	}

	public void turbo() {
		isTurbo = true;		
		ImageIcon referencia = new ImageIcon("res\\naveturbo.png");
		imagem = referencia.getImage();

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

	public void keyPressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode(); /* reconhece uma tecla do teclado pressionada */

		if (codigo == KeyEvent.VK_SPACE) {
			turbo();
		}

		if (codigo == KeyEvent.VK_A) {
			if(isTurbo == false) {
			tiroSimples();
			}
		}

		if (codigo == KeyEvent.VK_UP) { /*
										 * quando tecla UP apertada altera valor de dy e vai incrementar no y pelo
										 * metodo update, fazendo nave subir
										 */

			dy = -4; // PLANO CARTESIANO PADRAO é PRA BAIXO
		}
		if (codigo == KeyEvent.VK_DOWN) {
			dy = 4; // PLANO CARTESIANO PADRAO é PRA BAIXO
		}
		if (codigo == KeyEvent.VK_LEFT) {
			dx = -4;

		}
		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 4;
		}
	}

	public void keyRelease(KeyEvent tecla) {
		int codigo = tecla.getKeyCode(); /* reconhece uma tecla do teclado despressionada */

		if (codigo == KeyEvent.VK_UP) { /* faz parar de subir quando solta a tecla */
			dy = 0;
		}
		if (codigo == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		if (codigo == KeyEvent.VK_LEFT) {
			dx = 0;

		}
		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}

}
