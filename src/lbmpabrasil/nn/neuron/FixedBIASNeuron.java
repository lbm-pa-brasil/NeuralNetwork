package lbmpabrasil.nn.neuron;

public class FixedBIASNeuron extends AbstractNeuron {	
	private double biasWeight;
	private final double inputBIAS = 1.0d;
	
	public final void setBIASWeight(double biasWeight) {
		this.biasWeight = biasWeight;
	}
	
	@Override
	public double getYk() {		
		double vk = 0.0d;
		
		for(int it = 0; it < this.inputs.length; it++) 
			vk += this.inputs[it] * this.weights[it];		
		
		return this.tf.getYk(vk + this.inputBIAS * this.biasWeight);
	}
}