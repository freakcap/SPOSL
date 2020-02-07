

public class PassOne {
	LinkedHashMap<String,OperandEntry>SYMTAB;
	ArrayList<OperandEntry>LITTAB;
	ArrayList<Integer>POOLTAB;
	OpcodeTable OPTAB;
	String line;
	StringBuilder code;
	int LC=0;
	int pooltab_ptr = 0;
	int littab_ptr = 0;
	int symtab_ptr = 0;

	public PassOne() {
		SYMTAB = new LinkedHashMap<>();
		LITTAB = new ArrayList<>();
		POOLTAB = new ArrayList<>();
		OPTAB = new OpcodeTable();
		code = new StringBuilder();
	}

	public String getPoolTable() {
		StringBuilder sb = new StringBuilder();
		for(int id : POOLTAB) {
			sb.append("#").append(id).append("\n");
		}
		return sb.toString();
	}

	public String getLiteralTable() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<LITTAB.size();i++) {
			sb.append(i).append("\t")
			.append(LITTAB.get(i).getLiteral()).append("\t")
			.append(LITTAB.get(i).getAddress()).append("\n");
		}
		return sb.toString();
	}

	public String getSymbolTable() {
		StringBuilder sb = new StringBuilder();
		for(Entry<String,OperandEntry>entry : SYMTAB.entrySet()) {
			sb.append(entry.getValue().getIndex()).append("\t")
			.append(entry.getKey()).append("\t")
			.append(entry.getValue().getAddress()).append("\n");
		}
		return sb.toString();
	}

	public String constantPair(String literal) {
		string value = literal.replace("=","").replace("'","");
		return "(C,"+ value +")";
	}

	public String constantPair(int value) {
		return "(C,"+ value +")";
	}

	public String literalPair(OperandEntry entry) {
		int idx = LITTAB.indexOf(entry);
		return "(L,"+ idx +")";
	}	

}