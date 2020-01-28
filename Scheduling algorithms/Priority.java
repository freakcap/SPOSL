import java.util.Scanner;
import java.util.Arrays;

public class Priority {
	void execute(Process[] process,int size) {
		int sum=0,count=0,highest=0,time=0,min=Integer.MAX_VALUE;
		boolean check = false;
		double avgTAT=0,avgWT=0;
		while(count<size) {
					// check=false;
					for(int i=0;i<size;i++) {
						if(process[i].AT<=time && process[i].PR<min && process[i].rBT>0) {
							check=true;
							highest=i;
							min=process[highest].PR;
						}
					}
					if(check==false) {
						time++;
						continue;
					}
					process[highest].rBT--;
					if(process[highest].rBT==0) {
						count++;
						min = Integer.MAX_VALUE;
						process[highest].CT = time+1;
						process[highest].TAT = process[highest].CT - process[highest].AT;
						process[highest].WT = process[highest].TAT - process[highest].BT;
						avgTAT += process[highest].TAT;
						avgWT += process[highest].WT;
						process[highest].display();
					}
					time++;
				}
		avgTAT = avgTAT/size;
		avgWT = avgWT/size;
		System.out.println("\nAvg TAT : "+avgTAT+" and Avg WT : "+avgWT);
	}
}