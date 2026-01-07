import java.util.*;
import java.io.*;

class Service implements Serializable {
    String vehicleNo;
    String customerName;
    String serviceType;
    int cost;

    Service(String vehicleNo,String customerName,String serviceType,int cost){
        this.vehicleNo=vehicleNo;
        this.customerName=customerName;
        this.serviceType=serviceType;
        this.cost=cost;
    }

    public String toString(){
        return vehicleNo+" "+customerName+" "+serviceType+" "+cost;
    }
}

public class Main {
    static ArrayList<Service> list=new ArrayList<>();
    static Scanner s=new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("\n1 Add Service");
            System.out.println("2 View All");
            System.out.println("3 Search");
            System.out.println("4 Update");
            System.out.println("5 Delete");
            System.out.println("6 Sort");
            System.out.println("7 Generate Bill");
            System.out.println("8 Save");
            System.out.println("9 Load");
            System.out.println("10 Exit");

            int ch=s.nextInt();
            if(ch==1) add();
            else if(ch==2) view();
            else if(ch==3) search();
            else if(ch==4) update();
            else if(ch==5) delete();
            else if(ch==6) sort();
            else if(ch==7) bill();
            else if(ch==8) save();
            else if(ch==9) load();
            else if(ch==10) break;
        }
    }

    static void add(){
        System.out.println("Vehicle No:");
        String v=s.next();
        System.out.println("Customer Name:");
        String c=s.next();
        System.out.println("Service Type:");
        String t=s.next();
        System.out.println("Cost:");
        int cost=s.nextInt();
        list.add(new Service(v,c,t,cost));
        System.out.println("Added");
    }

    static void view(){
        if(list.isEmpty()){
            System.out.println("No Records");
            return;
        }
        for(Service st:list) System.out.println(st);
    }

    static void search(){
        System.out.println("1 Search by Vehicle No");
        System.out.println("2 Search by Customer Name");
        int ch=s.nextInt();

        if(ch==1){
            System.out.println("Enter Vehicle No:");
            String v=s.next();
            for(Service st:list){
                if(st.vehicleNo.equalsIgnoreCase(v)){
                    System.out.println(st);
                    return;
                }
            }
            System.out.println("Not Found");
        }else{
            System.out.println("Enter Customer Name:");
            String n=s.next();
            for(Service st:list){
                if(st.customerName.equalsIgnoreCase(n)){
                    System.out.println(st);
                    return;
                }
            }
            System.out.println("Not Found");
        }
    }

    static void update(){
        System.out.println("Enter Vehicle No to update:");
        String v=s.next();
        for(Service st:list){
            if(st.vehicleNo.equalsIgnoreCase(v)){
                System.out.println("New Customer Name:");
                st.customerName=s.next();
                System.out.println("New Service Type:");
                st.serviceType=s.next();
                System.out.println("New Cost:");
                st.cost=s.nextInt();
                System.out.println("Updated");
                return;
            }
        }
        System.out.println("Not Found");
    }

    static void delete(){
        System.out.println("Enter Vehicle No to delete:");
        String v=s.next();
        Iterator<Service> it=list.iterator();
        while(it.hasNext()){
            if(it.next().vehicleNo.equalsIgnoreCase(v)){
                it.remove();
                System.out.println("Deleted");
                return;
            }
        }
        System.out.println("Not Found");
    }

    static void sort(){
        System.out.println("1 Sort by Vehicle No");
        System.out.println("2 Sort by Customer Name");
        System.out.println("3 Sort by Cost");
        int ch=s.nextInt();

        if(ch==1){
            Collections.sort(list,(a,b)->a.vehicleNo.compareToIgnoreCase(b.vehicleNo));
        }else if(ch==2){
            Collections.sort(list,(a,b)->a.customerName.compareToIgnoreCase(b.customerName));
        }else{
            Collections.sort(list,(a,b)->a.cost-b.cost);
        }
        System.out.println("Sorted");
    }

    static void bill(){
        System.out.println("Enter Vehicle No for Bill:");
        String v=s.next();
        for(Service st:list){
            if(st.vehicleNo.equalsIgnoreCase(v)){
                System.out.println("------ BILL ------");
                System.out.println("Vehicle No: "+st.vehicleNo);
                System.out.println("Customer: "+st.customerName);
                System.out.println("Service: "+st.serviceType);
                System.out.println("Amount: Rs."+st.cost);
                System.out.println("------------------");
                return;
            }
        }
        System.out.println("Not Found");
    }

    static void save(){
        try{
            ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("service.txt"));
            o.writeObject(list);
            o.close();
            System.out.println("Saved");
        }catch(Exception e){
            System.out.println("Error");
        }
    }

    static void load(){
        try{
            ObjectInputStream o=new ObjectInputStream(new FileInputStream("service.txt"));
            list=(ArrayList<Service>)o.readObject();
            o.close();
            System.out.println("Loaded");
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
