package bowling.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-bowling
 * create date  : 2019-07-14 23:14
 */
public class BowlingGame {
    private static final String INIT_BOWL_DISPLAY = "";
    private final StringBuilder COMBINE_BOWL_DISPLAY = new StringBuilder(INIT_BOWL_DISPLAY);
    private Frame firstFrame;
    private Frame currentFrame;

    public BowlingGame() {
        this.firstFrame = new NormalFrame();
        this.currentFrame = firstFrame;
    }

    public void play(int downCount) {
        if (currentFrame instanceof FinalFrame && currentFrame.isGameOver()) {
            throw new IllegalStateException("게임 종료");
        }

        if (isNormalFrameOver()) {
            currentFrame = new FinalFrame();
        }
        currentFrame = currentFrame.bowl(downCount);
    }

    public boolean isNormalFrameOver() {
        return currentFrame.isGameOver();
    }

    public String normalFrameScoreToBowl() {
        NormalFrame normalFrame = (NormalFrame) firstFrame;
        return normalFrame.convertAllFrameScoreToBowl(COMBINE_BOWL_DISPLAY);
    }

    public String finalFrameScoreToBowl() {
        FinalFrame finalFrame = (FinalFrame) currentFrame;
        return finalFrame.convertScoreToBowl();
    }
}
