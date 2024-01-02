package meujogo.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {
	/*
	 * Classe para criar objeto no construtor e fazer o plano de fundo do jogo.
	 * Neste caso o fundo é preto, mas é so mudar a imagem utilizada.
	 */

	private Image fundo;
	private Player player;
	private Timer timer;
	private List<Enemy1> enemy1;
	private List<Enemy2> enemy2;
	private List<Enemy3> enemy3;
	private List<Stars> stars;
	private boolean emJogo;
	private int velocidadePadraoFaseX = 1;
	private int velocidadeTurboFaseX = 4;

	// CONSTRUTOR
	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);

		ImageIcon referencia = new ImageIcon("res\\Background.png");
		fundo = referencia.getImage();

		player = new Player();
		player.load();

		addKeyListener(new TecladoAdapter());

		timer = new Timer(5, this); /* Define a VELOCIDADE do jogo */

		timer.start();

		inicializaInimigos();
		inicializaStars();
		emJogo = true;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	// inicializa INIMIGOS

	public void inicializaInimigos() {

		// ENEMY1
		int coordenadas1[] = new int[40]; // vetor que definira o numero de inimigos
		enemy1 = new ArrayList<Enemy1>(); // lista dos inimigos

		// populando a lista de inimigos
		for (int i = 0; i < coordenadas1.length; i++) {
			int x = (int) (Math.random() * 8000 + 1024);
			int y = (int) (Math.random() * 650 + 30);
			enemy1.add(new Enemy1(x, y)); // adicionando objetos da classe Enemy1 na lista enemy1
		}

		// ENEMY2

		int coordenadas2[] = new int[40]; // vetor que definira o numero de inimigos
		enemy2 = new ArrayList<Enemy2>(); // lista dos inimigos

		for (int j = 0; j < coordenadas2.length; j++) {
			int m = (int) (Math.random() * 8000 + 1024);
			int n = (int) (Math.random() * 650 + 30);
			enemy2.add(new Enemy2(m, n));
		}
		// ENEMY3

		/*
		 * int coordenadas3[] = new int[40]; // vetor que definira o numero de inimigos
		 * enemy3 = new ArrayList<Enemy3>(); // lista dos inimigos
		 * 
		 * // populando a lista de inimigos for (int k = 0; k < coordenadas2.length;
		 * k++) { int o = (int) (Math.random() * 8000 + 1024); int p = (int)
		 * (Math.random() * 650 + 30); enemy3.add(new Enemy3(o, p)); // adicionando
		 * objetos da classe Enemy1 na lista enemy1 }
		 */

	}

	// inicializa estrelas
	public void inicializaStars() {
		int coordenadas[] = new int[150];
		stars = new ArrayList<Stars>();

		// populando
		for (int i = 0; i < coordenadas.length; i++) {
			int x = (int) (Math.random() * 1024 + 0);
			int y = (int) (Math.random() * 768 + 0);
			stars.add(new Stars(x, y));
		}
	}

	// METODO QUE PINTA FASE
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		if (emJogo) {
			// insere fundo
			graficos.drawImage(fundo, 0, 0, null);

			// insere estrelas
			for (int p = 0; p < stars.size(); p++) {
				Stars q = stars.get(p);
				q.load();
				graficos.drawImage(q.getImagem(), q.getX(), q.getY(), this);
			}
			// insere layer
			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

			/* insere os tiros dados */
			List<Tiro> tiros = player.getTiros();
			for (int i = 0; i < tiros.size(); i++) {
				Tiro m = tiros.get(i);
				m.load();
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
			}
			// insere os inimigos
			for (int n = 0; n < enemy1.size(); n++) {
				Enemy1 inim = enemy1.get(n);
				inim.load();
				graficos.drawImage(inim.getImagem(), inim.getX(), inim.getY(), this);
			}

			for (int n = 0; n < enemy2.size(); n++) {
				Enemy2 inim = enemy2.get(n);
				inim.load();
				graficos.drawImage(inim.getImagem(), inim.getX(), inim.getY(), this);
			}
			/*
			 * for (int n = 0; n < enemy3.size(); n++) { Enemy3 inim = enemy3.get(n);
			 * inim.load(); graficos.drawImage(inim.getImagem(), inim.getX(), inim.getY(),
			 * this); }
			 */

		} else {
			ImageIcon fimJogo = new ImageIcon("res\\fimdejogo.png");
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);
		}

		g.dispose();
	}

	// METODO QUE ATUALIZA FASE
	@Override
	public void actionPerformed(ActionEvent e) { /* metodo do implemento ActionListener */
		player.update();

		// ACIONA TURBO

		if (player.isTurbo()) {
			moveFase(velocidadeTurboFaseX);
		} else {
			moveFase(velocidadePadraoFaseX);
		}

		// ATUALIZA ESTRELAS
		for (int p = 0; p < stars.size(); p++) {
			Stars on = stars.get(p);
			if (on.isVisivel()) {
				on.update();
			} else {
				stars.remove(p);
			}
		}

		// atualiza os tiros do jogador
		List<Tiro> tiros = player.getTiros();
		for (int i = 0; i < tiros.size(); i++) {
			Tiro m = tiros.get(i);
			if (m.isVisivel()) {
				m.update();
				if (player.isTurbo()) {
					tiros.get(i).setVELOCIDADE(-1);
				} else {
					tiros.get(i).setVELOCIDADE(2);
				}
			} else {
				tiros.remove(i);
			}

		}

		// atualiza os inimigos
		for (int n = 0; n < enemy1.size(); n++) {
			Enemy1 inim1 = enemy1.get(n);
			if (inim1.isVisivel()) {
				inim1.update();
			} else {
				enemy1.remove(n);
			}
		}

		for (int b = 0; b < enemy2.size(); b++) {
			Enemy2 inim2 = enemy2.get(b);
			if (inim2.isVisivel()) {
				inim2.update();
			} else {
				enemy2.remove(b);
			}
		}

		checarColisoes();
		repaint(); // repinta tela do player que se moveu
	}

	// MÉTODO PARA MOVER A FASE COM O TURBO
	private void moveFase(int velocidadeX) {
		for (int p = 0; p < stars.size(); p++) {
			Stars on = stars.get(p);
			if (on.isVisivel()) {
				on.setX(on.getX() - velocidadeX);
				on.update();
			} else {
				stars.remove(p);
			}
		}

		
		Iterator<Enemy1> iteratorEnemy1 = enemy1.iterator();
		while (iteratorEnemy1.hasNext()) {
		    Enemy1 tempEnemy1 = iteratorEnemy1.next();
		    if (tempEnemy1.isVisivel()) {
		        tempEnemy1.setX(tempEnemy1.getX() - velocidadeX);
		        tempEnemy1.update();
		    } else {
		        iteratorEnemy1.remove();
		    }
		}
		
		Iterator<Enemy2> iteratorEnemy2 = enemy2.iterator();
		while (iteratorEnemy2.hasNext()) {
		    Enemy2 tempEnemy2 = iteratorEnemy2.next();
		    if (tempEnemy2.isVisivel()) {
		        tempEnemy2.setX(tempEnemy2.getX() - velocidadeX);
		        tempEnemy2.update();
		    } else {
		        iteratorEnemy2.remove();
		    }
		}
		
		
		

	}

	// CHECANDO COLISOES
	public void checarColisoes() {
		Rectangle formaNave = player.getBounds();
		Rectangle formaEnemy1;
		Rectangle formaEnemy2;
		Rectangle formaEnemy3;
		Rectangle formaTiro;

		// colisao player com Enemy1
		Iterator<Enemy1> iteratorEn1 = enemy1.iterator();
		while (iteratorEn1.hasNext()) {
		    Enemy1 tempEnemy1 = iteratorEn1.next();
		    formaEnemy1 = tempEnemy1.getBounds();
		    if (formaNave.intersects(formaEnemy1)) {
		        if (player.isTurbo()) {
		            tempEnemy1.setVisivel(false);
		        }
		        player.setVisivel(false);
		        tempEnemy1.setVisivel(false);
		        emJogo = false;
		        
		    }
		}

		// Colisao Player com Enemy2
		Iterator<Enemy2> iteratorEn2 = enemy2.iterator();
		while (iteratorEn2.hasNext()) {
		    Enemy2 tempEnemy2 = iteratorEn2.next();
		    formaEnemy2 = tempEnemy2.getBounds();
		    if (formaNave.intersects(formaEnemy2)) {
		        if (player.isTurbo()) {
		            tempEnemy2.setVisivel(false);
		        }
		        player.setVisivel(false);
		        tempEnemy2.setVisivel(false);
		        emJogo = false;
		        
		    }
		}
	

		// colisao Tiros com Inimigos
		List<Tiro> tiros = player.getTiros();

		Iterator<Tiro> iteratorTiros = tiros.iterator();
		while (iteratorTiros.hasNext()) {
		    Tiro tempTiro = iteratorTiros.next();
		    formaTiro = tempTiro.getBounds();

		    // Colisão tiros com Enemy1
		    Iterator<Enemy1> iteratorEnemy1 = enemy1.iterator();
		    while (iteratorEnemy1.hasNext()) {
		        Enemy1 tempEnemy1 = iteratorEnemy1.next();
		        formaEnemy1 = tempEnemy1.getBounds();

		        if (formaTiro.intersects(formaEnemy1)) {
		            tempEnemy1.setVisivel(false);
		            iteratorTiros.remove();
		            iteratorEnemy1.remove();
		        }
		    }

		    // Colisão tiros com Enemy2
		    Iterator<Enemy2> iteratorEnemy2 = enemy2.iterator();
		    while (iteratorEnemy2.hasNext()) {
		    	
		        Enemy2 tempEnemy2 = iteratorEnemy2.next();
		        formaEnemy2 = tempEnemy2.getBounds();

		        if (formaTiro.intersects(formaEnemy2)) {
		            tempEnemy2.setVisivel(false);
		            iteratorTiros.remove();
		            iteratorEnemy2.remove();
		        }
		    }
		}

		

	
	}

	/*
	 * METODO DE ENTRADA DE TECLADO (TecladoAdapter criado por mim, KeyAdapter e
	 * KeyEvent importados da biblioteca do java)
	 */

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
		}
	}

}
