# Thực hành REST API

Ứng dụng Food4U

## I. Giới thiệu ứng dụng

Food4U là một ứng dụng đặt món ăn trực tuyến. Thông qua ứng dụng,
người dùng có thể xem thông tin nhà hàng, lựa chọn món ăn và 
thực hiện việc đặt món.

### I.1. Chức năng

- Đăng kí
- Đăng nhập
- Xem danh sách, thông tin nhà hàng
- Xem danh sách, thông tin món ăn
- Đặt hàng
- Đánh giá nhà hàng

### I.2. Mô tả thiết kế

Backend sử dụng SpringBoot 2.x cung cấp REST API cho phía client.

Tài liệu API được mô tả trong 
[Swagger API](https://app.swaggerhub.com/apis/quytm/Food4U/1.0.0)

## II. Nhiệm vụ

- Nắm được các chức năng của ứng dụng
- Implement các đầu API đã được định nghĩa trong 
[Swagger API](https://app.swaggerhub.com/apis/quytm/Food4U/1.0.0) 

## III. Mục tiêu

Tạo webservice cung cấp API cho phía client.

Chỉ cần tập trung vào làm phần backend.

## IV. Planning

Thời gian: 4 tuần

### - Tuần 1:

- Tìm hiểu requirements
- Thiết kế DB
- Dựng base project

### - Tuần 2:

- Implement các đầu API liên quan tới nhà hàng: danh sách, chi tiết, 
đánh giá.

### - Tuần 3:

- Implement các đầu API liên quan tới món ăn và đơn hàng.

### - Tuần 4:

- Hoàn tất việc ghép với API
- API liên quan tới Đăng kí, đăng nhập tự implement sau.