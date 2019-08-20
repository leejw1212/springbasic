package kr.co.fastcampus.cli;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String args[]) {

		logger.info("hello world");

		ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");

		Dao dao = context.getBean("dao", Dao.class);
		//1. spring에서 new dao() 생성자 실행
        // 사용자가 생성자를 정의한 경우 기본 생성자를 생성할 수 없어서 따로 설정해야 함

        //2. dao.xml 에 createDao, factory-method를 추가하여 생성

        //3. 생성자 클래스를 따로 만들고 dao.xml에 2개의 bean을 만들어서 생성
		dao.run();

	}
}