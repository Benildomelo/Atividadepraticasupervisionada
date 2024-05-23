import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void armazenaConta(String titular, String numero, String agencia, double saldo, boolean isCorrente) {
        Conta conta;
        if (isCorrente) {
            conta = new ContaCorrente(titular, numero, agencia, saldo);
        } else {
            conta = new ContaPoupanca(titular, numero, agencia, saldo);
        }
        contas.add(conta);
        System.out.println("Conta cadastrada com sucesso.");
    }

    public void removeConta(String titular) {
        Conta contaParaRemover = null;
        for (Conta conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(titular)) {
                contaParaRemover = conta;
                break;
            }
        }
        if (contaParaRemover != null) {
            contas.remove(contaParaRemover);
            System.out.println("Conta removida com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public boolean buscaConta(String titular) {
        for (Conta conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(titular)) {
                conta.imprimirDados();
                return true;
            }
        }
        System.out.println("Conta não encontrada.");
        return false;
    }

    public void imprimeContas() {
        Collections.sort(contas, Comparator.comparing(Conta::getTitular));
        for (Conta conta : contas) {
            conta.imprimirDados();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu do Banco:");
            System.out.println("1. Cadastrar conta");
            System.out.println("2. Remover conta");
            System.out.println("3. Encontrar conta pelo nome do titular");
            System.out.println("4. Imprimir lista de todas as contas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do titular: ");
                    String titular = scanner.nextLine();
                    System.out.print("Digite o número da conta: ");
                    String numero = scanner.nextLine();
                    System.out.print("Digite a agência: ");
                    String agencia = scanner.nextLine();
                    System.out.print("Digite o saldo inicial: ");
                    double saldo = scanner.nextDouble();
                    System.out.print("É conta corrente? (true/false): ");
                    boolean isCorrente = scanner.nextBoolean();
                    banco.armazenaConta(titular, numero, agencia, saldo, isCorrente);
                    break;

                case 2:
                    System.out.print("Digite o nome do titular da conta a ser removida: ");
                    String titularParaRemover = scanner.nextLine();
                    banco.removeConta(titularParaRemover);
                    break;

                case 3:
                    System.out.print("Digite o nome do titular da conta a ser encontrada: ");
                    String titularParaBuscar = scanner.nextLine();
                    banco.buscaConta(titularParaBuscar);
                    break;

                case 4:
                    banco.imprimeContas();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
