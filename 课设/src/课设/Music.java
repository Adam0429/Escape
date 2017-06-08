package 课设;

import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Music implements Runnable {
	private String url = "music/";
	private int type = 0;

	public Music(int type) {
		this.type = type;
		switch (type) {
		case 0: 
			url = url + "2.wav";
			break;
		case 1: 
			url = url + "1.wav";
			break;
//		case 2: 
//			url = url + "levelup.wav";
//			break;
//		case 3: 
//			url = url + "over.wav";
//			break;
		}
		new Thread(this).start();
	}

	@Override
	public void run() {
		AudioStream ais = null;
		InputStream is = null;
		try {
			if (type == 0) { // 背景音乐循环
				while (true) {
					is = ClassLoader.getSystemResourceAsStream(url);
					ais = new AudioStream(is);
					AudioPlayer.player.start(ais);
					Thread.sleep(106000);
				}
			} else { // 音效只播放一次
				is = ClassLoader.getSystemResourceAsStream(url);
				ais = new AudioStream(is);
				AudioPlayer.player.start(ais);
				Thread.sleep(95000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) { // 关闭输入流
					is.close();
				}
				if (ais != null) { // 关闭音频流
					ais.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}