import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;										// ��¥ �ð� ��ü�� �μ� �� ���� �м��ϱ� ���� ����
import java.util.Date;															// �и��� ������ ���е��� ��Ÿ���� ����.			
import java.util.concurrent.TimeUnit;											// ���м� ������ �ð�, �Ⱓ ��Ÿ��.

public class Time {
	private DateTimeFormatter dateTimePattern;									//DateTimeFormatter ������ �ð����� �����ڰ� ���ϴ� ���·� ��ȯ.
	private LocalDateTime now;													//LocalDatetime : �ð������� ������ ��
	private SimpleDateFormat dateformat;			
	
	public Time(){
		dateTimePattern = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		now = LocalDateTime.now();												//����ð� LocalDateTime �޾ƿ���.
		dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	}
	
	public String currentDateTime() {	
		return dateTimePattern.format(now);										//.format(��¥������) �μ� ��ȯ�� ���� "yyyy/MM/dd HH:mm:ss" ���·� ����ϴ� �޼ҵ� �κ�
	}
	

	public long diffDateTime(String dateTime1, String dateTime2) {
		try {
			Date d1 = dateformat.parse(dateTime1);								//String ���¸� dateformat ���·� �Ľ��� ���� Date ������ ����
			Date d2 = dateformat.parse(dateTime2);
			long diff = d2.getTime()-d1.getTime();								//����ð� - ���۽ð��� (1/1000)������ ǥ��
			long result = TimeUnit.MILLISECONDS.toSeconds(diff);				//(1/1000)������ ǥ���Ѱ��� 1�ʴ����� ǥ��.
			return result;
		} catch (ParseException e) {											//String ���·� date���·� �޾ƿ����� ParseException �������ܼ� ����
			e.printStackTrace();
			System.out.println("�����߻�");
			return 0;
		}
	} 

}