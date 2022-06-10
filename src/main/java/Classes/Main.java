package Classes;


import Database.EmpresaDB;
import services.Conexao;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Empresa empresa = new Empresa(
                "gigabyte",
                "4545641550231321",
                "eletronico",
                5
        );

        EmpresaDB empresaDB = new EmpresaDB();

//        empresaDB.insertEmpresa(empresa);
        //empresaDB.researchEmpresaIds();
        System.out.println("Digite o numero da empresa que quer deletar");
        empresaDB.updateFkEmpresa(1, "numeroColaboradores_empresa", "15000");
        //Scanner
//        empresaDB.delete(1);


    }
}
