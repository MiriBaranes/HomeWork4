public class Property {
    private Address address;
    private int numberOfRooms;
    private double price;
    private int typeOfApartment;
    private boolean forRent;
    private int houseNumber;
    private int floorNumber;
    private User advertiser;

    public Property(Address address,int numberOfRooms,double price, int typeOfApartment,boolean forRent,int houseNumber,int floorNumber,User advertiser){
        this.address=address;
        this.numberOfRooms=numberOfRooms;
        this.price=price;
        this.typeOfApartment=typeOfApartment;
        this.forRent=forRent;
        this.houseNumber=houseNumber;
        this.floorNumber=floorNumber;
        this.advertiser=advertiser;
    }
    public Address getAddress(){
        return this.address;
    }
    public void setAddress(Address adders){
        this.address=adders;
    }
    public int getNumberOfRooms(){
        return this.numberOfRooms;
    }
    public void setNumberOfRooms(int numberOfRooms){
        if (numberOfRooms > 0) {
            this.numberOfRooms=numberOfRooms;
        }
        else {
            System.out.println("Invalid selection");
        }
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        if (price>0) {
            this.price = price;
        }
        else {
            System.out.println("Invalid selection");
        }
    }
    public int getTypeOfApartment(){
        return this.typeOfApartment ;
    }
    public void setTypeOfApartment(int typeOfApartment) {
        this.typeOfApartment = typeOfApartment;
    }
    public boolean isForRent() {
        return forRent;
    }
    public void setForRent(boolean forRent){
        this.forRent=forRent;
    }
    public int getHouseNumber(){
        return this.houseNumber;
    }
    public void setHouseNumber(int houseNumber){
        if (houseNumber>0) {
            this.houseNumber = houseNumber;
        }
        else {
            System.out.println("Invalid selection");
        }
    }
    public int getFloorNumber(){
        return this.floorNumber;
    }
    public void setFloorNumber(int floorNumber){
        this.floorNumber=floorNumber;
    }
    public User getAdvertiser(){
        return this.advertiser;
    }
    public void setAdvertiser(User advertiser){
        this.advertiser=advertiser;
    }
    public String toString (){
        String output= "Here are the details\n"+
                "Property address : "+this.address+
                "\nType of apartment: ";
        if (this.typeOfApartment==1){
            output+="Ordinary apartment in an apartment building";
        }
        else if (this.typeOfApartment==2){
            output+="Penthouse in an apartment building";
        }
        else if (this.typeOfApartment==3){
            output+="private house";
        }
                output+="\nFor rent? ";
        if (!this.forRent){
            output+= "The house is for sale";
        }
        else {
            output+="yes";
        }
               output+="\nNumber of rooms in the apartment: "+this.numberOfRooms+
                "\nThe house number : "+this.houseNumber;
        if (this.floorNumber!=0) {
            output+="\nFloor number :" + this.floorNumber;
        }
                output+="\nThe price of the apartment : "+this.price+
                "\nAdvertiser Details "+this.advertiser;

        return output;
    }
}
