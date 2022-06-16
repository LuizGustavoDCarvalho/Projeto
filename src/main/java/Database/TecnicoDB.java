package Database;

import Classes.Tecnico;
import services.Conexao;

import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class TecnicoDB extends Conexao {

    //Inserção dos tecnicos no DB
    public boolean insertTecnico(Tecnico tecnico) {
        connect();
        String sql = "INSERT INTO " +
                "tecnico(nome_tecnico,cpf_tecnico, avaliacao_tecnico) " +
                "VALUES (?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, tecnico.getNomeTecnico());
            pst.setString(2, tecnico.getCpfTecnico());
            pst.setDouble(3, tecnico.getAvaliacaoTecnico());
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

    //Pesquisar por tecnicos no DB
    public ArrayList<Tecnico> researchTecnicos(int idTecnico){
        connect();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        String sql = "SELECT * from tecnico";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                if(idTecnico == result.getInt("id_tecnico")) {
                    Tecnico tecnicoTemp = new Tecnico(
                            result.getString("nome_tecnico"),
                            result.getString("cpf_tecnico"),
                            result.getDouble("avaliacao_tecnico")

                    );
                    System.out.println("-------------------------------");
                    System.out.println("Código do tecnico = " + result.getInt("id_tecnico"));//do banco
                    System.out.println("Nome da tecnico = " + tecnicoTemp.getNomeTecnico());//do objeto
                    System.out.println("CPF do tecnico = " + tecnicoTemp.getCpfTecnico());
                    System.out.println("Avaliação do tecnico = " + tecnicoTemp.getAvaliacaoTecnico());
                    System.out.println("-------------------------------");
                    tecnicos.add(tecnicoTemp);
                }
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
        return tecnicos;
    }


    //Função para mostrar o menu somente com opções de nome e código do tecnico
    public ArrayList<Tecnico> researchTecnicoIds(Tecnico tecnico){
        connect();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        String sql = "SELECT * from tecnico";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){


                System.out.println("Código do tecnico = " + result.getInt("id_tecnico"));
                System.out.println("Nome do tecnico = " + result.getString("nome_tecnico"));
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
        return tecnicos;
    }

    //Editando tecnicos no DB
    public boolean updateFkTecnico(int idTecnico, String atributo, String novoValor ){
        connect();
        String sql = "UPDATE Tecnico SET " + atributo + "=? WHERE id_tecnico=?";

        try{
            pst = connection.prepareStatement(sql);

            if(atributo == "avaliacao_tecnico"){
                pst.setDouble(1, parseDouble(novoValor));
            }else {
                pst.setString(1, novoValor);
            }
            pst.setInt(2, idTecnico);
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

    //Deletando tecnicos no DB
    public boolean deleteTecnico(int idTecnico){
        connect();
        String sql = "DELETE FROM tecnico WHERE id_tecnico=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idTecnico);
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

    //Procurar tecnico pelo ID
    public boolean researchTecnico(int idTecnico){
        connect();
        String sql = "SELECT *FROM tecnico WHERE id_tecnico=?";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            pst = connection.prepareStatement(sql);
            pst.setInt(1,idTecnico);
            pst.execute();


            while(result.next()){


                System.out.println("Código do tecnico = " + result.getInt("id_tecnico"));
                System.out.println("Nome do tecnico = " + result.getString("nome_tecnico"));
                System.out.println("-------------------------------");

            }

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


}
