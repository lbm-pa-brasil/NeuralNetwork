package lbmpabrasil.nn.network;

import java.util.stream.DoubleStream;
import lbmpabrasil.nn.neuron.*;

public class ForwardNetworkSingleThread extends AbstractNeuronNetwork {
	@Override
	public void createNetwork(double[] config) {
		this.config = config;
		
		this.neurons = new Neuron[(int) DoubleStream.of(this.config).sum()];
		
		for(int it = 0; it < neurons.length; it++) 
			this.neurons[it] = new FixedBIASNeuron();
		
		
		
	}
}