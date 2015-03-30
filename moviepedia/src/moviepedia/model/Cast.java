package moviepedia.model;

public class Cast {
	int actorID;
	int movieID;
	int castID;
	String characterName;
	public Cast() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cast(int castID,int actorID, int movieID, String characterName) {
		super();
		this.castID=castID;
		this.actorID = actorID;
		this.movieID = movieID;
		this.characterName = characterName;
	}
	public int getCastID() {
		return castID;
	}
	public void setCastID(int castID) {
		this.castID = castID;
	}
	public int getActorID() {
		return actorID;
	}
	public void setActorID(int actorID) {
		this.actorID = actorID;
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

}
