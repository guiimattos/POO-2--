public class ImovelNovo extends Imovel {
    private double valorAdicional;

    public ImovelNovo() {
    }

    public ImovelNovo(int codigo, String endereco, double valor, double valorAdicional) {
        super(codigo, endereco, valor);
        this.valorAdicional = valorAdicional;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public double calcularValorImovel() {
        return getValor() + valorAdicional;
    }

    public String imprimir() {
        return "Codigo: " + getCodigo()
                + " - Endereco: " + getEndereco()
                + " - Tipo: Novo"
                + " - Valor: R$ " + getValor()
                + " - Valor adicional: R$ " + valorAdicional
                + " - Valor final: R$ " + calcularValorImovel();
    }
}
