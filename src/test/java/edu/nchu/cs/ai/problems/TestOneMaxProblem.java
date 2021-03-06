package edu.nchu.cs.ai.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.nchu.cs.ai.algorithms.Genetic;
import edu.nchu.cs.ai.algorithms.HillClimbing;
import edu.nchu.cs.ai.algorithms.OptimumSolution;
import edu.nchu.cs.ai.algorithms.SelectionType;
import edu.nchu.cs.ai.algorithms.SimulatedAnnealing;
import edu.nchu.cs.ai.algorithms.TabuSearch;

public class TestOneMaxProblem {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
	public void testHC() {
		int runTimes = 30;
		List<List<Integer>> totalDetail = new ArrayList<>();
		for (int i=0;i<runTimes;i++) {
			HillClimbing hc = new HillClimbing(100, 500);
			OptimumSolution os = hc.run();
			totalDetail.add((List<Integer>)os.getExecuteDetail());
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<totalDetail.get(0).size();i++) {
			for (int j=0;j<totalDetail.size();j++) {
				sb.append(totalDetail.get(j).get(i)).append("\t");
			}
			sb.append("\r\n");
		}
		System.out.println(sb.toString());
	}

//	@Test
	public void testSA() {
		int runTimes = 30;
		List<List<Integer>> totalDetail = new ArrayList<>();
		for (int i=0;i<runTimes;i++) {
			SimulatedAnnealing sa = new SimulatedAnnealing(100,500);
			OptimumSolution os = sa.run();
			totalDetail.add((List<Integer>)os.getExecuteDetail());
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<totalDetail.get(0).size();i++) {
			for (int j=0;j<totalDetail.size();j++) {
				sb.append(totalDetail.get(j).get(i)).append("\t");
			}
			sb.append("\r\n");
		}
		System.out.println(sb.toString());
	}
	@Test
	public void testGA() {
//		Genetic ga = new Genetic(100, 500, 10, SelectionType.ROULETTEWHEEL , 0.6, 0.1);
		Genetic ga = new Genetic(100, 500, 10, SelectionType.TOURNAMENT , 0.6, 0.1);
		OptimumSolution os = ga.run();
		System.out.println(os.getSolution());
	}
	@Test
	public void testTS() {
		TabuSearch ts = new TabuSearch(100, 500, 7);
		OptimumSolution os = ts.run();
		System.out.println(os.getSolution());
	}
}
