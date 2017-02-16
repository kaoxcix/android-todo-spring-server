-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 16, 2017 at 10:49 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `todo`
--

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id`, `name`, `created_date`, `updated_date`) VALUES
(1, 'Emitter', '2017-02-16 16:38:47', '2017-02-16 16:38:57'),
(2, 'HR Service', '2017-02-16 16:39:19', '2017-02-16 16:39:37'),
(3, 'Cash API', '2017-02-16 16:39:58', '2017-02-16 16:39:58'),
(4, 'Todo Android', '2017-02-16 16:40:10', '2017-02-16 16:40:10'),
(5, 'Todo Spring', '2017-02-16 16:40:19', '2017-02-16 16:40:19'),
(6, 'HR Rest API', '2017-02-16 16:40:36', '2017-02-16 16:40:36'),
(7, 'Todo IOS', '2017-02-16 16:41:05', '2017-02-16 16:41:05'),
(8, 'Emitter by Ruby', '2017-02-16 16:41:21', '2017-02-16 16:41:21'),
(9, 'Emitter by CakePHP', '2017-02-16 16:41:33', '2017-02-16 16:41:33');

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `project_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`id`, `name`, `project_id`, `status`, `created_date`, `updated_date`) VALUES
(1, 'Wait for customer Info', 1, 1, '2017-02-16 16:41:54', '2017-02-16 16:41:54'),
(2, 'Send Email to customer', 1, 1, '2017-02-16 16:42:06', '2017-02-16 16:42:06'),
(3, 'Create a Mockup', 1, 1, '2017-02-16 16:42:41', '2017-02-16 16:42:41'),
(4, 'Send a Mockup', 1, 0, '2017-02-16 16:43:03', '2017-02-16 16:43:03'),
(5, 'Get customer feedback', 1, 0, '2017-02-16 16:43:13', '2017-02-16 16:43:13'),
(6, 'Develop', 1, 0, '2017-02-16 16:43:28', '2017-02-16 16:43:28'),
(7, 'Testing', 1, 0, '2017-02-16 16:43:33', '2017-02-16 16:43:33'),
(8, 'Make testcases', 1, 0, '2017-02-16 16:43:48', '2017-02-16 16:43:48'),
(9, 'Make evidences', 1, 0, '2017-02-16 16:44:01', '2017-02-16 16:44:01'),
(10, 'Send to sales department', 1, 0, '2017-02-16 16:45:07', '2017-02-16 16:45:07'),
(11, 'Sales department confirmed', 1, 0, '2017-02-16 16:45:32', '2017-02-16 16:45:32'),
(12, 'Boss confirmed', 2, 0, '2017-02-16 16:46:33', '2017-02-16 16:46:33'),
(13, 'Design API', 3, 0, '2017-02-16 16:46:45', '2017-02-16 16:46:45'),
(14, 'Make a Mockup', 3, 0, '2017-02-16 16:47:04', '2017-02-16 16:47:04'),
(15, 'Buy Mac Pro', 7, 0, '2017-02-16 16:47:28', '2017-02-16 16:47:28'),
(16, 'Register Apple Develop', 7, 1, '2017-02-16 16:48:10', '2017-02-16 16:48:10'),
(17, 'Prepare AWS', 5, 0, '2017-02-16 16:49:11', '2017-02-16 16:49:11');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`),
  ADD KEY `project_id_idx` (`project_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `task_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
