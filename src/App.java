import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        HashMap<String, Runnable> gamemap = new HashMap<>();
        for (int i = 0; i < 11; i++) {
            set.add("thing" + i);
        }
        gamemap.put("A", ()-> {
            add(set);
        });
        gamemap.put("D", ()-> {
            delete(set);
        });
        gamemap.put("P", ()-> {
            print(set);
        });
        gamemap.put("Q", ()-> {
            quit();
        });
        Boolean sentinel = true;
        do{
        System.out.println("A - Add Item \nD - Delete Item\n P - Print List\n Q - Quit Program");
        String temp = scan.nextLine();
        if (gamemap.containsKey(temp)) {
            gamemap.get(temp).run();
        }else{
            System.out.println("Incorrect Value");
        }
        }while (sentinel);



    }

    public static void add(HashSet<String> set){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a value to add to the list: ");
        String temp = scan.nextLine();
        set.add(temp);
    }

    public static void delete(HashSet<String> set){
        Scanner scan = new Scanner(System.in);
        boolean sentinel = true;
        do {
            System.out.println("Enter the value to remove from list: ");
        String temp = scan.nextLine();
        if(set.contains(temp)){
            set.remove(temp);
            sentinel = false;
        }else{
            System.out.println("Not available try again");
        }
        } while (sentinel);
    }

    public static void print(HashSet<String> set){
        Iterator<String> iterator = set.iterator();
            
        while(iterator.hasNext()) {
            String temp = iterator.next();
            System.out.println(temp);
        }
    }
    public static void quit(){
        System.exit(0);
    }
}
