package Database;

import Classes.Servicos;
import Classes.Tecnico;
import services.Conexao;

import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class ServicosDB extends Conexao {


    //Inserção dos serviços no DB
    public static boolean insertServico(Servicos servico, int id_Empresa) {
        connect();
        String sql = "INSERT INTO " +
                "serviços(descricao_servico,data_servico,hora_servico, Empresa_id_empresa, Tecnico_id_tecnico) " +
                "VALUES (?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, servico.getDescricao_servico());
            pst.setString(2, servico.getData());
            pst.setString(3, servico.getHora());
            pst.setInt(4, id_Empresa);
            pst.setNull(5,1);

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

    //Procurando serviços pelo numero
    public ArrayList<Servicos> researchServico(){
        connect();
        ArrayList<Servicos> servicos = new ArrayList<>();
        String sql = "SELECT * from Serviços";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Servicos servicoTemp = new Servicos(
                        result.getString("descricao_servico"),//vem do banco
                        result.getString("data_servico"),
                        result.getString("hora_servico")
                );

                System.out.println("Número do atendimento: " + result.getInt("numero_serviços"));//do banco
                System.out.println("Descrição do trabalho: " + servicoTemp.getDescricao_servico());//do objeto
                System.out.println("Data: " + servicoTemp.getData());
                System.out.println("Horário: " + servicoTemp.getHora());

                System.out.println("-------------------------------");
                servicos.add(servicoTemp);
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
        return servicos;
    }

    //Editando serviços no DB
    public boolean updateFkServico(int numero_servicos, String atributo, String novoValor ){
        connect();
        String sql = "UPDATE Servicos SET " + atributo + "=? WHERE numero_serviços=?";

        try{
            pst = connection.prepareStatement(sql);


            pst.setString(1, novoValor);
            pst.setInt(2, numero_servicos);
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

    //Deletando serviços no DB
    public boolean deleteServico(int numero_servicos){
        connect();
        String sql = "DELETE FROM serviços WHERE numero_serviços=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,numero_servicos);
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

//    //Função para se candidatar em serviço
//    public void candidataServico(Servicos servicos, int auxVaga){
//        ArrayList<Servicos> servicosConfirmados = new ArrayList<>();
//        connect();
//        String sql = "INSERT INTO " +
//                "serviços(descricao_servico,data_servico,hora_servico) " +
//                "VALUES (?,?,?)";
//
//        try{
//            statement = connection.createStatement();
//            result = statement.executeQuery(sql);
//            pst = connection.prepareStatement(sql);
//
//            while(result.next()){
//                if(auxVaga == result.getInt("numero_serviços")) {
//
//                    Servicos servicoTemp = new Servicos(
//                    pst.setString(1, servicos.getDescricao_servico());
//                    pst.setString(2, servicos.getData());
//                    pst.setString(3, servicos.getHora());
//
//                    pst.execute();
//                    check = true;
//
//                    System.out.println("-------------------------------");
//                    System.out.println("Chamado confirmado!");
//                    System.out.println("Código do tecnico = " + result.getInt("numero_serviços"));//do banco
//                    System.out.println("Descrição do chamado = " + servicoTemp.getDescricao_servico());//do objeto
//                    System.out.println("Data do chamado = " + servicoTemp.getData());
//                    System.out.println("Horário do chamado = " + servicoTemp.getHora());
//                    System.out.println("-------------------------------");
//                }
//            }
//        }catch(SQLException e){
//            System.out.println("Erro de operação: " + e.getMessage());
//        }
//    }

}
