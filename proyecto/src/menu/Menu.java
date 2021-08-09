package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;

public class Menu extends JFrame implements ActionListener{
    JMenuBar barra;
    JMenu menu_archivo;
    JMenu menu_ayuda;
    JMenuItem menuItem_ayuda;
    JMenuItem menuItem_acercade;
    JLabel texto;
    
    
    public Menu(){
        crearMenu();
    }
    
    private void crearMenu(){
        //Menus:
        barra=new JMenuBar();
        menu_archivo=new JMenu("Archivo");
        menu_ayuda=new JMenu("Ayuda");

        //MenuItemps

        menuItem_ayuda= new JMenuItem("Ayuda");
        menuItem_acercade= new JMenuItem("Acerca de");

        menuItem_ayuda.addActionListener(this);
        menuItem_acercade.addActionListener(this);
        

        menu_ayuda.add(menuItem_ayuda);
        menu_ayuda.add(menuItem_acercade);
        barra.add(menu_ayuda);
        
        //Enlazamos la barra con la interfáz:
        setJMenuBar(barra);

        texto= new JLabel("¿En que te podemos ayudar?");

        Container contentpane= getContentPane();
        contentpane.setLayout(new FlowLayout());

        contentpane.add(texto);
                 
        //Eventos del menu:

                
    }

    @Override
    public void actionPerformed(ActionEvent evento) {


        
        if(evento.getSource()==menuItem_ayuda){
            texto.setText("Se seleccionó la opción de ayuda...");
            JOptionPane.showMessageDialog(null,"      ____________________________ INSTRUCCIONES DEL PROGRAMA: _______________________________ \n\n "+

            "Objetivo: El juego consiste en rescatar a una dama llamada Pauline, que ha sido capturada por el enorme gorila Donkey Kong\n"
            +"para ello deberá competir con otros jugadores para rescatarla\n\n"
            
            +"El juego de divide en niveles, cada uno con una dificultad mayor. Para completar el nivel se debe llegar a la cima\n\n"
            
            +"Cada juador acumula puntos a medidda que: destruye objetos, evita objetos, recoge objetos y completa el nivel\n\n"
            
            +"Cada jugador tiene disponible un martillo que lo puede usar para destruir objetos que se encuentre a su paso\n\n"
            
            +"Los jugadores deberán esquivar los barriles y bolas de fuego que les lance Doneky Kong, además de saltar los obstáculos\n"
            +"o trampas que se presenten en su camino\n\n"
            
            +"Para llegar a la cima es necesario subir por las escaleras y buscar el mejor camino libre de objetos que impidan avanzar\n\n"
            
            +"Cada jugador tiene cinco vidas, al chocar con un obstáculo se pierde una vida\n\n"
            
            +"En cada nivel se tiene un tiempo limite para llegar a la cima. Cuando se finaliza el tiempo , el jugador que no haya llegado\n"
            +"pierde automáticamente\n\n"
            
            +"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        else if(evento.getSource() == menuItem_acercade){
              texto.setText("Se seleccionó la opción de acerca de...");
              JOptionPane.showMessageDialog(null,"_________________INFORMACIÓN GENERAL DEL PROGRAMA__________________\n\n"
              +"*) Desarrolladores del juego:\n\n"+"Cesar Rojas      Jesús Betancourt\n"+"Teresa Youssef      Jonas Aray\n\n"
              +"*) Lenguaje de programación: Java\n"
              +"*) IDE utilizado para el desarrollo: Netbeans 8.2\n\n"
              +"*) Librerías externas utilizadas en el desarrollo del juego:\n"
              +"java.awt.Canvas\njava.awt.Color\njava.awt.Dimension\n"
              +"java.awt.BorderLayout\njava.awt.image.BufferedImage\njava.awt.imagine.DataBufferInt\n"
              +"java.awt.image.BufferStrategy\njava.awt.Graphics\njavax.swing.ImagineIcon\n"
              +"javax.swing.JFrame\njava.io.IOException\njavax.imageio.ImageIO\njava.awt.event.ActionEvent\n"
              +"java.awt.ActionListener\njavax,swing.JMenuBar\njavax.swing.JOptionPane\njava.awt.Container\njava.awt.FlowLayout\njavax.swing.WindowConstants.EXIT_ON_CLOSE\n\n"
              +"Versión Actualizada: DonKey Kong V. Open beta\n\n");
        }
    }
}
    