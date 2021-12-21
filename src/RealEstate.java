
import java.util.Arrays;
import java.util.Scanner;

public class RealEstate {
    public static final String START_PHONE_NUMBER = "05";
    public static final String VALID_CHARS_FOR_PASSWORD = "%$_";
    private User[] users;
    private Property[] properties;
    private Address[] addresses;

    public RealEstate(Address [] address) {
        int count = 0;
        this.users = new User[0];
        this.properties = new Property[0];
        this.addresses = new Address[10];
        if (validAddresses(address)){
            this.addresses=address;
        }
        else {
            System.out.println("Must have at least three different cities.");
        }

    }

    public Address[] getAddresses() {
        return this.addresses;
    }
    public boolean validAddresses(Address [] addresses) {
        boolean validAddresses = false;
        int count=0;
        for (int i=0; i<addresses.length; i++){
            if (count>4){
                break;
            }
            for (int j=i+1; j<addresses.length; j++){
                if (addresses[i].getCityName().equals(addresses[j].getCityName())){
                    count++;
                    break;
                }
            }
        }
        if (count>4) {
            validAddresses = true;
        }
        return validAddresses;
    }

    public void setAddresses(Address[] addresses) {
        if (validAddresses(addresses)){
            this.addresses=addresses;
        }
        else {
            System.out.println("improper list");
        }
    }


    public Property [] getProperties(){
        return this.properties;
    }
    public void setProperties(Property [] properties){
        this.properties=properties;
    }
    public void createUser(){
        Scanner scanner= new Scanner(System.in);
        String userName;
        String password;
        String phoneNumber;
        int aMediator;
        do {
            System.out.println("Enter username: ");
            userName=scanner.nextLine();
        }while (existUserName(userName));

        do {
            System.out.println("Enter a password: ");
            password=scanner.nextLine();
        }while (!isStrongPassword(password));
        do {
            System.out.println("Enter your phone number: ");
            phoneNumber=scanner.nextLine();
        }while (!isProperPhoneNumber(phoneNumber));
        do {
            System.out.println("If you are a mediator press 1"+
                    "\nYou are a regular user press 2");
            aMediator=scanner.nextInt();
        }while (!ordinaryMediatorOrUser(aMediator));
        User newUser = new User(userName,password,phoneNumber,aMediator);
        addUserToArray(newUser);
    }
    private boolean existUserName (String userName){
        boolean existUserName=false;
        for (int i=0; i< this.users.length; i++){
            User currentUser=users[i];
            if (currentUser.getUserName().equals(userName)){
                existUserName=true;
                break;
            }
        }
        return existUserName;
    }
    private boolean isStrongPassword(String password){
        boolean strong=false;
        boolean digit=false;
        boolean note=false;

        for (int i=0; i<password.length();i++){
            char currentChar=password.charAt(i);
            if (Character.isDigit(currentChar)){
                digit=true;
            }
            else if (currentChar== VALID_CHARS_FOR_PASSWORD.charAt(0)|| currentChar==VALID_CHARS_FOR_PASSWORD.charAt(1)|| currentChar==VALID_CHARS_FOR_PASSWORD.charAt(2)){
                note=true;
            }
        }
        if (digit&&note){
            strong=true;
        }
        return strong;
    }
    private void addPropertyToArray (Property propertyToAdd){
        Property[] newPropertyArray = new Property[this.properties.length+1];
        for (int i=0; i< this.properties.length; i++){
            newPropertyArray[i]=this.properties[i];
        }
        newPropertyArray[this.properties.length]=propertyToAdd;
        this.properties=newPropertyArray;
    }
    private void addUserToArray (User userToAdd){
        User[] newUserArray = new User[this.users.length+1];
        for (int i=0; i< this.users.length; i++){
            newUserArray[i]=this.users[i];
        }
        newUserArray[this.users.length]=userToAdd;
        this.users=newUserArray;
    }
    private boolean isProperPhoneNumber (String phoneNumber){
        boolean isProperPhoneNumber=false;
        String start = phoneNumber.substring(0,2);
        if (start.equals(START_PHONE_NUMBER)){
            if (phoneNumber.length()==10){
                isProperPhoneNumber=true;
            }
        }
        return isProperPhoneNumber;
    }
    private boolean ordinaryMediatorOrUser(int mediatorOrUser){
        boolean invalidSelection=false;
        if (mediatorOrUser==1||mediatorOrUser==2){
        invalidSelection=true;
        }
        return invalidSelection;
    }
    public User login(){
        Scanner scanner= new Scanner(System.in);
        String userName;
        String password;
        User user1=new User();
        System.out.println("Enter a username: ");
        userName=scanner.nextLine();
        System.out.println("Enter a password: ");
        password=scanner.nextLine();
        for (int i=0; i< this.users.length; i++){
            if (this.users[i].getUserName().equals(userName) && this.users[i].getPassword().equals(password)){
                user1=users[i];
                break;
            }
        }
        if (user1.getUserName()==null){
            user1=null;
        }
        return user1;
    }
    public boolean postNewProperty(User user){
        boolean postNewProperty=false;
        int choiceTypeApartment=0;
        int flor=0;
        int roms=0;
        int apartmentNumber=0;
        int forRent=0;
        boolean isForRent=false;
        double price=0;
        if (advertisingLimit(user)){
            String [] cities = cities();
            if (cities.length!=0) {
                System.out.println("cities list: " + Arrays.toString(cities));
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a city name: ");
                String cityName = scanner.nextLine();
                if (anExistingCity(cities, cityName)) {
                    String[] streets = streetNames(this.addresses, cityName);
                    System.out.println("The list of the streets is: " + Arrays.toString(streets));
                    System.out.println("Enter a street name: ");
                    String streetName = scanner.nextLine();
                    if (anExistingStreet(streets, streetName)) {
                        do {
                            System.out.println("Type of apartment \n1- Apartment in building \n2- Penthouse in building \n3- Private house ");
                            choiceTypeApartment = scanner.nextInt();
                        } while (choiceTypeApartment > 4 || choiceTypeApartment < 1);
                        if (choiceTypeApartment != 3) {
                            System.out.println("What floor property?");
                            flor = scanner.nextInt();
                        }
                        do {
                            System.out.println("How many properties are in the property?");
                            roms = scanner.nextInt();
                        } while (roms < 0);
                        do {
                            System.out.println("Property number?");
                            apartmentNumber = scanner.nextInt();
                        } while (apartmentNumber < 0);
                        do {
                            System.out.println("For Sale Press 1 For Rent Press 2.");
                            forRent = scanner.nextInt();
                        } while (forRent != 1 && forRent != 2);
                        if (forRent == 2) {
                            isForRent = true;
                        }
                        do {
                            System.out.println("What is the price of the property? ");
                            price = scanner.nextDouble();
                        } while (price < 0);
                    Address address = new Address(cityName, streetName);
                    Property property = new Property(address, roms, price, choiceTypeApartment, isForRent, apartmentNumber, flor, user);
                    addPropertyToArray(property);
                    postNewProperty = true;
                }
                    else {
                        System.out.println("The street you wrote does not exist in the list");
                    }
            }
                else {
                    System.out.println("The city you wrote does not exist in the list");
                }
            }
        }
        else {
            System.out.println("You have reached the advertising limit.");
        }
        return postNewProperty;
    }
    private boolean advertisingLimit(User user){
        boolean isNotLimited=false;
        int count=0;
            for (int i=0; i<properties.length;i++){
                if (properties[i].getAdvertiser().equals(user)){
                    count++;
                }
            }
            if ((user.getKindOfUser()==1&&count<10)|| (user.getKindOfUser()==2&& count<3)){
                isNotLimited=true;
            }
            return isNotLimited;
    }
    public String [] cities(){
        int count=0;
        String[] cities=new String[0];
            String[] citiesFull = new String[this.addresses.length];
            for (int i = 0; i < this.addresses.length; i++) {
                if (this.addresses[i] != null) {
                    for (int j = i; j >= 0; j--) {
                        if (this.addresses[i].getCityName().equals(citiesFull[j])) {
                            break;
                        } else if (j == 0) {
                            citiesFull[count] = this.addresses[i].getCityName();
                            count++;
                        }
                    }
                }
            }
            if (count>0) {
                cities = new String[count];
                for (int i = 0; i < cities.length; i++) {
                    cities[i] = citiesFull[i];
                }
            }
        return cities;
        }
        public boolean anExistingCity(String [] cities, String cityUserInput){
          boolean anExistingCity=false;
          for (int i=0; i<cities.length; i++){
              if (cities[i].equals(cityUserInput)){
                  anExistingCity=true;
                  break;
              }
          }
          return anExistingCity;
        }
    public boolean anExistingStreet(String [] streets, String streetUserInput){
        boolean anExistingStreet=false;
        for (int i=0; i<streets.length; i++){
            if (streets[i].equals(streetUserInput)){
                anExistingStreet=true;
                break;
            }
        }
        return anExistingStreet;
    }
    public String [] streetNames(Address [] address, String city){
        int count=0;
            String[] streetFull = new String[address.length];
            for (int i = 0; i < address.length; i++) {
                    if (address[i].getCityName().equals(city)) {
                        streetFull[count]=address[i].getStreetName();
                        count++;
                }
            }
           String [] street = new String[count];
            for (int i = 0; i < street.length; i++) {
                street[i] = streetFull[i];
            }
        return street;
    }

    }
