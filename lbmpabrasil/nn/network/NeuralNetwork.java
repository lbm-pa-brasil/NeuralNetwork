package lbmpabrasil.nn.network;

public interface NeuralNetwork {
	/*
	 *  CRIA A REDE NO FORMATO m-h-...-h-q ADQUIRIDO NO VETOR config ONDE:
	 *  m REPRESENTA O NÚMERO DE ENTRADAS;
	 *  h REPRESENTA O NÚMERO NEURÔNIOS EM CAMADAS OCULTAS;
	 *  q REPRESENTA O NÚMERO DE SAÍDAS.
	 */
	public void createNetwork(double[] config);	
	public void getOutputs();
}