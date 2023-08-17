package co.yedam.inheritance;

public class DmbCellPhone extends CellPhone {
	private int channel;
	
	public void changeChannel(int channel) {
		this.channel = channel;
	}
	
	public void turnOnBmb() {
		System.out.println("DMB 폰을 켭니다.");
	}
	
	//제정의(overriding)
	@Override
	public void turnOn() {
		//super.turnOn();	// super 부모를 가리킴
		System.out.println(getModel() + "의 전원을 켭니다.");
	}
}
