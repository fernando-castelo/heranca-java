package application;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Pessoa> list = new ArrayList<>();

        System.out.println("Digite quantos impostos serão calculados: ");
        int num = sc.nextInt();

        for(int i = 0; i < num; i++) {
            System.out.println("Dados do pagante de impostos #" + (i + 1) + ": ");
            System.out.println("Individuo ou Empresa (i/e) ?");
            char ch = sc.next().charAt(0);
            System.out.println("Nome: ");
            String nome = sc.next();
            System.out.println("Renda anual: ");
            Double rendaAnual = sc.nextDouble();
            if (ch == 'i') {
                System.out.println("Gastos com sáude: ");
                Double gastosSaude = sc.nextDouble();
                list.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
            } else {
                System.out.println("Número de Funcionarios: ");
                Integer numFuncionarios = sc.nextInt();
                list.add(new PessoaJuridica(nome, rendaAnual, numFuncionarios));
            }

        }

        System.out.println();
        System.out.println("Impostos Pagos: ");
        for(Pessoa pessoa : list){
            System.out.println(pessoa.getNome() + ": $" + String.format("%.2f", pessoa.imposto()));
        }

        int soma = 0;
        for(Pessoa pessoa : list){
             soma += pessoa.imposto();
        }

        System.out.println("Total de Impostos: " + soma);
        sc.close();
    }
}
