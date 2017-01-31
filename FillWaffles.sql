insert into Waffle(cream,fruit,price,sugar,topping,type) values('Nie','Nie',3.5,'Nie','Nie','Suchy');
insert into Waffle(cream,fruit,price,sugar,topping,type) values('Nie','Nie',4,'Tak','Nie','Z cukrem pudrem');
insert into Waffle(cream,fruit,price,sugar,topping,type) values('Nie','Nie',5,'Nie','Tak','Z polewą');
insert into Waffle(cream,fruit,price,sugar,topping,type) values('Nie','Nie',5.5,'Tak','Tak','Z polewą i cukrem pudrem');
insert into Waffle(cream,fruit,price,sugar,topping,type) values('Nie','Tak',6,'Nie','Nie','Z owocami');
insert into Waffle(cream,fruit,price,sugar,topping,type) values('Tak','Nie',6,'Nie','Nie','Ze śmietaną');
insert into Waffle(cream,fruit,price,sugar,topping,type) values('Nie','Tak',6.5,'Tak','Nie','Z owocami i cukrem pudrem');
insert into Waffle(cream,fruit,price,sugar,topping,type) values('Tak','Nie',6.5,'Tak','Nie','Ze śmietaną i cukrem pudrem');
insert into Waffle(cream,fruit,price,sugar,topping,type) values('Tak','Nie',7.5,'Nie','Tak','Ze śmietaną i polewą');
insert into Waffle(cream,fruit,price,sugar,topping,type) values('Tak','Tak',8.5,'Nie','Nie','Ze śmietaną i owocami');
insert into Waffle(cream,fruit,price,sugar,topping,type) values('Tak','Tak',9,'Tak','Nie','Ze śmietaną, owocami i cukrem pudrem');
insert into Waffle(cream,fruit,price,sugar,topping,type) values('Tak','Tak',10,'Nie','Tak','Ze śmietaną, owocami i polewą');

INSERT INTO SHOP ("CITY", "COUNTRY", "HOUSENUMBER", "NAME", "STREET" ) VALUES ('Gdansk', 'Polska', '121', 'Gofry u Zenka', 'długa');
INSERT INTO SHOP ("CITY", "COUNTRY", "HOUSENUMBER", "NAME", "STREET" ) VALUES ('Berlin', 'Niemcy', '13', 'Gofry najlepsze', 'krótka');
INSERT INTO SHOP ("CITY", "COUNTRY", "HOUSENUMBER", "NAME", "STREET" ) VALUES ('Barcelona', 'Hiszpania', '29', 'Gofry z Messi', 'podłóżna');
INSERT INTO SHOP ("CITY", "COUNTRY", "HOUSENUMBER", "NAME", "STREET" ) VALUES ('Paryż', 'Francja', '55', 'Gofry pod Wieżą', 'płaska');

INSERT INTO ORDERS("PRICE", "SOLD", "SHOP_ID" ) VALUES (12.5, true, 1);
INSERT INTO ORDERS("PRICE", "SOLD", "SHOP_ID" ) VALUES (23.5, false, 2);
INSERT INTO ORDERS("PRICE", "SOLD", "SHOP_ID" ) VALUES (22.5, true, 3);
INSERT INTO ORDERS("PRICE", "SOLD", "SHOP_ID" ) VALUES (9, false, 4);
INSERT INTO ORDERS("PRICE", "SOLD", "SHOP_ID" ) VALUES (10, true, 1);
INSERT INTO ORDERS("PRICE", "SOLD", "SHOP_ID" ) VALUES (3.5, false, 2);
INSERT INTO ORDERS("PRICE", "SOLD", "SHOP_ID" ) VALUES (4, true, 2);
INSERT INTO ORDERS("PRICE", "SOLD", "SHOP_ID" ) VALUES (0, false, 4);
INSERT INTO ORDERS("PRICE", "SOLD", "SHOP_ID" ) VALUES (10.5, true, 1);

INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 1, 1);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 1, 2);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 1, 3);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 2, 4);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 2, 5);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 2, 6);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 2, 7);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 3, 8);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 3, 9);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 3, 10);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 4, 11);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 5, 12);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 6, 1);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 7, 2);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 9, 3);
INSERT INTO ORDERS_WAFFLE ( "ORDERS_ID", "WAFFLES_ID" ) VALUES ( 9, 4);
