package diskmanage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Diskman extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JRadioButton cscan = new JRadioButton("CSCAN");
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diskman frame = new Diskman();
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
	public Diskman() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		buttonGroup.add(cscan);
		cscan.setBounds(22, 99, 77, 31);
		contentPane.add(cscan);
		
		JRadioButton look = new JRadioButton("LOOK");
		buttonGroup.add(look);
		look.setBounds(22, 133, 77, 31);
		contentPane.add(look);
		
		JRadioButton clook = new JRadioButton("CLOOK");
		buttonGroup.add(clook);
		clook.setBounds(22, 167, 77, 31);
		contentPane.add(clook);
		
		JRadioButton scan = new JRadioButton("SCAN");
		buttonGroup.add(scan);
		scan.setBounds(22, 65, 77, 31);
		contentPane.add(scan);
		
		JRadioButton fcfs = new JRadioButton("FCFS");
		buttonGroup.add(fcfs);
		fcfs.setBounds(22, 31, 77, 31);
		contentPane.add(fcfs);
		
		JRadioButton sstf = new JRadioButton("SSTF");
		buttonGroup.add(sstf);
		sstf.setBounds(22, 197, 77, 31);
		contentPane.add(sstf);
		
		textField = new JTextField();
		textField.setBounds(352, 36, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(352, 70, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("ENTER HEAD POSITION:");
		label.setBounds(147, 73, 195, 31);
		contentPane.add(label);
		
		JLabel lblEnterNumberOf = new JLabel("ENTER NUMBER OF REQUESTS:");
		lblEnterNumberOf.setBounds(147, 31, 195, 31);
		contentPane.add(lblEnterNumberOf);
		
		JButton btnSimulate = new JButton("SIMULATE");
		btnSimulate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=Integer.parseInt(textField.getText());
				int s=Integer.parseInt(textField_1.getText());
				
				if(fcfs.isSelected())
				{
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								inputnorm frame = new inputnorm(n,s);
								frame.setVisible(true);
								this.dispose();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}

						private void dispose() {
							setVisible(false);
							// TODO Auto-generated method stub
							
						}
					});

				}
				else
				{
									EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								int m=0;
								if(scan.isSelected())
									m=2;

								else if(cscan.isSelected())
									m=3;

								else if(look.isSelected())
									m=4;

								else if(clook.isSelected())
									m=5;

								else if(sstf.isSelected())
									m=6;

								input2 frame = new input2(n,s,m);
								frame.setVisible(true);
								this.dispose();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						private void dispose() {
							setVisible(false);
						}
					});
				}
			}
		});
		btnSimulate.setBounds(217, 201, 105, 23);
		contentPane.add(btnSimulate);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
			
		});
		btnExit.setBounds(349, 201, 89, 23);
		contentPane.add(btnExit);
		
	}
}
