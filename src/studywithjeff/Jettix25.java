/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jettix2.pkg5;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author cdfer
 */

public class Jettix25 {
    static Scanner entrada = new Scanner(System.in);
    static boolean forzarSalida = false; // Nuestra bandera de emergencia

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int opcion = 0;
        
        while (opcion != 4){
            opcion = mostrarMenu();
            
            switch (opcion){
                case 1 ->{
                    System.out.println("AQUI VA X0 DA DINERO");
                    char [][] SoyUnTablero = new char [3][3];
                    SoyElLlenadorDeTablero(SoyUnTablero);
                    SoyLaImpresoraDelTablero(SoyUnTablero);
                    
                    VamosAJugarXODaDinero(SoyUnTablero);

         
                }//FIN  del case 1
                case 2 -> {
                    System.out.println("AQUI VA BATTLESHIP ");
                    char[][] SoyUnTableroDeBattleship = new char[10][10];
                    SoyElLlenadorDeTablero(SoyUnTableroDeBattleship);
                    SoyLaImpresoraDelTablero(SoyUnTableroDeBattleship);
                }//FIN del case 2 

                case 3 -> {
                    System.out.println("AQUI VA EL AJEDREZ");
                    char [][] SoyUnTableroDeAjedrez = new char [8][8];
                    SoyElLlenadorDeTablero(SoyUnTableroDeAjedrez);
                    SoyLaImpresoraDelTablero(SoyUnTableroDeAjedrez);
                }//FIN del case 3

                case 4 -> {
                    System.out.println("A PUES VAYASE A LA MIERDA....");
                }// FIN del case 4
                
                default ->{
                    System.out.println("USTED NO LEE O QUE QUE PUTA OPCION ES ESTA AHHH VERDAD NINGUNA....");
                }
            }
            
        }//FIN del while
    }//FIN del main
    
    public static int mostrarMenu(){
        String textoIngresado = "";
        boolean esValido = false;
        do {
            System.out.println("======MENU=====");
            System.out.println("1. BIENVENIDO A X0 DA DINERO SOY SU SERVIDOR SALVADOR NASRALLA");
            System.out.println("2. BIENVENIDO A BATTLESHIP HDP....");
            System.out.println("3. NO SE PORQUE JUGARIAS AJEDREZ EN NETBEANS Y NO EN CHESS.COM O ALGO....");
            System.out.println("4. SALIR");
            System.out.print("INGRESE UNA OPCION: ");

            textoIngresado = entrada.nextLine();

            if (textoIngresado.length() == 0) {
                System.out.println("NO INGRESO NADA QUE PEDOS....");
                continue;
            }//FIN de la validacion de que ingreso algo   
            
            if (textoIngresado.length()>1) {
                System.out.println("QUE PEDOS HAY SOLO 4 OPCIONES MEN OSEA....");
                continue;
            }//FIN de la validacion de que ingrese solamente 1 digito
            char c = textoIngresado.charAt(0);
            
            if (c < '0' || c > '9') {
                System.out.println("INGRESE NUMEROS SOLAMENTE TEAM.....");
            }else{
                esValido = true;
            }//FIN de la validacion de que solo ingrese numeros y no otra cosa

            
        } while (!esValido);
        
        return textoIngresado.charAt(0)-48;

    }//FIN del metodo menu
    
    public static void SoyElLlenadorDeTablero(char [][] matriz){
        for (int i = 0; i < matriz.length; i++) {//Este controla las filas (va de arriba hacia abajo)
            
            for (int j = 0; j < matriz[i].length; j++) {//Este controla las columnas (de izquierda a derecha)
                
                matriz[i][j]='-';
            }//FIN del for columnas
        }//FIN del for filas
        
    }//FIN metodo para llenar el tablero 
    
    public static void SoyLaImpresoraDelTablero (char[][] matriz){
        System.out.println("-----HOLA SOY TU TABLERO-----");
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("["+matriz[i][j]+"]");
            }//FIN de las filas
            System.out.println();
        }//FIN de las columnas
    }//FIN del metodo para imprimir el tablero
    
    public static void VamosAJugarXODaDinero(char[][] Tablero) {
        char FichaDelJugador;
        forzarSalida = false;
        boolean GanoAlguien = false;
        
        
        Random Randomizador = new Random();

        int esXoO = Randomizador.nextInt(2);
        if (esXoO == 0) {
            System.out.println("Usted es X");
            FichaDelJugador = 'X';
        } else {
            System.out.println("Usted es O");
            FichaDelJugador = 'O';
        }
        
        System.out.println("KunAguero: Bueno vamo a juga");
        int turnosJugados = 0;

        while (turnosJugados < 9 && !forzarSalida ) {
            System.out.println("==> Es el turno de: " + FichaDelJugador);
            System.out.println("SI quiere salir ingrese 9");
            
            

    
            boolean FilaValida = false;
            int fila = 0;
            do {

                System.out.print("Ingrese la FILA (0,1,2): ");
                fila = entrada.nextInt();
                
                if (fila == 9) {
                System.out.println("Te rendiste team....");
                entrada.nextLine();
                forzarSalida = true;
                return;
            }

                if (fila < 0 || fila > 2) {
                    System.out.println("ERROR: Coordenada fuera del tablero");
                } else {
                    FilaValida = true;
                }
            } while (!FilaValida);
            boolean ColumnaValida = false;
            int columna = 0;

            do {

                System.out.print("Ingrese en que COLUMNA (0,1 o 2): ");
                columna = entrada.nextInt();
                if (columna == 9) {
                System.out.println("Te rendiste team....");
                entrada.nextLine();
                forzarSalida = true;
                return;
            }

                if (columna < 0 || columna > 2) {
                    System.out.println("ERROR: Coordenada fuera del tablero");
                } else {
                    ColumnaValida = true;
                }

            } while (!ColumnaValida);
            entrada.nextLine();
            
            if (Tablero[fila][columna] == '-') {
                Tablero[fila][columna] = FichaDelJugador;
                turnosJugados++;
                
                SoyLaImpresoraDelTablero(Tablero);
                
               
            } else {
                System.out.println("ERROR: Casilla ya esta llena ");
                SoyLaImpresoraDelTablero(Tablero);
            }
            
            for (int i = 0; i < 3; i++) {
                //Recorremos Filas primero 
                if (Tablero[i][0]==FichaDelJugador && Tablero[i][1]==FichaDelJugador && Tablero[i][2]==FichaDelJugador) {
                    GanoAlguien = true;
                    
                }
                
                if (Tablero[0][i]==FichaDelJugador && Tablero[1][i]==FichaDelJugador && Tablero[2][i]==FichaDelJugador) {
                    GanoAlguien = true;
                    
                }
            }// FIN del for para recorrer filas y columnas para verificar si alguien gana 
            
            if (Tablero[0][0]==FichaDelJugador && Tablero[1][1]==FichaDelJugador && Tablero[2][2]==FichaDelJugador) {
                GanoAlguien = true;
                
            }
             if (Tablero[2][0]==FichaDelJugador && Tablero[1][1]==FichaDelJugador && Tablero[0][2]==FichaDelJugador) {
                GanoAlguien = true;
                
            }
            if (GanoAlguien) {
                System.out.println("Felicidades Gano " + FichaDelJugador);
                return;
            }
            if (FichaDelJugador == 'X') {
                FichaDelJugador = 'O';
            } else {
                FichaDelJugador = 'X';
            }



            
        }//FIN del while 
        System.out.println("Empate");
        System.out.println("FIN del juego");

    }//FIN del metodo para jugar 
}//FIN de la clase
