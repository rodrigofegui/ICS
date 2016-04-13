/*	Pacote ao qual pertence */
package interFace;

/*	Importando APIs necessárias */
import java.awt.Dimension;
import javax.swing.JFrame;

public class Principal {
	JFrame janelaPrincipal;
	BarraDeMenu barraDeMenu = new BarraDeMenu();
	AreaGrafica areaGrafica = new AreaGrafica();

	public static void main(String[] args){
        new Principal ();
    }
	
	public Principal(){
		/*	Criação da nova interface, com um título */
		janelaPrincipal = new JFrame ("Tocador MIDI - H&R");

		/*	Adicionando componentes à janela */
		janelaPrincipal.setJMenuBar(barraDeMenu.criarBarraDeMenu());
		janelaPrincipal.setContentPane (areaGrafica.criarPlanoDeConteudo());

		/*	Configurando o tamanho mínimo da janela */
		janelaPrincipal.setMinimumSize (new Dimension(550, 190));
		janelaPrincipal.pack ();
		/* Exibição a interface */
		janelaPrincipal.setVisible (true);
	}
}
