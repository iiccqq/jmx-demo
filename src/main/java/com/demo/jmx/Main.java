package com.demo.jmx;
import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.modelmbean.DescriptorSupport;
import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.modelmbean.ModelMBeanInfoSupport;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.management.modelmbean.RequiredModelMBean;

public class Main {

	public static void main(String[] args) throws Exception {
		// 获取Mean的平台服务
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		// 对即将被注册的MBean 构造一个ObjectName
		ObjectName objectName = new ObjectName("com.cathy.demo.jmx:type=Hi");
		// 创建一个Mbean
		RequiredModelMBean mbean = new RequiredModelMBean();
		HiMbeanImpl hiMbean = new HiMbeanImpl();
		mbean.setManagedResource(hiMbean, "objectReference");

		ModelMBeanAttributeInfo name = new ModelMBeanAttributeInfo("name", "java.lang.String", "userName", true, true,
				false, new DescriptorSupport(new String[] { "name=name", "descriptorType=attribute",
						"getMethod=getName", "setMethod=setName" }));

		ModelMBeanOperationInfo sayHello = new ModelMBeanOperationInfo("say Hello", hiMbean.getClass().getMethod(
				"sayHello"));
		// 创建一个ModelMBeanOperationInfo
		ModelMBeanOperationInfo getName = new ModelMBeanOperationInfo("get userName", hiMbean.getClass().getMethod(
				"getName"));
		
		ModelMBeanOperationInfo add = new ModelMBeanOperationInfo("add", hiMbean.getClass().getMethod(
				"add",int.class,int.class));

		// 使用ModelMbeanAttributeInfo和ModelMbeanOperationInfo构建一个ModelMBeanInfo对象
		ModelMBeanInfo mbeanInfo = new ModelMBeanInfoSupport("HiMbean", "Test111",
				new ModelMBeanAttributeInfo[] { name }, null, new ModelMBeanOperationInfo[] { sayHello, getName,add }, null);
		// 向ModelMBean 设置ModelMBeanInfo
		mbean.setModelMBeanInfo(mbeanInfo);

		// 将Mbean 注册到MBeanServer
		mbs.registerMBean(mbean, objectName);
		// 一直等待
		System.out.println("Waiting forever...");
		Thread.sleep(Long.MAX_VALUE);

	}
}