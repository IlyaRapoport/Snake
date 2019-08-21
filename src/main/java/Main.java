import javax.swing.*;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args){

        JFrame window = new JFrame();
        final Drawing drawing = new Drawing();
        window.add(drawing);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(615, 639);
        window.setTitle("Snake");
        window.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                StringBuffer inputBuffer = new StringBuffer();
                String input = JOptionPane.showInputDialog("Set your name");
                if (input.isEmpty()) input = "noName";
                String[] inputArray = input.split("\\s");
                for (int i = 0; i < inputArray.length; i++) {

                    char s1 = inputArray[i].charAt(0);
                    String s = String.valueOf(s1);

                    inputBuffer.append(s.toUpperCase()).append(inputArray[i].substring(1));
                }
                drawing.setInputName(inputBuffer.toString());
            }
        });
    }
}
