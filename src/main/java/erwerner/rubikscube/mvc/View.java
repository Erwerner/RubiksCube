package erwerner.rubikscube.mvc;

public abstract class View implements iObserver {

	protected Model mModel;

	public View(Model pModel) {
		mModel = pModel;
		pModel.registerView(this);
	}

}
