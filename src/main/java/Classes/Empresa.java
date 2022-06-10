package Classes;

public class Empresa {

    private int id;
    private String nomeEmpresa;
    private String cnpjEmpresa;
    private String categoriaEmpresa;
    private int numeroColaboradoresEmpresa;

    //Construtor
    public Empresa(int id, String nomeEmpresa, String cnpjEmpresa, String categoriaEmpresa, int numeroColaboradoresEmpresa) {
        this.id = id;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpjEmpresa = cnpjEmpresa;
        this.categoriaEmpresa = categoriaEmpresa;
        this.numeroColaboradoresEmpresa = numeroColaboradoresEmpresa;
    }


    //Getter's e Setter's
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNomeEmpresa() {return nomeEmpresa;}
    public void setNomeEmpresa(String nomeEmpresa) {this.nomeEmpresa = nomeEmpresa;}
    public String getCnpjEmpresa() {return cnpjEmpresa;}
    public void setCnpjEmpresa(String cnpjEmpresa) {this.cnpjEmpresa = cnpjEmpresa;}
    public String getCategoriaEmpresa() {return categoriaEmpresa;}
    public void setCategoriaEmpresa(String categoriaEmpresa) {this.categoriaEmpresa = categoriaEmpresa;}
    public int getNumeroColaboradoresEmpresa() {return numeroColaboradoresEmpresa;}
    public void setNumeroColaboradoresEmpresa(int numeroColaboradoresEmpresa) {this.numeroColaboradoresEmpresa = numeroColaboradoresEmpresa;}
}
