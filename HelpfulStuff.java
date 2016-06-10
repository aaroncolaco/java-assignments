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