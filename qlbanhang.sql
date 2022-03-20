-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 20, 2022 lúc 03:11 PM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlbanhang`
--

DELIMITER $$
--
-- Thủ tục
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `hetsanpham` ()  BEGIN
SELECT * FROM sanpham WHERE soluong < 2;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spLaySP` ()  BEGIN
   SELECT *  FROM sanpham;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spThem` (IN `msp1` INT, IN `tensp1` CHAR(50), IN `gia1` INT, IN `sl1` INT)  BEGIN 
INSERT INTO sanpham(msp,tensp,gia,soluong) values(msp1,tensp1,gia1,sl1);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spTim` (IN `msp1` INT)  BEGIN
SELECT * from sanpham WHERE msp = msp1;
  
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `suaGia` (IN `gia1` INT, IN `msp1` INT)  BEGIN
	if EXISTS (SELECT msp from sanpham WHERE msp = msp1)
    then UPDATE sanpham set gia = gia1 WHERE msp = msp1;
    end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `suaSL` (IN `sl1` INT, IN `msp1` INT)  BEGIN
	if EXISTS (SELECT msp from sanpham WHERE msp = msp1)
    then UPDATE sanpham set soluong = sl1 WHERE msp = msp1;
    end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `suaTen` (IN `ten` CHAR(50), IN `msp1` INT)  BEGIN
   UPDATE sanpham set tensp = ten WHERE msp = msp1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ThemThanhToan` (IN `allSP` CHARACTER(255), IN `tongtien` INT)  BEGIN
INSERT into banhang(sanpham,tongtien) VALUES(allSP,tongtien);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tinhtong1` (IN `day` DATE)  BEGIN
SELECT SUM(tongtien) FROM banhang WHERE NgayTT = day;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tinhtong2` (IN `day1` DATE, IN `day2` DATE)  BEGIN
SELECT sum(tongtien) FROM banhang WHERE NgayTT BETWEEN day1 AND day2;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `xoa` (IN `msp1` INT)  BEGIN if exists (select msp from sanpham)  then delete from sanpham where msp = msp1;end if;END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `banhang`
--

CREATE TABLE `banhang` (
  `ID` int(11) NOT NULL,
  `sanpham` varchar(255) DEFAULT NULL,
  `tongtien` int(11) DEFAULT NULL,
  `NgayTT` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `banhang`
--

INSERT INTO `banhang` (`ID`, `sanpham`, `tongtien`, `NgayTT`) VALUES
(1, ' (2221)(3332)', 46000, '2022-03-18'),
(2, ' (222 1)', 26000, '2022-03-17'),
(3, ' (333 2) (555 3)', 22997, '2022-03-20');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `msp` int(10) NOT NULL,
  `tensp` varchar(50) NOT NULL,
  `gia` int(11) NOT NULL,
  `soluong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`msp`, `tensp`, `gia`, `soluong`) VALUES
(222, ' binh nuoc', 23000, 1),
(333, 'ruou', 10000, 3),
(555, 'banh', 999, 97),
(777, 'keo', 10000, 10);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `banhang`
--
ALTER TABLE `banhang`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`msp`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `banhang`
--
ALTER TABLE `banhang`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
