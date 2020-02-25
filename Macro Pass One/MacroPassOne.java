class MNTEntry {
	String name;
	int pp,kp,mdtp,kpdtp;

	public MNTEntry(String name,int mdtp, int kpdtp) {
		this.name = name;
		this.pp = 0;
		this.kp = 0;
		this.mdtp = mdtp;
		this.kpdtp = kpdtp;
	}

	public MNTEntry(String name,int pp,int kp,int mdtp, int kpdtp) {
		this.name = name;
		this.pp = pp;
		this.kp = kp;
		this.mdtp = mdtp;
		this.kpdtp = kpdtp;
	}

	public void incrementpp() {
		pp++;
	}

	public void incrememntkp() {
		kp++;
	}

	@Override
	public String toString() {
		return name + "  " + pp + "  " + kp + "  " + mdtp + "  " + kpdtp;
	}

}

class MacroOutput {
	String IC,MNT,MDT,KPDTAB;
	ArrayList<String>PNTAB = new ArrayList<>();

	public String getIC() {
		return IC;
	}

	public String getMNT() {
		return MNT;
	}

	public String getMDT() {
		return MDT;
	}

	public String getKPDTAB() {
		return KPDTAB;
	}

	public String getPNTAB() {
		StringBuilder tmp = new StringBuilder();
		for(int i=0;i<PNTAB.size();i++) {
			tmp.append(PNTAB.get(i)).append("\n");
		}
		return tmp.toString();
	}

	public void setIC(String IC) {
		this.IC = IC;
	}

	public void setMNT(String MNT) {
		this.MNT = MNT;
	}

	public void setMDT(String MDT) {
		this.MDT = MDT;
	}

	public void setKPDTAB(String KPDTAB) {
		this.KPDTAB = KPDTAB;
	}

	public void setPNTAB(String PNTAB) {
		this.PNTAB.add(PNTAB);
	}

}


public class MacroPassOne {
	ArrayList<MNTEntry>MNT;
	ArrayList<String>MDT;
	ArrayList<String>PNTAB;
	HashMap<String,String>KPDTAB;

	public MacroPassOne() {
		MNT = new ArrayList<>();
		MNT = new ArrayList<>();
		MNT = new ArrayList<>();
	}
}