package 课设;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class Sound {
	public static void main(String[] Args){
		Sound sound=new Sound();
	}
	public Sound() {
		try {
			/*
			 sequencer是CD播放机(播放)-->sequence是要演奏的歌曲(有一个)-->track带有歌曲的信息(载有)-->
			 midievent乐谱上的某个音符号，也可以用来更换乐器，用来表示音乐怎么播放，一连串midievent就像乐谱一样
			 */
			Sequencer sequencer=MidiSystem.getSequencer();
			sequencer.open();
			Sequence sequence=new Sequence(Sequence.PPQ, 4);
			Track track=sequence.createTrack();
			ShortMessage aMessage=new ShortMessage();//声音种类的选择
			aMessage.setMessage(144,12,54,100);//类型(144打开，128关闭)，乐器，音符，音道(声音大熊)
			MidiEvent note=new MidiEvent(aMessage, 0);//1表示第一拍的时候播放
			track.add(note);
			sequencer.setSequence(sequence);//将音乐加到加到音乐播放器
			sequencer.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated constructor stub
	}
	
}
