import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> epis = new ArrayList<>();
    static ArrayList<String> funcionarios = new ArrayList<>();
    static ArrayList<String> emprestimos = new ArrayList<>();
    static ArrayList<String> logOperacoes = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("=== Sistema de Gerenciamento ===");
            System.out.println("1. Módulo de EPIs");
            System.out.println("2. Módulo de Funcionários");
            System.out.println("3. Módulo de Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    executarModulo("EPIs", epis);
                    break;
                case 2:
                    executarModulo("Funcionários", funcionarios);
                    break;
                case 3:
                    executarModulo("Empréstimos", emprestimos);
                    break;
                case 0:
                    System.out.println("Saindo... Obrigado por utilizar o sistema!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        // Exibe log final (desafio extra)
        System.out.println("\n=== Log de Operações ===");
        for (String log : logOperacoes) {
            System.out.println(log);
        }
    }

    public static void executarModulo(String nomeModulo, ArrayList<String> lista) {
        int opcao;
        do {
            System.out.println("\n--- Módulo de " + nomeModulo + " ---");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Remover");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    cadastrar(nomeModulo, lista);
                    break;
                case 2:
                    listar(nomeModulo, lista);
                    break;
                case 3:
                    atualizar(nomeModulo, lista);
                    break;
                case 4:
                    remover(nomeModulo, lista);
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void cadastrar(String nomeModulo, ArrayList<String> lista) {
        scanner.nextLine(); // limpar buffer
        String entrada = "";

        switch (nomeModulo) {
            case "EPIs":
                System.out.print("Nome do EPI: ");
                String nomeEPI = scanner.nextLine().trim();
                System.out.print("Quantidade: ");
                String quantidade = scanner.nextLine().trim();
                System.out.print("Descrição: ");
                String descricao = scanner.nextLine().trim();

                if (nomeEPI.isEmpty() || quantidade.isEmpty() || descricao.isEmpty()) {
                    System.out.println("Erro: Nenhum campo pode estar vazio!");
                    return;
                }

                entrada = nomeEPI + " - " + quantidade + " unidades - " + descricao;
                break;

            case "Funcionários":
                System.out.print("Nome do Funcionário: ");
                String nomeFunc = scanner.nextLine().trim();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine().trim();
                System.out.print("Cargo: ");
                String cargo = scanner.nextLine().trim();

                if (nomeFunc.isEmpty() || cpf.isEmpty() || cargo.isEmpty()) {
                    System.out.println("Erro: Nenhum campo pode estar vazio!");
                    return;
                }

                entrada = nomeFunc + " - CPF: " + cpf + " - Cargo: " + cargo;
                break;

            case "Empréstimos":
                System.out.print("Nome do Funcionário: ");
                String funcionarioEmp = scanner.nextLine().trim();
                System.out.print("Item Emprestado: ");
                String item = scanner.nextLine().trim();
                System.out.print("Data do Empréstimo (dd/mm/aaaa): ");
                String data = scanner.nextLine().trim();

                if (funcionarioEmp.isEmpty() || item.isEmpty() || data.isEmpty()) {
                    System.out.println("Erro: Nenhum campo pode estar vazio!");
                    return;
                }

                entrada = funcionarioEmp + " - " + item + " - " + data;
                break;

            default:
                System.out.print("Digite os dados: ");
                entrada = scanner.nextLine().trim();
                if (entrada.isEmpty()) {
                    System.out.println("Erro: O campo não pode estar vazio!");
                    return;
                }
        }

        lista.add(entrada);
        System.out.println("Cadastro realizado com sucesso!");
        logOperacoes.add("Cadastrado em " + nomeModulo + ": " + entrada);
    }

    public static void listar(String nomeModulo, ArrayList<String> lista) {
        System.out.println("\nLista de " + nomeModulo + ":");
        if (lista.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i + ". " + lista.get(i));
            }
        }
    }

    public static void atualizar(String nomeModulo, ArrayList<String> lista) {
        listar(nomeModulo, lista);
        if (lista.isEmpty()) return;

        System.out.print("Digite o índice do item a ser atualizado: ");
        int index = lerInteiro();
        if (index >= 0 && index < lista.size()) {
            scanner.nextLine(); // limpar buffer
            String novoValor = "";

            switch (nomeModulo) {
                case "EPIs":
                    System.out.print("Novo nome do EPI: ");
                    String nomeEPI = scanner.nextLine().trim();
                    System.out.print("Nova quantidade: ");
                    String quantidade = scanner.nextLine().trim();
                    System.out.print("Nova descrição: ");
                    String descricao = scanner.nextLine().trim();

                    if (nomeEPI.isEmpty() || quantidade.isEmpty() || descricao.isEmpty()) {
                        System.out.println("Erro: Nenhum campo pode estar vazio.");
                        return;
                    }

                    novoValor = nomeEPI + " - " + quantidade + " unidades - " + descricao;
                    break;

                case "Funcionários":
                    System.out.print("Novo nome do Funcionário: ");
                    String nomeFunc = scanner.nextLine().trim();
                    System.out.print("Novo CPF: ");
                    String cpf = scanner.nextLine().trim();
                    System.out.print("Novo cargo: ");
                    String cargo = scanner.nextLine().trim();

                    if (nomeFunc.isEmpty() || cpf.isEmpty() || cargo.isEmpty()) {
                        System.out.println("Erro: Nenhum campo pode estar vazio.");
                        return;
                    }

                    novoValor = nomeFunc + " - CPF: " + cpf + " - Cargo: " + cargo;
                    break;

                case "Empréstimos":
                    System.out.print("Novo nome do Funcionário: ");
                    String funcionarioEmp = scanner.nextLine().trim();
                    System.out.print("Novo item emprestado: ");
                    String item = scanner.nextLine().trim();
                    System.out.print("Nova data do empréstimo (dd/mm/aaaa): ");
                    String data = scanner.nextLine().trim();

                    if (funcionarioEmp.isEmpty() || item.isEmpty() || data.isEmpty()) {
                        System.out.println("Erro: Nenhum campo pode estar vazio.");
                        return;
                    }

                    novoValor = funcionarioEmp + " - " + item + " - " + data;
                    break;

                default:
                    System.out.print("Digite o novo valor: ");
                    novoValor = scanner.nextLine().trim();
                    if (novoValor.isEmpty()) {
                        System.out.println("Erro: O valor não pode estar vazio.");
                        return;
                    }
            }

            String antigo = lista.get(index);
            lista.set(index, novoValor);
            System.out.println("Atualização realizada com sucesso!");
            logOperacoes.add("Atualizado em " + nomeModulo + ": \"" + antigo + "\" para \"" + novoValor + "\"");
        } else {
            System.out.println("Erro: Índice inválido.");
        }
    }

    public static void remover(String nomeModulo, ArrayList<String> lista) {
        listar(nomeModulo, lista);
        if (lista.isEmpty()) return;

        System.out.print("Digite o índice do item a ser removido: ");
        int index = lerInteiro();
        if (index >= 0 && index < lista.size()) {
            String removido = lista.remove(index);
            System.out.println("Item removido com sucesso!");
            logOperacoes.add("Removido de " + nomeModulo + ": " + removido);
        } else {
            System.out.println("Erro: Índice inválido.");
        }
    }

    public static int lerInteiro() {
        while (true) {
            try {
                int valor = scanner.nextInt();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.nextLine(); // limpa entrada inválida
                System.out.print("Digite novamente: ");
            }
        }
    }
}