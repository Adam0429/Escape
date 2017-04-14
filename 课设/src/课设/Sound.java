package ����;
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
			 sequencer��CD���Ż�(����)-->sequence��Ҫ����ĸ���(��һ��)-->track���и�������Ϣ(����)-->
			 midievent�����ϵ�ĳ�������ţ�Ҳ������������������������ʾ������ô���ţ�һ����midievent��������һ��
			 */
			Sequencer sequencer=MidiSystem.getSequencer();
			sequencer.open();
			Sequence sequence=new Sequence(Sequence.PPQ, 4);
			Track track=sequence.createTrack();
			ShortMessage aMessage=new ShortMessage();//���������ѡ��
			aMessage.setMessage(144,12,54,100);//����(144�򿪣�128�ر�)������������������(��������)
			MidiEvent note=new MidiEvent(aMessage, 0);//1��ʾ��һ�ĵ�ʱ�򲥷�
			track.add(note);
			sequencer.setSequence(sequence);//�����ּӵ��ӵ����ֲ�����
			sequencer.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated constructor stub
	}
	
}
