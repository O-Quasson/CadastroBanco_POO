package src.Janela;
//não sei oque é esse tal de package, mas o Vscode mandou colocar
//consegui compilar isso daqui de primeira, só chutando que era pra colocr ./src/Janela/Janela.java
//pae que é pae é pae né pae
import java.awt.Dimension;
import java.awt.Toolkit;
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

    public JanelaEditar(Conta[] contas, Pessoa[] cliente, int[] id, int iid){

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

        int textoAgencia = contas[iid].getagencia();
        JFormattedTextField jtfAgencia = new JFormattedTextField();
        jtfAgencia.setBounds(125, 10, 50,20);
        getContentPane().add(jtfAgencia);

        MaskFormatter mascaraAgencia = null;
        try {
            mascaraAgencia = new MaskFormatter("####");
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
        }
        mascaraAgencia.install(jtfAgencia);
        //muito estranho o toString ser um método do Integer ao invés de um método de String
        jtfAgencia.setText(Integer.toString(textoAgencia));

        JLabel jlConta = new JLabel();
        jlConta.setText("Número da Conta:");
        jlConta.setBounds(190, 10, 105, 18);
        getContentPane().add(jlConta);

        JFormattedTextField jtfConta = new JFormattedTextField(contas[iid].getnumero());
        jtfConta.setBounds(300, 10, 75, 20);
        getContentPane().add(jtfConta);

        MaskFormatter mascaraConta = null;
        try {
            mascaraConta = new MaskFormatter("########-#");
            mascaraConta.setPlaceholder("________-_");
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
        }
        mascaraConta.install(jtfConta);
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

        MaskFormatter mascaraTelefone = null;
        try {
            mascaraTelefone = new MaskFormatter("(##) #####-####");
            mascaraTelefone.setPlaceholder("(__) _____-____");
        } catch (ParseException e1) {

        }
        mascaraTelefone.install(jtfTelefone);
        jtfTelefone.setText(cliente[iid].gettelefone());

        JLabel jlCpf = new JLabel("CPF:");
        jlCpf.setBounds(10, 125, 60, 18);
        jlCpf.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlCpf);

        JFormattedTextField jtfCpf = new JFormattedTextField(cliente[iid].getcpf());
        jtfCpf.setBounds(75, 125, 300, 20);
        add(jtfCpf);

        MaskFormatter mascaraCpf = null;
        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraCpf.setPlaceholder("___.___.___.-__");
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
        }
        mascaraCpf.install(jtfCpf);
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
        jbAtualizar.addActionListener(atualizarRegistro -> {

            if((jtfAgencia.getText().trim().equals(""))||(jtfConta.getText().trim().equals(""))||(jtfCpf.getText().trim().equals(""))||(jtfEndereco.getText().trim().equals(""))||(jtfNome.getText().trim().equals(""))||(jtfTelefone.getText().trim().equals(""))){
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
                dispose();
            }
        });

        JButton jbExcluir = new JButton("Excluir");
        jbExcluir.setBounds(145, 190, 100, 23);
        jbExcluir.setMnemonic('S');
        add(jbExcluir);
        jbExcluir.addActionListener(excluircadastro -> {
            cliente[iid].excluir(iid, id, cliente);
            contas[iid].excluir(iid, id, contas);
            JOptionPane.showMessageDialog(null, "Cliente e conta excluídos com sucesso!");
            dispose();
        });

        JButton jbFechar = new JButton("Cancelar");
        jbFechar.setBounds(255, 190, 100, 23);
        jbFechar.setMnemonic('F');
        getContentPane().add(jbFechar);
        jbFechar.addActionListener(fecharJanela -> {
            dispose();
        });

    }

}
