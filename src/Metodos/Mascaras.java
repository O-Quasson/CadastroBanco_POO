package src.Metodos;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import javax.swing.JFormattedTextField;

public class Mascaras {

    public void mascaraCpf(JFormattedTextField campo){
        MaskFormatter mascaraCpf = null;
        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraCpf.setPlaceholder("___.___.___.-__");
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
        }

        mascaraCpf.install(campo);
    }

    public void mascaraAgencia(JFormattedTextField campo){
        MaskFormatter mascaraAgencia = null;
        try {
            mascaraAgencia = new MaskFormatter("####");
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
        }
        mascaraAgencia.install(campo);
    }

    public void mascaraConta(JFormattedTextField campo){
        MaskFormatter mascaraConta = null;
        try {
            mascaraConta = new MaskFormatter("########-#");
            mascaraConta.setPlaceholder("________-_");
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
        }
        mascaraConta.install(campo);
    }

    public void mascaraTelefone(JFormattedTextField campo){
        MaskFormatter mascaraTelefone = null;
        try {
            mascaraTelefone = new MaskFormatter("(##) #####-####");
            mascaraTelefone.setPlaceholder("(__) _____-____");
        } catch (ParseException e1) {

        }
        mascaraTelefone.install(campo);
    }
    
}
