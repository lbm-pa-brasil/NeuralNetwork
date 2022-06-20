package lbmpabrasil.nn.app;

import javax.swing.SwingUtilities;

import lbmpabrasil.nn.neuron.*;
import lbmpabrasil.nn.neuron.transfer.*;

/*
 *  CLASSE App MOSTRA O MODO DE USO TÍPICO. 
 *  USE ESSA CLASSE COMO PONTO DE PARTIDA.
 */
public class App {	
	public void partida() {		
		TransferFunction tf = new SigmoidFunction();
		tf.setAlpha(1.0d);
		
		Neuron neuron = new FixedBIASNeuron();
		neuron.setTransferFunction(tf);
		
		double[] weights = new double[] {1.0d, 2.0d};
		neuron.setWeights(weights);
		
		double[] inputs = new double[] {1.0d, 2.0d};
		neuron.setInputs(inputs);	
		
		((FixedBIASNeuron) neuron).setBIASWeight(1.0d);
		
		System.out.println("Se tudo estiver certo, o valor 0.9975273768433653 deve aparecer no resultado!");
		System.out.println(neuron.getYk());
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	new App() {{ partida(); }};
	        }
	    });
	}

}
