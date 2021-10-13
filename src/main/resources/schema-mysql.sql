
--create database if not exists tiendavirtualgrupo4;
--use tiendavirtualgrupo4;


create table if not exists usuarios (
  cedula_usuario bigint unsigned not null,
  usuario varchar(255) not null unique,
  nombre_usuario varchar(255) not null,
  email_usuario varchar(255) not null,
  usuario_password varchar(255) not null,
  rol varchar(255) not null,
  -- 
  constraint pk_usuarios primary key (cedula_usuario),
  check (rol in ('administrador', 'usuario'))
);

create table if not exists clientes (
  cedula_cliente bigint unsigned not null,
  nombre_cliente varchar(255) not null,
  direccion_cliente varchar(255) not null,
  email_cliente varchar(255) not null,
  telefono_cliente varchar(255) not null,
  -- 
  constraint pk_clientes primary key (cedula_cliente)
);

create table if not exists proveedores (
  nit_proveedor bigint unsigned not null ,
  nombre_proveedor varchar(255) not null unique,
  direccion_proveedor varchar(255) not null,
  ciudad_proveedor varchar(255) not null,
  telefono_proveedor varchar(255) not null,
  -- 
  constraint pk_proveedores primary key (nit_proveedor)
);

create table if not exists productos (
  codigo_producto bigint unsigned not null,
  nombre_producto varchar(255) not null unique,
  precio_compra double not null, 
  iva_compra double not null,
   precio_venta double not null,
  nit_proveedor bigint unsigned not null,
  -- 
  constraint pk_producto primary key (codigo_producto),
  constraint fk_producto_nit_proveedor 
    foreign key (nit_proveedor) references proveedores(nit_proveedor)
);

create table if not exists ventas (
  codigo_venta bigint unsigned not null auto_increment,
  cedula_cliente bigint unsigned not null,
  cedula_usuario bigint unsigned not null,  
  total_venta double not null,
  iva_venta double not null,
  valor_venta double not null,
  -- 
  constraint pk_ventas primary key (codigo_venta),
  constraint fk_ventas_cedula_cliente 
    foreign key (cedula_cliente) references clientes(cedula_cliente),
  constraint fk_ventas_cedula_usuario 
    foreign key (cedula_usuario) references usuarios(cedula_usuario)
);

create table if not exists detalle_ventas (
  codigo_detalle_venta bigint unsigned not null,
  codigo_venta bigint unsigned not null,
  codigo_producto bigint unsigned not null,
  cantidad_producto int unsigned not null,
  total_venta double not null,
  valor_iva double not null,
  valor_venta double not null,
  -- 
  constraint pk_detalle_ventas primary key (codigo_detalle_venta),
  constraint uq_detalle_venta_producto 
    unique (codigo_detalle_venta, codigo_venta, codigo_producto),
  constraint fk_detalle_ventas_codigo_venta
    foreign key (codigo_detalle_venta)
    references ventas(codigo_venta),
  constraint fk_detalle_ventas_codigo_producto 
    foreign key (codigo_producto) references productos(codigo_producto)
);
