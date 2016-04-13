/*	Pacote ao qual pertence */
package interFace;

/*	Importando APIs necessárias */
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AreaGrafica implements ActionListener, ChangeListener{
	JPanel painelPrincipal;
	JPanel painelProgresso;
	JPanel painelBotoes;
	TitledBorder tituloCaixaArquivo;
	ImageIcon icone;
	final static int volumeInicial = 64;
	static JTextArea textoNomeArquivo = null;
	static JProgressBar barraDeProgresso = null;
	static JTextArea textoBarraDeProgresso = null;
	static JButton botaoTocar = null, botaoPausar = null, botaoParar = null, botaoVolume = null;
	static JButton textoVolume = null;
	static JSlider controleVolume = null;
	
	public JPanel criarPlanoDeConteudo() {
		/*	Preparação para o incremento das informações gráficas */
		preparaPainelPrincipal();
		
		/*	Adicionando nome do arquivo */
		addCaixaArquivo();
		
		/*	Preparando a barra de progresso */
		preparaPainelProgresso ();
		
		/*	Adicionando a barra de progresso */
		addBarraProgresso ();
		
		/*	Preparando os botoes */
		preparaPainelBotes();
		
		/*	Adicionando os botoes */
		addBotoes();
		
		return painelPrincipal;
	}

	private void preparaPainelPrincipal() {
		/*	Criando o painel de conteúdo principal */
		painelPrincipal = new JPanel ();
		/*	Configuração do layout para "crescer" no eixo Y */
        painelPrincipal.setLayout (new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setOpaque (true);
        
        /*	Criando e configurando caixa principal */
        Border caixaPrincipal = BorderFactory.createEmptyBorder (2,10,10,10);
        painelPrincipal.setBorder (caixaPrincipal);
	}
	
	private void addCaixaArquivo(){
		/*	Criando caixa em baixo relevo */
		Border caixaArquivo = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		/*	Criando título da caixa */
        tituloCaixaArquivo = BorderFactory.createTitledBorder(caixaArquivo, "Nome do Arquivo:");
        /*	Adicionando a caixa com título */
        addCompABorda (tituloCaixaArquivo, "", painelPrincipal);
        
        /*	Adicionaod espaçamento para o próximo painel */
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
	}

	private void preparaPainelProgresso(){
		/*	Criando painel para a barra de progresso */
		painelProgresso = new JPanel ();
		/*	Configuração do layout para "crescer" no eixo Y */
		painelProgresso.setLayout(new BoxLayout(painelProgresso, BoxLayout.Y_AXIS));
		painelProgresso.setOpaque (true);
		
		/*	Configurando o tamanho máximo */
		painelProgresso.setMaximumSize(new Dimension(550, 30));
		
		/*	Adicionando ao painel principal */
		painelPrincipal.add(painelProgresso);
	}
	
	private void addBarraProgresso() {
		barraDeProgresso = new JProgressBar(0, 100);
		barraDeProgresso.setPreferredSize(new Dimension(400,10));
		barraDeProgresso.setFocusable(false);
		barraDeProgresso.setStringPainted(false);
		
		textoBarraDeProgresso = new JTextArea ();
		textoBarraDeProgresso.setBackground (new Color(235, 235, 235));
		textoBarraDeProgresso.setEditable(false);
		
		painelProgresso.add(barraDeProgresso);
		painelProgresso.add(textoBarraDeProgresso);
		painelProgresso.add(Box.createRigidArea(new Dimension(0, 5)));
	}
	
	private void preparaPainelBotes() {
		painelBotoes = new JPanel (new FlowLayout());
		Border caixaPrincipal = BorderFactory.createEmptyBorder(1,1,1,1);
		
		painelBotoes.setBorder(caixaPrincipal);
		painelBotoes.setBackground(new Color(235, 235, 235));
		painelBotoes.setMaximumSize(new Dimension(550, 55));
		painelPrincipal.add(painelBotoes);        
	}
	
	private void addBotoes(){
		botaoTocar = criarBotao ("tocar", true, false);
		
		botaoPausar = criarBotao ("pausar", true, false);
		
		botaoParar = criarBotao ("parar", true, false);
		
		addEspacoVazio (115);
		
		botaoVolume = criarVolume ("volume_médio");
		
		controleVolume = sliderVolume (0, 127, volumeInicial);
		
		textoVolume = criarTextoVolume ();
		
		Comandos.controleVolume();
	}

	void addCompABorda(Border borda, String descricao, Container destino){
        /*	Criando Caixa */
		JPanel caixa = new JPanel (new GridLayout (1, 1), false);
       
		/*	Configuração da área de texto */
		textoNomeArquivo = new JTextArea();
		textoNomeArquivo.setBackground(new Color(235, 235, 235));
		textoNomeArquivo.setText(descricao);
		textoNomeArquivo.setEditable(false);
        caixa.add(textoNomeArquivo);
        caixa.setBorder(borda);
        
        caixa.setMaximumSize (new Dimension(550, 40));
        destino.add(Box.createRigidArea(new Dimension(0, 10)));
        destino.add(caixa);
    }
	
	private void addEspacoVazio(int largura) {
		painelBotoes.add(Box.createRigidArea(new Dimension(largura, 50)));
	}
		
	protected ImageIcon criarIcone (String diretorio){
        ImageIcon imagem = new ImageIcon (diretorio);
        return imagem;
    }
	
	private JButton criarBotao (String descricao, boolean acao, boolean ativacao){
		String nomeIcone = "Icones/" + descricao + ".png";
		
		/*	Aquisição do icone */
		icone = criarIcone(nomeIcone);
		/*	Criando Botão de Tocar */
		JButton novo = new JButton(icone);
		/*	Redimensioar botão */
		novo.setPreferredSize(new Dimension(32, 32));
		/*	Tirar borda */
		novo.setBorderPainted(false);
		/*	Tirar area pintada */
		novo.setContentAreaFilled(false);
		/*	Tirar destaque ao clicar */
		//novo.setFocusPainted(false);
		
		if (acao){
			/*	Identificação da Ação a ser tomada */
	        novo.setActionCommand(descricao);
	        /*	Adicionando Ação ao botao */
			novo.addActionListener(this);
		}
		
		/*	Desativado */
		novo.setEnabled(ativacao);
		/*	Adicionando ao painel */
		painelBotoes.add(novo);
		
		return novo;
	}
	
	private JButton criarVolume (String descricao){
		String nomeIcone = "Icones/" + descricao + ".png";
		
		/*	Aquisição do icone */
		icone = criarIcone(nomeIcone);
		/*	Criando Botão de Tocar */
		JButton novo = new JButton(icone);
		/*	Redimensioar botão */
		novo.setPreferredSize(new Dimension(32, 32));
		/*	Tirar borda */
		novo.setBorderPainted(false);
		/*	Tirar area pintada */
		novo.setContentAreaFilled(false);
		/*	Tirar destaque ao clicar */
		//novo.setFocusPainted(false);
		/*	Adicionando ao painel */
		painelBotoes.add(novo);
		
		return novo;
	}
	
	private JSlider sliderVolume (int min, int max, int inicio){
		/*	Criando Controle de volume por Slider */
		JSlider novo = new JSlider(JSlider.HORIZONTAL, min, max, inicio);
		/*	Configurando o tamanho */
		novo.setSize(new Dimension(110, 45));
		/*	Configurando Traços de intervalos menores */
		novo.setMinorTickSpacing(21);
		/*	Configurando Traços de intervalos maiores */
		novo.setMajorTickSpacing(42);
		/*	Marcando os traços */
		novo.setPaintTicks(true);
		/*	Mostrando Identificações */
		novo.setPaintLabels(true);
		/*	Criando Identificações */
		novo.setLabelTable(novo.createStandardLabels(42));
		/*	Adicionando ação */
		novo.addChangeListener(this);
		/*	Adicionando ao painel */
		painelBotoes.add(novo);
		
		return novo;
	}
	
	private JButton criarTextoVolume (){
		JButton nova = new JButton();
		
		/*	Redimensioar area do texto */
		nova.setPreferredSize (new Dimension(25, 45));
		/*	Tirar borda */
		nova.setBorderPainted(false);
		/*	Tirar area pintada */
		nova.setContentAreaFilled(false);
		/*	Configuração do alinhamento do texto */
		nova.setHorizontalAlignment(SwingConstants.LEFT);
		/*	Configuração do tamanho da fonte */
		nova.setFont(nova.getFont().deriveFont(10));
		/*	Retirando borda interna */
		nova.setBorder (null);
		/*	Adicionando ao painel */
		painelBotoes.add(nova);
		
		return nova;
	}
	
	public void actionPerformed(ActionEvent evento) {
		if ("tocar".equals(evento.getActionCommand()))
			Comandos.tocarMusica();
		else if ("pausar".equals(evento.getActionCommand()))
			Comandos.pausarMusica();
		else if ("parar".equals(evento.getActionCommand()))
			Comandos.pararMusica();
	}
	
	public void stateChanged(ChangeEvent event){
		int atual = controleVolume.getValue();
		
		if (atual == 0)
			icone = criarIcone("Icones/volume_mudo.png");
		else if (atual < 42)
			icone = criarIcone("Icones/volume_baixo.png");
		else if (atual < 84)
			icone = criarIcone("Icones/volume_médio.png");
		else
			icone = criarIcone("Icones/volume_alto.png");
		
		/*	Configurando o ícone do botão */
		botaoVolume.setIcon(icone);
		
		Comandos.controleVolume();
    }
}
