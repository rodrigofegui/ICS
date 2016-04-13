/*	Pacote ao qual pertence */
package interFace;

/*	Importando APIs necessárias */
import java.io.File;

import javax.swing.JFileChooser;

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
        }
	}
	
	public static void tocarMusica (){
		AreaGrafica.textoBarraDeProgresso.setText("tocando a hh:mm:ss");
		AreaGrafica.botaoTocar.setEnabled(false);
		AreaGrafica.botaoPausar.setEnabled(true);
		AreaGrafica.botaoParar.setEnabled(true);
	}
	
	public static void pausarMusica (){
		AreaGrafica.textoBarraDeProgresso.setText("pausado em hh:mm:ss");
		AreaGrafica.botaoTocar.setEnabled(true);
		AreaGrafica.botaoPausar.setEnabled(false);
		AreaGrafica.botaoParar.setEnabled(true);
	}
	
	public static void pararMusica (){
		AreaGrafica.textoBarraDeProgresso.setText("parou em hh:mm:ss");
		AreaGrafica.botaoTocar.setEnabled(true);
		AreaGrafica.botaoPausar.setEnabled(false);
		AreaGrafica.botaoParar.setEnabled(false);
	}
}
