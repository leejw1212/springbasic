package kr.co.fastcampus.cli;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String args[]) throws SQLException {

		logger.info("hello world");

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

		ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");

		Dao2 dao2 = context.getBean("dao2", Dao2.class);
		//1. spring에서 new dao() 생성자 실행
        // 사용자가 생성자를 정의한 경우 기본 생성자를 생성할 수 없어서 따로 설정해야 함

        //2. dao.xml 에 createDao, factory-method를 추가하여 생성

        //3. 생성자 클래스를 따로 만들고 dao.xml에 2개의 bean을 만들어서 생성
	    dao2.run();

	}
}