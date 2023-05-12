CREATE SEQUENCE tipo_servico_id MINVALUE 1 INCREMENT 1;
CREATE TABLE tipo_servico (tipo_servico_id integer NOT NULL DEFAULT nextval('tipo_servico_id'), tipo_servico_nome VARCHAR(120) NOT NULL , tipo_servico_descricao VARCHAR(500) , tipo_servico_ativo BOOLEAN NOT NULL , tipo_servico_createat timestamp without time zone NOT NULL , PRIMARY KEY(tipo_servico_id));

CREATE SEQUENCE ordem_servico_cliente_id MINVALUE 1 INCREMENT 1;
CREATE TABLE ordem_servico_cliente (ordem_servico_cliente_id integer NOT NULL DEFAULT nextval('ordem_servico_cliente_id'), cliente_id integer NOT NULL , PRIMARY KEY(ordem_servico_cliente_id));
CREATE INDEX IORDEM_SERVICO_CLIENTE1 ON ordem_servico_cliente (cliente_id );

CREATE SEQUENCE ordem_servico_id MINVALUE 1 INCREMENT 1;
CREATE TABLE ordem_servico (ordem_servico_id integer NOT NULL DEFAULT nextval('ordem_servico_id'), ordem_servico_numero VARCHAR(40) NOT NULL , tipo_servico_id integer NOT NULL , ordem_servico_status smallint NOT NULL , ordem_servico_data_abertura date NOT NULL , PRIMARY KEY(ordem_servico_id));
CREATE INDEX IORDEM_SERVICO1 ON ordem_servico (tipo_servico_id );

CREATE SEQUENCE material_id MINVALUE 1 INCREMENT 1;
CREATE TABLE material (material_id integer NOT NULL DEFAULT nextval('material_id'), material_nome VARCHAR(120) NOT NULL , material_descricao VARCHAR(500) NOT NULL , material_observacao TEXT NOT NULL , material_sku VARCHAR(40) NOT NULL , material_ativo BOOLEAN NOT NULL , material_createat timestamp without time zone NOT NULL , PRIMARY KEY(material_id));

CREATE SEQUENCE cliente_id MINVALUE 1 INCREMENT 1;
CREATE TABLE cliente (cliente_id integer NOT NULL DEFAULT nextval('cliente_id'), cliente_nome VARCHAR(120) NOT NULL , cliente_documento VARCHAR(40) NOT NULL , cliente_createat timestamp without time zone NOT NULL , PRIMARY KEY(cliente_id));

CREATE SEQUENCE almoxarifado_material_id MINVALUE 1 INCREMENT 1;
CREATE TABLE almoxarifado_material (almoxarifado_material_id integer NOT NULL DEFAULT nextval('almoxarifado_material_id'), almoxarifado_id integer NOT NULL , material_id integer NOT NULL , PRIMARY KEY(almoxarifado_material_id));
CREATE INDEX IALMOXARIFADO_MATERIAL2 ON almoxarifado_material (almoxarifado_id );
CREATE INDEX IALMOXARIFADO_MATERIAL1 ON almoxarifado_material (material_id );

CREATE SEQUENCE almoxarifado_id MINVALUE 1 INCREMENT 1;
CREATE TABLE almoxarifado (almoxarifado_id integer NOT NULL DEFAULT nextval('almoxarifado_id'), almoxarifado_nome VARCHAR(120) NOT NULL , almoxarifado_descricao VARCHAR(500) NOT NULL , almoxarifado_ativo BOOLEAN NOT NULL , almoxarifado_createat timestamp without time zone NOT NULL , PRIMARY KEY(almoxarifado_id));

ALTER TABLE almoxarifado_material ADD CONSTRAINT IALMOXARIFADO_MATERIAL2 FOREIGN KEY (almoxarifado_id) REFERENCES almoxarifado (almoxarifado_id);
ALTER TABLE almoxarifado_material ADD CONSTRAINT IALMOXARIFADO_MATERIAL1 FOREIGN KEY (material_id) REFERENCES material (material_id);

ALTER TABLE ordem_servico ADD CONSTRAINT IORDEM_SERVICO1 FOREIGN KEY (tipo_servico_id) REFERENCES tipo_servico (tipo_servico_id);

ALTER TABLE ordem_servico_cliente ADD CONSTRAINT IORDEM_SERVICO_CLIENTE1 FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id);

