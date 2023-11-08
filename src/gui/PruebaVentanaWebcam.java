package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;

import com.github.sarxos.webcam.Webcam;

public class PruebaVentanaWebcam extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaVentanaWebcam frame = new PruebaVentanaWebcam();
					BasicConfigurator.configure();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PruebaVentanaWebcam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnCapturar = new JButton("Capturar Foto C\u00E1mara");
		btnCapturar.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnCapturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tomarFoto();
			}
		});
		contentPane.add(btnCapturar);
	}

	protected void tomarFoto() {
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		try {
			ImageIO.write(webcam.getImage(), "PNG", new File("hello-world.png"));
			webcam.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
