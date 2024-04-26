package controle;

public class Cliente extends Thread {
    private Conta conta;
    private String nome;

    public Cliente(String nome, double saldoInicial) {
        this.nome = nome;
        this.conta = new Conta(saldoInicial);
    }

    public void run() {
        while (conta.getSaldo() > 0) {
            int valorCompra = Math.random() < 0.5 ? 100 : 200;
            realizarCompra(valorCompra);
        }
    }

    private void realizarCompra(double valor) {
        synchronized (conta) {
            if (conta.getSaldo() >= valor) {
                conta.sacar(valor);
                System.out.println(nome + " realizou uma compra de R$" + valor);
            } else {
                System.out.println("Saldo insuficiente para realizar a compra.");
            }
        }
    }
}