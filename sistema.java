import java.util.Scanner;

public class sistema{


    @SuppressWarnings("unused")
    private int id;
    @SuppressWarnings("unused")
    private String nome;
    @SuppressWarnings("unused")
    private String login;
    @SuppressWarnings("unused")
    private String senha;



public sistema (int id, String nome, String login, String senha) {
    this.id = id;
    this.nome = nome;
    this.login = login;
    this.senha = senha; 
}
  
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
       
        System.out.println("Bem vindo ao sistema!");
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        System.out.println("Senha:");
        String senha = scanner.nextLine();


        System.out.println("qual coluna deseja acessar? ");
        System.out.println("1 - Estoque");
        System.out.println("2 - Funcionario");
        System.out.println("3 - Cliente");
        System.out.println("4 - Produto");
        System.out.println("5 - Pagamento");
        

        System.out.println("Digite o numero da coluna:");
        int opcao = scanner.nextInt();

        switch (opcao) { 
            case 1:
            System.out.println("Voce acessou a coluna estoque");
                break;
            case 2:
            System.out.println("Voce acessou a coluna funcionario");
                break;
            case 3:
            System.out.println("Voce acessou a coluna cliente");
                break;
            case 4:
            System.out.println("Voce acessou a coluna produto");
                break;
            case 5:
            System.out.println("Voce acessou a coluna pagamento");
                break;
            default:
            System.out.println("A coluna inserida nao existe");
                break;
        }

        scanner.close();
        
    }
}
