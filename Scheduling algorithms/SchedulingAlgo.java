import java.util.Arrays;
import java.util.Scanner;

public class SchedulingAlgo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of process :");
		int size = sc.nextInt();
		Process[] processF = new Process[size];
		Process[] processS = new Process[size];
		Process[] processP = new Process[size];
		Process[] processR = new Process[size];
		for(int i=0;i<size;i++) {
			System.out.println("P"+(i+1)+" -- Enter the AT,BT and priority :");
			int at = sc.nextInt();
			int bt = sc.nextInt();
			int pr = sc.nextInt();
			processF[i] = new Process("P"+(i+1),at,bt,pr);
			processS[i] = new Process("P"+(i+1),at,bt,pr);
			processP[i] = new Process("P"+(i+1),at,bt,pr);
			processR[i] = new Process("P"+(i+1),at,bt,pr);
		}
		System.out.println("Enter the value of quantum : ");
		int quantum = sc.nextInt();
		FCFS fcfs = new FCFS();
		Priority pri = new Priority();
		RoundRobin rr = new RoundRobin();
		SJF sjf = new SJF();
		System.out.println("---------------------------------------------------");
		System.out.println("P\tAT\tBT\tPRI\tCT\tWT\tTAT");
		System.out.println("---------------------------------------------------");
		System.out.println("\n----FCFS----");
		fcfs.execute(processF,size);
		System.out.println("\n----SJF----");
		sjf.execute(processS,size);
		System.out.println("\n----Priority----");
		pri.execute(processP,size);
		System.out.println("\n----Round Robin----");
		rr.execute(processR,quantum,size);
	}
}