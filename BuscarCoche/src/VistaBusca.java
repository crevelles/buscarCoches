import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class VistaBusca extends JFrame {

	private JPanel contentPane;
	JTextField textMin;
	JTextField textMax;
	 JTable table;
	JButton btnBuscar;
	JButton btnSalir;
	 JLabel lblError;


	public VistaBusca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textMin = new JTextField();
		textMin.setBounds(192, 74, 106, 20);
		contentPane.add(textMin);
		textMin.setColumns(10);
		
		textMax = new JTextField();
		textMax.setColumns(10);
		textMax.setBounds(334, 74, 99, 20);
		contentPane.add(textMax);
		
		btnBuscar = new JButton("buscar");
		btnBuscar.setBounds(475, 73, 89, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 121, 532, 214);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Marca", "Modelo", "Matricula", "Precio"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(142);
		table.getColumnModel().getColumn(1).setPreferredWidth(194);
		table.getColumnModel().getColumn(2).setPreferredWidth(154);
		table.getColumnModel().getColumn(3).setPreferredWidth(128);
		scrollPane.setViewportView(table);
		
		btnSalir = new JButton("salir");
		btnSalir.setBounds(475, 348, 89, 23);
		contentPane.add(btnSalir);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblError.setForeground(Color.RED);
		lblError.setBounds(30, 346, 390, 23);
		contentPane.add(lblError);
	}
		public void setControlador(Controlador c){
			btnBuscar.addActionListener(c);
			btnSalir.addActionListener(c);
		}
}
