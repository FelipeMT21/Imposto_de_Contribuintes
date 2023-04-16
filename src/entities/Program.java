package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Contribuintes> list = new ArrayList<>();

		System.out.print("Digite o número de contribuintes: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Dados do contribuinte nº " + i + ":");
			System.out.print("Pessoa Física ou Jurídic (f/j)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Renda Anual: ");
			double rendaAnual = sc.nextDouble();

			if (ch == 'f') {
				System.out.print("Gastos com Saúde: ");
				double gastosComSaude = sc.nextDouble();
				list.add(new Fisica(nome, rendaAnual, gastosComSaude));
			} else if (ch == 'j') {
				System.out.print("Número de Funcionários: ");
				int numeroDeFuncionarios = sc.nextInt();
				list.add(new Juridica(nome, rendaAnual, numeroDeFuncionarios));
			}
		}

		double sum = 0.0;
		System.out.println();
		System.out.println("IMPOSTOS PAGOS:");
		for (Contribuintes cb : list) {
			System.out.println(cb);
			sum += cb.taxa();
		}

		System.out.println();
		System.out.println("IMPOSTOS TOTAIS: R$ " + String.format("%.2f", sum));

		sc.close();
	}

}
