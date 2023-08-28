package views;

import controladores.controladorHues;
import controladores.controladorRegH;
import modelos.huesped;
import modelos.registroH;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;
	controladorHues cH;
	controladorRegH rH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		panel.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				
				if(panel.getSelectedIndex() == 0){
					
					tbHuespedes.clearSelection();
				}else{
					tbReservas.clearSelection();
					
				}
			}
		});
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,
												 "Desea cerrar sesion?",
												 "Confirmar",
												 JOptionPane.YES_NO_OPTION,
												 JOptionPane.WARNING_MESSAGE) == 0){
					
					MenuPrincipal principal = new MenuPrincipal();
					principal.setVisible(true);
					dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cH = new controladorHues();
				
				ArrayList<Object> arr;
				
				if(tryLong(txtBuscar.getText())){
					
					arr = new ArrayList(cH.buscarP(Long.parseLong(txtBuscar.getText())));
					
					if(!arr.isEmpty()){
						
						modeloHuesped.setRowCount(0);
						modelo.setRowCount(0);
						
						modeloHuesped.addRow(new String[]{
								arr.get(0).toString(),
								arr.get(1).toString(),
								arr.get(2).toString(),
								arr.get(3).toString(),
								arr.get(4).toString(),
								arr.get(5).toString(),
								arr.get(6).toString()
						});
						
						modelo.addRow(new String[]{
								arr.get(7).toString(),
								arr.get(8).toString(),
								arr.get(9).toString(),
								arr.get(10).toString(),
								arr.get(11).toString()
						});
					}else{
						
						JOptionPane.showMessageDialog(null, "No se encontro informacion.");
					}
				}else{
					
					arr = new ArrayList(cH.buscarP(txtBuscar.getText()));
					
					if(!arr.isEmpty()){
						
						modeloHuesped.setRowCount(0);
						modelo.setRowCount(0);
						
						arr.forEach(datos -> {
							
							ArrayList<String> arr2 = (ArrayList<String>) datos;
							
							modeloHuesped.addRow(new String[]{
									arr2.get(0),
									arr2.get(1),
									arr2.get(2),
									arr2.get(3),
									arr2.get(4),
									arr2.get(5),
									arr2.get(6)
							});
							
							modelo.addRow(new String[]{
									arr2.get(7),
									arr2.get(8),
									arr2.get(9),
									arr2.get(10),
									arr2.get(11)
							});
						});
						
					}else{
						
						JOptionPane.showMessageDialog(null, "No se encontro informacion.");
					}
				}
				
				panel.setSelectedIndex(panel.getSelectedIndex());
				panel.updateUI();
				
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
				
				try{
					if(tbHuespedes.getSelectedRow() >= 0){
						
						huesped h = new huesped(
								
								Long.parseLong(tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(),
																	 0).toString()),
								tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 1).toString(),
								tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 2).toString(),
								fmt.parse(tbHuespedes.getValueAt(
										tbHuespedes.getSelectedRow(),
										3).toString()),
								tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 4).toString(),
								Long.parseLong(tbHuespedes.getValueAt(
										tbHuespedes.getSelectedRow(),5).toString()),
								Long.parseLong(tbHuespedes.getValueAt(tbHuespedes.getSelectedRow()
										, 6).toString())
							
							
						);
						
						cH.actualizarH(h);
						mostrarD();
					}
					if(tbReservas.getSelectedRow() >= 0){
						
						registroH r = new registroH(
								Long.parseLong(tbReservas.getValueAt(tbReservas.getSelectedRow(),
													  0).toString()),
								fmt.parse(tbReservas.getValueAt(
										tbReservas.getSelectedRow(),
										1).toString()),
								fmt.parse(tbReservas.getValueAt(
										tbReservas.getSelectedRow(),
										2).toString()),
								new BigDecimal(tbReservas.getValueAt(tbReservas.getSelectedRow(),
																	 3).toString()) ,
								tbReservas.getValueAt(tbReservas.getSelectedRow(), 4).toString()
							
								
						);
						rH = new controladorRegH();
						
						rH.actualizarH(r);
						mostrarD();
					}
				}catch(ParseException ex){
					throw new RuntimeException(ex);
				}
				
			}
		});
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				
				rH = new controladorRegH();
				
				if(tbHuespedes.getSelectedRow() >= 0){
					
					cH.eliminarH(Long.parseLong(tbHuespedes.getValueAt(
							tbHuespedes.getSelectedRow(),
							0).toString()));
					rH.eliminarH(Long.parseLong(tbHuespedes.getValueAt(
							tbHuespedes.getSelectedRow(),
							6).toString()));
					mostrarD();
				}
				if(tbReservas.getSelectedRow() >= 0){
					
					cH.eliminarH(Long.parseLong(tbReservas.getValueAt(
							tbReservas.getSelectedRow(),
							0).toString()));
					rH.eliminarH(Long.parseLong(tbReservas.getValueAt(
							tbReservas.getSelectedRow(),
							0).toString()));
					mostrarD();
				}
			}
		});
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
		
		mostrarD();
	}
	
	public void mostrarD(){
		
		cH = new controladorHues();
		
		modeloHuesped.setRowCount(0);
		modelo.setRowCount(0);
		
		cH.obtenerD().forEach(datos -> {
			modeloHuesped.addRow(new String[]{
					datos[0],
					datos[1],
					datos[2],
					datos[3],
					datos[4],
					datos[5],
					datos[6]
			});
			
			modelo.addRow(new String[]{
					datos[7],
					datos[8],
					datos[9],
					datos[10],
					datos[11]
			});
		});
	}
	
	public boolean tryLong(String id){
		
		boolean conver;
		
		try{
			
			Long.parseLong(id);
			conver = true;
		}catch(Exception ex){
			
			conver = false;
		}
		
		return conver;
	}
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
