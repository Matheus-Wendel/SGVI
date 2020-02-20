


INSERT INTO `sgvi_bd`.`customizacao`
(`id`,
`descricao`)
VALUES
(1,
'fotoDoMaicon');


INSERT INTO `sgvi_bd`.`customizacao`
(`id`,
`descricao`)
VALUES
(2,
'fotoDoLinkingInpark');



INSERT INTO `sgvi_bd`.`endereco`
(`id`,
`bairro`,
`cep`,
`numero`,
`rua`,
`cidade_id`)
VALUES
(1,
'hellbor',
07400000,
100,
'Rua sinm',
5051);

INSERT INTO `sgvi_bd`.`endereco`
(`id`,
`bairro`,
`cep`,
`numero`,
`rua`,
`cidade_id`)
VALUES
(2,
'casa',
08695201,
652,
'avenida paulos ta',
5051);



INSERT INTO `sgvi_bd`.`evento`
(`id`,
`hora_inicio`,
`hora_termino`,
`nome`,
`customizacao_id`,
`endereco_id`)
VALUES
(1,
'2019-11-13 22:00:00',
'2019-11-14 22:00:00',
'show do infernitus',
1,
1);

INSERT INTO `sgvi_bd`.`evento`
(`id`,
`hora_inicio`,
`hora_termino`,
`nome`,
`customizacao_id`,
`endereco_id`)
VALUES
(2,
'2020-01-01 10:00:00',
'2019-11-14 23:00:00',
'show linkin in part',
2,
2);



INSERT INTO `sgvi_bd`.`artista`
(`id`,
`descricao`,
`genero`,
`nome`)
VALUES
(1,
'integrante banda são marques',
'rock',
'mk jackson');

INSERT INTO `sgvi_bd`.`artista`
(`id`,
`descricao`,
`genero`,
`nome`)
VALUES
(2,
'todaos mortos',
'samba',
'linking prk AMV');


INSERT INTO `sgvi_bd`.`evento_artista`
(`evento_id`,
`artista_id`)
VALUES
(1,
1);

INSERT INTO `sgvi_bd`.`evento_artista`
(`evento_id`,
`artista_id`)
VALUES
(1,
2);

INSERT INTO `sgvi_bd`.`evento_artista`
(`evento_id`,
`artista_id`)
VALUES
(2,
1);

INSERT INTO `sgvi_bd`.`setor`
(`id`,
`descricao`,
`ingresos_disponiveis`,
`valor`)
VALUES
(1,
'para as Mais +',
200,
'300');

INSERT INTO `sgvi_bd`.`setor`
(`id`,
`descricao`,
`ingresos_disponiveis`,
`valor`)
VALUES
(2,
'pista pobre',
200,
'50');

INSERT INTO `sgvi_bd`.`setor`
(`id`,
`descricao`,
`ingresos_disponiveis`,
`valor`)
VALUES
(3,
'rei do camarote',
10,
'1000');

INSERT INTO `sgvi_bd`.`setor`
(`id`,
`descricao`,
`ingresos_disponiveis`,
`valor`)
VALUES
(4,
'pista',
1000,
'10');

INSERT INTO `sgvi_bd`.`evento_setor`
(`evento_id`,
`setor_id`)
VALUES
(1,
1);



INSERT INTO `sgvi_bd`.`evento_setor`
(`evento_id`,
`setor_id`)
VALUES
(1,
2);

INSERT INTO `sgvi_bd`.`evento_setor`
(`evento_id`,
`setor_id`)
VALUES
(1,
3);



INSERT INTO `sgvi_bd`.`evento_setor`
(`evento_id`,
`setor_id`)
VALUES
(2,
4);



INSERT INTO `artista` (`id`, `descricao`, `genero`, `nome`) VALUES 
(6, 'cantor indie', 'indie', 'The Lumineers'),
(7, 'cantor indie', 'indie', 'Tame Impala'),
(8, 'cantor indie', 'indie', 'Cigaretes After Sex'),
(9, 'cantor indie', 'indie', 'Cage The Elephant'),
(10, 'cantor indie', 'indie', 'Foster the People');



