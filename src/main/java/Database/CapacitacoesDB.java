package Database;

import Classes.Capacitacoes;
import Classes.Servicos;
import services.Conexao;

import java.sql.SQLException;
import java.util.ArrayList;

public class CapacitacoesDB extends Conexao {

    //Inserção de capacitacoes no DB
    public static boolean insertCapacitacao(Capacitacoes capacitacao) {
        connect();
        String sql = "INSERT INTO " +
                "capacitacoes(idcapacitacoes,descricao_capacitacao,titulo_capacitacao,quantidadeHoras) " +
                "VALUES (?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, capacitacao.getDescricaoCapacitacao()); //Destinado ao id_tecnico
            pst.setString(2, capacitacao.getTituloCapacitacao()); //Destinado ao id_empresa
            pst.setInt(3, capacitacao.getQuantidadeHorasCapacitacao());

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

    //Procurando pelas capacitacoes
    public ArrayList<Capacitacoes> researchcapacitacao(){
        connect();
        ArrayList<Capacitacoes> capacitacao = new ArrayList<>();
        String sql = "SELECT * from Capacitacoes";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Capacitacoes capacitacaoTemp = new Capacitacoes(
                        result.getString("descricao_capacitacao"),//vem do banco
                        result.getString("titulo_capacitacao"),
                        result.getInt("quantidadeHoras_capacitacao")
                );

                System.out.println("id: " + result.getString("idcapacitacoes"));//do banco
                System.out.println(capacitacaoTemp.getTituloCapacitacao());//do objeto
                System.out.println("Descrição: " + capacitacaoTemp.getDescricaoCapacitacao());
                System.out.println("Quantidade de horas: " + capacitacaoTemp.getQuantidadeHorasCapacitacao());

                System.out.println("-------------------------------");
                capacitacao.add(capacitacaoTemp);
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
        return capacitacao;
    }

}
