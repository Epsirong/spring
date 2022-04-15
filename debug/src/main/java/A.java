import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2022/4/15
 **/
public class A {


	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("testA.xml");
		Abean someBean= (Abean) context.getBean("a");
		someBean.a();
	}
}
