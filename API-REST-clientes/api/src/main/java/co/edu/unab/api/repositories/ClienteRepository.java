package co.edu.unab.api.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unab.api.models.ClienteModel;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteModel , String> {
    
      ArrayList<ClienteModel> findByNombre(String nombre);

      ArrayList<ClienteModel> findByPuntosGreaterThanEqual(Long puntos);
      
      ArrayList<ClienteModel> findByPuntosLessThanEqual(Long puntos);

       

      
      @Query("{'nombre':?0,'apellido':?1}")
      ArrayList<ClienteModel> clientePorNombreApellido(String nombre, String apellido);
      
      
      @Query(value = "{'address.ciudad':?0}", fields = "{'nombre':1,'apellido':1}")
      ArrayList<ClienteModel> clientePorUbicacion(String ciudad);
      
      
      //Cliente por ciudad y departamento mostrando solo nombres y apellidos
      @Query(value = "{'address.ciudad':?0,'address.departamento':?1}", fields = "{'nombre':1,'apellido':1}")
      ArrayList<ClienteModel> clientePorCiudadDepartamento(String ciudad, String departamento);


      //Clientes con productos con cantidades entre dos números j y k
      @Query(value = "{'productos.cantidad':{$gt:?0,$lt:?1}}")
      ArrayList<ClienteModel> clienteCantidadProductoEntre(int cantidad1, int cantidad2);

      //
      @Query("{'puntos':{$lte:?0}}")
      ArrayList<ClienteModel> clientesPorMenorPuntos(Long puntos);






}

