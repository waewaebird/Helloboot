package waewaebirdspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


public class HellobootApplication {
    //매핑, 파라미터 바인딩 = 디스패처서블릿
    public static void main(String[] args) {
        /*********** 1. 스프링 컨테이너! **********/
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                /*********** 2. 서블릿 컨테이너 실행 및 등록 **********/
                ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet", new DispatcherServlet(this))
                            .addMapping("/*");
                });
                webServer.start();
            }
        };

        //스프링 컨테이너는 오브젝트를 처음에 한번만 만든다.
        //스프링 컨테이너를 싱글톤 레지스트리라고도 부른다.(싱글톤 패턴과 유사함.)
        applicationContext.registerBean(HelloController.class); //빈등록
        applicationContext.registerBean(SimpleHelloService.class); //빈등록

        applicationContext.refresh();


    }
}
