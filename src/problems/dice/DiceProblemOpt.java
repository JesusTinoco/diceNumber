package problems.dice;

import java.util.HashSet;
import java.util.Set;

public class DiceProblemOpt implements IDiceProblem {

	//Numero total de dados
	private int diceNumber;
	//Numero de caras de cada dado
	private int faces;
	//Numero de bandejas que el sistema tiene (unid, dec, cent..)
	private int trays;

	private int resultado;

	public DiceProblemOpt(){
	}

	@Override
	public void setData(int diceNumber, int faces, int trays) {
		if(diceNumber < 1 || faces < 1 || trays < 1)
			throw new IllegalArgumentException();
		this.diceNumber = diceNumber;
		this.faces = faces;
		this.trays = trays;
	}

	@Override
	public void run() {

		/* Todos los resultados posibles de X*10^r sin repetir
		 * Ejemplo: 1 dado, 2 caras, 2 bandejas:
		 * 			[0, 1, 2, 20, 21]
		 */

		if(trays == 1){
			resultado = diceNumber * faces + 1;			
		}else{

			Set<Integer> lcombinaciones = new HashSet<Integer>();
			for(int tray = 0; tray<trays; tray++){
				for(int face = 0; face<=faces; face++){
					lcombinaciones.add(ponderacion(face, tray));
				}
			}


			Set<Integer> lcomb = new HashSet<Integer>();
			lcomb.addAll(lcombinaciones);

			/* Combinaciones posibles de todos los dados
			 * X*10^r + X*10^r + X*10^r ....
			 */
			for(int i = 1; i < diceNumber; i++){
				Set<Integer> aux = new HashSet<Integer>();
				for(Integer num1: lcombinaciones){
					for(Integer num2: lcomb){
						aux.add(num1 + num2);
					}
				}
				lcomb.addAll(aux);
			}

			/* Comprobar que entero i falta en el conjunto que contiene todas las combinaciones
		   posibles de todos los dados.
			 */
			for(int i = 0; i<lcomb.size(); i++){
				if(!lcomb.contains(i)){
					resultado = i;
					break;
				}
			}

		}

	}

	@Override
	public int getResult() {
		return resultado;
	}

	public int combinaciones(){
		return diceNumber * faces * trays;
	}

	public Integer ponderacion(Integer face, Integer tray){
		return face * (int)(Math.pow(10, tray));
	}

}
