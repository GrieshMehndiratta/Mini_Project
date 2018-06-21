package Collection;

public class MyException extends Exception{
	
	String str;
	public MyException(String str1) {
		str=str1;
	}
	public String toString(){ 
		return ("MyException Occurred: "+str);
	}
}
