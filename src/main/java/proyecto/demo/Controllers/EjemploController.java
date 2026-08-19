package proyecto.demo.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EjemploController {
    
    @GetMapping("/hola")
    public String hola() {
        return "Hola a todos";
    }
}