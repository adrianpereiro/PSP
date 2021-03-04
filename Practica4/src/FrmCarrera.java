
import java.util.Observable;
import java.util.Observer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JSlider;

public class FrmCarrera extends javax.swing.JFrame implements Observer {

	private Thread[] hilos;
	JSlider slHilo2 = new JSlider(1, 10);

	JSlider slHilo3 = new JSlider(1, 10);

	JSlider slHilo1 = new JSlider(1, 10);

	public FrmCarrera() {
		initComponents();
		hilos = new Thread[3];
	}

	@SuppressWarnings("unchecked")

	public void initComponents() {

		pg1 = new javax.swing.JProgressBar();
		pg1.setStringPainted(true);

		jLabel1 = new javax.swing.JLabel();

		pg2 = new javax.swing.JProgressBar();
		pg2.setStringPainted(true);

		jLabel2 = new javax.swing.JLabel();

		pg3 = new javax.swing.JProgressBar();
		pg3.setStringPainted(true);

		jLabel3 = new javax.swing.JLabel();

		btnIniciar = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		lblGanador = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Hilo 0");

		jLabel2.setText("Hilo 1");

		jLabel3.setText("Hilo 2");

		btnIniciar.setText("Comenzar Carrera");
		btnIniciar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnIniciarActionPerformed(evt);
			}
		});

		jLabel5.setText("El ganador es: ");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(8)
							.addComponent(jLabel1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pg1, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(jLabel3)
								.addComponent(jLabel2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(pg2, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
								.addComponent(pg3, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
							.addGap(245)
							.addComponent(jLabel5)
							.addGap(18)
							.addComponent(lblGanador, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addGap(101)
							.addComponent(slHilo3, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addGap(103)
							.addComponent(slHilo2, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addGap(105)
							.addComponent(slHilo1, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)))
					.addGap(52))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(slHilo1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pg1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(slHilo2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pg2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel2))
					.addGap(6)
					.addComponent(slHilo3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pg3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblGanador, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		getContentPane().setLayout(layout);

		pack();
	}

	public void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {
		this.btnIniciar.setEnabled(false);
		this.lblGanador.setText("");

		Hilo c = new Hilo((0) + "");
		hilos[0] = new Thread(c);
		c.addObserver(this);
		hilos[0].setPriority(slHilo1.getValue());
		hilos[0].start();
		
		Hilo c1 = new Hilo((1) + "");
		hilos[1] = new Thread(c1);
		c1.addObserver(this);
		hilos[1].setPriority(slHilo2.getValue());
		hilos[1].start();
		
		Hilo c2 = new Hilo((2) + "");
		hilos[2] = new Thread(c2);
		c2.addObserver(this);
		hilos[2].setPriority(slHilo3.getValue());
		hilos[2].start();
		                    
	}

	private void terminar() {
		for (int i = 0; i < hilos.length; i++) {
			hilos[i].interrupt();
		}
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FrmCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FrmCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FrmCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FrmCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FrmCarrera().setVisible(true);
			}
		});
	}

	private javax.swing.JButton btnIniciar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel lblGanador;
	private javax.swing.JProgressBar pg1;
	private javax.swing.JProgressBar pg2;
	private javax.swing.JProgressBar pg3;

	@Override
	public void update(Observable o, Object arg) {

		Hilo c = (Hilo) o;
		int porcentaje = (int) arg;

		switch (c.getNombre()) {
		case "0":
			this.pg1.setValue(porcentaje);
			break;

		case "1":
			this.pg2.setValue(porcentaje);
			break;

		case "2":
			this.pg3.setValue(porcentaje);
			break;
		}

		if (porcentaje >= 100) {
			terminar();
			System.out.println("Se acabo");
			System.out.println("Hilo "+ hilos[0].getName() + " prioridad " + hilos[0].getPriority());
			System.out.println("Hilo "+ hilos[1].getName() + " prioridad " + hilos[1].getPriority());
			System.out.println("Hilo "+ hilos[2].getName() + " prioridad " + hilos[2].getPriority());
			this.btnIniciar.setEnabled(true);
			this.lblGanador.setText("Hilo " + c.getNombre());
		}
	}
}
