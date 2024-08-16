CREATE DATABASE baitapbuoi20;
USE baitapbuoi20;

CREATE TABLE Customers (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerName VARCHAR(100) NOT NULL,
    ContactName VARCHAR(100),
    Country VARCHAR(50)
);

-- Tạo bảng Suppliers
CREATE TABLE Suppliers (
    SupplierID INT AUTO_INCREMENT PRIMARY KEY,
    SupplierName VARCHAR(100),
    ContactName VARCHAR(100),
    Country VARCHAR(50)
);

-- Tạo bảng Categories
CREATE TABLE Categories (
    CategoryID INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(100)
);

-- Tạo bảng Products với các khóa ngoại
CREATE TABLE Products (
    ProductID INT AUTO_INCREMENT PRIMARY KEY,
    ProductName VARCHAR(100) NOT NULL,
    SupplierID INT,
    CategoryID INT,
    Unit VARCHAR(50),
    Price DECIMAL(10, 2),
    FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID),
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

-- Tạo bảng Orders với khóa ngoại
CREATE TABLE Orders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT,
    OrderDate DATE,
    ShipperID INT,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Tạo bảng OrderDetails với các khóa ngoại
CREATE TABLE OrderDetails (
    OrderDetailID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT,
    ProductID INT,
    Quantity INT,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

INSERT INTO Customers (CustomerName, ContactName, Country)
VALUES
('Around the Horn', 'Thomas Hardy', 'UK'),
('Berglunds snabbköp', 'Christina Berglund', 'Sweden'),
('Blauer See Delikatessen', 'Hanna Moos', 'Germany'),
('Blondel père et fils', 'Frédérique Citeaux', 'France'),
('Bólido Comidas preparadas', 'Martín Sommer', 'Spain'),
('Bon app''', 'Laurence Lebihan', 'France'),
('Bottom-Dollar Markets', 'Elizabeth Lincoln', 'Canada'),
('Cactus Comidas para llevar', 'Patricio Simpson', 'Argentina'),
('Centro comercial Moctezuma', 'Francisco Chang', 'Mexico'),
('Chop-suey Chinese', 'Yang Wang', 'Switzerland');

INSERT INTO Suppliers (SupplierName, ContactName, Country)
VALUES
('Grandma Kelly''s Homestead', 'Regina Murphy', 'USA'),
('Tokyo Traders', 'Yoshi Nagase', 'Japan'),
('Cooperativa de Quesos ''Las Cabras''', 'Antonio del Valle Saavedra', 'Spain'),
('Mayumi''s', 'Mayumi Ohno', 'Japan'),
('Pavlova, Ltd.', 'Ian Devling', 'Australia'),
('Specialty Biscuits, Ltd.', 'Peter Wilson', 'UK'),
('PB Knäckebröd AB', 'Lars Peterson', 'Sweden'),
('Refrescos Americanas LTDA', 'Carlos Diaz', 'Brazil'),
('Heli Süßwaren GmbH & Co. KG', 'Petra Winkler', 'Germany'),
('Plutzer Lebensmittelgroßmärkte AG', 'Martin Bein', 'Germany');


INSERT INTO Products (ProductName, SupplierID, CategoryID, Unit, Price)
VALUES
('Chef Anton''s Cajun Seasoning', 2, 2, '48 - 6 oz jars', 22.00),
('Chef Anton''s Gumbo Mix', 2, 2, '36 boxes', 21.35),
('Grandma''s Boysenberry Spread', 3, 2, '12 - 8 oz jars', 25.00),
('Uncle Bob''s Organic Dried Pears', 3, 7, '12 - 1 lb pkgs.', 30.00),
('Northwoods Cranberry Sauce', 3, 2, '12 - 12 oz jars', 40.00),
('Mishi Kobe Niku', 4, 6, '18 - 500 g pkgs.', 97.00),
('Ikura', 4, 8, '12 - 200 ml jars', 31.00),
('Queso Cabrales', 5, 4, '1 kg pkg.', 21.00),
('Queso Manchego La Pastora', 5, 4, '10 - 500 g pkgs.', 38.00),
('Konbu', 6, 8, '2 kg box', 6.00);

INSERT INTO Categories (CategoryName)
VALUES
('Grains/Cereals'),
('Condiments'),
('Confections'),
('Dairy Products'),
('Seafood'),
('Beverages'),
('Produce'),
('Meat/Poultry');

INSERT INTO Orders (CustomerID, OrderDate, ShipperID)
VALUES
(4, '2024-05-20', 3),
(5, '2024-05-21', 2),
(6, '2024-05-22', 1),
(7, '2024-05-23', 2),
(8, '2024-05-24', 3),
(9, '2024-05-25', 1),
(10, '2024-05-26', 2),
(1, '2024-05-27', 3),
(2, '2024-05-28', 1),
(3, '2024-05-29', 2);

INSERT INTO OrderDetails (OrderID, ProductID, Quantity)
VALUES
(1, 1, 10),
(1, 2, 5),
(2, 3, 20),
(3, 4, 15),
(4, 5, 12),
(5, 6, 8),
(6, 7, 30),
(7, 8, 25),
(8, 9, 18),
(9, 10, 7);

-- 1) Liệt kê tên sản phẩm và tên nhà cung cấp cho tất cả các sản phẩm có giá lớn hơn 15.00
SELECT p.ProductName , s.SupplierName 
FROM Products p 
JOIN Suppliers s ON p.SupplierID = s.SupplierID;

-- 2)	Tìm tất cả các đơn hàng được thực hiện bởi khách hàng ở "Mexico"
SELECT o.OrderID , c.CustomerName , c.Country 
FROM Orders o 
JOIN Customers c ON o.CustomerID = c.CustomerID 
HAVING c.Country ='Mexico';

-- 3)	Tìm số lượng đơn hàng được thực hiện trong mỗi quốc gia
SELECT c.Country , COUNT(o.OrderID)
FROM Customers c 
LEFT JOIN Orders o ON c.CustomerID = o.CustomerID 
GROUP BY c.Country ;

-- 4)	Liệt kê tất cả các nhà cung cấp và số lượng sản phẩm mà họ cung cấp
SELECT s.SupplierName , COUNT(ProductID)
FROM Suppliers s 
LEFT JOIN Products p ON p.SupplierID = s.SupplierID 
GROUP BY s.SupplierName ;

-- 5)	Liệt kê tên sản phẩm và giá của các sản phẩm đắt hơn sản phẩm "Chang"
SELECT *
FROM Products p 
WHERE p.ProductName LIKE "%Chang%";

-- 6)	Tìm tổng số lượng sản phẩm bán ra trong tháng 5 năm 2024
SELECT SUM(od.Quantity) AS quantity
FROM Orders o 
JOIN OrderDetails od ON o.OrderID = od.OrderID 
WHERE MONTH (o.OrderDate) = 5 AND YEAR(o.OrderDate) = 2024

-- 7)	Tìm tên của các khách hàng chưa từng đặt hàng
SELECT c.CustomerName , COUNT(o.OrderID) AS so_order
FROM Customers c 
LEFT JOIN Orders o ON o.CustomerID = c.CustomerID 
GROUP BY c.CustomerID 
HAVING so_order = 0;

-- 8)	Liệt kê các đơn hàng với tổng số tiền lớn hơn 200.00
SELECT od.OrderID , SUM(od.Quantity * p.Price) AS total
FROM OrderDetails od
JOIN Products p ON p.ProductID = od.ProductID
GROUP BY od.OrderID
HAVING total > 200.00;

-- 9)	Tìm tên sản phẩm và số lượng trung bình được đặt hàng cho mỗi đơn hàng
-- Giải nghĩa: cứ mỗi đơn hàng phát sinh thì có trung bình bao nhiêu sp đó được đặt?
-- Kết quả = Tổng số lượng sp đó đã đc bán ra / tổng số đơn hàng

-- Tính tổng số lượng đơn
SELECT COUNT(*)
FROM Orders o ;
-- Tính kết quả
SELECT p.ProductName , od.Quantity / (SELECT COUNT(*)
							FROM Orders o) so_luong_tb_duoc_dat
FROM Products p 
JOIN OrderDetails od ON od.ProductID = p.ProductID 

-- 10)	Tìm khách hàng có tổng giá trị đơn hàng cao nhất
SELECT c.CustomerName , SUM(p.Price * od.Quantity ) as total
FROM Customers c 
JOIN Orders o ON o.CustomerID = c.CustomerID 
JOIN OrderDetails od ON od.OrderID = o.OrderID 
JOIN Products p ON p.ProductID = od.ProductID 
GROUP BY c.CustomerName 
ORDER BY total DESC
LIMIT 1;

--  11)	Tìm các đơn hàng có tổng giá trị nằm trong top 10 cao nhất
SELECT od.OrderID , SUM(od.Quantity * p.Price) AS total
FROM OrderDetails od
JOIN Products p ON p.ProductID = od.ProductID
GROUP BY od.OrderID
ORDER BY total DESC
LIMIT 10;

-- 12)	Tìm tên khách hàng và số lượng đơn hàng của họ, chỉ bao gồm các khách hàng có số lượng đơn hàng lớn hơn mức trung bình
-- B1: Tính tổng số lượng đơn hàng
-- B2: Tính tổng số khách hàng đã đặt
-- B3: Tính trung bình mỗi khách đặt bao nhiêu đơn và gán cho biến
(SELECT @trungbinh := COUNT(*)/(SELECT COUNT(*) 
				FROM Customers c )
FROM Orders o);
-- B4: Tính kết quả
SELECT c.CustomerName , COUNT(o.OrderID) AS so_order
FROM Customers c 
LEFT JOIN Orders o ON o.CustomerID = c.CustomerID  
GROUP BY c.CustomerName 
HAVING so_order > @trungbinh;

-- 13)	Tìm sản phẩm có giá trị đơn hàng trung bình cao nhất (dựa trên giá sản phẩm và số lượng).
SELECT p.ProductName , od.OrderID , (od.Quantity * p.Price) AS total
FROM OrderDetails od
JOIN Products p ON p.ProductID = od.ProductID
ORDER BY total DESC
LIMIT 1

-- 14)	Liệt kê các sản phẩm chưa bao giờ được đặt hàng bởi khách hàng đến từ "USA"
SELECT p.ProductName 
FROM Products p 
JOIN OrderDetails od ON od.ProductID = p.ProductID 
JOIN Orders o ON o.OrderID = od.OrderID 
JOIN Customers c ON c.CustomerID = o.CustomerID 
WHERE c.Country != "USA";

-- 15)	Tìm nhà cung cấp có số lượng sản phẩm cung cấp nhiều nhất.
SELECT s.SupplierName , SUM(od.Quantity) AS product_total
FROM Suppliers s 
JOIN Products p ON p.SupplierID = s.SupplierID 
JOIN OrderDetails od ON od.ProductID = p.ProductID 
GROUP BY s.SupplierName 
ORDER BY product_total DESC
LIMIT 1;

