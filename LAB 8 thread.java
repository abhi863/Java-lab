class FirstThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("BMS College of Engineering");
            try {
                Thread.sleep(10000); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class SecondThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("CSE");
            try {
                Thread.sleep(2000);  
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class thread{
    public static void main(String[] args) {
    
        FirstThread thread1 = new FirstThread();
        SecondThread thread2 = new SecondThread();

       
        thread1.start();
        thread2.start();
    }
}





