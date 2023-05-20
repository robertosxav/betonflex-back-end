ALTER TABLE ordem_servico_cliente ADD COLUMN ordem_servico_id INTEGER;
CREATE INDEX IORDEM_SERVICO_ORDEM_SERVICO ON ordem_servico_cliente (ordem_servico_id);
ALTER TABLE ordem_servico_cliente ADD CONSTRAINT IORDEM_SERVICO_ORDEM_SERVICO1
  FOREIGN KEY (ordem_servico_id) REFERENCES ordem_servico(ordem_servico_id);