package business;

import models.Producto;
import io.vavr.collection.List;

import static vo.Tipo.ASEO;
import static vo.Tipo.COCINA;
import static vo.Tipo.HOGAR;

public class Productos {
    private static List productos = List.of(new Producto(1, "Estufa", COCINA, 10D),
            new Producto(2, "Cama", HOGAR, 20D),
            new Producto(3, "Lavadora", ASEO, 30D));

    public static List getProductos() {
        return productos;
    }

    public static void setProductos(List productos) {
        Productos.productos = productos;
    }
}
