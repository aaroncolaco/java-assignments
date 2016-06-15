/* User Input */
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


/* File operations with BufferedReader */

BufferedReader bufferedReader = new BufferedReader(new FileReader("foo.txt"));

BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("foo.txt"));
bufferedWriter.close();		// always close or else may not write


/* Standard file operations */

// write
FileOutputStream fileOutputStream =  new FileOutputStream("foo.txt");
PrintStream printStream = new PrintStream(fileOutputStream);
printStream.println(stringValue)
printStream.close

// read
FileInputStream fileInputStream =  new FileInputStream("foo.txt");
DataInputStream dataInputStream = new DataInputStream(fileInputStream);
string = dataInputStream.readLine()


/* Serialization */

// Read serialized object
FileInputStream fileInputStream = new FileInputStream(filename);
ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
Object ob = (Object) objectInputStream.readLine();  // have to typecast with object you are reading

// Write serialized object
FileOutputStream fileOutputStream = new FileOutputStream("temp.ser");		
ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);		
Object ob = new Object();		// object that you want to serialize
objectOutputStream.writeObject(ob);		
objectOutputStream.flush();		
objectOutputStream.close();

/* Threads */

// implements Runnable

class RunnableDemo implements Runnable {

    private Thread thread;
    private String threadName;

    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);	// or put this and the next line in  
            thread.start();		// the constructor directly and delete this method
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.threadName + ", " + i);
        }
    }

}

public class Client {

    public static void main(String[] args) {
        // Call your functionalities from here to test your code.

        RunnableDemo runnableDemo1, runnableDemo2, runnableDemo3;

        runnableDemo1 = new RunnableDemo("Test1");
        runnableDemo2 = new RunnableDemo("Test2");
        runnableDemo3 = new RunnableDemo("Test3");

        runnableDemo1.start();
        runnableDemo2.start();
        runnableDemo3.start();

        System.out.println(Thread.currentThread());

    }
}


// extends Thread
class ThreadDemo extends Thread {

    private Thread t;
    private String threadName;

    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

}

public class TestThread {

    public static void main(String args[]) {

        ThreadDemo T1 = new ThreadDemo("Thread-1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo("Thread-2");
        T2.start();
    }
}


/*DB connec*/

Class.forName("com.mysql.jdbc.Driver"); // may have to put
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb", "root", "root");
statement = connection.createStatement();
resultSet = statement.executeQuery("Select * from cheese_tbl");


/*Comparator*/
class SortByCategory implements Comparator<Question>{

    @Override
    public int compare(Question q1, Question q2) {
        return q1.getCategory().compareTo(q2.getCategory());
    }
    
}       
Collections.sort(queList,new SortByCategory());