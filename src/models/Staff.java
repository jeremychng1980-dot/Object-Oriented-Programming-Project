package models;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Staff extends User {  
    
    private String staffID;
    private int staffCount;
    private Date hireDate;
    
    public Staff() {
       this(" ", " ", " ", ' ', " ", null);   
    }
    public Staff(String loginID,String password,String name, char gender,String phoneNo, Date hireDate){
    	super(loginID, password, name, gender, phoneNo);
        staffCount++;
        this.hireDate = hireDate;
        this.staffID = generateStaffID();
    }
    private String generateStaffID() {
        return "S" + String.format("%03d", staffCount);
    }
   //getters and setters 
        public String getStaffID() {
        return staffID;
    }
    
    public Date getHireDate(){
    	return hireDate;
    }
    
    public void setStaffID(String staffID) {
    this.staffID = staffID;
    }
    
    public void setHireDate(Date hireDate){
    	this.hireDate = hireDate;
    }
//---------------------------------Equaals Method--------------------------
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Staff other = (Staff) obj;
    return this.staffID.equals(other.staffID);
}
//--------------------------------ToString Method------------------------- 
    public String toString(){ 
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String hireDateStr = sdf.format(hireDate);
        
    	return "Staff ID: "+ staffID +
    		    "\n" + super.toString() +
    		    "\nHire Date: " + hireDateStr;
}
}