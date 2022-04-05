
package pe.com.serviciosrest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.serviciosrest.entity.Distrito;


public interface DistritoRepository extends JpaRepository<Distrito, Long>{
    //mostrar todo si es 1 bit
    @Query("select d from Distrito d where d.estado = '1'")
    List<Distrito> findAllCustom();
    
    //mostrando datos por nombre
    @Query("select d from Distrito d where upper(d.nombre) like upper(:nombre) "
            + "and d.estado = '1'")
    List<Distrito> findByName(@Param("nombre")String nombre);
}