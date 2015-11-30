package diskmanage;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class inputnorm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public inputnorm(int n,int s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 66, 506, 179);
		contentPane.add(textArea);
		
		JLabel label = new JLabel("Enter "+n+" requests in format <sector number> separate by space");
		label.setBounds(10, 11, 506, 44);
		contentPane.add(label);
		
		JButton btnRun = new JButton("RUN");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String us=textArea.getText();
				int[] a=new int[n];
				//System.out.println("YO"+ "---------   "+s.substring(2,3));
				String[] parts=us.split(" ");
				for(int i=0;i<n;i++)
				{
					a[i]=Integer.parseInt(parts[i]);
				}
				fcfs ss=new fcfs(n,s,a);
				ss.simulate();
				this.dispose();
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		btnRun.setBounds(183, 256, 89, 23);
		contentPane.add(btnRun);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(307, 256, 89, 23);
		contentPane.add(btnExit);
	}
}
