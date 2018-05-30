package college_library;
import static java.lang.System.*;
import java.util.*;
import java.sql.*;

class books_view
{
Scanner t1 = new Scanner(in);   
void list_books()
{
out.println("------------------------------");
out.println("BID\tTITLE\tSUBJECT\tAUTHOR\tSTATUS"); //
    try
    {Class.forName("com.mysql.jdbc.Driver");}
    catch(ClassNotFoundException e)
    {err.println("Error11 - "+e.getMessage());}
    String url = "jdbc:mysql://localhost:3306/library";
    try(Connection con = DriverManager.getConnection(url,"root","nedi123456"))
    {
        String sql_3 = "select * from books";
        Statement st = con.createStatement();        
        ResultSet rs = st.executeQuery(sql_3);
        while(rs.next())
        {
        int bid = rs.getInt("bid");
        String title = rs.getString("title");
        String subject = rs.getString("subject");
        String author = rs.getString("author");
        String status = rs.getString("status");
        out.println(bid+" "+title+" "+subject+" "+author+" "+status);//
        }
    }
    catch (Exception ex)
    {out.println("error - "+ex.getMessage());}

out.println("------------------------------");
out.println("------------------------------");
}
void search_books()
{
out.println("SEARCH BOOK HERE:"); //
out.print("ENTER TEXT TO SEARCH : "); //
String text = this.t1.nextLine();
    try
    {Class.forName("com.mysql.jdbc.Driver");}
    catch(ClassNotFoundException e)
    {err.println("Error11 - "+e.getMessage());}
    String url = "jdbc:mysql://localhost:3306/library";
   // out.println(text+" 1111111");
    try(Connection con = DriverManager.getConnection(url,"root","nedi123456"))
    {
     //   out.println(text);
        String sql_4_1 = "select * from books where (title = '"+text+"' or subject = '"+text+"' or status = '"+text+"')";
        Statement st = con.createStatement();        
        ResultSet rs = st.executeQuery(sql_4_1);       
        while(rs.next())
        {            
        int bid = rs.getInt("bid");
        String title = rs.getString("title");
        String subject = rs.getString("subject");
        String author = rs.getString("author");
        String status = rs.getString("status");
        out.println(bid+" "+title+" "+subject+" "+author+" "+status);//
        }        
    }
    catch (Exception ex)
    {out.println("error - "+ex.getMessage());}
}
}
class employee extends books_view
{
int eid;
employee(int eid)
{
this.eid=eid;
out.println("Select the following options - ");
out.print("1. for Add book\n2. for delete book\n3. for list all books\n4. for search book\n5. for issue book\n6. for Add new employee\n7. for return of book update \n8. for Exit\n");
}
Scanner t = new Scanner(in);
int choice()
{
int choice1 = Integer.parseInt(t.nextLine());
return choice1;
}        
void add_book()
{
out.println("ADD NEW BOOK HERE:");
out.print("Enter title: ");//
String title = this.t.nextLine();
out.print("Enter subject: ");//
String subject = this.t.nextLine();
out.print("Enter author: ");//
String author = this.t.nextLine();
    try
    {Class.forName("com.mysql.jdbc.Driver");}
    catch(ClassNotFoundException e)
    {err.println("Error11 - "+e.getMessage());}
    String url = "jdbc:mysql://localhost:3306/library";
    try(Connection con = DriverManager.getConnection(url,"root","nedi123456"))
    {
        String sql_1 = "insert into books(title,subject,author) values ('"+title+"','"+subject+"','"+author+"')";
        Statement st = con.createStatement();        
        int x = st.executeUpdate(sql_1);
        if (x>0)
        {out.println("******NEW BOOK ADDED*****");}
        else
        {out.println("SYSTEM PROBLEM");}
    }
    catch (Exception ex)
    {out.println("error - "+ex.getMessage());}    
}
void del_book()
{
out.println("DELETE BOOK HERE:");
out.print("Enter Book ID: ");//
int bid = Integer.parseInt(this.t.nextLine());
int x;
try
    {Class.forName("com.mysql.jdbc.Driver");}
    catch(ClassNotFoundException e)
    {err.println("Error11 - "+e.getMessage());}
    String url = "jdbc:mysql://localhost:3306/library";
    try(Connection con = DriverManager.getConnection(url,"root","nedi123456"))
    {
        String sql_2 = "delete from books where bid = "+bid;
        Statement st = con.createStatement();         
        x = st.executeUpdate(sql_2);
        if (x>0)
        {out.println("******BOOK HAS BEEN DELETED*****");}
        else
        {out.println("WRONG ENTRY!!!!");}
    }
    catch (Exception ex)
    {out.println("error - "+ex.getMessage());}
}
void issue()
{
out.print("ENTER BOOK ID: ");//
String bid = this.t.nextLine();
out.print("ENTER STUDENT ROLL NO.: ");//
int roll = Integer.parseInt(this.t.nextLine());
try
{Class.forName("com.mysql.jdbc.Driver");}
    catch(ClassNotFoundException e)
    {err.println("Error11 - "+e.getMessage());}
    String url = "jdbc:mysql://localhost:3306/library";
    try(Connection con = DriverManager.getConnection(url,"root","nedi123456"))
    {
        String sql_5_check_1 = "select * from books where bid = "+bid;
        String sql_5_check_2 = "select * from student where roll = "+roll;
        Statement st = con.createStatement(),s_t=con.createStatement();          
        ResultSet rs = st.executeQuery(sql_5_check_1);
        ResultSet rs_1 = s_t.executeQuery(sql_5_check_2);
        if (rs.next()==true && rs_1.next()==true)
        {
            String status = rs.getString("status");
            if (status.equals("available"))
            {
                String sql_5 = "insert into issue values("+bid+","+roll+","+this.eid+")";
                String sql_up = "update books set status = 'issued' where bid = "+bid;
                Statement st1 = con.createStatement();
                Statement st2 = con.createStatement();
                int y = st1.executeUpdate(sql_5);
                int z = st2.executeUpdate(sql_up);
                if (y>0 && z>0)                    
                {out.println("******BOOK HAS BEEN ISSUED*****");}
                else
                {out.println("SOFTWARE PROBLEM");}
                
            }
            else
            {out.println("*****BOOK HAS BEEN PREVIOUSLYY ISSUED*****");}
        }
        else 
        {out.println("WRONG ENTRY!!!!");}
    }
    catch (Exception ex)
    {out.println("error - "+ex.getMessage());}
}
void add_new_employee()
{
out.println("REGISTER NEW EMPLOYEE");
out.println("ENTER DETAILS");//
out.print("EMP ID: ");//
int empid = Integer.parseInt(this.t.nextLine());
out.print("NAME: ");//
String name = this.t.nextLine();
out.print("DEPT: ");//
String dept = this.t.nextLine();
out.print("DATE Of JOINING: ");//
String doj= this.t.nextLine();
out.print("SALARY: ");//
int sal = Integer.parseInt(this.t.nextLine());
    try
    {Class.forName("com.mysql.jdbc.Driver");}
    catch(ClassNotFoundException e)
    {err.println("Error11 - "+e.getMessage());}
    String url = "jdbc:mysql://localhost:3306/library";
    try(Connection con = DriverManager.getConnection(url,"root","nedi123456"))
    {
        String sql_1 = "insert into employee values ("+empid+",'"+name+"','"+dept+"','"+doj+"',"+sal+")";        
        Statement st = con.createStatement();        
        int x = st.executeUpdate(sql_1);
        if (x>0)
        {
            out.println("******NEW EMPLOYEE ADDED*****");
            out.println("LOGIN DETAILS FOR PANEL ACCESS");
            out.println("LOGIN ID - "+empid);//
            out.print("Enter Password - ");    //        
            String pass = this.t.nextLine();
            String sql_2 = "insert into login values ('"+empid+"','"+pass+"','"+name+"',"+1+")";
            int x1 = st.executeUpdate(sql_2);
            if (x1>0)
            {out.println("THANK YOU");}
            else
            {out.println("SYSTEM PROBLEM");}
        }
        else
        {out.println("SYSTEM PROBLEM");}        
    }
    catch (Exception ex)
    {out.println("error - "+ex.getMessage());}    

}
void return_book()
{
out.println("FOR RETURNING BOOK");   
out.print("Enter book ID: ");//
String bid = this.t.nextLine();
try
{Class.forName("com.mysql.jdbc.Driver");}
    catch(ClassNotFoundException e)
    {err.println("Error11 - "+e.getMessage());}
    String url = "jdbc:mysql://localhost:3306/library";
    try(Connection con = DriverManager.getConnection(url,"root","nedi123456"))
    {
        String sql_5_check_1 = "select * from books where bid = "+bid;        
        Statement st = con.createStatement();          
        ResultSet rs = st.executeQuery(sql_5_check_1);        
        if (rs.next()==true)
        {
            String status = rs.getString("status");
            if (status.equals("issued"))
            {                
                String sql_up = "update books set status = 'available' where bid = "+bid;
                String sql_del = "delete from issue where book = "+bid;
                Statement st1 = con.createStatement();
                Statement st2 = con.createStatement();
                int y = st1.executeUpdate(sql_del);
                int z = st2.executeUpdate(sql_up);
                if (y>0 && z>0)                    
                {out.println("DATABASE HAS BEEN UPDATED SUCCESSFULLY");}
                else
                {out.println("SOFTWARE PROBLEM");}
                
            }
            else
            {out.println("BOOK EXISTS BUT HAS NOT BEEN ISSUED TO ANYONE!!!");}
        }
        else 
        {out.println("WRONG ENTRY!!!!");}
    }
    catch (Exception ex)
    {out.println("error - "+ex.getMessage());}
}
}
class Student extends books_view
{
int roll;
Scanner t = new Scanner(in);
Student(int user)
{this.roll = user;}
int choice()
{
out.println("Select the following options - ");
out.println("1. for list all books\n2. for search book\n3. for exit");
int c = Integer.parseInt(t.nextLine());
return c;
}
}
public class College_library 
{
    void login()
    {
    Scanner t = new Scanner(in);
    out.print("Username: ");//
    int user = Integer.parseInt(t.nextLine());
    out.print("Password: ");//
    String pass = t.nextLine();
    try
    {Class.forName("com.mysql.jdbc.Driver");}
    catch(ClassNotFoundException e)
    {err.println("Error11 - "+e.getMessage());}
    String url = "jdbc:mysql://localhost:3306/library";
    try(Connection con = DriverManager.getConnection(url,"root","nedi123456"))
    {
        String sql = "select * from login where lid = "+user+" and pass = '"+pass+"'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()==false)
        {
        out.println("Wrong credentials");
        return ;
        }
        int type = rs.getInt("role");
        if (type==1)
        {
        while(true)
        {
        employee e = new employee(user);
        int choice1 = e.choice();
        //1. for Add book\n2. for delete book\n3. for list all books\n4. for search book\n5. for issue book\n6. for Add new employee\n7. for return of book update \n8.for Exit
        if (choice1==1)
        {e.add_book();}        
        if (choice1==2)
        {e.del_book();}
        if (choice1==3)
        {e.list_books();}
        if (choice1==4)
        {e.search_books();}
        if (choice1==5)
        {e.issue();}
        if (choice1==6)
        {e.add_new_employee();}
        if (choice1==7)
        {e.return_book();}
        if (choice1==8)
        {break;}
        }
        }
        else
        {
        while(true)
        {
        Student s1 = new Student(user);
        int c1 = s1.choice();
        if (c1==1)
        {s1.list_books();}
        else if (c1==2)
        {s1.search_books();}
        else
        {break;}
        }
        }
        }        
    catch (SQLException ex) 
    {out.println("Error in SQLException - "+ex.getMessage());}
    }        
    void register_new_student()
    {
    Scanner t = new Scanner(in);
    out.println("REGISTER NEW STUDENT HERE");
    out.println("ENTER DETAILS");
    out.print("ROLL NO.: ");//
    int r = Integer.parseInt(t.nextLine());
    out.print("NAME: ");//
    String name = t.nextLine();
    out.print("DEPT: ");//
    String dept = t.nextLine();
    out.print("SEMESTER: ");//
    String s= t.nextLine();
    out.print("BATCH: ");//
    int b = Integer.parseInt(t.nextLine());
    try
    {Class.forName("com.mysql.jdbc.Driver");}
    catch(ClassNotFoundException e)
    {err.println("Error11 - "+e.getMessage());}
    String url = "jdbc:mysql://localhost:3306/library";
    try(Connection con = DriverManager.getConnection(url,"root","nedi123456"))
    {
        String sql_1 = "insert into student values ("+r+",'"+name+"','"+dept+"','"+s+"','"+b+"')";        
        Statement st = con.createStatement();        
        int x = st.executeUpdate(sql_1);
        if (x>0)
        {
            out.println("******NEW STUDENT ADDED*****");
            out.println("LOGIN DETAILS FOR PANEL ACCESS");
            out.println("LOGIN ID - "+r);//
            out.print("Enter Password - ");//            
            String pass = t.nextLine();
            String sql_2 = "insert into login values ('"+r+"','"+pass+"','"+name+"',"+2+")";
            int x1 = st.executeUpdate(sql_2);
            if (x1>0)
            {out.println("THANK YOU");}
            else
            {out.println("SYSTEM PROBLEM");}
        }
        else
        {out.println("SYSTEM PROBLEM");}        
    }
    catch (Exception ex)
    {out.println("error - "+ex.getMessage());}    

    }    
    public static void main(String[] args) 
    {
        Scanner t = new Scanner(in);
        College_library l = new College_library();
        while(true)
        {
            out.println("Select the choice:");
            out.print("1. For login\n2. For register for login\n3. For Exit\n");
            int choice = Integer.parseInt(t.nextLine());
            if (choice==3)
            {break;}
            if (choice==1)
            {l.login();}
            else
            {l.register_new_student();}
        }
    }    
}