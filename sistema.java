import java.util.Scanner;
import java.util.ArrayList;

public class sistema {
     
     private final String usuario = "Thiago F.";
     private final String senha ="061221";
    
     // Listas para cada coluna
    private ArrayList<String> estoque = new ArrayList<>();
    private ArrayList<String> funcionarios = new ArrayList<>();
    private ArrayList<String> clientes = new ArrayList<>();
    private ArrayList<String> produtos = new ArrayList<>();
    private ArrayList<String> pagamentos = new ArrayList<>();

    public sistema() {
    
        estoque.add("Barra de cereal");
        estoque.add("Energético");
        estoque.add("Água");
        estoque.add("Vitamina");
        
        funcionarios.add("Funcionario 1");
        clientes.add("Cliente 1");
        produtos.add("Produto X");
        pagamentos.add("Pagamento 1");
    }

    // Métodos listas
    private void mostrarLista(ArrayList<String> lista, String nomeLista) {
        System.out.println("Itens de " + nomeLista + ":");
        if(lista.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            for (String item : lista) {
                System.out.println("- " + item);
            }
        }
    }

      private boolean login (Scanner scanner) {
            System.out.println("Digite seu Login e Senha");
            System.out.print("Usuário: ");
            String user = scanner.nextLine();

            System.out.print("senha: ");
            String pass = scanner.nextLine();

            if(user.equals(usuario) && pass.equals(senha)){
                System.out.println("Login realizado com sucesso");
                return true;
            } else {
                System.out.println("Usuario ou senha incorretos");
                return false;
            }
        }


    private void adicionarItem(ArrayList<String> lista, String nomeLista, Scanner scanner) {
        scanner.nextLine(); // consumir Enter sobrando
        System.out.println("Digite o nome do item para adicionar em " + nomeLista + ":");
        String item = scanner.nextLine();
        lista.add(item);
        System.out.println("Item adicionado com sucesso!");
    }

    private void removerItem(ArrayList<String> lista, String nomeLista, Scanner scanner) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do item para remover de " + nomeLista + ":");
        String item = scanner.nextLine();
        if(lista.remove(item)) {
            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    // Menu  e o submenu
    private void submenu(ArrayList<String> lista, String nomeLista, Scanner scanner) {
        System.out.println("\nVocê acessou a coluna " + nomeLista);
        System.out.println("1 - Ver itens");
        System.out.println("2 - Adicionar item");
        System.out.println("3 - Remover item");
        System.out.print("Escolha a opção: ");
        int opcao = scanner.nextInt();

        switch(opcao) {
            case 1:
                mostrarLista(lista, nomeLista);
                break;
            case 2:
                adicionarItem(lista, nomeLista, scanner);
                break;
            case 3:
                removerItem(lista, nomeLista, scanner);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    // Menu principal
    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);

        //login sistema
        while (true) {
            if(login(scanner)){
                break;
            }
            System.out.println("Tente novamente.\n");
        }

        System.out.println("Bem-vindo ao sistema!");

        while(true) {
            System.out.println("\nQual coluna deseja acessar?");
            System.out.println("1 - Estoque");
            System.out.println("2 - Funcionários");
            System.out.println("3 - Clientes");
            System.out.println("4 - Produtos");
            System.out.println("5 - Pagamentos");
            System.out.println("0 - Sair");
            System.out.print("Digite o número da coluna: ");
            int opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    submenu(estoque, "Estoque", scanner);
                    break;
                case 2:
                    submenu(funcionarios, "Funcionários", scanner);
                    break;
                case 3:
                    submenu(clientes, "Clientes", scanner);
                    break;
                case 4:
                    submenu(produtos, "Produtos", scanner);
                    break;
                case 5:
                    submenu(pagamentos, "Pagamentos", scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Coluna inválida!");
            }
        }
    }

    public static void main(String[] args) {
        sistema s = new sistema();
        s.menuPrincipal();
    }
}
