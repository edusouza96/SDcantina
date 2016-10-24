CREATE TABLE cliente (
  matricula BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NULL,
  senha VARCHAR(50) NULL,
  saldo DECIMAL(10,2) NULL,
  PRIMARY KEY(matricula)
);

CREATE TABLE pedido (
  numeroPedido INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  produto INTEGER UNSIGNED NOT NULL,
  cliente BIGINT NOT NULL,
  quantidade INTEGER UNSIGNED NULL,
  pedidoConfirmado BOOL NULL,
  PRIMARY KEY(numeroPedido),
  INDEX pedido_FKIndex1(cliente),
  INDEX pedido_FKIndex2(produto)
);

CREATE TABLE produto (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  produto VARCHAR(255) NULL,
  valor DECIMAL(10,2) NULL,
  unidades INTEGER UNSIGNED NULL,
  PRIMARY KEY(codigo)
);


