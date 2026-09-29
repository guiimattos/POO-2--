public class FuncionarioMensalista extends Funcionario {
    private double salario;

    public FuncionarioMensalista() {
    }

    public FuncionarioMensalista(int numeroCracha, String nome, String setor, String funcao, double salario) {
        super(numeroCracha, nome, setor, funcao);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String imprimir() {
        return "Cracha: " + getNumeroCracha()
                + " - Nome: " + getNome()
                + " - Setor: " + getSetor()
                + " - Funcao: " + getFuncao()
                + " - Tipo: Mensalista"
                + " - Salario: R$ " + salario;
    }
}
