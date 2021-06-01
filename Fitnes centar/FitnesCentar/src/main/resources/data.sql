INSERT INTO FITNES_CENTAR(naziv,adresa,broj_telefona_centrale,email)
VALUES('FF1','Adresa','063477126','FF');



INSERT INTO SALA(kapacitet,oznaka_sale,ff_id)
VALUES('100','sala1',1);
INSERT INTO SALA(kapacitet,oznaka_sale,ff_id)
VALUES('15000','sala2',1);
INSERT INTO SALA(kapacitet,oznaka_sale,ff_id)
VALUES('17500','sala3',1);

INSERT INTO TERMIN(broj_prijavljenih_clanova,raspored_termina,ff_id)
VALUES('10','raspored1',1);
INSERT INTO TERMIN(broj_prijavljenih_clanova,raspored_termina,ff_id)
VALUES('1','raspored2',1);
INSERT INTO TERMIN(broj_prijavljenih_clanova,raspored_termina,ff_id)
VALUES('14','raspored3',1);

INSERT INTO TRENING(naziv,opis,tip_treninga,trajanje,cena)
VALUES('trening1','nemaopisa1','tezaktrening1','1500','100');
INSERT INTO TRENING(naziv,opis,tip_treninga,trajanje,cena)
VALUES('trening2','nemaopisa2','tezaktrening2','1700','200');
INSERT INTO TRENING(naziv,opis,tip_treninga,trajanje,cena)
VALUES('trening3','nemaopisa3','tezaktrening3','158500','300');
INSERT INTO TRENING(naziv,opis,tip_treninga,trajanje,cena)
VALUES('trening4','nemaopisa4','tezaktrening4','201','300');
INSERT INTO TRENING(naziv,opis,tip_treninga,trajanje,cena)
VALUES('trening5','nemaopisa5','tezaktrening5','0100','300');
INSERT INTO TRENING(naziv,opis,tip_treninga,trajanje,cena)
VALUES('trening6','nemaopisa6','tezaktrening6','1010','300');
INSERT INTO TRENING(naziv,opis,tip_treninga,trajanje,cena)
VALUES('trening7','nemaopisa7','tezaktrening7','0101','300');
INSERT INTO TRENING(naziv,opis,tip_treninga,trajanje,cena)
VALUES('trening8','trening9','tezaktrening8','111','300');
INSERT INTO TRENING(naziv,opis,tip_treninga,trajanje,cena)
VALUES('trening9','nemaopisa9','tezaktrening9','1111','300');
INSERT INTO TRENING(naziv,opis,tip_treninga,trajanje,cena)
VALUES('trening10','nemaopisa10','tezaktrening10','410','300');





INSERT INTO ADMINISTRATOR(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan)
VALUES('Stefan13','lozinka13','Stefan','Kalicanin','063477126','skstefankalicanin@gmail.com','13.06.2000',0,'da');
