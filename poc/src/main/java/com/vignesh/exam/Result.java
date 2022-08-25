package com.vignesh.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {
	
	public static int lastStoneWeight(List<Integer> weights) {
		ArrayList<Integer> tempList = new ArrayList<>(weights);
		Collections.sort(tempList);
		//System.out.println(tempList);
		int lastIndex = tempList.size() - 1;
		int lastStoneWeight = 0;
		while(lastIndex > 0) {
			int lastEle = tempList.get(lastIndex);
			int lastButOneEle = tempList.get(lastIndex-1);
			
			int diff = lastEle - lastButOneEle;
			if(diff == 0) {
				lastIndex = lastIndex -2;
				lastStoneWeight = 0;
			}else if(diff > 0) {
				lastIndex = lastIndex -1;
				tempList.add(lastIndex, diff);
				lastStoneWeight = diff;
			}else {
				lastIndex = lastIndex -1;
				tempList.add(lastIndex, -diff);
				lastStoneWeight = -diff;
			}
		}
		
		return lastStoneWeight;
	}
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
	//	list.add(1);list.add(2);list.add(3);list.add(6);list.add(7);list.add(7);
		list.add(2);list.add(4);list.add(5);
		System.out.println(list);
		
		System.out.println(lastStoneWeight(list));
	}
}
