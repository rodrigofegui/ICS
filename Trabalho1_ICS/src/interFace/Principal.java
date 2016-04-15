/*	Pacote ao qual pertence */
package interFace;

/*	Importando APIs necessárias */
import java.awt.Dimension;

import javax.swing.JFrame;

public class Principal implements Runnable{
	static JFrame janelaPrincipal = null;
	BarraDeMenu barraDeMenu = new BarraDeMenu();
	AreaGrafica areaGrafica = new AreaGrafica();
	static int inicioBarra = 0;
	static int inicioSequenciador = 0;
	static boolean tocando = false;
	final static boolean executar = true;
	static boolean EXECUTANDO_ECLIPSE = true;

	public static void main(String[] args){
		Principal principal = new Principal();
        Thread     thread  = new Thread(principal);
        thread.start();
        System.gc();
    }
	
	public Principal(){
		System.gc();
		/*	Criação da nova interface, com um título */
		janelaPrincipal = new JFrame ("Tocador MIDI - H\u0026R");

		/*	Adicionando componentes à janela */
		janelaPrincipal.setJMenuBar(barraDeMenu.criarBarraDeMenu());
		janelaPrincipal.setContentPane (areaGrafica.criarPlanoDeConteudo());

		/*	Configurando o tamanho mínimo da janela */
		janelaPrincipal.setSize(new Dimension(550, 190));
		/*	Desabilitando o redimensionamento da janela */
		janelaPrincipal.setResizable(false);
		//janelaPrincipal.pack ();
		/* Exibição a interface */
		janelaPrincipal.setVisible (true);
		janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.gc();
	}

	public void run() {
		while(executar){
			if (tocando){
					AreaGrafica.barraDeProgresso.setValue(inicioBarra);
					Comandos.retardo(1000);
					inicioBarra++;
			}else{
				try{
					Comandos.retardo(1000);                                 
				}catch(Exception e) {
					System.out.println(e.getMessage());  
                }
			}    
		}
	}

}
