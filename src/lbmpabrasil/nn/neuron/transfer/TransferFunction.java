package lbmpabrasil.nn.neuron.transfer;

public interface TransferFunction {
	public void setAlpha(double alpha); // DEFINE O PARÂMETRO DE INCLINAÇÃO DA FUNÇÃO.
	public double getYk(double vk); // APLICA A FUNÇÃO DE TRANSFERÊNCIA. 
}
