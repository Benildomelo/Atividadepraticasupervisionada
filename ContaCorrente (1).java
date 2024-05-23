public class ContaCorrente extends Conta implements Tributavel {
    public ContaCorrente(String titular, String numero, String agencia, double saldoInicial) {
        super(titular, numero, agencia, saldoInicial);
    }

    @Override
    public double getValorImposto() {
        return getSaldo() * 0.01;
    }

    @Override
    public void imprimirDados() {
        super.imprimirDados();
        System.out.println("Imposto: " + getValorImposto());
    }
}
