package com.sarat.Serialization;

import java.io.*;

class SerializationBox implements Serializable {

	private byte serializableProp = 10;

	public byte getSerializableProp() {
		return serializableProp;
	}
}

public class SerializationSample {

	public static void main(String args[]) throws IOException,
			FileNotFoundException, ClassNotFoundException {

		SerializationBox serialB = new SerializationBox();
		serialize("serial.out", serialB);
		SerializationBox sb = (SerializationBox) deSerialize("serial.out");
		System.out.println(sb.getSerializableProp());
	}

	public static void serialize(String outFile, Object serializableObject)
			throws IOException {
		
		try(FileOutputStream fos = new FileOutputStream(outFile)){
			try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(serializableObject);
			}
		};		
	}

	public static Object deSerialize(String serilizedObject)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream returnValue = null;
		
		//try with resource from JDK 8 - have to create an extra variable
		try(FileInputStream fis = new FileInputStream(serilizedObject)) {
			try(ObjectInputStream ois = new ObjectInputStream(fis)){
				returnValue = (ObjectInputStream) ois.readObject();
			};
		}
		
		return returnValue;
	}
}