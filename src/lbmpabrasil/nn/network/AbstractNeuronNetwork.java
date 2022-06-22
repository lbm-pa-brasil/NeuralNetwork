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
	
	protected abstract void process(); // PLACEHOLDER METHOD.
		
	public final double[] getOutputs() {
		this.process();
		
		return this.outputs;
	}
}