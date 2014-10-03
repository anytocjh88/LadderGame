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
	public void ����������Է��ϸ鵵���������1() {
		int actual = ladder.run(10, 6, 1);
		assertThat(actual, is(6));
	}
	
	@Test
	public void ����������Է��ϸ鵵���������2() {
		int actual = ladder.run(10, 6, 3);
		assertThat(actual, is(5));
	}
	
	@Test
	public void ����������Է��ϸ鵵���������3() {
		int actual = ladder.run(10, 6, 6);
		assertThat(actual, is(3));
	}
	
	@Test
	public void ����������Է��ϸ鵵���������4() {
		int actual = ladder.run(10, 6, 5);
		assertThat(actual, is(2));
	}
	
	@Test
	public void �پ���ũ���ǻ�ٸ�() {
		Random random = new Random();
		int rowSize = random.nextInt(10) + 3;
		int colSize = random.nextInt(5) + 3;
		int startNum = random.nextInt(colSize) + 1;

		System.out.println("���� ���� : " + startNum);
		int result = ladder.run(rowSize, colSize, startNum);
		System.out.println("��� : " + result);
	}
	
	@Test
	public void �������ԷµǸ鿡��() throws Exception {
		ladder.run(-1, 10, 1);
	}
	
	@Test
	public void ������������������Է�������() throws Exception {
		ladder.run(6, 10, 11);
	}

}
