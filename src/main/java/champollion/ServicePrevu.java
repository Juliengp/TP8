package champollion;

public class ServicePrevu {
	private int volumeCM;
	private int volumeTD;
	private int volumeTP;
	private final UE ue;

	public ServicePrevu(int volumeCM, int volumeTD, int volumeTP, UE ue){
		this.volumeCM=volumeCM;
		this.volumeTD=volumeTD;
		this.volumeTP=volumeTP;
		this.ue=ue;
	}

	public UE getUe(){
		return ue;
	}

	public int getVolumeCM(){
		return volumeCM;
	}

	public int getVolumeTD(){
		return volumeTD;
	}

	public int getVolumeTP(){
		return volumeTP;
	}

	public int getVolume(TypeIntervention type){
		int result = 0;
		switch (type){
			case CM: result = getVolumeCM(); break;
			case TD: result = getVolumeTD(); break;
			case TP: result = getVolumeTP();break;
		}
		return result;
		}

	public void setVolumeCM(int nvVolume){
		this.volumeCM=nvVolume;
	}

	public void setVolumeTD(int nvVolume){
		this.volumeTD=nvVolume;
	}

	public void setVolumeTP(int nvVolume){
		this.volumeTP=nvVolume;
	}

	}
