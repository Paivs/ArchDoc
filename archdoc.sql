-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 17-Nov-2022 às 22:59
-- Versão do servidor: 5.7.36
-- versão do PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `archdoc`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `arquivos`
--

DROP TABLE IF EXISTS `arquivos`;
CREATE TABLE IF NOT EXISTS `arquivos` (
  `cod_arquivos` int(11) NOT NULL AUTO_INCREMENT,
  `arquivo` varchar(255) DEFAULT NULL,
  `revisao` varchar(50) DEFAULT NULL,
  `workpath` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`cod_arquivos`)
) ENGINE=MyISAM AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `arquivos`
--

INSERT INTO `arquivos` (`cod_arquivos`, `arquivo`, `revisao`, `workpath`) VALUES
(65, 'arquivo3', '1', 'D:documentsGitHubArchDocDocManagerworkPath'),
(64, 'arquivo2', '1', 'D:documentsGitHubArchDocDocManagerworkPath'),
(63, 'arquivo1', '2', 'D:documentsGitHubArchDocDocManagerworkPath'),
(62, 'arquivo1', '1', 'D:documentsGitHubArchDocDocManagerworkPath'),
(61, 'arquivo3', '1', 'D:documentsGitHubArchDocDocManagerworkPath'),
(60, 'arquivo2', '1', 'D:documentsGitHubArchDocDocManagerworkPath'),
(59, 'arquivo1', '2', 'D:documentsGitHubArchDocDocManagerworkPath'),
(58, 'arquivo1', '1', 'D:documentsGitHubArchDocDocManagerworkPath');

-- --------------------------------------------------------

--
-- Estrutura da tabela `grupo`
--

DROP TABLE IF EXISTS `grupo`;
CREATE TABLE IF NOT EXISTS `grupo` (
  `cod_grupo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cod_empresa` int(11) DEFAULT NULL,
  `descricao` text,
  `cod_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_grupo`),
  KEY `fk_cod_usuario` (`cod_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `grupo`
--

INSERT INTO `grupo` (`cod_grupo`, `nome`, `cod_empresa`, `descricao`, `cod_usuario`) VALUES
(1, 'archDoc', 1, 'Nome Empresa: archDoc\n	CNPJ: 92.101.517/0001-95\n	Responsável pela comunicação: Arthur N. Caproni\n	Contato:\n		email: arthuzinho@gamei.com.br\n		telefone: (+55) 11 980697346', 1),
(2, 'archDoc', 1, 'Nome Empresa: archDoc\n	CNPJ: 92.101.517/0001-95\n	Responsável pela comunicação: Arthur N. Caproni\n	Contato:\n		email: arthuzinho@gamei.com.br\n		telefone: (+55) 11 980697346', 2),
(3, 'archDoc', 1, 'Nome Empresa: archDoc\n	CNPJ: 92.101.517/0001-95\n	Responsável pela comunicação: Arthur N. Caproni\n	Contato:\n		email: arthuzinho@gamei.com.br\n		telefone: (+55) 11 980697346', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `historizador`
--

DROP TABLE IF EXISTS `historizador`;
CREATE TABLE IF NOT EXISTS `historizador` (
  `cod_historizador` int(11) NOT NULL AUTO_INCREMENT,
  `revisao` varchar(126) DEFAULT NULL,
  `arquivo` varchar(1024) DEFAULT NULL,
  `acao` int(11) DEFAULT NULL,
  `data_historizador` date DEFAULT NULL,
  PRIMARY KEY (`cod_historizador`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `trabalho`
--

DROP TABLE IF EXISTS `trabalho`;
CREATE TABLE IF NOT EXISTS `trabalho` (
  `cod_trabalho` int(11) NOT NULL AUTO_INCREMENT,
  `cod_arquivos` int(11) DEFAULT NULL,
  `cod_grupo` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_trabalho`),
  KEY `fk_cod_grupo` (`cod_grupo`),
  KEY `fk_cod_arquivos` (`cod_arquivos`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `cod_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `senha` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `cod_grupo` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_usuario`),
  KEY `fk_cod_grupo` (`cod_grupo`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`cod_usuario`, `senha`, `nome`, `cod_grupo`) VALUES
(1, '123', 'Gustavo', 1),
(2, '123', 'Lucas', 1),
(3, '123', 'Arthur', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
