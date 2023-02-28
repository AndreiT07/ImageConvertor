//Aceasta clasa permite selectarea fisierului
package packWork;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ChooseFile extends JFrame {
	private String nume;
	private JPanel contentPane;
	private JTextField txtFile;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseFile frame = new ChooseFile();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public String getNume() {
		return nume;
	}


	public void setNume(String nume) {
		this.nume = nume;
	}


	/**
	 * Create the frame.
	 */
	
	public ChooseFile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Choose File");
		btnNewButton.setBounds(5, 125, 111, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(chooser);
			chooser.setVisible(true);
			setNume(chooser.getSelectedFile().toString());
			txtFile.setText(getNume());
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		txtFile = new JTextField();
		txtFile.setBounds(5, 5, 210, 120);
		txtFile.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(txtFile);
		txtFile.setColumns(10);
		txtFile.setCaretColor(Color.WHITE);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnConvert.setBounds(118, 125, 97, 25);
		contentPane.add(btnConvert);
		
	}
	
}
