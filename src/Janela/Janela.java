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
import src.Janela.JanelaRegistros;

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
        jtfAgencia.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                jtfAgencia.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            
        });

        MaskFormatter mascaraAgencia = null;
        try {
            mascaraAgencia = new MaskFormatter("####");
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
        }
        mascaraAgencia.install(jtfAgencia);

        //usar setText() é um desperdício de linha, viu?
        JLabel jlConta = new JLabel();
        jlConta.setText("Número da Conta:");
        jlConta.setBounds(190, 10, 105, 18);
        getContentPane().add(jlConta);

        JFormattedTextField jtfConta = new JFormattedTextField();
        jtfConta.setBounds(300, 10, 75, 20);
        getContentPane().add(jtfConta);
        jtfConta.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                jtfConta.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });

        MaskFormatter mascaraConta = null;
        try {
            mascaraConta = new MaskFormatter("########-#");
            mascaraConta.setPlaceholder("________-_");
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
        }
        mascaraConta.install(jtfConta);


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

        MaskFormatter mascaraTelefone = null;
        try {
            mascaraTelefone = new MaskFormatter("(##) #####-####");
            mascaraTelefone.setPlaceholder("(__) _____-____");
        } catch (ParseException e1) {

        }
        mascaraTelefone.install(jtfTelefone);

        jtfTelefone.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                jtfTelefone.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });

        //amém, você não pede mais setText() 🙏
        JLabel jlCpf = new JLabel("CPF:");
        jlCpf.setBounds(10, 125, 60, 18);
        jlCpf.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlCpf);

        JFormattedTextField jtfCpf = new JFormattedTextField();
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

        jtfCpf.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                jtfCpf.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });

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
        jbRegistros.addActionListener(abrirRegistros -> {
            if(id[0]<1){
                JOptionPane.showMessageDialog(null, "Não há nenhum registro cadastrado");
            }else{
                JanelaRegistros registros = new JanelaRegistros(id, cliente, contas);
                registros.setVisible(true);
            }
        });

        //mudei para cadastrar para fazer sentido
        //não faz sentido ter 2 botões para atualizar cadastro
        JButton jbCadastrar = new JButton("Cadastrar");
        jbCadastrar.setBounds(35, 190, 100, 23);
        jbCadastrar.setMnemonic('S');
        add(jbCadastrar);
        jbCadastrar.addActionListener(testandocadastro -> {

            if((jtfAgencia.getText().trim().equals(""))||(jtfConta.getText().trim().equals(""))||(jtfCpf.getText().trim().equals(""))||(jtfEndereco.getText().trim().equals(""))||(jtfNome.getText().trim().equals(""))||(jtfTelefone.getText().trim().equals(""))){
                JOptionPane.showMessageDialog(null, "Um dos campos de dados está vazio ou incompleto!");
            }else{
                //isso daqui é só um placeholder, ignora
                //eu só cadastrei primeiro com lixo de memória e atualizei depois
                cliente[id[0]] = new Cliente(WIDTH, getName(), getTitle(), getTitle(), getName());
                cliente[id[0]].gravar(jtfNome.getText().trim(), jtfEndereco.getText().trim(), jtfTelefone.getText().trim(), jtfCpf.getText().trim(), id[0], cliente);
                if(jrbPoupanca.isSelected()){
                    contas[id[0]] = new ContaPoupanca(WIDTH, ALLBITS, getName(), ABORT);
                    contas[id[0]].gravar(id[0], Integer.parseInt(jtfAgencia.getText().trim()), jtfConta.getText().trim(), 0.0, contas);
                }else{
                    contas[id[0]] = new ContaCorrente(WIDTH, ALLBITS, getName(), ABORT);
                    contas[id[0]].gravar(id[0], Integer.parseInt(jtfAgencia.getText().trim()), jtfConta.getText().trim(), 0.0, contas);
                }
                id[0] = id[0]+1;
                jbRegistros.setEnabled(true);
                jtfAgencia.setText("");
                jtfConta.setText("");
                jtfCpf.setText("");
                jtfEndereco.setText("");
                jtfNome.setText("");
                jtfTelefone.setText("");
            }
        });

        JButton jbFechar = new JButton("Fechar");
        jbFechar.setBounds(255, 190, 100, 23);
        jbFechar.setMnemonic('F');
        getContentPane().add(jbFechar);
        jbFechar.addActionListener(fecharJanela -> {
            dispose();
        });

    }

}
