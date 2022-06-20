package lbmpabrasil.nn.neuron;

import lbmpabrasil.nn.neuron.transfer.TransferFunction;

public abstract class AbstractNeuron implements Neuron {	
	protected double[] inputs;
	protected double[] weights;
	protected TransferFunction tf;
	
	public final void setInputs(double[] inputs) {
		this.inputs = inputs;
	}
	
	public final void setWeights(double[] weights) {
		this.weights = weights;
	}
	
	public final double[] getWeights() {
		return this.weights;
	}
	
	public final void setTransferFunction(TransferFunction tf) {
		this.tf = tf;
	}
}