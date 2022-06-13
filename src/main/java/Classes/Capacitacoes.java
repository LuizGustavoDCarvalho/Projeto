package Classes;

public class Capacitacoes {

    private String descricaoCapacitacao;
    private String tituloCapacitacao;
    private int quantidadeHorasCapacitacao;

    //Construtor
    public Capacitacoes(String descricaoCapacitacao, String tituloCapacitacao, int quantidadeHorasCapacitacao) {
        this.descricaoCapacitacao = descricaoCapacitacao;
        this.tituloCapacitacao = tituloCapacitacao;
        this.quantidadeHorasCapacitacao = quantidadeHorasCapacitacao;
    }

    //Getter's e Setter's
    public String getDescricaoCapacitacao() {return descricaoCapacitacao;}
    public void setDescricaoCapacitacao(String descricaoCapacitacao) {this.descricaoCapacitacao = descricaoCapacitacao;}
    public String getTituloCapacitacao() {return tituloCapacitacao;}
    public void setTituloCapacitacao(String tituloCapacitacao) {this.tituloCapacitacao = tituloCapacitacao;}
    public int getQuantidadeHorasCapacitacao() {return quantidadeHorasCapacitacao;}
    public void setQuantidadeHorasCapacitacao(int quantidadeHorasCapacitacao) {this.quantidadeHorasCapacitacao = quantidadeHorasCapacitacao;}
}
