package meujogo;

import javax.swing.JFrame;

import meujogo.Modelo.Fase;

public class Container extends JFrame {
	
	public Container() {
		add(new Fase()); /*Objeto que seta a imagem de fundo*/
		setTitle("Meu Jogo");  
		setSize(1024,728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Faz o jogo fechar
		setLocationRelativeTo(null);  // onde vai ficar o mouse qnd iniciar tela(no meio==null)
		this.setResizable(false);  // nao permite fullscreen ou mudar resoluçao
		setVisible(true);
		
		 
	}
	
	public static void main(String[] args) {
		new Container();
	}

}
