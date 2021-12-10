package co.edu.unab.api.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.api.models.ClienteModel;
import co.edu.unab.api.services.ClienteService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<ClienteModel> obtenerClientes(){
        return  clienteService.obtenerClientes();
    }

    @PostMapping()
    public ClienteModel guardarCliente(@RequestBody ClienteModel cliente){
        
        return clienteService.guardarCliente(cliente);
    }
    
    @DeleteMapping(path = "/{id}")
    public String eliminarClientePorId(@PathVariable("id") String id){
        boolean resultadoEliminar=this.clienteService.eliminarCliente(id);
        if (resultadoEliminar){
            return "Se eliminó el usuario con id: "+id;
        }else{
            return "No se pudo eliminar el usuario con el id: "+id;
        }
    }
    

    //Consulta clientes por id
    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> obtenerClientePorId(@PathVariable("id") String id){
        return this.clienteService.obtenerClientePorId(id);
    }
    
    ////Consulta clientes por nombre
    @GetMapping(path = "/nombre/{nombre}")
    public ArrayList<ClienteModel> obtenerClientePorNombre(@PathVariable("nombre") String nombre){
        return this.clienteService.obtenerClientePorNombre(nombre);
    }

    //Consulta clientes por puntos menor o igual a 
    @GetMapping(path = "/puntosmen/{puntos}")
    public ArrayList<ClienteModel> obtenerClientePorPuntosMenor(@PathVariable("puntos") Long puntos){
        return this.clienteService.obtenerClientePorPuntosMenor(puntos);
    }

    //Consulta clientes por puntos mayor o igual a
    @GetMapping(path = "/puntosmay/{puntos}")
    public ArrayList<ClienteModel> obtenerClientePorPuntosMayor(@PathVariable("puntos") Long puntos){
        return this.clienteService.obtenerClientePorPuntosMayor(puntos);
    }  
        
    //Consulta clientes por dos parámetros: nombre y apellido
    @GetMapping(path = "/nombreapellido/{nombre}/{apellido}")
    public ArrayList<ClienteModel> obtenerClientePorNombreApellido(@PathVariable("nombre") String nombre,
    @PathVariable("apellido") String apellido){
        return this.clienteService.obtenerClientePorNombreApellido(nombre, apellido);
    }
    
    //Consulta clientes por ciudad, mostrando solo nombres y apellidos
    @GetMapping(path = "/ubicacion/{ciudad}")
    public ArrayList<ClienteModel> obtenerClientePorCiudad(@PathVariable("ciudad") String ciudad){
        return this.clienteService.obtenerClientePorUbicacion(ciudad);
    }
    
    
    //Cliente por ciudad y departamento mostrando solo nombres y apellidos
    @GetMapping(path = "ubicacionciudep/{ciudad}/{departamento}")
    public ArrayList<ClienteModel> obtenerClientePorCiudadDepartamento(@PathVariable("ciudad") String ciudad,
    @PathVariable("departamento") String departamento){
        return this.clienteService.obtenerClientePorCiudadDepartamento(ciudad, departamento);
    }


    //Clientes con productos con cantidades entre dos números j y k
    @GetMapping(path = "/prod_cant/{cantidad}/{cantidad}")
    public ArrayList<ClienteModel> obtenerClientePorProductoCantidadEntre(@PathVariable("cantidad") int cantidad1,
    @PathVariable("cantidad") int cantidad2){
        return this.clienteService.obtenerClientePorProductoCantidadEntre(cantidad1, cantidad2);
    }


    @GetMapping(path = "puntosmenor/{puntos}")
    public ArrayList<ClienteModel> obtenerClientePorPuntosMnr(@PathVariable("puntos") Long puntos){
        return this.clienteService.clienteMenorPuntos(puntos);
    }




  
}