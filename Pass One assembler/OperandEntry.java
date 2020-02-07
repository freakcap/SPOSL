public class OperandEntry {
	private String literal;
	private int address;
	private int index;

	public OperandEntry(String literal,int address) {
		this.literal = literal;
		this.address =address;
		index = 0;
	}

	public OperandEntry(String literal,int abstract ,int index) {
		this.literal = literal;
		this.address = address;
		this.index = index;
	}

	public String getLiteral() {
		return this.literal;
	}

	public int getAddress() {
		return this.address;
	}

	public int getIndex() {
		return this.index;
	}

	public OperandEntry setAddress(int address) {
		this.address = address;
		return this;
	}

	public OperandEntry setIndex(int index) {
		this.index = index;
		return this;
	}

	@Override
	public String toString() {
		if(this.literal.contains("=")) {
			return "(L,"+index+")";
		}
		else {
			return "(S,"+index+")";
		}
	}
}