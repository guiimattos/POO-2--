import java.util.ArrayList;

public class Pessoa {
    private int codigo;
    private String nome;
    private ArrayList<Automovel> automoveis;

    public Pessoa() {
        this.automoveis = new ArrayList<>();
    }

    public Pessoa(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.automoveis = new ArrayList<>();
    }

    public void inserirAutomovel(Automovel automovel) {
        automoveis.add(automovel);
    }

    public void removerAutomovel(int index) {
        if (index >= 0 && index < automoveis.size()) {
            automoveis.remove(index);
        }
    }

    public String imprimir() {
        return "Codigo: " + codigo + " - Nome: " + nome;
    }

    public String imprimirCompleto() {
        String texto = imprimir() + "\nAutomoveis:\n";
        if (automoveis.isEmpty()) {
            texto += "  (nenhum automovel)\n";
        } else {
            for (int i = 0; i < automoveis.size(); i++) {
                texto += "  " + i + " - " + automoveis.get(i).imprimir() + "\n";
            }
        }
        return texto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(ArrayList<Automovel> automoveis) {
        this.automoveis = automoveis;
    }
}
