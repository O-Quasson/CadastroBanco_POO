package src.Classes;

import javax.swing.JOptionPane;

public class ContaPoupanca extends Conta {
    private int agencia;
    private String numero;
    private double saldo;
    private int id;

    public ContaPoupanca(int id, int agencia, String numero, double saldo){
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
    public void gravar(int id, int agencia, String numero, double saldo, Conta... contaPoupanca){
        contaPoupanca[id] = new ContaPoupanca(id, agencia, numero, saldo);
        JOptionPane.showMessageDialog(null, "Conta poupança cadastrada com sucesso! Informações: \nAgência: " + contaPoupanca[id].getagencia() + "\nNúmero da conta: " + contaPoupanca[id].getnumero() + "\nSaldo: " + contaPoupanca[id].getsaldo());

    };

    @Override
    public void editar(int id, int agencia, String numero, double saldo, Conta... contaPoupanca){
        contaPoupanca[id] = new ContaPoupanca(id, agencia, numero, saldo);
        JOptionPane.showMessageDialog(null, "Conta poupança cadastrada com sucesso! Informações: \nAgência: " + contaPoupanca[id].getagencia() + "\nNúmero da conta: " + contaPoupanca[id].getnumero() + "\nSaldo: " + contaPoupanca[id].getsaldo());

    };

    @Override
    public void excluir(int iid, int[] id, Conta[] contaPoupanca){
        contaPoupanca[iid] = null;

        for(int i = iid; i < id[0] - 1; i++){
            contaPoupanca[i] = contaPoupanca[i + 1];
            contaPoupanca[i].setid(i);
        }

        contaPoupanca[id[0]-1] = null;

        id[0] = id[0]-1;
    };

    @Override
    public void cancelar(){

    };

    @Override
    public int tipoConta(){
        return 2;
    }

}
