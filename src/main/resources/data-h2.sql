INSERT INTO  PRODOTTO (PROD_ID, NOME_PRODOTTO) VALUES ('1', 'acqua 0.5L');
INSERT INTO  PRODOTTO (PROD_ID, NOME_PRODOTTO) VALUES ('2', 'acqua 1L');
INSERT INTO  PRODOTTO (PROD_ID, NOME_PRODOTTO) VALUES ('3', 'scatola biscotti');

INSERT INTO AREA_GEOGRAFICA (AREA_ID, NOME) VALUES ('1', 'Roma');
INSERT INTO AREA_GEOGRAFICA (AREA_ID, NOME) VALUES ('2', 'Milano');

INSERT INTO COMPONENTE (COMP_ID, NOME_COMPONENTE, PRODOTTO_PROD_ID) VALUES ('0','Tappo','1');
INSERT INTO COMPONENTE (COMP_ID, NOME_COMPONENTE, PRODOTTO_PROD_ID) VALUES ('1','Bottiglia','1');
INSERT INTO COMPONENTE (COMP_ID, NOME_COMPONENTE, PRODOTTO_PROD_ID) VALUES ('2','Etichetta','1');
INSERT INTO COMPONENTE (COMP_ID, NOME_COMPONENTE, PRODOTTO_PROD_ID) VALUES ('0','Tappo','2');
INSERT INTO COMPONENTE (COMP_ID, NOME_COMPONENTE, PRODOTTO_PROD_ID) VALUES ('1','Bottiglia','2');
INSERT INTO COMPONENTE (COMP_ID, NOME_COMPONENTE, PRODOTTO_PROD_ID) VALUES ('0','Scatola','3');
INSERT INTO COMPONENTE (COMP_ID, NOME_COMPONENTE, PRODOTTO_PROD_ID) VALUES ('1','Incarto','3');

INSERT INTO CATEGORIA_SMALTIMENTO (CAT_ID, CATEGORIA) VALUES ('0','NON RICICLABILE');
INSERT INTO CATEGORIA_SMALTIMENTO (CAT_ID, CATEGORIA) VALUES ('1','CARTA');
INSERT INTO CATEGORIA_SMALTIMENTO (CAT_ID, CATEGORIA) VALUES ('2','PLASTICA');
INSERT INTO CATEGORIA_SMALTIMENTO (CAT_ID, CATEGORIA) VALUES ('3','ALLUMINIO');
INSERT INTO CATEGORIA_SMALTIMENTO (CAT_ID, CATEGORIA) VALUES ('4','UMIDO');
INSERT INTO CATEGORIA_SMALTIMENTO (CAT_ID, CATEGORIA) VALUES ('5','VETRO');

INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, AREA_GEOGRAFICA_AREA_ID, CAT_ID) VALUES ('0','1','1','2');
INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, AREA_GEOGRAFICA_AREA_ID, CAT_ID) VALUES ('0','1','2','2');
INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, AREA_GEOGRAFICA_AREA_ID, CAT_ID) VALUES ('1','1','1','2');
INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, AREA_GEOGRAFICA_AREA_ID, CAT_ID) VALUES ('1','1','2','0');
INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, AREA_GEOGRAFICA_AREA_ID, CAT_ID) VALUES ('2','1','1','1');
INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, AREA_GEOGRAFICA_AREA_ID, CAT_ID) VALUES ('2','1','2','2');
INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, AREA_GEOGRAFICA_AREA_ID, CAT_ID) VALUES ('0','2','1','3');
INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, AREA_GEOGRAFICA_AREA_ID, CAT_ID) VALUES ('0','2','2','3');
INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, AREA_GEOGRAFICA_AREA_ID, CAT_ID) VALUES ('1','2','1','0');
INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, AREA_GEOGRAFICA_AREA_ID, CAT_ID) VALUES ('1','2','2','5');
INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, DESCRIZIONE, AREA_GEOGRAFICA_AREA_ID) VALUES ('0','3','altro smaltimento','1');
INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, AREA_GEOGRAFICA_AREA_ID, CAT_ID) VALUES ('0','3','2','1');
INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, AREA_GEOGRAFICA_AREA_ID, CAT_ID) VALUES ('1','3','1','1');
INSERT INTO POLITICA_SMALTIMENTO (POL_COMP_ID, POL_PROD_ID, DESCRIZIONE, AREA_GEOGRAFICA_AREA_ID) VALUES ('1','3','altro smaltimento','2');
