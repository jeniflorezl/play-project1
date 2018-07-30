package services;

import business.Productos;
import models.Producto;
import io.vavr.collection.List;
import io.vavr.control.Option;

public class ServicioProducto {

    public static List<Producto> allProducts(){
        return Productos.getProductos();
    }

    public static void add(Producto product){
        List<Producto> productos = Productos.getProductos();
        productos = productos.append(product);
        Productos.setProductos(productos);
    }

    public static Producto findByIdt(Integer id){
        List<Producto> productos = Productos.getProductos();
        Option<Producto> product = productos.find(pro -> pro.getId().equals(id));
        return  product.isDefined() ? product.get() : null;
    }

    public static void remove(Producto product){
        List<Producto> productos = Productos.getProductos();
        productos = productos.remove(product);
        Productos.setProductos(productos);
    }
}
