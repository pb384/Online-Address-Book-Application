/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draft;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saraff
 */
public class LoginDataObject extends DataObject{
    protected String username;
    protected String password;
    protected String eid;
    protected String ename;
    
    protected Boolean error;
    protected List<String> empID = new ArrayList<String>();
    protected List<String> fname=new ArrayList<String>();
    protected List<String> lname=new ArrayList<String>();
    protected List<String> gender=new ArrayList<String>();
    protected List<String> phone=new ArrayList<String>();
    protected List<String> email=new ArrayList<String>();
    protected List<String> street=new ArrayList<String>();
    protected List<String> apt=new ArrayList<String>();
    protected List<String> city=new ArrayList<String>();
    protected List<String> state=new ArrayList<String>();
    protected List<String> zip=new ArrayList<String>();
  
    protected Integer count = 0;
    
    protected String sempID;
    protected String sfname;
    protected String slname;
    protected String sgender;
    protected String sphone;
    protected String semail;
    protected String sstreet;
    protected String sapt;
    protected String scity;
    protected String sstate;
    protected String szip;
    
    
    	
        LoginDataObject(){
                username = "";
                password = "";
                
              
                
	}

        public String getUsername(){
		return username;
	}
	public void setUsername(String inMessage){
		username = inMessage;
	}
        
	public String getPassword(){
		return password;
	}
	public void setPassword(String inMessage){
		password = inMessage;
	}
        
        public String getEid(){
		return eid;
	}
	public void setEid(String inMessage){
		eid = inMessage; 
        }
        
        public String getEname(){
		return ename;
	}
	public void setEname(String inMessage){
		ename = inMessage; 
        }
        
        
        public List<String> getEmpID(){
		return empID;
	}
	public void setEmpID(List<String> inMessage){
		empID = inMessage; 
        }
        
        public List<String> getFname(){
		return fname;
	}
	public void setFname(List<String> inMessage){
		fname = inMessage; 
        }
        
        public List<String> getLname(){
		return lname;
	}
	public void setLname(List<String> inMessage){
		lname = inMessage; 
        }
        
        public List<String> getGender(){
		return gender;
	}
	public void setGender(List<String> inMessage){
		gender = inMessage; 
        }
        
        public List<String> getPhone(){
		return phone;
	}
	public void setPhone(List<String> inMessage){
		phone = inMessage; 
        }
        
        public List<String> getEmail(){
		return email;
	}
	public void setEmail(List<String> inMessage){
		email = inMessage; 
        }
        
        public List<String> getStreet(){
		return street;
	}
	public void setStreet(List<String> inMessage){
		street = inMessage; 
        }
        
        public List<String> getApt(){
		return apt;
	}
	public void setApt(List<String> inMessage){
		apt = inMessage; 
        }
        
        public List<String> getCity(){
		return city;
	}
	public void setCity(List<String> inMessage){
		city = inMessage; 
        }
        
        public List<String> getState(){
		return state;
	}
	public void setState(List<String> inMessage){
		state = inMessage; 
        }
        
        public List<String> getZip(){
		return zip;
	}
	public void setZip(List<String> inMessage){
		zip = inMessage; 
        }
        
        public Boolean getError(){
		return error;
	}
	public void setError(Boolean inMessage){
		error = inMessage; 
        }
        
        public Integer getCount(){
		return count;
	}
	public void setCount(Integer inMessage){
		count = inMessage; 
        }
        
        public String getSFname(){
		return sfname;
	}
	public void setSFname(String inMessage){
		sfname = inMessage;
	}
        
        public String getSLname(){
		return slname;
	}
	public void setSLname(String inMessage){
		slname = inMessage;
	}
        
        public String getSGender(){
		return sgender;
	}
	public void setSGender(String inMessage){
		sgender = inMessage;
	}
        
        public String getSPhone(){
		return sphone;
	}
	public void setSPhone(String inMessage){
		sphone = inMessage;
	}
        
        public String getSEmail(){
		return semail;
	}
	public void setSEmail(String inMessage){
		semail = inMessage;
	}
       
        public String getSStreet(){
		return sstreet;
	}
	public void setSStreet(String inMessage){
		sstreet = inMessage;
	}
        
        public String getSApt(){
		return sapt;
	}
	public void setSApt(String inMessage){
		sapt = inMessage;
	}
        
        public String getSCity(){
		return scity;
	}
	public void setSCity(String inMessage){
		scity = inMessage;
	}
        
        public String getSState(){
		return sstate;
	}
	public void setSState(String inMessage){
		sstate = inMessage;
	}
        
        public String getSZip(){
		return szip;
	}
	public void setSZip(String inMessage){
		szip = inMessage;
	}
}
