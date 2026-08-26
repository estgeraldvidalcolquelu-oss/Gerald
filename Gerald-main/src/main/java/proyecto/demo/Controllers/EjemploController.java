package proyecto.demo.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EjemploController {
    int[] edades = new int[5];
    
    @GetMapping("/hola")
    public String hola() {
        return "Hola a todos";
    }

    @GetMapping("/edades")//http://localhost:8080/api/v1/edades
    public int [] getEdades(){
        edades [1] = 19;
        edades [0] = 20;
        edades [2] = 30;
        edades [3] = 10;
        edades [4] = 18;
        return edades;
    }
//Request param http://localhost:8080/api/edad?num=30
//Path variable http://localhost:8080/api/edad/30

    @GetMapping("/agregarEdad/{edadNueva}")// http://localhost:
    public int[] agregarEda(@PathVariable int edadNueva){
        int[] edadesExtendido = new int [6];
        for(int i = 0; i < 5; i++){
            edadesExtendido[i] = edades[i];
        }
        edadesExtendido[5] = edadNueva;
        return edadesExtendido;
    }

}