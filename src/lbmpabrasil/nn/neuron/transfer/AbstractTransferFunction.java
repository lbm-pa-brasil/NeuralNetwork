package lbmpabrasil.nn.neuron.transfer;

public abstract class AbstractTransferFunction implements TransferFunction {
	protected double alpha = 0.0d;
	
	public final void setAlpha(double alpha) {
		this.alpha = alpha;
	}	
}
