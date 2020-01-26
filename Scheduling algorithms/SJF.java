import java.util.Scanner;
import java.util.Arrays;

public class SJF {
	void execute(Process[] process,int size) {
		Arrays.sort(process,new SortByArrival());
		int sum=0,time=0,count=0,shortest=0,min=Integer.MAX_VALUE;
		boolean check = false;
		double avgTAT=0,avgWT=0;
		while(count<size) {
			// check=false;
			for(int i=0;i<size;i++) {
				if(process[i].AT<=time && process[i].rBT<min && process[i].rBT>0) {
					check=true;
					shortest=i;
					min=process[shortest].rBT;
				}
			}
			if(check==false) {
				time++;
				continue;
			}
			process[shortest].rBT--;
			min = process[shortest].rBT;
			if(min==0) {
				count++;
				min = Integer.MAX_VALUE;
				process[shortest].CT = time+1;
				process[shortest].TAT = process[shortest].CT - process[shortest].AT;
				process[shortest].WT = process[shortest].TAT - process[shortest].BT;
				avgTAT += process[shortest].TAT;
				avgWT += process[shortest].WT;
				process[shortest].display();
			}
			time++;
		}
		avgTAT = avgTAT/size;
		avgWT = avgWT/size;
		System.out.println("\nAvg TAT : "+avgTAT+" and Avg WT : "+avgWT);
	}
}