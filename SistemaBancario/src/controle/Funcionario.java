package controle;

public class Funcionario extends Thread {
    private Conta contaSalario;
    private Conta contaInvestimento;

    public Funcionario() {
        this.contaSalario = new Conta(0);
        this.contaInvestimento = new Conta(0);
    }

    public void run() {
        synchronized (contaSalario) {
            double salario = contaSalario.getSaldo();
            contaInvestimento.depositar(salario * 0.2);
            System.out.println("Funcionário recebeu salário de R$" + salario + " e investiu R$" + (salario * 0.2));
            contaSalario.sacar(salario);
        }
    }

    public double getSaldoSalario() {
        return contaSalario.getSaldo();
    }

    public double getSaldoInvestimento() {
        return contaInvestimento.getSaldo();
    }

    public void setSaldoSalario(double saldo) {
        contaSalario.depositar(saldo);
    }

    public void setSaldoInvestimento(double saldo) {
        contaInvestimento.depositar(saldo);
    }
}