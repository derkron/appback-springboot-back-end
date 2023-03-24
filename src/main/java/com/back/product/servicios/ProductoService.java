package com.back.product.servicios;

import com.back.product.entidades.Producto;
import com.back.product.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;
    public Producto crearProducto (Producto nuevoProducto){
        return productoRepository.save(nuevoProducto);
    }

    public List<Producto> listarProducto(){
        return productoRepository.findAll();
    }

    public Producto actualizarProducto (Producto producto,Integer id){
        Producto produc=productoRepository.findById(id).get();
        produc.setNombre(producto.getNombre());
        produc.setDescripcion(producto.getDescripcion());
        produc.setFecha(producto.getFecha());
        return productoRepository.save(produc);

    }

    public void eliminarProducto(Integer id){

        productoRepository.deleteById(id);
    }

    public Producto verProducto(Integer id){
        return productoRepository.findById(id).get();
    }


}
