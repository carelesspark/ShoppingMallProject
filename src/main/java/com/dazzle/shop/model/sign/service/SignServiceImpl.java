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

	/*
	 * 로그인
	 */
	@Override
	public SignVO login(SignVO vo) {
		return signDAO.login(vo);
	}
	
	/*
	 * 관리자 로그인
	 */
	@Override
	public SignVO loginAdmin(SignVO vo) {
		return signDAO.loginAdmin(vo);
	}

	/*
	 * 아이디 찾기
	 */
	@Override
	public SignVO findId(SignVO vo) {
		return signDAO.findId(vo);
	}

	/*
	 * 비밀번호 재설정 - 첫번째 단계
	 */
	@Override
	public SignVO findPwd(SignVO vo) {
		return signDAO.findPwd(vo);
	}

	/*
	 * 비밀번호 재설정 - 두번째 단계
	 */
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

	/*
	 * 비밀번호 재설정 - 세번째 단계
	 */
	@Override
	public void updatePwd(SignVO vo) {
		signDAO.updatePwd(vo);
	}

	/*
	 * 회원가입 - 아이디 중복 확인(비동기)
	 */
	@Override
	public boolean isIdDupl(String id) {
		return signDAO.checkIdExist(id);
	}

	/*
	 * 회원가입 - 이메일 중복 확인(비동기)
	 */
	@Override
	public boolean isEmailDupl(String user_email) {
		return signDAO.checkEmailExist(user_email);
	}

	/*
	 * 회원가입
	 */
	@Override
	public void register(SignVO vo) {
		signDAO.register(vo);
	}
}
