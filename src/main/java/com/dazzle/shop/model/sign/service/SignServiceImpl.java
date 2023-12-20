package com.dazzle.shop.model.sign.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dazzle.shop.model.sign.domain.SignVO;
import com.dazzle.shop.model.sign.persistence.SignDAO;

@Service
public class SignServiceImpl implements SignService {

	@Autowired
	private SignDAO signDAO;

	// find_id
	@Override
	public SignVO findId(SignVO vo) {
		return signDAO.findId(vo);
	}

	// find_pwd
	@Override
	public SignVO findPwd(SignVO vo) {
		return signDAO.findPwd(vo);
	}

	// sign_in
	@Override
	public SignVO signIn(SignVO vo) {
		return signDAO.signIn(vo);
	}

	// update_pwd
	@Override
	public void updatePwd(SignVO vo) {
		signDAO.updatePwd(vo);
	}

	////////////////////////// sign up에서 사용하는 service
	@Override
	public boolean isIdDupl(String id) {
		return signDAO.checkIdExist(id);
	}

	@Override
	public boolean isEmailDupl(String user_email) {
		return signDAO.checkEmailExist(user_email);
	}

	@Override
	public void signUp(SignVO vo) {
		signDAO.signUp(vo);
	}

	////////////////////////////// DB에 없는 Service

	// send_email
	@Override
	public void sendEmail(String user_email, String authStr) {
		System.out.println("===> SignService sendEmail()");

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");

		// 메일 내용
		String subject = "[Dazzle] 이메일 인증번호입니다.";
		String text = "인증번호는 " + authStr + " 입니다.";

		// 보내는 사람
		String from = "3daysplit@naver.com";
		// 받는 사람
		String to = user_email;

		try {
			// 메일 내용을 넣을 객체와, 이를 도와주는 Helper 객체 생성
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "utf-8");

			// 메일 내용 채우기
			mailHelper.setFrom(from); // 보내는 사람
			mailHelper.setTo(to); // 받는 사람
			mailHelper.setSubject(subject); // 제목
			mailHelper.setText(text); // 내용

			// 메일 전송
			mailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.close();
		}
	}

}
