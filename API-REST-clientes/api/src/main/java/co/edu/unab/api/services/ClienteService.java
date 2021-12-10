package co.edu.unab.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.api.models.ClienteModel;
import co.edu.unab.api.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<ClienteModel> obtenerClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public ClienteModel guardarCliente(ClienteModel cliente){
        cliente.setNombre(cliente.getNombre().toLowerCase()); //Opcional, convertir la cadena a minúscula para facilitar buscar por nombre , esto normalmente se hace desde el frontend 
        return clienteRepository.save(cliente);
    }

    public boolean eliminarCliente(String id){

        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;
        }else{
            return false;
        }      
                             
    }      
    public Optional<ClienteModel> obtenerClientePorId(String id){
        
        return clienteRepository.findById(id);
    }  

    public ArrayList<ClienteModel> obtenerClientePorNombre(String nombre){
        return clienteRepository.findByNombre(nombre);
    }

    
    public ArrayList<ClienteModel> obtenerClientePorPuntosMenor(Long puntos){
        return clienteRepository.findByPuntosLessThanEqual(puntos);
    }


    public ArrayList<ClienteModel> obtenerClientePorPuntosMayor(Long puntos){
        return clienteRepository.findByPuntosGreaterThanEqual(puntos);
    }     
    
    
    public ArrayList<ClienteModel> obtenerClientePorNombreApellido(String nombre, String apellido){
        return clienteRepository.clientePorNombreApellido(nombre, apellido);
    }
    
    
    public ArrayList<ClienteModel> obtenerClientePorUbicacion(String ciudad){
        return clienteRepository.clientePorUbicacion(ciudad);
    }
    
    //Cliente por ciudad y departamento mostrando solo nombres y apellidos
    public ArrayList<ClienteModel> obtenerClientePorCiudadDepartamento(String ciudad, String departamento){
        return clienteRepository.clientePorCiudadDepartamento(ciudad, departamento);
    }

    //Clientes con productos con cantidades entre dos números j y k
    public ArrayList<ClienteModel> obtenerClientePorProductoCantidadEntre(int cantidad1, int cantidad2){
        return clienteRepository.clienteCantidadProductoEntre(cantidad1, cantidad2);
    }    


    public ArrayList<ClienteModel> clienteMenorPuntos(Long puntos){
        return clienteRepository.clientesPorMenorPuntos(puntos);
    }








    
   

}