package Projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Projeto.Pizza.TamanhoPizza;

public class Pizzaria {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        List<Pedido> listaPedidos = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n== PIZZARIA ==");
            System.out.println("1. Fazer um novo pedido");
            System.out.println("2. Alterar um pedido");
            System.out.println("3. Adicionar cliente");
            System.out.println("4. Gerar relatório de vendas");
            System.out.println("5. Gerar lista de clientes");
            System.out.println("0. Sair");

            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:

                    fazerPedido(scanner, listaPedidos, listaClientes);
                    break;

                case 2:

                    alterarPedido(scanner, listaPedidos);
                    break;

                case 3:

                    listaClientes.add(adicionarCliente(scanner));
                    System.out.println("\nCliente adicionado com sucesso!" );
                    break;

                case 4:

                    gerarRelatorio(listaPedidos);
                    break;

                case 5:

                    gerarListaClientes(listaClientes);
                    break;

                case 0:

                    System.out.println("\nEncerrando sistema...\n");
                    continuar = false;
                    scanner.close();
                    break;

                default:
                    break;
            }
        }
    }

    private static void fazerPedido(Scanner scanner, List<Pedido> listaPedidos, List<Cliente> listaClientes){
       
        List<Pizza> pizzas = new ArrayList<>();
        System.out.println("\n--- Fazer Pedido ---\n");
        
        if (listaClientes.isEmpty()) {
            System.out.println("Adicione um cliente para realizar o pedido...");
        } else {

            int x = 1;
            System.out.println("Selecione um cliente: ");
            for (Cliente cliente : listaClientes) {
                System.out.println(x + " | " + cliente.getNome());
                x++;
            }

            System.out.print("\nOpção: ");
            int cliente = scanner.nextInt();
            scanner.nextLine();

            boolean continuar = true;
            while (continuar){

                x = 1;
                System.out.println("\nQual o tamanho da pizza? ");
                for (TamanhoPizza tamanhos : Pizza.TamanhoPizza.values()) {
                    System.out.println(x + " | " + tamanhos);
                    x++;
                }
                System.out.print("\nOpção: ");
                int tamanho = scanner.nextInt();
                scanner.nextLine();

                int quantidadeSabores = 0;
                while (quantidadeSabores < 1 || quantidadeSabores > 4) {
                    System.out.print("\nDigite a quantidade de sabores (1 - 4), que você deseja escolher: ");
                    quantidadeSabores = scanner.nextInt();
                    scanner.nextLine();
                }

                Cardapio cardapio = new Cardapio();
                List<String> saboresList = new ArrayList<>();
                List<String> saboresSelect = new ArrayList<>();

                for (int i = 0; i < quantidadeSabores; i++) {
                    System.out.println("\nSelecione o sabor " + (i + 1) + ":");

                    x = 1;
                    for (String sabor : cardapio.getCardapio().keySet()) {
                        saboresList.add(sabor);
                        System.out.println(x + " | " + sabor);
                        x++;
                    }

                    System.out.print("\nOpção: ");
                    int opcao = scanner.nextInt();
                    scanner.nextLine();
                    saboresSelect.add(saboresList.get(opcao - 1));
                }

                TamanhoPizza tamanhoEnum = TamanhoPizza.getByIndex(tamanho - 1);
                double precoCalculado = Pizza.ajustarPrecoTamanho(saboresSelect, tamanhoEnum);

                Pizza pizza = new Pizza(saboresSelect, precoCalculado, tamanhoEnum);
                pizzas.add(pizza);

                System.out.println("\nPizza cadastrada com sucesso!");
                System.out.println("\nDeseja cadastrar mais uma pizza no pedido? ");
                System.out.println("1 - Sim | 2 - Não ");
                System.out.print("\nOpção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao != 1) {
                    continuar = false;
                }
            }

            Pedido pedido = new Pedido(listaPedidos.size() + 1, listaClientes.get(cliente - 1), pizzas, somarPizzas(pizzas));
            listaPedidos.add(pedido);

            System.out.println("\nPedido realizado com sucesso!");
            System.out.printf("\nValor dos produtos: R$ %.2f%n", pedido.getValorTotal());
            System.out.println("Número do pedido: " + pedido.getId()); //implementação mostrar id

            System.out.println("\n--- CÁCULO DE FRETE ---");
            System.out.print("Qual a distância da entrega (em KM)? ");

            double distancia = scanner.nextDouble();
            scanner.nextLine();

            pedido.setDistanciaEntrega(distancia);

            double valorFrete = calcularFrete(distancia);
            System.out.printf("\nCusto do Frete: R$ %.2f%n", valorFrete);
            System.out.printf("Valor total com frete: R$ %.2f%n", (pedido.getValorTotal() + valorFrete));
        }
    }

    private static double somarPizzas(List<Pizza> pizzas) {
        double valorTotal = 0;
        for (Pizza pizza : pizzas) {
            valorTotal += pizza.getPreco();
        }
        return valorTotal;
    }

    private static double calcularFrete(double distanciaKm){ //implementação frete
        double taxaPorKm = 2.00;

        double valorFrete = (distanciaKm * taxaPorKm);

        return valorFrete;
    }

    private static void alterarPedido(Scanner scanner, List<Pedido> listaPedidos){ //implementação opção alterar pedido

        System.out.println("\n--- Alterar Pedido ---");


        if (listaPedidos.isEmpty()) {
            System.out.println("\nNão há pedidos para alterar...");
        } else {
            System.out.print("\nDigite o ID do pedido que deseja alterar: ");
            int idBuscado = scanner.nextInt();
            scanner.nextLine();

            Pedido pedidoEncontrado = null;

            for (Pedido pedido : listaPedidos) {
                if (pedido.getId() == idBuscado) {
                    pedidoEncontrado = pedido;
                    break;
                }
            }

            if (pedidoEncontrado == null) {
                System.out.println("\nPedido não encontrado...");
                return;
            }

            System.out.println("\nPedido localizado! Cliente: " + pedidoEncontrado.getCliente().getNome());

            boolean alterar = true;
            while (alterar) {

                System.out.println("\n-- O que deseja fazer? --");
                System.out.println("1. Adicionar pizza");
                System.out.println("2. Remover pizza");
                System.out.println("3. Alterar sabor");
                System.out.println("4. Voltar");  
                System.out.print("\nOpção: "); 

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        adicionarPizzaPedido(scanner, pedidoEncontrado);
                        break;
                    case 2:
                        removerPizzaPedido(scanner, pedidoEncontrado);
                        break;
                    case 3:
                        alterarSaborPizza(scanner, pedidoEncontrado);
                        break;
                    case 4:
                        alterar = false;
                        break;        
                    default:
                        System.out.println("\nOpção inválida!");
                        break;
                }
            } 
        }
         
    }

    private static void alterarSaborPizza(Scanner scanner, Pedido pedidoEncontrado) {

        System.out.println("\n-- Alterar Sabor --");
        
        if (pedidoEncontrado.getPizzas().isEmpty()) {
            System.out.println("\nNão há pizzas neste pedido...");
        } else {
            int x = 1;
            for (Pizza pizza : pedidoEncontrado.getPizzas()) {
                System.out.println(x + " | " + pizza.getSabores());
                x++;
            }

            System.out.print("\nEscolha o número da pizza que deseja alterar: ");
            int opcaoAlterar = scanner.nextInt();
            scanner.nextLine();

            int pizzaSelecionada = opcaoAlterar - 1;
            if (pizzaSelecionada < 0 || pizzaSelecionada >= pedidoEncontrado.getPizzas().size()) {
                System.out.println("\nOpção inválida!");
                return;
            }

            Pizza pizza = pedidoEncontrado.getPizzas().get(pizzaSelecionada);

            int quantidadeSabores = 0;
            while (quantidadeSabores < 1 || quantidadeSabores > 4) {
                System.out.print("\nQuantos sabores a pizza terá agora (1 - 4)? ");
                quantidadeSabores = scanner.nextInt();
                scanner.nextLine();
            }

            Cardapio cardapio = new Cardapio();
            List<String> saboresList = new ArrayList<>();
            List<String> novosSabores = new ArrayList<>();

            for (int i = 0; i < quantidadeSabores; i++) {
                System.out.println("\nSelecione o novo sabor " + (i + 1) + ": ");
                x = 1;
                for (String sabor : cardapio.getCardapio().keySet()) {
                    saboresList.add(sabor);
                    System.out.println(x + " | " + sabor);
                    x++;
                }

                System.out.print("\nOpção: ");
                int opSabor = scanner.nextInt();
                scanner.nextLine();
                novosSabores.add(saboresList.get(opSabor - 1));
            }

            pizza.setSabores(novosSabores);

            double novoPreco = Pizza.ajustarPrecoTamanho(novosSabores, pizza.getTamanho());

            pizza.setPreco(novoPreco);

            System.out.println("\nSabor alterado para: " + novosSabores);
            System.out.printf("Valor dos produtos atualizado: R$%.2f%n", novoPreco);
        }
    }

    private static void removerPizzaPedido(Scanner scanner, Pedido pedidoEncontrado){
        
        System.out.println("-- Remover Pizza --");
        
        if (pedidoEncontrado.getPizzas().isEmpty()) {
            System.out.println("\nNão há pizzas neste pedido...");
        } else {
            
            int x = 1;
            for (Pizza pizza : pedidoEncontrado.getPizzas()) {
                System.out.println(x + " | " + pizza.getSabores());
                x++;
            }

            System.out.print("\nEscolha o número da pizza que deseja remover: ");
            int opcaoRemover = scanner.nextInt();
            scanner.nextLine();

            int pizzaSelecionada = opcaoRemover - 1;
            if (pizzaSelecionada < 0 || pizzaSelecionada >= pedidoEncontrado.getPizzas().size()) {
                System.out.println("\nOpção inválida!");
                return;
            }

            pedidoEncontrado.getPizzas().remove(pizzaSelecionada);

            double novoTotalPedido = 0;
            for (Pizza p : pedidoEncontrado.getPizzas()) {
                novoTotalPedido += p.getPreco();
            }

            pedidoEncontrado.setValorTotal(novoTotalPedido);

            System.out.printf("\nValor dos produtos atualizado: R$%.2f%n", novoTotalPedido);

        }
    }

    private static void adicionarPizzaPedido(Scanner scanner, Pedido pedidoEncontrado) {

        System.out.println("\n-- Adicionar Pizza ao Pedido --");
        int x = 1;
        System.out.println("\nQual o tamanho da pizza? ");
            for (TamanhoPizza tamanhos : Pizza.TamanhoPizza.values()) {
                System.out.println(x + " | " + tamanhos);
                x++;
            }

        System.out.print("\nOpção: ");
        int tamanho = scanner.nextInt();
        scanner.nextLine();

        int quantidadeSabores = 0;
        while (quantidadeSabores < 1 || quantidadeSabores > 4) {
            System.out.print("\nDigite a quantidade de sabores (1 - 4), que você deseja escolher: ");
            quantidadeSabores = scanner.nextInt();
            scanner.nextLine();
        }

        Cardapio cardapio = new Cardapio();
        List<String> saboresList = new ArrayList<>();
        List<String> saboresSelect = new ArrayList<>();

        for (int i = 0; i < quantidadeSabores; i++) {
            System.out.println("\nSelecione o sabor " + (i + 1) + ":");

            x = 1;
            for (String sabor : cardapio.getCardapio().keySet()) {
                saboresList.add(sabor);
                System.out.println(x + " | " + sabor);
                x++;
            }

            System.out.print("\nOpção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            saboresSelect.add(saboresList.get(opcao - 1));
        }

        TamanhoPizza tamanhoEnum = TamanhoPizza.getByIndex(tamanho - 1);
        double precoCalculado = Pizza.ajustarPrecoTamanho(saboresSelect, tamanhoEnum);

        Pizza novaPizza = new Pizza(saboresSelect, precoCalculado, tamanhoEnum);
        pedidoEncontrado.getPizzas().add(novaPizza);

        System.out.println("\nNova pizza adicionada com sucesso!");

        double novoTotalPedido = 0;
        for (Pizza p : pedidoEncontrado.getPizzas()) {
            novoTotalPedido += p.getPreco();
        }
        
        pedidoEncontrado.setValorTotal(novoTotalPedido);

        System.out.printf("\nValor dos produtos atualizado: R$%.2f%n", novoTotalPedido);

    }
    

    private static Cliente adicionarCliente(Scanner scanner){
        
        System.out.println("\n--- Adicionar Cliente ---\n");

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();

        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(nome, endereco, telefone, email);
        return cliente;
    }

    private static void gerarRelatorio(List<Pedido> listaPedidos){ //implemetação opcçao relatório
        
        System.out.println("\n--- Relatório de Vendas ---\n");

        if (listaPedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado ainda...");
            return;
        }

        double faturamentoTotal = 0;
        Map<String, Integer> ranking = new HashMap<>();
        GrafoSabores grafo = new GrafoSabores();

        for (Pedido pedido : listaPedidos) {

            faturamentoTotal += pedido.getValorTotal();

            for (Pizza pizza : pedido.getPizzas()) {
                
                List<String> sabores = pizza.getSabores();

                for (String sabor : sabores) {
                    
                    if (ranking.containsKey(sabor)) {
                        int quantidadeAtual = ranking.get(sabor);
                        ranking.put(sabor, quantidadeAtual + 1);
                    } else {
                        ranking.put(sabor, 1);
                    }
                }

                if (sabores.size() > 1) {
                    for (int i = 0; i < sabores.size() - 1; i++) {
                        grafo.adicionarAresta(sabores.get(i), sabores.get(i + 1));
                    }
                }
            }
            
        }

        System.out.printf("Faturamento Total: R$%.2f%n", faturamentoTotal);
        System.out.println("Total de Pedidos: " + listaPedidos.size());
        System.out.println("\n------------------- Ranking Sabores Mais Pedidos -------------------\n");
        for (String sabor : ranking.keySet()) {
            if (ranking.get(sabor) == 1) {
               System.out.println("-> " + sabor + ": " + ranking.get(sabor) + " vez"); 
            } else {
                System.out.println("-> " + sabor + ": " + ranking.get(sabor) + " vezes");
            }
            
        }

        grafo.imprimirGrafo(); //implementação classe grafo
    }



    private static void gerarListaClientes(List<Cliente> listaClientes){
        int x = 1;
        if (listaClientes.isEmpty()) {
            System.out.println("\nA lista de clientes está vazia...");
        } else {
            for (Cliente cliente : listaClientes) {
                System.out.println("\n-- Cliente " + x + " --");
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Endereço: " + cliente.getEndereco());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println("Email: " + cliente.getEmail());
                System.out.println("--------------------------------------------------");
                x++;
            }
        }
    }
}
