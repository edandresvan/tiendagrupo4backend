
start transaction;

insert ignore into usuarios 
  (cedula_usuario, usuario, nombre_usuario, email_usuario, usuario_password, rol) 
  VALUES 
    (101, 'admininicial', 'Admin Inicial', 'admininicial@correo.net', 'admin123456', 'administrador'),
    (102, 'vendedorinicial', 'Vendedor Inicial', 'vendedorinicial@correo.net', 'vendedor123456', 'usuario');

insert ignore into clientes 
  (cedula_cliente,nombre_cliente,direccion_cliente,email_cliente,telefono_cliente)
  values 
    (201, 'Cliente A', 'Calle 20 # 6-28', 'clientea@correo.com', '201001'),
    (202, 'Cliente B', 'Carrera 78 # 20-14', 'clienteb@correo.com', '202002');

insert ignore into proveedores 
  (nit_proveedor, nombre_proveedor, direccion_proveedor, ciudad_proveedor, telefono_proveedor) 
  values
  (301, 'Proveedor A', 'Carrera 67 # 12-34', 'Bogotá', '301001'),
  (302, 'Proveedor B', 'Calle 22 # 90-32', 'Bogotá', '302002'),
  (303, 'Proveedor C', 'Avenida 30 # 45-80', 'Medellín', '303003'),
  (304, 'Proveedor D', 'Carrera 23 # 12-09', 'Cartagena', '304004'),
  (305, 'Proveedor E', 'Calle 38 # 31-56', 'Manizales', '305005');

insert ignore into productos
  (codigo_producto, nombre_producto, precio_compra, iva_compra, precio_venta , nit_proveedor) 
  values 
  (451, 'Producto A', 6800, 19, 8092, 301),
  (452, 'Producto B', 3500, 16, 4060, 302),
  (453, 'Producto C', 2800,  0, 2800, 301);
  
insert ignore into ventas 
  (codigo_venta, cedula_cliente, cedula_usuario, total_venta, iva_venta, valor_venta)
  values 
  (501, 201, 102, 43500, 4926, 48426),
  (502, 202, 102, 46500, 3214, 49714),
  (503, 201, 102, 44700, 6218, 50918);

insert ignore into detalle_ventas 
  (codigo_detalle_venta, codigo_venta, codigo_producto, cantidad_producto, 
    total_venta, valor_iva, valor_venta)
  values 
  (601, 501, 451, 3, 20400, 3876, 24276),
  (602, 501, 452, 5, 17500, 1050, 18550),
  (603, 501, 453, 2, 5600, 0, 5600),
  (604, 502, 451, 2, 13600, 2584, 16184),
  (605, 502, 452, 3, 10500, 630, 11130),
  (606, 502, 453, 8, 22400, 0, 22400),
  (607, 503, 451, 4, 27200, 5168, 32368),
  (608, 503, 452, 5, 17500, 1050, 18550);

  
  
commit;
    