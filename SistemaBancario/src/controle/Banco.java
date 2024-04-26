package controle;

public class Banco {
    private Conta conta;

    public Banco() {
        this.conta = new Conta(0);
    }

    public synchronized void transferir(double valor, Conta origem, Conta destino) {
        synchronized (origem) {
            synchronized (destino) {
                if (origem.getSaldo() >= valor) {
                    origem.sacar(valor);
                    destino.depositar(valor);
                    System.out.println("Transferência de R$" + valor + " realizada.");
                } else {
                    System.out.println("Saldo insuficiente para transferência.");
                }
            }
        }
    }

    public double getSaldo() {
        return conta.getSaldo();
    }
}