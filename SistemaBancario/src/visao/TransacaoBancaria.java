package visao;

import controle.*;

public class TransacaoBancaria {
    private Banco banco;
    private Loja loja1;
    private Loja loja2;
    private Funcionario funcionarioLoja1;
    private Funcionario funcionarioLoja2;

    public TransacaoBancaria(Banco banco, Loja loja1, Loja loja2, Funcionario funcionarioLoja1, Funcionario funcionarioLoja2) {
        this.banco = banco;
        this.loja1 = loja1;
        this.loja2 = loja2;
        this.funcionarioLoja1 = funcionarioLoja1;
        this.funcionarioLoja2 = funcionarioLoja2;
    }

    public void iniciarTransacoes() {
        Thread cliente1 = new Cliente("Cliente 1", 1000);
        Thread cliente2 = new Cliente("Cliente 2", 1000);
        Thread cliente3 = new Cliente("Cliente 3", 1000);
        Thread cliente4 = new Cliente("Cliente 4", 1000);
        Thread cliente5 = new Cliente("Cliente 5", 1000);

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();

        funcionarioLoja1.start();
        funcionarioLoja2.start();
    }

    public void finalizarTransacoes() {
        try {
            funcionarioLoja1.join();
            funcionarioLoja2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}