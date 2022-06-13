package Classes;

public class Tecnico {

    //Atributos do tecnico
    private String nomeTecnico;
    private String cpfTecnico;
    private double avaliacaoTecnico;

    //Construtor
    public Tecnico(String nomeTecnico, String cpfTecnico, double avaliacaoTecnico) {
        this.nomeTecnico = nomeTecnico;
        this.cpfTecnico = cpfTecnico;
        this.avaliacaoTecnico = avaliacaoTecnico;
    }

    //Getter's e Setter's
    public String getNomeTecnico() {return nomeTecnico;}
    public void setNomeTecnico(String nomeTecnico) {this.nomeTecnico = nomeTecnico;}
    public String getCpfTecnico() {return cpfTecnico;}
    public void setCpfTecnico(String cpfTecnico) {this.cpfTecnico = cpfTecnico;}
    public double getAvaliacaoTecnico() {return avaliacaoTecnico;}
    public void setAvaliacaoTecnico(double avaliacaoTecnico) {this.avaliacaoTecnico = avaliacaoTecnico;}
}
