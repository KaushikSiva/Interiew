package FinalScoreQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
//Run Time O(n) 
public class FinalScoreQuestion {

	static Map<Integer, PriorityQueue<Double>> allResultsMap = new HashMap<Integer, PriorityQueue<Double>>();
	static Map<Integer, Double> studentaveragemap = new HashMap<Integer, Double>();
  /**
   * Gives the map of student id along with their average mark 
   * @param results
   * @return
   */
	static Map<Integer, Double> calculateFinalScores(List<TestResult> results) {
		if (results != null) {

			Iterator<TestResult> iter = results.iterator();
			while (iter.hasNext()) {
				TestResult test = iter.next();
				if (allResultsMap.containsKey(test.studentid)) {
					PriorityQueue<Double> ar = allResultsMap.get(test.studentid);
					ar.add((double) test.testScore);
					allResultsMap.put(test.studentid, ar);
				} else {
					Comparator<Double> doublecomp = new DoubleComparator();
					PriorityQueue<Double> ar = new PriorityQueue<Double>(5,doublecomp);
					if (test.studentid != 0) {
						ar.add((double) test.testScore);
						allResultsMap.put(test.studentid, ar);
					}
				}
			}
			studentaveragemap = studentMarksMap(allResultsMap);
			return studentaveragemap;
		} else {
			return null;
		}
	}

	/**
	 * sorts the map and passes the sorted sudent marks map to calculate average and returns student marks and average
	 * @param allResultsMap
	 * @return resultMap
	 */
	static Map<Integer, Double> studentMarksMap(Map<Integer, PriorityQueue<Double>> allResultsMap) {
		Map<Integer, Double> resultMap = new HashMap<Integer, Double>();
		if (allResultsMap != null) {
			Iterator<Entry<Integer, PriorityQueue<Double>>> iter = allResultsMap.entrySet().iterator();
			while (iter.hasNext()) {
				Entry<Integer, PriorityQueue<Double>> student = iter.next();
				Integer studid = Integer.parseInt(student.getKey().toString());
				Double Marks = calculateaverage((PriorityQueue<Double>) student.getValue());
				resultMap.put(studid, Marks);
			}

			return resultMap;
		} else {
			return null;
		}
	}
/**
 * Takes in list of all marks of a student and returns the average
 * @param ar
 * @return average
 */
	public static Double calculateaverage(PriorityQueue<Double> ar) {
		double sum=0.0;
		int count =0;
		while(count<5)
		{
		sum = sum+ar.poll();
		count++;
		}
		Double average = sum/5;
		return average;

	}
	
	

	
	public static void main(String args[])
	{
		TestResult tr=new TestResult();
		tr.studentid=1;
		tr.testDate="1/2/2012";
		tr.testScore=70;
		TestResult tr1=new TestResult();
		tr1.studentid=1;
		tr1.testDate="1/2/2012";
		tr1.testScore=70;
		TestResult tr2=new TestResult();
		tr2.studentid=1;
		tr2.testDate="1/2/2012";
		tr2.testScore=70;
		TestResult tr3=new TestResult();
		tr3.studentid=1;
		tr3.testDate="1/2/2012";
		tr3.testScore=70;
		TestResult tr4=new TestResult();
		tr4.studentid=1;
		tr4.testDate="1/2/2012";
		tr4.testScore=90;
		TestResult tr95=new TestResult();
		tr95.studentid=2;
		tr95.testDate="1/2/2012";
		tr95.testScore=70;
		TestResult tr15=new TestResult();
		tr15.studentid=2;
		tr15.testDate="1/2/2012";
		tr15.testScore=70;
		TestResult tr25=new TestResult();
		tr25.studentid=2;
		tr25.testDate="1/2/2012";
		tr25.testScore=70;
		TestResult tr35=new TestResult();
		tr35.studentid=2;
		tr35.testDate="1/2/2012";
		tr35.testScore=70;
		TestResult tr45=new TestResult();
		tr45.studentid=2;
		tr45.testDate="1/2/2012";
		tr45.testScore=90;
		List<TestResult> trlist = new LinkedList();
		trlist.add(tr);
		trlist.add(tr1);
		trlist.add(tr2);
		trlist.add(tr3);
		trlist.add(tr4);
		trlist.add(tr45);
		trlist.add(tr35);
		trlist.add(tr25);
		trlist.add(tr95);
		trlist.add(tr15);
		System.out.println(calculateFinalScores(trlist));
	}

}
class DoubleComparator implements Comparator<Double>
{
    @Override
    public int compare(Double x, Double y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        if (x < y)
        {
            return -1;
        }
        if (x > y)
        {
            return 1;
        }
        return 0;
    }
}