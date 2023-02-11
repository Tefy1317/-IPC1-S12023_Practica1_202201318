import com.sun.source.tree.IfTree;

import javax.sound.midi.Soundbank;
import java.util.Date;
import java.util.Scanner;
public class Main {

    public static String[] productos = new String[3];
    public static double[] precios = new double[3];
   public static String[] descuento = new String[1];
    public static double[] porcentaje = new double[1];
    public static int [] unidades = new int[3];
    static java.util.Date fecha = new Date();
    static double total;
    static double descuentofinal;
    public static double subtotal;
    static int productoelegido;


 //FUNCIONES

    public static void agregarproductos() {

        System.out.println("Ingrese el nombre del producto: ");
        Scanner input = new Scanner(System.in);
        String producto = input.nextLine();
        System.out.println("Ingrese el precio del producto: ");
        double precio;
        try {
            precio = input.nextDouble();
        } catch (Exception e) {
            System.out.println("EL PRECIO DEBE SER UN VALOR NUMERICO");
            return;
        }

        for (int i = 1; i<productos.length; i++){
            if (productos[i] != null && productos[i].equals(producto)) {
                System.out.println("ESE PRODUCTO YA EXISTE, INTENTELO DE NUEVO CON OTRO PRODUCTO");
                return;
            }
        }

        for (int j = 1; j<precios.length; j++){
            if (precio <= 0) {
                System.out.println("EL PRECIO DEBE SER MAYOR A 0");
                return;
            }
        }

        for (int i = 1; i<productos.length; i++){
            productos[0]= null;
            if(productos[i] == null){
                productos[i] = producto;
                precios[i] = precio;
                System.out.println("PRODUCTO REGISTRADO");
                return;
            }
        }
        System.out.println("NO SE PUEDEN INGRESAR MÁS PRODUCTOS");
    }

    public static void agregardescuentos(){
        System.out.println("Ingrese código de descuento: ");
        Scanner c = new Scanner(System.in);
        String codigo = c.nextLine();
        System.out.println("Ingrese porcentaje de descuento (valor númerico de 0 a 100) : ");
        Scanner por = new Scanner(System.in);
        double porcentajes;
         int tamanocodigo = codigo.length();

        try {
            porcentajes = por.nextDouble();
        } catch (Exception e) {
            System.out.println("EL PORCENTAJE DEBE SER UN VALOR NUMERICO");
            return;
        }

        for (int f = 0; f < descuento.length; f++){
            if (descuento[f] != null && descuento[f].equals(codigo)) {
                System.out.println("ESE CÓDIGO YA EXISTE, INTENTELO DE NUEVO CON OTRO CÓDIGO");
                return;
            }
        }
        for (int g = 0; g<porcentaje.length; g++){
            if(porcentajes > 100){
                System.out.println("EL PORCENTAJE DEBE SER MENOR A 100");
                return;
            }
        }
        for (int g= 0; g<porcentaje.length; g++){
            if (porcentajes <= 0) {
                System.out.println("EL PORCENTAJE DEBE SER MAYOR A 0");
                return;
            }
        }
         if(tamanocodigo == 4){
             for(int f = 0; f<descuento.length; f++){
                 if(descuento[f] == null) {
                     descuento[f] = codigo;
                     porcentaje[f] = porcentajes;
                     System.out.println("CÓDIGO DE DESCUENTO REGISTRADO");
                     return;
                 }
             } System.out.println("NO SE PUEDEN INGRESAR MÁS CÓDIGOS DE DESCUENTO");
         }else {
             System.out.println("EL CÓDIGO DE DESCUENTO DEBE SER DE CUATRO CARACTERES");
         }
    }

    public static void realizarventas(){
        System.out.println("Ingrese su nombre: ");
        Scanner cl = new Scanner(System.in);
        String cliente = cl.nextLine();
        System.out.println("Ingrese el numero de la opción a elegir para los datos de facturación: ");
        System.out.println("1. Ingresar número de NIT");
        System.out.println("2.C/F");
        Scanner op = new Scanner(System.in);
        int option;
        try{
            option = op.nextInt();
        }catch (Exception e) {
            System.out.println("LA OPCIÓN DEBE SER UN VALOR NUMERICO");
            mostrarmenu();
            return;
        }
        switch (option) {
            case 1:
                System.out.println("Ingrese número de NIT: ");
                Scanner n = new Scanner(System.in);
                //Variable tipo String para no tener problema si el usuario ingresa "-" en el número de NIT
                String NIT = n.nextLine();
                listadoproductos();
                comprarproductos();
                comprarotroproducto();
                System.out.println("FACTURA");
                System.out.println("++++++++++++++++++SUPER-25+++++++++++++++++++");
                System.out.println("CAJERO: Estephanie Alejandra Ruiz Perez");
                System.out.println("CLIENTE: " + cliente);
                System.out.println("NIT: " + NIT);
                System.out.println("FECHA: " + fecha);
                System.out.println("---------------------------------------------");
                System.out.println("PRODUCTO - PRECIO - UNIDADES - SUBTOTAL");
                System.out.println("---------------------------------------------");
                for(int i = 1;i<productos.length; i++) {
                    if(productos[i] != null) {
                        System.out.println(productos[i] + "  -   " + precios[i] + "  -   " + unidades[i] + "  -   " + unidades[i] * precios[i]);
                        System.out.println("SUBTOTAL: " + subtotal + "------------------------------");
                        for (int f = 0; f < descuento.length; f++) {
                            System.out.println("DESCUENTO DE: " + porcentaje[f]+"%");
                        }
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("El total con el descuento aplicado es: " + total + " has ahorrado " + descuentofinal);
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("TOTAL: " + total);
                    }
                }
                break;
            case 2:
                String consumidorfinal = "C/F";
                listadoproductos();
                comprarproductos();
                comprarotroproducto();
                System.out.println("FACTURA");
                System.out.println("++++++++++++++++++SUPER-25+++++++++++++++++++");
                System.out.println("CAJERO: Estephanie Alejandra Ruiz Perez");
                System.out.println("CLIENTE: " + cliente);
                System.out.println("NIT: " + consumidorfinal);
                System.out.println("FECHA: " + fecha);
                System.out.println("---------------------------------------------");
                System.out.println("PRODUCTO - PRECIO - UNIDADES - SUBTOTAL");
                System.out.println("---------------------------------------------");
                for(int i = 1;i<productos.length; i++) {
                    if(productos[i] != null) {
                        System.out.println(productos[i] + "  -   " + precios[i] + "  -   " + unidades[i] + "  -   " + unidades[i] * precios[i]);
                        System.out.println("SUBTOTAL: " + subtotal + "------------------------------");
                        for (int f = 0; f < descuento.length; f++) {
                            System.out.println("DESCUENTO DE: " + porcentaje[f]+"%");
                        }
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("El total con el descuento aplicado es: " + total + " has ahorrado " + descuentofinal);
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("TOTAL: " + total);
                    }
                }
                break;
        }
    }

    public static void listadoproductos(){
        System.out.println("Listado de productos");
        for (int i = 1;i<productos.length; i++){
            if(productos[i] != null){
                System.out.println(i+". Producto: " + productos[i] + " ----- Precio: " + precios[i]);
            }

        }
    }
    public static void comprarproductos(){
                Scanner leer = new Scanner(System.in);
                System.out.println("Escriba el numero de la posición en la que se encuentre el producto que desea comprar: (1-10)");
                int productoelegido = leer.nextInt();
                for(int i = 1;i<productos.length; i++){
                    System.out.println("El producto elegido es: "+productos[productoelegido]+" "+"con precio de: "+precios[productoelegido]);
                }
                System.out.println("Ingrese el número de unidades del producto seleccionado que desea adquirir");
                Scanner uni = new Scanner(System.in);
                int unidad = uni.nextInt();
                 for (int i = 1; i<unidades.length; i++){
                    if(unidad > 0) {
                        unidades[i] = unidad;

                    }else if(unidades[i] < 0){
                        unidades[i] = 0;
                    }
                }
    }
    public static void comprarotroproducto(){

        System.out.println("¿Desea adquirir otro producto?");
        System.out.println("1. Si ");
        System.out.println("2. No ");
        System.out.println("Ingrese el numero de la opción a elegir:  ");
        Scanner e = new Scanner(System.in);
        int elegir = e.nextInt();

            do{
                if(elegir==1) {
                    listadoproductos();
                    comprarproductos();
                    comprarotroproducto();
                    return;
                }
            }while(elegir !=2);
            aplicarDescuento();
    }

    public static void aplicarDescuento(){
        subtotal = 0;
              for(int i = 0;i<productos.length; i++){
                      subtotal = subtotal + (unidades[i]*precios[i]);
                  System.out.println("El total es: "+ subtotal);
                  System.out.println("¿Cuenta con algún código de descuento?");
                  System.out.println("1. Si");
                  System.out.println("2. No");
                  Scanner opc = new Scanner(System.in);
                  int opci = opc.nextInt();
                  if(opci == 1) {
                      do {
                          Scanner desc = new Scanner(System.in);
                          System.out.println("Ingrese el código de descuento: ");
                          String codigodescuento = desc.nextLine();
                          for (int f = 0; f < descuento.length; f++) {
                              if (codigodescuento.equals(descuento[f])) {
                                  descuentofinal = subtotal * porcentaje[f] / 100;
                                  total = subtotal - descuentofinal;
                                  System.out.println("--------------------------------------------------------------------------------");
                                  System.out.println("DESCUENTO APLICADO");
                                  System.out.println("--------------------------------------------------------------------------------");

                                  return;
                              }
                          }
                          for (int f = 0; f < descuento.length; f++) {
                              if(codigodescuento != descuento[f]){
                                  if(descuento[f] != null) {
                                      System.out.println("---------------------------------------------");
                                      System.out.println("NO EXISTE ESE CÓDIGO DE DESCUENTO");
                                      System.out.println("---------------------------------------------");
                                  }
                              }
                          }
                      }while(opci!=2);

                  }else if (opci == 2) {
                      System.out.println("---------------------------------------------");
                      return;
                  }
              }
    }
    public static void emitirreporte(){
            System.out.println("Listado de productos vendidos");
            for(int i = unidades.length; i>=0; i--){
                if(productos[i] != null) {
                    System.out.println("Producto: " + productos[productoelegido] + " ----- Unidades vendidas: " + unidades[i]);
                }
            }
    }

    //menú de opciones//////////////////////////////
    public static void mostrarmenu(){
        Scanner input = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n ------BIEVENIDO A SUPER-25 :)------ ");
            System.out.println("¿Qué desea realizar hoy?");
            System.out.println("1. Agregar nuevos productos.");
            System.out.println("2. Agregar cupones de descuento. ");
            System.out.println("3. Realizar ventas. ");
            System.out.println("4. Emitir reporte. ");
            System.out.println("5. Salir");
            System.out.println("Ingrese el numero de la opción a elegir:  ");

            try{
                opcion = input.nextInt();
            }catch (Exception e) {
                System.out.println("LA OPCIÓN DEBE SER UN VALOR NUMERICO");
                mostrarmenu();
                return;
            }

            switch (opcion) {
                case 1:
                    agregarproductos();
                    break;
                case 2:
                    agregardescuentos();
                    break;
                case 3:
                    realizarventas();
                    break;
                case 4:
                    emitirreporte();
                case 5: System.exit(0);
            }
        } while (opcion != 5);
    }
    //////////////////////////////////////////////////////////////////

    public static void main (String[]args) {

        //Ingreso del usuario//////////////////////////////
        String usuario = "1"; //""cajero_202201318";
        String password = "2"; //""ipc1_202201318";
        String entrada1, entrada2;

        do {
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++SUPER-25++++++++++++");
            Scanner u = new Scanner(System.in);
            System.out.println("Ingrese usuario: ");
            entrada1 = u.nextLine();
            Scanner p = new Scanner(System.in);
            System.out.println("Ingrese contraseña: ");
            entrada2 = p.nextLine();
            System.out.println("+++++++++++++++++++++++++++++++");

            if (entrada1.equals(usuario) && entrada2.equals(password)) {
                mostrarmenu();
            }else{
                System.out.println("USUARIO Y/O CONTRASEÑA INCORRECTA, INGRESE NUEVAMENTE: ");
            }

        } while (entrada1 != usuario & entrada2 != password);


        //////////////////////////////////////////////////////////////////
    }

}
