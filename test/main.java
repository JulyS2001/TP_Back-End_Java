package test;

import datos.pedido;
import datos.producto;
import java.util.*;

public class main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        pedido p = new pedido(0);

        int opcion; 

        do{
            System.out.println("\n--- MENÚ ---");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar/Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear un pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("7) Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                System.out.println("1) Agregar producto"); 
                System.out.println("Ingrese el nombre del producto: ");
                String nombre = sc.nextLine();
                System.out.println("Ingrese el precio del producto: ");
                float precio = sc.nextFloat();
                System.out.println("Ingrese la cantidad de stock: ");
                int stock = sc.nextInt();
                boolean agregado = p.agregarProducto(nombre, precio, stock);
                if(agregado){
                    System.out.println("producto agregado correctamente.");
                }else{
                    System.out.println("Error al agregar el producto.");
                }
                    break;
                case 2:
                System.out.println("2) Listar productos");
                System.out.println(p.getLstProductos());
                    break;
                case 3:
                System.out.println("3) Buscar/Actualizar producto");
                System.out.println("Ingrese el id del producto a actualizar: ");
                int idP = sc.nextInt();
                System.out.println("Ingrese el precio del producto: ");
                float precioAc = sc.nextFloat();
                System.out.println("Ingrese la cantidad de stock: ");
                int stockAc = sc.nextInt();
                p.actualizarProducto(idP,  precioAc, stockAc);

                    break;
                case 4:
                System.out.println("4) Eliminar producto");
                System.out.println("Ingrese el id del producto a eliminar: ");
                int idAEliminar = sc.nextInt();
                p.eliminarProducto(idAEliminar);
                    break;
                case 5:
                System.out.println("5) Crear un pedido");
                p.agregarPedido(sc);
                    break;
                case 6:
                System.out.println("6) Listar pedidos");
                System.out.println(p.getLstPedidos());
                    break;
                case 7:   
                System.out.println("Saliendo del sistema..."); 
                    break;
            
                default:
                System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 7);
            sc.close();
    }
    
}