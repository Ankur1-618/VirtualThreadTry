import async.AsyncFutureAction;
import traditional.TraditionalThreadAction;
import virtual.VirtualThreadAction;

public class Runner {

    public static void main(String args[]){

        TraditionalThreadAction t = new TraditionalThreadAction();
        AsyncFutureAction a = new AsyncFutureAction();
        VirtualThreadAction v = new VirtualThreadAction();

        long traditional = t.runThreadAction(1000,10,false,false);
        long async = a.runCompletableFutureAction(1000,10,false,false);
        long virtual = v.runVirtualThreadAction(1000,10, false,false);

        System.out.println("\n \n ######### 1000 thread X 0 sleep time X no IO task X no CPU task ######### ");
        System.out.println("Traditional :: "+ traditional);
        System.out.println("Async :: "+ async);
        System.out.println("Virtual :: "+ virtual);

        long traditional_1 = t.runThreadAction(1000,10,false,false);
        long async_1 = a.runCompletableFutureAction(1000,10,false,false);
        long virtual_1 = v.runVirtualThreadAction(1000,10, false,false);

        System.out.println("\n \n ######### 1000 thread X 10 sleep time X no IO task X no CPU task ######### ");
        System.out.println("Traditional :: "+ traditional_1);
        System.out.println("Async :: "+ async_1);
        System.out.println("Virtual :: "+ virtual_1);

        long traditional_f = t.runThreadAction(1000,0,true,false);
        long async_f = a.runCompletableFutureAction(1000,0, true, false);
        long virtual_f = v.runVirtualThreadAction(1000,0, true,false);

        System.out.println("\n \n ######### 1000 thread X 0 sleep time X IO task : read file X no CPU task ######### ");
        System.out.println("Traditional :: "+ traditional_f);
        System.out.println("Async :: "+ async_f);
        System.out.println("Virtual :: "+ virtual_f);

        long traditional_f1 = t.runThreadAction(1000,0,false,true);
        long async_f1 = a.runCompletableFutureAction(1000,0, false,true);
        long virtual_f1 = v.runVirtualThreadAction(1000,0, false,true);

        System.out.println("\n \n ######### 1000 thread X 10 sleep time X no IO task X CPU task : sum of square ######### ");
        System.out.println("Traditional :: "+ traditional_f1);
        System.out.println("Async :: "+ async_f1);
        System.out.println("Virtual :: "+ virtual_f1);
    }
}
