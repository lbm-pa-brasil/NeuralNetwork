package lbmpabrasil.nn.neuron;
import lbmpabrasil.nn.neuron.transfer.TransferFunction;

public interface Neuron {
	public void setInputs(double[] es); // DEFINE AS ENTRADAS DO NEURÔNIO. 
	public double[] getInputs();
	public void setWeights(double[] weights); // DEFINE OS PESOS EM UM VETOR.
	public double[] getWeights(); // RETORNA OS PESOS EM UM VETOR.
	public void setTransferFunction(TransferFunction tf); // DEFINE A FUNÇÃO DE TRANSFERÊNCIA DO NEURÔNIO.
	public double getYk(); // PROCESSA O COMBINADOR LINEAR E A FUNÇÃO DE ATIVAÇÃO.	
}