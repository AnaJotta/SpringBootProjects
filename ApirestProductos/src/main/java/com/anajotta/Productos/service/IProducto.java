package com.anajotta.Productos.service;

import com.anajotta.Productos.entity.Producto;

import java.util.List;

public interface IProducto {
  Producto save (Producto producto);

  List<Producto> findAll();

  Producto findById(Integer id);

  void deleteById(Integer id);

  Producto update(Producto producto);

  List<Producto> saveAll(List<Producto> productos);
}


