package pageUIs.hrmOrange.user;

public class HomePageUI {
    // public: page object dùng lại bên page ui
    // private/default: khác package ko dung dc
    // protected: cac class ben page object ko ke thua ben page ui
    // bien static: cho phép gọi trực tiếp từ class
    // bien non-static: 1. khoi tao doi tuong, or ke thua -> moi dung dc => ko dung, vi Pageui chi chua bien (ko chứa hàm, nếu chứa hàm thì đứng từ PO goị đến)
    // bien non-static: 2. gọi nhanh nhất đứng tu PO gọi ten ham goi den biến
    // final: ngăn việc chỉnh sửa giá trị biến khi gọi từ PO, trong quá trình chạy
    // non-final: có thể update lại giá trị của biến từ pageUI
    // String : tất cả locator đều nhận vào kiểu String
    // tên biến, vì sao viết hoa và dùng dấu gạch dưới: cần đặt tên theo kiểu constant trong Java, mang ý nghĩa ko thay đổi giá trị khi chạy
    public static final String USERNAME = "xpath=//input[@name='username']";
    public static final String PASSWORD = "xpath=//input[@name='password']";
    public static final String SUBMIT_BUTTON = "xpath=//button[@type='submit']";
    public static final String ERROR_MESSAGE_USERNAME = "xpath=//label[text()='Username']/parent::div/following-sibling::span";
    public static final String ERROR_MESSAGE_PASSWORD = "xpath=//input[@name='password']/parent::div/following-sibling::span";
    public static final String ERROR_MESSAGE_CREDENTIALS = "xpath=//p[text()='Invalid credentials']";

}
