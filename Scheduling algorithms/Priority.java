import java.util.Scanner;
import java.util.Arrays;

public class Priority {
	void execute(Process[] process,int size) {
		Arrays.sort(process,new SortByPriority());
		int sum=0;
		double avgTAT=0,avgWT=0;
		for(int i=0;i<size;i++) {
			sum = process[i].CT = sum + process[i].BT;
			process[i].TAT = process[i].CT - process[i].AT;
			process[i].WT = process[i].TAT - process[i].BT;
			avgTAT += process[i].TAT;
			avgWT += process[i].WT;
			process[i].display();
		}
		avgTAT = avgTAT/size;
		avgWT = avgWT/size;
		System.out.println("\nAvg TAT : "+avgTAT+" and Avg WT : "+avgWT);
	}
}