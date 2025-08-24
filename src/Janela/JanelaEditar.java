package src.Janela;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import src.Classes.*;
import src.Metodos.*;

public class JanelaEditar extends JFrame {

    private void centralizar() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension janela = getSize();

        if(janela.height > screen.height){
            setSize(janela.width, screen.width);
        }
        if(janela.width > screen.width){
            setSize(screen.width, janela.width);
        }

        setLocation((screen.width - janela.width) / 2, (screen.height - janela.height) / 2);
    }

    public JanelaEditar(Conta[] contas, Pessoa[] cliente, int[] id, int iid, JFrame janelaRegistros){
        Mascaras mascaras = new Mascaras();
        ActionListeners actionListeners = new ActionListeners();

        setSize(400, 255);
        setTitle("Editar registro de " + cliente[iid].getnome());
        centralizar();
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel jlAgencia = new JLabel();
        jlAgencia.setBounds(10, 10, 110, 18);
        jlAgencia.setText("Código da Agência:");
        add(jlAgencia);

        JFormattedTextField jtfAgencia = new JFormattedTextField();
        jtfAgencia.setBounds(125, 10, 50,20);
        getContentPane().add(jtfAgencia);
        mascaras.mascaraAgencia(jtfAgencia);
        //muito estranho o toString ser um método do Integer ao invés de um método de String
        jtfAgencia.setText(Integer.toString(contas[iid].getagencia()));

        JLabel jlConta = new JLabel();
        jlConta.setText("Número da Conta:");
        jlConta.setBounds(190, 10, 105, 18);
        getContentPane().add(jlConta);

        JFormattedTextField jtfConta = new JFormattedTextField(contas[iid].getnumero());
        jtfConta.setBounds(300, 10, 75, 20);
        getContentPane().add(jtfConta);
        mascaras.mascaraConta(jtfConta);
        jtfConta.setText(contas[iid].getnumero());

        JSeparator jSeparator01 = new JSeparator();
        jSeparator01.setBounds(10, 40, 365, 10);
        getContentPane().add(jSeparator01);

        JLabel jlNome = new JLabel("Nome:");
        jlNome.setBounds(10, 50, 60, 18);
        jlNome.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlNome);

        JTextField jtfNome = new JTextField(cliente[iid].getnome());
        jtfNome.setBounds(75, 50, 300, 20);
        add(jtfNome);

        JLabel jlEndereco = new JLabel("Endereço:");
        jlEndereco.setBounds(10, 75, 60, 18);
        jlEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlEndereco);

        JTextField jtfEndereco = new JTextField(cliente[iid].getendereco());
        jtfEndereco.setBounds(75, 75, 300, 20);
        add(jtfEndereco);

        JLabel jlTelefone = new JLabel("Telefone:");
        jlTelefone.setBounds(10, 100, 60, 18);
        jlTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlTelefone);

        JFormattedTextField jtfTelefone = new JFormattedTextField(cliente[iid].gettelefone());
        jtfTelefone.setBounds(75, 100, 300, 20);
        add(jtfTelefone);
        mascaras.mascaraTelefone(jtfTelefone);
        jtfTelefone.setText(cliente[iid].gettelefone());

        //algum desses tá dando errado (cpf ou telefone)
        //2 da manhã e eu ainda não achei a porra desse erro. Faz quase 20 minutos que eu to procurando caralhoooooooooo
        //achei, eu sou burro pra caralho e botei a máscara errado 
        //para de falar sozinho, seu maluco
        JLabel jlCpf = new JLabel("CPF:");
        jlCpf.setBounds(10, 125, 60, 18); 
        jlCpf.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlCpf);

        JFormattedTextField jtfCpf = new JFormattedTextField(cliente[iid].getcpf());
        jtfCpf.setBounds(75, 125, 300, 20);
        add(jtfCpf);
        mascaras.mascaraCpf(jtfCpf);
        jtfCpf.setText(cliente[iid].getcpf());

        ButtonGroup bgContas = new ButtonGroup();

        JRadioButton jrbCorrente = new JRadioButton("Corrente");
        jrbCorrente.setBounds(100, 150, 111, 20);
        jrbCorrente.setMnemonic('C');
        add(jrbCorrente);
        bgContas.add(jrbCorrente);

        JRadioButton jrbPoupanca = new JRadioButton("Poupança");
        jrbPoupanca.setBounds(225, 150, 118, 20);
        jrbPoupanca.setMnemonic('P');
        add(jrbPoupanca);
        bgContas.add(jrbPoupanca);

        if(contas[iid].tipoConta()==1){
            jrbCorrente.setSelected(true);
        }else{
            jrbPoupanca.setSelected(true);
        }

        JSeparator jSeparator02 = new JSeparator();
        jSeparator02.setBounds(10, 180, 365, 10);
        add(jSeparator02);

        JButton jbAtualizar = new JButton("Atualizar");
        jbAtualizar.setBounds(35, 190, 100, 23);
        jbAtualizar.setMnemonic('A');
        add(jbAtualizar);
        jbAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                actionListeners.atualizarRegistro(iid, jtfAgencia, jtfConta, jtfNome, jtfEndereco, jtfTelefone, jtfCpf, jrbPoupanca, contas, id, cliente, JanelaEditar.this, janelaRegistros);
            };
        });

        JButton jbExcluir = new JButton("Excluir");
        jbExcluir.setBounds(145, 190, 100, 23);
        jbExcluir.setMnemonic('S');
        add(jbExcluir);
        jbExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                actionListeners.excluirRegistro(contas, cliente, id, iid, JanelaEditar.this, janelaRegistros);
            };
        });

        JButton jbFechar = new JButton("Cancelar");
        jbFechar.setBounds(255, 190, 100, 23);
        jbFechar.setMnemonic('F');
        getContentPane().add(jbFechar);
        jbFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                actionListeners.cancelarOperacao(cliente, contas, JanelaEditar.this);
            };
        });

    }

}
