#!/bin/bash

echo "========================================"
echo "    HE THONG QUAN LY CHUYEN BAY"
echo "========================================"
echo

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "❌ Java chưa được cài đặt. Vui lòng cài đặt JDK 11+ trước."
    exit 1
fi

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven chưa được cài đặt. Vui lòng cài đặt Maven 3.6+ trước."
    exit 1
fi

echo "✅ Java và Maven đã được cài đặt."
echo

# Clean and compile
echo "🔧 Đang build project..."
mvn clean compile
if [ $? -ne 0 ]; then
    echo "❌ Build thất bại. Kiểm tra lỗi trên."
    exit 1
fi

echo "✅ Build thành công!"
echo

# Run the application
echo "🚀 Đang khởi động ứng dụng..."
mvn exec:java -Dexec.mainClass="gui.GUI"
if [ $? -ne 0 ]; then
    echo "❌ Lỗi khi chạy ứng dụng."
    exit 1
fi