public class User {
    private String userName;
    private String password;
    private String phoneNumber;
    private int kindOfUser;

    public User(String userName,String password,String phoneNumber, int isAMediator){
    this.userName=userName;
    this.password=password;
    this.phoneNumber=phoneNumber;
    this.kindOfUser =isAMediator;
    }
    public User(){
        this.userName=null;
        this.password=null;
        this.phoneNumber=null;
        this.kindOfUser=0;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public int getKindOfUser() {
        return kindOfUser;
    }
    public void setKindOfUser(int aMediator) {
        System.out.println("1 for mediator, 2 for user");
        if (kindOfUser == 1 || kindOfUser == 2) {
            this.kindOfUser = aMediator;
        } else {
            System.out.println("Invalid selection");
        }
    }
    public String toString (){
        String output= "Username: "+this.userName+
                "\npassword: "+this.password+
                "\nphone number: "+this.phoneNumber+
                "\nUser Secret: ";
        if (kindOfUser ==1){
            output+="Mediator";
        }
        else {
            output+="Ordinary user";
        }
        return output;
    }
}
