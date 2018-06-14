alter table orders drop constraint if exists fk_orders_customer_id;
drop index if exists ix_orders_customer_id;

alter table order_line drop constraint if exists fk_order_line_order_id;
drop index if exists ix_order_line_order_id;

alter table order_line drop constraint if exists fk_order_line_product_id;
drop index if exists ix_order_line_product_id;

drop table if exists customer;

drop table if exists orders;

drop table if exists order_line;

drop table if exists product;

