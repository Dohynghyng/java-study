
class TimeWrong{
	int hour;
	int minute;
	int second;
}

class Time{
	private int hour;
	private int minute;
	private int second;
	
	public void setHour(int hour) {
		if (hour < 0 || hour > 23) return;
		this.hour = hour;
	}
	public int getHour() {return hour;}
}

public class TimeClass {

	public static void main(String[] args) {
		TimeWrong t = new TimeWrong();
		t.hour = -100; // 직접 접근으로 인한 데이터 변질
		
		Time t2 = new Time();
		t2.setHour(21);  // 간접 접근으로 데이터 변질 보호
		t2.setHour(-100);  // 간접 접근으로 데이터 변질 보호
		System.out.println(t2.getHour());
	}
}


