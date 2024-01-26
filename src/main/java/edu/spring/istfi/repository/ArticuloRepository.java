package edu.spring.istfi.repository;

import edu.spring.istfi.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    //Articulo findByCodigo(long codigo);

   // List<Articulo> findByDescripcionContaining(String descripcion);

    //consultas con talle y color
    @Query("SELECT DISTINCT a FROM Articulo a " +
            "WHERE a.codigo = :codigo")
    Articulo findByCodigo(@Param("codigo") long codigo);

    @Query("SELECT DISTINCT a FROM Articulo a " +
            "WHERE LOWER(a.descripcion) LIKE LOWER(CONCAT('%', :descripcion, '%'))")
    List<Articulo> findByDescripcionContaining(@Param("descripcion") String descripcion);
    @Query("SELECT DISTINCT a FROM Articulo a " +
            "LEFT JOIN FETCH a.talles " +
            "LEFT JOIN FETCH a.colores " +
            "WHERE LOWER(a.descripcion) LIKE LOWER(CONCAT('%', :descripcion, '%'))")
    List<Articulo> findByDescripcionContainingWithTallesAndColores(@Param("descripcion") String descripcion);




}

