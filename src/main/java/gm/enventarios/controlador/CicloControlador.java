package gm.enventarios.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//http://localhost:8080/inventario-app   , context path
@RequestMapping("blue-planet")
@CrossOrigin(value = "http://localhost:4200")
public class CicloControlador {
    //informacion para poder enviar a la consola
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);


}
