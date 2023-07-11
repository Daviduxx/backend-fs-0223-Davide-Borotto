DROP TABLE clienti;
DROP TABLE fatture;

-- Clienti (NumeroCliente, Nome, Cognome, DataNascita, RegioneResidenza);

CREATE TABLE IF NOT EXISTS clienti (
	numero_cliente SERIAL PRIMARY KEY,
	nome VARCHAR NOT NULL,
	cognome VARCHAR NOT NULL,
	data_nascita DATE NOT NULL,
	regione_residenza VARCHAR NOT NULL
);

-- Fatture (NumeroFattura, Tipologia, Importo, Iva, IdCliente, DataFattura, NumeroFornitore);

CREATE TABLE IF NOT EXISTS fatture (
	numero_fattura SERIAL PRIMARY KEY,
	tipologia VARCHAR NOT NULL,
	importo INTEGER NOT NULL,
	iva INTEGER NOT NULL,
	id_cliente INTEGER,
	data_fattura DATE NOT NULL,
	numero_fornitore INTEGER,
	CONSTRAINT fattura_cliente_fk FOREIGN KEY (id_cliente) REFERENCES clienti (numero_cliente),
	CONSTRAINT regione_fornitore_fk FOREIGN KEY (numero_fornitore) REFERENCES fornitori (numero_fornitore)
);

-- Prodotti (IdProdotto, Descrizione, InProduzione, InCommercio,  DataAttivazione, DataDisattivazione);

CREATE TABLE IF NOT EXISTS prodotti (
	id_prodotto SERIAL PRIMARY KEY,
	descrizione VARCHAR NOT NULL,
	in_produzione BOOLEAN NOT NULL,
	in_commercio BOOLEAN NOT NULL,
	data_attivazione DATE NOT NULL,
	data_disattivazione DATE
);

-- Fornitori (NumeroFornitore, Denominazione, RegioneResidenza);

CREATE TABLE IF NOT EXISTS fornitori (
	numero_fornitore SERIAL PRIMARY KEY,
	denominazione VARCHAR NOT NULL,
	regione_residenza VARCHAR NOT NULL
);

INSERT INTO clienti(nome, cognome, data_nascita, regione_residenza)
	VALUES ('Mario', 'Rossi', '1/2/1982', 'Lombardia'),
			('Luigi', 'Bianchi', '8/9/1980', 'Piemonte'),
			('Maria', 'Verdi', '5/5/1892', 'Veneto'),
			('Aldo', 'Bliu', '4/7/1980', 'Valle dAosta');
			
INSERT INTO fornitori(denominazione, regione_residenza)
	VALUES ('Fornifuoco', 'Lazio'),
			('Forniciao', 'Liguria');
			
INSERT INTO fatture(tipologia, importo, iva, id_cliente, data_fattura, numero_fornitore)
	VALUES ('A', 55, 20, 1, '4/5/2023', 1),
			('B', 20, 20, 4, '8/6/2023', 1),
			('C', 70, 30, 3, '7/7/2023', 2),
			('A', 72, 30, 2, '11/7/2023', 2);
			
INSERT INTO prodotti(descrizione, in_produzione, in_commercio, data_attivazione, data_disattivazione)
	VALUES ('smartphone', true, true, '3/8/2020', '7/3/2025'),
			('pc', true, false, '4/1/2020', '8/8/2026'),
			('smartwatch', true, true, '6/9/2022', '4/15/2026');
			
SELECT nome, cognome FROM clienti WHERE EXTRACT(YEAR FROM data_nascita) = 1982;
SELECT COUNT(*) AS numero_fatture FROM fatture WHERE iva = 20;
SELECT EXTRACT(YEAR FROM data_fattura) AS anno,
COUNT(*) AS numero_fatture,
SUM(importo) AS somma_totale
FROM fatture GROUP BY EXTRACT(YEAR FROM data_fattura);
SELECT * FROM prodotti WHERE EXTRACT(YEAR FROM data_attivazione) = 2020 AND (in_produzione = true OR in_commercio = true);
SELECT EXTRACT(YEAR FROM data_fattura) AS anno, COUNT(*) AS numero FROM fatture WHERE iva = 20 GROUP BY EXTRACT(YEAR FROM data_fattura);
SELECT 
EXTRACT(YEAR FROM data_fattura) AS anno,
COUNT(*) AS numerodi_fatture
FROM fatture 
WHERE tipologia = 'A'
GROUP BY EXTRACT(YEAR FROM data_fattura)
HAVING COUNT(*) > 1;
SELECT numero_fattura, importo, iva, data_fattura, denominazione
FROM FATTURE INNER JOIN fornitori ON fatture.numero_fornitore = fornitori.numero_fornitore; 
SELECT clienti.regione_residenza, SUM(fatture.importo) AS numero_fatture 
FROM fatture INNER JOIN clienti ON fatture.id_cliente = clienti.numero_cliente
GROUP BY clienti.regione_residenza;
SELECT nome FROM clienti INNER JOIN fatture ON fatture.id_cliente = clienti.numero_cliente
WHERE EXTRACT(YEAR FROM data_nascita) = 1980 AND fatture.importo > 50
GROUP BY clienti.nome;
SELECT CONCAT(nome, '-', cognome) FROM clienti WHERE regione_residenza = 'Veneto';