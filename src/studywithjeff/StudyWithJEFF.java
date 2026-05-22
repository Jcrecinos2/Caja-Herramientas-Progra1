/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studywithjeff;

import java.util.Scanner;

/**
 *
 * @author cdfer
 */
public class StudyWithJEFF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int seleccion = 0;
        
        while (seleccion != 4){
            
            seleccion = MenuDeOpciones(entrada);
            
        switch(seleccion){
            case 1 -> {
              char continuar = 'S';
              
                System.out.println("Analizador de Contrasenas PRO ");
                do{
                    boolean CONTRASEGURA =  false;
                    do{
                        System.out.println("Ingrese su contrasena: ");
                        String CONTRA = entrada.nextLine();
                        if (CONTRA.length()==0) {
                            System.out.println("Su contrasena no puede estar vacia");
                            continue;
                        }// Reviso que la entrada no este vacia 
                        
                        boolean LongitudOK = validarLongitud(CONTRA);
                        boolean MayusOK = ContieneMAYUS(CONTRA);
                        boolean DigitoOK = TieneDigito(CONTRA);
                        boolean EspecialOK = ContienCharEspecial(CONTRA);
                        
                        if (LongitudOK && MayusOK && DigitoOK && EspecialOK) {
                            System.out.println("Su contrasena es segura!!!! ");
                            CONTRASEGURA = true;
                            
                        }else{
                            System.out.println("La contrasena NO es segura usted fallo en: ");
                            if (!LongitudOK) {
                                System.out.println("Su contrasena debe tener 8 o mas caracteres");
                            }// FIN if error en la longitud
                            if (!MayusOK) {
                                System.out.println("Su contrasena debe de tener una letra mayuscula ");
                            }// FIN error en la Mayus
                            if (!DigitoOK) {
                                System.out.println("Su contrasena debe de tener un digito");
                            }// FIN error en el digito 
                            if (!EspecialOK) {
                                System.out.println("Su contrasena debe de tener un caracter especial");
                            }// FIN error en el caracter especial 
                        }// Fin del else
                    }while (!CONTRASEGURA);// FIN del do while original 
                    
                    System.out.println("Desea Analizar Otra Contrasena {S,N}: ");
                    continuar = entrada.nextLine().toUpperCase().charAt(0);
                }while (continuar == 'S');// FIN del do while
                System.out.println("Saliendo del Analizador de Contrasenas.....");       
            }//FIN del case 1
            
            case 2->{
                char continuar = 'S';
                do{
             
                System.out.println("===BIENVENIDO AL DECODIFICADOR SECRETO====");
                System.out.print("Ingrese el codigo secreto sin espacios en blanco (ej. a2p1m3): ");
                String CodigoIngresado = entrada.nextLine();
                    if (CodigoIngresado.length()==0) {
                        System.out.println("Su palabra no puede estar vacia!");
                        continue;
                    }// Reviso si la entrada esta vacia 
                    if (NoContieneEspacios(CodigoIngresado)) {
                        System.out.println("ERROR: NO DEBE DE HABER ESPACIOS EN BLANCO");
                        continue;
                    }// Verifico si hay espacios en blanco 
                
                String mensajeDescifrado = decodificador(CodigoIngresado);
                System.out.println("El mensaje oculto es: "+mensajeDescifrado);
                    System.out.println("Desea Decodificar otro mensaje{S,N}");
                    continuar = entrada.nextLine().toUpperCase().charAt(0);
                } while (continuar == 'S');
             
            }// FIN del case 2 
            case 3 -> {
                char continuar = 'S';
                do {
                    System.out.println("====BIENVENIDO A CASCADA Y SIMETRIA====");
                    boolean PalabraValida = false;
                    String texto = "";
                    
                    do {
                       System.out.println("Ingrese una palabra (SIN ESPACIOS EN BLANCO)");
                       texto = entrada.nextLine();
                        if (texto.length()==0) {
                            System.out.println("ERROR: No ingreso nada!!!");
                        }else{
                        if (NoContieneEspacios(texto)) {
                            PalabraValida = true;
                        }else{
                            System.out.println("ERROR: la palabra tiene un espacio en blanco");
                        }
                        }
                    } while (!PalabraValida);
                    System.out.println("====RESULTADO====");
                    ImprimirCascada(texto);
                    
                    System.out.println("Desea probar con otra palabra {S,N}");
                    continuar = entrada.nextLine().toUpperCase().charAt(0);
                } while (continuar == 'S');
            }//FIN del case 3 
        }// FIN del switch

        }// Fin del while que correra el menu
      
    }// Fin del main 
    
    public static boolean validarLongitud (String password){
        return password.length() >= 8;
    }// Fin del metodo longitud
    
    public static boolean ContieneMAYUS (String password){
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 65 && c <= 90) {
                return true;
            }// Fin del if para verificar con tabla ascii
        }//Fin del for recorrer palabra 
        return false; // Si no ecuentra nada que retorne falso
    }// FIN del metodo para las mayus
    
    public static boolean TieneDigito (String password){
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 48 && c <= 57) {
                return true;
            }// FIN if rango ascii para digitos
        }// FIN for recorrer la palabra
        return false;
    }// FIN metodo para verificar char especial
    
    public static boolean ContienCharEspecial (String password){
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c == 33 || c == 35 || c == 36 || c ==37) {
                return true;
            }// Fin rango ascii para valores especiales
        }//FIN del for recorrer la palabra
        return false;
    }// FIN del metodo verificar el caracter especial 
    
    public static int MenuDeOpciones(Scanner lector){
        System.out.println("========MENU PRINCIPAL========");
        System.out.println("1. Analizador de contrasenas ");
        System.out.println("2. Decodificador secreto ");
        System.out.println("3. Cascada y Simetria ");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
        int opcion = lector.nextInt();
        lector.nextLine();
        return opcion;
    }//FIN del menu de opciones
    
    public static String decodificador(String secreto){
        String resultado = "";
        
        for (int i = 0; i < secreto.length(); i+=2) {
            char letra = secreto.charAt(i);
            
            int repeticiones = secreto.charAt(i+1)-48;
            
            for (int j = 0; j < repeticiones; j++) {
                resultado += letra;
            }// FIN del for para pegar la letra 
            
        }// FIN del for para ir recorriendo la letra 
        return resultado;
    }//FIN del metodo decodificador 
    
    public static boolean NoContieneEspacios (String password){
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c == 32) {
                return false;
            }//FIN if verificar si hay espacios
        }// FIN del if recorre la palabra
        return true;
    }// FIN metodo verificar no espacios en blanco 
    
    public static void ImprimirCascada (String texto){
        
        String acumulador = "";
        
        for (int i = 0; i < texto.length(); i++) {
            acumulador += texto.charAt(i);
            System.out.println(acumulador);
        }// Cascada subida
        
        for (int i = texto.length()-2; i >= 0; i--) {
            String linea ="";
            for (int j = 0; j < i; j++) {
                linea += texto.charAt(j);
            }// 
            System.out.println(linea);// Imprime la linea reconstruida 
        }// FIN for elimina letras
    }// FIN metodo cascada
    
}// FIN de la clase
