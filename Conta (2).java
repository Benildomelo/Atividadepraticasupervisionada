public abstract class Conta {
    private String titular;
    private String numero;
    private String agencia;
    private double saldo;

    public Conta(String titular, String numero, String agencia, double saldoInicial) {
        this.titular = titular;
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void saca(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saque não realizado. Verifique o saldo ou o valor do saque.");
        }
    }

    public void deposita(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Depósito não realizado. Valor inválido.");
        }
    }

    public void transfere(Conta destino, double valor) {
        if (valor > 0 && saldo >= valor) {
            this.saca(valor);
            destino.deposita(valor);
        } else {
            System.out.println("Transferência não realizada. Verifique o saldo ou o valor da transferência.");
        }
    }

    public void imprimirDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Número: " + numero);
        System.out.println("Agência: " + agencia);
        System.out.println("Saldo: " + saldo);
    }
}
