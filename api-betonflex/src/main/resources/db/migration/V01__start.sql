CREATE SEQUENCE almoxarifado_id MINVALUE 1 INCREMENT 1;
CREATE TABLE almoxarifado (almoxarifado_id integer NOT NULL DEFAULT nextval('almoxarifado_id'), almoxarifado_nome VARCHAR(120) NOT NULL , almoxarifado_descricao VARCHAR(500) NOT NULL , almoxarifado_ativo BOOLEAN NOT NULL , almoxarifado_createat timestamp without time zone NOT NULL , PRIMARY KEY(almoxarifado_id));

CREATE SEQUENCE material_id MINVALUE 1 INCREMENT 1;
CREATE TABLE material (material_id integer NOT NULL DEFAULT nextval('material_id'), material_nome VARCHAR(120) NOT NULL , material_descricao VARCHAR(500) NOT NULL , material_observacao TEXT NOT NULL , material_sku VARCHAR(40) NOT NULL , material_ativo BOOLEAN NOT NULL , material_createat timestamp without time zone NOT NULL , PRIMARY KEY(material_id));

CREATE SEQUENCE cliente_id MINVALUE 1 INCREMENT 1;
CREATE TABLE cliente (cliente_id integer NOT NULL DEFAULT nextval('cliente_id'), cliente_nome VARCHAR(120) NOT NULL , cliente_documento VARCHAR(40) NOT NULL , cliente_createat timestamp without time zone NOT NULL , PRIMARY KEY(cliente_id));

CREATE SEQUENCE funcionario_id MINVALUE 1 INCREMENT 1;
CREATE TABLE funcionario (funcionario_id integer NOT NULL DEFAULT nextval('funcionario_id'), funcionario_nome VARCHAR(120) NOT NULL , funcionario_cargo VARCHAR(40) NOT NULL , funcionario_ativo BOOLEAN NOT NULL , PRIMARY KEY(funcionario_id));

CREATE SEQUENCE tipo_servico_id MINVALUE 1 INCREMENT 1;
CREATE TABLE tipo_servico (tipo_servico_id integer NOT NULL DEFAULT nextval('tipo_servico_id'), tipo_servico_nome VARCHAR(120) NOT NULL , tipo_servico_descricao VARCHAR(500) , tipo_servico_ativo BOOLEAN NOT NULL , tipo_servico_createat timestamp without time zone NOT NULL , PRIMARY KEY(tipo_servico_id));

CREATE SEQUENCE ordem_servico_id MINVALUE 1 INCREMENT 1;
CREATE TABLE ordem_servico (ordem_servico_id integer NOT NULL DEFAULT nextval('ordem_servico_id'), ordem_servico_numero VARCHAR(40) NOT NULL , tipo_servico_id integer NOT NULL , ordem_servico_status smallint NOT NULL , ordem_servico_data_abertura date NOT NULL , ordem_servico_valor NUMERIC(17,2) NOT NULL , PRIMARY KEY(ordem_servico_id));
CREATE INDEX IORDEM_SERVICO1 ON ordem_servico (tipo_servico_id );

CREATE SEQUENCE almoxarifado_material_id MINVALUE 1 INCREMENT 1;
CREATE TABLE almoxarifado_material (almoxarifado_material_id integer NOT NULL DEFAULT nextval('almoxarifado_material_id'), almoxarifado_id integer NOT NULL , material_id integer NOT NULL , almoxarifado_material_status VARCHAR(40) NOT NULL , almoxarifado_material_lote VARCHAR(40) , almoxarifado_material_valor_un NUMERIC(17,2) , almoxarifado_material_valor_to NUMERIC(17,2) , almoxarifado_material_qtd smallint NOT NULL , almoxarifado_material_qtd_uti smallint , almoxarifado_material_data date , PRIMARY KEY(almoxarifado_material_id));

CREATE INDEX IALMOXARIFADO_MATERIAL2 ON almoxarifado_material (almoxarifado_id );
CREATE INDEX IALMOXARIFADO_MATERIAL1 ON almoxarifado_material (material_id );

CREATE TABLE ordem_servico_produto (ordem_servico_produto smallint NOT NULL , ordem_servico_id integer NOT NULL , ordem_servico_produto_dimensao VARCHAR(40) NOT NULL , ordem_servico_produto_data_con date NOT NULL , ordem_servico_produto_traco VARCHAR(40) NOT NULL , ordem_servico_produto_resisten VARCHAR(40) NOT NULL , ordem_servico_produto_laudo BYTEA NOT NULL , PRIMARY KEY(ordem_servico_produto));
CREATE INDEX IORDEM_SERVICO_PRODUTO1 ON ordem_servico_produto (ordem_servico_id );

CREATE SEQUENCE ordem_servico_fechamento_id MINVALUE 1 INCREMENT 1;
CREATE TABLE ordem_servico_fechamento (ordem_servico_fechamento_id integer NOT NULL DEFAULT nextval('ordem_servico_fechamento_id'), ordem_servico_fechamento_data timestamp without time zone NOT NULL , ordem_servico_id integer NOT NULL , PRIMARY KEY(ordem_servico_fechamento_id));
CREATE INDEX IORDEM_SERVICO_FECHAMENTO1 ON ordem_servico_fechamento (ordem_servico_id );

CREATE SEQUENCE ordem_servico_material_id MINVALUE 1 INCREMENT 1;
CREATE TABLE ordem_servico_material (ordem_servico_material_id integer NOT NULL DEFAULT nextval('ordem_servico_material_id'), almoxarifado_material_id integer , ordem_servico_id integer NOT NULL , ordem_servico_material_data timestamp without time zone NOT NULL , ordem_servico_material_status VARCHAR(40) NOT NULL , funcionario_id integer , ordem_servico_material_valor NUMERIC(17,2) NOT NULL , almoxarifado_material_valor NUMERIC(17,2) NOT NULL , ordem_servico_material_qtd smallint NOT NULL , PRIMARY KEY(ordem_servico_material_id));
CREATE INDEX IORDEM_SERVICO_MATERIAL1 ON ordem_servico_material (almoxarifado_material_id );
CREATE INDEX IORDEM_SERVICO_MATERIAL2 ON ordem_servico_material (ordem_servico_id );
CREATE INDEX IORDEM_SERVICO_MATERIAL3 ON ordem_servico_material (funcionario_id );

CREATE SEQUENCE ordem_servico_anexo_id MINVALUE 1 INCREMENT 1;
CREATE TABLE ordem_servico_anexos (ordem_servico_anexo_id integer NOT NULL DEFAULT nextval('ordem_servico_anexo_id'), ordem_servico_id integer NOT NULL , ordem_servico_anexo_arq BYTEA NOT NULL , ordem_servico_anexo_arq_tipo VARCHAR(40) NOT NULL , ordem_servico_anexo_arq_nome VARCHAR(40) NOT NULL , PRIMARY KEY(ordem_servico_anexo_id));
CREATE INDEX IORDEM_SERVICO_ANEXOS1 ON ordem_servico_anexos (ordem_servico_id );

CREATE SEQUENCE material_movimentacao_id MINVALUE 1 INCREMENT 1;
CREATE TABLE material_movimentacao (material_movimentacao_id integer NOT NULL DEFAULT nextval('material_movimentacao_id'), almoxarifado_material_id integer NOT NULL , material_movimentacao_tipo VARCHAR(40) NOT NULL , PRIMARY KEY(material_movimentacao_id));
CREATE INDEX IMATERIAL_MOVIMENTACAO1 ON material_movimentacao (almoxarifado_material_id );

CREATE SEQUENCE ordem_servico_cliente_id MINVALUE 1 INCREMENT 1;
CREATE TABLE ordem_servico_cliente (ordem_servico_cliente_id integer NOT NULL DEFAULT nextval('ordem_servico_cliente_id'), cliente_id integer NOT NULL , ordem_servico_id integer NOT NULL , PRIMARY KEY(ordem_servico_cliente_id));
CREATE INDEX IORDEM_SERVICO_CLIENTE1 ON ordem_servico_cliente (cliente_id );
CREATE INDEX IORDEM_SERVICO_CLIENTE2 ON ordem_servico_cliente (ordem_servico_id );


ALTER TABLE almoxarifado_material ADD CONSTRAINT IALMOXARIFADO_MATERIAL2 FOREIGN KEY (almoxarifado_id) REFERENCES almoxarifado (almoxarifado_id);
ALTER TABLE almoxarifado_material ADD CONSTRAINT IALMOXARIFADO_MATERIAL1 FOREIGN KEY (material_id) REFERENCES material (material_id);
ALTER TABLE ordem_servico ADD CONSTRAINT IORDEM_SERVICO1 FOREIGN KEY (tipo_servico_id) REFERENCES tipo_servico (tipo_servico_id);
ALTER TABLE ordem_servico_cliente ADD CONSTRAINT IORDEM_SERVICO_CLIENTE1 FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id);
ALTER TABLE ordem_servico_cliente ADD CONSTRAINT IORDEM_SERVICO_CLIENTE2 FOREIGN KEY (ordem_servico_id) REFERENCES ordem_servico (ordem_servico_id);
ALTER TABLE material_movimentacao ADD CONSTRAINT IMATERIAL_MOVIMENTACAO1 FOREIGN KEY (almoxarifado_material_id) REFERENCES almoxarifado_material (almoxarifado_material_id);
ALTER TABLE ordem_servico_anexos ADD CONSTRAINT IORDEM_SERVICO_ANEXOS1 FOREIGN KEY (ordem_servico_id) REFERENCES ordem_servico (ordem_servico_id);
ALTER TABLE ordem_servico_material ADD CONSTRAINT IORDEM_SERVICO_MATERIAL1 FOREIGN KEY (almoxarifado_material_id) REFERENCES almoxarifado_material (almoxarifado_material_id);
ALTER TABLE ordem_servico_material ADD CONSTRAINT IORDEM_SERVICO_MATERIAL2 FOREIGN KEY (ordem_servico_id) REFERENCES ordem_servico (ordem_servico_id);
ALTER TABLE ordem_servico_material ADD CONSTRAINT IORDEM_SERVICO_MATERIAL3 FOREIGN KEY (funcionario_id) REFERENCES funcionario (funcionario_id);
ALTER TABLE ordem_servico_fechamento ADD CONSTRAINT IORDEM_SERVICO_FECHAMENTO1 FOREIGN KEY (ordem_servico_id) REFERENCES ordem_servico (ordem_servico_id);
ALTER TABLE ordem_servico_produto ADD CONSTRAINT IORDEM_SERVICO_PRODUTO1 FOREIGN KEY (ordem_servico_id) REFERENCES ordem_servico (ordem_servico_id);

