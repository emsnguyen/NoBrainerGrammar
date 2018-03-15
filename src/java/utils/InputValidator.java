package utils;
public class InputValidator {
    public static String isUsernameValid(String username) {
        if (username == null || username.isEmpty()) {
            return "Tên đăng nhập không được trống";
        }
        int length = username.length();
        if (length < 8 || length > 20) {
            return "Tên đăng nhập phải từ 8 đến 20 kí tự";
        }
        //match requires the whole string to match a certain regex
        //wrong if username does not contain letter characters
        if (!username.matches("(.*)[A-Za-z](.*)")) {
            return "Tên đăng nhập phải chứa chữ cái";
        }
        //wrong if username starts with space ( ) or number
        if (username.matches("^[ 0-9](.*)")) {
            return "Tên đăng nhập không được bắt đầu bằng số hoặc dấu cách";
        }
        return "";
    }
    public static String isPasswordValid(String password) {
        if (password == null || password.isEmpty()) {
            return "Mật khẩu không được trống";
        }
        int length = password.length();
        if (length < 8 || length > 20) {
            return "Mật khẩu phải từ 8 đến 20 kí tự";
        }
        //match requires the whole string to match a certain regex
        //wrong if password does not contain lowercase letters
//        if (!password.matches("(.*)[a-z](.*)")) {
//            return "Mật khẩu phải chứa ít nhất 1 chữ cái thường";
//        }
//        //wrong if password does not contain uppercase letters
//        if (!password.matches("(.*)[A-Z](.*)")) {
//            return "Mật khẩu phải chứa ít nhất 1 chữ cái hoa";
//        }
//        //wrong if password does not contain number
//        if (!password.matches("(.*)[0-9](.*)")) {
//            return "Mật khẩu phải chứa số";
//        }
        return "";
    }
}
