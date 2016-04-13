/*	Pacote ao qual pertence */
package interFace;

/*	Importando APIs necessárias */
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class Comandos {
	//private static final java.lang.String newline = "\n";
	
	public static void abrirArquivo (){
		/*	Abrindo o selecionador de arquivos */
		JFileChooser fc = new JFileChooser();
		
		/*	Inicializando no diretório corrente */
		fc.setCurrentDirectory (new File("."));
		
		/*	Habilitando o filtro de arquivos */
		fc.addChoosableFileFilter(new FiltroMidi());
		fc.setAcceptAllFileFilterUsed(true);
		
        int returnVal = fc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            AreaGrafica.textoNomeArquivo.setText(file.getName());
            AreaGrafica.botaoTocar.setEnabled(true);
        }
	}
	
	public static void fecharAplicacao (){
		System.gc();
		Principal.janelaPrincipal.dispose();
		System.exit(0);
	}
	
	public static void tocarMusica (){
		Principal.tocando = true;
		
		AreaGrafica.textoBarraDeProgresso.setText("tocando a " + "hh:mm:ss" + " / " + "hh:mm:ss");
		AreaGrafica.botaoTocar.setEnabled(false);
		AreaGrafica.botaoPausar.setEnabled(true);
		AreaGrafica.botaoParar.setEnabled(true);
		
		//System.out.println("Tocando = " + Principal.tocando);
	}
	
	public static void pausarMusica (){
		Principal.tocando = false;
		
		AreaGrafica.textoBarraDeProgresso.setText("pausou em " + "hh:mm:ss" + " / " + "hh:mm:ss");
		AreaGrafica.botaoTocar.setEnabled(true);
		AreaGrafica.botaoPausar.setEnabled(false);
		AreaGrafica.botaoParar.setEnabled(true);
		//System.out.println("Tocando = " + Principal.tocando);
	}
	
	public static void pararMusica (){
		Principal.tocando = false;
		Principal.inicioBarra = 0;
		
		AreaGrafica.textoBarraDeProgresso.setText("parou a " + "hh:mm:ss" + " / " + "hh:mm:ss");
		AreaGrafica.botaoTocar.setEnabled(true);
		AreaGrafica.botaoPausar.setEnabled(false);
		AreaGrafica.botaoParar.setEnabled(false);
		
		//System.out.println("Tocando = " + Principal.tocando);
	}

	public static void aumentarVolume() {
		int atual = AreaGrafica.controleVolume.getValue();
		
		if (atual < AreaGrafica.controleVolume.getMaximum())
			AreaGrafica.controleVolume.setValue(atual + 1);
		
		//System.out.println("aumentando volume...");
		
		controleVolume();
	}
	
	public static void diminuirVolume() {
		int atual = AreaGrafica.controleVolume.getValue();
		
		if (atual > AreaGrafica.controleVolume.getMinimum())
			AreaGrafica.controleVolume.setValue(atual - 1);
		
		//System.out.println("diminuindo volume...");
		controleVolume();
	}
	
	public static void controleVolume() {
		AreaGrafica.textoVolume.setText("" + AreaGrafica.controleVolume.getValue());
		//System.out.println("volume Atual: " + AreaGrafica.controleVolume.getValue());
	}
	
	public static void sobreAplicacao (){
		JFrame sobre = new JFrame("Sobre");
		/*	Configurando o tamanho mínimo da janela */
		sobre.setSize(new Dimension(500, 260));
		/*	Desabilitando o redimensionamento da janela */
		sobre.setResizable(false);
		//janelaPrincipal.pack ();
		/* Exibição a interface */
		sobre.setVisible (true);
		sobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JTextPane textoSobre = new JTextPane();
		textoSobre.setBackground (new Color(235, 235, 235));
		textoSobre.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		textoSobre.setEditable(false);
		textoSobre.setContentType("text/html");
		
		String texto = "<html>"
						+ "<b> Tocador de Arquivos MIDIs</b><br /><br />"
						+ "<b> Desenvolvido por: </b><br />"
						+ "<i>Hélio Santana e Rodrigo Guimarães</i><br /><br />"
						+ "<b> Finalidade: </b><br />"
						+ "Reprodução de arquivos tipo MIDI, possibilitando o seu controle: "
						+ "tocar, pausar e parar, assim como o do volume. "
						+ "Além disso, há a possibilidade de exibir os eventos do arquivo MIDI "
						+ "em reprodução, ou pelo menos selecionado pelo usuário.<br /><br />"
						+ "<b> Linguagem adotada: </b><br />"
						+ "A aplicação foi desenvolvida em linguagem JAVA, tendo a GUI "
						+ "implementada por intermédio da SWING.<br /><br />"
						+ "</html>";
		
		textoSobre.setText(texto);
		
		
		sobre.add(textoSobre);
	}
}
