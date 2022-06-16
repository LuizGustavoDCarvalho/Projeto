package Classes;


import Database.*;
import services.Conexao;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Variáveis auxiliares e atributivas
        String auxNome;
        String tipoUsuario;
        int auxUsuario = 0;
        int idTecnico;
        int auxVaga;
        String auxProblema;
        String auxHora;
        String auxData;
        int auxIdEmpresa;

        String nomeCertificacao;
        String descricaoCertificacao;
        int qtdHorasCertificacao;

        String nomeTecnico;
        String cpfTecnico;

        String nomeEmpresa;
        String cnpjEmpresa;
        int auxFinaliza = 0;

        TecnicoDB tecnicoDB = new TecnicoDB();
        TecnicoDB tecnicoDB2 = new TecnicoDB();
        ServicosDB servicosDB = new ServicosDB();
        EmpresaDB empresaDB = new EmpresaDB();


            //Introdução do programa
            System.out.println("Digite seu nome ou nome do seu negócio:");
            auxNome = sc.nextLine();
            System.out.println("Você representa uma 'empresa' ou um você é 'tecnico'?");
            tipoUsuario = sc.nextLine();

        while(auxFinaliza == 0){
            //Direcionamento do tecnico para suas opções
            if (tipoUsuario.equals("tecnico")) {
                System.out.println("---------------------------");
                System.out.println("1 - Entrar");
                System.out.println("2 - Quero me cadastrar");
                System.out.println("---------------------------");
                auxUsuario = sc.nextInt();

                switch (auxUsuario) {
                    //Opção de entrar na conta/tecnico
                    case 1:
                        System.out.println("-------------------------------------");
                        System.out.println("Seja bem vindo, " + auxNome);
                        System.out.println("1 - Visualizar perfil");
                        System.out.println("2 - Buscar por chamados novos");
                        System.out.println("3 - Visualizar chamados  marcados");
                        System.out.println("4 - Adicionar certificação");
                        System.out.println("0 - Sair");
                        System.out.println("-------------------------------------");
                        auxUsuario = sc.nextInt();
                        sc.nextLine();

                        switch (auxUsuario) {

                            case 0:
                                auxFinaliza = 1;
                                break;

                            //1-Visualizar perfil
                            case 1:
                                System.out.println("---------------------------");
                                System.out.println("Qual o seu ID?");
                                System.out.println("---------------------------");
                                idTecnico = sc.nextInt();
                                tecnicoDB.researchTecnicos(idTecnico);
                                break;

                            //2-Buscar por chamados novos
                            case 2:
                                System.out.println("------/ Lista de chamados /----------");
                                servicosDB.researchServico();
                                System.out.println("Deseja se candidatar para qual vaga?");
                                auxVaga = sc.nextInt();
                                System.out.println("---------------------------");
                                System.out.println("Qual o seu ID?");
                                System.out.println("---------------------------");
                                idTecnico = sc.nextInt();
                                servicosDB.candidataServico(auxVaga, idTecnico);


                                break;

                            //3-Visualizar chamados marcados
                            case 3:
                                System.out.println("---------------------------");
                                System.out.println("Qual o seu ID?");
                                System.out.println("---------------------------");
                                idTecnico = sc.nextInt();
                                System.out.println("------/ Chamados marcados /----------");
                                servicosDB.researchServicoConfirmado(idTecnico);


                                System.out.println("-------------------------------------");
                                break;

                            //4-Adicionar certificação
                            case 4:
                                sc.nextLine();
                                System.out.println("-------------------------------------");
                                System.out.println("Digite o nome da certificação");
                                nomeCertificacao = sc.nextLine();
                                System.out.println("Digite a descrição da certificação");
                                descricaoCertificacao = sc.nextLine();
                                System.out.println("Digite a quantidade de horas do curso");
                                qtdHorasCertificacao = sc.nextInt();
                                System.out.println("-------------------------------------");
                                break;

                        }
                        break;

                    //Opção de cadastrar/tecnico
                    case 2:
                        System.out.println("-------------------------------------------------");
                        System.out.println("Digite seu nome completo");
                        nomeTecnico = sc.nextLine();
                        System.out.println("Digite seu CPF (incluir pontos e traços)");
                        cpfTecnico = sc.nextLine();
                        System.out.println("-------------------------------------------------");
                }
            }


            //Direcionamento da empresa para as sua opções
            else if (tipoUsuario.equals("empresa")) {
                System.out.println("---------------------------");
                System.out.println("1 - Entrar");
                System.out.println("2 - Quero me cadastrar");
                System.out.println("---------------------------");
                auxUsuario = sc.nextInt();


                switch (auxUsuario) {

                    //Opção de entrar na conta/empresa
                    case 1:
                        System.out.println("-------------------------------------");
                        System.out.println("Seja bem vindo, " + auxNome);
                        System.out.println("1 - Abrir chamado");
                        System.out.println("2 - Chamados abertos");
                        System.out.println("3 - Visualizar perfil");
                        System.out.println("-------------------------------------");
                        auxUsuario = sc.nextInt();
                        sc.nextLine();

                        switch (auxUsuario) {

                            case 1:

                                System.out.println("-------------------------------------");
                                System.out.println("Descreva seu problema: ");
                                auxProblema = sc.nextLine();
                                System.out.println("1 - Qual data?");
                                auxData = sc.nextLine();
                                System.out.println("2 - Qual horário?");
                                auxHora = sc.nextLine();
                                System.out.println("2 - Qual o ID da empresa?");
                                auxIdEmpresa = sc.nextInt();
                                System.out.println("3 - Pedido de chamado confirmado!");
                                System.out.println("-------------------------------------");

                                Servicos servicos = new Servicos(auxProblema,auxData, auxHora);
                                servicosDB.insertServico(servicos, auxIdEmpresa);

                                break;

                            case 2:
                                System.out.println("---------------------------");
                                System.out.println("Qual o seu ID?");
                                System.out.println("---------------------------");
                                auxIdEmpresa = sc.nextInt();
                                System.out.println("------/ Lista de chamados /----------");
                                servicosDB.researchChamadosConfirmado(auxIdEmpresa);



                                break;

                            case 3:
                                System.out.println("---------------------------");
                                System.out.println("Qual o seu ID?");
                                System.out.println("---------------------------");
                                int idEmpresa = sc.nextInt();
                                empresaDB.researchEmpresa(idEmpresa);

                                break;
                        }
                        break;

                    //Opção de cadastrar/ empresa
                    case 2:
                        System.out.println("-------------------------------------------------");
                        System.out.println("Digite o nome da empresa");
                        nomeEmpresa = sc.nextLine();
                        System.out.println("Digite o CNPJ (incluir pontos e traços)");
                        cnpjEmpresa = sc.nextLine();
                        System.out.println("Digite a categoria da empresa");
                        String categoriaEmpresa = sc.nextLine();
                        System.out.println("Digite o número de funcionários da empresa");
                        String numeroColaboradoresEmpresa = sc.nextLine();
                        System.out.println("-------------------------------------------------");



                        break;
                }
            }

            //Em caso de nome inválido
            else
                System.out.println("Nome inválido");
        }
    }
}
