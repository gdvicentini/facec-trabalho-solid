package trabalho_solid;

import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;


public class ExecutarMenu {
    private int opcaoMenuPrincipal = 0;
    private int opcaoCadastro = 0;
    private int opcaoAcesso = 0;
    private static int opcaoAcao = 0;
    private String cpf="";
    private String senha="";
    private String nome="";
    private String conta = "";
    private static Double valor = 0.0;

    static Scanner scan = new Scanner(System.in);
    static Scanner scan2 = new Scanner(System.in);
    static Scanner scan3 = new Scanner(System.in);
    Random random = new Random();

    Hashtable<String, PessoaFisica> cliente = new Hashtable<String, PessoaFisica>();
    Hashtable<String, ContaCorrente> contaCorrente = new Hashtable<String, ContaCorrente>();
    Hashtable<String, ContaPoupanca> contaPoupanca = new Hashtable<String, ContaPoupanca>();

    public void Executar() {
        
        while(opcaoMenuPrincipal != 3) {
            System.out.println("-------------------------------");
            System.out.println("MENU BANCO ONLINE");
            System.out.println("-------------------------------");
            System.out.println("Selecione umas das opções abaixo: ");
            System.out.println("1 - Efetuar Cadastro\n" + "2 - Acessar Conta\n" + "3 - Finalizar aplicativo\n");

            System.out.print("Digite a opção escolhida: ");
            opcaoMenuPrincipal = scan.nextInt();


            switch (opcaoMenuPrincipal) {
                case 1:
                    OpcaoCadastro();
                    break;

                case 2:
                    OpcaoAcesso();
                    break;

                case 3:
                    System.out.println("Finalizando o programa...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            
                default:
                    System.out.println("Opção Inválida!");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
    }

    public void OpcaoCadastro() {

        System.out.println("-------------------------------");
        System.out.println("MENU BANCO ONLINE - Tela de Cadastro");
        System.out.println("-------------------------------");
        System.out.println("Selecione umas das opções abaixo: ");
        System.out.println("1 - Cadastrar Pessoa Física\n" + "2 - Cadastrar Conta Corrente\n" 
            + "3 - Cadastrar Conta Poupança\n" + "4 - Voltar");
        
        System.out.print("Digite a opção escolhida: ");
        opcaoCadastro = scan.nextInt();

        switch (opcaoCadastro) {
            case 1:
                System.out.println("Informe abaixo os dados necessários:");
                System.out.print("Nome: ");
                nome = scan2.nextLine();
                System.out.print("CPF: ");
                cpf = scan3.nextLine();
                
                cliente.put(cpf, new PessoaFisica(cpf, nome));

                System.out.println("Cadastro realizado com sucesso!");
                break;
            
            case 2:
                System.out.println("Para efetuar o cadastro, é necessário primeiramente validar seu CPF.");
                System.out.print("CPF: ");
                cpf = scan2.nextLine();

                if(!cliente.containsKey(cpf)){
                    System.out.println("CPF Inválido!");
                    break;
                }
                System.out.println("CPF válido!");

                System.out.println("Dados da sua agência e conta gerado com sucesso");
                System.out.print("Agência: 123");

                int contaNum = random.nextInt(6);
                String conta = Integer.toString(contaNum);

                System.out.print("Conta: " + conta);

                System.out.println("Defina sua senha: ");
                senha = scan3.nextLine();

                contaCorrente.put(conta, new ContaCorrente(conta, senha));
                break;
            
            case 3:
                System.out.println("Para efetuar o cadastro, é necessário primeiramente validar seu CPF.");
                System.out.print("CPF: ");
                cpf = scan2.nextLine();

                if(!cliente.containsKey(cpf)){
                    System.out.println("CPF Inválido!");
                    break;
                }
                System.out.println("CPF válido!");

                System.out.println("Dados da sua agência e conta gerado com sucesso");
                System.out.print("\nAgência: 123");

                contaNum = random.nextInt(6);
                conta = Integer.toString(contaNum);

                System.out.print("\nConta: " + conta);

                System.out.println("\nDefina sua senha: ");
                senha = scan3.nextLine();

                contaPoupanca.put(conta, new ContaPoupanca(conta, senha));
                break;
            
            case 4:
                Executar();
                break;
            
            default:
                System.out.println("Opcção Invalida!\n");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
        }
    }

    public void OpcaoAcesso() {
        System.out.println("-------------------------------");
        System.out.println("MENU BANCO ONLINE - Tela de Acesso");
        System.out.println("-------------------------------");
        System.out.println("Selecione umas das opções abaixo: ");
        System.out.println("1 - Acessar Conta Corrente\n" + "2 - Acessar Conta Poupança\n" 
            + "3 - Voltar");
        
        System.out.print("Digite a opção escolhida: ");
        opcaoAcesso = scan.nextInt();

        switch (opcaoAcesso) {
            case 1:
                System.out.println("Para acessar sua conta, informe o numero da sua conta cadastrada.");
                System.out.print("Conta: ");
                conta = scan2.nextLine();

                if(!contaCorrente.containsKey(conta)) {
                    System.out.println("Conta Invalida!");
                    break;
                }
                
                System.out.println("-------------------------------");
                System.out.println("MENU BANCO ONLINE - Conta Corrente Acessada");
                System.out.println("-------------------------------");
                
                AbstractConta contaCorrenteConsulta = contaPoupanca.get(conta);

                realizarAcao(contaCorrenteConsulta);

                break;

            case 2:
                System.out.println("Para acessar sua conta, informe o numero da sua conta cadastrada.");
                System.out.print("Conta: ");
                conta = scan2.nextLine();

                if(!contaCorrente.containsKey(conta)) {
                    System.out.println("Conta Invalida!");
                    break;
                }
                
                System.out.println("-------------------------------");
                System.out.println("MENU BANCO ONLINE - Conta Poupança Acessada");
                System.out.println("-------------------------------");
            
                AbstractConta contaPoupancaConsulta = contaPoupanca.get(conta);

                realizarAcao(contaPoupancaConsulta);
                break;
            
            case 3:
                Executar();
                break;

            default:
                System.out.println("Opção Inválida!");
                break;
        }
    }

    public static void realizarAcao(AbstractConta conta) {
        Scanner scan4 = new Scanner(System.in);

        System.out.println("Selecione a ação que gostaria de executar: ");
        System.out.println("1 - Realizar saque\n" + "2 - Realizar depósito\n" 
            + "3 - Realizar transferência\n" + "4 - Verificar saldo");
        
            opcaoAcao = scan.nextInt();

            switch (opcaoAcao) {
                case 1:
                    System.out.print("Informe o valor que gostaria de sacar:");
                    valor = scan4.nextDouble();
                    conta.sacar(valor);

                    System.out.println("Seu saldo atualmente é de: " + conta.getSaldo());
                    break;

                case 2:
                    System.out.print("Informe o valor que gostaria de depositar:");
                    valor = scan4.nextDouble();
                    conta.depositar(valor);

                    System.out.println("Seu saldo atualmente é de: " + conta.getSaldo());
                    break;

                case 3:
                    System.out.print("Informe o valor que gostaria de transferir:");
                    valor = scan4.nextDouble();
                    conta.transferir(valor);

                    System.out.println("Seu saldo atualmente é de: " + conta.getSaldo());
                    break;

                case 4:
                    System.out.print("O seu saldo atual é de: " + conta.getSaldo());
                    
                    break;
                
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        
    }
}