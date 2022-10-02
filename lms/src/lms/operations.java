package lms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;


public class operations {

   
    public static void addBook() throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Add boook");

         Connection con = ConnectionFactory.getConnection();
        String query = "insert into books(b_id, b_name, b_author, b_pic) values (?,?,?,?)";

        PreparedStatement pstmt = con.prepareStatement(query);

        while (true) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter book id");
        int bid = Integer.parseInt(br.readLine());

        System.out.println("Enter book name");
        String bname = br.readLine();

        System.out.println("Enter book author");
        String bauthor = br.readLine();

        System.out.println("Enter book pic name");
        String bpic = br.readLine();

        pstmt.setInt(1, bid);
        pstmt.setString(2, bname);
        pstmt.setString(3, bauthor);
        pstmt.setString(4, bpic);
        
         pstmt.addBatch();

            System.out.println("Success..");

            System.out.println("do you want to add more book [Y/N]");
            String ch = br.readLine();

            if (ch.equals("N")) {

                int r[] = pstmt.executeBatch();

                int s = 0;
                for (int i : r) {
                    s += i;
                }
                System.out.println("Book added successfully..");
                break;
            }
        }
    }

    
    public static void deleteBook() throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Delete boook");

        Connection con = ConnectionFactory.getConnection();
        String query = "delete from books where b_id=? && b_name=?";
        PreparedStatement pstmt = con.prepareStatement(query);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter book id");
        int bid = Integer.parseInt(br.readLine());

        System.out.println("Enter book name");
        String bname = br.readLine();

        pstmt.setInt(1, bid);
        pstmt.setString(2, bname);
        pstmt.executeUpdate();

        System.out.println("Book deleted successfully..");
    }

    
    public static void issueBook() throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Issue boook");

        Connection con = ConnectionFactory.getConnection();
        String que = "delete from books where b_id=? && b_name=?";
        String query = "insert into students(s_id, s_name, s_college, b_id, b_name) values (?,?,?,?,?)";

        PreparedStatement pst = con.prepareStatement(que);
        PreparedStatement pstmt = con.prepareStatement(query);

        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter student id");
        int sid = Integer.parseInt(br.readLine());

        System.out.println("Enter student name");
        String sname = br.readLine();

        System.out.println("Enter student college");
        String scollege = br.readLine();

        System.out.println("Enter book id");
        int bid = Integer.parseInt(br.readLine());

        System.out.println("Enter book name");
        String bname = br.readLine();

        pst.setInt(1, bid);
        pst.setString(2, bname);

        pst.executeUpdate();

        pstmt.setInt(1, sid);
        pstmt.setString(2, sname);
        pstmt.setString(3, scollege);
        pstmt.setInt(4, bid);
        pstmt.setString(5, bname);

        pstmt.executeUpdate();

        System.out.println("Book issued successfully..");
    }

    //  method for return book
    public static void returnBook() throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Return boook");

        Connection con = ConnectionFactory.getConnection();
        String que = "delete from students where s_id=? && b_id=?";
        String query = "insert into books(b_id, b_name, b_author, b_pic) values (?,?,?,?)";

        PreparedStatement pst = con.prepareStatement(que);
        PreparedStatement pstmt = con.prepareStatement(query);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter student id");
        int sid = Integer.parseInt(br.readLine());

        System.out.println("Enter book id");
        int bid = Integer.parseInt(br.readLine());

        System.out.println("Enter book name");
        String bname = br.readLine();

        System.out.println("Enter book author");
        String bauthor = br.readLine();

        System.out.println("Enter book pic");
        String bpic = br.readLine();

        pst.setInt(1, sid);
        pst.setInt(2, bid);

        pst.executeUpdate();

        pstmt.setInt(1, bid);
        pstmt.setString(2, bname);
        pstmt.setString(3, bauthor);
        pstmt.setString(4, bpic);

        pstmt.executeUpdate();

        System.out.println("Book returned successfully..");
    }

    
    public static void booksList() throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Books list");

        Connection con = ConnectionFactory.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("select * from books");

        ResultSetMetaData rsmd = res.getMetaData();
        int colNum = rsmd.getColumnCount();

        while (res.next()) {
            for (int i = 1; i < colNum; i++)
                System.out.print(res.getString(i) + "  ");
            System.out.println();
        }

    }

    
    public static void studentsList() throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Students list");

        Connection con = ConnectionFactory.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("select * from students ");

        ResultSetMetaData rsmd = res.getMetaData();
        int colNum = rsmd.getColumnCount();

        while (res.next()) {
            for (int i = 1; i < colNum; i++)
                System.out.print(res.getString(i) + "  ");
            System.out.println();
        }

    }

    
    public static void searchBook() throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Search book");

        Connection con = ConnectionFactory.getConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter book name");
        String bname = br.readLine();

        String query = "select  * from books where b_name like  ? ";
        PreparedStatement pstmt1=con.prepareStatement(query);
        pstmt1.setString(1,"%"+bname+"%");
        
        ResultSet res =pstmt1.executeQuery();
    
        ResultSetMetaData rsmd = res.getMetaData();
        int colNum = rsmd.getColumnCount();

        while (res.next()) {
            for (int i = 1; i < colNum; i++)
                System.out.print(res.getString(i) + "  ");
            System.out.println();
        }

    }

    
    public static void searchStudent() throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Search student");

        Connection con = ConnectionFactory.getConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter student id");
        int sid = Integer.parseInt(br.readLine());
        
        System.out.println("Enter student name");
        String sname = br.readLine();

        String query = "select  * from students where s_id = ?  && s_name=?";
        PreparedStatement pstmt=con.prepareStatement(query);
        pstmt.setInt(1,sid);
        pstmt.setString(2,sname);
        
        ResultSet res =pstmt.executeQuery();
    
        ResultSetMetaData rsmd = res.getMetaData();
        int colNum = rsmd.getColumnCount();

        while (res.next()) {
            for (int i = 1; i < colNum; i++)
                System.out.print(res.getString(i) + "  ");
            System.out.println();
        }

    }

}




