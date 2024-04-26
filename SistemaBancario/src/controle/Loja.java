package controle;

public class Loja {
    private Conta conta;

    public Loja() {
        this.conta = new Conta(0);
    }

    public synchronized void pagarFuncionario(double salario) {
        conta.sacar(salario);
        System.out.println("Pagamento de salário no valor de R$" + salario + " realizado para funcionário.");
    }

    public double getSaldo() {
        return conta.getSaldo();
    }
}