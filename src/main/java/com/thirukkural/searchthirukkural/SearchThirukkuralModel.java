package com.thirukkural.searchthirukkural;

import com.thirukkural.dto.Kural;
import com.thirukkural.repository.Repository;

public class SearchThirukkuralModel implements SearchThirukkuralModelCallBack {
	private SearchThirukkuralModelControllerCallBack searchThirukkuralController;
	private Repository repositoryInstance = Repository.getInstance();
	public SearchThirukkuralModel(SearchThirukkuralController searchThirukkuralController) {
		this.searchThirukkuralController = searchThirukkuralController;
	}
	@Override
	public void getThirukkuralJSon(int kuralEnn) {
		Kural kural = repositoryInstance.getThirukural(kuralEnn);
		searchThirukkuralController.showKural(kural);
	}

}
