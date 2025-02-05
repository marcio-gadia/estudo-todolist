create table if not exists todos(
    id serial primary key,
    nome text not null,
    descricao text not null,
    realizado BOOLEAN null,
    prioridade int not null
);