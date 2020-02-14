
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class PassTwo {
	ArrayList<OperandEntry>SYMTAB;
	ArrayList<OperandEntry>LITTAB;
	StringBuilder code;

	private static final String IMPERATIVE = "IS";
	private static final String DECLARATIVE = "DL";
	private static final String ASSM_DIRECTIVE = "AD";
	private static final String SYMBOL = "S";
	private static final String LITERAL = "L";
	private static final String CONSTANT = "C";

	public PassTwo() {
		SYMTAB= new ArrayList<>();
		LITTAB = new ArrayList<>();
		code = new StringBuilder();
	}

	public void setSymbolTable(BufferedReader reader) throws NumberFormatException, IOException {
		assignTo(reader,SYMTAB);
	}

	public void setLiteralTable(BufferedReader reader) throws NumberFormatException, IOException {
		assignTo(reader,LITTAB);
	}

	public void assignTo(BufferedReader reader, ArrayList<OperandEntry>table) throws NumberFormatException, IOException {
		String line;
		while((line = reader.readLine()) != null) {
			String str[] = line.split("\\s+");
			table.add(new OperandEntry(str[1],
					Integer.parseInt(str[2]),
					Integer.parseInt(str[0])));
		}
	}

	private void handleOperation(String operand) throws IndexOutOfBoundsException {
		int value = Integer.parseInt(operand.replaceAll("[^0-9]",""));
		String output = "000";
		if(operand.contains(SYMBOL)) {
			output = String.format("%03d",SYMTAB.get(value).getAddress());
		} else if(operand.contains(LITERAL)) {
			output = String.format("%03d",LITTAB.get(value).getAddress());
		} else if(operand.contains(CONSTANT)) {
			output = String.format("%03d",value);
		}
		code.append(output).append("\n");
	}

	public String generateMachineCode(BufferedReader reader) throws IOException {
		String line;
		while((line = reader.readLine())!= null) {
			String str[] = line.split("\\s+");
			if(str[1].contains(ASSM_DIRECTIVE)) {
				code.append("\n");
				continue;
			}

			if(str[1].contains(DECLARATIVE)) {
				code.append(str[0]).append("  ");
				code.append("+00").append("  ").append("00").append("  ");
				handleOperation(str[2]);
			}

			if(str[1].contains(IMPERATIVE)) {
				code.append(str[0]).append("  ");
				int opcode = Integer.parseInt(str[1].replaceAll("[^0-9]",""));
				code.append("+"+String.format("%02d",opcode)).append("  ");

				switch(str.length) {
					case 2:
						code.append("00").append("  ").append("000\n");
						break;
					case 3:
						code.append("00").append("  ");
						handleOperation(str[2]);
						break;
					case 4:
						code.append(String.format("%02d",Integer.parseInt(str[2].replaceAll("[^0-9]","")))).append("  ");
						handleOperation(str[3]);
				}
			}
		}
		return code.toString();
	} 
}