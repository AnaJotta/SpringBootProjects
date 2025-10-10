package com.anajotta.Productos.service;

import com.anajotta.Productos.entity.Producto;
import com.anajotta.Productos.respository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImplementar implements IProducto{

  private ProductoRepository productoRepository;

  public ProductoServiceImplementar(ProductoRepository productoRepository) {
    this.productoRepository = productoRepository;
  }

  @Override
  public Producto save(Producto producto) {
    return productoRepository.save(producto);
  }

  @Override
  public List<Producto> findAll() {
    return productoRepository.findAll();
  }

  @Override
  public Producto findById(Integer id) {
    return productoRepository.findById(id).get();
  }

  @Override
  public void deleteById(Integer id) {
    productoRepository.deleteById(id);
  }

  @Override
  public Producto update(Producto producto) {
    Producto productoBDD = productoRepository.findById(producto.getId()).get();

    productoBDD.setNombre(producto.getNombre());
    productoBDD.setDetalle(producto.getDetalle());
    productoBDD.setPrecio(producto.getPrecio());

    return productoRepository.save(productoBDD);
  }

  @Override
  public List<Producto> saveAll(List<Producto> productos) {
    return productoRepository.saveAll(productos);
  }
}


