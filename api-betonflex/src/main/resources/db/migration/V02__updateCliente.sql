ALTER TABLE cliente ADD COLUMN cliente_ativo BOOLEAN;
ALTER TABLE cliente ALTER COLUMN cliente_ativo SET DEFAULT true;