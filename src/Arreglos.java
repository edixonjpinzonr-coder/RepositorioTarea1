import javax.swing.*;

public class Arreglos {
    public static void main(String[] args) {

        int cantidad= ingresarCantidad();
        double[] notas = new double[cantidad];
        double [] nota= ingresarNotas(cantidad, notas);
        System.out.println("\nArreglo ingresado:");
      mostrarNotasAgregadas(notas);
        //invocacion del metodo burbuja
        ordenarBurbuja(notas);
        double notaDefinitiva = calcularNotaDefinitiva(notas);
        double notaMayor = determinarNotaMayor(notas);
        double notaMenor = determinarNotaMenor(notas);
        String notaMasRepetida = determinarNotaMasRepetida(notas);
        int notasAprobadas= calcularNotasAprobadas(notas);
        int notasDesaprobadas= calcularNotasDesaprobadas(notas);
        double[] notasQueAprovo = determinarCualesNotasAprovo( notasAprobadas, notas);
        double[] notasQueDesaprovo = determinarCualesNotasDesaprovo( notasDesaprobadas, notas);
        String mostrarNotasA = mostrarNotasAprovadas( notasQueAprovo);
        String mostrarNotasD = mostrarNotasDesaprovadas( notasQueDesaprovo);

        mostrarMensajeFinal(notaDefinitiva, notaMayor, notaMenor, notaMasRepetida,
        notasAprobadas, notasDesaprobadas);

        // decide si mostrar las notas o si muestra el mensaje
        determinarMostrarNotasAprovadas( notasAprobadas, mostrarNotasA);
        //decide si mostrar las notas desaprovadas o si muestra el mensaje
        determinarMostrarNotasDesprovadas(notasDesaprobadas,mostrarNotasD);
        //invocacion del metodo para mostrar el metodo burbuja
        mostrarMetodoBurbuja(notas);

    }


    //muestra el mensaje para ingresar la cantidad de notas
    public static int ingresarCantidad(){
        int cantidad = Integer.valueOf(JOptionPane.showInputDialog
                (null, "ingfese el numero de notas"));
        return cantidad;
    }

    //muestra el mensaje para ingresar las notas
    public static double [] ingresarNotas(int cantidad, double [] notas) {
        double[] nota = new double[cantidad];
        for (int i = 0; i < notas.length; i++) {
            notas[i] = Double.valueOf(JOptionPane.showInputDialog
                    (null, "ingrese su nota " + (i + 1)));
        }
        return nota;
    }

    //muestra las notas
    public static void mostrarNotasAgregadas(double[]notas){
        //metodo para mostrar el arreglo ingresado por el usuario

        for (int i = 0; i < notas.length; i++) {
         System.out.println(notas[i]);
        }

    }


    //metodo para calcular cual es la nota definitiva

    public static double calcularNotaDefinitiva(double[] notas) {
        double notaDefinitiva = 0;
        double suma = 0;

        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        notaDefinitiva = suma / notas.length;
        notaDefinitiva=Math.round(notaDefinitiva*100.0)/100.0;

        return notaDefinitiva;
    }

    // metodo para determinar cual es la nota mayor
    public static double determinarNotaMayor(double[] notas) {
        double notaMayor = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > notaMayor) {
                notaMayor = notas[i];
            }
        }
        return notaMayor;
    }

    //metodo para determinar cual es la nota menor
    public static double determinarNotaMenor(double[] notas) {
        double notaMenor = 9;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < notaMenor) {
                notaMenor = notas[i];
            }
        }
        return notaMenor;
    }

    //metodo para saber cual es la nota que mas se repite
    public static String determinarNotaMasRepetida(double[] notas) {
        double notaRepetida = notas[0];
        int mayorCantidad = 0;
        for (int i = 0; i < notas.length; i++) {
            int contador = 0;
            for (int j = 0; j < notas.length; j++) {
                if (notas[j] == notas[i]) {
                    contador++;
                }
            }
            if (contador > mayorCantidad) {
                mayorCantidad = contador;
                notaRepetida = notas[i];

            }
        }

        if(mayorCantidad<2){
            return "No hay nota que se repita";
        }
        return String.valueOf(notaRepetida);

    }


    //metodo para calcular cuantas notas aprovo
    public static int calcularNotasAprobadas(double[]notas){
        int notasAprobadas=0;
        for(int i=0; i<notas.length; i++){
            if(notas[i]>= 3.0){
                notasAprobadas++;
            }
        }
        return notasAprobadas;
    }


    //metodo para calcular cuantas notas desaprovo
    public static int calcularNotasDesaprobadas(double[]notas){
        int notasDesaprobadas=0;
        for(int i=0; i<notas.length; i++){
            if(notas[i]< 3.0){
                notasDesaprobadas++;
            }
        }
        return notasDesaprobadas;
    }


    //metodo para determinar cuales notas aprovo
    public static double[] determinarCualesNotasAprovo(int notasAprovadas, double[]notas){
        double[] notasQueAprovo= new double[notasAprovadas];
        int posicion=0;
        for(int i=0; i<notas.length; i++){
            if(notas[i]>= 3.0){
                notasQueAprovo[posicion] = notas[i];
                posicion++;
            }

        }
        return notasQueAprovo;
    }


    //metodo para determinar cuales notas desaprovo
    public static double[] determinarCualesNotasDesaprovo(int notasDesaprovadas, double[]notas){
        double[] notasQueDesaprovo= new double[notasDesaprovadas];
        int posicion=0;
        for(int i=0; i<notas.length; i++){
            if(notas[i]< 3.0){
                notasQueDesaprovo[posicion] = notas[i];
                posicion++;
            }

        }
        return notasQueDesaprovo;
    }


    //metodo para mostrar cuales son las notas aprovadas
    public static String mostrarNotasAprovadas(double [] notasQueAprovo){
        String notas= "";
        for(int i=0; i<notasQueAprovo.length; i++){
            notas += notasQueAprovo[i];
            if(i<notasQueAprovo.length-1){
                notas+="\n";
            }
        }
        return notas;
    }


    //metodo para mostrar cuales son las notas desaprovadas
    public static String mostrarNotasDesaprovadas(double [] notasQueDesaprovo){
        String notas= "";
        for(int i=0; i<notasQueDesaprovo.length; i++){
            notas += notasQueDesaprovo[i];
            if(i<notasQueDesaprovo.length-1){
                notas+="\n";
            }
        }
        return notas;
    }

    // decide si mostrar las notas o si muestra el mensaje
    public static void determinarMostrarNotasAprovadas(int notasAprobadas, String mostrarNotasA){
        if(notasAprobadas>0){
            System.out.println("Notas aprovadas \n"+mostrarNotasA+ "\n");
        }else{
            System.out.println("No hay notas aprovadas\n ");
        }
    }


    public static void determinarMostrarNotasDesprovadas(int notasDesprobadas, String mostrarNotasD){
        if(notasDesprobadas>0){
            System.out.println("Notas aprovadas \n"+mostrarNotasD);
        }else{
            System.out.println("No hay notas aprovadas\n ");
        }
    }


    //notas por medio del metodo burbuja
    public static void ordenarBurbuja(double [] notas){
        for(int i=0; i<notas.length-1; i++){
            double nota= 0;
            for(int j=0; j<notas.length-1-i; j++){
                if(notas[j]>notas[j+1]){
                    nota=notas[j];
                    notas[j]=notas[j+1];
                    notas[j+1]=nota;

                }
            }
        }

    }

    //metodo para mostrar el metodo burbuja
    public static void mostrarMetodoBurbuja(double[] notas){
        System.out.println("\nnotas con metodo busrbuja: ");
        for (int i = 0; i < notas.length; i++) {
            System.out.println(notas[i]);

        }
    }

    public static void mostrarMensajeFinal
            (double notaDefinitiva,double notaMayor,double notaMenor,String notaMasRepetida,
             int notasAprobadas, int notasDesaprobadas){

        System.out.println("\nNota definitiva: " + notaDefinitiva + "\n" +
                "\nNota mayor: " + notaMayor +"\n"+
                " \nNota menor: " + notaMenor +"\n"+
                "\nNota mas repetida: " + notaMasRepetida+"\n"+
                "\nCuantas notas aprovo: "+notasAprobadas+"\n"+
                "\nCuantas notas desaprovo: "+notasDesaprobadas+"\n");

    }
}

