package Classes;


import Database.*;
import services.Conexao;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Teste CRUD  de empresa. Status: ok
        Empresa empresa = new Empresa(
                "gigabyte",
                "4545641550231321",
                "eletronico",
                5
        );

        EmpresaDB empresaDB = new EmpresaDB();

        //empresaDB.insertEmpresa(empresa);
        //empresaDB.researchEmpresaIds();
        //System.out.println("Digite o numero da empresa que quer deletar");
        // empresaDB.updateFkEmpresa(1, "numeroColaboradores_empresa", "15000");
        // empresaDB.delete(1);


        //Testando CRUD de tecnicos. Status: ok
        Tecnico tecnico = new Tecnico("Estagiario","116.121.356-25",5.0);
        TecnicoDB tecnicoDB = new TecnicoDB();
        //tecnicoDB.insertTecnico(tecnico);
        //tecnicoDB.researchTecnico(tecnico);
        //tecnicoDB.researchTecnicoIds(tecnico);
        //tecnicoDB.updateFkTecnico(1,"nome_tecnico", "Jorgim");
        //tecnicoDB.deleteTecnico(3);


        //Testando CRUD de endereços. Status: ok
        Endereco endereco = new Endereco("Minas Gerais","Pouso Alegre","Recanto dos Fernandes","Rosa F. Barreiro","154","Bloco 2");
        EnderecoDB enderecoDB = new EnderecoDB();
        //enderecoDB.insertEndereco(endereco);
        //enderecoDB.researchEndereco(endereco);


        //Teste CRUD  de Serviços. Status: ok
        Servicos servico = new Servicos(
                "Formatação e instalção de SSD",
                "04/10/2022",
                "13:45"
        );
        ServicosDB servicoDB = new ServicosDB();
        ServicosDB.insertServico(servico);
        //empresaDB.researchEmpresaIds();
        //System.out.println("Digite o numero da empresa que quer deletar");
        // empresaDB.updateFkEmpresa(1, "numeroColaboradores_empresa", "15000");
        // empresaDB.delete(1);


        //Testando CRUD de capacitacoes. Status: ok
        Capacitacoes capacitacao= new Capacitacoes("Programador de java","Curso de programação",80);
        CapacitacoesDB capacitacoesDB = new CapacitacoesDB();
        enderecoDB.insertEndereco(endereco);
        //enderecoDB.researchEndereco(endereco);






        //Lógica de entrada de dados(Rascunho):
        // string categoria = cin()
        // switch(categoria)
        // 'nome':
        //      string nome = cin()
        //      updateFkEmpresa(1, 'categoria_empresa', nome);
        //      break;
    }
}
