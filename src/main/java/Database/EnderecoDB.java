package Database;

import Classes.Endereco;
import Classes.Tecnico;
import services.Conexao;

import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoDB extends Conexao {

    //Inserção dos endereços no DB
    public boolean insertEndereco(Endereco endereco) {
        connect();
        String sql = "INSERT INTO " +
                "endereco(estado_endereco,cidade_endereco,bairro_endereco,rua_endereco,numero_endereco,complemento_endereco) " +
                "VALUES (?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, endereco.getEstado_endereco());
            pst.setString(2, endereco.getCidade_endereco());
            pst.setString(3, endereco.getBairro());
            pst.setString(4, endereco.getRua());
            pst.setString(5, endereco.getNumero());
            pst.setString(6, endereco.getComplemento());
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

    //Pesquisar por endereços no DB
    public ArrayList<Endereco> researchEndereco(Endereco endereco){
        connect();
        ArrayList<Endereco> enderecos = new ArrayList<>();
        String sql = "SELECT * from endereco";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Endereco enderecoTemp = new Endereco(
                        result.getString("estado_endereco"),
                        result.getString("cidade_endereco"),
                        result.getString("bairro_endereco"),
                        result.getString("rua_endereco"),
                        result.getString("numero_endereco"),
                        result.getString("complemento_endereco")

                );
                //como puxar o nome da empresa?
                //System.out.println("Nome da empresa = " + result.getInt(""));//do banco
                System.out.println("Estado: " + enderecoTemp.getEstado_endereco());//do objeto
                System.out.println("Cidade: " + enderecoTemp.getCidade_endereco());
                System.out.println("Bairro: " + enderecoTemp.getBairro());
                System.out.println("Rua: " + enderecoTemp.getRua());
                System.out.println("Número: " + enderecoTemp.getNumero());
                System.out.println("Complemento: " + enderecoTemp.getComplemento());
                System.out.println("-------------------------------");
                enderecos.add(enderecoTemp);
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
        return enderecos;
    }
}
