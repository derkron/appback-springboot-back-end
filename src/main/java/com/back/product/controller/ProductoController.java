package com.back.product.controller;

import com.back.product.entidades.Producto;
import com.back.product.servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/productos")
public class ProductoController  {
    @Autowired
    ProductoService productoService;

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }


    @PutMapping(path = {"/{id}"})
    public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto  ){
        producto.setId(id);
        return productoService.actualizarProducto(producto, id);
    }
    @GetMapping
    public List<Producto> listarProducto(){
        return productoService.listarProducto();
    }
    @GetMapping(path = {"/{id}"})
    public Producto verProducto(@PathVariable("id") Integer id){
        return productoService.verProducto(id);
    }
    @DeleteMapping(path = {"/{id}"})
    public void eliminarProducto(@PathVariable("id") Integer id){
        productoService.eliminarProducto(id);
    }
}
