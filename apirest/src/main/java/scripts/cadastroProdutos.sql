INSERT INTO produto (id, medida, nome, preco, quantidade_disponivel, image) values (1, '200 ml', 'Choco leite', 4.00, 90, 'http://www.weberatacadista.com.br/wp-content/uploads/2017/01/CHOCO-LEITE-460ML-TRADICIONAL.jpg');
INSERT INTO produto (id, medida, nome, preco, quantidade_disponivel, image) values (2, '1 L', 'Coca-Cola', 8.00, 300, 'https://domuscatore.com/wp-content/uploads/2016/03/coca-cola-15litro-1.jpg');
INSERT INTO produto (id, medida, nome, preco, quantidade_disponivel, image) values (3, '300 g', 'Hamburguer', 3.00, 180, 'https://laricaria.com/wp-content/uploads/2018/02/hamburguer-maconha-cannaburguer-1300x949.jpg');
INSERT INTO produto (id, medida, nome, preco, quantidade_disponivel, image) values (4, '500 g', 'Pizza', 20.00, 47, 'https://pizzamarcante.com.br/home/wp-content/uploads/2018/09/slider-pizza.png');
INSERT INTO produto (id, medida, nome, preco, quantidade_disponivel, image) values (5, '200 g', 'Pudim', 6.00, 90, 'https://i.pinimg.com/originals/c6/8d/70/c68d7036964bf6ae4bd426272376b714.jpg');
INSERT INTO produto (id, medida, nome, preco, quantidade_disponivel, image) values (6, '500 ml', 'Cachaça', 13.00, 50090, 'https://www.clubeextra.com.br/img/uploads/1/480/547480.jpg?type=product');
INSERT INTO produto (id, medida, nome, preco, quantidade_disponivel, image) values (7, '500 ml', 'IPA da boa', 12.00, 10, 'http://tendaatacado.vteximg.com.br/arquivos/ids/225230/981108.jpg?v=637027069020800000');

delete from produto where id=1
delete from produto where id=2
delete from produto where id=3
delete from produto where id=4
delete from produto where id=5
delete from produto where id=6
delete from produto where id=7

select * from produto
select * from usuario
drop table usuario