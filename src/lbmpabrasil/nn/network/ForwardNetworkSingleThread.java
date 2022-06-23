package lbmpabrasil.nn.network;

import java.util.ArrayList;
import java.util.List;

public class ForwardNetworkSingleThread extends AbstractNeuronNetwork {
	@Override
	protected void process() {				
		List<Double> yk = new ArrayList<Double>();
		
		int fooCounter = 0;
		
		/*
		 *  PROCESSA A CAMADA DE ENTRADA. 
		 */		
		for(int it = 0; it < (int) this.config[1]; it++) {
			this.neurons[fooCounter].setInputs(this.inputs);			
			yk.add(this.neurons[fooCounter].getYk());
			fooCounter++;
		}
		
		for(int it1 = 2; it1 < (int) this.config.length; it1++) {
			double[] ykCopy = yk.stream().mapToDouble(Double::doubleValue).toArray();
			
			yk.clear();
			
			for(int it2 = 0; it2 < (int) this.config[it1]; it2++) {
				this.neurons[fooCounter].setInputs(ykCopy);
				yk.add(this.neurons[fooCounter].getYk());
				
				fooCounter++;
			}
		}
		
		this.outputs = yk.stream().mapToDouble(Double::doubleValue).toArray();	
	}
}