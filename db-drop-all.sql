alter table if exists animal drop constraint if exists fk_animal_owner_id;
drop index if exists ix_animal_owner_id;

alter table if exists orders drop constraint if exists fk_orders_customer_id;
drop index if exists ix_orders_customer_id;

alter table if exists order_line drop constraint if exists fk_order_line_order_id;
drop index if exists ix_order_line_order_id;

alter table if exists order_line drop constraint if exists fk_order_line_product_id;
drop index if exists ix_order_line_product_id;

drop table if exists animal cascade;

drop table if exists customer cascade;

drop table if exists orders cascade;

drop table if exists order_line cascade;

drop table if exists owner cascade;

drop table if exists product cascade;

