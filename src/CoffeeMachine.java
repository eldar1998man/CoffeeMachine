import java.util.Scanner;

public class CoffeeMachine {
    private Scanner scanner;

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    private CoffeeMachine() {
        this.scanner = new Scanner(System.in);
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        boolean status;
        do {
            status = coffeeMachine.processAction();
        }
        while (status);
    }

    private void remain() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    private void take() {
        System.out.println(String.format("I gave you $%d", this.money));
        this.money = 0;
    }

    private void fill() {

        System.out.println("Write how many ml of water do you want to add:");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        this.beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        this.cups += scanner.nextInt();

    }

    private void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String type = this.scanner.nextLine();

        switch (type) {
            case "1": {
                if(this.water >= 250 && this.beans >= 16 && this.cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 250;
                    this.beans -= 16;
                    this.cups--;
                    this.money += 4;
                    break;
                }else if(this.water < 250){
                    System.out.println("Sorry, not enough water!");
                }else if(this.beans < 16){
                    System.out.println("Sorry, not enough beans!");
                }else{
                    System.out.println("Sorry, not enough cups!");
                }
            }
            case "2": {
                if(this.water >= 350 && this.beans >= 20 && this.milk >= 75 && this.cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 350;
                    this.milk -= 75;
                    this.beans -= 20;
                    this.cups--;
                    this.money += 7;
                    break;
                }else if(this.water < 350){
                    System.out.println("Sorry, not enough water!");
                }else if(this.beans < 20){
                    System.out.println("Sorry, not enough beans!");
                }else if(this.milk < 75){
                    System.out.println("Sorry, not enough milk!");
                }else{
                    System.out.println("Sorry, not enough cups!");
                }
            }
            case "3":{
                if(this.water >= 200 && this.beans >= 12 && this.milk >= 100 && this.cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 200;
                    this.milk -= 100;
                    this.beans -= 12;
                    this.cups--;
                    this.money += 6;
                }else if(this.water < 200){
                    System.out.println("Sorry, not enough water!");
                }else if(this.beans < 12){
                    System.out.println("Sorry, not enough beans!");
                }else if(this.milk < 100){
                    System.out.println("Sorry, not enough milk!");
                }else{
                    System.out.println("Sorry, not enough cups!");
                }
                break;
            }
            case "back":
                break;
            default:
                break;
        }
    }

    public boolean processAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = this.scanner.nextLine();

        switch (action) {
            case "buy": {
                this.buy();
                break;
            }
            case "fill": {
                this.fill();
                break;
            }
            case "take": {
                this.take();
                break;
            }
            case "remaining": {
                this.remain();
                break;
            }
            case "exit": {
                return false;
            }
            default: {
                break;
            }
        }
        return true;
    }
}
