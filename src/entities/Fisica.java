package entities;

public class Fisica extends Contribuintes {

	private Double gastosComSaude;

	public Fisica() {
		super();
	}

	public Fisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}

	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}

	@Override
	public double taxa() {
		if (getRendaAnual() <= 20000) {
			return getRendaAnual() * 0.15 - this.gastosComSaude * 0.5;
		} else {
			return getRendaAnual() * 0.25 - this.gastosComSaude * 0.5;
		}
	}

	@Override
	public String toString() {
		return getNome() + ": R$ " + String.format("%.2f", taxa());
	}

}
