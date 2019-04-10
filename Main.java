package sisaku_Teian;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main{
	public static void main(String args[]) throws IOException{

		double simTime = 1;//シミュレーション間隔 0.1
		double endTime = 500;//シミュレーション時間(招集しないなら406秒
		double lapseTime = 1;//経過時間

		int peaple = 10;

		int serchArea1 = 7;//要救助者のいる領域名1
		int serchArea2 = 8;//要救助者のいる領域名2
		int serchArea3 = 9;//要救助者のいる領域名3

		int serchCase = 1;//ケース

		int falsePeaple = peaple * 2;

		//long sleepTime = (long) (simTime * 1000);

		Area position = new Area(peaple, serchArea1, serchArea2, serchArea3, serchCase);


		int[][] area = new int[9][2];//エリア生成
		int x = 0, y = 0;
		for(int i = 0; i < 9; i++) {
			if(i == 0) {
				x = 15;
				y = 225;

			}
			if(i == 3 || i == 6) {
				x = 15;
				y += 240;

			}
			area[i][0] = x;
			area[i][1] = y;
			x += 240;

		}


		Drone[] drone = new Drone[9];//ドローン9台生成

		for(int i = 0; i < 9; i++) {//ドローンに値を割り当て
			drone[i] = new Drone(i + 50001, area[i][0], area[i][1]);
		}

		EdgeServer edgeServer = new EdgeServer();//インスタンス生成

		while(lapseTime < endTime) {

			for(int i = 0; i < 9; i++) {
				drone[i].move(simTime);
				drone[i].dataGet(position.field);
				drone[i].gDataGet(position.divisionField);

				System.out.println("ドローン"+(i+1)+":状態"+ drone[i].state+" x:"+ drone[i].x+"  y:"+drone[i].y+
						" 方向:"+drone[i].direction + " "+ "バッテリー：" + drone[i].battery );

				falsePeaple -= drone[i].gDiscover;

				edgeServer.receiveData(area[i][0], area[i][1], simTime);

				/*if(drone[i].time.equals("sensingstart")) {
					String str =  String.valueOf(lapseTime) + " " + String.valueOf(drone[i].id);
					try {//ファイルへの書き込み
						FileWriter fw = new FileWriter("/Users/TKLab/Desktop/sennsingStartTime.txt",true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(str);
						bw.newLine();//改行
						bw.flush();
						bw.close();//ファイル閉鎖
					}catch(IOException e) {
						System.out.println("エラー");
					}

				}

				if(drone[i].time.equals("sensingEnd")) {
					String str =  String.valueOf(lapseTime) + " " + String.valueOf(drone[i].id);
					try {//ファイルへの書き込み
						FileWriter fw = new FileWriter("/Users/TKLab/Desktop/sennsingEndTime.txt",true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(str);
						bw.newLine();//改行
						bw.flush();
						bw.close();//ファイル閉鎖
					}catch(IOException e) {
						System.out.println("エラー");
					}

				}

				if(drone[i].time.equals("missionEnd")) {
					String str =  String.valueOf(lapseTime) + " " + String.valueOf(drone[i].id);
					try {//ファイルへの書き込み
						FileWriter fw = new FileWriter("/Users/TKLab/Desktop/missionEndTime.txt",true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(str);
						bw.newLine();//改行
						bw.flush();
						bw.close();//ファイル閉鎖
					}catch(IOException e) {
						System.out.println("エラー");
					}

				}*/

				if(drone[i].message.equals("end")) {
					String str =  String.valueOf(lapseTime) + " " + String.valueOf(drone[i].id);
					try {//ファイルへの書き込み
						FileWriter fw = new FileWriter("/Users/e1558219/Desktop/conventionSennsingEndTime.txt",true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(str);
						bw.newLine();//改行
						bw.flush();
						bw.close();//ファイル閉鎖
					}catch(IOException e) {
						System.out.println("エラー");
					}

				}
				System.out.println("");
			}

			//System.out.println(falsePeaple);
			if(falsePeaple == 0) {
				String str =  String.valueOf(lapseTime) + " ";
				falsePeaple = 10000;
				try {//ファイルへの書き込み
					FileWriter fw = new FileWriter("/Users/e1558219/Desktop/detectionPeapleTime.txt",true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(str);
					bw.newLine();//改行
					bw.flush();
					bw.close();//ファイル閉鎖
				}catch(IOException e) {
					System.out.println("エラー");
				}
			}

			lapseTime += simTime;
			System.out.println("経過時間："+lapseTime);

			if(lapseTime == endTime) {
				String str =  "　　";
				/*try {//ファイルへの書き込み
					FileWriter fw = new FileWriter("/Users/TKLab/Desktop/sennsingStartTime.txt",true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(str);
					bw.newLine();//改行
					bw.flush();
					bw.close();//ファイル閉鎖
				}catch(IOException e) {
					System.out.println("エラー");
				}
				try {//ファイルへの書き込み
					FileWriter fw = new FileWriter("/Users/TKLab/Desktop/sennsingEndTime.txt",true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(str);
					bw.newLine();//改行
					bw.flush();
					bw.close();//ファイル閉鎖
				}catch(IOException e) {
					System.out.println("エラー");
				}*/
				try {//ファイルへの書き込み
					FileWriter fw = new FileWriter("/Users/e1558219/Desktop/conventionSennsingEndTime.txt",true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(str);
					bw.newLine();//改行
					bw.flush();
					bw.close();//ファイル閉鎖
				}catch(IOException e) {
					System.out.println("エラー");
				}
				System.exit(0);
			}

			/*try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}*/
		}


	}
}