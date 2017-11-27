package com.sdt.number;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import com.sdt.file.FileUtils;


public class IP {
	public static int K10 = 1024 * 10;
	public static int M1 = 1024 * 1024;
	public static int M4 = 4 * M1;
	private static int partitionCount = 100;
	
	public static void main(String[] args) throws IOException{
		generateMassIP("ip", "ips.txt", 100000000);
		generatePartitionFile("ip", "ips.txt", 100); 
		
		System.out.println("done");
		searchTopN(10);
	}
	public static void searchTopN(int count) throws IOException{
		File[] smallFiles = getPartitionFile("ip", 100);
		DataInputStream dis = null;
		Map<Integer, Integer> ipCountMap = new HashMap<Integer, Integer>();
		
        TopNHeap<IPInfo> heap = new TopNHeap<IPInfo>(count);  
        for (int i = 0; i < 100; i++) {  
            ipCountMap.clear();  
            try {  
                dis = new DataInputStream(new BufferedInputStream(new FileInputStream(smallFiles[i]), K10));  
                while (dis.available() > 0) {  
                    int ip = dis.readInt();  
                    Integer cnt = ipCountMap.get(ip);  
                    ipCountMap.put(ip, cnt == null ? 1 : cnt + 1);  
                }  
                searchMostCountIps(ipCountMap, heap);  
            } finally {  
                if (dis != null) {  
                    try {  
                        dis.close();  
                    } catch (IOException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
        printResult(heap);  
		
	}
	private static void printResult(TopNHeap<IPInfo> heap) {  
        while (heap.hasNext()) {  
            System.out.println(heap.removeTop().toString());  
        }  
    }
	//生成ip
	public static void generateMassIP(String srcDirName, String srcFileName, int count) 
			throws IOException{
		File file = FileUtils.createFile(srcDirName, srcFileName);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			count = count / 100;
			Random random = new Random(255);
			StringBuilder sb = new StringBuilder(1500);
			for(int i = 0; i < count; i++){
				sb.delete(0, sb.length());
				for(int j = 0; j < 100; j++){
					sb.append(random.nextInt(100)).append(".");
					sb.append(random.nextInt(150)).append(".");
					sb.append(random.nextInt(256)).append(".");
					sb.append(random.nextInt(256)).append("\n");
				}
				bw.write(sb.toString());
				bw.flush();
			}
			
		} finally {
			if(bw != null){
				bw.close();
			}
		}
		
	}
	
	private static void searchMostCountIps(Map<Integer, Integer> map,  
            TopNHeap<IPInfo> heap) {  
        Iterator<Integer> iter = map.keySet().iterator();  
        Integer key = null;  
        while (iter.hasNext()) {  
            key = iter.next();  
            int count = map.get(key);  
            if (!heap.isFull() || count > heap.getHeapTop().getCount()) {  
                heap.addToHeap(new IPInfo(count, key));  
            }  
        }  
    } 
	public static File[] generatePartitionFile(String srcDirName, String srcFileName, int count) 
			throws IOException{
		File[] files = new File[count];
		DataOutputStream[] dpos = new DataOutputStream[count];
		for(int i =0; i< count; i++){
			files[i] = FileUtils.createFile(srcDirName, i + ".txt");
		}
		File file = FileUtils.getFile(srcDirName, srcFileName);
		BufferedReader br = null;
		try {
			for(int i = 0; i < count; i++){
				dpos[i] = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(files[i]), K10));
			}
			br = new BufferedReader(new FileReader(file), M4);
			String s;
			while((s = br.readLine()) != null){
				int ip = parseIp2Int(s);
				dpos[Math.abs(ip % count)].write(ip);
			}
		} finally {
			for(int i = 0; i < count; i++){
				if(dpos[i] != null){
					try {
						dpos[i].close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(br != null){
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return files;	
	}
	//ip转为int型存储
	public static int parseIp2Int(String ip){
		String[] segs = ip.split("\\.");
		int rst = 0;
		for(int i =  0; i < segs.length; i++){
			rst = (rst << 8) | Integer.valueOf(segs[i]);
		}
		return rst;
	}
	
	public static String parseInt2Ip(int value){
		StringBuilder sb = new StringBuilder(15);
		String[] segs = new String[4];
		for(int i = 0; i < 4; i++){
			segs[3 - i] = String.valueOf((0xFF & value));
			value >>= 8;
		}
		for (int i = 0; i < 4; i++){
			sb.append(segs[i]).append(".");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	public static File[] getPartitionFile(String srcDirName, int count){
		File[] files = new File[count];
		for(int i = 0; i< count; i++){
			files[i] = FileUtils.getFile(srcDirName, i + ".data");
		}
		return files;
	}
	static class IPInfo implements Comparable<IPInfo>{
		private int count;
		private int ipValue;
		public IPInfo(int count, int ipValue){
			super();
			this.count = count;
			this.ipValue = ipValue;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public int getIpValue() {
			return ipValue;
		}
		public void setIpValue(int ipValue) {
			this.ipValue = ipValue;
		}
		public String getIp(){
			return parseInt2Ip(ipValue);
		}
		@Override
		public int compareTo(IPInfo o) {
			if (this.count > o.getCount())
				return 1;
			else if (this.count < o.getCount()) {
				return -1;
			}
			else {
				return 0;
			}
		}
		@Override
		public String toString(){
			return this.getIp() + " -- " +this.count;
		}
	}
}
