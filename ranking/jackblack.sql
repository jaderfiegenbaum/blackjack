--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: ranking; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ranking (
    rankingid integer NOT NULL,
    nome character varying NOT NULL,
    pontos integer DEFAULT 0 NOT NULL
);


ALTER TABLE public.ranking OWNER TO postgres;

--
-- Name: ranking_rankingid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ranking_rankingid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ranking_rankingid_seq OWNER TO postgres;

--
-- Name: ranking_rankingid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ranking_rankingid_seq OWNED BY ranking.rankingid;


--
-- Name: ranking_rankingid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ranking_rankingid_seq', 66, true);


--
-- Name: rankingid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ranking ALTER COLUMN rankingid SET DEFAULT nextval('ranking_rankingid_seq'::regclass);


--
-- Data for Name: ranking; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ranking (rankingid, nome, pontos) FROM stdin;
58	João	100000
59	João	100000
60	João	100000
61	João	100000
62	João	100000
63	João	100000
64	João	100000
65	Jaders2	100000
66	brunola	50
57	João	100000
\.


--
-- Name: chave; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ranking
    ADD CONSTRAINT chave PRIMARY KEY (rankingid);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

