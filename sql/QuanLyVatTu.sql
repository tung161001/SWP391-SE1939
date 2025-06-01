-- Tạo cơ sở dữ liệu và sử dụng
CREATE DATABASE IF NOT EXISTS QuanLyVatTu;
USE QuanLyVatTu;

-- Bảng phân quyền người dùng
CREATE TABLE Role (
    RoleID INT AUTO_INCREMENT PRIMARY KEY,
    RoleName VARCHAR(50) NOT NULL -- Quản lý kho, Nhân viên kho, GĐ, Nhân viên cty
);

-- Bảng người dùng
CREATE TABLE User (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    FullName VARCHAR(100),
    Email VARCHAR(100),
    Password VARCHAR(255),
    Status BOOLEAN DEFAULT TRUE,
    RoleID INT,
    Address VARCHAR(1000),
    FOREIGN KEY (RoleID) REFERENCES Role(RoleID)
);

-- Bảng danh mục vật tư
CREATE TABLE Category (
    CategoryID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    ParentID INT,
    FOREIGN KEY (ParentID) REFERENCES Category(CategoryID)
);

-- Bảng vật tư
CREATE TABLE Material (
    MaterialID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    CategoryID INT,
    ImageURL VARCHAR(255),
    `Condition` VARCHAR(50),
    Price DECIMAL(12,2),
    Quantity INT,
    FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);

-- Bảng phiếu nhập kho
CREATE TABLE ImportReceipt (
    ImportID INT AUTO_INCREMENT PRIMARY KEY,
    MaterialID INT,
    Quantity INT,
    ImportDate DATE,
    DeliveredBy VARCHAR(100),
    ReceivedBy INT,
    FOREIGN KEY (MaterialID) REFERENCES Material(MaterialID),
    FOREIGN KEY (ReceivedBy) REFERENCES User(UserID)
);

-- Bảng phiếu xuất kho
CREATE TABLE ExportReceipt (
    ExportID INT AUTO_INCREMENT PRIMARY KEY,
    MaterialID INT,
    Quantity INT,
    ExportDate DATE,
    ExportedTo INT,
    ExportedBy INT,
    FOREIGN KEY (MaterialID) REFERENCES Material(MaterialID),
    FOREIGN KEY (ExportedTo) REFERENCES User(UserID),
    FOREIGN KEY (ExportedBy) REFERENCES User(UserID)
);

-- Bảng loại yêu cầu (xuất, mua, sửa)
CREATE TABLE RequestType (
    TypeID INT AUTO_INCREMENT PRIMARY KEY,
    TypeName VARCHAR(50)
);

-- Bảng yêu cầu vật tư
CREATE TABLE Request (
    RequestID INT AUTO_INCREMENT PRIMARY KEY,
    RequesterID INT,
    MaterialID INT,
    TypeID INT,
    RequestDate DATE,
    Status VARCHAR(50),
    ResponseNote TEXT,
    ApprovedBy INT,
    FOREIGN KEY (RequesterID) REFERENCES User(UserID),
    FOREIGN KEY (MaterialID) REFERENCES Material(MaterialID),
    FOREIGN KEY (TypeID) REFERENCES RequestType(TypeID),
    FOREIGN KEY (ApprovedBy) REFERENCES User(UserID)
);

-- Dữ liệu mẫu cho bảng Role
INSERT INTO Role (RoleName) VALUES ('Quản lý kho'), ('Nhân viên kho'), ('Giám đốc'), ('Nhân viên');

-- Dữ liệu mẫu cho bảng RequestType
INSERT INTO RequestType (TypeName) VALUES ('Yêu cầu xuất kho'), ('Đề nghị mua mới'), ('Đề nghị sửa chữa');






