import java.util.Scanner;
import java.util.Arrays;

public class RoundRobin {
	void execute(Process[] process,int quantum,int size) {
		Arrays.sort(process,new SortByArrival());
		int sum=0,time=0;
		double avgTAT=0,avgWT=0;
		while(true) {
			boolean end = true;
			for(int i=0;i<size;i++) {
				if(process[i].rBT>0 && process[i].AT<=time) {
					end = false;
					if(process[i].rBT>quantum) {
						time+=quantum;
						process[i].rBT-=quantum;
					}
					else {
						time+=process[i].rBT;
						process[i].rBT = 0;
						process[i].CT=time;
						process[i].TAT = process[i].CT - process[i].AT;
						process[i].WT = process[i].TAT - process[i].BT;
						avgTAT+=process[i].TAT;
						avgWT+=process[i].WT;
						process[i].display();
					}
				}
			}
			if(end==true) {
				break;
			}
		}
		avgTAT = avgTAT/size;
		avgWT = avgWT/size;
		System.out.println("\nAvg TAT : "+avgTAT+" and Avg WT : "+avgWT);
	}
}