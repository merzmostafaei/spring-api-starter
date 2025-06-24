CREATE TABLE `store_api`.`carts` (
  `id` BINARY(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID())),
  `date_created` DATE NOT NULL DEFAULT (CURDATE()),
  CONSTRAINT `carts_pk` PRIMARY KEY (`id`)
);

