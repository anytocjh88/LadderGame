package naveru;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class LadderMainTest {
	private LadderMain ladder;

	@Before
	public void before() {
		ladder = new LadderMain();
	}
	
	@Test
	public void 출발지점을입력하면도착지점을출력1() {
		int actual = ladder.run(10, 6, 1);
		assertThat(actual, is(6));
	}
	
	@Test
	public void 출발지점을입력하면도착지점을출력2() {
		int actual = ladder.run(10, 6, 3);
		assertThat(actual, is(5));
	}
	
	@Test
	public void 출발지점을입력하면도착지점을출력3() {
		int actual = ladder.run(10, 6, 6);
		assertThat(actual, is(3));
	}
	
	@Test
	public void 출발지점을입력하면도착지점을출력4() {
		int actual = ladder.run(10, 6, 5);
		assertThat(actual, is(2));
	}
	
	@Test
	public void 다양한크기의사다리타기() {
		Random random = new Random();
		int rowSize = random.nextInt(10) + 3;
		int colSize = random.nextInt(5) + 3;
		int startNum = random.nextInt(colSize) + 1;

		System.out.println("���� ���� : " + startNum);
		int result = ladder.run(rowSize, colSize, startNum);
		System.out.println("��� : " + result);
	}
	
	@Test
	public void 음수값이입력되었을때() throws Exception {
		ladder.run(-1, 10, 1);
	}
	
	@Test
	public void 범위를넘어선시작지점을입력했을때() throws Exception {
		ladder.run(6, 10, 11);
	}

}
