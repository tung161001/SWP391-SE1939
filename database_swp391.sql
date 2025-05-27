-- Create database
 CREATE DATABASE IF NOT EXISTS SWP391;

-- Use database
USE SWP391;

-- Create user table
CREATE TABLE IF NOT EXISTS user (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(300) UNIQUE NOT NULL,
  full_name VARCHAR(1000),
  password VARCHAR(100) NOT NULL,
  email VARCHAR(300) UNIQUE NOT NULL,
  role_id INT NOT NULL,
  status INT NOT NULL DEFAULT 1,
  address VARCHAR(1000)
);

-- create role table
CREATE TABLE IF NOT EXISTS role (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(300) UNIQUE NOT NULL
);



-- init data

-- role
INSERT INTO role(name) VALUES
("Administrator"),
("customer"),
("saler"),
("manager");

-- user
INSERT INTO user (username, full_name, password, email, role_id, status, address) VALUES
('jdoe', 'John Doe', '$2b$10$Qe0mZsGlxOb.EYSh7g35uO0eOV7wyUEEtHz1T5.YVtQ3uZUGK', 'john.doe@example.com', 1, 1, '123 Elm St, Springfield, IL'),
('asmith', 'Alice Smith', '$2b$10$KIXM4frwNBFV1efIZS3ZaemD3Qps6D9Xnvuv1hVcgyS3iWIs0aqS', 'alice.smith@example.com', 2, 1, '456 Oak Ave, Portland, OR'),
('bnguyen', 'Bao Nguyen', '$2b$10$V1h/xjtnnv7FPpVZmd7w4OSRpbfJ09bWn8D/t8Ckt61FZqJeDJOy', 'bao.nguyen@example.com', 3, 0, '78 Tran Hung Dao, Ha Noi, Vietnam'),
('kmiller', 'Kevin Miller', '$2b$10$f5yxUp/2DRAeTrABeMHKk.gHpTRvdA1DpA7X.AQlUkTz7By9m6VXu', 'kevin.miller@example.com', 3, 1, '890 Maple Rd, Denver, CO'),
('ltan', 'Lan Tan', '$2b$10$1NqZ1luhdo8DZB1FXbQ8HO06QZn2zWztmUXS9/bB9N9r/NZcRgU3S', 'lan.tan@example.com', 4, 1, '12 Le Loi, Ho Chi Minh City, Vietnam'),
('tmorgan', 'Tina Morgan', '$2b$10$tX.1aNiA9XeZPbsKTeV.CeR2KDuyv7ln2G6UJqEwVvGzKRoafbhba', 'tina.morgan@example.com', 1, 1, '101 Pine St, Boston, MA'),
('dlee', 'Daniel Lee', '$2b$10$TK8u7lzYBz77NHTdCKAId.eHp6ydqIE5qxqUasQ8XPBdO1XK3GcHa', 'daniel.lee@example.com', 3, 1, '222 Sunset Blvd, Los Angeles, CA'),
('mharris', 'Maria Harris', '$2b$10$gC2msJ91YYTxKuV/j.2CxeuNB6NdYm4gXnSdwBfZCjHov.R2Zu.l2', 'maria.harris@example.com', 3, 0, '310 Main St, Seattle, WA'),
('cpham', 'Chi Pham', '$2b$10$rAE6BRClzPLONFw9S3G0j.njUMX9O94Jxz6s0zEwz.1OBmAwvGAKa', 'chi.pham@example.com', 2, 1, '19 Nguyen Trai, Da Nang, Vietnam'),
('rjohnson', 'Robert Johnson', '$2b$10$AVTtzE.5Brw3n3u2XoEfyulnWcC/NpDyyNdrsP9Ql94WW3Pv9gJQy', 'robert.johnson@example.com', 4, 1, '43 Birch Ln, Austin, TX'),
('lgreen', 'Laura Green', '$2b$10$0umJHZKxM9Bh2fHt1gNKnuc4zW4kT0RWjXbkJ7N7oVu2kzvGz26ga', 'laura.green@example.com', 3, 1, '92 Ocean Dr, Miami, FL'),
('wtran', 'William Tran', '$2b$10$eUIhwbZzBhFZ.z2rRQDhhu5zDH9D5XjGcbCG8ftVnDvsZfCJgu/5u', 'william.tran@example.com', 2, 0, '55 Pasteur, Hue, Vietnam'),
('nhoang', 'Nhi Hoang', '$2b$10$kAxtzSn2S/yDNa5LPX03DO/yExRpmpx05AHHYqaMEgOAbZ8cYIn62', 'nhi.hoang@example.com', 3, 1, '88 Xuan Dieu, Hoi An, Vietnam'),
('sgarcia', 'Sofia Garcia', '$2b$10$odQTxJ2G9z64D3aLGkkxJue4W50mGkLjqEfXx9YclRReAfJwTeiGq', 'sofia.garcia@example.com', 3, 0, '120 Lakeview Rd, Chicago, IL'),
('dnguyen', 'Duc Nguyen', '$2b$10$HqLXBxZ.S1V6mNHMi1aTfe2cOr4DpCzjvERePiVY4P3snXgX5McMi', 'duc.nguyen@example.com', 3, 1, '59 Hai Ba Trung, Ha Noi, Vietnam'),
('ecampbell', 'Emily Campbell', '$2b$10$oyFnH7g4c4Z59ZKJx3VjFeYdQHTN3XLEuRmATvU8A2uM0qBrnxSme', 'emily.campbell@example.com', 1, 1, '44 Riverbend, Nashville, TN'),
('hpham', 'Hanh Pham', '$2b$10$7UQgDhjU22r7fjrblKrW6OlOSOPxzOGXE93fs.HsICcgOh1FPOJu2', 'hanh.pham@example.com', 3, 1, '34 Le Van Luong, Ho Chi Minh City, Vietnam'),
('cnguyen', 'Cuong Nguyen', '$2b$10$Y9eFdfWhjYvlPHV7R49Q3OdP4R/NRY.jh3Vh8cX25c0txfIpx8c92', 'cuong.nguyen@example.com', 4, 1, '21 Nguyen Van Cu, Can Tho, Vietnam'),
('jwhite', 'James White', '$2b$10$RvHiLIGyVqt1Xf4A9ZLKv.5EVxZY7DBw0PCY8hnkMLbwKZ/Ff8A3e', 'james.white@example.com', 2, 0, '91 Broadway, New York, NY'),
('ttaylor', 'Tommy Taylor', '$2b$10$uF7yp15vZyqWWm2xOBk1F.1UcfFJoEIbTZ5eh1FIC7om5wpxDCe1i', 'tommy.taylor@example.com', 3, 1, '16 Hilltop Rd, Phoenix, AZ');
