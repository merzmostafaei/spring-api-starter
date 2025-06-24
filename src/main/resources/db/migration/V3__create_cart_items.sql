CREATE TABLE `store_api`.`cart_items` (
  `id` BIGINT NOT NULL,
  `cart_id` BINARY(16) NOT NULL,
  `product_id` BIGINT NOT NULL,
  `quantity` INT NOT NULL DEFAULT 1,

  CONSTRAINT `cart_item_pk` PRIMARY KEY (`id`),

  CONSTRAINT `cart_items_product_unique` UNIQUE (`cart_id`, `product_id`),

  INDEX `cart_items_products_fk_idx` (`product_id` ASC) VISIBLE,

  CONSTRAINT `cart_items_carts_fk`
    FOREIGN KEY (`cart_id`)
    REFERENCES `store_api`.`carts` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,

  CONSTRAINT `cart_items_products_fk`
    FOREIGN KEY (`product_id`)
    REFERENCES `store_api`.`products` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
);

