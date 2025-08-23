package src.Classes;

public abstract class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    private String cpf;
    private int id;

    public abstract String getnome();

    public abstract String getendereco();

    public abstract String gettelefone();

    public abstract String getcpf();

    public abstract int getid();

    public abstract void setnome(String nome);

    public abstract void setendereco(String endereco);

    public abstract void settelefone(String telefone);

    public abstract void setcpf(String cpf);

    public abstract void setid(int id);
    
    public abstract void gravar(String nome, String endereco, String telefone, String cpf, int id, Pessoa... cliente);

    public abstract void editar(String nome, String endereco, String telefone, String cpf, int id, Pessoa... cliente);

    public abstract void excluir(int iid, int[] id, Pessoa[] cliente);

    public abstract void cancelar();
}
