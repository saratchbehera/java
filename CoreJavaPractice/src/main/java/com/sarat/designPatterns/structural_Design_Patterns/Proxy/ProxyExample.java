package com.sarat.designPatterns.structural_Design_Patterns.Proxy;

import java.lang.reflect.Proxy;

/**
 * <b>Proxy Design Pattern</b>
 * <p>Proxy design pattern is used when we want to provide controlled access of a functionality.</p>
 * 
 * <p>From JDK 1.3 java has direct support for implementing proxy design pattern. 
 * We need not worry on maintaining the reference and object creation. 
 * Java provides us the needed utilities</p>
 * 
 * 			  Client -  Proxy -	Real Subject
 * 
 * <p><b>Scenarios</b></p>
 * <p><ul>
 * <li><b>Remote Proxy</b></li>
 * <p>Represents an object locally which belongs to a different address space. Think of an ATM implementation, 
 * it will hold proxy objects for bank information that exists in the remote server. 
 * RMI is an example of proxy implmenetation for this type in java.</p>
 * 
 * <li><b>Virtual Proxy</b></li> 
 * <p>In place of a complex or heavy object use a skeleton representation. When an underlying image is huge in size, 
 * just represent it using a virtual proxy object and on demand load the real object. 
 * You feel that the real object is expensive in terms of instantiation and so without the real need we are not going to use the real object. 
 * Until the need arises we will use the virtual proxy.</p>
 * 
 * <li><b>Protection Proxy</b></li> 
 * <p>Are you working on a MNC? If so, you might be well aware of the proxy server that provides you internet. 
 * Saying more than provides, the right word is censores internet. 
 * The management feels its better to censor some content and provide only work related web pages. 
 * Proxy server does that job. This is a type of proxy design pattern. 
 * Lighter part of censor is, we search for something critical in Google and click the result and you get this page is blocked by proxy server. 
 * You never know why this page is blocked and you feel this is genuine. How do you overcome that, over a period you learn to live with it.</p>
 * 
 * <li><b>Smart Reference</b></li>
 * <p>Just we keep a link/reference to the real object a kind of pointer.</p>
 * </ul>
 * 
 * <p><b>Important Points</b></p>
 * 
 * <ul>
 * <li>A proxy may hide information about the real object to the client.</li>
 * <li>A proxy may perform optimization like on demand loading.</li>
 * <li>A proxy may do additional house-keeping job like audit tasks.</li>
 * <li>Proxy design pattern is also known as surrogate design pattern.</li>
 * </ul>
 * 
 * 
 * <b>Proxy Design Pattern Usage in Java API</b>
 * <p>java.rmi.* � RMI package is based on proxy design pattern<p>
 * 
 * @author Sarat Behera
 *
 */
public class ProxyExample {

	public static void main(String[] args) {
		Animal realSubject = new Lion();
		
		Animal proxy = (Animal) Proxy.newProxyInstance(realSubject.getClass()
				.getClassLoader(), realSubject.getClass().getInterfaces(),
				new AnimalInvocationHandler(realSubject));
		proxy.getSound();
		realSubject.getSound();
	}
}
