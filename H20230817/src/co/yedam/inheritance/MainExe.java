package co.yedam.inheritance;

public class MainExe {
	public static void main(String[] args) {
		CellPhone cell = new CellPhone();
		cell.setModel("SM1100");
		cell.setColor("black");
		cell.turnOn();
		cell.turnOff();
		
		DmbCellPhone dmb = new DmbCellPhone();
		dmb.setModel("DMb1100");
		dmb.setColor("white");
		dmb.turnOn();
		dmb.turnOnBmb();
		dmb.turnOff();
		
		CellPhone cell2 = new DmbCellPhone();	//promotion
		cell2.turnOn();
		//cell.turnOnBmb();	//불가.
		
		if( cell2 instanceof DmbCellPhone ) {
			DmbCellPhone dmb2 = (DmbCellPhone) cell2;	//casting
			dmb2.turnOnBmb();	//자식 클래스에 정의된 기능 사용.
		}
		
		if( cell instanceof DmbCellPhone ) {
			DmbCellPhone dmb3 = (DmbCellPhone) cell;
			dmb3.turnOnBmb();
		}
		
		//
		CellPhone[] phones = new CellPhone[5];
		phones[0] = cell;
		phones[1] = dmb;
		
		phones[0].turnOn();	// CellPhone 인스턴스
		phones[1].turnOn();	// DmbCellPhone 인스턴스
	}
}
