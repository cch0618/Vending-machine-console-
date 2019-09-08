import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;										// 날짜 시간 객체를 인쇄 및 구문 분석하기 위한 형식
import java.util.Date;															// 밀리초 단위의 정밀도로 나타내는 선언문.			
import java.util.concurrent.TimeUnit;											// 세분성 단위의 시간, 기간 나타냄.

public class Time {
	private DateTimeFormatter dateTimePattern;									//DateTimeFormatter 추출한 시간정보 개발자가 원하는 형태로 변환.
	private LocalDateTime now;													//LocalDatetime : 시간정보를 추출할 때
	private SimpleDateFormat dateformat;			
	
	public Time(){
		dateTimePattern = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		now = LocalDateTime.now();												//현재시간 LocalDateTime 받아오기.
		dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	}
	
	public String currentDateTime() {	
		return dateTimePattern.format(now);										//.format(날짜데이터) 로서 변환된 값을 "yyyy/MM/dd HH:mm:ss" 형태로 출력하는 메소드 부분
	}
	

	public long diffDateTime(String dateTime1, String dateTime2) {
		try {
			Date d1 = dateformat.parse(dateTime1);								//String 형태를 dateformat 형태로 파싱한 것을 Date 변수에 저장
			Date d2 = dateformat.parse(dateTime2);
			long diff = d2.getTime()-d1.getTime();								//현재시간 - 시작시간을 (1/1000)단위로 표현
			long result = TimeUnit.MILLISECONDS.toSeconds(diff);				//(1/1000)단위로 표현한것을 1초단위로 표현.
			return result;
		} catch (ParseException e) {											//String 형태롤 date형태로 받아오려면 ParseException 오류생겨서 잡음
			e.printStackTrace();
			System.out.println("오류발생");
			return 0;
		}
	} 

}