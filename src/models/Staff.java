package models;

public class Staff extends User {  
    
    private String staffID;
    private int staffCount;
    
    public Staff() {
       this(" ", " ", " ", ' ', " ");   
    }
    public Staff(String loginID,String password,String name, char gender,String phoneNo){
    	super(loginID, password, name, gender, phoneNo);
        staffCount++;
        this.staffID = generateStaffID();
    }
    private String generateStaffID() {
        return "S" + String.format("%03d", staffCount);
    }
   //getters and setters 
        public String getStaffID() {
        return staffID;
    }
    
    public void setStaffID(String staffID) {
    this.staffID = staffID;
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
    	return "Staff ID: "+ staffID +
    		    "\n" + super.toString();
}
}