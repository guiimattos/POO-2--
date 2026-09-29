import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Inserir imovel");
            System.out.println("2 - Exibir imoveis");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Codigo: ");
                int codigo = sc.nextInt();
                sc.nextLine();

                System.out.print("Endereco: ");
                String endereco = sc.nextLine();

                System.out.print("Valor: ");
                double valor = sc.nextDouble();
                sc.nextLine();

                System.out.println("O imovel e novo ou velho?");
                System.out.println("1 - Novo");
                System.out.println("2 - Velho");
                System.out.print("Escolha: ");
                int tipo = sc.nextInt();
                sc.nextLine();

                if (tipo == 1) {
                    System.out.print("Valor adicional: ");
                    double valorAdicional = sc.nextDouble();
                    sc.nextLine();

                    ImovelNovo novo = new ImovelNovo(codigo, endereco, valor, valorAdicional);
                    imoveis.add(novo);
                    System.out.println("Imovel novo inserido com sucesso!");
                } else if (tipo == 2) {
                    System.out.print("Valor do desconto: ");
                    double valorDesconto = sc.nextDouble();
                    sc.nextLine();

                    ImovelVelho velho = new ImovelVelho(codigo, endereco, valor, valorDesconto);
                    imoveis.add(velho);
                    System.out.println("Imovel velho inserido com sucesso!");
                } else {
                    System.out.println("Tipo invalido! Imovel nao inserido.");
                }
            } else if (opcao == 2) {
                if (imoveis.size() == 0) {
                    System.out.println("Nenhum imovel cadastrado!");
                } else {
                    System.out.println("\n--- Imoveis ---");
                    for (int i = 0; i < imoveis.size(); i++) {
                        Imovel imovel = imoveis.get(i);
                        if (imovel instanceof ImovelNovo) {
                            ImovelNovo novo = (ImovelNovo) imovel;
                            System.out.println(novo.imprimir());
                        } else {
                            ImovelVelho velho = (ImovelVelho) imovel;
                            System.out.println(velho.imprimir());
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
