package twitter;


import javax.swing.JOptionPane;
import twitter.Metodos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author artur
 */
public class Twitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Metodos.conexion();

        int select;

        do {
            select = Integer.parseInt(JOptionPane.showInputDialog("1.Twittear \n 2.TimeLine \n 3.Buscar un Tweet \n 0. Salir"));
            switch (select) {

                case 1:
                    Metodos.twittear(JOptionPane.showInputDialog(null, "Introducir nuevo Estado"));
                    break;
                case 2:
                    Metodos.lineaTiempo();
                    break;
                case 3:
                    Metodos.buscarTwitt(JOptionPane.showInputDialog("Introduce el hastag"));
                    break;
            }

        } while (select != 0);
    }
}