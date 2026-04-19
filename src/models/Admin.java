package models;

public class Admin extends User {
   private String adminID;
    private static int adminCount;
    
    public Admin() {
       this(" ", " ", " ", ' ', " ");   
    }
    public Admin(String loginID,String password,String name, char gender,String phoneNo){
    	super(loginID, password, name, gender, phoneNo);
        adminCount++;
        this.adminID = generateAdminID();
    }

    private String generateAdminID() {
        return "A" + String.format("%03d", adminCount);
    }
    //getters and setters
    public String getAdminID() {
        return adminID;
    }
    
    public void setAdminID(String adminID) {
    this.adminID = adminID;
}

//----------------------------Equals Method--------------------   
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    
    if (!(obj instanceof Admin)) return false;
    
    Admin other = (Admin) obj;
    return this.adminID.equals(other.adminID);
}
//---------------------------ToString Method--------------------  
    public String toString(){ 
    	return "Admin ID: "+ adminID +
    		    "\n" + super.toString();
    }
}