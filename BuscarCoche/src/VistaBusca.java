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
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class VistaBusca extends JFrame {

	private JPanel contentPane;
	JTextField dirWeb;
	JTable table;
	JButton btnGO;
	JButton btnSalir;
	JButton btnWord;
	JButton btnPowerpoint;
	JButton btnExcel;
	JLabel lblGestinDeProgramas;
	JLabel lblIntroduceUnaDireccin;
	JButton btnLimpiarHistorial;
	 


	public VistaBusca() {
		setUndecorated(true);
		setResizable(false);
		setForeground(new Color(175, 238, 238));
		setTitle("Gesti\u00F3n Software PSP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dirWeb = new JTextField();
		dirWeb.setBorder(new LineBorder(new Color(135, 206, 250), 2, true));
		
		dirWeb.setToolTipText("");
		dirWeb.setBounds(30, 128, 432, 20);
		contentPane.add(dirWeb);
		dirWeb.setColumns(10);
		
		btnGO = new JButton("Go!!");
		btnGO.setForeground(new Color(30, 144, 255));
		btnGO.setBackground(new Color(255, 255, 255));
		btnGO.setBounds(512, 127, 73, 23);
		contentPane.add(btnGO);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Leelawadee", Font.PLAIN, 11));
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(30, 159, 555, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setForeground(new Color(255, 255, 255));
		table.setShowGrid(false);
		table.setFillsViewportHeight(true);
		table.setBorder(null);
		table.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		table.setBackground(new Color(135, 206, 250));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Direcciones registradas"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(415);
		scrollPane.setViewportView(table);
		
		btnSalir = new JButton("salir");
		btnSalir.setForeground(new Color(30, 144, 255));
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setBounds(496, 383, 89, 23);
		contentPane.add(btnSalir);
		
		btnWord = new JButton("WORD");
		btnWord.setForeground(new Color(30, 144, 255));
		btnWord.setBackground(new Color(255, 255, 255));
		btnWord.setBounds(30, 61, 140, 35);
		contentPane.add(btnWord);
		
		btnPowerpoint = new JButton("POWERPOINT\r\n");
		btnPowerpoint.setForeground(new Color(30, 144, 255));
		btnPowerpoint.setBackground(new Color(255, 255, 255));
		btnPowerpoint.setBounds(239, 61, 140, 35);
		contentPane.add(btnPowerpoint);
		
		btnExcel = new JButton("EXCEL");
		btnExcel.setForeground(new Color(30, 144, 255));
		btnExcel.setBackground(new Color(255, 255, 255));
		btnExcel.setBounds(443, 61, 140, 35);
		contentPane.add(btnExcel);
		
		lblGestinDeProgramas = new JLabel("Gesti\u00F3n de programas - PSP");
		lblGestinDeProgramas.setForeground(new Color(255, 255, 255));
		lblGestinDeProgramas.setFont(new Font("Candara", Font.PLAIN, 30));
		lblGestinDeProgramas.setBounds(30, 11, 395, 39);
		contentPane.add(lblGestinDeProgramas);
		
		lblIntroduceUnaDireccin = new JLabel("Introduce una direcci\u00F3n WEB o seleccione una de la lista");
		lblIntroduceUnaDireccin.setBackground(new Color(255, 255, 255));
		lblIntroduceUnaDireccin.setForeground(new Color(255, 255, 255));
		lblIntroduceUnaDireccin.setFont(new Font("Leelawadee", Font.PLAIN, 17));
		lblIntroduceUnaDireccin.setBounds(30, 96, 445, 35);
		contentPane.add(lblIntroduceUnaDireccin);
		
		JLabel lblDesignedByTwodesing = new JLabel("Designed by TwoDesing");
		lblDesignedByTwodesing.setForeground(new Color(255, 255, 255));
		lblDesignedByTwodesing.setFont(new Font("Levenim MT", Font.BOLD, 11));
		lblDesignedByTwodesing.setBounds(450, 417, 133, 14);
		contentPane.add(lblDesignedByTwodesing);
		
		btnLimpiarHistorial = new JButton("Limpiar historial");
		btnLimpiarHistorial.setForeground(new Color(30, 144, 255));
		btnLimpiarHistorial.setBackground(Color.WHITE);
		btnLimpiarHistorial.setBounds(30, 383, 162, 23);
		contentPane.add(btnLimpiarHistorial);
		

	}
		public void setControlador(Controlador c){
			btnSalir.addActionListener(c);
			btnExcel.addActionListener(c);
			btnGO.addActionListener(c);
			btnPowerpoint.addActionListener(c);
			btnWord.addActionListener(c);
			table.addMouseListener(c);
			btnLimpiarHistorial.addActionListener(c);
		}
}
