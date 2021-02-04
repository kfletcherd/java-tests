package test.trig;

import java.awt.Point;

import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

class TrigCache {

	private static HashMap<Integer, Point> angles;

	static {
		angles = new HashMap<Integer, Point>(360);

		for(int i = 0; i < 360; i++){
			Point p = new Point();

			p.x = (int) Math.cos(i) * 1;
			p.y = (int) Math.sin(i) * 1;

			angles.put(i, p);
		}

	}

	public static Point getPoint(int deg){
		return angles.get(deg);
	}

	public static void main(String[] a){
		Set s = angles.entrySet();
		Iterator i = s.iterator();
		while(i.hasNext()){
			Map.Entry e = (Map.Entry)i.next();
			System.out.println("["+e.getKey()+"] "+e.getValue());
		}
	}
}

