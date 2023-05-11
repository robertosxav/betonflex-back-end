--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2023-05-10 20:17:22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 34732)
-- Name: administrativo; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA administrativo;


ALTER SCHEMA administrativo OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 315 (class 1259 OID 51160)
-- Name: almoxarifado; Type: TABLE; Schema: administrativo; Owner: postgres
--

CREATE TABLE administrativo.almoxarifado (
    almoxarifado_id character(36) NOT NULL,
    almoxarifado_nome character varying(120) NOT NULL,
    almoxarifado_descricao character varying(500) NOT NULL,
    almoxarifado_ativo boolean NOT NULL,
    almoxarifado_createat timestamp without time zone NOT NULL
);


ALTER TABLE administrativo.almoxarifado OWNER TO postgres;

--
-- TOC entry 316 (class 1259 OID 51177)
-- Name: almoxarifado_material; Type: TABLE; Schema: administrativo; Owner: postgres
--

CREATE TABLE administrativo.almoxarifado_material (
    almoxarifado_material_id character(36) NOT NULL,
    almoxarifado_id character(36) NOT NULL,
    material_id character(36) NOT NULL
);


ALTER TABLE administrativo.almoxarifado_material OWNER TO postgres;

--
-- TOC entry 312 (class 1259 OID 51142)
-- Name: cliente; Type: TABLE; Schema: administrativo; Owner: postgres
--

CREATE TABLE administrativo.cliente (
    cliente_id character(36) NOT NULL,
    cliente_nome character varying(120) NOT NULL,
    cliente_documento character varying(40) NOT NULL,
    cliente_createat timestamp without time zone NOT NULL
);


ALTER TABLE administrativo.cliente OWNER TO postgres;

--
-- TOC entry 314 (class 1259 OID 51153)
-- Name: material; Type: TABLE; Schema: administrativo; Owner: postgres
--

CREATE TABLE administrativo.material (
    material_id character(36) NOT NULL,
    material_nome character varying(120) NOT NULL,
    material_descricao character varying(500) NOT NULL,
    material_observacao text NOT NULL,
    material_sku character varying(40) NOT NULL,
    material_ativo boolean NOT NULL,
    material_createat timestamp without time zone NOT NULL
);


ALTER TABLE administrativo.material OWNER TO postgres;

--
-- TOC entry 311 (class 1259 OID 51136)
-- Name: ordem_servico; Type: TABLE; Schema: administrativo; Owner: postgres
--

CREATE TABLE administrativo.ordem_servico (
    ordem_servico_id character(36) NOT NULL,
    ordem_servico_numero character varying(40) NOT NULL,
    ordem_servico_status smallint NOT NULL,
    ordem_servico_data_abertura date NOT NULL,
    tipo_servico_id character(36) NOT NULL
);


ALTER TABLE administrativo.ordem_servico OWNER TO postgres;

--
-- TOC entry 313 (class 1259 OID 51147)
-- Name: ordem_servico_cliente; Type: TABLE; Schema: administrativo; Owner: postgres
--

CREATE TABLE administrativo.ordem_servico_cliente (
    ordem_servico_cliente_id character(36) NOT NULL,
    cliente_id character(36) NOT NULL
);


ALTER TABLE administrativo.ordem_servico_cliente OWNER TO postgres;

--
-- TOC entry 310 (class 1259 OID 51129)
-- Name: tipo_servico; Type: TABLE; Schema: administrativo; Owner: postgres
--

CREATE TABLE administrativo.tipo_servico (
    tipo_servico_id character(36) NOT NULL,
    tipo_servico_nome character varying(120) NOT NULL,
    tipo_servico_descricao character varying(500),
    tipo_servico_createat timestamp without time zone NOT NULL,
    tipo_servico_ativo boolean NOT NULL
);


ALTER TABLE administrativo.tipo_servico OWNER TO postgres;

--
-- TOC entry 3656 (class 0 OID 51160)
-- Dependencies: 315
-- Data for Name: almoxarifado; Type: TABLE DATA; Schema: administrativo; Owner: postgres
--

COPY administrativo.almoxarifado (almoxarifado_id, almoxarifado_nome, almoxarifado_descricao, almoxarifado_ativo, almoxarifado_createat) FROM stdin;
\.


--
-- TOC entry 3657 (class 0 OID 51177)
-- Dependencies: 316
-- Data for Name: almoxarifado_material; Type: TABLE DATA; Schema: administrativo; Owner: postgres
--

COPY administrativo.almoxarifado_material (almoxarifado_material_id, almoxarifado_id, material_id) FROM stdin;
\.


--
-- TOC entry 3653 (class 0 OID 51142)
-- Dependencies: 312
-- Data for Name: cliente; Type: TABLE DATA; Schema: administrativo; Owner: postgres
--

COPY administrativo.cliente (cliente_id, cliente_nome, cliente_documento, cliente_createat) FROM stdin;
\.


--
-- TOC entry 3655 (class 0 OID 51153)
-- Dependencies: 314
-- Data for Name: material; Type: TABLE DATA; Schema: administrativo; Owner: postgres
--

COPY administrativo.material (material_id, material_nome, material_descricao, material_observacao, material_sku, material_ativo, material_createat) FROM stdin;
\.


--
-- TOC entry 3652 (class 0 OID 51136)
-- Dependencies: 311
-- Data for Name: ordem_servico; Type: TABLE DATA; Schema: administrativo; Owner: postgres
--

COPY administrativo.ordem_servico (ordem_servico_id, ordem_servico_numero, ordem_servico_status, ordem_servico_data_abertura, tipo_servico_id) FROM stdin;
\.


--
-- TOC entry 3654 (class 0 OID 51147)
-- Dependencies: 313
-- Data for Name: ordem_servico_cliente; Type: TABLE DATA; Schema: administrativo; Owner: postgres
--

COPY administrativo.ordem_servico_cliente (ordem_servico_cliente_id, cliente_id) FROM stdin;
\.


--
-- TOC entry 3651 (class 0 OID 51129)
-- Dependencies: 310
-- Data for Name: tipo_servico; Type: TABLE DATA; Schema: administrativo; Owner: postgres
--

COPY administrativo.tipo_servico (tipo_servico_id, tipo_servico_nome, tipo_servico_descricao, tipo_servico_createat, tipo_servico_ativo) FROM stdin;
\.


--
-- TOC entry 3505 (class 2606 OID 51181)
-- Name: almoxarifado_material almoxarifado_material_pkey; Type: CONSTRAINT; Schema: administrativo; Owner: postgres
--

ALTER TABLE ONLY administrativo.almoxarifado_material
    ADD CONSTRAINT almoxarifado_material_pkey PRIMARY KEY (almoxarifado_material_id);


--
-- TOC entry 3503 (class 2606 OID 51166)
-- Name: almoxarifado almoxarifado_pkey; Type: CONSTRAINT; Schema: administrativo; Owner: postgres
--

ALTER TABLE ONLY administrativo.almoxarifado
    ADD CONSTRAINT almoxarifado_pkey PRIMARY KEY (almoxarifado_id);


--
-- TOC entry 3496 (class 2606 OID 51146)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: administrativo; Owner: postgres
--

ALTER TABLE ONLY administrativo.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cliente_id);


--
-- TOC entry 3501 (class 2606 OID 51159)
-- Name: material material_pkey; Type: CONSTRAINT; Schema: administrativo; Owner: postgres
--

ALTER TABLE ONLY administrativo.material
    ADD CONSTRAINT material_pkey PRIMARY KEY (material_id);


--
-- TOC entry 3499 (class 2606 OID 51151)
-- Name: ordem_servico_cliente ordem_servico_cliente_pkey; Type: CONSTRAINT; Schema: administrativo; Owner: postgres
--

ALTER TABLE ONLY administrativo.ordem_servico_cliente
    ADD CONSTRAINT ordem_servico_cliente_pkey PRIMARY KEY (ordem_servico_cliente_id);


--
-- TOC entry 3494 (class 2606 OID 51140)
-- Name: ordem_servico ordem_servico_pkey; Type: CONSTRAINT; Schema: administrativo; Owner: postgres
--

ALTER TABLE ONLY administrativo.ordem_servico
    ADD CONSTRAINT ordem_servico_pkey PRIMARY KEY (ordem_servico_id);


--
-- TOC entry 3491 (class 2606 OID 51135)
-- Name: tipo_servico tipo_servico_pkey; Type: CONSTRAINT; Schema: administrativo; Owner: postgres
--

ALTER TABLE ONLY administrativo.tipo_servico
    ADD CONSTRAINT tipo_servico_pkey PRIMARY KEY (tipo_servico_id);


--
-- TOC entry 3506 (class 1259 OID 51182)
-- Name: ialmoxarifado_material1; Type: INDEX; Schema: administrativo; Owner: postgres
--

CREATE INDEX ialmoxarifado_material1 ON administrativo.almoxarifado_material USING btree (material_id);


--
-- TOC entry 3507 (class 1259 OID 51183)
-- Name: ialmoxarifado_material2; Type: INDEX; Schema: administrativo; Owner: postgres
--

CREATE INDEX ialmoxarifado_material2 ON administrativo.almoxarifado_material USING btree (almoxarifado_id);


--
-- TOC entry 3492 (class 1259 OID 51141)
-- Name: iordem_servico1; Type: INDEX; Schema: administrativo; Owner: postgres
--

CREATE INDEX iordem_servico1 ON administrativo.ordem_servico USING btree (tipo_servico_id);


--
-- TOC entry 3497 (class 1259 OID 51152)
-- Name: iordem_servico_cliente1; Type: INDEX; Schema: administrativo; Owner: postgres
--

CREATE INDEX iordem_servico_cliente1 ON administrativo.ordem_servico_cliente USING btree (cliente_id);


--
-- TOC entry 3510 (class 2606 OID 51189)
-- Name: almoxarifado_material ialmoxarifado_material1; Type: FK CONSTRAINT; Schema: administrativo; Owner: postgres
--

ALTER TABLE ONLY administrativo.almoxarifado_material
    ADD CONSTRAINT ialmoxarifado_material1 FOREIGN KEY (material_id) REFERENCES administrativo.material(material_id);


--
-- TOC entry 3511 (class 2606 OID 51184)
-- Name: almoxarifado_material ialmoxarifado_material2; Type: FK CONSTRAINT; Schema: administrativo; Owner: postgres
--

ALTER TABLE ONLY administrativo.almoxarifado_material
    ADD CONSTRAINT ialmoxarifado_material2 FOREIGN KEY (almoxarifado_id) REFERENCES administrativo.almoxarifado(almoxarifado_id);


--
-- TOC entry 3508 (class 2606 OID 51167)
-- Name: ordem_servico iordem_servico1; Type: FK CONSTRAINT; Schema: administrativo; Owner: postgres
--

ALTER TABLE ONLY administrativo.ordem_servico
    ADD CONSTRAINT iordem_servico1 FOREIGN KEY (tipo_servico_id) REFERENCES administrativo.tipo_servico(tipo_servico_id);


--
-- TOC entry 3509 (class 2606 OID 51172)
-- Name: ordem_servico_cliente iordem_servico_cliente1; Type: FK CONSTRAINT; Schema: administrativo; Owner: postgres
--

ALTER TABLE ONLY administrativo.ordem_servico_cliente
    ADD CONSTRAINT iordem_servico_cliente1 FOREIGN KEY (cliente_id) REFERENCES administrativo.cliente(cliente_id);


-- Completed on 2023-05-10 20:17:22

--
-- PostgreSQL database dump complete
--

