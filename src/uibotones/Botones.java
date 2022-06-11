package uibotones;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botones extends JFrame implements ActionListener {
    private JButton b1,b2,b3,b4;
    private JLabel jLabel;
    private static final int ANCHO = 400;
    private static final int ALTO = 400;
    private Border border;
    Container container;
    public Botones(){
        //Nombre de mi ventana
        super("Arreglo de botones");
        //1. Pedimos el panel de contención al JFrame
        container = getContentPane();
        //2. seteamos el layout a utilizar
        container.setLayout(new BorderLayout());
        //Dibujamos bordes
        border =BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        // 3. Creamos el panel norte
        JPanel pNorte = _crearNorte();
        //Agregamos bordes
        container.add(pNorte,BorderLayout.NORTH);
        //4. Creamos el panes central
        JPanel pCentral = _crearCentro();
        //Agregamos bordes
        container.add(pCentral,BorderLayout.CENTER);
        // este metodo dimensiona y setea el tamanio exacto
        // necesario para contener todos los componentes del Frame
        pack();
        //5. Tamaño de ventana
        setSize(ANCHO,ALTO);
        //6.Mostrar vetana
        setVisible(true);
    }
    private JPanel _crearNorte(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // instancio un TitledBorder con el titulo y ol objeto border
        // que cree en el constructor
        TitledBorder titleBoder = BorderFactory.createTitledBorder(border,"Mensaje Botón");
        // asigno el titled border al panel
        panel.setBorder(titleBoder);
        jLabel =  new JLabel("Mensaje");
        panel.add(jLabel,BorderLayout.CENTER);
        return  panel;
    }

    private JPanel _crearCentro(){
        b1 = new JButton("A");
        b2 = new JButton("B");
        b3 = new JButton("C");
        b4 = new JButton("D");
        //Penel container con GridLayout
        JPanel panel = new JPanel(new GridLayout(2,2));
        Color c = Color.getHSBColor(111,111,111);
        panel.setBackground(c);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border,"Botones");
        panel.setBorder(titledBorder);
        // Agrego los botones al panel
        panel.add(b1);
        b1.addActionListener(this);
        panel.add(b2);
        b2.addActionListener(this);
        panel.add(b3);
        b3.addActionListener(this);
        panel.add(b4);
        b4.addActionListener(this);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "A":
                jLabel.setText("Has presionado el botón"+ b1.getActionCommand());
                break;
            case "B":
                jLabel.setText("Has presionado el botón: "+ b2.getActionCommand());
                break;
            case "C":
                jLabel.setText("Has presionado el botón: "+ b3.getActionCommand());
                break;
            case "D":
                jLabel.setText("Has presionado el botón: "+ b4.getActionCommand());
                break;
            default:
                break;
        }
    }
}
