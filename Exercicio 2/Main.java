import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Criar Pessoa");
            System.out.println("2 - Criar Automovel");
            System.out.println("3 - Transferir Automovel");
            System.out.println("4 - Mostrar Todas as Pessoas");
            System.out.println("5 - Mostrar automovel da pessoa");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = lerInt();

            switch (opcao) {
                case 1:
                    criarPessoa();
                    break;
                case 2:
                    criarAutomovel();
                    break;
                case 3:
                    transferirAutomovel();
                    break;
                case 4:
                    mostrarPessoas();
                    break;
                case 5:
                    mostrarAutomoveisDaPessoa();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 6);

        sc.close();
    }

    private static int lerInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Digite um numero valido: ");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine(); // consome a quebra de linha
        return valor;
    }

    private static void criarPessoa() {
        System.out.print("Codigo da pessoa: ");
        int codigo = lerInt();
        System.out.print("Nome da pessoa: ");
        String nome = sc.nextLine();

        pessoas.add(new Pessoa(codigo, nome));
        System.out.println("Pessoa criada com sucesso!");
    }

    private static Pessoa escolherPessoa(String mensagem) {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada!");
            return null;
        }
        System.out.println("Pessoas disponiveis:");
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println(i + " - " + pessoas.get(i).imprimir());
        }
        System.out.print(mensagem + " (indice): ");
        int indice = lerInt();
        if (indice < 0 || indice >= pessoas.size()) {
            System.out.println("Pessoa invalida!");
            return null;
        }
        return pessoas.get(indice);
    }

    private static void criarAutomovel() {
        if (pessoas.isEmpty()) {
            System.out.println("Cadastre uma pessoa antes de criar um automovel!");
            return;
        }
        System.out.print("Marca do automovel: ");
        String marca = sc.nextLine();
        System.out.print("Modelo do automovel: ");
        String modelo = sc.nextLine();

        Pessoa pessoa = escolherPessoa("Escolha o dono do automovel");
        if (pessoa == null) {
            return;
        }
        pessoa.inserirAutomovel(new Automovel(marca, modelo));
        System.out.println("Automovel criado e atribuido a " + pessoa.getNome() + "!");
    }

    private static void transferirAutomovel() {
        if (pessoas.size() < 2) {
            System.out.println("E necessario ter pelo menos duas pessoas cadastradas!");
            return;
        }

        Pessoa origem = escolherPessoa("Escolha a pessoa de ORIGEM");
        if (origem == null) {
            return;
        }
        if (origem.getAutomoveis().isEmpty()) {
            System.out.println("Esta pessoa nao possui automoveis!");
            return;
        }

        System.out.println(origem.imprimirCompleto());
        System.out.print("Escolha o automovel a transferir (indice): ");
        int indiceAuto = lerInt();
        if (indiceAuto < 0 || indiceAuto >= origem.getAutomoveis().size()) {
            System.out.println("Automovel invalido!");
            return;
        }

        Pessoa destino = escolherPessoa("Escolha a pessoa de DESTINO");
        if (destino == null) {
            return;
        }
        if (destino == origem) {
            System.out.println("A pessoa de destino deve ser diferente da origem!");
            return;
        }

        Automovel automovel = origem.getAutomoveis().get(indiceAuto);
        origem.removerAutomovel(indiceAuto);
        destino.inserirAutomovel(automovel);
        System.out.println("Automovel " + automovel.imprimir() + " transferido de "
                + origem.getNome() + " para " + destino.getNome() + "!");
    }

    private static void mostrarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada!");
            return;
        }
        System.out.println("\n--- Pessoas ---");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.imprimir());
        }
    }

    private static void mostrarAutomoveisDaPessoa() {
        Pessoa pessoa = escolherPessoa("Escolha a pessoa");
        if (pessoa == null) {
            return;
        }
        System.out.println("\n" + pessoa.imprimirCompleto());
    }
}
