package co.yedam.array;

public class ArrayExe1 {
	public static void main(String[] args) {
		
		//배열선언
		int[] intAry = null;
		intAry = new int[10];	// 정수값을 담을 수 있는 공간을 만들어 줌
		intAry = new int[] {12, 25, 67, 23};	//int 배열에는 정수값만 들어갈 수 있음
		
		System.out.println(intAry[0]);
		int[] intAry2 = {55, 47, 90};
		
		intAry[0] = 22;	// 오른쪽과 왼쪽의 데이터 타입이 같아야 함.
		System.out.println(intAry[0]);
		
		intAry = intAry2;
		
		int sum = 0;
		sum += intAry[0];
		sum += intAry[1];
		sum += intAry[2];
		sum += intAry[3];
		
		//for( int i = 0; i <= intAry.length; i++ ) {	// 배열안의 모든 데이터 길이만큼 반복하고자 할때 length를 사용
		for( int i = 0; i <= 4; i++ ) {
			sum += intAry[i];
		}
	}
}
