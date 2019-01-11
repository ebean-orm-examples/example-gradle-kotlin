create table customer (
  id                            bigserial not null,
  credit_limit                  decimal(38),
  notes                         varchar(500),
  name                          varchar(150) not null,
  version                       bigint not null,
  when_created                  timestamptz not null,
  when_modified                 timestamptz not null,
  constraint uq_customer_name unique (name),
  constraint pk_customer primary key (id)
);

create table orders (
  id                            bigserial not null,
  when_placed_for               timestamptz,
  when_invoiced                 timestamptz,
  customer_id                   bigint not null,
  version                       bigint not null,
  when_created                  timestamptz not null,
  when_modified                 timestamptz not null,
  constraint pk_orders primary key (id)
);

create table order_line (
  id                            bigserial not null,
  order_id                      bigint not null,
  description                   varchar(255),
  product_id                    bigint not null,
  quantity                      integer not null,
  version                       bigint not null,
  when_created                  timestamptz not null,
  when_modified                 timestamptz not null,
  constraint pk_order_line primary key (id)
);

create table product (
  id                            bigserial not null,
  sku                           varchar(20) not null,
  name                          varchar(100) not null,
  version                       bigint not null,
  when_created                  timestamptz not null,
  when_modified                 timestamptz not null,
  constraint pk_product primary key (id)
);

create index ix_orders_customer_id on orders (customer_id);
alter table orders add constraint fk_orders_customer_id foreign key (customer_id) references customer (id) on delete restrict on update restrict;

create index ix_order_line_order_id on order_line (order_id);
alter table order_line add constraint fk_order_line_order_id foreign key (order_id) references orders (id) on delete restrict on update restrict;

create index ix_order_line_product_id on order_line (product_id);
alter table order_line add constraint fk_order_line_product_id foreign key (product_id) references product (id) on delete restrict on update restrict;

