package diskmanage;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class input2 extends JFrame {

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
	
	public input2(int n,int s,int mark) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 66, 506, 179);
		contentPane.add(textArea);
		
		JLabel label = new JLabel("Enter "+n+" requests in format <sector number> <sector delay> separate by space");
		label.setBounds(10, 11, 506, 44);
		contentPane.add(label);
		
		JButton btnRun = new JButton("RUN");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String us=textArea.getText();
				int[] a=new int[n];
				int[] b=new int[n];
				
				String[] parts=us.split(" ");
				int x=0;
				for(int i=0;i<2*n;i=i+2)
				{
					a[x]=Integer.parseInt(parts[i]);
					b[+x]=Integer.parseInt(parts[i+1]);
				
					x++;
				}
				switch(mark)
				{
				case 2:
					scan sc=new scan(n,s,a,b);
					sc.simulate();
					this.dispose();
					break;

				case 3:
					cscan csc=new cscan(n,s,a,b);
					csc.simulate();
					this.dispose();
					break;

				case 4:
					look l=new look(n,s,a,b);
					l.simulate();
					this.dispose();
					break;

				case 5:
					clook cl=new clook(n,s,a,b);
					cl.simulate();
					this.dispose();
					break;

				case 6:
					sstf ss=new sstf(n,s,a,b);
					ss.simulate();
					this.dispose();
					break;
				}
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		btnRun.setBounds(170, 256, 89, 23);
		contentPane.add(btnRun);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(281, 256, 89, 23);
		contentPane.add(btnExit);
	}
}
