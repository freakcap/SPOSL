import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws java.io.IOException {
		FileReader file;
		BufferedReader reader;
		PassTwo assembler = new PassTwo();
		File op=new File("mc.txt");
		FileWriter fw;
		fw=new FileWriter("mc.txt");
		try {
			reader = new BufferedReader(new FileReader("SYMTAB.txt"));
			assembler.setSymbolTable(reader);
			reader = new BufferedReader(new FileReader("LITTAB.txt"));
			assembler.setLiteralTable(reader);
			reader = new BufferedReader(new FileReader("IC.txt"));
			String machineCode = assembler.generateMachineCode(reader);
			System.out.println(machineCode);
			fw.write(machineCode);
			fw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
