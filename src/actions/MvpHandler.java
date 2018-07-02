package actions;

import javax.swing.*;
import java.awt.event.*;

public class MvpHandler extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textArea1;
    private OnGenerateListener listener;

    public void setOnGenerateListener(OnGenerateListener listener) {
        this.listener = listener;
    }

    public MvpHandler() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> listener.onGenerate(textArea1.getText().trim()));

        buttonCancel.addActionListener(e -> listener.onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                listener.onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> listener.onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public interface OnGenerateListener{
        void onGenerate(String text);
        void onCancel();
    }


}
