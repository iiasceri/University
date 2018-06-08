package error_repair;

import javax.swing.JOptionPane;

public class Interfata {
    
    public int ft_in(String text) {
        String something_string = JOptionPane.showInputDialog(text);
        int something_int = Integer.parseInt(something_string);
        return something_int;
    }
    
    public void ft_out(String text, String tittle) {
        JOptionPane.showMessageDialog(null, text, tittle, JOptionPane.PLAIN_MESSAGE);
    }
}
