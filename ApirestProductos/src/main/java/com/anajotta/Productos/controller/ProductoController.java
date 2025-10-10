package com.anajotta.Productos.controller;

import com.anajotta.Productos.entity.Producto;
import com.anajotta.Productos.service.IProducto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

  private IProducto iProducto;

  public ProductoController(IProducto iProducto) {
    this.iProducto = iProducto;
  }

  //POST
  //http://localhost:8080
  // POST individual
  @PostMapping
  public Producto save(@RequestBody Producto producto) {
    return iProducto.save(producto);
  }

  //http://localhost:8080/lista
  // POST múltiple
  @PostMapping("/lista")
  public List<Producto> saveAll(@RequestBody List<Producto> productos) {
    return iProducto.saveAll(productos);
  }

  //GET
  //http://localhost:8080
  @GetMapping
  public List<Producto>  findAll(){
    return iProducto.findAll();
  }

  //GET
  //http://localhost:8080/1
  @GetMapping("/{id}")
  public Producto findById(@PathVariable Integer id){
    return iProducto.findById(id);
  }

  //DELETE
  //http://localhost:8080/1
  @DeleteMapping("/{idProducto}")
  public void deleteById(@PathVariable("idProducto") Integer id){
    iProducto.deleteById(id);
  }

  //PUT
  //http://localhost:8080
  @PutMapping
  public Producto update (@RequestBody Producto producto){
    return iProducto.update(producto);
  }


}