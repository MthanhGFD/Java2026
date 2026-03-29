# 📌 ĐỒ ÁN HỌC PHẦN JAVA
## ✈️ HỆ THỐNG QUẢN LÝ BÁN VÉ MÁY BAY

---

## 📖 Giới thiệu
Đây là đồ án học phần **Java**, xây dựng hệ thống **quản lý bán vé máy bay**, áp dụng lập trình hướng đối tượng (OOP), quản lý dữ liệu và làm việc nhóm với **Git**.

---

## 🏗️ Kiến trúc chương trình
```
src/
├── main/
│   ├── java/
│   │   ├── config/          # Cấu hình database
│   │   ├── database/        # Kết nối database
│   │   ├── exception/       # Xử lý ngoại lệ
│   │   ├── model/           # Các entity class
│   │   ├── DAO/             # Data Access Objects
│   │   ├── BUS/             # Business Logic
│   │   ├── gui/             # Giao diện người dùng
│   │   └── utils/           # Các tiện ích
│   └── resources/           # Cấu hình, properties
└── test/                    # Unit tests
```

---

## 🚀 Cài đặt và Chạy

### 📋 Yêu cầu hệ thống
- **Java**: JDK 11+
- **Database**: MySQL 8.0+
- **Build Tool**: Maven 3.6+

### 🛠️ Hướng dẫn setup

1. **Clone project**:
   ```bash
   git clone https://github.com/MthanhGFD/Java2026
   cd Java2026
   ```

2. **Cấu hình database**:
   - Tạo database MySQL: `quanlychuyenbay`
   - Import dữ liệu từ file `data/database.sql`
   - Cập nhật thông tin kết nối trong `src/main/resources/db.properties`

3. **Build project**:
   ```bash
   mvn clean compile
   ```

4. **Chạy ứng dụng**:
   ```bash
   mvn exec:java -Dexec.mainClass="gui.GUI"
   ```

5. **Chạy test**:
   ```bash
   mvn test
   ```

---

## 📊 Chức năng chính

### 👥 Quản lý Khách hàng
- Thêm, sửa, xóa khách hàng
- Tìm kiếm theo tên/SĐT
- Xem lịch sử đặt vé

### ✈️ Quản lý Chuyến bay
- Quản lý thông tin chuyến bay
- Cập nhật trạng thái chuyến bay
- Tra cứu lịch bay

### 🎫 Quản lý Vé & Hóa đơn
- Đặt vé online
- Xuất hóa đơn
- Thống kê doanh thu

### 📈 Báo cáo & Thống kê
- Thống kê chuyến bay
- Báo cáo doanh thu
- Xuất báo cáo Excel/PDF

---

## 🔧 Công nghệ sử dụng
- **Backend**: Java 11, JDBC
- **Database**: MySQL
- **GUI**: Swing
- **Build**: Maven
- **Version Control**: Git

---

## 👥 Đội ngũ phát triển
- **Thành viên**: [Tên các thành viên]
- **Giảng viên**: [Tên giảng viên]

---

## 📝 License
This project is for educational purposes only.
- git push origin <tên_nhánh>    ---   // Đẩy code lên nhánh cá nhân
- git pull origin main    ---    // Lấy code mới nhất từ nhánh chính

---

# 🔄 Quy trình làm việc (Workflow)
- Checkout nhánh cá nhân
- Pull code từ nhánh main
- Thông báo file/phần mình sẽ làm (tránh trùng nhau)
- Hoàn thành công việc:
- git add
- git commit
- git push
- Thông báo cho nhóm sau khi push xong

# ⚠️ Lưu ý quan trọng
- Mở Terminal: CTRL + `
- Cần mạng để sử dụng git
- ❌ Tránh nhiều người cùng chỉnh sửa một file
- ✔️ Luôn pull trước khi bắt đầu code
- ✔️ Commit rõ ràng, dễ hiểu
- ✔️ Thông báo nhóm khi có thay đổi
