package Database;

import Classes.Empresa;
import services.Conexao;

import java.sql.SQLException;

public class EmpresaDB extends Conexao {

    //Inserção das empresa no DB
    public boolean insertAluno(Empresa empresa){
        connect();
        String sql = "INSERT INTO empresa(nomeEmpresa,cnpjEmpresa,categoriaEmpresa,numeroColaboradoresEmpresa) VALUES (?,?,?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, empresa.getNomeEmpresa());
            pst.setString(2,empresa.getCnpjEmpresa());
            pst.setString(3,empresa.getCategoriaEmpresa());
            pst.setInt(4,empresa.getNumeroColaboradoresEmpresa());
            pst.execute();
            check = true;
        }
        catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}
