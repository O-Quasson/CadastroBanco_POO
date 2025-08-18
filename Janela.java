import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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

        JTextField jtfAgencia = new JTextField();
        jtfAgencia.setBounds(125, 10, 50,20);
        getContentPane().add(jtfAgencia);

        //usar setText() é um desperdício de linha, viu?
        JLabel jlConta = new JLabel();
        jlConta.setText("Número da Conta:");
        jlConta.setBounds(205, 10, 105, 18);
        getContentPane().add(jlConta);

        JTextField jtfConta = new JTextField();
        jtfConta.setBounds(315, 10, 60, 20);
        getContentPane().add(jtfConta);

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
        jlEndereco.setBounds(10, 120-50, 80-20, 20-2);
        jlEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlEndereco);

        JTextField jtfEndereco = new JTextField();
        jtfEndereco.setBounds(75, 75, 300, 20);
        add(jtfEndereco);

        JLabel jlTelefone = new JLabel("Telefone:");
        jlTelefone.setBounds(10, 100, 60, 18);
        jlTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlTelefone);

        JTextField jtfTelefone = new JTextField();
        jtfTelefone.setBounds(75, 100, 300, 20);
        add(jtfTelefone);

        //amém, você não pede mais setText() 🙏
        JLabel jlCpf = new JLabel("CPF:");
        jlCpf.setBounds(10, 125, 60, 18);
        jlCpf.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlCpf);

        JTextField jtfCpf = new JTextField();
        jtfCpf.setBounds(75, 125, 300, 20);
        add(jtfCpf);

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

        JButton jbConsultar = new JButton("Consultar");
        jbConsultar.setBounds(35, 190, 100, 23);
        jbConsultar.setMnemonic('S');
        add(jbConsultar);

        JButton jbAtualizar = new JButton("Atualizar");
        jbAtualizar.setBounds(145, 190, 100, 23);
        jbAtualizar.setMnemonic('A');
        jbAtualizar.setEnabled(false);
        add(jbAtualizar);

        JButton jbFechar = new JButton("Fechar");
        jbFechar.setBounds(255, 190, 100, 23);
        jbFechar.setMnemonic('F');
        getContentPane().add(jbFechar);

    }

    public static void main(String[] args) {
        Janela frame = new Janela();
        frame.setVisible(true);
    }

}
