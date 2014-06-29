-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.24-log
-- Versão do PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `sitecarnaval`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `ala`
--

CREATE TABLE IF NOT EXISTS `ala` (
  `idAla` int(11) NOT NULL,
  `nomeAla` varchar(50) NOT NULL,
  `numeroIntegrantes` int(11) NOT NULL,
  PRIMARY KEY (`idAla`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `ala`
--

INSERT INTO `ala` (`idAla`, `nomeAla`, `numeroIntegrantes`) VALUES
(1152, 'grem', 250),
(1202, 'igor o valente das terras lingincuas', 150),
(1203, 'janete no paraiso dos doces', 200);

-- --------------------------------------------------------

--
-- Estrutura da tabela `alafantasia`
--

CREATE TABLE IF NOT EXISTS `alafantasia` (
  `idAla` int(11) NOT NULL,
  `idFantasia` int(11) NOT NULL,
  KEY `idAla` (`idAla`),
  KEY `idFantasia` (`idFantasia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fantasia`
--

CREATE TABLE IF NOT EXISTS `fantasia` (
  `idFantasia` int(11) NOT NULL,
  `nomeFantasia` varchar(50) NOT NULL,
  `pesoFantasia` int(11) DEFAULT NULL,
  `descricao` text,
  `urlImagem` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idFantasia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fantasia`
--

INSERT INTO `fantasia` (`idFantasia`, `nomeFantasia`, `pesoFantasia`, `descricao`, `urlImagem`) VALUES
(851, 'kkkkkkkkkkkkkkkkkkkkkkkkkkkk', 342, ' ttttgggggggggggwwwwwwwwwwww aaaaaaaaa aa nnnnnnnnnnnn', 'url/paginas/jsp'),
(901, 'ggggggggggggg', 321, '  fffffffffffffffff hh ttt yyyyyyyyyyyyyyyyyyy', 'url/paginas/jsp'),
(951, 'wwwwwwwwwwwwwwwwww', 323, 'ssssss gggggggeeeeeeeeeeeeeee ee ttttttttttttt wwww', 'url/paginas/jsp'),
(952, 'uuuuuuuuuuuuuuuu', 342, ' aaaaaaaaa', 'url/paginas/jsp'),
(953, 'regggggggggg ttttt yyyyyyyyyy', 341, ' ssssssssssssssssss  df gfgfgg     vvvvvvvvvvvvvvvvvvvvvv', 'url/paginas/jsp'),
(1001, 'regggggggggg ttttt yyyyyyyyyy', 341, ' ssssssssssssssssss  df gfgfgg     vvvvvvvvvvvvvvvvvvvvvv', 'url/paginas/jsp'),
(1002, 'dddddd', 432, ' qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq  fffffffff vf ffffffffffffffffffffffff       fffff ', 'url/paginas/jsp'),
(1051, 'moster filores', 240, ' fdloposter dvendendos dicas de trampos', 'url/paginas/jsp'),
(1101, 'dddddsssssss', 234, '    hhhhhhhhhhhhhhhhhhhhh uuuuuuuuuuuuuuu oooooooooooo', 'url/paginas/jsp');

-- --------------------------------------------------------

--
-- Estrutura da tabela `foliao`
--

CREATE TABLE IF NOT EXISTS `foliao` (
  `idFoliao` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `idade` int(3) NOT NULL,
  `cpf` int(11) NOT NULL,
  `rg` int(15) NOT NULL,
  PRIMARY KEY (`idFoliao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `foliao`
--

INSERT INTO `foliao` (`idFoliao`, `nome`, `idade`, `cpf`, `rg`) VALUES
(1, 'ranam castrol', 52, 52148755, 55522266),
(51, 'Marcos antunes veigas', 25, 235689141, 856741255),
(301, 'vitor ciqueira mendesl', 33, 5333587, 65657678),
(351, 'brunoro montevintel', 28, 5333587, 65657678),
(401, 'julio', 23, 231654879, 562389563),
(451, 'Renata Costa', 24, 11, 11),
(501, 'WILSOM MARIS', 46, 6589362, 452178),
(551, 'higor novas', 35, 88888888, 33333333),
(601, 'higor novas', 35, 88888888, 33333333),
(651, 'belmes Convem', 32, 658974123, 563241789),
(701, 'daniel coldinezi', 25, 658932147, 563214789),
(751, 'Simone Carvalho dantas', 31, 365244178, 563241789),
(801, 'Simone Carvalho dantas', 31, 365244178, 563241789);

-- --------------------------------------------------------

--
-- Estrutura da tabela `reserva`
--

CREATE TABLE IF NOT EXISTS `reserva` (
  `numeroReserva` int(11) NOT NULL,
  `dataDaReserva` date NOT NULL,
  `hora` time NOT NULL,
  `idFoliao` int(11) NOT NULL,
  `idAla` int(11) NOT NULL,
  PRIMARY KEY (`numeroReserva`),
  KEY `idFoliao` (`idFoliao`),
  KEY `idAla` (`idAla`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sequence`
--

CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '1250');

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `alafantasia`
--
ALTER TABLE `alafantasia`
  ADD CONSTRAINT `alafantasia_ibfk_1` FOREIGN KEY (`idAla`) REFERENCES `ala` (`idAla`),
  ADD CONSTRAINT `alafantasia_ibfk_2` FOREIGN KEY (`idFantasia`) REFERENCES `fantasia` (`idFantasia`);

--
-- Restrições para a tabela `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`idFoliao`) REFERENCES `foliao` (`idFoliao`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`idAla`) REFERENCES `ala` (`idAla`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
