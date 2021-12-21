public class Address {
    private String cityName;
    public String streetName;

    public Address(String cityName,String streetName){
        this.cityName=cityName;
        this.streetName=streetName;
    }
    public Address(){
        this.cityName=null;
        this.streetName=null;
    }


    public String getCityName(){
        return this.cityName;
    }
    public boolean initializedObject(){
       boolean initializedObject=false;
       if (this.cityName!=null && this.streetName!=null){
           initializedObject=true;
       }
       return initializedObject;
    }
    public void setCityName(String cityName) {
            this.cityName = cityName;
    }
    public String getStreetName(){
        return this.streetName;
    }
    public void setStreetName(String streetName){
            this.streetName = streetName;
    }
    public String toString (){
        String output;
        if (this.streetName.length()>0 && this.cityName.length()>0){
            output="The name of the city is : "+ this.cityName +
                    "\n The name of the street is : "+this.streetName;
        }
        else {
            output="There is no address .";
        }
        return output;
    }
}
