/**
 * Created by Алена on 09.06.2017.
 */
public enum Card {

    ZERO_RED(1), ONE_RED(2), TWO_RED(2), THREE_RED(2), FOUR_RED(2), FIVE_RED(2),
    SIX_RED(2), SEVEN_RED(2), EIGHT_RED(2), NINE_RED(2),

    ZERO_GREEN(1), ONE_GREEN(2), TWO_GREEN(2), THREE_GREEN(2), FOUR_GREEN(2), FIVE_GREEN(2),
    SIX_GREEN(2), SEVEN_GREEN(2), EIGHT_GREEN(2), NINE_GREEN(2),

    ZERO_YELLOW(1), ONE_YELLOW(2), TWO_YELLOW(2), THREE_YELLOW(2), FOUR_YELLOW(2), FIVE_YELLOW(2),
    SIX_YELLOW(2), SEVEN_YELLOW(2), EIGHT_YELLOW(2), NINE_YELLOW(2),

    ZERO_BLUE(1), ONE_BLUE(2), TWO_BLUE(2), THREE_BLUE(2), FOUR_BLUE(2), FIVE_BLUE(2),
    SIX_BLUE(2), SEVEN_BLUE(2), EIGHT_BLUE(2), NINE_BLUE(2),

    SKIP_RED(2), SKIP_GREEN(2), SKIP_YELLOW(2), SKIP_BLUE(2),
    PICK_UP_TWO_RED(2), PICK_UP_TWO_GREEN(2), PICK_UP_TWO_YELLOW(2), PICK_UP_TWO_BLUE(2),
    REVERSE_RED(2), REVERSE_GREEN(2), REVERSE_YELLOW(2), REVERSE_BLUE(2),

    CHOOSE_COLOR(4), PICK_UP_FOUR(4);

    private int count;

    Card (int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
