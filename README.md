## Questions
1. What is dispatcher servlet?
   Ans: If you look at the auto-configuration log you can see the DispatcherServletAutoConfiguration. It says DispatcherServletAutoConfiguration matched. Because it founds a DispatcherServlet on the class path.
   Because we have added spring-boot-starter-web. So spring says lets configure a DispatcherServlet. In summary all this configuration
   is getting fired because of something called springbootautoconfiguration. Spring boot looks at all the classes, all the jars which are available on the classpath and based on whatever is in the class path, it tries
   to auto configure different things like dispatcherServlet.
2. Who is configuring dispatcher servlet?
   Ans: Spring boot autoConfiguration.
3. What does dispatcher servlet do?
   Ans: Mapping servlet: 'dispatcherServlet' to [/]
   DispatcherServlet is handling all the requests. this is the root of the application.
   If you type "localhost:8080/helloworld". the request is go to dispatcher servlet. This is following a pattern called front controller. Dispatcher servlet is the frontcontroller for spring web MVC framework.
   DispatcherServlet knows all the different mappings which are present in the application. So it knows helloWorld GET method
   is mapped to this specific method. so once it gets the request it determines which is the right controller to execute the request.
   So it looks at the uri and looks at the request method.