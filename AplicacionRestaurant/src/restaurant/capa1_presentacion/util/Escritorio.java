/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion.util;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author Antonio AB
 */
public class Escritorio extends JDesktopPane  {
  
       Image IMG=new ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/logosis.png")).getImage();

       @Override
        public void paintChildren(Graphics g){
            g.drawImage(IMG, 0, 0, getWidth(), getHeight(), this);
            super.paintChildren(g);
        
}
}
