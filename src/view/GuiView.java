package view;
import hopital.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GuiView{

	private JFrame frame;
	private JFrame nouveau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiView window = new GuiView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiView() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 169, 323);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frame.setResizable(false);
		
		JButton newService = new JButton("Nouveau Service");
		frame.getContentPane().add(newService);
		newService.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newService();
			}});
		
		JButton newPatient = new JButton("Nouveau Patient");
		frame.getContentPane().add(newPatient);
		newPatient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newPatient();
			}});
		
		JButton admissionPatient = new JButton("Admission Patient");
		frame.getContentPane().add(admissionPatient);
		admissionPatient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				admissionPatient();
			}});
		
		JButton annulationAttente = new JButton("Annulation Attente");
		frame.getContentPane().add(annulationAttente);
		annulationAttente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				annulationAttente();
			}});
		
		JButton afficherUnPatient = new JButton("afficherUnPatient");
		frame.getContentPane().add(afficherUnPatient);
		afficherUnPatient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				afficherUnPatient();
			}});
		
		JButton finHospitalisation = new JButton("fin Hospi");
		frame.getContentPane().add(finHospitalisation);
		finHospitalisation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				finHospi();
			}});
		
		JButton voirService = new JButton("voirService");
		frame.getContentPane().add(voirService);
		voirService.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				voirS();
			}});
		
		JButton voirPatient = new JButton("voirPatient");
		frame.getContentPane().add(voirPatient);
		voirPatient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				voirPatient();
			}});
		JButton voirAttente = new JButton("voirAttente");
		frame.getContentPane().add(voirAttente);
		voirAttente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				voirAttente();
			}});
		
	}
	public void newService(){
		nouveau = new JFrame("newService");
		nouveau.setVisible(true);
		nouveau.setBounds(100, 100, 435, 300);
		nouveau.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		nouveau.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		nouveau.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Menu North--------------------------------------------------
		JPanel North = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) North.getLayout();
		flowLayout_1.setHgap(15);
		contentPane.add(North, BorderLayout.NORTH);
		
		JPanel panelNorth = new JPanel();
		North.add(panelNorth);
		
		JTextPane txtNorth = new JTextPane();
		txtNorth.setText("Service - Nouveau Service");
		panelNorth.add(txtNorth);
				
		//Menu Sud------------------------------------------------------
		JPanel South = new JPanel();
		contentPane.add(South, BorderLayout.SOUTH);
		
		JButton btnSud = new JButton("Enregister\r\n");
		btnSud.setHorizontalAlignment(SwingConstants.RIGHT);
		South.add(btnSud);
		
		//----------------------------------------------------
		JPanel West = new JPanel();
		contentPane.add(West, BorderLayout.WEST);
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.WHITE);
		FlowLayout flowLayoutWest2 = (FlowLayout) panelWest.getLayout();
		flowLayoutWest2.setVgap(50);
		West.add(panelWest);
		
		JTextPane txtWest = new JTextPane();
		panelWest.add(txtWest);
		txtWest.setText("Veuillez insérer :\r\n\r\n-Nom : Nom du Service \r\n\r\n -Nombre de Lits : Le nombre \r\n de lits que contient le service");
		
		//Menu East-------------------------------------------------
		JPanel East = new JPanel();
		contentPane.add(East, BorderLayout.EAST);
		East.setLayout(new GridLayout(2, 0, 100, 0));
				
		JPanel panelEast1 = new JPanel();
		East.add(panelEast1);
		FlowLayout flowLayout1 = (FlowLayout) panelEast1.getLayout();
		flowLayout1.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabelNom = new JLabel("Nom service");
		panelEast1.add(lblNewLabelNom);
		
		JTextField textFieldNom = new JTextField();
		panelEast1.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JPanel panelEast2 = new JPanel();
		East.add(panelEast2);
		FlowLayout flowLayout_11 = (FlowLayout) panelEast2.getLayout();
		flowLayout_11.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabelNlits = new JLabel("Nombre de lits");
		panelEast2.add(lblNewLabelNlits);
		
		JTextField textFieldNlits = new JTextField();
		panelEast2.add(textFieldNlits);
		textFieldNlits.setColumns(10);
		
		btnSud.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nom = textFieldNom.getText();
				String a = textFieldNlits.getText();
				int lits = Integer.parseInt(a);
				new AjoutNomService(nom);
				new StructurationService(nom,lits);
				textFieldNom.setText("");
				textFieldNlits.setText("");
			}});
		
		
	}
	public void newPatient() {
		nouveau = new JFrame("admissionPatient");
		nouveau.setVisible(true);
		nouveau.setBounds(100, 100, 800, 400);
		nouveau.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		nouveau.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		nouveau.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Menu Nord--------------------------------------------------
		JPanel North = new JPanel();
		FlowLayout flowLayout_North = (FlowLayout) North.getLayout();
		flowLayout_North.setHgap(15);
		contentPane.add(North, BorderLayout.NORTH);
		
		JPanel panelNorth = new JPanel();
		North.add(panelNorth);
		
		JTextPane txtpnServiceNouveau = new JTextPane();
		txtpnServiceNouveau.setText("Service - Nouveau Patient");
		panelNorth.add(txtpnServiceNouveau);
		
		//Menu South----------------------------------------------------------
		JPanel South = new JPanel();
		contentPane.add(South, BorderLayout.SOUTH);
		
		JButton btnNewButtonSud = new JButton("Enregister\r\n");
		btnNewButtonSud.setHorizontalAlignment(SwingConstants.RIGHT);
		South.add(btnNewButtonSud);
		
		//Menu West --------------------------------------------------------
		JPanel West = new JPanel();
		contentPane.add(West, BorderLayout.WEST);
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.WHITE);
		FlowLayout flowLayout_West = (FlowLayout) panelWest.getLayout();
		flowLayout_West.setVgap(50);
		West.add(panelWest);
		
		JTextPane txtpnVoiciLeMenu = new JTextPane();
		panelWest.add(txtpnVoiciLeMenu);
		txtpnVoiciLeMenu.setText("Veuillez insérer :\r\n\r\n-Nom : Nom de famille du patient\r\n\r\n-Prenom : Prenom du patient"
				+ "\r\n\r\n-Genre : Le sexe du patient (M,F,T,N)\r\n\r\n-Naissance : La date de naissance \r\nau format yyyy-mm-dd \r\n\r\n-Téléphone : "
				+ "Numéro de téléphone \r\ndu patient ou référent");
		
		//Menu East-------------------------------------------------
		JPanel East = new JPanel();
		contentPane.add(East, BorderLayout.EAST);
		East.setLayout(new GridLayout(3, 0, 70, 0));
		
		JPanel panel_1 = new JPanel();
		East.add(panel_1);
		FlowLayout flowLayout1 = (FlowLayout) panel_1.getLayout();
		flowLayout1.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel = new JLabel("Nom : ");
		panel_1.add(lblNewLabel);
		
		JTextField textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		East.add(panel_2);
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom : ");
		panel_2.add(lblNewLabel_1);
		
		JTextField textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		East.add(panel_3);
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel_3 = new JLabel("Genre : ");
		panel_3.add(lblNewLabel_3);
		
		JTextField textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		East.add(panel_4);
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel_4 = new JLabel("Naissance : ");
		panel_4.add(lblNewLabel_4);
		
		JTextField textField_4 = new JTextField();
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		East.add(panel_5);
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel_5 = new JLabel("Téléphone : ");
		panel_5.add(lblNewLabel_5);
		
		JTextField textField_5 = new JTextField();
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		btnNewButtonSud.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String a = textField.getText();
				String b = textField_2.getText();
				char c = textField_3.getText().charAt(0);
				LocalDate d = LocalDate.parse(textField_4.getText());
				String ee = textField_5.getText();
				new AjoutPatient(a, b, c, d, ee);
				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}});
	}
	public void admissionPatient() {
		nouveau = new JFrame("admissionPatient");
		nouveau.setVisible(true);
		nouveau.setBounds(100, 100, 435, 282);
		nouveau.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		nouveau.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		nouveau.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Menu Nord--------------------------------------------------
		JPanel North = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) North.getLayout();
		flowLayout_1.setHgap(15);
		contentPane.add(North, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		North.add(panel_1);
		
		JTextPane txtpnServiceNouveau = new JTextPane();
		txtpnServiceNouveau.setText("Patient - Admission");
		panel_1.add(txtpnServiceNouveau);
		
		
		//Menu Sud----------------------------------------------------------
		JPanel South = new JPanel();
		contentPane.add(South, BorderLayout.SOUTH);
		
		JButton btnSud = new JButton("Enregister\r\n");
		btnSud.setHorizontalAlignment(SwingConstants.RIGHT);
		South.add(btnSud);
		
		
		//Menu West----------------------------------------------------
		JPanel West = new JPanel();
		contentPane.add(West, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(50);
		West.add(panel_2);
		
		JTextPane txtpnVoiciLeMenu = new JTextPane();
		panel_2.add(txtpnVoiciLeMenu);
		txtpnVoiciLeMenu.setText("Rentrez les informations \r\n-id du Service où le patient va\r\n-id du Patient admi.");
		
		//Menu East-------------------------------------------------
		JPanel East = new JPanel();
		contentPane.add(East, BorderLayout.EAST);
		East.setLayout(new GridLayout(2, 0, 100, 0));
				
		JPanel panel1 = new JPanel();
		East.add(panel1);
		FlowLayout flowLayout1 = (FlowLayout) panel1.getLayout();
		flowLayout1.setAlignment(FlowLayout.LEFT);
		
		JLabel LabelIdService = new JLabel("idService");
		panel1.add(LabelIdService);
		
		JTextField textField = new JTextField();
		panel1.add(textField);
		textField.setColumns(10);
		
		JPanel panel2 = new JPanel();
		East.add(panel2);
		FlowLayout flowLayout_11 = (FlowLayout) panel2.getLayout();
		flowLayout_11.setAlignment(FlowLayout.LEFT);
		
		JLabel LableIdPatient = new JLabel("idPatient");
		panel2.add(LableIdPatient);
		
		JTextField textField_1 = new JTextField();
		panel2.add(textField_1);
		textField_1.setColumns(10);
		
		btnSud.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(textField.getText());
				int b = Integer.parseInt(textField_1.getText());
				new MiseEnAttente(b, a);
				new AttributionPatient(b, a);
				textField.setText("");
				textField_1.setText("");
			}});
	}
	public void annulationAttente() {
		nouveau = new JFrame("annulationAttente");
		nouveau.setVisible(true);
		nouveau.setBounds(100, 100, 435, 282);
		nouveau.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		nouveau.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		nouveau.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Menu North--------------------------------------------------
		JPanel North = new JPanel();
		FlowLayout flowLayoutNord = (FlowLayout) North.getLayout();
		flowLayoutNord.setHgap(15);
		contentPane.add(North, BorderLayout.NORTH);
		
		JPanel panelNorth = new JPanel();
		North.add(panelNorth);
		
		JTextPane txtNorth = new JTextPane();
		txtNorth.setText("Patient - Annulation Attente");
		panelNorth.add(txtNorth);
		
		
		//Menu Sud----------------------------------------------------------
		JPanel South = new JPanel();
		contentPane.add(South, BorderLayout.SOUTH);
		
		JButton btnSud = new JButton("Enregister\r\n");
		btnSud.setHorizontalAlignment(SwingConstants.RIGHT);
		South.add(btnSud);
		
		
		//Menu West ----------------------------------------------------
		JPanel West = new JPanel();
		contentPane.add(West, BorderLayout.WEST);
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.WHITE);
		FlowLayout flowLayoutWest = (FlowLayout) panelWest.getLayout();
		flowLayoutWest.setVgap(50);
		West.add(panelWest);
		
		JTextPane txtWest = new JTextPane();
		panelWest.add(txtWest);
		txtWest.setText("Rentrez l'id\r\ncorrespondant au Patient\r\nquittant la file d'attente.");
		
		//Menu East-------------------------------------------------
		JPanel East = new JPanel();
		contentPane.add(East, BorderLayout.EAST);
		East.setLayout(new GridLayout(2, 0, 100, 0));
				
		JPanel panelId = new JPanel();
		East.add(panelId);
		FlowLayout flowLayoutId = (FlowLayout) panelId.getLayout();
		flowLayoutId.setAlignment(FlowLayout.LEFT);
		
		JLabel LabelId = new JLabel("Id Patient");
		panelId.add(LabelId);
		
		JTextField textField = new JTextField();
		panelId.add(textField);
		textField.setColumns(10);
		
		btnSud.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int idPatient = Integer.parseInt(textField.getText());
				new DesistementPatient(idPatient);
				textField.getText();				
			}});
	}
	public void afficherUnPatient() {
		nouveau = new JFrame("afficherUnPatient");
		nouveau.setVisible(true);
		nouveau.setBounds(100, 100, 435, 282);
		nouveau.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		nouveau.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		nouveau.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Menu--------------------------------------------------
		JPanel North = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) North.getLayout();
		flowLayout_1.setHgap(15);
		contentPane.add(North, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		North.add(panel_1);
		
		JTextPane txtpnServiceNouveau = new JTextPane();
		txtpnServiceNouveau.setText("Patient - AfficherUnPatient");
		panel_1.add(txtpnServiceNouveau);
		
		
		//----------------------------------------------------------
		JPanel South = new JPanel();
		contentPane.add(South, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Enregister\r\n");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		South.add(btnNewButton);
		
		
		//----------------------------------------------------
		JPanel West = new JPanel();
		contentPane.add(West, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(50);
		West.add(panel_2);
		
		JTextPane txtpnVoiciLeMenu = new JTextPane();
		panel_2.add(txtpnVoiciLeMenu);
		txtpnVoiciLeMenu.setText("Rentrez les informations \r\nrelatives au service\r\n dans les champs correspondant.");
		
		//Menu East-------------------------------------------------
		JPanel East = new JPanel();
		contentPane.add(East, BorderLayout.EAST);
		East.setLayout(new GridLayout(2, 0, 100, 0));
				
		JPanel panel_East = new JPanel();
		East.add(panel_East);
		FlowLayout flowLayout1 = (FlowLayout) panel_East.getLayout();
		flowLayout1.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel = new JLabel("idPatient");
		panel_East.add(lblNewLabel);
		
		JTextField textField = new JTextField();
		panel_East.add(textField);
		textField.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(textField.getText());
				AfficherUnPatient afficher = new AfficherUnPatient(a);
				String nom = afficher.getNom();
				String prenom = afficher.getPrenom();
				String genre = afficher.getGenre();
				Date naissance = afficher.getNaissance();
				String newNaissance = String.valueOf(naissance);
				String tel = afficher.getNumTel();
				int idPatient = a;
				modifier(nom, prenom, genre, newNaissance, tel, idPatient);
				textField.setText("");
			}});
	}
	public void modifier(String nom, String prenom, String genre, String naissance, String tel, int idPatient) {
		nouveau = new JFrame("admissionPatient");
		nouveau.setVisible(true);
		nouveau.setBounds(100, 100, 800, 400);
		nouveau.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		nouveau.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		nouveau.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Menu North--------------------------------------------------
		JPanel North = new JPanel();
		FlowLayout flowLayout_North = (FlowLayout) North.getLayout();
		flowLayout_North.setHgap(15);
		contentPane.add(North, BorderLayout.NORTH);
		
		JPanel panelNorth = new JPanel();
		North.add(panelNorth);
		
		JTextPane txtpnServiceNouveau = new JTextPane();
		txtpnServiceNouveau.setText("Service - Afficher Patient");
		panelNorth.add(txtpnServiceNouveau);
		
		
		//Menu South----------------------------------------------------------
		JPanel South = new JPanel();
		contentPane.add(South, BorderLayout.SOUTH);
		
		JButton btnSud = new JButton("Modifier\r\n");
		btnSud.setHorizontalAlignment(SwingConstants.RIGHT);
		South.add(btnSud);
		
		JPanel West = new JPanel();
		contentPane.add(West, BorderLayout.WEST);
		
		//Menu West --------------------------------------------------------
		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.WHITE);
		FlowLayout flowLayout_West = (FlowLayout) panelWest.getLayout();
		flowLayout_West.setVgap(50);
		West.add(panelWest);
		
		JTextPane txtpnVoiciLeMenu = new JTextPane();
		panelWest.add(txtpnVoiciLeMenu);
		txtpnVoiciLeMenu.setText("Veuillez insérer :\r\n\r\n-Nom : Nom de famille du patient\r\n\r\n-Prenom : Prenom du patient"
				+ "\r\n\r\n-Genre : Le sexe du patient (M,F,T,N)\r\n\r\n-Naissance : La date de naissance \r\nau format yyyy-mm-dd \r\n\r\n-Téléphone : "
				+ "Numéro de téléphone \r\ndu patient ou référent");
		
		//Menu East-------------------------------------------------
		JPanel East = new JPanel();
		contentPane.add(East, BorderLayout.EAST);
		East.setLayout(new GridLayout(3, 0, 70, 0));
		
		JPanel panel_1 = new JPanel();
		East.add(panel_1);
		FlowLayout flowLayout1 = (FlowLayout) panel_1.getLayout();
		flowLayout1.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel = new JLabel("Nom : ");
		panel_1.add(lblNewLabel);
		
		JTextField textField = new JTextField(nom);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		East.add(panel_2);
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom : ");
		panel_2.add(lblNewLabel_1);
		
		JTextField textField_2 = new JTextField(prenom);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		East.add(panel_3);
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel_3 = new JLabel("Genre : ");
		panel_3.add(lblNewLabel_3);
		
		JTextField textField_3 = new JTextField(genre);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		East.add(panel_4);
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel_4 = new JLabel("Naissance : ");
		panel_4.add(lblNewLabel_4);
		
		JTextField textField_4 = new JTextField(naissance);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		East.add(panel_5);
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel_5 = new JLabel("Téléphone : ");
		panel_5.add(lblNewLabel_5);
		
		JTextField textField_5 = new JTextField(tel);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		btnSud.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String a = textField.getText();
				String b = textField_2.getText();
				char c = textField_3.getText().charAt(0);
				LocalDate d = LocalDate.parse(textField_4.getText());
				String ee = textField_5.getText();
				new ModifierPatient(a, b, c, d, ee, idPatient);
				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}});
	}
	public void finHospi() {
		nouveau = new JFrame("afficherUnPatient");
		nouveau.setVisible(true);
		nouveau.setBounds(100, 100, 435, 282);
		nouveau.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		nouveau.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		nouveau.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Menu North--------------------------------------------------
		JPanel North = new JPanel();
		FlowLayout flowLayoutNorth = (FlowLayout) North.getLayout();
		flowLayoutNorth.setHgap(15);
		contentPane.add(North, BorderLayout.NORTH);
		
		JPanel panelNorth = new JPanel();
		North.add(panelNorth);
		
		JTextPane txtpnServiceNouveau = new JTextPane();
		txtpnServiceNouveau.setText("Patient - Fin Hospitalisation");
		panelNorth.add(txtpnServiceNouveau);
		
		
		//Menu South----------------------------------------------------------
		JPanel South = new JPanel();
		contentPane.add(South, BorderLayout.SOUTH);
		
		JButton btnSud = new JButton("Enregister\r\n");
		btnSud.setHorizontalAlignment(SwingConstants.RIGHT);
		South.add(btnSud);
		
		
		//Menu West----------------------------------------------------
		JPanel West = new JPanel();
		contentPane.add(West, BorderLayout.WEST);
		
		JPanel panelWest = new JPanel();
		panelWest .setBackground(Color.WHITE);
		FlowLayout flowLayoutWest = (FlowLayout) panelWest .getLayout();
		flowLayoutWest.setVgap(50);
		West.add(panelWest );
		
		JTextPane txtpnVoiciLeMenu = new JTextPane();
		panelWest .add(txtpnVoiciLeMenu);
		txtpnVoiciLeMenu.setText("Rentrez l'id \r\nrelatif au patient  sortant.");
		
		//Menu East-------------------------------------------------
		JPanel East = new JPanel();
		contentPane.add(East, BorderLayout.EAST);
		East.setLayout(new GridLayout(2, 0, 100, 0));
				
		JPanel panel_East = new JPanel();
		East.add(panel_East);
		FlowLayout flowLayout1 = (FlowLayout) panel_East.getLayout();
		flowLayout1.setAlignment(FlowLayout.LEFT);
		
		JLabel LabelId = new JLabel("idPatient");
		panel_East.add(LabelId);
		
		JTextField textField = new JTextField();
		panel_East.add(textField);
		textField.setColumns(10);
		
		btnSud.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				int idPatient = Integer.parseInt(textField.getText());
				new ResiliationPatient(idPatient);
				textField.setText("");
			}});
	}
	public void voirS() {
		new VoirService();
	}
	public void voirPatient() {
		new VoirPatient();
	}
	public void voirAttente() {
		new VoirAttente();
	}
}
