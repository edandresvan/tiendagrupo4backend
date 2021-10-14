
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
  VALUES 
  (301, 'Proveedor A', 'Carrera 67 # 12-34', 'Bogotá', '301001'),
  (302, 'Proveedor B', 'Calle 22 # 90-32', 'Bogotá', '302002'),
  (303, 'Proveedor C', 'Avenida 30 # 45-80', 'Medellín', '303003'),
  (304, 'Proveedor D', 'Carrera 23 # 12-09', 'Cartagena', '304004'),
  (305, 'Proveedor E', 'Calle 38 # 31-56', 'Manizales', '305005');

  
commit;
    