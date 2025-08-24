package src.Janela;
//não sei oque é esse tal de package, mas o Vscode mandou colocar
//consegui compilar isso daqui de primeira, só chutando que era pra colocr ./src/Janela/Janela.java
//pae que é pae é pae né pae
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import src.Janela.JanelaRegistros;
import src.Metodos.*;


public class Janela extends JFrame {

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

    public Janela(){

        int[] id = new int[2];
        id[0] = 0;
        Pessoa[] cliente = new Cliente[10];
        Conta[] contas = new Conta[10];
        Mascaras mascaras = new Mascaras();
        MouseListeners listeners = new MouseListeners();
        ActionListeners actionListeners = new ActionListeners();

        setSize(400, 255);
        setTitle("Java Swing - Desenvolvimento de Sistemas");
        centralizar();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);


        JLabel jlAgencia = new JLabel();
        jlAgencia.setBounds(10, 10, 110, 18);
        //quem é o maluco que usa setText() ao invés de só instanciar o negócio com o texto normal? Tipo, você pode passar uma string ali exatamente pra isso
        jlAgencia.setText("Código da Agência:");
        add(jlAgencia);

        JFormattedTextField jtfAgencia = new JFormattedTextField();
        jtfAgencia.setBounds(125, 10, 50,20);
        getContentPane().add(jtfAgencia);
        listeners.listenerAgencia(jtfAgencia);
        mascaras.mascaraAgencia(jtfAgencia);

        //usar setText() é um desperdício de linha, viu?
        JLabel jlConta = new JLabel();
        jlConta.setText("Número da Conta:");
        jlConta.setBounds(190, 10, 105, 18);
        getContentPane().add(jlConta);

        JFormattedTextField jtfConta = new JFormattedTextField();
        jtfConta.setBounds(300, 10, 75, 20);
        getContentPane().add(jtfConta);
        listeners.listenerConta(jtfConta);
        mascaras.mascaraConta(jtfConta);

        JSeparator jSeparator01 = new JSeparator();
        jSeparator01.setBounds(10, 40, 365, 10);
        getContentPane().add(jSeparator01);

        //você não mandou usar setText() 😎😎😎😎😎
        JLabel jlNome = new JLabel("Nome:");
        jlNome.setBounds(10, 50, 60, 18);
        jlNome.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlNome);

        JTextField jtfNome = new JTextField();
        jtfNome.setBounds(75, 50, 300, 20);
        add(jtfNome);

        JLabel jlEndereco = new JLabel("Endereço:");
        jlEndereco.setBounds(10, 75, 60, 18);
        jlEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlEndereco);

        JTextField jtfEndereco = new JTextField();
        jtfEndereco.setBounds(75, 75, 300, 20);
        add(jtfEndereco);

        JLabel jlTelefone = new JLabel("Telefone:");
        jlTelefone.setBounds(10, 100, 60, 18);
        jlTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlTelefone);

        JFormattedTextField jtfTelefone = new JFormattedTextField();
        jtfTelefone.setBounds(75, 100, 300, 20);
        add(jtfTelefone);
        mascaras.mascaraTelefone(jtfTelefone);
        listeners.listenerTelefone(jtfTelefone);

        //amém, você não pede mais setText() 🙏
        JLabel jlCpf = new JLabel("CPF:");
        jlCpf.setBounds(10, 125, 60, 18);
        jlCpf.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlCpf);

        JFormattedTextField jtfCpf = new JFormattedTextField();
        jtfCpf.setBounds(75, 125, 300, 20);
        add(jtfCpf);
        mascaras.mascaraCpf(jtfCpf);
        listeners.listenerCpf(jtfCpf);

        ButtonGroup bgContas = new ButtonGroup();

        JRadioButton jrbCorrente = new JRadioButton("Corrente");
        jrbCorrente.setBounds(100, 150, 111, 20);
        jrbCorrente.setMnemonic('C');
        jrbCorrente.setSelected(true);
        add(jrbCorrente);
        bgContas.add(jrbCorrente);

        JRadioButton jrbPoupanca = new JRadioButton("Poupança");
        jrbPoupanca.setBounds(225, 150, 118, 20);
        jrbPoupanca.setMnemonic('P');
        add(jrbPoupanca);
        bgContas.add(jrbPoupanca);

        JSeparator jSeparator02 = new JSeparator();
        jSeparator02.setBounds(10, 180, 365, 10);
        add(jSeparator02);

        JButton jbRegistros = new JButton("Registros");
        jbRegistros.setBounds(145, 190, 100, 23);
        jbRegistros.setMnemonic('A');
        jbRegistros.setEnabled(false);
        add(jbRegistros);
        jbRegistros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                actionListeners.abrirRegistros(id, cliente, contas);
            }
        });

        //mudei para cadastrar para fazer sentido
        //não faz sentido ter 2 botões para atualizar cadastro
        JButton jbCadastrar = new JButton("Cadastrar");
        jbCadastrar.setBounds(35, 190, 100, 23);
        jbCadastrar.setMnemonic('S');
        add(jbCadastrar);
        jbCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListeners.cadastrarRegistro(jtfAgencia, jtfConta, jtfNome, jtfEndereco, jtfTelefone, jtfCpf, jrbPoupanca, contas, id, cliente, jbRegistros);
            };
        });

        JButton jbFechar = new JButton("Fechar");
        jbFechar.setBounds(255, 190, 100, 23);
        jbFechar.setMnemonic('F');
        getContentPane().add(jbFechar);
        jbFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                actionListeners.fecharJanela(Janela.this);
            };
        });

    }

}
