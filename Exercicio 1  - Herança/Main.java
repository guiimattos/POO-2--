import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Inserir funcionario");
            System.out.println("2 - Exibir funcionarios");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Numero do cracha: ");
                int numeroCracha = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Setor: ");
                String setor = sc.nextLine();

                System.out.print("Funcao: ");
                String funcao = sc.nextLine();

                System.out.println("O funcionario e mensalista ou horista?");
                System.out.println("1 - Mensalista");
                System.out.println("2 - Horista");
                System.out.print("Escolha: ");
                int tipo = sc.nextInt();
                sc.nextLine();

                if (tipo == 1) {
                    System.out.print("Salario: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();

                    FuncionarioMensalista mensalista =
                            new FuncionarioMensalista(numeroCracha, nome, setor, funcao, salario);
                    funcionarios.add(mensalista);
                    System.out.println("Funcionario mensalista inserido com sucesso!");
                } else if (tipo == 2) {
                    System.out.print("Quantidade de horas: ");
                    int qtdeHoras = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Valor da hora: ");
                    double valorHora = sc.nextDouble();
                    sc.nextLine();

                    FuncionarioHorista horista =
                            new FuncionarioHorista(numeroCracha, nome, setor, funcao, qtdeHoras, valorHora);
                    funcionarios.add(horista);
                    System.out.println("Funcionario horista inserido com sucesso!");
                } else {
                    System.out.println("Tipo invalido! Funcionario nao inserido.");
                }
            } else if (opcao == 2) {
                if (funcionarios.size() == 0) {
                    System.out.println("Nenhum funcionario cadastrado!");
                } else {
                    System.out.println("\n--- Funcionarios ---");
                    for (int i = 0; i < funcionarios.size(); i++) {
                        Funcionario funcionario = funcionarios.get(i);
                        if (funcionario instanceof FuncionarioMensalista) {
                            FuncionarioMensalista mensalista = (FuncionarioMensalista) funcionario;
                            System.out.println(mensalista.imprimir());
                        } else {
                            FuncionarioHorista horista = (FuncionarioHorista) funcionario;
                            System.out.println(horista.imprimir());
                        }
                    }
                }
            } else if (opcao == 3) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opcao invalida!");
            }
        } while (opcao != 3);

        sc.close();
    }
}
