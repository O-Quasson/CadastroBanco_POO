package src.Janela;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import src.Classes.*;
import src.Metodos.ActionListeners;

public class JanelaRegistros extends JFrame {
    
    public JanelaRegistros(int[] id, Pessoa[] clientes, Conta[] contas){
        ActionListeners actionListeners = new ActionListeners();

        setSize(400, 400);
        setTitle("Lista de Registros");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel texto = new JLabel("Escolha um dos registros abaixo: ");
        texto.setFont(new Font("Dialog", Font.BOLD, 15));
        add(texto);
        texto.setBounds(10, 25, 250, 25);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        //passei 20 minutos procurando o porquê meu scroll não funcionava antes de eu descobrir que é porque eu sou obrigado a usar esse comando esquisitão
        painel.setPreferredSize(new Dimension(250, id[0]*60));

        JButton[] botaoCliente = new JButton[id[0]];

        //quase 2 horas alterando esse código direto, só pra descobrir agr que esse capeta de arquivo não tava compilando
        //POR QUE MEU VSCODE TÁ DANDO ERRO EM UM COMENTÁRIO???????? 
        for(int[] i = {0,1}; i[0] < id[0]; i[0]++){
            botaoCliente[i[0]] = new JButton(clientes[i[0]].getnome());
            botaoCliente[i[0]].setBounds(25, (60*i[0]), 250, 40);
            int idItem = i[0];
            botaoCliente[i[0]].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    actionListeners.acessarRegistro(idItem, id, contas, clientes, JanelaRegistros.this);
                }
            });
            painel.add(botaoCliente[i[0]]);
        }

        //a scrollbar não vinha por padrão, por algum motivo, então eu tive que declarar ela
        JScrollPane scroll = new JScrollPane(painel);
        scroll.setVerticalScrollBar(new JScrollBar());
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scroll);
        scroll.setBounds(50, 75, 300, 250);
        
    }
}
