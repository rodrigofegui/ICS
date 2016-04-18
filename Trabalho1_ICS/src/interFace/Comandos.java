
package interFace;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import controladorMidi.ControladorMidi2;

public class Comandos {

	
	public static void abrirArquivo () throws MidiUnavailableException{
		
		JFileChooser seletorArquivo = new JFileChooser();
		
		
		seletorArquivo.setCurrentDirectory (new File("."));
		
		
		seletorArquivo.addChoosableFileFilter(new FiltroMidi());
		seletorArquivo.setAcceptAllFileFilterUsed(true);
		seletorArquivo.setFileFilter(new FiltroMidi());
		
        int returnVal = seletorArquivo.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION){
            ControladorMidi2.arqMidi = seletorArquivo.getSelectedFile();
            
            AreaGrafica.textoNomeArquivo.setText(ControladorMidi2.arqMidi.getName());
            
            ControladorMidi2.iniciaSequenciador();
            AreaGrafica.botaoTocar.setEnabled(true);
            AreaGrafica.botaoVoltar.setEnabled(true);
            AreaGrafica.botaoAvancar.setEnabled(true);
        }
	}

	public static void conteudoMidi (){
		
		JFrame janelaDados = new JFrame("Conteúdo MIDI");		
		janelaDados.setSize(new Dimension(840, 600));		
		janelaDados.setVisible (true);
		janelaDados.setResizable(false);		
		janelaDados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String trilhaTexto = null;
		String tiqueString;
		int n;
	    String comandoString;
	    String nomecomando;
		String shortMessageString;
		String operador1, operador2, operador3;
		
		
		String[][] dados = {null}; 
		String cabecalho[] = {"Trilha", "Instante (tiques)",
							  "Instante (seg)", "Código",
							  "Operando 1", "Operando 2",
							  "Operando 3", "Mensagem deco."};
		int tamanho[] = {50, 120, 100, 60, 90, 90, 90, 250};
		DefaultTableModel modeloTabelaDados = new DefaultTableModel(dados, cabecalho);
		JTable tabelaDados = new JTable(modeloTabelaDados);
		JScrollPane planoRolante = new JScrollPane(tabelaDados);
		
		
		for (int col = 0; col < tamanho.length; col++){
			tabelaDados.getColumnModel().getColumn(col).setPreferredWidth(tamanho[col]);
			tabelaDados.getColumnModel().getColumn(col).setResizable(false);
		}
		
		
		tabelaDados.getTableHeader().setReorderingAllowed(false);		
		
		//tem que adicionar os negocio aqui
		
		if(ControladorMidi2.sequencia != null){
			Track[] trilhas = ControladorMidi2.sequencia.getTracks(); 
			
			for(int i=0; i<trilhas.length; i++){
				
				Track trilha = trilhas[i];				
				try{
	            	trilhaTexto =  getTexto(trilha);
	             }catch(Exception e){}
				
				
				for(int j=0; j<trilha.size(); j++){
					MidiEvent e = trilha.get(j);
					MidiMessage mensagem = e.getMessage();
					
					
					byte a[] = mensagem.getMessage(); 
					
					operador1 = new String(a, StandardCharsets.UTF_8);
					
					long tique = e.getTick();
					
					tiqueString = Long.toString(tique);
					
					n = mensagem.getStatus();
					
					comandoString = Integer.toString(n);
					
		               
		            nomecomando = ""+n;
		               
		            switch(n){
		            	case 128: nomecomando = "note ON"; break;
		                case 144: nomecomando = "note OFF"; break;
		                case 255: nomecomando = "MetaMensagem  (a ser decodificada)"; break;
		                case 192: nomecomando = "Program Change"; break;
		                case 250: nomecomando = "Start"; break;
		                case 252: nomecomando = "Stop"; break;
		                case 176: nomecomando = "Control Change"; break;
		            }
					
		            String  linhas[]  =  {trilhaTexto,tiqueString,ControladorMidi2.textoTempoAtual(),comandoString, operador1, " ", " ", nomecomando};		
		    		modeloTabelaDados.addRow(linhas);
		            
				}
				
			}
			
		}	
		
		
		
		tabelaDados.setEnabled(false);	
		janelaDados.add(planoRolante);
	}

	public static void conteudoMusical (){
		JFrame janelaMusical = new JFrame("Conteúdo Musical");
		/*	Configurando o tamanho mínimo da janela */
		janelaMusical.setSize(new Dimension(500, 400));
		/*	Desabilitando o redimensionamento da janela */
		janelaMusical.setResizable(false);
		/* Exibiç\u00e3o a interface */
		janelaMusical.setVisible (true);
		/*	Configurando para encerrar a janela ao sair, n\u00e3o a aplicaç\u00e3o */
		janelaMusical.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel painelMusical = new JPanel(new FlowLayout());
		/*	Configuraç\u00e3o do layout para "crescer" no eixo Y */
        painelMusical.setLayout (new BoxLayout(painelMusical, BoxLayout.Y_AXIS));
        painelMusical.setOpaque (true);
        /*	Adicionando à janela */
        janelaMusical.add(painelMusical);
		
		JTextPane textoMusical = new JTextPane();
		textoMusical.setBackground (new Color(235, 235, 235));
		textoMusical.setBorder(BorderFactory.createEmptyBorder(0,5,10,10));
		textoMusical.setEditable(false);
		textoMusical.setContentType("text/html");
		
		String texto =	"<html>"
						+ "<br /> <font size=5> <b>Parte Escrita: </b> </font> <br />"
						+ "<b>Clave: </b> <br />"
						+ "<font size=3>" + "SOL" + "</font>"
						+ "<br /><b>Fórmula de compasso: </b><br />"
						+ "<font size=3>" + 4 + "/" + 4 + "</font>"
						+ "<br /><b>Metro: </b><br />"
						+ "<font size=3>" + 4 + "</font>"
						+ "<br /><b>Andamento: </b><br />"
						+ "<font size=3>" + 60 + "</font>"
						+ "<br /><b>Armadura de Tonalidade: </b><br />"
						+ "<font size=3>" + "C Maior" + "</font>"
						+ "<br /><br /> <font size=5> <b>Parte Visual: </b> </font>"
						+ "</html>";		
		
		/*	Configurando texto */
		textoMusical.setText(texto);
		
		/*	Adicionando texto ao painel */
		painelMusical.add(textoMusical);
		/*	Adicionaod espaçamento para o próximo painel */
        painelMusical.add(Box.createRigidArea(new Dimension(0, 5)));
		
        String nomeIcone;
		if (Principal.EXECUTANDO_ECLIPSE)
			nomeIcone = "Icones/partevisual.png";
		else
			nomeIcone = "../Icones/partevisual.png";
		
		ImageIcon icone = AreaGrafica.criarIcone(nomeIcone);
		JButton parteVisual = new JButton(icone);
		/*	Redimensioar bot\u00e3o */
		//parteVisual.setPreferredSize(new Dimension(500, 80));
		/*	Tirar borda */
		parteVisual.setBorderPainted(false);
		/*	Tirar area pintada */
		parteVisual.setContentAreaFilled(false);
		parteVisual.setBorder (null);
		
		/*	Adicionando imagem ao painel */
		painelMusical.add(parteVisual);
	}
	
	public static void fecharAplicacao (){
		System.gc();
		Principal.janelaPrincipal.dispose();
		System.exit(0);
	}
	
	public static void tocarMusica () throws MidiUnavailableException{

		Principal.tocando = true;
		
		atualizarTempoProgresso();
		AreaGrafica.botaoTocar.setEnabled(false);
		AreaGrafica.botaoTocar.setVisible(false);
		AreaGrafica.botaoPausar.setEnabled(true);
		AreaGrafica.botaoPausar.setVisible(true);
		AreaGrafica.botaoParar.setEnabled(true);
		
		ControladorMidi2.tocarMidi();		
		
	}
	
	public static void pausarMusica (){
		Principal.tocando = false;
		
		atualizarTempoProgresso();
		AreaGrafica.botaoTocar.setEnabled(true);
		AreaGrafica.botaoTocar.setVisible(true);
		AreaGrafica.botaoPausar.setEnabled(false);
		AreaGrafica.botaoPausar.setVisible(false);
		AreaGrafica.botaoParar.setEnabled(true);
		
		ControladorMidi2.pausarMidi ();
	}
	
	public static void pararMusica (){
		Principal.tocando = false;
		AreaGrafica.posicaoBarraProgresso = 0;
		
		atualizarTempoProgresso();
		AreaGrafica.botaoTocar.setEnabled(true);
		AreaGrafica.botaoTocar.setVisible(true);
		AreaGrafica.botaoPausar.setEnabled(false);
		AreaGrafica.botaoPausar.setVisible(false);
		AreaGrafica.botaoParar.setEnabled(false);
		
		ControladorMidi2.pararMidi();		
		//System.out.println("Tocando = " + Principal.tocando);
	}

	public static void voltarMusica(){
		int atual = AreaGrafica.barraDeProgresso.getValue();
		
		atual--;
		
		if (atual < AreaGrafica.barraDeProgresso.getMinimum())
			atual = AreaGrafica.barraDeProgresso.getMinimum();
		
		
		confProgressos(atual);
	}
	
	public static void avancarMusica() throws MidiUnavailableException{
		int atual = AreaGrafica.barraDeProgresso.getValue();
		
		atual++;
		
		if (atual > AreaGrafica.barraDeProgresso.getMaximum())
			atual = AreaGrafica.barraDeProgresso.getMaximum();
		
		confProgressos(atual);
		
		long a = (long) atual;
		
		
		ControladorMidi2.avancarMidi(a);
		
				
	}
	
	public static void aumentarVolume() {
		int atual = AreaGrafica.controleVolume.getValue();
		
		if (atual < AreaGrafica.controleVolume.getMaximum()){
			AreaGrafica.controleVolume.setValue(atual + 1);
			 ControladorMidi2.mudaVolume(atual);
		}
		//System.out.println("aumentando volume...");
		
		controleVolume();
	}
	
	public static void diminuirVolume() {
		int atual = AreaGrafica.controleVolume.getValue();
		
		if (atual > AreaGrafica.controleVolume.getMinimum()){
			AreaGrafica.controleVolume.setValue(atual - 1);
			ControladorMidi2.mudaVolume(atual);
		}
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
		sobre.setSize(new Dimension(500, 280));
		/*	Desabilitando o redimensionamento da janela */
		sobre.setResizable(false);
		//janelaPrincipal.pack ();
		/* Exibiç\u00e3o a interface */
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
						+ "<i>Hélio Santana e Rodrigo Guimar\u00e3es</i><br /><br />"
						+ "<b> Finalidade: </b><br />"
						+ "Reproduç\u00e3o de arquivos tipo MIDI, possibilitando o seu controle: "
						+ "tocar, pausar e parar, assim como o do volume. "
						+ "Além disso, há a possibilidade de exibir os eventos do arquivo MIDI "
						+ "em reproduç\u00e3o, ou pelo menos selecionado pelo usuário.<br /><br />"
						+ "<b> Linguagem adotada: </b><br />"
						+ "A aplicaç\u00e3o foi desenvolvida em linguagem JAVA, tendo a GUI "
						+ "implementada por intermédio da SWING.<br /><br />"
						+ "</html>";
		
		textoSobre.setText(texto);
		
		
		sobre.add(textoSobre);
	}
	
	public static void atualizarTempoProgresso (){
		AreaGrafica.textoBarraDeProgresso.setText(textoProgresso());
	}
	
	private static String textoProgresso (){
		String texto = ControladorMidi2.textoTempoAtual() + " / " + ControladorMidi2.textoDuracao;		
		return texto;
	}
	
	public static int getPosicaoBarraProgresso (){
		ControladorMidi2.posicaoSequenciador = ControladorMidi2.sequenciador.getMicrosecondPosition();
		
		return (int) ((ControladorMidi2.posicaoSequenciador * 100) / ControladorMidi2.duracao);
	}
	
	public static int setPosicaoBarraProgresso (){
		return (int) ((ControladorMidi2.duracao * AreaGrafica.posicaoBarraProgresso) / 100);
	}
	
	private static void confProgressos (int atual) {
		AreaGrafica.barraDeProgresso.setValue(atual);
		AreaGrafica.posicaoBarraProgresso = atual;
		ControladorMidi2.posicaoSequenciador = setPosicaoBarraProgresso();
		
				
	}
	
  	public static void retardo (int miliseg){  
        try{
        	Thread.sleep(miliseg);
        }catch (InterruptedException e) { }
	}
  	
  	
  	
  	 static String getTexto(Track trilha) throws InvalidMidiDataException{
  		 
  	    String stexto = "";

  	    for(int i=0; i<trilha.size(); i++){
  	    	MidiMessage m = trilha.get(i).getMessage();
  	           
  	    	if(((MetaMessage)m).getType() == 0x01){
  	    		
  	    		MetaMessage mm  = (MetaMessage)m;
  	    		byte[]     data = mm.getData();

  	    		for(int j=0; j<data.length; j++){
  	    			stexto += (char)data[j];
  	    		}         
  	    	}       
  	    }    
  	  return stexto;
  	 }
  	
  	
}

