package edu.spring.istfi.servicio;

import edu.spring.istfi.model.*;
import edu.spring.istfi.servicio.ArticuloService;
import edu.spring.istfi.repository.ArticuloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArticuloServiceTest {

    private ArticuloService servicio;
    private ArticuloRepository repositorioArticulos;

    @BeforeEach
    public void setUp() {
        repositorioArticulos = mock(ArticuloRepository.class);
        servicio = new ArticuloService(repositorioArticulos);
    }

    @Test
    public void crearArticulo() {
        Articulo articulo = crearArticuloDePrueba();
        guardarArticuloEnRepositorio(articulo);

        assertEquals("Remera", articulo.getDescripcion());
        assertEquals(4500, articulo.getCosto());
        assertEquals(10, articulo.getMargenDeGanancia());
        assertEquals("XL", articulo.getTalle().getDescripcion());
        assertEquals("Negro", articulo.getColor().getDescripcion());
        assertEquals("Adidas", articulo.getMarca().getDescripcion());
        assertEquals("Deportiva", articulo.getCategoria().getDescripcion());

        verify(repositorioArticulos, times(1)).save(any(Articulo.class));
    }

    @Test
    public void buscarArticuloPorCodigo() {
        Articulo articuloEjemplo = crearArticuloDePrueba();
        when(repositorioArticulos.findByCodigo(001)).thenReturn(articuloEjemplo);

        Articulo articuloEncontrado = servicio.buscarArticuloPorCodigo(001);

        assertEquals("Remera", articuloEncontrado.getDescripcion());
        assertEquals(4500, articuloEncontrado.getCosto());
        assertEquals(10, articuloEncontrado.getMargenDeGanancia());
        assertEquals("XL", articuloEncontrado.getTalle().getDescripcion());
        assertEquals("Adidas", articuloEncontrado.getMarca().getDescripcion());
        assertEquals("Negro", articuloEncontrado.getColor().getDescripcion());
        assertEquals("Deportiva", articuloEncontrado.getCategoria().getDescripcion());

        verify(repositorioArticulos, times(1)).findByCodigo(001);
    }

    private Articulo crearArticuloDePrueba() {
        Talle talle = new Talle("XL");
        Color color = new Color("Negro");
        Marca marca = new Marca("Adidas");
        Categoria categoria = new Categoria("Deportiva");

        Articulo articulo = servicio.createArticulo("Remera", 4500, 10);
        articulo.setTalle(talle);
        articulo.setColor(color);
        articulo.setMarca(marca);
        articulo.setCategoria(categoria);

        return articulo;
    }

    private void guardarArticuloEnRepositorio(Articulo articulo) {
        when(repositorioArticulos.save(any(Articulo.class))).thenReturn(articulo);
    }
}
