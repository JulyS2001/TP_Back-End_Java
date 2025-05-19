package datos;
import java.util.*;

public class pedido {

    private int idPedido; 
    private List<producto> lstProductos;
    private List<pedido> lstPedidos;

    public pedido(int idPedido) {
        this.idPedido = idPedido;
        this.lstProductos = new ArrayList<producto>();
        this.lstPedidos = new ArrayList<pedido>();
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public List<producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(List<producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public List<pedido> getLstPedidos() {
        return lstPedidos;
    }

    public void setLstPedidos(List<pedido> lstPedidos) {
        this.lstPedidos = lstPedidos;
    }

    @Override
    public String toString() {
        return "pedido [idPedido=" + idPedido + ", lstProductos=" + lstProductos + "]\n";
    }

    public boolean agregarProducto(String nombre, float precio, int stock){
        int id = 1; 
        if(!lstProductos.isEmpty()){
            id = lstProductos.get(lstProductos.size() - 1).getIdProducto() + 1; 
        }
        return lstProductos.add(new producto(id, nombre, precio, stock));
    }

    public producto traerProducto(int id){
        producto p = null; 
        int i = 0; 
        while(i < lstProductos.size() && p == null){
            if(lstProductos.get(i).getIdProducto() == id){
                p = lstProductos.get(i);
            }
            i++;
        }
        return p; 
    }

    public void actualizarProducto(int id, float precio, int stock){
        producto p = traerProducto(id);
        if(p != null){
            p.setPrecio(precio);
            p.setStock(stock);
            System.out.println("Producto acualizado correctamente");
        }else{
            System.out.println("Producto no encontrado.");
        }
        
    }

    public void eliminarProducto(int idP){
        producto p = traerProducto(idP);
        if(p != null){
            lstProductos.remove(p);
            System.out.println("Producto eliminado correctamente.");
        }else{
            System.out.println("Error. Producto no encontrado.");
        }
    }

    public void agregarPedido(Scanner sc){
        pedido p = new pedido(lstPedidos.size() + 1);
        System.out.println("Seleccione productos por ID (0 para salir)");
        for(producto prod : lstProductos){
            System.out.println(prod);
        }
        while(true){
            System.out.print("ID producto: ");
        int id = sc.nextInt();
        if (id == 0) break;
        producto prod = traerProducto(id);
        if (prod != null) {
            System.out.println("Cantidad deseada: ");
            int cantidad = sc.nextInt();
            if(prod.getStock() >= cantidad){

                 p.getLstProductos().add(prod);
                 prod.setStock(prod.getStock() - cantidad);
                 System.out.println("Producto agregado al pedido.");
                
            }else{
                System.out.println("Stock insuficiente. Disponible: " + prod.getStock());
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
        }
        if (!p.getLstProductos().isEmpty()) {
        lstPedidos.add(p);
        System.out.println("Pedido creado: " + p);
    } else {
        System.out.println("No se agregaron productos. Pedido cancelado.");
    }
    }

    

    

}
