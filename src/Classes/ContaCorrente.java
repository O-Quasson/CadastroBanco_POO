package src.Classes;

import javax.swing.JOptionPane;

public class ContaCorrente extends Conta{
    private int agencia;
    private String numero;
    private double saldo;
    private int id;

    public ContaCorrente(int id, int agencia, String numero, double saldo){
        this.id = id;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    };

    @Override
    public int getagencia(){
        return agencia;
    };
    
    @Override
    public String getnumero(){
        return numero;
    };

    @Override
    public double getsaldo(){
        return saldo;
    };

    @Override
    public int getid(){
        return id;
    };

    @Override
    public void setid(int id){
        this.id = id;
    };

    @Override
    public void setgencia(int agencia){
        this.agencia = agencia;
    };

    @Override
    public void setnumero(String numero){
        this.numero = numero;
    };

    @Override
    public void setsaldo(int saldo){
        this.saldo = saldo;
    };
    
    @Override
    public void gravar(int id, int agencia, String numero, double saldo, Conta... contaCorrente){
        contaCorrente[id] = new ContaCorrente(id, agencia, numero, saldo);
        JOptionPane.showMessageDialog(null, "Conta corrente cadastrada com sucesso! Informações: \nAgência: " + contaCorrente[id].getagencia() + "\nNúmero da conta: " + contaCorrente[id].getnumero() + "\nSaldo: " + contaCorrente[id].getsaldo());
    };

    @Override
    public void editar(int id, int agencia, String numero, double saldo, Conta... contaCorrente){
        contaCorrente[id] = new ContaCorrente(id, agencia, numero, saldo);
        JOptionPane.showMessageDialog(null, "Conta corrente atualizada com sucesso! Informações atualizadas: \nAgência: " + contaCorrente[id].getagencia() + "\nNúmero da conta: " + contaCorrente[id].getnumero() + "\nSaldo: " + contaCorrente[id].getsaldo());
    };

    @Override
    public void excluir(int iid, int[] id, Conta[] contaCorrente){
        contaCorrente[iid] = null;

        for(int i = iid; i < id[0] - 1; i++){
            contaCorrente[i] = contaCorrente[i + 1];
            contaCorrente[i].setid(i);
        }

        contaCorrente[id[0]-1] = null;

        id[0] = id[0]-1;

    };

    @Override
    public void cancelar(){
        //eu não tinha a menor ideia do que colocar aqui e o exercício tava falando que esse método é obrigatório, então eu fiz isso
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
        };
        JOptionPane.showMessageDialog(null, "Operação cancelada. Nenhuma alteração foi salva");
    };

    @Override
    public int tipoConta(){
        return 1;
    }
}
