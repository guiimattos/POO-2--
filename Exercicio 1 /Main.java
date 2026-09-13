import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Curso> cursos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Criar Curso");
            System.out.println("2 - Criar Aluno");
            System.out.println("3 - Remover Aluno");
            System.out.println("4 - Mostrar Todos os Cursos");
            System.out.println("5 - Mostrar alunos do curso");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = lerInt();

            switch (opcao) {
                case 1:
                    criarCurso();
                    break;
                case 2:
                    criarAluno();
                    break;
                case 3:
                    removerAluno();
                    break;
                case 4:
                    mostrarCursos();
                    break;
                case 5:
                    mostrarAlunosDoCurso();
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

    private static void criarCurso() {
        System.out.print("Codigo do curso: ");
        int codigo = lerInt();
        System.out.print("Nome do curso: ");
        String nome = sc.nextLine();
        System.out.print("Carga horaria: ");
        int cargaHoraria = lerInt();

        cursos.add(new Curso(codigo, nome, cargaHoraria));
        System.out.println("Curso criado com sucesso!");
    }

    private static Curso escolherCurso() {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado!");
            return null;
        }
        System.out.println("Cursos disponiveis:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println(i + " - " + cursos.get(i).imprimir());
        }
        System.out.print("Escolha o curso (indice): ");
        int indice = lerInt();
        if (indice < 0 || indice >= cursos.size()) {
            System.out.println("Curso invalido!");
            return null;
        }
        return cursos.get(indice);
    }

    private static void criarAluno() {
        if (cursos.isEmpty()) {
            System.out.println("Cadastre um curso antes de criar um aluno!");
            return;
        }
        System.out.print("RA do aluno: ");
        String ra = sc.nextLine();
        System.out.print("Nome do aluno: ");
        String nome = sc.nextLine();

        Curso curso = escolherCurso();
        if (curso == null) {
            return;
        }
        curso.inserirAluno(new Aluno(ra, nome));
        System.out.println("Aluno criado e matriculado no curso " + curso.getNome() + "!");
    }

    private static void removerAluno() {
        Curso curso = escolherCurso();
        if (curso == null) {
            return;
        }
        if (curso.getAlunos().isEmpty()) {
            System.out.println("Este curso nao possui alunos!");
            return;
        }
        System.out.println(curso.imprimirCompleto());
        System.out.print("Indice do aluno a remover: ");
        int indice = lerInt();
        if (indice < 0 || indice >= curso.getAlunos().size()) {
            System.out.println("Indice invalido!");
            return;
        }
        curso.removerAluno(indice);
        System.out.println("Aluno removido com sucesso!");
    }

    private static void mostrarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado!");
            return;
        }
        System.out.println("\n--- Cursos ---");
        for (Curso curso : cursos) {
            System.out.println(curso.imprimir());
        }
    }

    private static void mostrarAlunosDoCurso() {
        Curso curso = escolherCurso();
        if (curso == null) {
            return;
        }
        System.out.println("\n" + curso.imprimirCompleto());
    }
}
