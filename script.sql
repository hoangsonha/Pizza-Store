USE [master]
GO
/****** Object:  Database [pizzafood]    Script Date: 7/9/2024 10:13:02 ******/
CREATE DATABASE [pizzafood]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'pizzafood', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SE160429\MSSQL\DATA\pizzafood.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'pizzafood_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SE160429\MSSQL\DATA\pizzafood_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [pizzafood] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [pizzafood].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [pizzafood] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [pizzafood] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [pizzafood] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [pizzafood] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [pizzafood] SET ARITHABORT OFF 
GO
ALTER DATABASE [pizzafood] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [pizzafood] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [pizzafood] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [pizzafood] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [pizzafood] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [pizzafood] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [pizzafood] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [pizzafood] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [pizzafood] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [pizzafood] SET  ENABLE_BROKER 
GO
ALTER DATABASE [pizzafood] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [pizzafood] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [pizzafood] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [pizzafood] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [pizzafood] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [pizzafood] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [pizzafood] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [pizzafood] SET RECOVERY FULL 
GO
ALTER DATABASE [pizzafood] SET  MULTI_USER 
GO
ALTER DATABASE [pizzafood] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [pizzafood] SET DB_CHAINING OFF 
GO
ALTER DATABASE [pizzafood] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [pizzafood] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [pizzafood] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [pizzafood] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'pizzafood', N'ON'
GO
ALTER DATABASE [pizzafood] SET QUERY_STORE = OFF
GO
USE [pizzafood]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 7/9/2024 10:13:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[AccountID] [varchar](5) NOT NULL,
	[UserName] [nvarchar](20) NOT NULL,
	[Password] [varchar](100) NOT NULL,
	[FullName] [nvarchar](30) NOT NULL,
	[Type] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[AccountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 7/9/2024 10:13:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[CategoryID] [varchar](5) NOT NULL,
	[CategoryName] [nvarchar](20) NOT NULL,
	[Description] [nvarchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 7/9/2024 10:13:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[OrderID] [int] NULL,
	[ProductID] [varchar](5) NULL,
	[UnitPrice] [money] NOT NULL,
	[Quantity] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 7/9/2024 10:13:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [int] IDENTITY(1,1) NOT NULL,
	[AccountID] [varchar](5) NOT NULL,
	[OrderDate] [date] NOT NULL,
	[Status] [nvarchar](50) NOT NULL,
	[ShipAddress] [nvarchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 7/9/2024 10:13:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[ProductID] [varchar](5) NOT NULL,
	[ProductName] [nvarchar](20) NOT NULL,
	[SupplierID] [varchar](5) NOT NULL,
	[CategoryID] [varchar](5) NOT NULL,
	[QuantityPerUnit] [int] NOT NULL,
	[UnitPrice] [money] NOT NULL,
	[ProductImage] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Suppliers]    Script Date: 7/9/2024 10:13:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Suppliers](
	[SupplierID] [varchar](5) NOT NULL,
	[CompanyName] [nvarchar](50) NOT NULL,
	[Address] [nvarchar](200) NOT NULL,
	[Phone] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SupplierID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([AccountID], [UserName], [Password], [FullName], [Type]) VALUES (N'A01', N'Nguyen', N'123456', N'Nguyen Ngoc Nguyenn', 2)
INSERT [dbo].[Account] ([AccountID], [UserName], [Password], [FullName], [Type]) VALUES (N'A02', N'Ha', N'123456', N'Hoang Son Ha', 1)
INSERT [dbo].[Account] ([AccountID], [UserName], [Password], [FullName], [Type]) VALUES (N'A03', N'Quynhh', N'123456', N'Vu Ngoc Quynhh', 2)
INSERT [dbo].[Account] ([AccountID], [UserName], [Password], [FullName], [Type]) VALUES (N'A04', N'Phuong', N'123456', N'Chau Quynh Phuong', 2)
INSERT [dbo].[Account] ([AccountID], [UserName], [Password], [FullName], [Type]) VALUES (N'A05', N'May', N'123456', N'Nguyen Thi Dieu May', 2)
GO
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'B', N'Bò', N'Làm từ bò')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'G', N'Gà', N'Làm từ gà')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'HS', N'Hải sản', N'Có hải sản')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'NN', N'Nhân nhồi', N'Có nhân bên trong')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'PM', N'Phô mai', N'Có phô mai')
GO
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (11, N'P01', 30000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (11, N'P03', 40000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (11, N'P02', 105000.0000, 3)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (11, N'P05', 50000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (11, N'P04', 45000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (11, N'P06', 55000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (13, N'P01', 120000.0000, 4)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (13, N'P03', 40000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (13, N'P02', 35000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (14, N'P03', 400000.0000, 10)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (18, N'P01', 30000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (18, N'P02', 35000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (20, N'P01', 30000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (20, N'P03', 40000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (20, N'P02', 35000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (21, N'P01', 30000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (21, N'P03', 40000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (21, N'P02', 35000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (22, N'P03', 40000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (22, N'P02', 35000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (23, N'P01', 30000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (23, N'P03', 40000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (23, N'P02', 35000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (24, N'P01', 30000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (24, N'P03', 40000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (24, N'P02', 35000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (25, N'P01', 30000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (25, N'P03', 40000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (25, N'P02', 35000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (15, N'P03', 200000.0000, 5)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (16, N'P01', 30000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (16, N'P03', 120000.0000, 3)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (16, N'P02', 35000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (17, N'P01', 30000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (17, N'P03', 120000.0000, 3)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (17, N'P02', 35000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (26, N'P01', 30000.0000, 1)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (26, N'P02', 35000.0000, 1)
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (4, N'A02', CAST(N'2024-04-23' AS Date), N'procesing', N'HN')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (9, N'A01', CAST(N'2024-04-23' AS Date), N'Processing', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (10, N'A01', CAST(N'2024-04-23' AS Date), N'Processing', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (11, N'A01', CAST(N'2024-04-23' AS Date), N'Processing', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (12, N'A01', CAST(N'2024-04-23' AS Date), N'Processing', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (13, N'A01', CAST(N'2024-04-23' AS Date), N'successfully', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (14, N'A01', CAST(N'2024-04-23' AS Date), N'successfully', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (15, N'A01', CAST(N'2024-04-23' AS Date), N'successfully', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (16, N'A01', CAST(N'2024-04-24' AS Date), N'Successfully', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (17, N'A01', CAST(N'2024-04-24' AS Date), N'Successfully', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (18, N'A01', CAST(N'2024-04-24' AS Date), N'Successfully', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (19, N'A01', CAST(N'2024-04-24' AS Date), N'Processing', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (20, N'A01', CAST(N'2024-04-24' AS Date), N'Successfully', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (21, N'A01', CAST(N'2024-04-24' AS Date), N'Successfully', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (22, N'A02', CAST(N'2024-04-24' AS Date), N'Successfully', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (23, N'A02', CAST(N'2024-04-24' AS Date), N'Successfully', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (24, N'A02', CAST(N'2024-04-24' AS Date), N'Successfully', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (25, N'A02', CAST(N'2024-04-24' AS Date), N'Successfully', N'')
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [Status], [ShipAddress]) VALUES (26, N'A02', CAST(N'2024-04-24' AS Date), N'Successfully', N'HCM')
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
INSERT [dbo].[Products] ([ProductID], [ProductName], [SupplierID], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'P01', N'Pizza Gà', N'VN', N'G', 92, 30000.0000, N'pizza_ga.jpg')
INSERT [dbo].[Products] ([ProductID], [ProductName], [SupplierID], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'P02', N'Pizza Bò', N'M', N'B', 91, 35000.0000, N'pizza_bo.jpg')
INSERT [dbo].[Products] ([ProductID], [ProductName], [SupplierID], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'P03', N'Pizza Phô mai', N'H', N'PM', 91, 40000.0000, N'pizza_phomai.jpg')
INSERT [dbo].[Products] ([ProductID], [ProductName], [SupplierID], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'P04', N'Pizza Hawai', N'N', N'HS', 100, 45000.0000, N'pizza_hawai.jpg')
INSERT [dbo].[Products] ([ProductID], [ProductName], [SupplierID], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'P05', N'Pizza Nhân nhồi', N'TQ', N'NN', 100, 50000.0000, N'pizza_nhannhoi.jpg')
INSERT [dbo].[Products] ([ProductID], [ProductName], [SupplierID], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'P06', N'Pizza Sốt', N'M', N'PM', 100, 55000.0000, N'pizza_sot.jpg')
INSERT [dbo].[Products] ([ProductID], [ProductName], [SupplierID], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'P07', N'Pizza Thung', N'H', N'G', 1000, 60000.0000, N'pizza_ga.jpg')
INSERT [dbo].[Products] ([ProductID], [ProductName], [SupplierID], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'P08', N'Pizza Hải sản', N'VN', N'HS', 100, 65000.0000, N'pizza_haisan.jpg')
INSERT [dbo].[Products] ([ProductID], [ProductName], [SupplierID], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'P09', N'Pizza Hạng 1', N'M', N'HS', 100, 78000.0000, N'pizza_1.jpg')
GO
INSERT [dbo].[Suppliers] ([SupplierID], [CompanyName], [Address], [Phone]) VALUES (N'H', N'Hàn Company', N'Hàn', N'345')
INSERT [dbo].[Suppliers] ([SupplierID], [CompanyName], [Address], [Phone]) VALUES (N'M', N'Mỹ Company', N'Mỹ', N'456')
INSERT [dbo].[Suppliers] ([SupplierID], [CompanyName], [Address], [Phone]) VALUES (N'N', N'Nhật Company', N'Nhật', N'789')
INSERT [dbo].[Suppliers] ([SupplierID], [CompanyName], [Address], [Phone]) VALUES (N'TQ', N'Trung Quốc Company', N'Trung Quốc', N'012')
INSERT [dbo].[Suppliers] ([SupplierID], [CompanyName], [Address], [Phone]) VALUES (N'VN', N'Việt Nam Company', N'Việt Nam', N'123')
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [fk_orderID] FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [fk_orderID]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [fk_productID] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [fk_productID]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [fk_accountID] FOREIGN KEY([AccountID])
REFERENCES [dbo].[Account] ([AccountID])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [fk_accountID]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [fk_CategoriesID] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Categories] ([CategoryID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [fk_CategoriesID]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [fk_supplierID] FOREIGN KEY([SupplierID])
REFERENCES [dbo].[Suppliers] ([SupplierID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [fk_supplierID]
GO
USE [master]
GO
ALTER DATABASE [pizzafood] SET  READ_WRITE 
GO
