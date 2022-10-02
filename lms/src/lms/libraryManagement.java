package lms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.logging.Logger;

public class libraryManagement {

   
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        

	Class.forName("com.mysql.cj.jdbc.Driver");

	String url="jdbc:mysql://localhost:3306/library2";
	String username="root";
	String userpassword="root";


	Connection con=DriverManager.getConnection(url,username,userpassword);
	Logger logger = Logger.getLogger(libraryManagement.class.getName());

	if(con.isClosed())
	{
                                    logger.info("connection is close still..");


	}else
	{
                                    logger.info("Welcome To Shivam Library Management System");

				
	}

            
  
         while(true){
             

             logger.info("==========================================");
            logger.info("Enter 1 for add books.");
            logger.info("Enter 2 for delete books.");
            logger.info("Enter 3 for issue books.");
            logger.info("Enter 4 for return books.");
            logger.info("Enter 5 for books list.");
            logger.info("Enter 6 for students list.");
            logger.info("Enter 7 for search book.");
            logger.info("Enter 8 for search student.");
            logger.info("Enter 9 for exit.");


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(br.readLine());
            

            if(input==1){
                       operations.addBook();
            }
        

           else if(input==2){
                        operations.deleteBook();
            }
           

            else if(input==3){
                        operations.issueBook();
            }
            

            else if(input==4){
                       operations.returnBook();
            }
            

            else if(input==5){
                        operations.booksList();
            }
            

            else if(input==6){
                        operations.studentsList();
            }
            

            else if(input==7){
                        operations.searchBook();
            }
            

            else if(input==8){

                        operations.searchStudent();
            }
            

            else if(input==9){
                        logger.info("Thanks for visit.");
                        logger.info("Good bye...");
                        break;
            }
            

            else{
                        logger.info("Invalid Entry, Please try again...");
                        logger.info("Input must be between 1 to 9.");
            }
      }

    
   }

}

