package Classes;

public class Endereco {

    private String estado_endereco;
    private String cidade_endereco;
    private String Bairro;
    private String rua;
    private String numero;
    private String complemento;

    //Construtor
    public Endereco(String estado_endereco, String cidade_endereco, String bairro, String rua,String numero, String complemento) {
        this.estado_endereco = estado_endereco;
        this.cidade_endereco = cidade_endereco;
        Bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;

    }

    //Getters e Setters
    public String getEstado_endereco() {return estado_endereco;}
    public void setEstado_endereco(String estado_endereco) {this.estado_endereco = estado_endereco;}
    public String getCidade_endereco() {return cidade_endereco;}
    public void setCidade_endereco(String cidade_endereco) {this.cidade_endereco = cidade_endereco;}
    public String getBairro() {return Bairro;}
    public void setBairro(String bairro) {Bairro = bairro;}
    public String getRua() {return rua;}
    public void setRua(String rua) {this.rua = rua;}public String getComplemento() {return complemento;}
    public String getNumero() {return numero;}
    public void setNumero(String numero) {this.numero = numero;}
    public void setComplemento(String complemento) {this.complemento = complemento;}
}
