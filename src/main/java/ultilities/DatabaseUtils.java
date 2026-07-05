package ultilities;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseUtils {

    // Mỗi thread có 1 connection riêng -> an toàn khi chạy test song song (parallel)
    private static final ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();

    // Đọc cấu hình từ file db.properties (đặt trong src/main/resources)
    private static Properties loadConfig() {
        Properties props = new Properties();
        try (InputStream input = DatabaseUtils.class.getClassLoader()
                .getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new RuntimeException("Không tìm thấy file db.properties trong classpath (resources)");
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi đọc db.properties", e);
        }
        return props;
    }

    public static Connection getConnection() {
        Connection conn = connectionHolder.get();
        try {
            if (conn == null || conn.isClosed()) {
                Properties props = loadConfig();
                conn = getConnection(
                        props.getProperty("db.host"),
                        props.getProperty("db.service"),
                        props.getProperty("db.port"),
                        props.getProperty("db.user"),
                        props.getProperty("db.password")
                );
                connectionHolder.set(conn);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Không thể kiểm tra trạng thái connection", e);
        }
        return conn;
    }

    public static Connection getConnection(String hostName, String serviceName,
                                           String port, String userName, String password) {
        try {
            String url = String.format("jdbc:oracle:thin:@//%s:%s/%s", hostName, port, serviceName);
            Connection conn = DriverManager.getConnection(url, userName, password);
            connectionHolder.set(conn);
            return conn;
        } catch (SQLException e) {
            // Ném lỗi ra ngoài thay vì nuốt lỗi -> caller biết ngay là kết nối fail
            throw new RuntimeException("Kết nối database thất bại: " + e.getMessage(), e);
        }
    }

    public String getStatus(String empId) throws SQLException {
        Connection conn = DatabaseUtils.getConnection();

        String sql = "SELECT EMP_ID, STATUS FROM EMPLOYEE WHERE EMP_ID = ?";

        // try-with-resources -> tự động đóng PreparedStatement và ResultSet
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(empId));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("EMP_ID = " + rs.getInt("EMP_ID"));
                    System.out.println("STATUS = " + rs.getString("STATUS"));
                    return rs.getString("STATUS");
                }
            }
        }

        return "";
    }

    public static void closeConnection() {
        Connection conn = connectionHolder.get();
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionHolder.remove();
        }
    }
}
