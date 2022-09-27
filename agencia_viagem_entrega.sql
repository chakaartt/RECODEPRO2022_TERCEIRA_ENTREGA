CREATE TABLE `permissoes` (
  `id_permissao` int NOT NULL AUTO_INCREMENT,
  `tipo_permissao` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_permissao`)
) ;

CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nome_Usuario` varchar(80) DEFAULT NULL,
  `email_Usuario` char(175) DEFAULT NULL,
  `senha_Usuario` varchar(120) DEFAULT NULL,
  `id_permissao` int DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_permissao` (`id_permissao`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_permissao`) REFERENCES `permissoes` (`id_permissao`)
);

CREATE TABLE `compra` (
  `id_compra` int NOT NULL AUTO_INCREMENT,
  `data_compra` date DEFAULT NULL,
  `valor_compra` decimal(5,0) DEFAULT NULL,
  `id_Usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `id_Usuario` (`id_Usuario`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_Usuario`) REFERENCES `usuario` (`id_usuario`)
) ;

CREATE TABLE `itens` (
  `valor_itens` int DEFAULT NULL,
  `qtd_itens` varchar(10) DEFAULT NULL,
  `id_compra` int DEFAULT NULL,
  `id_viagem` varchar(80) DEFAULT NULL,
  KEY `id_compra` (`id_compra`),
  CONSTRAINT `itens_compra_ibfk_1` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`)
);

CREATE TABLE `viagem` (
  `id_viagem` int NOT NULL,
  `destino_viagem` varchar(80) DEFAULT NULL,
  `preco_viagem` decimal(5,2) DEFAULT NULL,
  `hotel_viagem` varchar(50) DEFAULT NULL,
  `pacotes_viagem` varchar(20) DEFAULT NULL,
  `id_itens_compra` int DEFAULT NULL,
  PRIMARY KEY (`id_viagem`)
);




