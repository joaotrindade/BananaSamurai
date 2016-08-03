package graphic;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.Game;
/**
 * Painel de Settings
 * @author Joao Trindade & Paulo Marcos
 *
 */
@SuppressWarnings("serial")
public class SettingsPanel extends JPanel implements MouseListener {
	
	public SettingsPanel() {
		super();
		addMouseListener(this);
		this.setLayout(null);
		
		final JButton btnMusic = new JButton("On/Off");
		final JLabel lblMusic = new JLabel("Game Music");
		final JLabel lblFundo = new JLabel("Game Wallpaper");
		final JLabel lblTime = new JLabel("Game Time");
		
		lblMusic.setBounds(300,280,70,20);
		lblFundo.setBounds(300,380,100,20);
		lblTime.setBounds(300,480,100,20);
		
		btnMusic.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMusic.setBounds(400, 280, 70, 23);
		btnMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.startStopMusic(GameWindow.playingMusic);
			}
		});
		
		final JComboBox<String> comboBoxWall = new JComboBox<String>();
		comboBoxWall.setBounds(400, 380, 139, 28);
		comboBoxWall.addItem("Wood");
		comboBoxWall.addItem("Wave");
		comboBoxWall.addItem("Bamboo");
		comboBoxWall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxWall.getSelectedIndex() == 0)
				{
					GameWindow.GameWall="Imagens/Wood.jpg";
				}
				else if(comboBoxWall.getSelectedIndex() == 1)
				{
					GameWindow.GameWall="Imagens/Wave.jpg";
				}
				else
				{
					GameWindow.GameWall="Imagens/Bamboo.jpg";
				}
					
			}
		});
		
		final JComboBox<String> comboBoxTime= new JComboBox<String>();
		comboBoxTime.setBounds(400, 480, 139, 28);
		comboBoxTime.addItem("60s");
		comboBoxTime.addItem("120s");
		comboBoxTime.addItem("240s");
		comboBoxTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxTime.getSelectedIndex() == 0)
				{
					GameWindow.gameLenght=60;
				}
				else if(comboBoxTime.getSelectedIndex() == 1)
				{
					GameWindow.gameLenght=120;
				}
				else
				{
					GameWindow.gameLenght=240;
				}
					
			}
		});
		
		this.add(btnMusic);
		this.add(lblMusic);
		this.add(lblFundo);
		this.add(lblTime);
		this.add(comboBoxWall);
		this.add(comboBoxTime);
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("Imagens/settings_bg.png").getImage(), 0,0,null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getX() > 1185 && e.getX() < 1245 && e.getY()>31 && e.getY() < 91 )
		{
			System.out.println("GO BACK");
			this.setVisible(false);
			this.setFocusable(false);
			GameWindow.painelMenu.setVisible(true);
			GameWindow.painelMenu.setFocusable(true);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
