package lbmpabrasil.nn.neuron.transfer;

public class SigmoidFunction extends AbstractTransferFunction {
	public final double getYk(double vk) {
		return 1.0d / (1.0d + Math.exp(- this.alpha * vk));
	}
}
