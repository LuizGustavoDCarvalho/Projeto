package Classes;

public class Servicos {

    private String descricao_servico;
    private String data;
    private String hora;

    //Construtor
    public Servicos(String descricao_servico, String data, String hora) {
        this.descricao_servico = descricao_servico;
        this.data = data;
        this.hora = hora;
    }

    //Getter's e Setter's
    public String getDescricao_servico() {return descricao_servico;}
    public void setDescricao_servico(String descricao_servico) {this.descricao_servico = descricao_servico;}
    public String getData() {return data;}
    public void setData(String data) {this.data = data;}
    public String getHora() {return hora;}
    public void setHora(String hora) {this.hora = hora;}
}
