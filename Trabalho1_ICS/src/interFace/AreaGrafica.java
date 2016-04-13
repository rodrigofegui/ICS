/*	Pacote ao qual pertence */
package interFace;

/*	Importando APIs necessárias */
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class AreaGrafica implements ActionListener{
	JPanel painelPrincipal;
	JPanel painelProgresso;
	JPanel painelBotoes;
	TitledBorder tituloCaixaArquivo;
	ImageIcon icone;
	static JTextArea textoNomeArquivo;
	static JProgressBar barraDeProgresso;
	static JTextArea textoBarraDeProgresso;
	static JButton botaoTocar, botaoPausar, botaoParar;
	static JButton botaoAumentar, botaoDiminuir;
	
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
		barraDeProgresso.setStringPainted(false);
		
		textoBarraDeProgresso = new JTextArea ();
		textoBarraDeProgresso.setBackground (new Color(235, 235, 235));
		textoBarraDeProgresso.setEditable(false);
		
		painelProgresso.add(barraDeProgresso);
		painelProgresso.add(textoBarraDeProgresso);
		painelProgresso.add(Box.createRigidArea(new Dimension(0, 5)));
	}
	
	private void preparaPainelBotes() {
		painelBotoes = new JPanel(new GridLayout());
		Border caixaPrincipal = BorderFactory.createEmptyBorder(0,1,1,1);
		
		painelBotoes.setBorder(caixaPrincipal);
		painelBotoes.setBackground(new Color(130, 235, 235));
		painelBotoes.setMaximumSize(new Dimension(550, 40));
		painelPrincipal.add(painelBotoes);        
	}
	
	private void addBotoes(){
		/*	Aquisição do icone */
		icone = criarIcone("src/interFace/Icones/tocar.png");
		/*	Criando Botão de Tocar */
		botaoTocar = new JButton(icone);
		/*	Tirar borda */
		botaoTocar.setBorderPainted(false);
		/*	Tirar area pintada */
		botaoTocar.setContentAreaFilled(false);
		/*	Tirar destaque ao clicar */
		//botaoTocar.setFocusPainted(false);
		/*	Identificação da Ação a ser tomada */
        botaoTocar.setActionCommand("tocar");
        /*	Adicionando Ação ao botao */
		botaoTocar.addActionListener(this);
		/*	Adicionando ao painel */
		painelBotoes.add(botaoTocar);
		
		/*	Aquisição do icone */
		icone = criarIcone("src/interFace/Icones/pausar.png");
		/*	Criando Botão de Tocar */
		botaoPausar = new JButton(icone);
		/*	Tirar borda */
		botaoPausar.setBorderPainted(false);
		/*	Tirar area pintada */
		botaoPausar.setContentAreaFilled(false);
		/*	Tirar destaque ao clicar */
		//botaoPausar.setFocusPainted(false);
		/*	Identificação da Ação a ser tomada */
        botaoPausar.setActionCommand("pausar");
        /*	Adicionando Ação ao botao */
		botaoPausar.addActionListener(this);
		/*	Desativado */
		botaoPausar.setEnabled(false);
		/*	Adicionando ao painel */
		painelBotoes.add(botaoPausar);
		
		/*	Aquisição do icone */
		icone = criarIcone("src/interFace/Icones/parar.png");
		/*	Criando Botão de Tocar */
		botaoParar = new JButton(icone);
		/*	Tirar borda */
		botaoParar.setBorderPainted(false);
		/*	Tirar area pintada */
		botaoParar.setContentAreaFilled(false);
		/*	Tirar destaque ao clicar */
		//botaoParar.setFocusPainted(false);
		/*	Identificação da Ação a ser tomada */
        botaoParar.setActionCommand("parar");
        /*	Adicionando Ação ao botao */
		botaoParar.addActionListener(this);
		/*	Desativado */
		botaoParar.setEnabled(false);
		/*	Adicionando ao painel */
		painelBotoes.add(botaoParar);
		
		addEspacoVazio (2);
		
		/*	Aquisição do icone */
		icone = criarIcone("src/interFace/Icones/aumentar.png");
		/*	Criando Botão de Tocar */
		botaoAumentar = new JButton(icone);
		/*	Tirar borda */
		botaoAumentar.setBorderPainted(false);
		/*	Tirar area pintada */
		botaoAumentar.setContentAreaFilled(false);
		/*	Tirar destaque ao clicar */
		//botaoAumentar.setFocusPainted(false);
		/*	Identificação da Ação a ser tomada */
		botaoAumentar.setActionCommand("aumentar");
        /*	Adicionando Ação ao botao */
		botaoAumentar.addActionListener(this);
		/*	Adicionando ao painel */
		painelBotoes.add(botaoAumentar);
		
		addEspacoVazio (1);
		
		/*	Aquisição do icone */
		icone = criarIcone("src/interFace/Icones/diminuir.png");
		/*	Criando Botão de Tocar */
		botaoDiminuir = new JButton(icone);
		/*	Tirar borda */
		botaoDiminuir.setBorderPainted(false);
		/*	Tirar area pintada */
		botaoDiminuir.setContentAreaFilled(false);
		/*	Tirar destaque ao clicar */
		//botaoDiminuir.setFocusPainted(false);
		/*	Identificação da Ação a ser tomada */
		botaoDiminuir.setActionCommand("diminuir");
		/*	Adicionando ao painel */
		painelBotoes.add(botaoDiminuir);
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
	
	private void addEspacoVazio(int qnt) {
		for (int vz = 0; vz < qnt; vz++)
			painelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
	}
	
	protected ImageIcon criarIcone (String diretorio){
        ImageIcon imagem = new ImageIcon (diretorio);
        return imagem;
    }
	
	public void actionPerformed(ActionEvent evento) {
		if ("tocar".equals(evento.getActionCommand())){
			Comandos.tocarMusica();
		}else if ("pausar".equals(evento.getActionCommand())){
			Comandos.pausarMusica();
		}else if ("parar".equals(evento.getActionCommand())){
			Comandos.pararMusica();
		}
	}
}
