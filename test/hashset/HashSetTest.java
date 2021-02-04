package test.hashset;

import java.util.HashSet;
import java.util.stream.IntStream;

class HashSetTest {

	public static void main(String[] args){
		/*
		int[] list = {1,2,3,4,5,6,5,4,3,2,1};

		list = IntStream.of(list).distinct().toArray();

		for(int l : list){
			System.out.println(l);
		}
		*/

		

		int[] list = {1,2,3,4,5,6,5,4,3,2,1};
		HashSet<Integer> set = new HashSet<Integer>();
		for(int l : list){
			set.add(l);
		}
		set.forEach(s -> System.out.println(s));
	}

}

