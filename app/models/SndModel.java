package models;

import play.Logger;


public class SndModel {
	static class studies{
		private String hits;
		public studies(){
			
		}
		public String getHits() {
			return hits;
		}
		public void setHits(String hits) {
			Logger.debug("hiits:"+hits);
			this.hits = hits;
		}
		
		
	}

	private String time;
	private String studyUnit;
	private studies myStudies;
	//"StudyUnit":{"url":"http://snd.gu.se/catalogue/study/SND2300",

	public studies getMyStudies() {
		return myStudies;
	}

	public void setMyStudies(studies myStudies) {
		this.myStudies = myStudies;
	}

	public String getStudyUnit() {
		return studyUnit;
	}

	public void setStudyUnit(String studyUnit) {
		this.studyUnit = studyUnit;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	

}
