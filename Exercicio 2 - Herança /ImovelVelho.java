public class ImovelVelho extends Imovel {
    private double valorDesconto;

    public ImovelVelho() {
    }

    public ImovelVelho(int codigo, String endereco, double valor, double valorDesconto) {
        super(codigo, endereco, valor);
        this.valorDesconto = valorDesconto;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double calcularValorImovel() {
        return getValor() - valorDesconto;
    }

    public String imprimir() {
        return "Codigo: " + getCodigo()
                + " - Endereco: " + getEndereco()
                + " - Tipo: Velho"
                + " - Valor: R$ " + getValor()
                + " - Desconto: R$ " + valorDesconto
                + " - Valor final: R$ " + calcularValorImovel();
    }
}
