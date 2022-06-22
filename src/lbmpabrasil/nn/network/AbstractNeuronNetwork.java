package lbmpabrasil.nn.network;

import java.util.Random;
import java.util.stream.DoubleStream;

import lbmpabrasil.nn.neuron.FixedBIASNeuron;
import lbmpabrasil.nn.neuron.Neuron;
import lbmpabrasil.nn.neuron.transfer.TransferFunction;

public abstract class AbstractNeuronNetwork implements NeuralNetwork {		
	protected Neuron neurons[];	
	protected double[] inputs;
	protected double[] outputs;
	protected double[] config;
	
	public final void setInputs(double[] inputs) {
		this.inputs = inputs;
	}
	
	public final void createNetwork(TransferFunction tf, double[] config) {
		this.config = config;
		
		this.neurons = new Neuron[(int) DoubleStream.of(this.config).sum() - 1];
		
		/*
		 *  CRIA A CAMADA DE ENTRADA DA REDE.
		 */
		this.inputs = new double[(int) config[0]]; 
		for(int it = 0; it < (int) config[0]; it++) 
			this.inputs[it] = 0.0d;
		
		/*
		 *  CRIA AS CAMADAS RESTANTES.
		 */
		for(int it = 1; it < config.length; it++) {
			this.neurons[it] = new FixedBIASNeuron(); // FUTURAMENTE, DELEGAR PARA UMA FACTORY A CRIAÇÃO, PASSANDO O TIPO DE NEURÔNIO.
			this.neurons[it].setTransferFunction(tf);			
			((FixedBIASNeuron) this.neurons[it]).setBIASWeight(1.0d);
			
			double[] inputs = new double[(int) config[it - 1]];
			double[] weights = new double[(int) config[it - 1]];
			
			for(int it1 = 0; it1 < (int) config[it - 1]; it1++) {
				inputs[it] = 0.0d;
				weights[it] = (new Random()).nextDouble();
			}
			
			this.neurons[it].setInputs(inputs);	
			this.neurons[it].setWeights(weights);
		}
		
		
		... PAREI AQUI ...
		
		
		
		
	}	
	
	protected abstract void process(); // PLACEHOLDER METHOD. NEGÓCIO DELEGADO PARA CLASSE FILHA.
		
	public final double[] getOutputs() {
		this.process();
		
		return this.outputs;
	}
}