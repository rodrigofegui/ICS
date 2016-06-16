/**
 * Responsavel por armazenar as notas lidas no arquivo midi,
 * antes de passa-las a uma classe Java
 * @author Helio Santana
 * @author Rodrigo Guimaraes
 */
public class NotasMidi {
	int amplitude;
	float frequencia;
	float instanteInicial, instanteFinal;
	float duracao;
	
	public static final float f_0 = 8.175f;
	
	public NotasMidi (){
		this.amplitude = 0;
		this.frequencia = 0f;
		this.instanteFinal = 0f;
		this.instanteInicial = 0f;
		this.duracao = 0f;
	}
	
	public void setAmplitude (int amplitude){
		this.amplitude = amplitude;
	}
	
	public int getAmplitude (){
		return this.amplitude;
	}
	
	public void setFrequencia (float frequencia){
		this.frequencia = frequencia;
	}
	
	public void setFrequencia (int indice){
		this.frequencia = (float)(f_0 * Math.pow(2, (double)indice/12));
	}
	
	public float getFrequencia (){
		return this.frequencia;
	}
	
	public void setInstanteInical (float instanteInicial){
		this.instanteInicial = instanteInicial;
	}
	
	public void setInstanteInicial (float instanteFinal, float duracao){
		this.instanteInicial = instanteFinal - duracao;
	}
	
	public float getInstanteInicial (){
		return this.instanteInicial;
	}
	
	public void setInstanteFinal (float instanteFinal){
		this.instanteFinal = instanteFinal;
	}
	
	public void setInstanteFinal (float instanteInicial, float duracao){
		this.instanteFinal = instanteInicial + duracao;
	}
	
	public float getInstanteFinal (){
		return this.instanteFinal;
	}
	
	public void setDuracao (){
		this.duracao = this.instanteFinal - this.instanteInicial;
	}
	
	public void setDuracao (float duracao){
		this.duracao = duracao;
	}
	
	public void setDuracao (float instanteInicial, float instanteFinal){
		this.duracao = instanteFinal - instanteInicial;
	}
	
	public float getDuracao (){
		return this.duracao;
	}

	public String toString (){
		String descricao = "Nota formada:\n";
		
		descricao += "\tFreq = " + this.getFrequencia() + "\n";
		
		descricao += "\tAmpli = " + this.getAmplitude() + "\n";
		
		descricao += "\tDuracao = " + this.getDuracao() + "\n";
		
		descricao += "\tInst. Inicial = " + this.getInstanteInicial() + "\n";
		
		descricao += "\tInst. Final = " + this.getInstanteFinal() + "\n\n";
		
		return descricao;
	}
}
