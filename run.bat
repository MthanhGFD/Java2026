@echo off
echo ========================================
echo    HE THONG QUAN LY CHUYEN BAY
echo ========================================
echo.

REM Check if Java is installed
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ❌ Java chưa được cài đặt. Vui lòng cài đặt JDK 11+ trước.
    pause
    exit /b 1
)

REM Check if Maven is installed
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ❌ Maven chưa được cài đặt. Vui lòng cài đặt Maven 3.6+ trước.
    pause
    exit /b 1
)

echo ✅ Java và Maven đã được cài đặt.
echo.

REM Clean and compile
echo 🔧 Đang build project...
call mvn clean compile
if %errorlevel% neq 0 (
    echo ❌ Build thất bại. Kiểm tra lỗi trên.
    pause
    exit /b 1
)

echo ✅ Build thành công!
echo.

REM Run the application
echo 🚀 Đang khởi động ứng dụng...
call mvn exec:java -Dexec.mainClass="gui.GUI"
if %errorlevel% neq 0 (
    echo ❌ Lỗi khi chạy ứng dụng.
    pause
    exit /b 1
)

pause