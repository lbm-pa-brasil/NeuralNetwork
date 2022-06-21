package lbmpabrasil.nn.network;

import lbmpabrasil.nn.neuron.*;

public abstract class AbstractNeuronNetwork implements NeuralNetwork {		
	protected Neuron neurons[];	
	protected double[] inputs;
	protected double[] outputs;
	protected double[] config;
	
	public final void setInputs(double[] inputs) {
		this.inputs = inputs;
	}
		
	public final double[] getOutputs() {
		return this.outputs;
	}
}