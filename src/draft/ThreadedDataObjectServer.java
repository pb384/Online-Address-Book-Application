/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draft;

/**
 *
 * @author Saraff
 */
import java.util.List;
import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ThreadedDataObjectServer{  
    
     
     
    public static void main(String[] args){  
      try 
      {  
          ServerSocket s = new ServerSocket(3000);
          for (;;){  
             Socket incoming = s.accept( );
             new ThreadedDataObjectHandler(incoming).start();
             }   
      }
      catch (Exception e){  
          System.out.println(e);
      } 
   } 
}

class ThreadedDataObjectHandler extends Thread{ 
   
    ResultSet rs = null;
    
    public ThreadedDataObjectHandler(Socket i) { 
   	incoming = i;
   }
   
   public void run()
   {  
    try { 	
         ObjectInputStream in =new ObjectInputStream(incoming.getInputStream());
         ObjectOutputStream out = new ObjectOutputStream(incoming.getOutputStream());
         
         myObject = (LoginDataObject)in.readObject();
         
         String msg_value = myObject.getMessage();
         
         if(msg_value.equals("AdminCredentials")){
             
            String uid = myObject.getUsername();
            String pid =myObject.getPassword();
            try{ 
             Statement stmt = DBConnection.getConnection();
             rs=stmt.executeQuery("Select username, password from myaccess where username = '"+uid+"';");
             try{
                 while(rs.next()){
                     myObject.setUsername(rs.getString("username"));
                     myObject.setPassword(rs.getString("password"));
                 }
             }catch(Exception e){
                 System.out.println(e);
             }finally{
                 try {
                     rs.close();
                     stmt.close();
                    }catch (SQLException e) {
                        System.out.println(e);
                    }
             }
            }catch(Exception e){
                System.out.println(e);
            }
            
            
            
         }else if(msg_value.equals("EmpCredentials")){
             String uid = myObject.getEid();
             try{ 
             Statement stmt = DBConnection.getConnection();
             rs=stmt.executeQuery("Select * from emp_table where EmpID = '"+uid+"';");
             try{
                 while(rs.next()){
                     myObject.setEid(rs.getString(1));
                     myObject.setSFname(rs.getString(2));
                     myObject.setSLname(rs.getString(3));
                     myObject.setSGender(rs.getString(4));
                     myObject.setSPhone(rs.getString(5));
                     myObject.setSEmail(rs.getString(6));
                     myObject.setSStreet(rs.getString(7));
                     myObject.setSApt(rs.getString(8));
                     myObject.setSCity(rs.getString(9));
                     myObject.setSState(rs.getString(10));
                     myObject.setSZip(rs.getString(11));
                     myObject.setPassword(rs.getString(12));
                 }
             }catch(Exception e){
                 System.out.println(e);
             }finally{
                 try {
                     rs.close();
                     stmt.close();
                    }catch (SQLException e) {
                        System.out.println(e);
                    }
             }
            }catch(Exception e){
                System.out.println(e);
            }
         }
         
         
     
         else if(msg_value.equals("AdminSearch") || msg_value.equals("EmpSearch")){
             String eid = myObject.getEid();
             String ename = myObject.getEname();
                List<String> id = new ArrayList<String>();
                List<String> fn=new ArrayList<String>();
                List<String> ln=new ArrayList<String>();
                List<String> gen=new ArrayList<String>();
                List<String> ph=new ArrayList<String>();
                List<String> em=new ArrayList<String>();
                List<String> st=new ArrayList<String>();
                List<String> ap=new ArrayList<String>();
                List<String> ci=new ArrayList<String>();
                List<String> stt=new ArrayList<String>();
                List<String> zp=new ArrayList<String>();
                
                Integer cnt =0;
             
             try{
                 Statement stmt = DBConnection.getConnection();
                 try{
                    if(!eid.trim().isEmpty() && !ename.trim().isEmpty()){
                        String query = "select * from emp_table where EmpId like '%"+eid+"%' AND FName like '%"+ename+"%' or LName like '%"+ename+"%';";
                        rs=stmt.executeQuery(query);
                        if (!rs.isBeforeFirst() ) {    
                            myObject.setError(true);
                            } else{
                            myObject.setError(false);
                        }
                    }else if(!eid.trim().isEmpty()){
                        String query = "select * from emp_table where EmpId like '%"+eid+"%';";
                        rs=stmt.executeQuery(query);
                        myObject.setError(false);
                    }else if(!ename.trim().isEmpty()){
                        String query = "select * from emp_table where FName like '%"+ename+"%' or LName like '%"+ename+"%';";
                        rs=stmt.executeQuery(query);
                        myObject.setError(false);
                    }else{
                        String query = "select * from emp_table;";
                        rs=stmt.executeQuery(query);
                        myObject.setError(false);
                    }
                    }catch(SQLException e){
                        System.out.println(e);
                    }
                 try{
                    while(rs.next()){
                        id.add(rs.getString(1));
                        //System.out.println(rs.getString(1));
                        fn.add(rs.getString(2));
                        ln.add(rs.getString(3));
                        gen.add(rs.getString(4));
                        ph.add(rs.getString(5));
                        em.add(rs.getString(6));
                        st.add(rs.getString(7));
                        ap.add(rs.getString(8));
                        ci.add(rs.getString(9));
                        stt.add(rs.getString(10));
                        zp.add(rs.getString(11));  
                     
                        cnt++;
                    } 
                    }catch(SQLException e){
                        System.out.println(e);
                    }finally{
                        try{
                            rs.close();
                            stmt.close();
                        }catch(SQLException e){
                            System.out.println(e);
                        }
                    }
             }catch(Exception e){
                 System.out.println(e);
             }
             myObject.setEmpID(id);
             myObject.setFname(fn);
             myObject.setLname(ln);
             myObject.setGender(gen);
             myObject.setPhone(ph);
             myObject.setEmail(em);
             myObject.setStreet(st);
             myObject.setApt(ap);
             myObject.setCity(ci);
             myObject.setState(stt);
             myObject.setZip(zp);
             myObject.setCount(cnt);
            System.out.println(myObject.getEmpID());
            
         }else if(msg_value.equals("AddEmployee")){
            String Fname = myObject.getSFname();
            String Lname = myObject.getSLname();
            String Gender = myObject.getSGender();
            String Phone = myObject.getSPhone();
            String EMail = myObject.getSEmail();
            String Street = myObject.getSStreet();
            String Apt = myObject.getSApt();
            String City = myObject.getSCity();
            String State = myObject.getSState();
            String Zip = myObject.getSZip();
            String Password = myObject.getPassword();
            
            try{
                Statement stmt = DBConnection.getConnection();
                try{
                    if(!Fname.trim().isEmpty() && !Lname.trim().isEmpty()){
                        String query = "insert into emp_table(FName,LName,Gender,Phone,email,Street_Address,Apt,City,State,ZipCode,Password) values ('"+Fname+"','"+Lname+"','"+Gender+"','"+Phone+"','"+EMail+"','"+Street+"','"+Apt+"','"+City+"','"+State+"','"+Zip+"','"+Password+"');";
                        stmt.executeUpdate(query);
                      //  int autoIncKeyFromApi = -1;
                        rs = stmt.getGeneratedKeys();
                        myObject.setEid(rs.getString(1));
                    }  
                }catch(SQLException e){
                    System.out.println(e);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
         }else if(msg_value.equals("UpdateEmployee")){
            String Eid = myObject.getEid();
            String Fname = myObject.getSFname();
            String Lname = myObject.getSLname();
            String Gender = myObject.getSGender();
            String Phone = myObject.getSPhone();
            String EMail = myObject.getSEmail();
            String Street = myObject.getSStreet();
            String Apt = myObject.getSApt();
            String City = myObject.getSCity();
            String State = myObject.getSState();
            String Zip = myObject.getSZip();
            try{
                Statement stmt = DBConnection.getConnection();
                try{
                    if(!Eid.trim().isEmpty()){
                        String query = "update emp_table set FName ='"+Fname+"',LName='"+Lname+"',Gender='"+Gender+"',Phone='"+Phone+"',email='"+EMail+"',Street_Address='"+Street+"',Apt='"+Apt+"',City='"+City+"',State='"+State+"',ZipCode='"+Zip+"' where EmpId='"+Eid+"';";
                        stmt.executeUpdate(query);
                        myObject.setError(false);
                    }  
                }catch(SQLException e){
                    System.out.println(e);
                }
            }catch(Exception e){
                System.out.println(e);
            }
               
         }else if(msg_value.equals("UpdateMyInfo")){
           String Eid = myObject.getEid();
            String Fname = myObject.getSFname();
            String Lname = myObject.getSLname();
            String Gender = myObject.getSGender();
            String Phone = myObject.getSPhone();
            String EMail = myObject.getSEmail();
            String Street = myObject.getSStreet();
            String Apt = myObject.getSApt();
            String City = myObject.getSCity();
            String State = myObject.getSState();
            String Zip = myObject.getSZip();
            String Password = myObject.getPassword();
            try{
                Statement stmt = DBConnection.getConnection();
                try{
                    if(!Eid.trim().isEmpty()){
                        String query = "update emp_table set FName ='"+Fname+"',LName='"+Lname+"',Gender='"+Gender+"',Phone='"+Phone+"',email='"+EMail+"',Street_Address='"+Street+"',Apt='"+Apt+"',City='"+City+"',State='"+State+"',ZipCode='"+Zip+"', Password='"+Password+"' where EmpId='"+Eid+"';";
                        stmt.executeUpdate(query);
                        myObject.setError(false);
                    }  
                }catch(SQLException e){
                    System.out.println(e);
                }
            }catch(Exception e){
                System.out.println(e);
            }             
         }
         else if(msg_value.equals("DeleteEmployee")){
             String Eid = myObject.getEid();
             try{
                Statement stmt = DBConnection.getConnection();
                try{
                    if(!Eid.trim().isEmpty()){
                        String query = "delete from emp_table where EmpId='"+Eid+"';";
                        stmt.executeUpdate(query);
                        myObject.setError(false);
                    }  
                }catch(SQLException e){
                    System.out.println(e);
                }
            }catch(Exception e){
                System.out.println(e);
            }
         }
         
         else{
             System.out.println("invalid message value");
         }
         
         out.writeObject(myObject);
         in.close();
         out.close();
         incoming.close();    
     }
   catch (Exception e){  
     System.out.println(e);
   } 
   }
   
   LoginDataObject myObject = null;
   private Socket incoming; 
}
