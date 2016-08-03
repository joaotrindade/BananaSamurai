package graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.PlayerScore;


/**
 * JDialog para receber nome do jogador
 * @author Joao Trindade & Paulo Marcos
 *
 */
@SuppressWarnings("serial")
public class GetPlayerInfo extends JDialog {
	private JTextField nameField;
	
	/** Criacao da janela JDialog */
	public static void main(String[] args) {
			GetPlayerInfo dialog = new GetPlayerInfo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
	}
	
	public GetPlayerInfo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.out.println("Dialog a fechar");
				GameWindow.painel1.setVisible(false);
				GameWindow.painel1.setFocusable(false);
				GameWindow.painelMenu.setVisible(true);
				GameWindow.painelMenu.setFocusable(true);
				GameWindow.painelMenu.requestFocusInWindow(); 
				dispose();
			}
		});
		
		final PlayerScore tempScore = new PlayerScore();
		final Calendar tempCal = Calendar.getInstance();
		
		setTitle("Enter your name");
		setBounds(100, 100, 301, 171);
		getContentPane().setLayout(null);
		
		nameField = new JTextField();
		nameField.setBounds(10, 24, 166, 20);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempScore.setPlayerName(nameField.getText());
				tempScore.setDate(tempCal);
				tempScore.setScore(GameWindow.cut_points);
				GameWindow.highscores.add(tempScore);
				GameWindow.painel1.setVisible(false);
				GameWindow.painel1.setFocusable(false);
				GameWindow.painelMenu.setVisible(true);
				GameWindow.painelMenu.setFocusable(true);
				GameWindow.painelMenu.requestFocusInWindow(); 
				dispose();
			}
		});
		
		btnOK.setBounds(186, 23, 89, 23);
		getContentPane().add(btnOK);
		
		JLabel lblSelectPath = new JLabel("Enter Your Name:");
		lblSelectPath.setBounds(10, 11, 100, 14);
		getContentPane().add(lblSelectPath);
		
		
		
	}

}
