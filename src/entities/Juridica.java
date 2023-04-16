package entities;

public class Juridica extends Contribuintes {

	private Integer numeroDeFuncionarios;

	public Juridica() {
		super();
	}

	public Juridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public double taxa() {
		if (this.numeroDeFuncionarios > 10) {
			return getRendaAnual() * 0.14;
		} else {
			return getRendaAnual() * 0.16;
		}
	}

	@Override
	public String toString() {
		return getNome() + ": R$ " + String.format("%.2f", taxa());
	}
}
