import java.io.File;

interface GrobStruktur{
	//Layout
	/**
	 * Zeigt Seite: StartScreen an
	 * @param b
	 */
	public void showStartScreen(boolean b);
	public void showExerciseLayout(boolean b);
	public void showHighscoreLayout(boolean b);
	public void showErrungsenschaftenlayot(boolean b);
	//Hilfmethoden
	public void loadTxtFile(String path);
	//Methoden
	public void loadProfile(File inputFile);
	public void saveProfile(File inputFile);
	//Spiel Logik
	public void spielAblauf();
	public void startGame();
	public void stopGame();
	public void gameEvent_nextExercise();
	public void gameEvent_nextQuestion();
	public void gameEvent_ShowHighscore();
	public void gameEvent_quit();
	
}
