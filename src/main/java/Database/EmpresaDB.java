package Database;

import Classes.Empresa;
import services.Conexao;

import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class EmpresaDB extends Conexao {

    //Inserção das empresa no DB
    //-Alterar o x = 1 por endereco, quando tiver endereco
    // C - Create
    public boolean insertEmpresa(Empresa empresa) {
        connect();
        String sql = "INSERT INTO " +
                "empresa(nome_empresa,cnpj_empresa,categoria_empresa,numeroColaboradores_empresa,Endereco_id_endereco) " +
                "VALUES (?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, empresa.getNomeEmpresa());
            pst.setString(2, empresa.getCnpjEmpresa());
            pst.setString(3, empresa.getCategoriaEmpresa());
            pst.setInt(4, empresa.getNumeroColaboradoresEmpresa());
            pst.setInt(5,1 );
            pst.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    //Pesquisar por empresas no DB
    public ArrayList<Empresa> researchEmpresa(){
        connect();
        ArrayList<Empresa> empresas = new ArrayList<>();
        String sql = "SELECT * from empresa";

            try{
                statement = connection.createStatement();
                result = statement.executeQuery(sql);

                while(result.next()){
                    Empresa empresaTemp = new Empresa(
                            result.getString("nome_empresa"),//vem do banco
                            result.getString("cnpj_empresa"),
                            result.getString("categoria_empresa"),
                            result.getInt("numeroColaboradores_empresa")
                    );

                    System.out.println("Código da empresa = " + result.getInt("id_empresa"));//do banco
                    System.out.println("Nome da empresa = " + empresaTemp.getNomeEmpresa());//do objeto
                    System.out.println("CNPJ da empresa = " + empresaTemp.getCnpjEmpresa());
                    System.out.println("Categoria = " + empresaTemp.getCategoriaEmpresa());
                    System.out.println("Número de funcionários = " + empresaTemp.getNumeroColaboradoresEmpresa());
                    System.out.println("-------------------------------");
                    empresas.add(empresaTemp);
                }
            }catch(SQLException e){
                System.out.println("Erro de operação: " + e.getMessage());
            }
            finally {
                try{
                    connection.close();
                    statement.close();
                    result.close();
                }
                catch (SQLException e){
                    System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
            return empresas;
        }

    //Função para mostrar o menu somente com opções de nome e código da empresa
    public ArrayList<Empresa> researchEmpresaIds(){
        connect();
        ArrayList<Empresa> empresas = new ArrayList<>();
        String sql = "SELECT * from empresa";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){


                System.out.println("Código da empresa = " + result.getInt("id_empresa"));//do banco
                System.out.println("Nome da empresa = " + result.getString("nome_empresa"));//do objeto
                System.out.println("-------------------------------");

            }
        }catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return empresas;
    }
//    updateFkEmpresa(1, 'categoria_empresa', 'tech');
//    updateFkEmpresa(1, 'nome_empresa', 'ronaldo');
//    updateFkEmpresa(1, 'numeroColaboradores_empresa', '50');

    // string categoria = cin()
    // switch(categoria)
    // 'nome':
    //      string nome = cin()
    //      updateFkEmpresa(1, 'categoria_empresa', nome);
    //      break;

    //Editando empresas no DB
    public boolean updateFkEmpresa(int idEmpresa, String atributo, String novoValor ){
        connect();
        String sql = "UPDATE Empresa SET " + atributo + "=? WHERE id_empresa=?";

        try{
            pst = connection.prepareStatement(sql);

            if(atributo == "numeroColaboradores_empresa"){
                pst.setInt(1, parseInt(novoValor));
            }else {
                pst.setString(1, novoValor);
            }
            pst.setInt(2, idEmpresa);
            pst.execute();
            check = true;
        }catch (SQLException e){
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

    public boolean deleteFkEmpresa(int idEmpresa){

    }
}

