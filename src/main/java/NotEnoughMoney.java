public class NotEnoughMoney extends Exception {

    public String getInformation(){
        return "You don't have money for the service";
    }
}
