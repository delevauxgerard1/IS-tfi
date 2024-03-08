package edu.spring.istfi.repository;



import edu.spring.istfi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {


    @Query("SELECT DISTINCT c FROM Cliente c " +
            "WHERE c.dni = :dni")
    Cliente findByDni(@Param("dni") int dni);
}
