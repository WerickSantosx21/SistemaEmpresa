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
    
        
estoque.add("XP Boost Bar - Chocolate branco, matcha e framboesa");
estoque.add("Mana Bar - Baunilha azul com spirulina e coco");
estoque.add("Critical Hit - Amendoim, caramelo salgado e whey isolado");
estoque.add("GG Easy - Cookies & Cream com biscoito");
estoque.add("Respawn Bar - Barra tropical sabor energético");


estoque.add("Potion Shake - Blueberry Blast");
estoque.add("Energy Respawn Drink - Sabor energético + cafeína natural");
estoque.add("Milkshake Pixelado - Algodão-doce e marshmallow");
estoque.add("Focus Shot - Cafeína + proteína hidrolisada + taurina");
estoque.add("Stream Fuel - Limão com hortelã");


estoque.add("Quest Cookies - Brownie com pedaços de chocolate");
estoque.add("Level Up Chips - Chips de frango barbecue");
estoque.add("Mana Gummies - Gummies proteicos sabor energético e melancia");
estoque.add("XP Crunch - Mix de nuts sabor cappuccino");
estoque.add("Ultra Boost Popcorn - Pipoca proteica caramelo salgado");

estoque.add("Respawn Ice Cream - Sorvete proteico sabor energético");
estoque.add("Critical Brownie - Brownie recheado de pasta de amendoim");
estoque.add("Buffed Donuts - Donuts de canela com chocolate zero");
estoque.add("Lootcake - Mini bolinhos de chocolate e morango");
estoque.add("Pixel Pudding - Pudim proteico tiramisù");


estoque.add("Cheat Day DLC - Barra triplo chocolate");
estoque.add("XP Mix - Pack de barrinhas variadas estilo loot box");
estoque.add("Limited Boss Edition - Shake com glitter (lichia + framboesa)");
estoque.add("Streamer’s Choice - Sabores exclusivos de streamers");
estoque.add("Esquiva Perfeita - Snack de queijo proteico apimentado");

        
funcionarios.add("Werick da Silva Santos");
funcionarios.add("Luiz Henrique Marques Miranda");
funcionarios.add("Bruna Gomes da Silva");
funcionarios.add("Kayo Lacerda Martins Lima");
funcionarios.add("Rodrigo Gonçalves Rocha");
funcionarios.add("Rodrigo Medeiros Fernandes");
funcionarios.add("Guilherme Expedito dos Santos");
funcionarios.add("Lucas Silva Duarte");
funcionarios.add("Thiago Antony Ferfoglia Rodrigues");
funcionarios.add("Rafael Augusto da Silva");

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
