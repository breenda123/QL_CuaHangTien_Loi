USE [QLNS]
GO
/****** Object:  Table [dbo].[TblBoPhan]    Script Date: 01/01/2021 9:24:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblBoPhan](
	[MaBophan] [char](10) NOT NULL,
	[TenBoPhan] [nvarchar](50) NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_TblBoPhan] PRIMARY KEY CLUSTERED 
(
	[MaBophan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblCongAnNinh]    Script Date: 01/01/2021 9:24:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblCongAnNinh](
	[MaNV] [char](10) NOT NULL,
	[MaBoPhan] [char](10) NULL,
	[LCB] [int] NULL,
	[PhuCapCVu] [int] NULL,
	[PhuCapKhac] [int] NULL,
	[Thang] [int] NULL,
	[Nam] [int] NULL,
	[SoNgayCongThang] [int] NULL,
	[SoNgayNghi] [int] NULL,
	[SoGioLamThem] [int] NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_TblCongKhoiVanPHong] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblCongBanHang]    Script Date: 01/01/2021 9:24:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblCongBanHang](
	[MaNV] [char](10) NOT NULL,
	[LCB] [int] NULL,
	[PhuCapCVu] [int] NULL,
	[PhuCapKhac] [int] NULL,
	[Thang] [int] NULL,
	[Nam] [int] NULL,
	[SoNgayCongThang] [int] NULL,
	[SoNgayNghi] [int] NULL,
	[SoGioLamThem] [int] NULL,
	[GhiChu] [nvarchar](50) NULL,
	[MaBoPhan] [char](10) NOT NULL,
 CONSTRAINT [PK_TblCongKhoiSanXuat] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblCongDieuHanh]    Script Date: 01/01/2021 9:24:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblCongDieuHanh](
	[MaNV] [char](10) NOT NULL,
	[LCB] [int] NULL,
	[PhuCapCVu] [int] NULL,
	[PHuCapKhac] [int] NULL,
	[Thang] [char](10) NULL,
	[Nam] [char](10) NULL,
	[SoNgayCongThang] [int] NULL,
	[SoNgayNghi] [int] NULL,
	[SoGioLamThem] [int] NULL,
	[GhiChu] [nvarchar](50) NULL,
	[MaBoPhan] [char](10) NULL,
 CONSTRAINT [PK_TblCongKhoiDieuHanh] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblCongKiemKho]    Script Date: 01/01/2021 9:24:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblCongKiemKho](
	[MaNV] [char](10) NOT NULL,
	[LCB] [int] NULL,
	[PhuCapCVu] [int] NULL,
	[PhuCapKhac] [int] NULL,
	[Thang] [int] NULL,
	[Nam] [int] NULL,
	[SoNgayCongThang] [int] NULL,
	[SoNgayNghi] [int] NULL,
	[SOGioLamThem] [int] NULL,
	[GhiChu] [nvarchar](50) NULL,
	[MaBoPhan] [char](10) NULL,
 CONSTRAINT [PK_TblCongKhoiVanChuyen] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblHoSoThuViec]    Script Date: 01/01/2021 9:24:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblHoSoThuViec](
	[MaPhong] [char](10) NOT NULL,
	[MaNV] [char](10) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[NgaySinh] [datetime] NULL,
	[GioiTinh] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[TDHocVan] [nvarchar](50) NULL,
	[HocHam] [nvarchar](50) NULL,
	[ViTriThuViec] [nvarchar](50) NULL,
	[NgayTV] [datetime] NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_TblHeSoThuViec] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblLuong]    Script Date: 01/01/2021 9:24:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblLuong](
	[MaNV] [char](10) NULL,
	[MaLuong] [char](10) NOT NULL,
	[HoTen] [nvarchar](30) NULL,
	[GioiTinh] [nvarchar](5) NULL,
	[ChucVu] [nvarchar](50) NULL,
	[ChucDanh] [nvarchar](50) NULL,
	[LCB] [int] NULL,
	[LCB_gio] [int] NULL,
	[PCap] [int] NULL,
	[HinhThuc] [nvarchar](20) NULL,
	[NgayNhap] [date] NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_TblLuong] PRIMARY KEY CLUSTERED 
(
	[MaLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblTTNVCaNhan]    Script Date: 01/01/2021 9:24:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblTTNVCaNhan](
	[MaNV] [char](10) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[GioiTinh] [nvarchar](5) NULL,
	[NgaySinh] [date] NULL,
	[NoiSinh] [nvarchar](50) NULL,
	[NguyenQuan] [nvarchar](50) NULL,
	[DCThuongtru] [nvarchar](100) NULL,
	[DCTamtru] [nvarchar](100) NULL,
	[SDT] [char](12) NULL,
	[DanToc] [nvarchar](30) NULL,
	[TonGiao] [nvarchar](20) NULL,
	[QuocTich] [nvarchar](20) NULL,
	[GhiChu] [nvarchar](50) NULL CONSTRAINT [DF_TblTTNVCaNhan_GhiChu]  DEFAULT (N'Không'),
 CONSTRAINT [PK_TblTTNVCaNhan] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblTTNVCoBan]    Script Date: 01/01/2021 9:24:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblTTNVCoBan](
	[MaBoPhan] [char](10) NOT NULL,
	[MaNV] [char](10) NOT NULL,
	[HoTen] [nvarchar](30) NULL,
	[NgaySinh] [date] NULL,
	[GioiTinh] [nvarchar](3) NULL CONSTRAINT [DF_TblTTNVCoBan_GioiTinh]  DEFAULT (N'Nam'),
	[CMTND] [char](12) NULL,
	[NgayCap] [date] NULL,
	[NoiCap] [nvarchar](50) NULL,
	[ChucVu] [nvarchar](50) NULL CONSTRAINT [DF_TblTTNVCoBan_ChucVu]  DEFAULT (N'Director'),
	[ChucDanh] [nvarchar](50) NULL,
	[LoaiHD] [nvarchar](50) NULL,
	[NgayKy] [date] NULL,
	[NgayHetHan] [date] NULL,
	[GhiChu] [nvarchar](100) NULL CONSTRAINT [DF_TblTTNVCoBan_GhiChu]  DEFAULT (N'Không'),
 CONSTRAINT [PK_TblTTNVCoBan] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbuser]    Script Date: 01/01/2021 9:24:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[tbuser](
	[Username] [nvarchar](50) NOT NULL,
	[Pass] [nvarchar](50) NULL,
	[ChucVu] [nvarchar](50) NULL,
	[NhanVien] [char](10) NULL,
 CONSTRAINT [PK_tbuser] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[TblBoPhan] ([MaBophan], [TenBoPhan], [GhiChu]) VALUES (N'12        ', N'tt', N'sda')
INSERT [dbo].[TblBoPhan] ([MaBophan], [TenBoPhan], [GhiChu]) VALUES (N'13        ', N'An Ninh', N'cz')
INSERT [dbo].[TblCongAnNinh] ([MaNV], [MaBoPhan], [LCB], [PhuCapCVu], [PhuCapKhac], [Thang], [Nam], [SoNgayCongThang], [SoNgayNghi], [SoGioLamThem], [GhiChu]) VALUES (N'002       ', N'12        ', 51000000, 600001, 50000, 12, 2019, 30, 0, 6, N's')
INSERT [dbo].[TblCongBanHang] ([MaNV], [LCB], [PhuCapCVu], [PhuCapKhac], [Thang], [Nam], [SoNgayCongThang], [SoNgayNghi], [SoGioLamThem], [GhiChu], [MaBoPhan]) VALUES (N'1         ', 31555, 30000, 2222111, 12, 2021, 30, 1, 0, N'1', N'12        ')
INSERT [dbo].[TblCongBanHang] ([MaNV], [LCB], [PhuCapCVu], [PhuCapKhac], [Thang], [Nam], [SoNgayCongThang], [SoNgayNghi], [SoGioLamThem], [GhiChu], [MaBoPhan]) VALUES (N'5         ', 315, 0, 0, 12, 2021, 30, 1, 0, N'1', N'12        ')
INSERT [dbo].[TblCongDieuHanh] ([MaNV], [LCB], [PhuCapCVu], [PHuCapKhac], [Thang], [Nam], [SoNgayCongThang], [SoNgayNghi], [SoGioLamThem], [GhiChu], [MaBoPhan]) VALUES (N'1         ', 540000000, 25000, 90000, N'12        ', N'2020      ', 30, 0, 6, N'ko', N'12        ')
INSERT [dbo].[TblCongDieuHanh] ([MaNV], [LCB], [PhuCapCVu], [PHuCapKhac], [Thang], [Nam], [SoNgayCongThang], [SoNgayNghi], [SoGioLamThem], [GhiChu], [MaBoPhan]) VALUES (N'5         ', 1222, 11111, 112555, N'12        ', N'2020      ', 30, 5, 3, N'j', N'12        ')
INSERT [dbo].[TblLuong] ([MaNV], [MaLuong], [HoTen], [GioiTinh], [ChucVu], [ChucDanh], [LCB], [LCB_gio], [PCap], [HinhThuc], [NgayNhap], [GhiChu]) VALUES (N'1         ', N'L2        ', N'dđakkkk', N'Nam', N'Director', N'ddddlllllllk', 3153515, 31, 31514577, N'Full time', CAST(N'2016-05-24' AS Date), N'ss')
INSERT [dbo].[TblLuong] ([MaNV], [MaLuong], [HoTen], [GioiTinh], [ChucVu], [ChucDanh], [LCB], [LCB_gio], [PCap], [HinhThuc], [NgayNhap], [GhiChu]) VALUES (N'3         ', N'L3        ', N'sfs', N'Nam', N'Director', N'fsfd', 6000000, 0, 20000, N'Part time', CAST(N'2018-05-24' AS Date), N'gđ')
INSERT [dbo].[TblLuong] ([MaNV], [MaLuong], [HoTen], [GioiTinh], [ChucVu], [ChucDanh], [LCB], [LCB_gio], [PCap], [HinhThuc], [NgayNhap], [GhiChu]) VALUES (N'5         ', N'L6        ', N'ssss', N'Nam', N'Director', N'sâ', 250000, 10000, 20, N'Part time', CAST(N'2018-05-24' AS Date), N'a')
INSERT [dbo].[TblTTNVCaNhan] ([MaNV], [HoTen], [GioiTinh], [NgaySinh], [NoiSinh], [NguyenQuan], [DCThuongtru], [DCTamtru], [SDT], [DanToc], [TonGiao], [QuocTich], [GhiChu]) VALUES (N'002       ', N'kkkkkkd', N'nam', CAST(N'2000-04-26' AS Date), N'ád', N'da', N'adas', N'llllllllll      ', N'03666       ', N'ssa', N'adass', N'adas', N'ad')
INSERT [dbo].[TblTTNVCaNhan] ([MaNV], [HoTen], [GioiTinh], [NgaySinh], [NoiSinh], [NguyenQuan], [DCThuongtru], [DCTamtru], [SDT], [DanToc], [TonGiao], [QuocTich], [GhiChu]) VALUES (N'3         ', N'kkkkkkdk', N'nam', CAST(N'2000-04-26' AS Date), N'ádd', N'da', N'adas', N'llllllllll      ', N'03666       ', N'ssa', N'adass', N'adas', N'ad')
INSERT [dbo].[TblTTNVCaNhan] ([MaNV], [HoTen], [GioiTinh], [NgaySinh], [NoiSinh], [NguyenQuan], [DCThuongtru], [DCTamtru], [SDT], [DanToc], [TonGiao], [QuocTich], [GhiChu]) VALUES (N'7         ', N'kkkkkkd', N'nam', CAST(N'2000-04-26' AS Date), N'ád', N'da', N'adas', N'llllllllll      ', N'03666       ', N'ssa', N'adass', N'adas', N'ad')
INSERT [dbo].[TblTTNVCoBan] ([MaBoPhan], [MaNV], [HoTen], [NgaySinh], [GioiTinh], [CMTND], [NgayCap], [NoiCap], [ChucVu], [ChucDanh], [LoaiHD], [NgayKy], [NgayHetHan], [GhiChu]) VALUES (N'12        ', N'002       ', N'g', CAST(N'2000-06-08' AS Date), N'Nam', N'2465        ', CAST(N'2019-06-29' AS Date), N'lkj', N'Manager', N'klj', N'oip', CAST(N'2019-06-29' AS Date), CAST(N'2019-06-29' AS Date), N'')
INSERT [dbo].[TblTTNVCoBan] ([MaBoPhan], [MaNV], [HoTen], [NgaySinh], [GioiTinh], [CMTND], [NgayCap], [NoiCap], [ChucVu], [ChucDanh], [LoaiHD], [NgayKy], [NgayHetHan], [GhiChu]) VALUES (N'12        ', N'1         ', N'dxas', CAST(N'2001-06-05' AS Date), N'Nam', N'315         ', CAST(N'2005-07-26' AS Date), N'ads', N'Direction', N'ada', N'ada', CAST(N'1998-04-30' AS Date), CAST(N'1999-06-30' AS Date), N'ada')
INSERT [dbo].[TblTTNVCoBan] ([MaBoPhan], [MaNV], [HoTen], [NgaySinh], [GioiTinh], [CMTND], [NgayCap], [NoiCap], [ChucVu], [ChucDanh], [LoaiHD], [NgayKy], [NgayHetHan], [GhiChu]) VALUES (N'mb04      ', N'3         ', N'pk', CAST(N'2001-04-26' AS Date), N'Nam', N'321564      ', CAST(N'2180-04-26' AS Date), N'ád', N'Direction', N'ada', N'ada', CAST(N'2020-04-16' AS Date), CAST(N'2060-04-26' AS Date), N' ')
INSERT [dbo].[TblTTNVCoBan] ([MaBoPhan], [MaNV], [HoTen], [NgaySinh], [GioiTinh], [CMTND], [NgayCap], [NoiCap], [ChucVu], [ChucDanh], [LoaiHD], [NgayKy], [NgayHetHan], [GhiChu]) VALUES (N'13        ', N'5         ', N'vd', CAST(N'2000-04-20' AS Date), N'Nam', N'1444        ', CAST(N'1999-06-30' AS Date), N'hf', N'Manager', N'hhh', N'hhh', CAST(N'2015-08-23' AS Date), CAST(N'2020-09-24' AS Date), N'Không')
INSERT [dbo].[tbuser] ([Username], [Pass], [ChucVu], [NhanVien]) VALUES (N'tr', N'123', N'Director', N'1         ')
INSERT [dbo].[tbuser] ([Username], [Pass], [ChucVu], [NhanVien]) VALUES (N'trong', N'1234', N'Director', N'3         ')
INSERT [dbo].[tbuser] ([Username], [Pass], [ChucVu], [NhanVien]) VALUES (N'tronglenh', N'123', N'Director', NULL)
INSERT [dbo].[tbuser] ([Username], [Pass], [ChucVu], [NhanVien]) VALUES (N'trr', N'123', N'Director', N'2         ')
INSERT [dbo].[tbuser] ([Username], [Pass], [ChucVu], [NhanVien]) VALUES (N'trrr', N'123456', N'Director', N'002       ')
ALTER TABLE [dbo].[TblHoSoThuViec] ADD  CONSTRAINT [DF_TblHoSoThuViec_GhiChu]  DEFAULT (N'Không') FOR [GhiChu]
GO
ALTER TABLE [dbo].[TblCongAnNinh]  WITH CHECK ADD  CONSTRAINT [FK_TblCongKhoiVanPHong_TblBoPhan] FOREIGN KEY([MaBoPhan])
REFERENCES [dbo].[TblBoPhan] ([MaBophan])
GO
ALTER TABLE [dbo].[TblCongAnNinh] CHECK CONSTRAINT [FK_TblCongKhoiVanPHong_TblBoPhan]
GO
ALTER TABLE [dbo].[TblCongBanHang]  WITH CHECK ADD  CONSTRAINT [FK_TblCongKhoiSanXuat_TblBoPhan] FOREIGN KEY([MaBoPhan])
REFERENCES [dbo].[TblBoPhan] ([MaBophan])
GO
ALTER TABLE [dbo].[TblCongBanHang] CHECK CONSTRAINT [FK_TblCongKhoiSanXuat_TblBoPhan]
GO
ALTER TABLE [dbo].[TblCongDieuHanh]  WITH CHECK ADD  CONSTRAINT [FK_TblCongKhoiDieuHanh_TblBoPhan] FOREIGN KEY([MaBoPhan])
REFERENCES [dbo].[TblBoPhan] ([MaBophan])
GO
ALTER TABLE [dbo].[TblCongDieuHanh] CHECK CONSTRAINT [FK_TblCongKhoiDieuHanh_TblBoPhan]
GO
ALTER TABLE [dbo].[TblCongKiemKho]  WITH CHECK ADD  CONSTRAINT [FK_TblCongKhoiVanChuyen_TblBoPhan] FOREIGN KEY([MaBoPhan])
REFERENCES [dbo].[TblBoPhan] ([MaBophan])
GO
ALTER TABLE [dbo].[TblCongKiemKho] CHECK CONSTRAINT [FK_TblCongKhoiVanChuyen_TblBoPhan]
GO
ALTER TABLE [dbo].[TblLuong]  WITH CHECK ADD  CONSTRAINT [FK_TblLuong_TblTTNVCoBan] FOREIGN KEY([MaNV])
REFERENCES [dbo].[TblTTNVCoBan] ([MaNV])
GO
ALTER TABLE [dbo].[TblLuong] CHECK CONSTRAINT [FK_TblLuong_TblTTNVCoBan]
GO
