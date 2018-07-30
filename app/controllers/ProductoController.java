package controllers;

import com.google.inject.Inject;
import models.Producto;
import io.vavr.collection.List;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.ServicioProducto;
import views.html.create;
import views.html.edit;
import views.html.index;
import views.html.show;

public class ProductoController extends Controller {

    @Inject
    FormFactory formFactory;

    // to index products
    public Result index(){
        List<Producto> productos = ServicioProducto.allProducts();
        return ok(index.render(productos.asJava()));
    }

    // to create product
    public Result create(){
        Form<Producto> productForm = formFactory.form(Producto.class);
        return ok(create.render(productForm));
    }

    // to save product
    public Result save(){
        Producto producto = formFactory.form(Producto.class).bindFromRequest().get();
        ServicioProducto.add(producto);
        return redirect("/products");
    }

    //to show a product
    public Result show(Integer id){
        Producto producto = ServicioProducto.findByIdt(id);
        if(producto == null){
            return notFound("Product not found");
        }
        return ok(show.render(producto));
    }

    //to edit a product
    public Result edit(Integer id){
        Producto producto = ServicioProducto.findByIdt(id);
        if(producto == null){
            return notFound("Product not found");
        }
        Form<Producto> productoFormEdit = formFactory.form(Producto.class).fill(producto);
        return ok(edit.render(productoFormEdit));

    }

    //to update a product
    public Result update(){
        Producto producto = formFactory.form(Producto.class).bindFromRequest().get();
        Producto oldProducto = ServicioProducto.findByIdt(producto.getId());
        if(oldProducto == null){
            return notFound("Product not found");
        }
        oldProducto.setId(producto.getId());
        oldProducto.setNombre(producto.getNombre());
        oldProducto.setTipo(producto.getTipo());
        oldProducto.setCosto(producto.getCosto());
        return redirect("/products");
    }

    //to destroy a product
    public Result destroy(Integer id){
        Producto producto = ServicioProducto.findByIdt(id);
        if (producto == null){
            return notFound("Product not found");
        }
        ServicioProducto.remove(producto);
        return redirect("/products");
    }
}
