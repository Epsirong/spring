package org.springframework.context.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/4/13
 **/
@Component
public class MyApplicationAware implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, ApplicationContextAware {

	private String beanName;

	private BeanFactory beanFactory;

	private ClassLoader classLoader;

	private ApplicationContext applicationContext;

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("调用了 BeanClassLoaderAware 的 setBeanClassLoader 方法");
		this.classLoader = classLoader;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("调用了 BeanFactoryAware 的 setBeanFactory 方法");
		this.beanFactory = beanFactory;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("调用了 BeanNameAware 的 setBeanName 方法");
		this.beanName = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("调用了 ApplicationContextAware 的 setApplicationContext 方法");
		this.applicationContext = applicationContext;
	}

	public void display(){
		System.out.println("beanName:" + beanName);
		System.out.println("是否为单例：" + beanFactory.isSingleton(beanName));
		System.out.println("系统环境为：" + applicationContext.getEnvironment());
	}

	public static void main(String[] args) {
		/*ClassPathResource resource = new ClassPathResource("org/springframework/context/aware/simplePropertyNamespaceHandlerWithExpressionLanguageTests.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		MyApplicationAware applicationAware = (MyApplicationAware) factory.getBean("myApplicationAware");
		applicationAware.display();*/

		// ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/springframework/context/aware/simplePropertyNamespaceHandlerWithExpressionLanguageTests.xml");
		// MyApplicationAware applicationAware = (MyApplicationAware) applicationContext.getBean("myApplicationAware");
		// applicationAware.display();


		//@Component
		ApplicationContext context = new AnnotationConfigApplicationContext(MyApplicationAware.class);
		MyApplicationAware bean = context.getBean(MyApplicationAware.class);
		bean.display();
	}
}
