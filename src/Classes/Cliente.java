package src.Classes;

import javax.swing.JOptionPane;

public class Cliente extends Pessoa{
    private String nome;
    private String endereco;
    private String telefone;
    private String cpf;
    private int id;

    public Cliente(int id, String nome, String endereco, String telefone, String cpf){
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    @Override
    public int getid(){
        return id;
    }

    @Override
    public String getnome(){
        return nome;
    };

    @Override
    public String getendereco(){
        return endereco;
    };

    @Override
    public String gettelefone(){
        return telefone;
    };

    @Override
    public String getcpf(){
        return cpf;
    };

    @Override
    public void setnome(String nome){
        this.nome = nome;
    };

    @Override
    public void setendereco(String endereco){
        this.endereco = endereco;
    };

    @Override
    public void settelefone(String telefone){
        this.telefone = telefone;
    };

    @Override
    public void setcpf(String cpf){
        this.cpf = cpf;
    };

    public void setid(int id){
        this.id = id;
    };

    @Override
    public void gravar(String nome, String endereco, String telefone, String cpf, int id, Pessoa... cliente){
        cliente[id] = new Cliente(id, nome, endereco, telefone, cpf);
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso! Informações: \nNome: " + cliente[id].getnome() + "\nEndereço: " + cliente[id].getendereco() + "\nTelefone: " + cliente[id].gettelefone() + "\nCPF: " + cliente[id].getcpf());
    };

    @Override
    public void editar(String nome, String endereco, String telefone, String cpf, int id, Pessoa... cliente){
        cliente[id] = new Cliente(id, nome, endereco, telefone, cpf);
        JOptionPane.showMessageDialog(null, "Informações de cliente atualizadas com sucesso! Informações atualizadas: \nNome: " + cliente[id].getnome() + "\nEndereço: " + cliente[id].getendereco() + "\nTelefone: " + cliente[id].gettelefone() + "\nCPF: " + cliente[id].getcpf());
    };

    @Override
    public void excluir(int iid, int[] id, Pessoa[] cliente){
        cliente[iid] = null;

        for(int i = iid; i < id[0] - 1; i++){
            //faz tanto tempo que eu criei esse código que eu nem lembro a lógica, só fui copiando
            //é da atividade de cadastro de funcionário, ainda
            //pelo que eu entendi, ele vai passando os registros da direita para a esquerda, apaga o registro final da direita e reduz o número máximo de ids que tem
            cliente[i] = cliente[i + 1];
            cliente[i].setid(i);
        }

        //o -1 é para ele não acessar o índice 11 em um array que vai até 10, por exemplo
        //arrays começam no 0, duh
        cliente[id[0]-1] = null;

    };

    @Override
    public void cancelar(){

    };
}
