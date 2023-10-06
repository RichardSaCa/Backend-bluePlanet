package gm.enventarios.controlador;

import gm.enventarios.controlador.excepcion.RecursoNoEncontradoExcepcion;
import gm.enventarios.modelo.Producto;
import gm.enventarios.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://localhost:8080/inventario-app   , context path
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoControlador {
    //informacion para poder enviar a la consola
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    //http://localhost:8080/inventario-app/productos
    @GetMapping("/productos")
    public List<Producto> obtenerProductor(){
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("productos Obtenidos:");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("prodcuto agregar "+producto);
        return this.productoServicio.guardarProducto(producto);
    }

    @GetMapping("/productos/{id}")
    //devolver la respuesta dentro del cuerpo de tipo get
    public ResponseEntity<Producto> obtenerProductoPorId(
            @PathVariable int id
    ){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if(producto != null)
            return ResponseEntity.ok(producto);
        else
            throw new RecursoNoEncontradoExcepcion("No se encontro el id");


    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable int id,
            @RequestBody Producto productoRecibido
    ){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if(producto == null)
            throw  new RecursoNoEncontradoExcepcion("no se encontro el id "+id);
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setExistencia(productoRecibido.getExistencia());
        producto.setPrecio(productoRecibido.getPrecio());
        this.productoServicio.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(
            @PathVariable int id
    ){
        Producto producto = productoServicio.buscarProductoPorId(id);
        if(producto == null)
            throw  new RecursoNoEncontradoExcepcion("no se encontro el id "+id);
        this.productoServicio.eliminarProductoPorId(producto.getIdProducto());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);

    }
}
