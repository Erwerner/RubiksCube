package erwerner.rubikscube.datatypes;

public class StoneSlot {
	private Stone mStone;
	public StoneSlot() {
		super();
		this.mStone = new Stone();
	}
	public Stone getStone() {
		return mStone;
	}
	public void setStone(Stone pStone) {
mStone = pStone;
	} 

	
}
