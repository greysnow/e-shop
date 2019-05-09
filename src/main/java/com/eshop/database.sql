drop table if exists E_User;
drop table if exists E_Seller;
drop table if exists E_Goods;
drop table if exists E_Order;
drop table if exists E_Manager;

CREATE TABLE E_User
(
    UserId INT(11) PRIMARY KEY NOT NULL COMMENT '用户Id、自增主键' AUTO_INCREMENT,
    UserName VARCHAR(50) NOT NULL COMMENT '用户名',
    UserPwd VARCHAR(200) NOT NULL COMMENT '用户密码,加密存储',
    UserEmail VARCHAR(200) NOT NULL COMMENT '用户邮件',
    UserTel VARCHAR(100) NOT NULL COMMENT '用户电话',
    UserAddress VARCHAR(100) NOT NULL COMMENT '用户地址'
);
CREATE UNIQUE INDEX UK_Name ON E_User (UserName);
ALTER TABLE E_User ADD INDEX IX_UserName(userName);

CREATE TABLE E_Admin
(
    AdminId INT(11) PRIMARY KEY NOT NULL COMMENT '管理员Id、自增主键' AUTO_INCREMENT,
    AdminName VARCHAR(50) NOT NULL COMMENT '管理员名',
    AdminPwd VARCHAR(200) NOT NULL COMMENT '管理员密码,加密存储'
);
CREATE UNIQUE INDEX UK_Name ON E_Admin (AdminName);
ALTER TABLE E_Admin ADD INDEX IX_AdminName(AdminName);

CREATE TABLE E_Order
(
    OrderId INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    UserId INT(11) NOT NULL COMMENT '用户Id',
    GoodsId INT(11) NOT NULL COMMENT '商品Id',
    OrderDate DATE NOT NULL COMMENT '订单日期',
    Quantity INT(20) NOT NULL COMMENT '购买数量',
    Total DOUBLE NOT NULL COMMENT '订单总价格'
);

CREATE TABLE E_Goods
(
    GoodsId INT(11) PRIMARY KEY NOT NULL COMMENT '商品Id、自增主键' AUTO_INCREMENT,
    SellerId INT(11) NOT NULL COMMENT '卖家Id',
    GoodsName VARCHAR(40) NOT NULL COMMENT '商品名',
    GoodsBrand VARCHAR(40) NOT NULL COMMENT '商品品牌',
    GoodsType VARCHAR(20) NOT NULL COMMENT '商品类型',
    GoodsFor VARCHAR(20) NOT NULL COMMENT '男女款式',
    GoodsStock INT(10) NOT NULL COMMENT '商品库存',
    GoodsSales INT(10) NOT NULL DEFAULT 0 COMMENT '销售总量',
    GoodsPrice INT(10) NOT NULL COMMENT '商品价格'
);
CREATE TABLE E_Seller
(
    SellerId INT(11) PRIMARY KEY NOT NULL COMMENT '卖家Id、自增主键' AUTO_INCREMENT,
    SellerName VARCHAR(50) NOT NULL COMMENT '卖家名',
    SellerPwd VARCHAR(200) NOT NULL COMMENT '卖家密码',
    SellerEmail VARCHAR(200) NOT NULL COMMENT '卖家邮件地址',
    SellerTel VARCHAR(100) NOT NULL COMMENT '卖家电话',
    SellerAddress VARCHAR(100) NOT NULL COMMENT '卖家地址'
);
ALTER TABLE E_Seller ADD INDEX IX_SellerName(SellerName);
CREATE UNIQUE INDEX sellerName ON E_Seller (SellerName);

CREATE TABLE E_Sales
(
    SalesId INT(11) PRIMARY KEY NOT NULL COMMENT '销售Id、自增主键' AUTO_INCREMENT,
    GoodsBrand VARCHAR(50) NOT NULL COMMENT '商品品牌',
    OrderDate VARCHAR(200) NOT NULL COMMENT '销售年月',
    Quantity INT(200) NOT NULL COMMENT '销售量'
);

CREATE TABLE E_SellerSales
(
    SellerSalesId INT(11) PRIMARY KEY NOT NULL COMMENT '卖家销售Id、自增主键' AUTO_INCREMENT,
    SellerId INT(11) NOT NULL COMMENT '卖家Id',
    GoodsName VARCHAR(50) NOT NULL COMMENT '商品名称',
    OrderDate VARCHAR(200) NOT NULL COMMENT '销售年月',
    Quantity INT(200) NOT NULL COMMENT '销售量'
);
