package ultilities;

import java.sql.*;

public class DatabaseUtils123 {

    private static Connection conn;

    public static Connection getConnection(){
        String hostName = "localhost";
        String serviceName = "XEPDB1";
        String port = "1521";
        String userName = "sample_user";
        String password = "sample123";
        return getConnection(hostName,serviceName,port,userName,password);
    }

    public static Connection getConnection(String hostName,String serviceName,String port,String userName,String password) {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@//" + hostName + ":" + port + "/" + serviceName, userName, password);

            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public String getStatus(String empId) throws SQLException {

        Connection conn = DatabaseUtils123.getConnection();

        // Kiểm tra đang kết nối bằng user nào
        Statement st = conn.createStatement();
//        ResultSet rsUser = st.executeQuery("SELECT USER FROM DUAL");
//
//        if (rsUser.next()) {
//            System.out.println("Current User = " + rsUser.getString(1));
//        }

        String sql = "SELECT EMP_ID, STATUS FROM EMPLOYEE WHERE EMP_ID = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, Integer.parseInt(empId));

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            System.out.println("EMP_ID = " + rs.getInt("EMP_ID"));
            System.out.println("STATUS = [" + rs.getString("STATUS") + "]");

            return rs.getString("STATUS");
        }

        System.out.println("Không tìm thấy EMP_ID = " + empId);

        return "";
    }

    public static void closeConnection() {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}