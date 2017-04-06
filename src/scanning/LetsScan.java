package scanning;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
 
public class LetsScan {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String fName = "C:\\Users\\Brandon Willis\\Desktop\\SerialToAsset.csv";
		String thisLine; 
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fName);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DataInputStream myInput = new DataInputStream(fis);
		int i = 0;//line count of csv
	    String[][] data = new String[0][];//csv data line count=0 initially
	    try {
			while ((thisLine = myInput.readLine()) != null) {
			    ++i;//increment the line count when new line found

			    String[][] newdata = new String[i][2];//create new array for data

			    String strar[] = thisLine.split(",");//get contents of line as an array
			    newdata[i - 1] = strar;//add new line to the array

			    System.arraycopy(data, 0, newdata, 0, i - 1);//copy previously read values to new array
			    data = newdata;//set new array as csv data
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			System.out.println("Serial Number:");
			
			String serialNumber = sc.next();
			if (serialNumber.equals("Done")){
				System.out.println("Have a good day! :-)");
				break;
			}
			
			for (int a = 0; a < data.length; a++){
				if (data[a][1].equals(serialNumber)){
					System.out.println("Teacher: " + data[a][0] + "\n");
					break;
				}
			}
			System.out.println();
		}
	}
}