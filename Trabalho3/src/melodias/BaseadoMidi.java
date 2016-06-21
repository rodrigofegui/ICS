package melodias;

import sintese.Melodia;
import sintese.Nota;

/**
 * Responsavel por armazenar os metodos Java criados
 * a partir de arquivos midi
 * @author	Helio Santana
 * @author	Rodrigo Guimaraes
 * @version	1.0
 * @since	14/06/2016
 */
public class BaseadoMidi{
	static Melodia 	 melodiaPrincipal;
	static Nota 	 nota;

	public BaseadoMidi (){
		melodiaPrincipal = new Melodia();
		melodiaPrincipal.setSeminima (1);
		melodiaPrincipal.setAndamento (0.62f);
	}

	public static Melodia theRainsOfCastamere (){
		new BaseadoMidi();

		nota = new Nota (2.0370934, 0.0, 0.0);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.6772628, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.0167782, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.3377471, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.0167785, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.3377471, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.6772628, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.6772628, 391.95715, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016778, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.6772623, 391.95715, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.6772623, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726326, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726326, 293.63608, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.7143555, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774662, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.6772623, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 466.11823, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726326, 391.95715, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 261.6, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 261.6, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726326, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 466.11823, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016777, 391.95715, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726326, 466.11823, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726326, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726326, 391.95715, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726326, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.035324, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016779, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016779, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 391.95715, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016779, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726326, 391.95715, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726326, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726326, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 293.63608, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.035324, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 261.6, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016777, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774948, 466.11823, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.0167809, 391.95715, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774948, 261.6, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726517, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726517, 466.11823, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016777, 391.95715, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 466.11823, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 391.95715, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.7143555, 293.63608, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726517, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774948, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774948, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 293.63608, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 293.63608, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726517, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774948, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.6958122, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726517, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774948, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774948, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 293.63608, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 391.95715, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016777, 293.63608, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016777, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 293.63608, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016777, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.035324, 293.63608, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 293.63608, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.677269, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.677269, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.677269, 391.95715, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.0167847, 293.63608, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.3377533, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016777, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 293.63608, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 439.957, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 391.95715, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 329.59537, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 349.19412, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.7143555, 293.63608, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.714356, 73.40902, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.7143564, 73.40902, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562937, 130.8, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562937, 195.97858, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562937, 87.29853, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562946, 130.8, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 87.29853, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 130.8, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.7143574, 97.98929, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.7143555, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 73.40902, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.035326, 146.81804, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 73.40902, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.035324, 146.81804, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 73.40902, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774757, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.035324, 146.81804, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 130.8, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 195.97858, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (2.035324, 261.6, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 87.29853, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 130.8, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726517, 174.59706, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562965, 130.8, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774948, 87.29853, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774948, 130.8, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726517, 174.59706, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 130.8, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 97.98929, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 146.81804, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 195.97858, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 164.79768, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016777, 73.40902, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 146.81804, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 146.81804, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.0167809, 73.40902, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774948, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562965, 146.81804, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.0167809, 73.40902, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774948, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 146.81804, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016777, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 164.79768, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 261.6, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016777, 73.40902, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 146.81804, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.0167809, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774948, 164.79768, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562965, 261.6, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562965, 219.9785, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.0167809, 116.52956, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 116.52956, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 233.05911, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 97.98929, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 146.81804, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 195.97858, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 116.52956, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 174.59706, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 233.05911, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.67726135, 164.79768, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016777, 73.40902, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.33774567, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 146.81804, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.016777, 116.52956, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.3377533, 116.52956, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.677269, 233.05911, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.677269, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.3377533, 97.98929, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.677269, 146.81804, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (0.3377533, 195.97858, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 116.52956, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 109.98925, 3.2125983);
		melodiaPrincipal.addNota (nota);

		nota = new Nota (1.3562927, 73.40902, 3.2125983);
		melodiaPrincipal.addNota (nota);


		return melodiaPrincipal;
	}

	public static Melodia gerenciador (String nome){
		if (nome.equals("theRainsOfCastamere"))
			return theRainsOfCastamere();
		else return null;
	}
}