public class Plane {
    private int index;
    private int position;
    private int color;

    public Plane(int index, int position, int color) {
        this.index = index;
        this.position = position;
        this.color = color;
    }

    public int getIndex() {
        return index;
    }

    public int getPosition() {
        return position;
    }

    /**
     *
     * @param num
     * @return int value: possible location can move to, otherwise return -1
     */
    public int canMoveTo(int num) {
        int nextPosition;
        // if the plane currently in the base
        if (position < 4) {
            if (num == 6) {
                return position + 4;
            } else {
                return -1;
            }
        }
        //if the plane currently in launch point
        else if (position < 8) {
            //blue is a special case
            if (position == 4) {

                if (num == 1) {
                    nextPosition = 59;
                } else {
                    nextPosition = 7 + num;
                }
            } //This is general case for YGR
            else {
                nextPosition = 6 + 13 * color + num;
            }
        }
        // normal board situation
        else if (position < 60) {
            nextPosition = position + num;
            // check the color, may need to go to landing arrow
            if (color == 0 && nextPosition > 56) {
                int excess = nextPosition - 56;
                nextPosition = 56 + excess * 4;
            }
            else if ((color == 1 && nextPosition > 17) ||
                    (color == 2 && nextPosition > 30) ||
                    (color == 3 && nextPosition > 43)) {
                int excess = nextPosition - ((color - 1) * 13 + 17);
                nextPosition = (color - 1) * 13 + 17 + excess * 4;
            }
            else if (nextPosition > 59) {
                nextPosition = nextPosition % 59 + 7;
            }
        }

    }
}
