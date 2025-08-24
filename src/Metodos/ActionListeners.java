package src.Metodos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import src.Classes.Cliente;
import src.Classes.Conta;
import src.Classes.ContaCorrente;
import src.Classes.ContaPoupanca;
import src.Classes.Pessoa;
import src.Janela.Janela;
import src.Janela.JanelaEditar;
import src.Janela.JanelaRegistros;

public class ActionListeners{

    public void cadastrarRegistro(JFormattedTextField jtfAgencia, JFormattedTextField jtfConta, JTextField jtfNome, JTextField jtfEndereco, JFormattedTextField jtfTelefone, JFormattedTextField jtfCpf, JRadioButton jrbPoupanca, Conta[] contas, int[] id, Pessoa[] cliente, JButton jbRegistros){
        if(id[0]>=10){
            JOptionPane.showMessageDialog(null, "Limite máximo de registros atingido! Apague um dos registros para continuar");
        }else{
            //guj.com é o maior salvador de vidas pra quem tem dúvidas sobre gui com java, puta merda
            //eu te amo, site aleatório da internet
            //https://www.geeksforgeeks.org/java/how-to-remove-all-non-alphanumeric-characters-from-a-string-in-java/
            //replaceAll troca todos os caracteres que não correspondem aos especificados, no caso, números e letras, por ""
            if((jtfEndereco.getText().trim().equals(""))||(jtfNome.getText().trim().equals(""))||(jtfAgencia.getText().replaceAll("[^a-zA-Z0-9]", "").length()<4)||(jtfTelefone.getText().replaceAll("[^a-zA-Z0-9]", "").trim().length()<11)||(jtfCpf.getText().replaceAll("[^a-zA-Z0-9]", "").trim().length()<11)||(jtfConta.getText().replaceAll("[^a-zA-Z0-9]", "").trim().length()<9)){
                    JOptionPane.showMessageDialog(null, "Um dos campos de dados está vazio ou incompleto!");
            }else{
                //isso daqui é só um placeholder, ignora
                //eu só cadastrei primeiro com lixo de memória e atualizei depois, pra ter acesso aos métodos
                cliente[id[0]] = new Cliente(0, null, null, null, null);
                cliente[id[0]].gravar(jtfNome.getText().trim(), jtfEndereco.getText().trim(), jtfTelefone.getText().trim(), jtfCpf.getText().trim(), id[0], cliente);
                if(jrbPoupanca.isSelected()){
                    contas[id[0]] = new ContaPoupanca(0, 0, null, 0);
                    contas[id[0]].gravar(id[0], Integer.parseInt(jtfAgencia.getText().trim()), jtfConta.getText().trim(), 0.0, contas);
                }else{
                    contas[id[0]] = new ContaCorrente(0, 0, null, 0);
                    contas[id[0]].gravar(id[0], Integer.parseInt(jtfAgencia.getText().trim()), jtfConta.getText().trim(), 0.0, contas);
                }
                id[0] = id[0]+1;
                //bagulho feio, ferra todo o texto placeholder do projeto 😭
                jbRegistros.setEnabled(true);
                jtfAgencia.setText("");
                jtfConta.setText("");
                jtfCpf.setText("");
                jtfEndereco.setText("");
                jtfNome.setText("");
                jtfTelefone.setText("");
            };
        };
    };

    public void fecharJanela(JFrame janela){
        janela.dispose();
    };

    public void abrirRegistros(int[] id, Pessoa[] cliente, Conta[] contas){
        if(id[0]<1){
            JOptionPane.showMessageDialog(null, "Não há nenhum registro cadastrado");
        }else{
            JanelaRegistros registros = new JanelaRegistros(id, cliente, contas);
            registros.setVisible(true);
        }
    };

    public void atualizarRegistro(int iid, JFormattedTextField jtfAgencia, JFormattedTextField jtfConta, JTextField jtfNome, JTextField jtfEndereco, JFormattedTextField jtfTelefone, JFormattedTextField jtfCpf, JRadioButton jrbPoupanca, Conta[] contas, int[] id, Pessoa[] cliente, JanelaEditar janela, JFrame janelaRegistros){
        //I aint reading allat bruh 💔🥀
        if((jtfEndereco.getText().trim().equals(""))||(jtfNome.getText().trim().equals(""))||(jtfAgencia.getText().replaceAll("[^a-zA-Z0-9]", "").length()<4)||(jtfTelefone.getText().replaceAll("[^a-zA-Z0-9]", "").trim().length()<11)||(jtfCpf.getText().replaceAll("[^a-zA-Z0-9]", "").trim().length()<11)||(jtfConta.getText().replaceAll("[^a-zA-Z0-9]", "").trim().length()<9)){
            JOptionPane.showMessageDialog(null, "Um dos campos de dados está vazio ou incompleto!");
        }else{
            cliente[iid].editar(jtfNome.getText().trim(), jtfEndereco.getText().trim(), jtfTelefone.getText().trim(), jtfCpf.getText().trim(), iid, cliente);
            if(jrbPoupanca.isSelected()){
                //algum desses tá dando erro
                //ver depois da janta
                contas[iid] = new ContaPoupanca(iid, Integer.parseInt(jtfAgencia.getText().trim()), jtfConta.getText().trim(), 0.0);
                contas[iid].editar(iid, Integer.parseInt(jtfAgencia.getText().trim()), jtfConta.getText().trim(), 0.0, contas);
            }else{
                contas[iid] = new ContaCorrente(iid, Integer.parseInt(jtfAgencia.getText().trim()), jtfConta.getText().trim(), 0.0);
                contas[iid].editar(iid, Integer.parseInt(jtfAgencia.getText().trim()), jtfConta.getText().trim(), 0.0, contas);
            }
            // janelaRegistros.revalidate();
            // janelaRegistros.repaint();
            // janela.dispose();

            janelaRegistros.dispose();
            JanelaRegistros novaJanela = new JanelaRegistros(id, cliente, contas);
            novaJanela.setVisible(true);
            janela.dispose();
        }
    };

    public void excluirRegistro(Conta[] contas, Pessoa[] cliente, int[] id, int iid, JanelaEditar janela, JFrame janelaRegistros){
        cliente[iid].excluir(iid, id, cliente);
        contas[iid].excluir(iid, id, contas);
        JOptionPane.showMessageDialog(null, "Cliente e conta excluídos com sucesso!");
        //não funcionam por quê??????
        // janelaRegistros.repaint();
        // janela.dispose();

        janelaRegistros.dispose();
        JanelaRegistros novaJanela = new JanelaRegistros(id, cliente, contas);
        novaJanela.setVisible(true);
        janela.dispose();
    };

    public void acessarRegistro(int idItem, int[] id, Conta[] contas, Pessoa[] clientes, JFrame janelaRegistros){
        JanelaEditar infoRegistro = new JanelaEditar(contas, clientes, id, idItem, janelaRegistros);
        infoRegistro.setVisible(true);
    };

    public void cancelarOperacao(Pessoa[] cliente, Conta[] contas, JFrame janela){
        cliente[0].cancelar();
        contas[0].cancelar();
        janela.dispose();
    };
};
