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
		if(config.length < 3) {
			System.out.println("Error during the Network create process.\nThe minimal configuration is m-h-q ou m-h-...-h-q!\nAborting...");
			System.exit(-1);
		}
		
		this.config = config;
		
		int sizeOfNeuronsVector = (int) (DoubleStream.of(this.config).sum() -  this.config[0]);		
		this.neurons = new Neuron[sizeOfNeuronsVector];		
		for(int it = 0; it < sizeOfNeuronsVector; it++) {
			this.neurons[it] = new FixedBIASNeuron();
			this.neurons[it].setTransferFunction(tf);	
			((FixedBIASNeuron) this.neurons[it]).setBIASWeight(1.0d);
		}
		
		/*
		 *  CRIA A CAMADA DE ENTRADA DA REDE.
		 */
		int sizeOfInputNodes = (int) config[0];
		this.inputs = new double[sizeOfInputNodes]; 
		for(int it = 0; it < sizeOfInputNodes; it++) 
			this.inputs[it] = 0.0d;	
		
		/*
		 *  CRIA A CAMADA DE SAÍDA DA REDE.
		 */
		int sizeOfOutputs = (int) config[config.length - 1];
		this.outputs = new double[sizeOfOutputs]; 
		for(int it = 0; it < (int) config[config.length - 1]; it++) 
			this.outputs[it] = 0.0d;		
		
		/*
		 *  CONFIGURA OS NEURÔNIOS.
		 */	
		int fooCounter = 0;
		for(int it1 = 1; it1 < this.config.length; it1++) {
			for(int it2 = 0; it2 < (int) this.config[it1]; it2++) {				
				int sizeOfInput = (int) this.config[it1 - 1];
				
				double[] weights = new double[sizeOfInput];
				for(int it3 = 0; it3 < sizeOfInput; it3++) 
					weights[it3] = (new Random()).nextDouble();
				
				double[] inputs = new double[sizeOfInput];
				for(int it4 = 0; it4 < sizeOfInput; it4++) 
					inputs[it4] = 0.0d; 
				
				this.neurons[fooCounter].setInputs(inputs);
				this.neurons[fooCounter].setWeights(weights);
				
				fooCounter++;
			}
		}
	}	
	
	protected abstract void process(); // PLACEHOLDER METHOD. NEGÓCIO DELEGADO PARA CLASSE FILHA.
		
	public final double[] getOutputs() {
		this.process();
		
		return this.outputs;
	}
}