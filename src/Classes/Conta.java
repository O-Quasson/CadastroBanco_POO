package src.Classes;

public abstract class Conta {
    private int agencia;
    private String numero;
    private double saldo;
    private int id;

    public abstract int getagencia();
    
    public abstract String getnumero();

    public abstract double getsaldo();

    public abstract int getid();
    
    public abstract void setgencia(int agencia);

    public abstract void setnumero(String numero);

    public abstract void setsaldo(int saldo);

    public abstract void setid(int id);

    public abstract void gravar(int id, int agencia, String numero, double saldo, Conta... contacorrente);

    public abstract void editar(int id, int agencia, String numero, double saldo, Conta... contaCorrente);

    public abstract void excluir(int iid, int[] id, Conta[] contaCorrente);

    public abstract void cancelar();

    public abstract int tipoConta();
    
    
}
