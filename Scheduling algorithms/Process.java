import java.util.Comparator;

public class Process {
	String name;
	int AT,BT,PR,CT,WT,TAT,rBT;
	boolean flag;

	public Process(String name,int AT,int BT,int PR) {
		this.AT=AT;
		this.BT=BT;
		this.name=name;
		this.PR=PR;
		CT=TAT=WT=0;
		rBT=BT;
		flag=false;
	}

	void display() {
		System.out.println(name+"\t"+AT+"\t"+BT+"\t"+PR+"\t"+CT+"\t"+WT+"\t"+TAT+"\t");
	}
}

// CLASSES FOR SORTING THE ARRAY OF PROCESS OBJECTS

class SortByArrival implements Comparator<Process> {
	@Override
	public int compare(Process p1, Process p2) {
		return p1.AT-p2.AT;
	}
}

