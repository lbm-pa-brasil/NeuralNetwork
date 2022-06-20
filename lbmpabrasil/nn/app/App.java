package lbmpabrasil.nn.app;

import java.util.Random;

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
		
		((FixedBIASNeuron) neuron).setBIASWeight(1.0d);
		
		{
			double[] weights = new double[] {1.0d, 2.0d};
			neuron.setWeights(weights);
			
			double[] inputs = new double[] {1.0d, 2.0d};
			neuron.setInputs(inputs);
			
			System.out.println("Se tudo estiver certo, o valor 0.9975273768433653 deve aparecer no resultado!");
			System.out.println(neuron.getYk());
		}
		
		{	
			System.out.println("Testando a performance para grandes entradas...");	
			
			for(int step = 1; step < 1000000000; step *= 10) {
				double[] weights = new double[step];
				for(int it = 0; it < step; it++) 
					weights[it] = (new Random()).nextDouble();
				neuron.setWeights(weights);
				
				double[] inputs = new double[step];
				for(int it = 0; it < step; it++) 
					inputs[it] = (new Random()).nextDouble();
				neuron.setInputs(inputs);	
				
				long time = System.currentTimeMillis();
				double output = neuron.getYk();
				System.out.println(step + " iterações concluídas em " + (System.currentTimeMillis() - time) + " milissegundos.");
			}
		}
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	new App() {{ partida(); }};
	        }
	    });
	}

}
