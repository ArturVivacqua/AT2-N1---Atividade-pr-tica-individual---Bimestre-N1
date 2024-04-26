package visao;

import controle.*;

public class SistemaBancario {
    public static void main(String[] args) {
        // Criar entidades do sistema
        Banco banco = new Banco();
        Loja loja1 = new Loja();
        Loja loja2 = new Loja();
        Funcionario funcionarioLoja1 = new Funcionario();
        Funcionario funcionarioLoja2 = new Funcionario();

        // Iniciar transações bancárias
        TransacaoBancaria transacaoBancaria = new TransacaoBancaria(banco, loja1, loja2, funcionarioLoja1, funcionarioLoja2);
        System.out.println("Iniciando transações bancárias...");
        transacaoBancaria.iniciarTransacoes();
        System.out.println("Transações bancárias iniciadas.");

        // Aguardar finalização das transações
        System.out.println("\nAguardando finalização das transações...");
        transacaoBancaria.finalizarTransacoes();
        System.out.println("Transações bancárias finalizadas.");

        // Exibir saldos finais das contas
        System.out.println("\nSaldos finais das contas:");
        System.out.println("Saldo da conta do Banco: R$" + banco.getSaldo());
        System.out.println("Saldo da conta da Loja 1: R$" + loja1.getSaldo());
        System.out.println("Saldo da conta da Loja 2: R$" + loja2.getSaldo());
        System.out.println("Saldo da conta do Funcionário 1: R$" + funcionarioLoja1.getSaldoSalario());
        System.out.println("Saldo da conta de Investimento do Funcionário 1: R$" + funcionarioLoja1.getSaldoInvestimento());
        System.out.println("Saldo da conta do Funcionário 2: R$" + funcionarioLoja2.getSaldoSalario());
        System.out.println("Saldo da conta de Investimento do Funcionário 2: R$" + funcionarioLoja2.getSaldoInvestimento());
    }
}