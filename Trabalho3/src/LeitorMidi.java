import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;


public class LeitorMidi {
	static File arqMidi = null;
	static Sequence sequenciaMidi = null;
	static String nomeArqMidi = "";
	static LinkedList<NotasMidi> notasLidas = new LinkedList<NotasMidi> ();
	static int vez = 1;
	
	public LeitorMidi (){
		notasLidas = new LinkedList<NotasMidi> (); 
	}
	
	public LeitorMidi (String nomeArqMidi){
		this ();
		LeitorMidi.nomeArqMidi = nomeArqMidi;
		
		try {
			LeitorMidi.arqMidi = new File(LeitorMidi.nomeArqMidi);
			LeitorMidi.sequenciaMidi = MidiSystem.getSequence(LeitorMidi.arqMidi);
			
		}catch (InvalidMidiDataException e) {
			System.out.println (e + " : Erro nos dados midi.");
		}catch (IOException e1) {
			System.out.println (e1);
		}
	}

	public static void leituraDados (String nomeArqMidi){
		new LeitorMidi (nomeArqMidi);

		long duracao     = sequenciaMidi.getMicrosecondLength() / 1000000;
		long totaltiques = sequenciaMidi.getTickLength();
		float durtique = (float)duracao/totaltiques;

		Track[] trilhasDetectadas = sequenciaMidi.getTracks();

		for (int indTrilha = 0; indTrilha < trilhasDetectadas.length; indTrilha++){
			Track trilhaAtual = trilhasDetectadas[indTrilha];

			for (int indEvento = 0; indEvento < trilhaAtual.size(); indEvento++){
				MidiEvent evento = trilhaAtual.get(indEvento);
				MidiMessage mensagem = evento.getMessage();
				long tique = evento.getTick();

				trataMensagem (mensagem, (tique * durtique));
			}
		}

		preencherInicio (notasLidas);
		//System.out.println(notasLidas);
		//System.out.println(notasLidas.getFirst());
		//System.out.println(notasLidas.size());
	}

	public static void escreverArquivo (){
		if (!notasLidas.isEmpty()){
			try {
				FileWriter arq = new FileWriter("src/BaseadoMidi.java");
				PrintWriter gravarArq = new PrintWriter(arq);
			    
				escreverCabecalho (gravarArq);
				
			    escreverMelodia (gravarArq);		    
			    
			    arq.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void trataMensagem (MidiMessage mensagem, float instante){
		int IdOperacao = mensagem.getStatus();
		
		if ((128 <= IdOperacao) & (IdOperacao <= 159)){
			byte[] dados = mensagem.getMessage();
			NotasMidi notaAux = new NotasMidi();
			boolean noteOn;
			
			if (IdOperacao < 144)
				noteOn = false;
			else
				noteOn = true;
		
			if (noteOn & (dados[2] > 0)){
				//*
				notaAux.setFrequencia (dados[1]);
				notaAux.setAmplitude (dados[2]);
				notaAux.setInstanteInical (instante);
				
				notasLidas.add(notaAux);
				//*/
			
			}else if (((noteOn & (dados[2] == 0))
					  || !noteOn) & !notasLidas.isEmpty()){
				notaAux.setFrequencia (dados[1]);
				
				int indice = localizaNota (notasLidas, notaAux);
				
				if (indice > -1){
					notasLidas.get(indice).setInstanteFinal (instante);
					notasLidas.get(indice).setDuracao();
				}
			}
		}
	}

	private static int localizaNota (LinkedList<NotasMidi> lista, NotasMidi notaAlvo){
		for (int ind = 0; ind < lista.size(); ind++){
			NotasMidi notaAtual = lista.get(ind);
			
			if ((notaAtual.getFrequencia() == notaAlvo.getFrequencia())
				& (notaAtual.getDuracao() == 0f)){
				return ind;
			}
		}
		
		return -1;
	}

	private static void preencherInicio (LinkedList<NotasMidi> lista){
		if (lista.getFirst().getInstanteInicial() != 0f){
			NotasMidi notaVazia = new NotasMidi();
			
			notaVazia.setInstanteFinal(lista.getFirst().getInstanteInicial());
			notaVazia.setDuracao();
			
			lista.addFirst(notaVazia);
		}
	}

	private static void escreverCabecalho (PrintWriter arquivo){
		arquivo.println("import sintese.Melodia;");
		arquivo.println("import sintese.Nota;\n");
		arquivo.println("public class BaseadoMidi {\n");
		
		arquivo.println("\tstatic Melodia 	 melodiaPrincipal;");
		arquivo.println("\tstatic Nota 	 nota;\n");
		
		arquivo.println("\tpublic BaseadoMidi (){");
		arquivo.println("\t\tmelodiaPrincipal = new Melodia();");
		arquivo.println("\t\tmelodiaPrincipal.setSeminima (1);");
		arquivo.println("\t\tmelodiaPrincipal.setAndamento (0.62f);");
		arquivo.println("\t}\n");
	}
	
	private static void escreverMelodia (PrintWriter arquivo){
		arquivo.println("\tpublic static Melodia padrao (){");
		arquivo.println("\t\tnew BaseadoMidi();\n");
		
		for (int indNota = 0; indNota < notasLidas.size(); indNota++){
			NotasMidi notaAtual = notasLidas.get(indNota);
			
			arquivo.print("\t\tnota = new Nota (");
			arquivo.print(notaAtual.getDuracao() + ", ");
			arquivo.print(notaAtual.getFrequencia() + ", ");
			arquivo.println(notaAtual.getAmplitude() + ");");
			arquivo.println("\t\tmelodiaPrincipal.addNota (nota);\n");
		}
		
		arquivo.println("\t\treturn melodiaPrincipal;");
		arquivo.println("\t}");
		arquivo.println("}");
	}
}