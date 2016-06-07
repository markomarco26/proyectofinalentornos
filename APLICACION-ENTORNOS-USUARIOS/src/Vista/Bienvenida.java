package Vista;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Bienvenida extends JFrame {

	private Principal principal;

	public void setprincipal(Principal principal) {
		this.principal = principal;
	}

	public Bienvenida() {
		getContentPane().setBackground(new Color(173, 216, 230));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				principal.setVisible(true);
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(Bienvenida.class.getResource("/imagenes/logo2.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 819, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		setBounds(100, 100, 783, 476);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
