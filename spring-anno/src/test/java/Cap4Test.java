import com.enjoy.cap4.config.Cap4MainConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Cap4Test {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap4MainConfig.class);
		
		System.out.println("IOC�����������........");
		app.getBean("person");//ִ�л�ȡ��ʱ��Ŵ�������ʼ��bean
		
	}
}
