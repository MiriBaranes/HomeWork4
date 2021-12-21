import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("sdfghjkl", "123456");
        Address address1 = new Address("sdfghjk", "12345");
        Address address2 = new Address("sdlfghjk", "12345");
        Address address3 = new Address("mf", "12345");
        RealEstate realEstate = new RealEstate(new Address[]{address, address, address, address, address2, address2, address3, address1, address, address});
        play(realEstate);

//
//        int choice = getStart();
//        while (choice != 3) {
//            switch (choice) {
//                case 1:
//                realEstate.createUser();
//                choice=getStart();
//                break;
//                case 2:
//                    User user=realEstate.login();
//                    if (user!=null){
//                        int executionOptions= executionOptions();
//                        if (executionOptions==6){
//                            break;
//                        }
//                        else {
//                        executionOptionsAct(executionOptions,realEstate,user);
//
//                        }
//                    }
//                    else {
//                            System.out.println("Invalid login information!");
//                            choice=getStart();
//                            break;
//                        }
//                    }
//            }
//
//        }
    }

    public static int getStart() {
        System.out.println("1- Creat account"
                + "\n2- Login\n3-Exit");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public static int executionOptions() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Publishing a new property" +
                "\n2-Remove property advertising"
                + "\n3-View all assets in the system" +
                "\n4-View properties posted by the user" +
                "\n5-Property search by parameters" +
                "\n6-logout and Back to the main menu");
        do {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 6);
        return choice;
    }

    public static void executionOptionsAct(int executionOptions, RealEstate realEstate, User user) {
        switch (executionOptions) {
            case 1:
                System.out.println(realEstate.postNewProperty(user));
                break;
        }
    }

    public static void play(RealEstate realEstate) {
        int choice = getStart();
        realEstate.createUser();
        choice = getStart();
        User user = realEstate.login();
        if (user != null) {
            int executionOptions = executionOptions();
            executionOptionsAct(executionOptions, realEstate, user);

        }
    }
}
