# MarketGestor
Trabalho Programação e Soluções Computacionais

Gabriel Salazar e William no View

Samuel Gois no DAO/Banco de Dados

Maurício e Guilherme no Model e apoio ao Banco de Dados


MODELAGEM DO BANCO DE DADOS:

-- ==========================================================
--  BANCO DE DADOS: Market_Gestor
--  Modelagem completa em SQL
-- ==========================================================

-- ======================================
-- 1. TABELA PRINCIPAL: PRODUTOS
-- ======================================

CREATE TABLE market_gestor (
    id_produto SERIAL PRIMARY KEY,
    nome_produto VARCHAR(100) NOT NULL,
    descricao_produto TEXT,
    quantidade_estoque INTEGER NOT NULL DEFAULT 0,
    preco NUMERIC(10, 2) NOT NULL,
    data_cadastro DATE DEFAULT CURRENT_DATE,
    data_validade DATE,
    categoria VARCHAR(100)
);

-- ======================================
-- 2. TABELA DE USUÁRIOS DO SISTEMA
-- ======================================

CREATE TABLE tb_usuarios (
    id_usuario SERIAL PRIMARY KEY,
    nome_completo VARCHAR(100) NOT NULL,
    login VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ======================================
-- 3. TABELA DE VENDAS
-- ======================================

CREATE TABLE tb_vendas (
    id_venda SERIAL PRIMARY KEY,
    id_produto INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    valor_total NUMERIC(10,2) NOT NULL,
    data_venda TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_venda_produto
        FOREIGN KEY (id_produto)
        REFERENCES market_gestor(id_produto)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

-- ======================================
-- 4. AVISO SOBRE TABELA DUPLICADA
-- (CASO EXISTIR, DEVE SER REMOVIDA)
-- ======================================

-- A tabela abaixo é desnecessária e deve ser ignorada.
-- Ela não possui FK para produtos e prejudica relatórios.
--
-- CREATE TABLE vendas (
--     id_venda SERIAL PRIMARY KEY,
--     data_venda DATE,
--     total_venda NUMERIC(10,2)
-- );
--
-- Recomendo excluir essa tabela se estiver no banco:
-- DROP TABLE IF EXISTS vendas;
